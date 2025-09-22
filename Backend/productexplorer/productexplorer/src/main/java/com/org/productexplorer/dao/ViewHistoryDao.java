package com.org.productexplorer.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.productexplorer.entity.ViewHistory;
import com.org.productexplorer.repository.ViewHistoryRepository;

@Repository
public class ViewHistoryDao {
 
	@Autowired
    private ViewHistoryRepository viewHistoryRepository;

    public ViewHistory save(ViewHistory vh) {
        return viewHistoryRepository.save(vh);
    }

    public List<ViewHistory> findAll() {
        return viewHistoryRepository.findAll();
    }

    public Optional<ViewHistory> findById(Long id) {
        return viewHistoryRepository.findById(id);
    }

    public void deleteById(Long id) {
        viewHistoryRepository.deleteById(id);
    }

    public List<ViewHistory> findBySessionId(String sessionId) {
        return viewHistoryRepository.findBySessionId(sessionId);
    }

    public List<ViewHistory> findByUserId(String userId) {
        return viewHistoryRepository.findByUserId(userId);
    }
}
