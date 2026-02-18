package com.gmail.rafaroga46.PriceAi.service;

import com.gmail.rafaroga46.PriceAi.model.ProductAlert;
import com.gmail.rafaroga46.PriceAi.repository.ProductAlertRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductAlertService {

    private final ProductAlertRepository repository;

    public ProductAlertService(ProductAlertRepository repository) {
        this.repository = repository;
    }

    public ProductAlert save(ProductAlert request) {
        return repository.save(request);
    }

}
