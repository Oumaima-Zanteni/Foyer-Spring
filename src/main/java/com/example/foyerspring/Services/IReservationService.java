package com.example.foyerspring.Services;

import com.example.foyerspring.DAO.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation (Reservation r );

    List<Reservation> addReservations(List<Reservation>reservations);
    Reservation editReservation (Reservation r);

    List<Reservation> findAll();


    Reservation findById(String id);

    void deleteById(String id);

    void delete(Reservation r);

public List<Reservation> getReservationByChambre(long idChambre);
   // public Reservation ajouterReservation(Reservation reservation);
}
