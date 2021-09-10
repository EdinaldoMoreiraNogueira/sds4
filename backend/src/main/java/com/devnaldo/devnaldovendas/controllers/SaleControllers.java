package com.devnaldo.devnaldovendas.controllers;

import com.devnaldo.devnaldovendas.dto.SaleDTO;
import com.devnaldo.devnaldovendas.dto.SaleSucessDTO;
import com.devnaldo.devnaldovendas.dto.SaleSumDTO;
import com.devnaldo.devnaldovendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/sales")
public class SaleControllers {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
    Page<SaleDTO> page = saleService.findAll(pageable);
    return ResponseEntity.ok(page);
}
    @GetMapping(value = "/sum-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupbySeller () {
        List<SaleSumDTO> list = saleService.amountGroupbySeller();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/sucess-by-seller")
    public ResponseEntity<List<SaleSucessDTO>> sucessGroupbySeller () {
        List<SaleSucessDTO> list = saleService.sucessGroupbySeller();
        return ResponseEntity.ok(list);
    }
}
