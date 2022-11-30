package com.example.Market.Data.Service.controller;

import com.example.Market.Data.Service.publisher.Publisher;
import com.example.Market.Data.Service.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class MarketDataWebHookController {
    @Autowired
    Publisher publisher;

    @PostMapping("/exchange1-market-data")
    public Object exchange1Subcription(@RequestBody Object requestBody){
        System.out.println("rec" +
                "eived data from exchange 1 => " + requestBody);
        publisher.publisher(requestBody.toString());
        return requestBody;
    }

    @PostMapping("/exchange2-market-data")
    public void exchange2Subscription(@RequestBody Stock requestBody){
        System.out.println("received data from exchange 2 => " + requestBody);
    }
}
