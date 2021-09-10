package com.devnaldo.devnaldovendas.dto;

import com.devnaldo.devnaldovendas.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SaleDTO {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;

    private SellerDTO seller;

    public SaleDTO(){

    }

    public SaleDTO(Sale entidy) {
        id = entidy.getId();
        visited = entidy.getVisited();
        deals = entidy.getDeals();
        amount = entidy.getAmount();
        date = entidy.getDate();
        seller = new SellerDTO(entidy.getSeller());
    }
}
