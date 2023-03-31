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
    public List<ClientiDto> findClientiAll(){

        List<ClientiDto> responseFindAll = new ArrayList<>();
        clientirepo.findAll().forEach(cliente -> {
            responseFindAll.add( ClientiMapper.INSTANCE.modelToDto(cliente));
        });
//        ClientiEntity cc = ClientiRepo.findbyId(Integer.decode("1")).get();
        return responseFindAll;
    }

//    public ClientiDto findClientiNome(String nome){
//        List<>
//        return clientirepo.
//    }

}
