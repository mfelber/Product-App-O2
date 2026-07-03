package com.o2.felber.product_app.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.o2.felber.product_app.dto.ProductDto;
import com.o2.felber.product_app.mapper.ProductMapper;
import com.o2.felber.product_app.model.Product;

@Repository
public class ProductRepository {

  private final List<Product> products = new ArrayList<>(
      List.of(
          new Product(1L, "Mobile Data 30GB", "Mobilné dáta 30GB" ,new BigDecimal("30.99"), true),
          new Product(2L, "Internet 500 Mb/s", "Internet 500 Mb/s" ,new BigDecimal("19.99"), true),
          new Product(3L, "Mobile phone plan", "Mobilný paušál" ,new BigDecimal("19.99"), true)
      )
  );

  public List<ProductDto> findAll() {
    return products.stream().map(ProductMapper::productResponse).toList();
  }

  public Optional<Product> findById(Long id) {
    return products.stream().filter(product -> product.getId().equals(id)).findFirst();
  }

  public void disableProduct(Long id) {
    final Product product = findById(id).orElseThrow(() -> new RuntimeException("Product with id: " + id + " not found"));
    product.setEnabled(false);
  }

  public void enableProduct(Long id) {
    final Product product = findById(id).orElseThrow(() -> new RuntimeException("Product with id: " + id + " not found"));
    product.setEnabled(true);
  }

}
