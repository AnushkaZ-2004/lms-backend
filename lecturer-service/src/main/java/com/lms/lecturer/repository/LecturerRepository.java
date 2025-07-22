package com.lms.lecturer.repository;

import com.lms.lecturer.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    boolean existsByEmail(String email);
}
