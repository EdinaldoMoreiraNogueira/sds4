package com.devnaldo.devnaldovendas.service;

import com.devnaldo.devnaldovendas.dto.SaleDTO;
import com.devnaldo.devnaldovendas.entities.Sale;
import com.devnaldo.devnaldovendas.repositories.SaleRepositories;
import com.devnaldo.devnaldovendas.repositories.SellerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaleService {
    @Autowired
    private SaleRepositories saleRepositories;

    @Autowired
    private SellerRepositories sellerRepositories;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        sellerRepositories.findAll();
        Page<Sale> result = saleRepositories.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }
}
