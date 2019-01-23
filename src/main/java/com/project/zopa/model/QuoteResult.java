package com.project.zopa.model;

import java.math.BigDecimal;

public class QuoteResult {
	
	private int requestedAmount;
	private BigDecimal percentageRate;
	private BigDecimal monthlyRepayment;
	private BigDecimal totalRepayment;
	
	/**
	 * @return the requestedAmount
	 */
	public int getRequestedAmount() {
		return requestedAmount;
	}
	
	/**
	 * @param requestedAmount the requestedAmount to set
	 */
	public void setRequestedAmount(int requestedAmount) {
		this.requestedAmount = requestedAmount;
	}
	
	/**
	 * @return the percentageRate
	 */
	public BigDecimal getPercentageRate() {
		return percentageRate;
	}
	
	/**
	 * @param percentageRate the percentageRate to set
	 */
	public void setPercentageRate(BigDecimal percentageRate) {
		this.percentageRate = percentageRate;
	}
	
	/**
	 * @return the monthlyRepayment
	 */
	public BigDecimal getMonthlyRepayment() {
		return monthlyRepayment;
	}
	
	/**
	 * @param monthlyRepayment the monthlyRepayment to set
	 */
	public void setMonthlyRepayment(BigDecimal monthlyRepayment) {
		this.monthlyRepayment = monthlyRepayment;
	}
	
	/**
	 * @return the totalRepayment
	 */
	public BigDecimal getTotalRepayment() {
		return totalRepayment;
	}
	
	/**
	 * @param totalRepayment the totalRepayment to set
	 */
	public void setTotalRepayment(BigDecimal totalRepayment) {
		this.totalRepayment = totalRepayment;
	}
}
