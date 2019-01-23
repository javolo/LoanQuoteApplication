package com.project.zopa.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

import com.project.zopa.exception.QuoteException;
import com.project.zopa.model.Lender;
import com.project.zopa.model.QuoteConstants;

public class FileUtils {

	// Method to translate the file into a list of Lenders
	public static List<Lender> transformCSVFileIntoList(final File inputFile) throws FileNotFoundException, QuoteException{

		List<Lender> result = new ArrayList<>();

		if (!FilenameUtils.getExtension(inputFile.getName()).equals("csv")){
			throw new QuoteException(QuoteConstants.INCORRECTFILEEXTENSION);
		} else {
			Scanner scanner = new Scanner(inputFile);
			
			// Variables used in the scan
			String line;
			String[] fields;
			Lender lender;
			
			while(scanner.hasNextLine()){

				line = scanner.nextLine();
				fields = line.split(",");
				
				// At least one address specified.
				if (fields.length == 3) {
					lender = new Lender();
					for (String field: fields) {
						lender.setLenderName(field);
						lender.setInterestRate(new BigDecimal(field));
						lender.setAvailableAmount(Integer.parseInt(field));
					}
					result.add(lender);
				} else {
					scanner.close();
					throw new QuoteException(QuoteConstants.INCORRECTFORMATFILE);
				}
			}
			scanner.close();
		}
		return result;
	}

}
