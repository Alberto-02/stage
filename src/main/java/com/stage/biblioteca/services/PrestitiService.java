package com.stage.biblioteca.services;

import com.stage.biblioteca.dto.PrestitiDto;
import com.stage.biblioteca.entities.PrestitiEntity;
import com.stage.biblioteca.mapper.PrestitiMapper;
import com.stage.biblioteca.repo.PrestitiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PrestitiService {
    @Autowired
    PrestitiRepo prestitiRepo;

    //GET ALL
    public List<PrestitiDto> findPrestitiAll(){
        List<PrestitiDto> responseFindAll = new ArrayList<>();
        prestitiRepo.findAll().forEach(prestiti -> {
        responseFindAll.add(PrestitiMapper.INSTANCE.modelToDto(prestiti));
        });
        return responseFindAll;
    }

//    //LIBRI DISPONIBILI
//    public List<PrestitiDto> libriDisponibili(){
//        List<PrestitiDto> responseFindAll = new ArrayList<>();
//        prestitiRepo.findBy(Integer).forEach(prestiti -> {System.out.println(prestiti.getIdPrestito());
//            responseFindAll.add(PrestitiMapper.INSTANCE.modelToDto(prestiti));
//        });
//        return responseFindAll;
//    }

    //CREA PRESTITO
    public PrestitiDto creaPrestito(PrestitiDto prestitiDto){
        PrestitiEntity prestiti = PrestitiMapper.INSTANCE.dtoToModel(prestitiDto);
        prestiti = prestitiRepo.save(prestiti);
        return PrestitiMapper.INSTANCE.modelToDto(prestiti);
    }


}
