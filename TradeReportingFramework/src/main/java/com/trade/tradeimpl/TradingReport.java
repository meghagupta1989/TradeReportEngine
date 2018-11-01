/**
 * 
 */
package com.trade.tradeimpl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.trade.model.TradeInstruction;
import com.trade.utils.CurrencyFxEnum;
import com.trade.utils.InstructionEnum;
import com.trade.utils.Utils;

/**
 * @author Megha
 *
 */
public class TradingReport {
	
	private static Map<String, Map<InstructionEnum, BigDecimal>> tradeReportMap = new HashMap<String, Map<InstructionEnum,BigDecimal>>();
	private static Map<String, BigDecimal> tradeSort = new HashMap<String, BigDecimal>();
	
	//Exception Currency list - with work week from sunday to thursday
	public static List<String> currencyList = Arrays.asList("AED", "SAR");
	
	public TradingReport() {
		
	}
	
	/**
	 * This method sorts the map based on value
	 * @return
	 */
	private Map<String, BigDecimal> sortMap() {
		List<Map.Entry<String, BigDecimal>> list = new ArrayList<Map.Entry<String, BigDecimal>>(
				tradeSort.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, BigDecimal>>() {
			public int compare(Map.Entry<String, BigDecimal> e1,
					Map.Entry<String, BigDecimal> e2) {
				return e1.getValue().compareTo(e2.getValue()) * -1;
			}
		});
		Map<String, BigDecimal> sortedByValues = new LinkedHashMap<String, BigDecimal>();
		for (Map.Entry<String, BigDecimal> entry : list) {
			sortedByValues.put(entry.getKey(), entry.getValue());
		}
		
		return sortedByValues;
	}
	
	/**
	 * This method is used to report amount incoming and outgoing everyday
	 * @param list
	 */
	public void reportAmountPerDay(List<TradeInstruction> list) {
		
		for(TradeInstruction tradeIns : list) {
			trade(tradeIns);
		}
		
		System.out.println("Trade Report");
		//output on console
		for(Map.Entry<String, Map<InstructionEnum, BigDecimal>> tradeMap : tradeReportMap.entrySet()) {
			System.out.println("Trade report for date - " + tradeMap.getKey());
			
			Map<InstructionEnum, BigDecimal> value = tradeMap.getValue();
			
			for(Map.Entry<InstructionEnum, BigDecimal> entry: value.entrySet()) {
				if(InstructionEnum.BUY == entry.getKey()) {
					System.out.println("Incoming Settlement Amount " + Utils.getFormattedBigDecimalValue(entry.getValue()) + " USD");
				} else {
					System.out.println("Outgoing Settlement Amount " + Utils.getFormattedBigDecimalValue(entry.getValue()) + " USD");
				}
			}
		}
	}
	
	/**
	 * This method Sort the entities based on amount per entity
	 * @param list
	 */
	public void reportEntities(List<TradeInstruction> list) {
		
		for(TradeInstruction tradeIns : list) {
			trade(tradeIns);
		}
		
		Map<String, BigDecimal> sortMap = sortMap();
		System.out.println("Ranking of entities based on Amount");
		//output on console
		for(Map.Entry<String, BigDecimal> entry: sortMap.entrySet()) {
			//List of entities based on their amount
			System.out.println("Entity : " + entry.getKey());
			System.out.println("Amount : " + Utils.getFormattedBigDecimalValue(entry.getValue()) + " USD");
		}
	}
	
