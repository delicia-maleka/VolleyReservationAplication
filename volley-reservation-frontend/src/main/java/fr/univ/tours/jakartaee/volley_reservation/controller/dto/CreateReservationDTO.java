package fr.univ.tours.jakartaee.volley_reservation.controller.dto;


import java.time.LocalDate;
import java.time.LocalTime;

public class CreateReservationDTO {

    private Integer idReservation;
    private Integer idUtilisateur;
    private Integer idTerrain;
    private LocalDate dateReservation;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String motif;
    public CreateReservationDTO() {
    }
   
	public CreateReservationDTO(CreateReservationDTO reservation) {
		this.idReservation=reservation.getIdReservation();
		this.dateReservation=reservation.getDateReservation();
		this.heureDebut=reservation.getHeureDebut();
		this.heureFin=reservation.getHeureFin();
		this.motif=reservation.getMotif();

		
	}
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(Integer idTerrain) {
        this.idTerrain = idTerrain;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) { 
    	this.motif = motif; 
    }
    
    

}
