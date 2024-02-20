package com.MonolithicApplication.QuizApplication.Application.Controllers;

import com.MonolithicApplication.QuizApplication.Application.Models.Question;
import com.MonolithicApplication.QuizApplication.Application.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }
//    @PostMapping("addQuestion")
//    public Question saveQuestion(@RequestBody Question question)
//    {
//        return questionService.saveQuestion(question);
//    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Question>> FindQuestionsByCategory(@PathVariable("cat") String category)
    {
        return questionService.FindQuestionsByCategory(category);
    }


    //How to add a question to a database
    @PostMapping("Questionadding")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    //how to delete data from database
    @DeleteMapping("DeleteData")
    public ResponseEntity<String> deleteQuestion(@RequestBody Question question)
    {
        return questionService.deleteQuestion(question);
    }

    //how to update data in a database
    @PatchMapping("UpdataData")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {
        return questionService.updateQuestion(question);
    }
}
