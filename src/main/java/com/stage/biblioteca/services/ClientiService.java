package com.stage.biblioteca.services;

import ch.qos.logback.core.net.server.Client;
import com.stage.biblioteca.mapper.ClientiMapper;
import com.stage.biblioteca.dto.ClientiDto;
import com.stage.biblioteca.entities.ClientiEntity;
import com.stage.biblioteca.repo.ClientiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
   //GET BY ID
    public Optional<ClientiEntity> getIdCliente(Integer idCliente){
     return clientirepo.findById(idCliente);
    }

    //GET BY COGNOME
    public ClientiDto cercaCliente(String cognome){
        return clientirepo.cercaCliente(cognome);
    }
    // POST AGGIUNGI CLIENTE
   public ClientiDto createCliente(ClientiDto clientiDto){
       ClientiEntity clienti = ClientiMapper.INSTANCE.dtoToModel(clientiDto);
       clienti = clientirepo.save(clienti);
       return ClientiMapper.INSTANCE.modelToDto(clienti);
   }
   //PUT CLIENTE update
    public ClientiDto updateCliente(Integer idCLiente, ClientiDto clientiDto){
        Optional<ClientiDto> optionalClienti = clientirepo.findById(idCLiente);
        if(optionalClienti.isEmpty()){
            throw new Exception{
                ("Cliente non trovato");
            }
        }

        ClientiEntity clienti = ClientiMapper.INSTANCE.dtoToModel(clientiDto);
        clienti = clientirepo.save(clienti);
        return ClientiMapper.INSTANCE.modelToDto(clienti);

    }
   // DELETE CLIENTE
    public ClientiDto deleteCliente(Integer idCliente, ClientiDto clientiDto){
        Optional<ClientiDto> optionalCLienti = clientirepo.findById(idCliente);
        if(optionalClienti.isEmpty()){
            throw new Exception("Cliente non trovato")
        }



        return "Cliente eliminato"+idCliente;
    }




}
