package com.quiz.application.service;

import com.quiz.application.model.Questions;
import com.quiz.application.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    public List<Questions> getAllQuestion() {
        return questionRepository.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public Questions addQuestions(Questions questions) {
        return questionRepository.save(questions);
    }

    public Questions updateQuestionById(Long id, Questions updatedQuestion) {
        Questions existing = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        existing.setQuestionTitle(updatedQuestion.getQuestionTitle());
        existing.setOption1(updatedQuestion.getOption1());
        existing.setOption2(updatedQuestion.getOption2());
        existing.setOption3(updatedQuestion.getOption3());
        existing.setOption4(updatedQuestion.getOption4());
        existing.setRightAnswer(updatedQuestion.getRightAnswer());
        existing.setCategory(updatedQuestion.getCategory());
        existing.setDifficultyLevel(updatedQuestion.getDifficultyLevel());

        return questionRepository.save(existing);
    }

    public void deleteById(Long id) {
        Questions existingQuestion=questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Resource Not found with this id"+id));
        questionRepository.deleteById(existingQuestion.getId());

    }
}
