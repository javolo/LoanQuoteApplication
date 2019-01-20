package com.project.zopa;

import java.io.File;
import java.util.List;

import com.project.zopa.exception.QuoteException;
import com.project.zopa.model.Lender;
import com.project.zopa.model.QuoteConstants;
import com.project.zopa.model.QuoteResult;
import com.project.zopa.utils.FileUtils;
import com.project.zopa.utils.QuoteUtils;

/**
 * Quote application
 *
 */
public class QuoteApplication  {

	public static void main(String[] args) throws QuoteException {


		if (args.length > 0) {
			File inFile = new File(args[0]);
			List<Lender> lendersList = FileUtils.transformCSVFileIntoList(inFile);
			
			if (args.length > 1) {
				// Creating object where we hold the result of the quote
				QuoteResult result = new QuoteResult();
				result.setRequestedAmount(QuoteUtils.getLoanAmountInput(args[1]));
				
				// Calculation of the rate and monthly repayment
				result = QuoteUtils.obtainQuoteRateAndRepayment(lendersList, result);

				// Calling the method that prints out the result
				QuoteUtils.printExitStatus(result);
			} else {
				throw new QuoteException(QuoteConstants.INCORRECTARGUMENTS);
			}
		} else {
			throw new QuoteException(QuoteConstants.INCORRECTARGUMENTS);
		}
	}

}
