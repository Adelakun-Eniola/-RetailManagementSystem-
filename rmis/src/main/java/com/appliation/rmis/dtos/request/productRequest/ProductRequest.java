package com.appliation.rmis.dtos.request.productRequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class ProductRequest {
    private String productName;
    private int productQuantity;
    private int priceOfProduct;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(int priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }
}
