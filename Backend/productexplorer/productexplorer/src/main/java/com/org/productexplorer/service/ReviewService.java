package com.org.productexplorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.productexplorer.dao.ReviewDao;
import com.org.productexplorer.entity.Review;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	public Review create(Review review) {
        return reviewDao.save(review);
    }

    public List<Review> getAll() {
        return reviewDao.findAll();
    }

    public Review getById(Long id) {
        return reviewDao.findById(id).orElse(null);
    }

    public Review update(Long id, Review review) {
        Review existing = getById(id);
        if (existing != null) {
            review.setId(id);
            return reviewDao.save(review);
        }
        return null;
    }

    public void delete(Long id) {
        reviewDao.deleteById(id);
    }

    public List<Review> findByProductId(Long productId) {
        return reviewDao.findByProductId(productId);
    }
}
