package com.quiz.application.repository;

import com.quiz.application.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {
   List<Questions> findByCategory(String category);

   @Query(value = "SELECT * FROM question q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2",nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
