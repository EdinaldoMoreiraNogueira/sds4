package com.devnaldo.devnaldovendas.controllers;

import com.devnaldo.devnaldovendas.dto.SaleDTO;
import com.devnaldo.devnaldovendas.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
