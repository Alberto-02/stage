package com.stage.biblioteca.repo;

import com.stage.biblioteca.dto.LibriDto;
import com.stage.biblioteca.entities.LibriEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibriRepo extends JpaRepository<LibriEntity, Integer> {

    Optional<LibriEntity> findByIsbn(String isbn);
}
