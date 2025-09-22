package com.org.productexplorer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.Navigation;

public interface NavigationRepository extends JpaRepository<Navigation, Long>{

	 Navigation findBySlug(String slug);
}
