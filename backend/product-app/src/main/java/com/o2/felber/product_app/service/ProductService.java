package com.o2.felber.product_app.service;

import java.util.List;

import com.o2.felber.product_app.dto.ProductDto;

public interface ProductService {

  List<ProductDto> getProducts();

  void disableProduct(Long id);

  void enableProduct(Long id);

}
