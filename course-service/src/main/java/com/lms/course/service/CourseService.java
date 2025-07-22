package com.lms.course.service;

import com.lms.course.model.Course;
import com.lms.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course create(Course course) {
        return repository.save(course);
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Course getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Course> getByLecturer(Long lecturerId) {
        return repository.findByLecturerId(lecturerId);
    }

    public Course update(Long id, Course updated) {
        Course course = repository.findById(id).orElse(null);
        if (course != null) {
            course.setTitle(updated.getTitle());
            course.setCode(updated.getCode());
            course.setDescription(updated.getDescription());
            course.setLecturerId(updated.getLecturerId());
            return repository.save(course);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
