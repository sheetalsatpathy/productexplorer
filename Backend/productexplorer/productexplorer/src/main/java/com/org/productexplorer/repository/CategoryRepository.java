package com.org.productexplorer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	    List<Category> findByNavigationId(Long navigationId);
	    List<Category> findByParentId(Long parentId);
}
