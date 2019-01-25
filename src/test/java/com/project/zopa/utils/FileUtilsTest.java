package com.project.zopa.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.project.zopa.exception.QuoteException;
import com.project.zopa.model.Lender;
import com.project.zopa.model.QuoteConstants;

public class FileUtilsTest {	

	private File testFile;

	@Before
	public void setUp() throws Exception {
		testFile = new File("src/test/resources/test_data.cs");
	}

	@Test
	public void testGetWrongFileName() throws Exception {

		try {
			FileUtils.transformCSVFileIntoList(testFile);
		} catch (Exception e) {
			assertTrue(e instanceof QuoteException);
			assertEquals(QuoteConstants.INCORRECTFILEEXTENSION, e.getMessage());
		}
	}

	@Test
	public void testGetWrongFormat() throws Exception {

		testFile = new File("src/test/resources/incorrect_market_data.csv");
		try {
			FileUtils.transformCSVFileIntoList(testFile);
		} catch (Exception e) {
			assertTrue(e instanceof QuoteException);
			assertEquals(QuoteConstants.INCORRECTFORMATFILE, e.getMessage());
		}
	}

	@Test
	public void testGetRightFile() throws Exception {

		testFile = new File("src/test/resources/market_data.csv");
		List<Lender> lenderList = FileUtils.transformCSVFileIntoList(testFile);
		assertEquals(7, lenderList.size());

	}

}
