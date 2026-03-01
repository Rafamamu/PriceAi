package com.gmail.rafaroga46.PriceAi.model;

import jakarta.persistence.*;
import org.hibernate.Length;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product_alert")
public class ProductAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String product;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    @Column(length = 2000)
    private String aiResponse;
    private String email;

    public ProductAlert() {

    }

    public ProductAlert(String product,
                        BigDecimal minPrice,
                        BigDecimal maxPrice,
                        String aiResponse,
                        String email) {

        this.product = product;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.aiResponse = aiResponse;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;

    }
    public String getAiResponse() {
        return aiResponse;
    }
    public void setAiResponse(String aiResponse) {
        this.aiResponse = aiResponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
