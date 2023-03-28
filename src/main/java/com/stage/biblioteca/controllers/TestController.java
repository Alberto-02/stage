package com.stage.biblioteca.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TestController {
    @GetMapping("ciao")

    public String TestMessage(){
        return "Ciao-ciaO";
    }
}
