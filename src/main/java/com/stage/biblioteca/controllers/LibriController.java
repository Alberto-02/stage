package com.stage.biblioteca.controllers;


import com.stage.biblioteca.dto.LibriDto;
import com.stage.biblioteca.services.LibriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class LibriController {
    @Autowired
    LibriService libriService;

    //GET ALL
    @GetMapping("Stage/findAll")
    public List<LibriDto> findLibriAll() {
        return libriService.findLibriAll(); }

    //GET BY ID
    @GetMapping("Stage/findById/{idLibro}")
    public ResponseEntity<LibriDto> getIdLibro(@PathVariable(value = "idLibro") Integer idLibro){
        LibriDto ll = libriService.getIdLibro(idLibro);
        return ResponseEntity.status(HttpStatus.OK).body(ll); }

    //GET BY ISBN
    @GetMapping("Stage/cercaLibroIsbn")
    public ResponseEntity<LibriDto> findByIsbn(@PathVariable(value = "isbn") String isbn, @RequestBody LibriDto libriDto){
        LibriDto ll = libriService.cercaLibroIsbn(isbn);
        return ResponseEntity.status(HttpStatus.OK).body(ll);
    }

    //POST Crea Libro
    @PostMapping("Stage/aggiungiCliente")
    public LibriDto createLibro(@RequestBody LibriDto libriDto){
        return libriService.createLibro(libriDto); }

    //PUT Modifica Libro
    @PutMapping("Stage/Update")
    public ResponseEntity<LibriDto> aggiornaLibro(@PathVariable(value = "idLibro") Integer idLibro, @RequestBody LibriDto libriDto) {
        LibriDto cl = libriService.aggiornaLibro(idLibro, libriDto);
        return ResponseEntity.ok(cl);

    }

    //DELETE
    @DeleteMapping("Stage/DELETE/{idLibro}")
    public ResponseEntity<String> deleteLibro(@PathVariable(value = "idLibro") Integer idLibro){
        libriService.deleteLibro(idLibro);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente eliminato");}

}
