package com.lms.student.service;

import com.lms.student.model.Student;
import com.lms.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        // Add email validation
        if (repository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists: " + student.getEmail());
        }
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // New method for pagination that frontend needs
    public Page<Student> getAllStudents(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);

        if (search != null && !search.trim().isEmpty()) {
            // Search in both name and email
            return repository.findByFullNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                    search.trim(), search.trim(), pageable);
        }

        return repository.findAll(pageable);
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = repository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("Student not found with id: " + id);
    }

    public Student updateStudent(Long id, Student studentData) {
        Optional<Student> existingStudent = repository.findById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();

            // Check if email is being changed to one that already exists
            if (!student.getEmail().equals(studentData.getEmail()) &&
                    repository.existsByEmail(studentData.getEmail())) {
                throw new RuntimeException("Email already exists: " + studentData.getEmail());
            }

            student.setFullName(studentData.getFullName());
            student.setEmail(studentData.getEmail());
            student.setRegistrationNo(studentData.getRegistrationNo());
            return repository.save(student);
        }

        throw new RuntimeException("Student not found with id: " + id);
    }

    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        repository.deleteById(id);
    }

    // New method for dashboard stats
    public long getTotalStudentCount() {
        return repository.count();
    }
}