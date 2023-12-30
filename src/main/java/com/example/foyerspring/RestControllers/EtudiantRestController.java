package com.example.foyerspring.RestControllers;

import com.example.foyerspring.DAO.Entities.Etudiant;
import com.example.foyerspring.Services.IEtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class EtudiantRestController {
    IEtudiantService iEtudiantService;
    @GetMapping("findAllE")
    List<Etudiant> findAll(){
        return iEtudiantService.findAll();
    }

    @PostMapping("/addEtudiant")
    Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }

    @PutMapping("updateEtudiant")
    Etudiant updateEtudiant(@RequestBody Etudiant e){
        return  iEtudiantService.editEtudiant(e);
    }

    @DeleteMapping("DeleteByIDEtudiant/{id}")
    void DeleteEtudiantByID(@PathVariable("id") long id){
        iEtudiantService.deleteById(id);
    }

    @DeleteMapping("deleteEtudiant")
    void DeleteEtudiant (@RequestBody Etudiant e){
        iEtudiantService.delete(e);
    }

    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> findEtudiantByNomAndPrenom(
            @RequestParam("nomEt") String nomEt,
            @RequestParam("prenomEt") String prenomEt) {
        List<Etudiant> etudiants = iEtudiantService.findEtudiantByNomAndPrenom(nomEt, prenomEt);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/etudiantByCin")
    public ResponseEntity<Etudiant> findEtudiantByCin(@RequestParam("cin") long cin) {
        Etudiant etudiant = iEtudiantService.findEtudiantByCin(cin);
        if (etudiant != null) {
            return ResponseEntity.ok(etudiant);
        } else {
            // Gérer le cas où aucun étudiant avec ce CIN n'a été trouvé
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/etudiantsApresDateNaissance")
    public ResponseEntity<List<Etudiant>> findEtudiantByDateNaissanceAfter(
            @RequestParam("dateNaissance") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateNaissance) {
        List<Etudiant> etudiants = iEtudiantService.findEtudiantByDateNaissanceAfter(dateNaissance);
        return ResponseEntity.ok(etudiants);
    }

    @GetMapping("/etudiantsByEcole")
    public ResponseEntity<List<Etudiant>> findEtudiantsByEcole(@RequestParam("ecole") String ecole) {
        List<Etudiant> etudiants = iEtudiantService.findEtudiantsByEcole(ecole);
        return ResponseEntity.ok(etudiants);
    }





}
