package com.stage.biblioteca.controllers;

import com.stage.biblioteca.dto.PrestitiDto;
import com.stage.biblioteca.repo.ClientiRepo;
import com.stage.biblioteca.repo.LibriRepo;
import com.stage.biblioteca.repo.PrestitiRepo;
import com.stage.biblioteca.services.PrestitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class PrestitiController {
    @Autowired
    PrestitiService prestitiService;
    @Autowired
    private ClientiRepo clientiRepo;
    @Autowired
    private LibriRepo libriRepo;

    //GET ALL
    @GetMapping("Stage/findAllPrestiti")
    public List<PrestitiDto> getAllPrestiti(){
    return prestitiService.findPrestitiAll();
    }

    //LIBRI DISPONIBILI
//    @PostMapping("Stage/libriDisponibili")
//    public List<PrestitiDto> libriDisponibili(){
//    return prestitiService.findPrestitiAll();
//    }

    //CREA PRESTITO
    @PostMapping("Stage/creaOrdine")
    public PrestitiDto creaPrestito(@RequestBody PrestitiDto prestitiDto){
        return prestitiService.creaPrestito(prestitiDto);
    }

}
