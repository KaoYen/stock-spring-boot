package com.stock.repository;

import com.stock.entity.TwseStock;
import com.stock.repository.extension.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwStockRawDataRepository extends JpaRepository<TwseStock, String>, CustomRepository<TwseStock, String> {

}
