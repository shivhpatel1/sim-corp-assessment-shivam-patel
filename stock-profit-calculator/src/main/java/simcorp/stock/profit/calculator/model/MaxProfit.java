package simcorp.stock.profit.calculator.model;

import java.math.BigDecimal;

public class MaxProfit {
    private String buyDate;
    private double buyPrice;
    private double sellPrice;
    private String sellDate;
    private double profit;

    public MaxProfit() {
    }

    public MaxProfit(String buyDate, double buyPrice,  String sellDate,double sellPrice, double profit) {   
        this.buyDate = buyDate;
        this.buyPrice = new BigDecimal(buyPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.sellPrice = new BigDecimal(sellPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.profit = new BigDecimal(profit).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.sellDate = sellDate;
    }
    
    public String getBuyDate() {
        return buyDate;
    }
    public void setBuyDate(String buyDate) {        
        this.buyDate = buyDate;
    }
    public double getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = new BigDecimal(buyPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public double getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(double sellPrice) {
        this.sellPrice = new BigDecimal(sellPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public String getSellDate() {
        return sellDate;
    }
    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }
    public double getProfit() {
        return profit;
    }    
    public void setProfit(double profit) {
        this.profit = new BigDecimal(profit).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }   

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------------------------------------\n");
        if (buyDate != null) {
            sb.append(String.format("Buy date: %s\n", buyDate));
        }
        if (buyPrice != 0.0) {
            sb.append(String.format("Buy price: %.2f\n", buyPrice));
        }
        if (sellDate != null) {
            sb.append(String.format("Sell date: %s\n", sellDate));
        }
        if (sellPrice != 0.0) {
            sb.append(String.format("Sell price: %.2f\n", sellPrice));
        }
        if (profit != 0.0) {
            sb.append(String.format("Profit: %.2f\n", profit));
        } else {
            sb.append("No Max Profit Found\n");
        }
        sb.append("--------------------------------------------------------\n");
        return sb.toString();
    }

}
