package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Chambre;
import com.example.foyerspring.DAO.Entities.Reservation;
import com.example.foyerspring.DAO.Repositories.ChambreRepository;
import com.example.foyerspring.DAO.Repositories.ReservationRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Builder
@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{

    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> reservations) {
        return reservationRepository.saveAll(reservations);
    }

    @Override
    public Reservation editReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void delete(Reservation r) {
        reservationRepository.delete(r);
    }


    @Override
    public List<Reservation> getReservationByChambre(long idChambre){
    return reservationRepository.getReservationByChambre_IdChambre(idChambre);
    }


   /* @Override

    public Reservation ajouterReservation(Reservation reservation) {
        Optional<Chambre> optionalChambre = chambreRepository.findById(reservation.getChambre().getIdChambre());
        if (optionalChambre.isPresent()) {
            Chambre chambre = optionalChambre.get();
            reservation.setChambre(chambre);

        }
        return reservationRepository.save(reservation);
    }*/
}
