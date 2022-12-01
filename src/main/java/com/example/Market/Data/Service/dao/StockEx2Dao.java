package com.example.Market.Data.Service.dao;

import com.example.Market.Data.Service.dto.stock.StockEx2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockEx2Dao extends JpaRepository<StockEx2, String> { }
