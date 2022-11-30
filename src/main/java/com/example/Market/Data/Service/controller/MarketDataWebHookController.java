package com.example.Market.Data.Service.controller;

import com.example.Market.Data.Service.publisher.Publisher;
import com.example.Market.Data.Service.stock.StockEx1;
import com.example.Market.Data.Service.stock.StockEx2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class MarketDataWebHookController {
    @Autowired
    Publisher publisher;

    @PostMapping("/exchange1-market-data")
    public StockEx1 exchange1Subcription(@RequestBody StockEx1 requestBody){
        System.out.println(">>>>> Received data from exchange 1 => " + requestBody + " => Sending the data to the order processing service");
        publisher.publisher(requestBody);
        return requestBody;
    }

    @PostMapping("/exchange2-market-data")
    public StockEx2 exchange2Subscription(@RequestBody StockEx2 requestBody){
        System.out.println(">>>>> Received data from exchange 2 => " + requestBody + " => Sending the data to the order processing service");
        publisher.publisher(requestBody);
        return requestBody;
    }
}
