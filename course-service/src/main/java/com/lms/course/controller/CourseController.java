package com.lms.course.controller;

import com.lms.course.model.Course;
import com.lms.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.create(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/lecturer/{lecturerId}")
    public List<Course> getByLecturer(@PathVariable Long lecturerId) {
        return service.getByLecturer(lecturerId);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return service.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
