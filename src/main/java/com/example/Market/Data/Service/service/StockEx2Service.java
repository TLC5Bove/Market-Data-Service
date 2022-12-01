package com.example.Market.Data.Service.service;

import com.example.Market.Data.Service.dao.StockEx2Dao;
import com.example.Market.Data.Service.dto.stock.StockEx1;
import com.example.Market.Data.Service.dto.stock.StockEx2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEx2Service {
    @Autowired
    StockEx2Dao stockDao;

    public StockEx2 saveStockData(StockEx2 stock){
        return stockDao.save(stock);
    }

    public List<StockEx2> getAllExchange2Stocks() { return stockDao.findAll(); }
}
