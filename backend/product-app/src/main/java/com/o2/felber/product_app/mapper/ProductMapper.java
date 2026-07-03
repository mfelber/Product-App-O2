package com.o2.felber.product_app.mapper;

import com.o2.felber.product_app.dto.ProductDto;
import com.o2.felber.product_app.model.Product;

public class ProductMapper {

  public static ProductDto productResponse(Product product) {
    return new ProductDto(
        product.getId(),
        product.getNameSk(),
        product.getPrice(),
        product.isEnabled()
    );
  }

}
