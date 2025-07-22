package com.lms.assignment.controller;

import com.lms.assignment.model.Assignment;
import com.lms.assignment.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService service;

    @PostMapping
    public Assignment create(@RequestBody Assignment assignment) {
        return service.create(assignment);
    }

    @GetMapping
    public List<Assignment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Assignment get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Assignment> getByCourse(@PathVariable Long courseId) {
        return service.getByCourse(courseId);
    }

    @PutMapping("/{id}")
    public Assignment update(@PathVariable Long id, @RequestBody Assignment assignment) {
        return service.update(id, assignment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
