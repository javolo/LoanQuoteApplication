package com.project.zopa.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.project.zopa.exception.QuoteException;
import com.project.zopa.model.QuoteConstants;

public class QuoteUtilsTest {


	@Test
	public void testGetZeroLoanAmount() throws Exception {

		try {
			QuoteUtils.getLoanAmountInput("0");
		} catch (Exception e) {
			assertTrue(e instanceof QuoteException);
			assertEquals(QuoteConstants.INCORRECTAMOUNTVALUE, e.getMessage());
		}
	}

	@Test
	public void testGetBigLoanAmount() throws Exception {

		try {
			QuoteUtils.getLoanAmountInput("20000");
		} catch (Exception e) {
			assertTrue(e instanceof QuoteException);
			assertEquals(QuoteConstants.INCORRECTAMOUNTVALUE, e.getMessage());
		}
	}

	@Test
	public void testGetNotMultipleLoanAmount() throws Exception {

		try {
			QuoteUtils.getLoanAmountInput("1820");
		} catch (Exception e) {
			assertTrue(e instanceof QuoteException);
			assertEquals(QuoteConstants.INCORRECTAMOUNT, e.getMessage());
		}
	}

	@Test
	public void testGetRightLoanAmount() throws Exception {

		assertEquals(2400, QuoteUtils.getLoanAmountInput("2400"));
	}

}
