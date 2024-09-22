package simcorp.stock.profit.calculator.model;

public class StockData {
    private String date;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;

    public StockData(String date, double openPrice, double highPrice, double lowPrice, double closePrice) {
        this.date = date;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpenPrice() {
        return openPrice;
    }    

    public double getHighPrice() {        
        return highPrice;
    }       

    public double getLowPrice() {
        return lowPrice;
    }   

    public double getClosePrice() {
        return closePrice;
    }   

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }   

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }   

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

}
