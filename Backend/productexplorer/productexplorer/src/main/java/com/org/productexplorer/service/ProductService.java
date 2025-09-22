package com.org.productexplorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.productexplorer.dao.ProductDao;
import com.org.productexplorer.entity.Product;

@Service
public class ProductService {
   
	 @Autowired
	    private ProductDao productDao;

	    public Product create(Product product) {
	        return productDao.save(product);
	    }

	    public List<Product> getAll() {
	        return productDao.findAll();
	    }

	    public Product getById(Long id) {
	        return productDao.findById(id).orElse(null);
	    }

	    public Product update(Long id, Product product) {
	        Product existing = getById(id);
	        if (existing != null) {
	            product.setId(id);
	            return productDao.save(product);
	        }
	        return null;
	    }

	    public void delete(Long id) {
	        productDao.deleteById(id);
	    }

	    public List<Product> findByCategoryId(Long categoryId) {
	        return productDao.findByCategoryId(categoryId);
	    }
}
