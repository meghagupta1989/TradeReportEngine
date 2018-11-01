/**
 * 
 */
package com.trade.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.trade.utils.InstructionEnum;

/**
 * @author Megha
 *
 */
public class TradeMock {

	public static List<TradeInstruction> getMockData() {
		List<TradeInstruction> tradeInsList = new ArrayList<TradeInstruction>();
		
		TradeInstruction tradeInstruction;
		
		//BUY
		//1st record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("foo");
		tradeInstruction.setInstruction(InstructionEnum.BUY);
		tradeInstruction.setCurrency("SAR");
		tradeInstruction.setUnits(100);
		tradeInstruction.setPricePerUnit(new BigDecimal(100.25));
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		Date instructionDate;
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date settlementDate;
		try {
			settlementDate = sdf.parse("29-09-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//2nd record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("foo");
		tradeInstruction.setInstruction(InstructionEnum.BUY);
		tradeInstruction.setCurrency("SEK");
		tradeInstruction.setUnits(50);
		tradeInstruction.setPricePerUnit(new BigDecimal(100.25));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("30-09-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//3rd record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("foo");
		tradeInstruction.setInstruction(InstructionEnum.BUY);
		tradeInstruction.setCurrency("CAD");
		tradeInstruction.setUnits(75);
		tradeInstruction.setPricePerUnit(new BigDecimal(100.25));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("30-09-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//4th record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("bar");
		tradeInstruction.setInstruction(InstructionEnum.BUY);
		tradeInstruction.setCurrency("AED");
		tradeInstruction.setUnits(200);
		tradeInstruction.setPricePerUnit(new BigDecimal(150.5));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("01-10-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//5th record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("bar");
		tradeInstruction.setInstruction(InstructionEnum.BUY);
		tradeInstruction.setCurrency("AED");
		tradeInstruction.setUnits(200);
		tradeInstruction.setPricePerUnit(new BigDecimal(150.5));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("06-10-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//SELL
		//1st record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("foo");
		tradeInstruction.setInstruction(InstructionEnum.SELL);
		tradeInstruction.setCurrency("SAR");
		tradeInstruction.setUnits(25);
		tradeInstruction.setPricePerUnit(new BigDecimal(100.25));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("29-09-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//2nd record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("foo");
		tradeInstruction.setInstruction(InstructionEnum.SELL);
		tradeInstruction.setCurrency("SEK");
		tradeInstruction.setUnits(25);
		tradeInstruction.setPricePerUnit(new BigDecimal(100.25));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("30-09-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//3rd record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("foo");
		tradeInstruction.setInstruction(InstructionEnum.SELL);
		tradeInstruction.setCurrency("CAD");
		tradeInstruction.setUnits(50);
		tradeInstruction.setPricePerUnit(new BigDecimal(100.25));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("30-09-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//4th record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("bar");
		tradeInstruction.setInstruction(InstructionEnum.SELL);
		tradeInstruction.setCurrency("AED");
		tradeInstruction.setUnits(50);
		tradeInstruction.setPricePerUnit(new BigDecimal(150.5));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("01-10-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		//5th record
		tradeInstruction = new TradeInstruction();
		tradeInstruction.setEntity("bar");
		tradeInstruction.setInstruction(InstructionEnum.SELL);
		tradeInstruction.setCurrency("AED");
		tradeInstruction.setUnits(75);
		tradeInstruction.setPricePerUnit(new BigDecimal(150.5));
		try {
			instructionDate = sdf1.parse("28-09-2018");
			tradeInstruction.setInstructionDate(instructionDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			settlementDate = sdf.parse("06-10-2018");
			tradeInstruction.setSettlementDate(settlementDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tradeInsList.add(tradeInstruction);
		
		return tradeInsList;
	}
	
}
