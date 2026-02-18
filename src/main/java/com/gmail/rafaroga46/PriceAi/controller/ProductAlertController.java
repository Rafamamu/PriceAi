package com.gmail.rafaroga46.PriceAi.controller;

import com.gmail.rafaroga46.PriceAi.model.ProductAlert;
import com.gmail.rafaroga46.PriceAi.service.ProductAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductAlertController {

    private  final ProductAlertService service;

    public ProductAlertController(ProductAlertService service) {
        this.service = service;
    }

    public ResponseEntity<ProductAlert> criar(@RequestBody ProductAlert productAlert){

        return ResponseEntity.ok(service.save(productAlert));
    }
}
