package com.gmail.rafaroga46.PriceAi.repository;

import com.gmail.rafaroga46.PriceAi.model.ProductAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAlertRepository extends JpaRepository<ProductAlert,Long> {

}
