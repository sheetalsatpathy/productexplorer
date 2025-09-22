package com.org.productexplorer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.productexplorer.entity.Product;
import com.org.productexplorer.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
  @Autowired
  private ProductService productService;
  
  @PostMapping
  public ResponseEntity<?> create(@RequestBody Product product){
	  Product saved = productService.create(product);
	  return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }
  @GetMapping
  public ResponseEntity<?> getAll(){
	  List<Product> list=productService.getAll();
	  return ResponseEntity.ok(list); 
  }
  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id) {
      Product product = productService.getById(id);
      return ResponseEntity.ok(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product) {
      Product updated = productService.update(id, product);
      return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
      productService.delete(id);
      return ResponseEntity.ok("Product deleted successfully");
  }
}

