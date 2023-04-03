package com.stage.biblioteca.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class LibriDto {

    private Integer idLibro;
    private String isbn;
    private String titolo;
    private String autore;
    private String anno;
    private Date genere;
}
