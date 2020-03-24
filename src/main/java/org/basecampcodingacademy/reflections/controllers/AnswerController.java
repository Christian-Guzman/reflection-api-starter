package org.basecampcodingacademy.reflections.controllers;

import org.basecampcodingacademy.reflections.db.AnswerRepository;
import org.basecampcodingacademy.reflections.domain.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AnswerController {
    @Autowired
    public AnswerRepository answers;

    @GetMapping("/responses/{questionId}/answers")
    public List<Answer> index() {
        return answers.all();
    }

    @PostMapping("/responses/{questionId}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public Answer create(@RequestBody Answer answer, @PathVariable Integer questionId){
        answer.questionId = questionId;
        return answers.create(answer);
    }

    @PatchMapping("/answers/{id}")
    public Answer update(@PathVariable Integer id, @RequestBody Answer answer) {
        answer.id = id;
        return answers.update(answer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        answers.delete(id);
    }


}