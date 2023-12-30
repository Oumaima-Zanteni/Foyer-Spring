package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Foyer;
import com.example.foyerspring.DAO.Entities.Universite;
import com.example.foyerspring.DAO.Repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
@Builder
@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService {

    UniversiteRepository universiteRepository;

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public List<Universite> addUniversites(List<Universite> universites) {
        return universiteRepository.saveAll(universites);
    }

    @Override
    public Universite editUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findById(long id) {
        return universiteRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public void delete(Universite u) {
        universiteRepository.delete(u);
    }
    @Override
    public List<Universite>findByNomUniversite(String nomUniversite)
    {
        return universiteRepository.findByNomUniversite(nomUniversite);
    }

}
