package com.example.Market.Data.Service.stock;

//import jakarta.persistence.Entity;
import lombok.Data;

//@Entity
@Data
abstract public class Stock {
//    private int SELL_LIMIT;
//    private double ASK_PRICE;
//    private int BUY_LIMIT;
//    private double MAX_PRICE_SHIFT;
//    private double LAST_TRADED_PRICE;
//    private String TICKER;
//    private double BID_PRICE;
    protected String product;
    protected double price;
    protected String side;
}
