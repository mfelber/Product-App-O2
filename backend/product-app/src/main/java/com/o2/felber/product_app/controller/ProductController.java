package com.o2.felber.product_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.o2.felber.product_app.dto.ProductDto;
import com.o2.felber.product_app.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/getAll")
  public List<ProductDto> getProducts() {
    return productService.getProducts();
  }

  @PostMapping("/{id}/disable")
  public ResponseEntity<Void> disableProduct(@PathVariable Long id) {
    productService.disableProduct(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/{id}/enable")
  public ResponseEntity<Void> enableProduct(@PathVariable Long id) {
    productService.enableProduct(id);
    return ResponseEntity.noContent().build();
  }

}
