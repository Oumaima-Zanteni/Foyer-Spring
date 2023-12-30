package com.example.foyerspring.DAO.Repositories;

import com.example.foyerspring.DAO.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EtudiantRepository extends JpaRepository <Etudiant,Long> {
    List<Etudiant> findEtudiantByNomEtAndPrenomEt(String nomEt, String prenomEt);

    Etudiant findEtudiantByCin(long cin);

    List<Etudiant> findEtudiantByDateNaissanceAfter(LocalDate date);

    List<Etudiant> findEtudiantsByEcole(String ecole);



}
