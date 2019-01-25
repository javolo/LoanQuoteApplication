package com.project.zopa.model;

public class QuoteResult {
	
	private int requestedAmount;
	private double percentageRate;
	private double monthlyRepayment;
	private double totalRepayment;
	
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
	public double getPercentageRate() {
		return percentageRate;
	}
	
	/**
	 * @param percentageRate the percentageRate to set
	 */
	public void setPercentageRate(double percentageRate) {
		this.percentageRate = percentageRate;
	}
	
	/**
	 * @return the monthlyRepayment
	 */
	public double getMonthlyRepayment() {
		return monthlyRepayment;
	}
	
	/**
	 * @param monthlyRepayment the monthlyRepayment to set
	 */
	public void setMonthlyRepayment(double monthlyRepayment) {
		this.monthlyRepayment = monthlyRepayment;
	}
	
	/**
	 * @return the totalRepayment
	 */
	public double getTotalRepayment() {
		return totalRepayment;
	}
	
	/**
	 * @param totalRepayment the totalRepayment to set
	 */
	public void setTotalRepayment(double totalRepayment) {
		this.totalRepayment = totalRepayment;
	}
}
