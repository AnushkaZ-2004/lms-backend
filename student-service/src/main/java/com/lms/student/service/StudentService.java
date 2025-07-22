package com.lms.student.service;

import com.lms.student.model.Student;
import com.lms.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student studentData) {
        Student student = repository.findById(id).orElse(null);
        if (student != null) {
            student.setFullName(studentData.getFullName());
            student.setEmail(studentData.getEmail());
            student.setRegistrationNo(studentData.getRegistrationNo());
            return repository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
