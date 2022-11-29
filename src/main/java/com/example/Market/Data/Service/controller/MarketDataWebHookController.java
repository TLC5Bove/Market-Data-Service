package com.example.Market.Data.Service.controller;

import com.example.Market.Data.Service.stock.Stock;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class MarketDataWebHookController {

    @PostMapping("/exchange1-market-data")
    public void exchange1Subcription(@RequestBody Stock requestBody){
        System.out.println("received data from exchange 1 => " + requestBody);
    }

    @PostMapping("/exchange2-market-data")
    public void exchange2Subscription(@RequestBody Stock requestBody){
        System.out.println("received data from exchange 2 => " + requestBody);
    }
}
