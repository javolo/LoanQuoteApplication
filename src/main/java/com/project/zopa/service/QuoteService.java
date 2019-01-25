package com.project.zopa.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.project.zopa.model.Lender;
import com.project.zopa.model.QuoteResult;

public class QuoteService {

	private static final BigDecimal LOANLENGHT = new BigDecimal("36");

	public static QuoteResult obtainQuoteRateAndRepayment(final List<Lender> lendersList, QuoteResult result) {

		// Sort the list by Rate so we apply the lowest interest rate first
		List<Lender> sortedList = lendersList.stream().sorted(Comparator.comparing(Lender::getInterestRate)).collect(Collectors.toList());

		// Populate the different fields for the result
		// Total Repayment
		result.setTotalRepayment(round(calculateTotalRepayment(sortedList, result.getRequestedAmount()), 2));
		// Interest Rate
		result.setPercentageRate(round(((BigDecimal.valueOf(result.getTotalRepayment()).subtract(BigDecimal.valueOf(result.getRequestedAmount()))).
				divide(BigDecimal.valueOf(result.getRequestedAmount()), MathContext.DECIMAL64)).multiply(new BigDecimal("100")), 2));
		// Monthly repayment
		result.setMonthlyRepayment(round(BigDecimal.valueOf(result.getTotalRepayment()).divide(LOANLENGHT, MathContext.DECIMAL64), 2));

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

			totalAmount = totalAmount.add(BigDecimal.valueOf(amountToBorrow)).add(BigDecimal.valueOf(amountToBorrow).multiply(lender.getInterestRate()));

			amountBorrowed += amountToBorrow;
			if (amountBorrowed >= loanAmount) {
				break;
			}
		}

		return totalAmount;
	}

	public static double round(BigDecimal value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal decimalValue = value;
		decimalValue = decimalValue.setScale(places, RoundingMode.HALF_UP);
		return decimalValue.doubleValue();
	}

}
