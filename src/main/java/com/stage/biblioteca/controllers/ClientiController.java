package com.stage.biblioteca.controllers;

import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientiController {
    @Autowired
    ClientiService clientiService;
    @GetMapping("Stage/GET")
    public List<ClientiDto> getall() {
    return clientiService.findClientiAll(); }

    @GetMapping("Stage/GET-id")
    public String getid(){
    return clientiService.findClientiNome(); }

    @PostMapping("Stage/GET-id")
    public String postid(){return "ciao postid";}

    @PutMapping("Stage/PUT")
    public String putid(){return "ciao putid";}

    @DeleteMapping("Stage/DELETE")
    public String deleleteid(){return "ciao deleteid";}

}

