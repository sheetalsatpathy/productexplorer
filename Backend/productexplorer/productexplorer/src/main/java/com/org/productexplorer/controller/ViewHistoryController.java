package com.org.productexplorer.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.org.productexplorer.entity.ViewHistory;
import com.org.productexplorer.service.ViewHistoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")

public class ViewHistoryController {
 
	@Autowired
    private ViewHistoryService viewHistoryService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ViewHistory vh) {
        ViewHistory saved = viewHistoryService.create(vh);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ViewHistory> list = viewHistoryService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ViewHistory vh = viewHistoryService.getById(id);
        return ResponseEntity.ok(vh);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ViewHistory vh) {
        ViewHistory updated = viewHistoryService.update(id, vh);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        viewHistoryService.delete(id);
        return ResponseEntity.ok("View history deleted successfully");
    }
}
