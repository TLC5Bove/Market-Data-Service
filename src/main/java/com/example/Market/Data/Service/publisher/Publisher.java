package com.example.Market.Data.Service.publisher;

import com.example.Market.Data.Service.dto.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class Publisher implements MessagePublisher {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public Publisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    public Publisher() {
    }

    @Override
    public void publisher(Stock message) {
        redisTemplate.convertAndSend(topic.getTopic(),message);
    }
}
