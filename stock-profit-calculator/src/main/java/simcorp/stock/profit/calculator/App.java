package simcorp.stock.profit.calculator;

import java.io.IOException;

import java.util.Scanner;

import simcorp.stock.profit.calculator.model.*;
import simcorp.stock.profit.calculator.utils.FileHelper;
import simcorp.stock.profit.calculator.utils.InputValidator;

import java.util.List;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * 
         * Loop until user exits
         * Will validate user input for stock name and year
         */
        while (true) {
            System.out.print("\nEnter stock name:");
            String stockName = scanner.nextLine().trim().toUpperCase();
            
            if (stockName.equals("QUIT")) {
                break;
            }
            
            if (!InputValidator.isValidStockName(stockName)) {
                continue;
            }
            
            System.out.print("Enter year: ");
            String yearStr = scanner.nextLine().trim();
            
            if (!InputValidator.isValidYear(yearStr)) {
                continue;
            }
            
            int year = Integer.parseInt(yearStr);
            MaxProfit profit = calculatMaxProfit(stockName, year);
            System.out.println("\nMax Profit for " + stockName + " in year " + year + ": \n" + profit);
        }
        
        scanner.close();
    }
   
    /** 
     * 
     * Method to calculate max profit
     * 
     * 
    */
   
    public static MaxProfit calculatMaxProfit(String stockName, int year) {
        try {
            List<StockData> stockData = FileHelper.readCsvFileAndReturnStockData(stockName, year);
            // If no data found, return empty object
            if (stockData.isEmpty()) {
                return new MaxProfit();
            }

            double minPrice = Double.MAX_VALUE;
            double maxProfit = 0;
            String buyDate = null, sellDate = null;
            double buyPrice = 0, sellPrice = 0; 

            /**
             * 
             * If the current day's openPrice is less than the current minPrice
             * then update minPrice and buyDate new lower price for a possible potential buy date
             * 
             * Else if the current days openPrice is greater than the current maxProfit
             * then update maxProfit and sellDate new higher price for a possible sell date
             */

            for (StockData data : stockData) {
                
                double openPrice = data.getOpenPrice();
                if (openPrice < minPrice) {
                    minPrice = openPrice;
                    buyDate = data.getDate();
                    buyPrice = openPrice;
                } else if (openPrice - minPrice > maxProfit) {
                    maxProfit = openPrice - minPrice;
                    sellDate = data.getDate();
                    sellPrice = openPrice;
                }
            }

            if (maxProfit > 0) {
                return new MaxProfit(buyDate, buyPrice, sellDate, sellPrice, maxProfit);
            } else {
                return new MaxProfit();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return new MaxProfit();
        }
    }
}
