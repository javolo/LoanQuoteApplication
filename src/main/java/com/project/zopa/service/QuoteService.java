package com.project.zopa.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.project.zopa.model.Lender;
import com.project.zopa.model.QuoteResult;

public class QuoteService {
	
	private static final int LOANLENGHT = 36;

	public static QuoteResult obtainQuoteRateAndRepayment(final List<Lender> lendersList, QuoteResult result) {
		
		// Sort the list by Rate so we apply the lowest interest rate first
		List<Lender> sortedList = lendersList.stream().sorted(Comparator.comparing(Lender::getInterestRate)).collect(Collectors.toList());

		// Populate the different fields for the result
		// Total Repayment
		result.setTotalRepayment(calculateTotalRepayment(sortedList, result.getRequestedAmount()));
		// Interest Rate
		result.setPercentageRate((result.getTotalRepayment().subtract(BigDecimal.valueOf(result.getRequestedAmount()))).divide(BigDecimal.valueOf(LOANLENGHT)));
		// Monthly repayment
		result.setMonthlyRepayment((BigDecimal.valueOf(result.getRequestedAmount()).
				add(BigDecimal.valueOf(result.getRequestedAmount()).
						multiply(result.getPercentageRate()))).
							divide(BigDecimal.valueOf(LOANLENGHT)));
		

		return result;
	}
	
	private static BigDecimal calculateTotalRepayment(final List<Lender> lendersList, final int loanAmount) {
		
		int amountBorrowed = 0;
		BigDecimal totalAmount = new BigDecimal(0);
		int amountToBorrow = 0;
		
		for (Lender lender : lendersList) {
			
			if (amountBorrowed + lender.getAvailableAmount() > loanAmount) {
				amountToBorrow = loanAmount - amountBorrowed;
			} else {
				amountToBorrow = lender.getAvailableAmount();
			}
			
			amountBorrowed += amountToBorrow;
			if (amountBorrowed >= loanAmount) {
				break;
			}
			
		}
		
		
		return totalAmount;
	}

}
