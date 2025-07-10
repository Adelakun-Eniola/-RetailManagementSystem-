package com.appliation.rmis.mapper.product;

import com.appliation.rmis.data.models.Product;
import com.appliation.rmis.dtos.request.productRequest.ProductRequest;

public class ProductCreationMapper {

    public static Product mapToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setProductQuantity(productRequest.getProductQuantity());
        product.setPriceOfProduct(productRequest.getPriceOfProduct());

        return product;
    }
}
