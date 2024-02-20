package com.MonolithicApplication.QuizApplication.Application.Service;


import com.MonolithicApplication.QuizApplication.Application.DAO.QuestionDAO;
import com.MonolithicApplication.QuizApplication.Application.Models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        try{
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
//    public Question saveQuestion(Question question)
//    {
//        return questionDAO.save(question);
//    }

    public ResponseEntity<List<Question>> FindQuestionsByCategory(String category)
    {
        try{
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question)
    {
        try
        {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Question question)
    {
        try
        {
            questionDAO.delete(question);
            return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not Deleted", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Question> updateQuestion(Question question)
    {
        try
        {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
}
