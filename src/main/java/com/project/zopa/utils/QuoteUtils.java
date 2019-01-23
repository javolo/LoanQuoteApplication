package com.project.zopa.utils;

import com.project.zopa.exception.QuoteException;
import com.project.zopa.model.QuoteConstants;
import com.project.zopa.model.QuoteResult;

public class QuoteUtils {
	
	/**
	 * Calculates and prints exit results
	 *
	 * @param data input data
	 */
	public static void printExitStatus(final QuoteResult result) {

		System.out.println("Requested Amount: " + result.getRequestedAmount());
		System.out.println("Rate: " + result.getPercentageRate() + "%");
		System.out.println("Monthly repayment: £" + result.getMonthlyRepayment());
		System.out.println("Total repayment: £" + result.getTotalRepayment());
	}
	
	public static int getLoanAmountInput(String loanAmount) throws QuoteException {
		
		int convertedLoanAmount = Integer.parseInt(loanAmount);
		
		if (convertedLoanAmount % 100 != 0) {
			throw new QuoteException(QuoteConstants.INCORRECTAMOUNT);
		} else if (convertedLoanAmount < 1000 || convertedLoanAmount > 15000) {
			throw new QuoteException(QuoteConstants.INCORRECTAMOUNTVALUE);
		} else {
			return convertedLoanAmount;
		}
	}	

}
