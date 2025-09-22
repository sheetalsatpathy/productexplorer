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

import com.org.productexplorer.entity.ProductDetail;
import com.org.productexplorer.service.ProductDetailService;

@RestController
@RequestMapping("/api/product-details")
@CrossOrigin(origins = "*")

public class ProductDetailController {
  
	@Autowired
	private ProductDetailService productDetailService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProductDetail detail){
		 ProductDetail saved = productDetailService.create(detail);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved); 
	}
	 @GetMapping
	    public ResponseEntity<?> getAll() {
	        List<ProductDetail> list = productDetailService.getAll();
	        return ResponseEntity.ok(list);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<?> getById(@PathVariable Long id) {
	        ProductDetail detail = productDetailService.getById(id);
	        return ResponseEntity.ok(detail);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDetail detail) {
	        ProductDetail updated = productDetailService.update(id, detail);
	        return ResponseEntity.ok(updated);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        productDetailService.delete(id);
	        return ResponseEntity.ok("Product detail deleted successfully");
	    }
}
