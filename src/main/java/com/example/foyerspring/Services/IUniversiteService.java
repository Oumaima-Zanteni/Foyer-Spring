package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite (Universite u );


    List<Universite> addUniversites(List<Universite>universites);
    Universite editUniversite (Universite u);

    List<Universite> findAll();

    Universite findById(long id);

    void deleteById(long id);

    void delete(Universite u);
    List<Universite>findByNomUniversite(String nomUniversite);

}
