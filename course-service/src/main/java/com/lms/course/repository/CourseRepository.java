package com.lms.course.repository;

import com.lms.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByLecturerId(Long lecturerId);
}
