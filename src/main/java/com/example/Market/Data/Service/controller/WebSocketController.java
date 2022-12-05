package com.example.Market.Data.Service.controller;

import com.example.Market.Data.Service.dto.stock.Stock;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
    @MessageMapping(value = "/mds/receive")
    @SendTo(value = "/sd/stock-data")
    public Stock send(Stock stock) {
        return stock;
    }
}
