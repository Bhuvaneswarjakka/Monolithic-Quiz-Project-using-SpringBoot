package com.MonolithicApplication.QuizApplication.Application.Service;

import com.MonolithicApplication.QuizApplication.Application.DAO.QuestionDAO;
import com.MonolithicApplication.QuizApplication.Application.DAO.QuizDAO;
import com.MonolithicApplication.QuizApplication.Application.Models.Question;
import com.MonolithicApplication.QuizApplication.Application.Models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService
{
    @Autowired
    QuizDAO quizDAO;
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> CreatingQuiz(String category, int numQ, String title)
    {
        List<Question> questions=questionDAO.findRandomQuestionsCategory(category, numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDAO.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
