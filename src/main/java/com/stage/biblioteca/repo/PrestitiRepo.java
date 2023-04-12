package com.stage.biblioteca.repo;

import com.stage.biblioteca.entities.LibriEntity;
import com.stage.biblioteca.entities.PrestitiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PrestitiRepo extends JpaRepository<PrestitiEntity,Integer> {
    //Optional<PrestitiEntity> LibriDisponibili();
}
