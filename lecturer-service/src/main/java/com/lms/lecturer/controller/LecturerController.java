package com.lms.lecturer.controller;

import com.lms.lecturer.model.Lecturer;
import com.lms.lecturer.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/lecturers")
public class LecturerController {

    @Autowired
    private LecturerService service;

    @PostMapping
    public Lecturer create(@RequestBody Lecturer lecturer) {
        return service.createLecturer(lecturer);
    }

    @GetMapping
    public List<Lecturer> getAll() {
        return service.getAllLecturers();
    }

    @GetMapping("/{id}")
    public Lecturer get(@PathVariable Long id) {
        return service.getLecturerById(id);
    }

    @PutMapping("/{id}")
    public Lecturer update(@PathVariable Long id, @RequestBody Lecturer lecturer) {
        return service.updateLecturer(id, lecturer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteLecturer(id);
    }
}
