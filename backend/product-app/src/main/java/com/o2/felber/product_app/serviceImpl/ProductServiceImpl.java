package com.o2.felber.product_app.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.o2.felber.product_app.dto.ProductDto;
import com.o2.felber.product_app.repository.ProductRepository;
import com.o2.felber.product_app.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public List<ProductDto> getProducts() {
    return productRepository.findAll();
  }

  @Override
  public void disableProduct(Long id) {
    productRepository.disableProduct(id);
  }

  @Override
  public void enableProduct(final Long id) {
    productRepository.enableProduct(id);
  }

}
