package com.example.controller;


import com.example.domain.Admin;
import com.example.util.Res;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping
    public Res login(@RequestBody Admin admin) {

        return new Res();
    }

}
