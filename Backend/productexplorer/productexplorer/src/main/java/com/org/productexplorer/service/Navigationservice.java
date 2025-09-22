package com.org.productexplorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.productexplorer.dao.NavigationDao;
import com.org.productexplorer.entity.Navigation;

@Service
public class Navigationservice {
 
	 @Autowired
	    private NavigationDao navigationDao;

	    public Navigation create(Navigation nav) {
	        return navigationDao.save(nav);
	    }

	    public List<Navigation> getAll() {
	        return navigationDao.findAll();
	    }

	    public Navigation getById(Long id) {
	        return navigationDao.findById(id).orElse(null);
	    }

	    public Navigation update(Long id, Navigation updatedNav) {
	        return navigationDao.findById(id).map(existing -> {
	            existing.setTitle(updatedNav.getTitle());
	            existing.setSlug(updatedNav.getSlug());
	            existing.setLastScrapedAt(updatedNav.getLastScrapedAt());
	            return navigationDao.save(existing);
	        }).orElse(null);
	    }

	    public boolean delete(Long id) {
	        return navigationDao.findById(id).map(existing -> {
	            navigationDao.delete(existing);
	            return true;
	        }).orElse(false);
	    }
}
