package com.example.Market.Data.Service.controller;

import com.example.Market.Data.Service.dto.stock.StockEx1;
import com.example.Market.Data.Service.dto.stock.StockEx2;
import com.example.Market.Data.Service.service.StockEx1Service;
import com.example.Market.Data.Service.service.StockEx2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class MarketDataController {
    @Autowired
    StockEx1Service stockEx1Service;

    @Autowired
    StockEx2Service stockEx2Service;
    private final WebClient webClient = WebClient.create();

    @GetMapping("/api/v1/full-market-data")
    public String getFullMarketData() {
        WebClient.ResponseSpec responseSpec = webClient.get().uri("https://exchange.matraining.com/pd").retrieve();
        return responseSpec.bodyToMono(String.class).block();
    }

    @GetMapping("/api/v1/stocks/exchange1/{product}")
    public List<StockEx1> getEx1ProductData(@PathVariable String product){
        return stockEx1Service.getAllExchange1StockByProduct(product);
    }

    @GetMapping("/api/v1/stocks/exchange2/{product}")
    public List<StockEx2> getEx2ProductData(@PathVariable String product){
        return stockEx2Service.getAllExchange2StockByProduct(product);
    }
}
