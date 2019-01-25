package com.project.zopa.model;

import java.math.BigDecimal;

public class Lender {
	
	private String lenderName;
	private BigDecimal interestRate;
	private int availableAmount;
	
	/**
	 * Constructor
	 * @param lenderNameIn
	 * @param interestRateIn
	 * @param avaiableAmountIn
	 */
	public Lender (final String lenderNameIn, final BigDecimal interestRateIn, final int avaiableAmountIn) {
		this.lenderName = lenderNameIn;
		this.interestRate = interestRateIn;
		this.availableAmount = avaiableAmountIn;
	}
	
	/**
	 * @return the lenderName
	 */
	public String getLenderName() {
		return lenderName;
	}
	
	/**
	 * @param lenderName the lenderName to set
	 */
	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}
	
	/**
	 * @return the interestRate
	 */
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	
	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * @return the availableAmount
	 */
	public int getAvailableAmount() {
		return availableAmount;
	}
	
	/**
	 * @param availableAmount the availableAmount to set
	 */
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
}
