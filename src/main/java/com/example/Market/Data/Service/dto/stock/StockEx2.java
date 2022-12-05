package com.example.Market.Data.Service.dto.stock;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class StockEx2 implements Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String product;
    @Transient
    private final String exchange = "exchange 2";
    private double price;
    private String side;
    @Transient
    private String orderType;
}
