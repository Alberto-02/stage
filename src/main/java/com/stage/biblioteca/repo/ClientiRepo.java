package com.stage.biblioteca.repo;


import com.stage.biblioteca.entities.ClientiEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientiRepo extends JpaRepository<ClientiEntity,Integer> {

}
