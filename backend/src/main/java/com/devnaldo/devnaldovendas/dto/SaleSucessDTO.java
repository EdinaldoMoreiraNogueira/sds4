package com.devnaldo.devnaldovendas.dto;

import com.devnaldo.devnaldovendas.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SaleSucessDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSucessDTO(){

    }

    public SaleSucessDTO(Seller seller, Long visited, Long deals) {
        sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
