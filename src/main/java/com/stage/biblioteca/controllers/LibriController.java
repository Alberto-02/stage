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
    @GetMapping("Stage/findAllLibro")
    public List<LibriDto> findLibriAll() {
    return libriService.findLibriAll();
    }

    //GET BY ID
    @GetMapping("Stage/findByIdLibro/{idLibro}")
    public ResponseEntity<LibriDto> getIdLibro(@PathVariable(value = "idLibro") Integer idLibro){
    LibriDto ll = libriService.getIdLibro(idLibro);
    return ResponseEntity.status(HttpStatus.OK).body(ll); }

    //GET BY ISBN
    @GetMapping("Stage/cercaLibroIsbn")
    public LibriDto findByIsbn(@RequestParam String isbn){
        return libriService.cercaLibroIsbn(isbn);
    }

    //POST Crea Libro
    @PostMapping("Stage/aggiungiLibro")
    public LibriDto createLibro(@RequestBody LibriDto libriDto){
    return libriService.createLibro(libriDto); }

    //PUT Aggiorna Libro
    @PutMapping("Stage/UpdateLibro/{idLibro}")
    public ResponseEntity<LibriDto> aggiornaLibro(@PathVariable(value = "idLibro") Integer idLibro, @RequestBody LibriDto libriDto) {
    LibriDto ll = libriService.aggiornaLibro(idLibro, libriDto);
    return ResponseEntity.ok(ll);
    }

    //DELETE
    @DeleteMapping("Stage/DeleteLibro/{idLibro}")
    public void deleteLibro(@PathVariable(value = "idLibro") Integer idLibro){
    libriService.deleteLibro(idLibro);
    }
}
