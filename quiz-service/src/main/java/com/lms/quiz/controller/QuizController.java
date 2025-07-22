package com.lms.quiz.controller;

import com.lms.quiz.dto.QuizSubmissionRequest;
import com.lms.quiz.model.*;
import com.lms.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return service.createQuiz(quiz);
    }

    @GetMapping("/course/{courseId}")
    public List<Quiz> getByCourse(@PathVariable Long courseId) {
        return service.getQuizzesByCourse(courseId);
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question question) {
        return service.addQuestion(question);
    }

    @GetMapping("/{quizId}/questions")
    public List<Question> getQuestions(@PathVariable Long quizId) {
        return service.getQuestions(quizId);
    }

    @PostMapping("/{quizId}/submit/{studentId}")
    public Attempt submitQuiz(@RequestBody QuizSubmissionRequest submission) {
        return service.submitAttempt(
                submission.getStudentId(),
                submission.getQuizId(),
                submission.getAnswers()
        );
    }

    @GetMapping("/attempts/{studentId}")
    public List<Attempt> getAttempts(@PathVariable Long studentId) {
        return service.getAttemptsByStudent(studentId);
    }
}
