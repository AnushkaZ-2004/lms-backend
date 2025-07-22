package com.lms.course.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String code;
    private String description;
    private Long lecturerId; // FK from Lecturer Service

    public Course() {}

    public Course(String title, String code, String description, Long lecturerId) {
        this.title = title;
        this.code = code;
        this.description = description;
        this.lecturerId = lecturerId;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Long getLecturerId() { return lecturerId; }

    public void setLecturerId(Long lecturerId) { this.lecturerId = lecturerId; }
}
