package com.lms.submission.service;

import com.lms.submission.model.Submission;
import com.lms.submission.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository repository;

    public Submission submitAssignment(Submission submission) {
        submission.setSubmittedAt(LocalDateTime.now());
        return repository.save(submission);
    }

    public List<Submission> getAll() {
        return repository.findAll();
    }

    public List<Submission> getByAssignment(Long assignmentId) {
        return repository.findByAssignmentId(assignmentId);
    }

    public List<Submission> getByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    public Submission reviewSubmission(Long id, Integer marks, String feedback) {
        Submission submission = repository.findById(id).orElse(null);
        if (submission != null) {
            submission.setMarks(marks);
            submission.setFeedback(feedback);
            return repository.save(submission);
        }
        return null;
    }

    public Submission get(Long id) {
        return repository.findById(id).orElse(null);
    }
}
