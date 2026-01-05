package fr.univ.tours.jakartaee.volley_reservation.repositorie;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByUtilisateur_IdUtilisateur(Integer utilisateurId);
	List<Reservation> findAll();
	List<Reservation> findByTerrain_IdTerrainAndDateReservation(Integer terrainid, LocalDate date);
	
}
