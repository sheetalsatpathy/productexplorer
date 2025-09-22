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

import com.org.productexplorer.entity.Category;
import com.org.productexplorer.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")

public class CategoryController {
 
	@Autowired
    private CategoryService categoryService; 
	
	@PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category saved = categoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
	@GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> list = categoryService.getAll();
        return ResponseEntity.ok(list);
    }

	@GetMapping("/{id}")
	public ResponseEntity<?> findCategoryById(@PathVariable Long id) {
	    Category category = categoryService.getById(id);
	    if (category == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
	    }
	    return ResponseEntity.ok(category);
	}

    @GetMapping("/navigation/{navigationId}")
    public ResponseEntity<List<Category>> findByNavigation(@PathVariable Long navigationId) {
        List<Category> list = categoryService.findByNavigationId(navigationId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/parent/{parentId}")
    public ResponseEntity<List<Category>> findByParent(@PathVariable Long parentId) {
        List<Category> list = categoryService.findByParentId(parentId);
        return ResponseEntity.ok(list); 
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        Category existing = categoryService.getById(id); 


        if (existing == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }

        // Update fields
        existing.setTitle(updatedCategory.getTitle());
        existing.setSlug(updatedCategory.getSlug());
        existing.setProductCount(updatedCategory.getProductCount());
        existing.setLastScrapedAt(updatedCategory.getLastScrapedAt());
        existing.setNavigation(updatedCategory.getNavigation());
        existing.setParent(updatedCategory.getParent());

        Category saved = categoryService.create(existing); 

        return ResponseEntity.ok(saved);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Category deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found");
        }
    }



}
