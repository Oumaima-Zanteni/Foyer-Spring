package com.example.foyerspring.RestControllers;

import com.example.foyerspring.DAO.Entities.Bloc;
import com.example.foyerspring.DAO.Entities.Universite;
import com.example.foyerspring.Services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteRestController {
    IUniversiteService iUniversiteService;

    @GetMapping("findAllU")
    List<Universite> findAll(){
        return iUniversiteService.findAll();
    }

    @PostMapping("addUniversite")
    Universite addUniversite(@RequestBody Universite u){
        return iUniversiteService.addUniversite(u);
    }

    @PutMapping("updateUniversite")
    Universite updateUniversite(@RequestBody Universite u){
        return iUniversiteService.editUniversite(u);
    }



    @DeleteMapping("DeleteUniversite")
    void DeleteUniversite(@RequestBody Universite u){
        iUniversiteService.delete(u);
    }

    @GetMapping("universite/findByNom")
    public List<Universite>findByNomUniversite(@RequestParam("nomUniversite") String nomUniversite) {
        return iUniversiteService.findByNomUniversite(nomUniversite);
    }
}
