package com.devnaldo.devnaldovendas.dto;

import com.devnaldo.devnaldovendas.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SaleSumDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sellerName;
    private  Double sum;

    public SaleSumDTO(){

    }

    public SaleSumDTO(Seller seller, Double sum) {
        sellerName = seller.getName();
        this.sum = sum;
    }
}
