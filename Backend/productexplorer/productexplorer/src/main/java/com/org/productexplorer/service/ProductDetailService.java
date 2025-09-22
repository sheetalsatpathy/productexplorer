package com.org.productexplorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.productexplorer.dao.ProductDetailDao;
import com.org.productexplorer.entity.ProductDetail;

@Service
public class ProductDetailService {

	@Autowired 
	private ProductDetailDao productDetailDao;
	
	public ProductDetail create(ProductDetail detail) {
        return productDetailDao.save(detail);
    }
	public List<ProductDetail> getAll() {
        return productDetailDao.findAll();
    }

    public ProductDetail getById(Long id) {
        return productDetailDao.findById(id).orElse(null);
    }

    public ProductDetail update(Long id, ProductDetail detail) {
        ProductDetail existing = getById(id);
        if (existing != null) {
            detail.setId(id);
            return productDetailDao.save(detail);
        }
        return null;
    }

    public void delete(Long id) {
        productDetailDao.deleteById(id);
    }
}
