package com.stage.biblioteca.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientiController {

    @GetMapping("Stage/GET")
    public String getall(){return "ciao getall";}

    @GetMapping("Stage/GET-id")
    public String getid(){return "ciao getid";}
    @PostMapping("Stage/GET-id")
    public String postid(){return "ciao postid";}
    @PutMapping("Stage/PUT")
    public String putid(){return "ciao putid";}
    @DeleteMapping("Stage/DELETE")
    public String deleleteid(){return "ciao deleteid";}

}

