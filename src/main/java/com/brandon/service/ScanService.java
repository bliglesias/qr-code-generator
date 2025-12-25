package com.brandon.service;

import com.brandon.model.ScanLog;
import com.brandon.repository.ScanLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScanService {

    @Autowired
    private ScanLogRepository scanLogRepository;

    public ScanLog saveScan(String tbaCode) {
        ScanLog scanLog = new ScanLog();
        scanLog.setUserId(1L); // Temporary - no real users yet
        scanLog.setTbaCode(tbaCode);
        return scanLogRepository.save(scanLog);
    }

    public List<ScanLog> getRecentScans() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        return scanLogRepository.findByUserIdAndScannedAtAfter(1L, sevenDaysAgo);
    }
}