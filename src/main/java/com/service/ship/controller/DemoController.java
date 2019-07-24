package com.service.ship.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        System.out.println("12");
        return demoRepository.save(demo);
    }
}
