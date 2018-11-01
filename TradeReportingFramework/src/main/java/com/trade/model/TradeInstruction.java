/**
 * 
 */
package com.trade.model;

import java.math.BigDecimal;
import java.util.Date;

import com.trade.utils.InstructionEnum;

/**
 * @author Megha
 *
 */
public class TradeInstruction {

	private String entity;
	private InstructionEnum instruction;
	private String currency;
	private Date instructionDate;
	private Date settlementDate;
	private Date actualSettlementDate;
	private String actualSettlementDateStr;
	private int units;
	private BigDecimal pricePerUnit;
	private BigDecimal totalAmount;
	
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}
	/**
	 * @return the instruction
	 */
	public InstructionEnum getInstruction() {
		return instruction;
	}
	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(InstructionEnum instruction) {
		this.instruction = instruction;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the instructionDate
	 */
	public Date getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	/**
	 * @return the settlementDate
	 */
	public Date getSettlementDate() {
		return settlementDate;
	}
	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	/**
	 * @return the actualSettlementDate
	 */
	public Date getActualSettlementDate() {
		return actualSettlementDate;
	}
	/**
	 * @param actualSettlementDate the actualSettlementDate to set
	 */
	public void setActualSettlementDate(Date actualSettlementDate) {
		this.actualSettlementDate = actualSettlementDate;
	}
	/**
	 * @return the actualSettlementDateStr
	 */
	public String getActualSettlementDateStr() {
		return actualSettlementDateStr;
	}
	/**
	 * @param actualSettlementDateStr the actualSettlementDateStr to set
	 */
	public void setActualSettlementDateStr(String actualSettlementDateStr) {
		this.actualSettlementDateStr = actualSettlementDateStr;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	/**
	 * @return the pricePerUnit
	 */
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	/**
	 * @return the totalAmount
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
