package com.example.Market.Data.Service.publisher;

import com.example.Market.Data.Service.dto.stock.Stock;
import org.springframework.stereotype.Component;

@Component
public interface MessagePublisher {
    public void publisher(Stock message);
}
