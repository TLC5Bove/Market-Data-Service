package com.example.Market.Data.Service.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class MarketDataController {
    private WebClient webClient = WebClient.create();

    @GetMapping("/api/v1/full-market-data")
    public String getFullMarketData() {
        WebClient.ResponseSpec responseSpec = webClient.get().uri("https://exchange.matraining.com/pd").retrieve();
        return responseSpec.bodyToMono(String.class).block();
    }
}
