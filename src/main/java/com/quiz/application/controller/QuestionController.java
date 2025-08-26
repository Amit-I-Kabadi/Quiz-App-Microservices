package com.quiz.application.controller;

import com.quiz.application.model.Questions;
import com.quiz.application.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<Questions>> getAllQuestion(){
        List<Questions> questions=questionService.getAllQuestion();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionByCategory(@PathVariable String category){
        List<Questions> questions=questionService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/addQuestions")
    public ResponseEntity<Questions> addQuestions(@RequestBody Questions questions){
        Questions questions1=questionService.addQuestions(questions);
        return ResponseEntity.ok(questions);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Questions> updateQuestionById(@PathVariable Long id,@RequestBody Questions updatedQuestion){
        Questions questions=questionService.updateQuestionById(id,updatedQuestion);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        questionService.deleteById(id);
        return ResponseEntity.ok("Question is Deleted with id "+id);
    }
}
