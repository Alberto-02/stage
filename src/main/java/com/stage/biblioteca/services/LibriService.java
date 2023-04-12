package com.stage.biblioteca.services;

import com.stage.biblioteca.dto.LibriDto;
import com.stage.biblioteca.entities.LibriEntity;
import com.stage.biblioteca.mapper.LibriMapper;
import com.stage.biblioteca.repo.LibriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibriService {
    @Autowired
    LibriRepo libriRepo;

    // GET ALL
    public List<LibriDto> findLibriAll(){

        List<LibriDto> responseFindAll = new ArrayList<>();
        libriRepo.findAll().forEach(libri -> { System.out.println(libri.getIdLibro());
            responseFindAll.add( LibriMapper.INSTANCE.modelToDto(libri));
        });
        return responseFindAll;
    }
    //GET BY ID
    public LibriDto getIdLibro(Integer idLibro){
        Optional<LibriEntity> libri = libriRepo.findById(idLibro);
        if(!libri.isPresent()){
            throw new RuntimeException("Libro non trovato");
        }
        LibriEntity libridb = libri.get();

        return LibriMapper.INSTANCE.modelToDto(libridb);
    }

    //GET BY ISBN
    public LibriDto cercaLibroIsbn(String isbn){
        Optional<LibriEntity> libri = libriRepo.findByIsbn(isbn);
        if(!libri.isPresent()){
            throw new RuntimeException("Libro non trovato");
        }
        LibriEntity libridb = libri.get();

        return LibriMapper.INSTANCE.modelToDto(libridb);
    }

    // POST AGGIUNGI LIBRO
    public LibriDto createLibro(LibriDto libriDto){
        LibriEntity libri = LibriMapper.INSTANCE.dtoToModel(libriDto);
        libri = libriRepo.save(libri);
        return LibriMapper.INSTANCE.modelToDto(libri);
    }
    //PUT LIBRO UPDATE
    public LibriDto aggiornaLibro(Integer idLibro, LibriDto libriDto){
        Optional<LibriEntity> libri = libriRepo.findById(idLibro);
        if(!libri.isPresent()){
            throw new RuntimeException("Libro non trovato");
        }
        LibriEntity libridb = libri.get();
        libridb = LibriMapper.INSTANCE.dtoToModel(libriDto);
        libridb.setIdLibro(idLibro);
        libridb = libriRepo.save(libridb);
        return LibriMapper.INSTANCE.modelToDto(libridb);

    }
    // DELETE LIBRO
    public void deleteLibro(Integer idLibro) {
        Optional<LibriEntity> libri = libriRepo.findById(idLibro);
        if (libri.isEmpty()) {
            throw new RuntimeException("Libro non trovato");
        }
        libriRepo.deleteById(idLibro);
    }
}
