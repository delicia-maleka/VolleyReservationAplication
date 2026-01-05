package fr.univ.tours.jakartaee.volley_reservation.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;




public class CreateReservationDTO {
	
	private Integer idReservation;
	private Integer idUtilisateur;
	private Integer idTerrain;
    private LocalDate dateReservation;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String motif;
    
    public CreateReservationDTO() {}
    
	public CreateReservationDTO(Reservation reservation) {
		this.idReservation=reservation.getIdReservation();
		this.idTerrain=reservation.getTerrain().getIdTerrain();
		this.dateReservation=reservation.getDateReservation();
		this.heureDebut=reservation.getHeureDebut();
		this.heureFin=reservation.getHeureFin();
		this.motif=reservation.getMotif();

	}
	public CreateReservationDTO(CreateReservationDTO reservation) {
		this.idReservation=reservation.getIdReservation();
		this.idTerrain=reservation.getIdTerrain();
		this.dateReservation=reservation.getDateReservation();
		this.heureDebut=reservation.getHeureDebut();
		this.heureFin=reservation.getHeureFin();
		this.motif=reservation.getMotif();

	}
	

	public LocalDate getDateReservation() {
		return dateReservation;
	}
	public LocalTime getHeureDebut() {
		return heureDebut;
	}
	public LocalTime getHeureFin() {
		return heureFin;
	}
	public String getMotif() {
		return motif;
	}
	public Integer getIdReservation() {
		return idReservation;
	}


	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}


	public Integer getIdTerrain() {
		return idTerrain;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public void setIdTerrain(Integer idTerrain) {
		this.idTerrain = idTerrain;
	}

	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}


    
    
}
