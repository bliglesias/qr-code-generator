package com.brandon.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scan_logs")
public class ScanLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String tbaCode;

    @Column(nullable = false)
    private LocalDateTime scannedAt;

    @PrePersist
    protected void onCreate() {
        scannedAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTbaCode() { return tbaCode; }
    public void setTbaCode(String tbaCode) { this.tbaCode = tbaCode; }

    public LocalDateTime getScannedAt() { return scannedAt; }
    public void setScannedAt(LocalDateTime scannedAt) { this.scannedAt = scannedAt; }
}