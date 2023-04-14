package com.stage.biblioteca.controllers;


import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.services.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientiController {
    @Autowired
    ClientiService clientiService;

    //GET ALL
    @GetMapping("Stage/findAllClienti")
    public List<ClientiDto> findAllClienti() {
    return clientiService.findClientiAll();
    }

    //GET BY ID
    @GetMapping("Stage/findByIdCliente/{idCliente}")
    public ResponseEntity<ClientiDto> getIdCliente(@PathVariable(value = "idCliente") Integer idCliente){
    ClientiDto cl = clientiService.getIdCliente(idCliente);
    return ResponseEntity.status(HttpStatus.OK).body(cl); }

    //GET BY COGNOME
    @GetMapping("Stage/cercaCliente")
    public ClientiDto cercaClienteCognome(@RequestParam String cognome){
    return clientiService.cercaClienteCognome(cognome);
    }

    //POST Crea Cliente
    @PostMapping("Stage/aggiungiCliente")
    public ClientiDto createCliente(@RequestBody ClientiDto clientiDto){
    return clientiService.createCliente(clientiDto); }

    //PUT Aggiorna Cliente
    @PutMapping("Stage/UpdateCliente/{idCliente}")
    public ResponseEntity<ClientiDto> aggiornaCliente(@PathVariable(value = "idCliente") Integer idCliente, @RequestBody ClientiDto clientiDto) {
    ClientiDto cl = clientiService.aggiornaCliente(idCliente, clientiDto);
    return ResponseEntity.ok(cl);
    }

    //DELETE
    @DeleteMapping("Stage/DeleteCliente/{idCliente}")
    public void deleteCliente(@PathVariable(value = "idCliente") Integer idCliente) {
    clientiService.deleteCliente(idCliente);
    }
}

