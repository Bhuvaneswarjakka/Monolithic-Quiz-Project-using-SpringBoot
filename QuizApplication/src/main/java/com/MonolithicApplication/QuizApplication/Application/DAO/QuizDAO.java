package com.MonolithicApplication.QuizApplication.Application.DAO;

import com.MonolithicApplication.QuizApplication.Application.Models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz, Integer>
{

}
