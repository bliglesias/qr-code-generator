package com.brandon.repository;

import com.brandon.model.ScanLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScanLogRepository extends JpaRepository<ScanLog, Long> {
    List<ScanLog> findByUserId(Long userId);
    List<ScanLog> findByUserIdAndScannedAtAfter(Long userId, LocalDateTime date);
    void deleteByScannedAtBefore(LocalDateTime date);
}