package com.example.Market.Data.Service.controller;

import com.example.Market.Data.Service.publisher.Publisher;
import com.example.Market.Data.Service.dto.stock.StockEx1;
import com.example.Market.Data.Service.dto.stock.StockEx2;
import com.example.Market.Data.Service.service.StockEx1Service;
import com.example.Market.Data.Service.service.StockEx2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1")
public class MarketDataWebHookController {
    @Autowired
    Publisher publisher;

    @Autowired
    StockEx1Service stockEx1Service;

    @Autowired
    StockEx2Service stockEx2Service;

    @PostMapping("/exchange1-market-data")
    public StockEx1 exchange1Subscription(@RequestBody StockEx1 requestBody){
        if (Objects.equals(requestBody.getOrderType(), "LIMIT")) {
            System.out.println(">>>>> Received data from exchange 1 => " + requestBody + " => Sending the data to the order processing service");
            publisher.publisher(requestBody);
            stockEx1Service.saveStockData(requestBody);
        }
        return requestBody;
    }

    @PostMapping("/exchange2-market-data")
    public StockEx2 exchange2Subscription(@RequestBody StockEx2 requestBody){
        if (Objects.equals(requestBody.getOrderType(), "LIMIT")){
            System.out.println(">>>>> Received data from exchange 2 => " + requestBody + " => Sending the data to the order processing service");
            publisher.publisher(requestBody);
            stockEx2Service.saveStockData(requestBody);
        }
        return requestBody;
    }
}
