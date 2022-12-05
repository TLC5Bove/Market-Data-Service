package com.example.Market.Data.Service.service;

import com.example.Market.Data.Service.dao.StockEx1Dao;
import com.example.Market.Data.Service.dto.stock.StockEx1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class StockEx1ServiceTest {
    @Autowired
    StockEx1Service stockEx1Service;

    @MockBean
    StockEx1Dao stockEx1Dao;

    @Test
    public void saveStockDataTest() {
        StockEx1 stock = new StockEx1();

        stockEx1Service.saveStockData(stock);

        verify(stockEx1Dao, times(1)).save(stock);
    }

    @Test
    public void getAllExchange1StockTest() {
        stockEx1Service.getAllExchange1Stocks();

        verify(stockEx1Dao, times(1)).findAll();
    }

    @Test
    public void getAllExchange1StockByProductTest() {
        stockEx1Service.getAllExchange1StockByProduct("IBM");
        verify(stockEx1Dao, times(1)).findAllByProduct("IBM");
    }
}