package com.lms.announcement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId; // Can be null for global
    private String title;
    private String message;
    private String postedByRole; // "ADMIN" or "LECTURER"
    private Long postedById;

    private LocalDateTime postedAt;

    public Announcement() {}

    public Announcement(Long courseId, String title, String message, String postedByRole, Long postedById, LocalDateTime postedAt) {
        this.courseId = courseId;
        this.title = title;
        this.message = message;
        this.postedByRole = postedByRole;
        this.postedById = postedById;
        this.postedAt = postedAt;
    }

    // Getters & Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getCourseId() { return courseId; }

    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public String getPostedByRole() { return postedByRole; }

    public void setPostedByRole(String postedByRole) { this.postedByRole = postedByRole; }

    public Long getPostedById() { return postedById; }

    public void setPostedById(Long postedById) { this.postedById = postedById; }

    public LocalDateTime getPostedAt() { return postedAt; }

    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }
}
