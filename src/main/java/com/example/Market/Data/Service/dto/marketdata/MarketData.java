package com.example.Market.Data.Service.dto.marketdata;

import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

public class MarketData {
    @Id
    private String TICKER;

    private int SELL_LIMIT;

    private double ASK_PRICE;

    private int BUY_LIMIT;

    private double MAX_PRICE_SHIFT;

    private double LAST_TRADED_PRICE;

    private double BID_PRICE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MarketData that = (MarketData) o;
        return TICKER != null && Objects.equals(TICKER, that.TICKER);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
