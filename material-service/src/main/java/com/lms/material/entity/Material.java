package com.lms.material.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type; // PDF, VIDEO, etc.
    private String url;
    private Long uploadedBy; // lecturer ID
    private Long courseId;
    private LocalDateTime uploadedAt;

    public Material() {}

    public Material(String title, String type, String url, Long uploadedBy, Long courseId, LocalDateTime uploadedAt) {
        this.title = title;
        this.type = type;
        this.url = url;
        this.uploadedBy = uploadedBy;
        this.courseId = courseId;
        this.uploadedAt = uploadedAt;
    }

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Long uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
