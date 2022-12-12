package com.example.Market.Data.Service.dao;

import com.example.Market.Data.Service.dto.marketdata.MarketDataCache;

import java.util.Map;

public interface MarketDataDao {
    void saveData(MarketDataCache data);
    void saveAll(Map<String, MarketDataCache> marketDataList);
    void updateMarketData(MarketDataCache data);
    void deleteMarketData(String ticker);
    MarketDataCache getMarketData(String ticker);
    Map<String, MarketDataCache> getAllMarketData();
}
