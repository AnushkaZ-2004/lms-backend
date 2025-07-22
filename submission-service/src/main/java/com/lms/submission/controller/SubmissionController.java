package com.lms.submission.controller;

import com.lms.submission.model.Submission;
import com.lms.submission.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService service;

    @PostMapping
    public Submission submit(@RequestBody Submission submission) {
        return service.submitAssignment(submission);
    }

    @GetMapping
    public List<Submission> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Submission get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<Submission> getByAssignment(@PathVariable Long assignmentId) {
        return service.getByAssignment(assignmentId);
    }

    @GetMapping("/student/{studentId}")
    public List<Submission> getByStudent(@PathVariable Long studentId) {
        return service.getByStudent(studentId);
    }

    @PutMapping("/{id}/review")
    public Submission review(@PathVariable Long id,
                             @RequestParam Integer marks,
                             @RequestParam String feedback) {
        return service.reviewSubmission(id, marks, feedback);
    }
}
