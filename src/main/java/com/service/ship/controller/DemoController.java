package com.service.ship.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.ship.model.Demo;
import com.service.ship.repository.DemoRepository;

@RestController
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @GetMapping("/demos")
    public Page<Demo> getQuestions(Pageable pageable) {
        return demoRepository.findAll(pageable);
    }


    @PostMapping("/demos")
    public Demo createQuestion(@Valid @RequestBody Demo demo) {
        return demoRepository.save(demo);
    }

    @PutMapping("/questions/{questionId}")
    public Demo updateQuestion(@PathVariable Long questionId,
                                   @Valid @RequestBody Demo questionRequest) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    question.setTitle(questionRequest.getTitle());
                    question.setDescription(questionRequest.getDescription());
                    return questionRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }


    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId)
                .map(question -> {
                    questionRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
    }
}
