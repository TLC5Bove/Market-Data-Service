package com.example.Market.Data.Service.dao;

import com.example.Market.Data.Service.dto.stock.StockEx1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockEx1Dao extends JpaRepository<StockEx1, String> { }
