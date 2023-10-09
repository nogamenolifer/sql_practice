package com.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class BookController {

    @GetMapping
    public String getById() {
        System.out.println("login success");
        return "springboot";
    }

}
