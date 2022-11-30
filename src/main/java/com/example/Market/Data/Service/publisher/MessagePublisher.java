package com.example.Market.Data.Service.publisher;

import org.springframework.stereotype.Component;

@Component
public interface MessagePublisher {
    public void publisher(String message);
}
