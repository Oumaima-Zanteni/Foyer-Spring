package com.example.foyerspring.RestControllers;

import com.example.foyerspring.DAO.Entities.Reservation;
import com.example.foyerspring.Services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/reservations")
public class ReservationRestController {
    IReservationService iReservationService;

    @GetMapping("/findAllR")
    List<Reservation> findAll(){
        return iReservationService.findAll();
    }

    @PostMapping("/addReservation")
    Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @PutMapping("updateReservation")
    Reservation updateReservation(@RequestBody Reservation r){
        return iReservationService.editReservation(r);
    }

    @DeleteMapping("DeleteReservation/{id}")
    void DeleteReservationByID(@PathVariable("id") String id){
        iReservationService.deleteById(id);
    }

    @DeleteMapping("DeleteReservation")
    void DeleteReservation(@RequestBody Reservation r){
        iReservationService.delete(r);
    }

    @GetMapping("getReservationByChambre/{idChambre}")
    List<Reservation> getReservationByChambre(@PathVariable("idChambre") long idChambre) {
        return iReservationService.getReservationByChambre( idChambre);}

  /*  @PostMapping("ajouterReservation")
    Reservation ajouterReservation(@RequestBody Reservation reservation) {return iReservationService.ajouterReservation(reservation);}*/
}
