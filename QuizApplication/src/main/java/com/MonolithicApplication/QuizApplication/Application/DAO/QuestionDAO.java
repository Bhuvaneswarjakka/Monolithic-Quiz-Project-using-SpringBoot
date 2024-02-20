package com.MonolithicApplication.QuizApplication.Application.DAO;

import com.MonolithicApplication.QuizApplication.Application.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>
{
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
//    @Query(value="SELECT * from question q where q.category=:category ORDER BY RANDOM() LIMIT=:numQ", nativeQuery = true)
    List<Question> findRandomQuestionsCategory(String category, int numQ);
}
