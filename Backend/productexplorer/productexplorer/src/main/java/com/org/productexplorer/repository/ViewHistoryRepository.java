package com.org.productexplorer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.productexplorer.entity.ViewHistory;

public interface ViewHistoryRepository extends JpaRepository<ViewHistory, Long>{
	List<ViewHistory> findBySessionId(String sessionId);
    List<ViewHistory> findByUserId(String userId);
}
