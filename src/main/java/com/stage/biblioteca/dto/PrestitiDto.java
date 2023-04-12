package com.stage.biblioteca.dto;

import com.stage.biblioteca.entities.ClientiEntity;
import com.stage.biblioteca.entities.LibriEntity;
import jakarta.persistence.*;
import lombok.Data;
@Data
public class PrestitiDto {
    private Integer idPrestito;
    private String dataInizio;
    private String dataFine;
    private String dataConsegna;
    private ClientiDto idCliente;
    private LibriDto idLibro;
}
