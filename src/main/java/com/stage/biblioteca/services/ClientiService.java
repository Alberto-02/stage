package com.stage.biblioteca.services;

import com.stage.biblioteca.mapper.ClientiMapper;
import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.entities.ClientiEntity;
import com.stage.biblioteca.repo.ClientiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientiService {

    @Autowired
    ClientiRepo clientirepo;
    public List<ClientiDto> findLibriAll(){

        List<ClientiDto> responseFindAll = new ArrayList<>();
        clientirepo.findAll().foreach(libro ->
            responseFindAll.add( ClientiMapper.ISTANCE.todto(ClientiEntity));
        });
        ClientiEntity ll = ClientiRepo.findBy( Integer.decode());
        return responseFindAll;
    }

    public ClientiDto findClientiNome(String nome){
        List<>
        return clientirepo
    }

}
