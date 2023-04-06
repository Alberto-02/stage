package com.stage.biblioteca.services;

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
        return responseFindAll;
    }
   //GET BY ID
    public ClientiDto getIdCliente(Integer idCliente){
        Optional<ClientiEntity> clienti = clientirepo.findById(idCliente);
        if(!clienti.isPresent()){
            throw new RuntimeException("Cliente non trovato");
        }
        ClientiEntity clientidb = clienti.get();

        return ClientiMapper.INSTANCE.modelToDto(clientidb);
    }

    //GET BY COGNOME
    public ClientiDto cercaClienteCognome(String cognome){
        Optional<ClientiEntity> clienti = clientirepo.findByCognome(cognome);
        if(!clienti.isPresent()){
            throw new RuntimeException("Cliente non trovato");
        }
        ClientiEntity clientidb = clienti.get();

        return ClientiMapper.INSTANCE.modelToDto(clientidb);
    }
    // POST AGGIUNGI CLIENTE
   public ClientiDto createCliente(ClientiDto clientiDto){
       ClientiEntity clienti = ClientiMapper.INSTANCE.dtoToModel(clientiDto);
       clienti = clientirepo.save(clienti);
       return ClientiMapper.INSTANCE.modelToDto(clienti);
   }
   //PUT CLIENTE UPDATE
    public ClientiDto aggiornaCliente(Integer idCLiente, ClientiDto clientiDto){
        Optional<ClientiEntity> clienti = clientirepo.findById(idCLiente);
        if(!clienti.isPresent()){
            throw new RuntimeException("Cliente non trovato");
        }
        ClientiEntity clientidb = clienti.get();
        clientidb = ClientiMapper.INSTANCE.dtoToModel(clientiDto);
        clientidb.setIdCliente(idCLiente);
        clientidb = clientirepo.save(clientidb);
        return ClientiMapper.INSTANCE.modelToDto(clientidb);

    }
   // DELETE CLIENTE
    public void deleteCliente(Integer idCliente) {
        Optional<ClientiEntity> clienti = clientirepo.findById(idCliente);
        if (clienti.isEmpty()) {
            throw new RuntimeException("Cliente non trovato");
        }
        clientirepo.deleteById(idCliente);
    }

}
