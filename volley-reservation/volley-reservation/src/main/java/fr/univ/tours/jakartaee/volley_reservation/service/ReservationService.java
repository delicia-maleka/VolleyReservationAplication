package fr.univ.tours.jakartaee.volley_reservation.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;
import fr.univ.tours.jakartaee.volley_reservation.repositorie.ReservationRepository;

@Service

public class ReservationService {

	
    private final ReservationRepository reservationRepository;

	    public ReservationService(ReservationRepository reservationRepository) {
	        this.reservationRepository = reservationRepository;
	    }

	    public List<Reservation> getReservationsDuTerrainPourLaJournee(Integer idTerrain, LocalDate date) {

	        return reservationRepository.findByTerrain_IdTerrainAndDateReservation(idTerrain, date);
	    }
	    
	    
	    private List<LocalTime> genererCreneaux() {
	        List<LocalTime> creneaux = new ArrayList<>();

	        for (int heure = 10; heure < 22; heure += 2) {
	            creneaux.add(LocalTime.of(heure, 0));
	        }

	        return creneaux;
	    }
	    
	    public List<LocalTime> getCreneauxDisponibles(Integer terrainId, LocalDate date) {

	        List<Reservation> reservations = getReservationsDuTerrainPourLaJournee(terrainId, date);
	        List<LocalTime> heuresPrises = new ArrayList<>();
	        
	        for (Reservation r : reservations) {
	            heuresPrises.add(r.getHeureDebut());
	        }

	        List<LocalTime> creneaux=genererCreneaux();
	        creneaux.removeAll(heuresPrises);
	       
	        return creneaux;

	    }

	    
}
