package com.org.productexplorer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.ScrapeJob;

public interface ScrapeJobRepository extends JpaRepository<ScrapeJob, Long>{
	
	List<ScrapeJob> findTop10ByStatusOrderByIdAsc(String status);
    boolean existsByTargetUrlAndStatusIn(String targetUrl, List<String> statuses);

}
