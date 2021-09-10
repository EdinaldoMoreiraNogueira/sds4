package com.devnaldo.devnaldovendas.repositories;

import com.devnaldo.devnaldovendas.dto.SaleSucessDTO;
import com.devnaldo.devnaldovendas.dto.SaleSumDTO;
import com.devnaldo.devnaldovendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepositories extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devnaldo.devnaldovendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
            "FROM Sale AS obj GROUP BY obj.seller ")
    List<SaleSumDTO> amountGroupbySeller();


    @Query("SELECT new com.devnaldo.devnaldovendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            "FROM Sale AS obj GROUP BY obj.seller ")
    List<SaleSucessDTO> sucessGroupbySeller();


}
