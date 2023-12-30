package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Etudiant;
import com.example.foyerspring.DAO.Repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Builder
@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService {
    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant editEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(long id) {
        return etudiantRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public void delete(Etudiant e) {
        etudiantRepository.delete(e);

    }

    @Override
    public List<Etudiant> findEtudiantByNomAndPrenom(String nomEt, String prenomEt) {
        return etudiantRepository.findEtudiantByNomEtAndPrenomEt(nomEt, prenomEt);
    }
    @Override
    public Etudiant findEtudiantByCin(long cin) {
        return etudiantRepository.findEtudiantByCin(cin);
    }
    @Override
    public List<Etudiant> findEtudiantByDateNaissanceAfter(LocalDate date) {
        return etudiantRepository.findEtudiantByDateNaissanceAfter(date);
    }

    @Override
    public List<Etudiant> findEtudiantsByEcole(String ecole) {
        return etudiantRepository.findEtudiantsByEcole(ecole);
    }


}
