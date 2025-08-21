package com.quiz.application.service;

import com.quiz.application.model.Questions;
import com.quiz.application.model.Quiz;
import com.quiz.application.repository.QuestionRepository;
import com.quiz.application.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    private final QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Questions> questions=questionRepository.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
         quizRepository.save(quiz);
         return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
