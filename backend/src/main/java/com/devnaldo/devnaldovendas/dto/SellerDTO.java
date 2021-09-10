package com.devnaldo.devnaldovendas.dto;

import com.devnaldo.devnaldovendas.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public SellerDTO(Seller seller) {

    }
}
