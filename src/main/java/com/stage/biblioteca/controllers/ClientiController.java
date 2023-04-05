package com.stage.biblioteca.controllers;


import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.entities.ClientiEntity;
import com.stage.biblioteca.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientiController {
    @Autowired
    ClientiService clientiService;
    @GetMapping("Stage/findAll")
    public List<ClientiDto> getall() {
    return clientiService.findClientiAll(); }
    @GetMapping("Stage/findById/{idCliente}")
    public ResponseEntity<Optional<ClientiEntity>> getIdCliente(@PathVariable(value = "idCliente") Integer idCliente){
    Optional<ClientiEntity> cl = clientiService.getIdCliente(idCliente);
    return ResponseEntity.status(HttpStatus.OK).body(cl); }
    @PostMapping("Stage/aggiungiCliente")
    public ClientiDto createCliente(@RequestBody ClientiDto clientiDto){
    return clientiService.createCliente(clientiDto); }

    @PutMapping("Stage/PUT")
    public String putid(){return "ciao putid";}

    @DeleteMapping("Stage/DELETE")
    public String deleleteid(){return "ciao deleteid";}

}

