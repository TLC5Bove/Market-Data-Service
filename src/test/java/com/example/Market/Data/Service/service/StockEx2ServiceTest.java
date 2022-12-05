package com.example.Market.Data.Service.service;

import com.example.Market.Data.Service.dao.StockEx2Dao;
import com.example.Market.Data.Service.dto.stock.StockEx2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StockEx2ServiceTest {
    @Autowired
    StockEx2Service stockEx2Service;

    @MockBean
    StockEx2Dao stockEx2Dao;

    @Test
    void saveStockDataTest() {

        StockEx2 stock = new StockEx2();

        stockEx2Service.saveStockData(stock);

        verify(stockEx2Dao, times(1)).save(stock);
    }

    @Test
    void getAllExchange2StocksTest() {
        stockEx2Service.getAllExchange2Stocks();

        verify(stockEx2Dao, times(1)).findAll();
    }

    @Test
    public void getAllExchange1StockByProductTest() {
        stockEx2Service.getAllExchange2StockByProduct("IBM");
        verify(stockEx2Dao, times(1)).findAllByProduct("IBM");
    }
}