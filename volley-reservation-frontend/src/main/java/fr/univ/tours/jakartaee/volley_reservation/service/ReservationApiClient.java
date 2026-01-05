package fr.univ.tours.jakartaee.volley_reservation.service;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.univ.tours.jakartaee.volley_reservation.controller.dto.CreateReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.MyReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.ReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.ReservationListDTO;


@Service
public class ReservationApiClient {


    private final RestTemplate restTemplate;

    
    public ReservationApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    

    public List<LocalTime> getCreneauxDisponibles(Integer id_terrain, String date) {
        LocalTime[] creneaux = restTemplate.getForObject("http://localhost:8080/home/reservations/terrain/"+ id_terrain+"/date/"+date,LocalTime[].class);
        List<LocalTime> res = new ArrayList<>();
        
        if (creneaux != null) {
            res.addAll(Arrays.asList(creneaux));
        }
        return res;
    }
    
    
    
	public List<ReservationListDTO> reservationList() {
    	ReservationListDTO[] reservations = restTemplate.getForObject("http://localhost:8080/home", ReservationListDTO[].class);
    	
    	List<ReservationListDTO> res = new ArrayList<>();
        
        if (reservations != null) {
            res.addAll(Arrays.asList(reservations));
        }
    	return res;
    }
    
   
    public List<MyReservationDTO> getReservationsUtilisateur(Integer id) {
        MyReservationDTO[] reservations = restTemplate.getForObject("http://localhost:8080/home/reservations/user/" + id,MyReservationDTO[].class);
        List<MyReservationDTO> res = new ArrayList<>();
        if (reservations != null) {
            res.addAll(Arrays.asList(reservations));
        }
        return res;
    }

    public ReservationDTO getReservation(Integer id) {
        return restTemplate.getForObject("http://localhost:8080/home/reservations/detail/" + id, ReservationDTO.class);
    }
    public CreateReservationDTO getReservationComplet(Integer id) {
        return restTemplate.getForObject("http://localhost:8080/home/reservations/detail/complet/" + id, CreateReservationDTO.class);
    }
    
    public void createReservation(CreateReservationDTO dto) {
        restTemplate.postForLocation("http://localhost:8080/home/reservations", dto);
    }
    
    public void updateReservation(Integer id, CreateReservationDTO dto) {
        restTemplate.put("http://localhost:8080/home/reservations/" + id, dto);
    }
    
    public void deleteReservation(Integer id) {
        restTemplate.delete("http://localhost:8080/home/reservations/" + id);
    }

    
}
