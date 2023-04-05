package com.stage.biblioteca.controllers;


import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.entities.ClientiEntity;
import com.stage.biblioteca.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    //GET ALL
    @GetMapping("Stage/findAll")
    public List<ClientiDto> getall() {
    return clientiService.findClientiAll(); }

    //GET BY ID
    @GetMapping("Stage/findById/{idCliente}")
    public ResponseEntity<Optional<ClientiEntity>> getIdCliente(@PathVariable(value = "idCliente") Integer idCliente){
    Optional<ClientiEntity> cl = clientiService.getIdCliente(idCliente);
    return ResponseEntity.status(HttpStatus.OK).body(cl); }

    //GET BY COGNOME
    @GetMapping
    public ClientiDto cercaCliente(@PathVariable(value = "cognome") String cognome){
        return clientiService.cercaCliente(cognome);
    }

    //POST Crea Cliente
    @PostMapping("Stage/aggiungiCliente")
    public ClientiDto createCliente(@RequestBody ClientiDto clientiDto){
    return clientiService.createCliente(clientiDto); }

    //PUT Aggiorna Cliente
    @PutMapping("Stage/PUT")
    public ResponseEntity<Optional<ClientiDto>> updateCliente(@PathVariable(value = "idCliente") Integer idCliente){
    Optional<ClientiEntity> cl = clientiService.getIdCliente(idCliente);
    return ResponseEntity.status(HttpStatus.OK).body(cl);}

    //DELETE
    @DeleteMapping("Stage/DELETE")
    public ResponseEntity<Optional<ClientiDto>> deleteCliente(@PathVariable(value = "idCliente") Integer idCliente){
    Optional<ClientiEntity> cl = clientiService.getIdCliente(idCliente);
    return ResponseEntity.status(HttpStatus.OK).body(cl);}

}

