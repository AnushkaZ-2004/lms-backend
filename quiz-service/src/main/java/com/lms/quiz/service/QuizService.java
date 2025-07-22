package com.lms.quiz.service;

import com.lms.quiz.model.*;
import com.lms.quiz.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private AttemptRepository attemptRepo;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public List<Quiz> getQuizzesByCourse(Long courseId) {
        return quizRepo.findByCourseId(courseId);
    }

    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    public List<Question> getQuestions(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }

    public Attempt submitAttempt(Long studentId, Long quizId, Map<Long, String> answers) {
        List<Question> questions = questionRepo.findByQuizId(quizId);
        int correct = 0;

        for (Question q : questions) {
            String submittedAnswer = answers.get(q.getId()); // correct way to get from Map<Long, String>
            if (submittedAnswer != null && submittedAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                correct++;
            }
        }

        Attempt attempt = new Attempt();
        attempt.setStudentId(studentId);
        attempt.setQuizId(quizId);
        attempt.setTotalQuestions(questions.size());
        attempt.setCorrectAnswers(correct);
        attempt.setScore((int) ((correct / (double) questions.size()) * 100));

        return attemptRepo.save(attempt);
    }


    public List<Attempt> getAttemptsByStudent(Long studentId) {
        return attemptRepo.findByStudentId(studentId);
    }
}
