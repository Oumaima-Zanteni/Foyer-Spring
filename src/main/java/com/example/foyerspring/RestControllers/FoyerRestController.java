package com.example.foyerspring.RestControllers;

import com.example.foyerspring.DAO.Entities.Bloc;
import com.example.foyerspring.DAO.Entities.Foyer;
import com.example.foyerspring.DAO.Entities.Universite;
import com.example.foyerspring.DAO.Repositories.BlocRepository;
import com.example.foyerspring.Services.IFoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerRestController {
    IFoyerService iFoyerService;
    BlocRepository blocRepository;

    @GetMapping("findAllF")
    List<Foyer> findAll(){
        return iFoyerService.findAll();
    }

    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }

    @PutMapping("UpdateFoyer")
    Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.editFoyer(f);
    }
    @DeleteMapping("DeleteFoyer")
    void DeleteFoyer(@RequestBody Foyer f){
        iFoyerService.delete(f);
    }


    @GetMapping("/byBloc/{blocId}")
    public List<Foyer> getFoyersByBloc(@PathVariable Long blocId) {
        Bloc bloc = blocRepository.findById(blocId).orElse(null);

        if (bloc == null) {
            return null;
        }

        return iFoyerService.getFoyersByBloc(bloc);
    }
    @PostMapping("/ajoutFoyerEtBloc")
    public Foyer ajoutFoyerEtBloc(@RequestBody Foyer foyer) {
        return iFoyerService.ajoutFoyerEtBloc(foyer);
    }
    @PostMapping("/ajouterFoyerEtAffecteUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecteUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return iFoyerService.ajouterFoyerEtAffecteUniversite(foyer, idUniversite);
    }

    @PostMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return iFoyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @PutMapping("/desaffecterFoyerAUniversite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return iFoyerService.desaffecterFoyerAUniversite(idUniversite);
    }
    @PutMapping("/affecterBlocAFoyer")
    public Bloc affecterBlocAFoyer(@RequestParam String nomBloc, @RequestParam String nomFoyer) {
        return iFoyerService.affecterBlocAFoyer(nomBloc, nomFoyer);
    }




}
