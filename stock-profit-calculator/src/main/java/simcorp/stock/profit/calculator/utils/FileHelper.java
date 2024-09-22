package simcorp.stock.profit.calculator.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import simcorp.stock.profit.calculator.constants.AppConstants;
import simcorp.stock.profit.calculator.model.StockData;
public class FileHelper {
   /**
    * Read CSV file and return list convert each row to StockData object and return List<StockData>
    */
    public static List<StockData> readCsvFileAndReturnStockData(String stockName, int year) throws IOException {
        String filename =  AppConstants.RESOURCE_PATH +stockName + ".csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<StockData> stockDataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                LocalDate date = LocalDate.parse(values[0], formatter);
                if(date.getYear() != year) continue;
                stockDataList.add(new StockData(date.toString(), Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4])));
            }
        }catch(Exception e){
            System.out.println("Error Occured While Parsing CSV File: " + e);
        }
        return stockDataList;
    }
}
