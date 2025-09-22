package com.org.productexplorer.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
 
	Optional<Product> findBySourceId(String sourceId);
    Optional<Product> findBySourceUrl(String sourceUrl);
    List<Product> findByCategoryId(Long categoryId);

}
