/**
 * 
 */
package com.trade.utils;

import java.math.BigDecimal;

/**
 * @author ex22714
 *
 */
public enum CurrencyFxEnum {

	USD("USD" , new BigDecimal(1)) ,
	AED ("AED" , new BigDecimal(0.27)),
	SAR ("SAR" , new BigDecimal(0.26)),
	SEK ("SEK" , new BigDecimal(0.11)),
	EUR ("EUR" , new BigDecimal(1.15)),
	AUD ("AUD" , new BigDecimal(0.72)),
	CAD ("CAD" , new BigDecimal(0.76)),
	HKD ("HKD" , new BigDecimal(0.12)),
	GBP ("GBP" , new BigDecimal(1.30));
	
	 private String id;
	 private BigDecimal agreedFx;
	 
	 private CurrencyFxEnum(String id, BigDecimal agreedFx) {
		this.id = id;
		this.agreedFx = agreedFx;
	}
	 
	public static BigDecimal getExchangeValue(String currency) {
		BigDecimal exchangeValue = new BigDecimal(1);
		
		for(CurrencyFxEnum currencyEnum: CurrencyFxEnum.values()) {
			if(currency.equalsIgnoreCase(currencyEnum.getId())) {
				return currencyEnum.getAgreedFx();
			}
		}

		return exchangeValue;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	/**
	 * @param agreedFx the agreedFx to set
	 */
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}
}
