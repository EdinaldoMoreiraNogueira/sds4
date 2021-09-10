package com.devnaldo.devnaldovendas.service;

import com.devnaldo.devnaldovendas.dto.SellerDTO;
import com.devnaldo.devnaldovendas.entities.Seller;
import com.devnaldo.devnaldovendas.repositories.SellerRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepositories sellerRepositories;

    public List<SellerDTO> findAll(){
        List<Seller> result =  sellerRepositories.findAll();
        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }
}
