package com.stage.biblioteca.dto;

import com.stage.biblioteca.entities.PrestitiEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class ClientiDto {
    @Id
    private Integer idCliente;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private Date dataNascita;
    private List<PrestitiEntity> PrestitiEntityList;

}