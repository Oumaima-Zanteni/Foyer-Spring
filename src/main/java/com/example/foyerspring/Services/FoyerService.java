package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Bloc;
import com.example.foyerspring.DAO.Entities.Foyer;
import com.example.foyerspring.DAO.Entities.Universite;
import com.example.foyerspring.DAO.Repositories.BlocRepository;
import com.example.foyerspring.DAO.Repositories.FoyerRepository;
import com.example.foyerspring.DAO.Repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{

    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    UniversiteRepository universiteRepository;

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer editFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long id) {
        return foyerRepository.findById(id).get();
    }

    @Override
    public void deleteById(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer f) {
        foyerRepository.delete(f);
    }

    @Override
    public List<Foyer>findByNomFoyer(String nomFoyer)
    {
        return foyerRepository.findByNomFoyer(nomFoyer);
    }
    @Override
    public List<Foyer> getFoyersByBloc(Bloc bloc) {
        return foyerRepository.findByBloc(bloc);
    }

    @Override
    public Foyer ajoutFoyerEtBloc(Foyer foyer) {
        Foyer f=foyerRepository.save(foyer);
        for (Bloc b:foyer.getBloc()) {
            b.setFoyer(f);
            blocRepository.save(b);
        }
        return f;
    }

    @Override
    public Foyer ajouterFoyerEtAffecteUniversite(Foyer foyer, long idUniversite) {
        Universite uni=universiteRepository.findById(idUniversite).get();
        Foyer fo=foyerRepository.save(foyer);
        uni.setFoyer(fo);
        universiteRepository.save(uni);
        return foyer;
    }
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        if (foyer == null) {
            // Gérer le cas où le foyer n'existe pas, par exemple, en lançant une exception
            return null;
        }

        List<Universite> universites = universiteRepository.findByNomUniversite(nomUniversite);
        if (universites.isEmpty()) {
            // Gérer le cas où l'université n'existe pas, par exemple, en lançant une exception
            return null;
        }

        // Vous devez choisir l'université appropriée ici, par exemple, en prenant la première de la liste.
        Universite universite = universites.get(0);

        universite.setFoyer(foyer); // Assurez-vous que la relation est correctement configurée dans vos entités
        universiteRepository.save(universite); // Assurez-vous que vous avez correctement configuré la cascade

        return universite;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if (universite == null) {
            // Gérer le cas où l'université n'existe pas, par exemple, en lançant une exception
            return null;
        }

        universite.setFoyer(null); // Désaffectez le foyer en définissant null
        return universiteRepository.save(universite);
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        // Recherchez tous les blocs avec le nom spécifié
        List<Bloc> blocs = blocRepository.findByNomBloc(nomBloc);
        // Recherchez tous les foyers avec le nom spécifié
        List<Foyer> foyers = foyerRepository.findByNomFoyer(nomFoyer);

        // Vous devez choisir le foyer approprié ici, par exemple, en prenant le premier de la liste.
        Foyer foyer = foyers.get(0);

        // Assurez-vous que la relation entre Bloc et Foyer est correctement configurée dans vos entités
        for (Bloc bloc : blocs) {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }

        Bloc bloc= blocs.get(0); // Vous pouvez renvoyer le premier bloc de la liste si nécessaire
        bloc.setFoyer(foyer); // Assurez-vous que la relation est correctement configurée dans vos entités
        blocRepository.save(bloc);
        return bloc;
    }



}
