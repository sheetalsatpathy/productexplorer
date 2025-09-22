package com.org.productexplorer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	 List<Review> findByProductId(Long productId);
}