	/**
	 * trade method is an actual implementation of realtime trade. It should be called 
	 * whenever a new trade request comes in.
	 * This method performs below functions:
	 * 1. Calculate Actual settlement date
	 * 2. Calculate total amount of the trade
	 * 3. Add this trade to the list of daily trade reports
	 * 
	 * @param tradeIns
	 */
	public void trade(TradeInstruction tradeIns) {
		
		//calculate settlement Date
		Date  actualSettlementDate;
		actualSettlementDate = getActualSettlementDate(tradeIns);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String actualSettlementDateStr = df.format(actualSettlementDate); 
		
		tradeIns.setActualSettlementDate(actualSettlementDate);
		tradeIns.setActualSettlementDateStr(actualSettlementDateStr);
		
		//Calculate Amount
		calculateAmount(tradeIns);
		
		if(tradeReportMap.containsKey(tradeIns.getActualSettlementDateStr())) {
			Map<InstructionEnum, BigDecimal> settlement = tradeReportMap.get(tradeIns.getActualSettlementDateStr());
			if(settlement.containsKey(tradeIns.getInstruction())) {
				BigDecimal amount = settlement.get(tradeIns.getInstruction());
				amount = amount.add(tradeIns.getTotalAmount());
				settlement.put(tradeIns.getInstruction(), amount);
				tradeReportMap.put(tradeIns.getActualSettlementDateStr(), settlement);
			} else {
				//Map<InstructionEnum, BigDecimal> settlement1 = new HashMap<InstructionEnum, BigDecimal>();
				settlement.put(tradeIns.getInstruction(), tradeIns.getTotalAmount());
				tradeReportMap.put(tradeIns.getActualSettlementDateStr(), settlement);
			}
		} else {
			Map<InstructionEnum, BigDecimal> settlement = new HashMap<InstructionEnum, BigDecimal>();
			settlement.put(tradeIns.getInstruction(), tradeIns.getTotalAmount());
			tradeReportMap.put(tradeIns.getActualSettlementDateStr(), settlement);
		}
		
		//Adding to map according to entity
		if(tradeSort.containsKey(tradeIns.getEntity())) {
			BigDecimal amount = tradeSort.get(tradeIns.getEntity());
			tradeSort.put(tradeIns.getEntity(), addAmount(amount, tradeIns.getTotalAmount(), tradeIns.getInstruction()));
		} else {
			tradeSort.put(tradeIns.getEntity(), addAmount(new BigDecimal(0), tradeIns.getTotalAmount(), tradeIns.getInstruction()));
		}
	}


	private BigDecimal addAmount(BigDecimal mainAmount, BigDecimal amount, InstructionEnum ins) {
		BigDecimal calc = mainAmount;
		
		if(InstructionEnum.BUY == ins) {
			calc = mainAmount.add(amount);
		} else {
			calc = mainAmount.subtract(amount);
		}
		
		return calc;
		
	}
	
	private Date getActualSettlementDate(TradeInstruction tradeIns) {
		
		String currency = tradeIns.getCurrency(); 
		Date actualSettlementDate;
		int dayOfWeek = Utils.getDayOfWeek(tradeIns.getSettlementDate());
		if(currencyList.contains(currency)) {
			if(dayOfWeek > 5) {
				actualSettlementDate = Utils.getNextWorkingDay(tradeIns.getSettlementDate(), 8 - dayOfWeek);
			} else {
				actualSettlementDate = tradeIns.getSettlementDate();
			}
		} else {
			if(dayOfWeek == 1) {
				actualSettlementDate = Utils.getNextWorkingDay(tradeIns.getSettlementDate(), 1);
			} else if(dayOfWeek == 7) {
				actualSettlementDate = Utils.getNextWorkingDay(tradeIns.getSettlementDate(), 2);
			} else {
				actualSettlementDate = tradeIns.getSettlementDate();
			}
		}
		return actualSettlementDate;
	}
	
	private void calculateAmount(TradeInstruction tradeIns) {
		BigDecimal fxRate = CurrencyFxEnum.getExchangeValue(tradeIns.getCurrency());
		BigDecimal result = (fxRate.multiply(tradeIns.getPricePerUnit())).multiply(new BigDecimal(tradeIns.getUnits()));
		
		tradeIns.setTotalAmount(result);
	}
	
}
