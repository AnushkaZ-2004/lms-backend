package com.lms.lecturer.service;

import com.lms.lecturer.model.Lecturer;
import com.lms.lecturer.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private LecturerRepository repository;

    public Lecturer createLecturer(Lecturer lecturer) {
        return repository.save(lecturer);
    }

    public List<Lecturer> getAllLecturers() {
        return repository.findAll();
    }

    public Lecturer getLecturerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Lecturer updateLecturer(Long id, Lecturer data) {
        Lecturer lecturer = repository.findById(id).orElse(null);
        if (lecturer != null) {
            lecturer.setFullName(data.getFullName());
            lecturer.setEmail(data.getEmail());
            lecturer.setDepartment(data.getDepartment());
            return repository.save(lecturer);
        }
        return null;
    }

    public void deleteLecturer(Long id) {
        repository.deleteById(id);
    }
}
