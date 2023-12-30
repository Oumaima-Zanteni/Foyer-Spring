package com.example.foyerspring.DAO.Repositories;

import com.example.foyerspring.DAO.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository <Reservation,String> {
 List<Reservation> getReservationByChambre_IdChambre(long idChambre);
 List<Reservation> getReservationByEstValide(boolean estValide);

}
