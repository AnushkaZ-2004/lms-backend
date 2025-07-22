package com.lms.assignment.service;

import com.lms.assignment.model.Assignment;
import com.lms.assignment.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository repository;

    public Assignment create(Assignment assignment) {
        return repository.save(assignment);
    }

    public List<Assignment> getAll() {
        return repository.findAll();
    }

    public Assignment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Assignment> getByCourse(Long courseId) {
        return repository.findByCourseId(courseId);
    }

    public Assignment update(Long id, Assignment updated) {
        Assignment assignment = repository.findById(id).orElse(null);
        if (assignment != null) {
            assignment.setTitle(updated.getTitle());
            assignment.setDescription(updated.getDescription());
            assignment.setDueDate(updated.getDueDate());
            assignment.setCourseId(updated.getCourseId());
            return repository.save(assignment);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
