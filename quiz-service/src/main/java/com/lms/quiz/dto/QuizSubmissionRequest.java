package com.lms.quiz.dto;

import java.util.Map;

public class QuizSubmissionRequest {
    private Long quizId;
    private Long studentId;
    private Map<Long, String> answers; // Map<QuestionId, Answer>

    // Getters and Setters

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
