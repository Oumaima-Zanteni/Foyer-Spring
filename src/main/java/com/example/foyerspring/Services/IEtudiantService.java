package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Etudiant;

import java.time.LocalDate;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant (Etudiant e );


    List<Etudiant> addEtudiants(List<Etudiant>etudiants);
    Etudiant editEtudiant (Etudiant e);

    List<Etudiant> findAll();

    Etudiant findById(long id);

    void deleteById(long id);

    void delete(Etudiant e);
    List<Etudiant> findEtudiantByNomAndPrenom(String nomEt, String prenomEt);

    Etudiant findEtudiantByCin(long cin);

    List<Etudiant> findEtudiantByDateNaissanceAfter(LocalDate date);

    List<Etudiant> findEtudiantsByEcole(String ecole);



}
