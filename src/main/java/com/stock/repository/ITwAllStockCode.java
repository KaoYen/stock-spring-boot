package com.stock.repository;

import com.stock.entity.TwAllStockCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITwAllStockCode extends JpaRepository<TwAllStockCode, String> {

    @Query("SELECT t FROM TwAllStockCode t WHERE t.stockType = :stockType")
    List<TwAllStockCode> findByStockType(@Param("stockType")String stockType);
}
