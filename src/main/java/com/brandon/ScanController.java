package com.brandon;

import com.brandon.model.ScanLog;
import com.brandon.service.ScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scans")
@CrossOrigin(origins = "*")
public class ScanController {

    @Autowired
    private ScanService scanService;

    @PostMapping
    public ResponseEntity<ScanLog> saveScan(@RequestBody ScanRequest request) {
        // Validate TBA format
        if (!request.getTbaCode().matches("^TBA\\d{12}$")) {
            return ResponseEntity.badRequest().build();
        }

        ScanLog saved = scanService.saveScan(request.getTbaCode());
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<ScanLog>> getScans() {
        List<ScanLog> scans = scanService.getRecentScans();
        return ResponseEntity.ok(scans);
    }

    // Inner class for request body
    static class ScanRequest {
        private String tbaCode;

        public String getTbaCode() { return tbaCode; }
        public void setTbaCode(String tbaCode) { this.tbaCode = tbaCode; }
    }
}