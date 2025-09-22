package com.org.productexplorer.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.productexplorer.entity.ProductDetail;
import com.org.productexplorer.repository.ProductDetailRepository;

@Repository
public class ProductDetailDao {
@Autowired 
private ProductDetailRepository productDetailRepository;
	
public ProductDetail save(ProductDetail detail) {
	
		return productDetailRepository.save(detail); 
	}
public List<ProductDetail> findAll() {
    return productDetailRepository.findAll();
}

public Optional<ProductDetail> findById(Long id) {
    return productDetailRepository.findById(id);
}

public void deleteById(Long id) {
    productDetailRepository.deleteById(id);
}
}
