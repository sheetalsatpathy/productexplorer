package com.org.productexplorer.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.productexplorer.entity.ScrapeJob;
import com.org.productexplorer.repository.ScrapeJobRepository;

@Repository
public class ScrapeJobDao {

	@Autowired
    private ScrapeJobRepository scrapeJobRepository;

    public ScrapeJob save(ScrapeJob job) {
        return scrapeJobRepository.save(job);
    }

    public List<ScrapeJob> findAll() {
        return scrapeJobRepository.findAll();
    }

    public Optional<ScrapeJob> findById(Long id) {
        return scrapeJobRepository.findById(id);
    }

    public void deleteById(Long id) {
        scrapeJobRepository.deleteById(id);
    }
}
