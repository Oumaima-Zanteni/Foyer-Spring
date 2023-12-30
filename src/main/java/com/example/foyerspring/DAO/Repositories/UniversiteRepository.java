package com.example.foyerspring.DAO.Repositories;

import com.example.foyerspring.DAO.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    List<Universite> findByNomUniversite(String nomUniversite);
}
