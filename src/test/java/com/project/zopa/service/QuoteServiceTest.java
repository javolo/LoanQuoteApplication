package com.project.zopa.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project.zopa.model.Lender;
import com.project.zopa.model.QuoteResult;

public class QuoteServiceTest {

	private List<Lender> lenders = new ArrayList<>();
	private int loanAmount;
	private QuoteResult quoteResult;

	@Before
	public void setUp() throws Exception {
		lenders.add(new Lender("Bob", BigDecimal.valueOf(0.075), 640));
		lenders.add(new Lender("Jane", BigDecimal.valueOf(0.069), 480));
		lenders.add(new Lender("Fred", BigDecimal.valueOf(0.071), 520));

		loanAmount = 1000;
		
		quoteResult = new QuoteResult();
		quoteResult.setRequestedAmount(loanAmount);
	}

	@Test
	public void testGetMonthlyRepayment() throws Exception {
		assertEquals(BigDecimal.valueOf(29.72).doubleValue(), QuoteService.obtainQuoteRateAndRepayment(lenders, quoteResult).getMonthlyRepayment(), 0);
	}

	@Test
	public void testGetInterestRate() throws Exception {
		assertEquals(BigDecimal.valueOf(7.0).doubleValue(), QuoteService.obtainQuoteRateAndRepayment(lenders, quoteResult).getPercentageRate(), 0);
	}

	@Test
	public void testGetTotalRepayment() throws Exception {
		assertEquals(BigDecimal.valueOf(1070.04).doubleValue() , QuoteService.obtainQuoteRateAndRepayment(lenders, quoteResult).getTotalRepayment(), 0);
	}


}
