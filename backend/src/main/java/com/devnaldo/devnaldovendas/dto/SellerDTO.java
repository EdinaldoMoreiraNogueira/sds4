package com.devnaldo.devnaldovendas.dto;

import com.devnaldo.devnaldovendas.entities.Sale;
import com.devnaldo.devnaldovendas.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class SellerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    private SaleDTO sale;

    public SellerDTO() {

    }

    public SellerDTO(Seller entidy) {
        id = entidy.getId();
        name = entidy.getName();


    }
}
