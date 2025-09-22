package com.org.productexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{

}
