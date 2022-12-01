package com.example.Market.Data.Service.service;

import com.example.Market.Data.Service.dao.StockEx1Dao;
import com.example.Market.Data.Service.dto.stock.StockEx1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockEx1Service {
    @Autowired
    StockEx1Dao stockDao;

    public StockEx1 saveStockData(StockEx1 stock){
//        StockEx1 s = stockDao.save(stock);
//        if (s == null)
//            return HttpStatus.PRECONDITION_FAILED;
//        else return HttpStatus.OK;

        return stockDao.save(stock);
    }

    public List<StockEx1> getAllExchange1Stocks(){
        return stockDao.findAll();
    }
}
