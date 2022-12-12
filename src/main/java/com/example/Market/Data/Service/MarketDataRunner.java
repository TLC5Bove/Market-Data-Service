package com.example.Market.Data.Service;

import com.example.Market.Data.Service.dao.MarketDataRepository;
import com.example.Market.Data.Service.dto.marketdata.MarketDataCache;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Component
public class MarketDataRunner implements CommandLineRunner {

    @Value("${market-data.EXCHANGE_URL}")
    private String exchangeURL;
    @Value("${market-data.EXCHANGE2_URL}")
    private String exchange2URL;

    @Autowired
    private MarketDataRepository marketDataRepository;

    @Override
    public void run(String... args) throws Exception {
        // get initial market data from exchange 1
        WebClient webClient = WebClient.create(exchangeURL);
        try {
            Object[] response = webClient.get()
                    .uri("/pd")
                    .retrieve()
                    .bodyToMono(Object[].class)
                    .block();

            assert response != null;
            List<Object> data = Arrays.stream(response).toList();
            data.forEach(res -> saveMarketDataToCache(res, "exchange 1"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // get initial market data from exchange 2
        WebClient webClient2 = WebClient.create(exchange2URL);
        try {
            Object[] response = webClient2.get()
                    .uri("/pd")
                    .retrieve()
                    .bodyToMono(Object[].class)
                    .block();

            assert response != null;
            List<Object> data = Arrays.stream(response).toList();
            data.forEach(res -> saveMarketDataToCache(res, "exchange 2"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        marketDataRepository.getAllMarketData().forEach((k, v) -> System.out.println(k +": "+ v));

    }

    private void saveMarketDataToCache(Object object, String exchange) {
        MarketDataCache marketData = new Gson().fromJson(object.toString(), MarketDataCache.class);
        String ticker = marketData.getTICKER()+"_"+exchange;
        marketData.setTICKER(ticker);
        marketDataRepository.saveData(marketData);
    }
}
