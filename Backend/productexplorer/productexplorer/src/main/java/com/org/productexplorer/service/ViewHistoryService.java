package com.org.productexplorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.productexplorer.dao.ViewHistoryDao;
import com.org.productexplorer.entity.ViewHistory;

@Service
public class ViewHistoryService {

	@Autowired
	private ViewHistoryDao viewHistoryDao;
	
	public ViewHistory create(ViewHistory vh) {
        return viewHistoryDao.save(vh);
    }

    public List<ViewHistory> getAll() {
        return viewHistoryDao.findAll();
    }

    public ViewHistory getById(Long id) {
        return viewHistoryDao.findById(id).orElse(null);
    }

    public ViewHistory update(Long id, ViewHistory vh) {
        ViewHistory existing = getById(id);
        if (existing != null) {
            vh.setId(id);
            return viewHistoryDao.save(vh);
        }
        return null;
    }

    public void delete(Long id) {
        viewHistoryDao.deleteById(id);
    }

    public List<ViewHistory> findBySessionId(String sessionId) {
        return viewHistoryDao.findBySessionId(sessionId);
    }

    public List<ViewHistory> findByUserId(String userId) {
        return viewHistoryDao.findByUserId(userId);
    }
}
