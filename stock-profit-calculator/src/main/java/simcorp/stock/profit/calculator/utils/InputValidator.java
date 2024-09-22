package simcorp.stock.profit.calculator.utils;

import java.io.File;

import simcorp.stock.profit.calculator.constants.AppConstants;

public class InputValidator {
    public static boolean isValidStockName(String stockName) {
        if (stockName == null || stockName.trim().isEmpty()) {
            System.out.println("ERROR: Stock name cannot be empty.");
            return false;
        }
        
        File file = new File(AppConstants.RESOURCE_PATH + stockName + ".csv");
        if (!file.exists() || !file.isFile()) {
            System.out.println("ERROR: CSV file: " + file.getAbsolutePath() + " does not exist.");
            return false;
        }
        
        return true;
    }

    public static boolean isValidYear(String yearStr) {
        if (yearStr == null || yearStr.trim().isEmpty()) {
            System.out.println("ERROR: Year cannot be empty.");
            return false;
        }
        
        try {
            int year = Integer.parseInt(yearStr);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid year format. Please enter a valid integer year.");
            return false;
        }
        
        return true;
    }
}
