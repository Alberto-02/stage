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
public class ClientiService{
    @Autowired
    ClientiRepo clientirepo;
    // GET ALL
    public List<ClientiDto> findClientiAll(){

        List<ClientiDto> responseFindAll = new ArrayList<>();
        clientirepo.findAll().forEach(cliente -> { System.out.println(cliente.getIdCliente());
            responseFindAll.add( ClientiMapper.INSTANCE.modelToDto(cliente));
        });
//        ClientiEntity cc = ClientiRepo.findbyId(Integer.decode("1")).get();
        return responseFindAll;
    }
   //GET BY NOME
    public ClientiDto findClientiNome(){
        List<ClientiDto> responseFindNome = new ArrayList<>();
        clientirepo.findAll().forEach(cliente -> { System.out.println(cliente.getIdCliente());
            responseFindNome.add( ClientiMapper.INSTANCE.modelToDto(cliente));
        });
    }

}
