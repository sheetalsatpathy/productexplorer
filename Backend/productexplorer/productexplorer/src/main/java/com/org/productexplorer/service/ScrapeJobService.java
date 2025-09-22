package com.org.productexplorer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.productexplorer.dao.ScrapeJobDao;
import com.org.productexplorer.entity.ScrapeJob;

@Service
public class ScrapeJobService {

	@Autowired
    private ScrapeJobDao scrapeJobDao;

    public ScrapeJob create(ScrapeJob job) {
        return scrapeJobDao.save(job);
    }

    public List<ScrapeJob> getAll() {
        return scrapeJobDao.findAll();
    }

    public ScrapeJob getById(Long id) {
        return scrapeJobDao.findById(id).orElse(null);
    }

    public ScrapeJob update(Long id, ScrapeJob job) {
        ScrapeJob existing = getById(id);
        if (existing != null) {
            job.setId(id);
            return scrapeJobDao.save(job);
        }
        return null;
    }

    public void delete(Long id) {
        scrapeJobDao.deleteById(id);
    }
}
