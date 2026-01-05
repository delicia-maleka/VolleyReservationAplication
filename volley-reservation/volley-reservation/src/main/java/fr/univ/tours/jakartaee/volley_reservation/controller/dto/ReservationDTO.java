package fr.univ.tours.jakartaee.volley_reservation.controller.dto;

import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;

public class ReservationDTO {

	private Integer idReservation;
	private String nomutilisateur;
    private String nomTerrain;
    private String dateDebut; 
    private Integer duree; 
    private String motif;
    
    public ReservationDTO() {}
    public ReservationDTO(Reservation reservation) {
    	this.nomutilisateur=reservation.getUtilisateur().getNom();
    	this.nomTerrain=reservation.getTerrain().getNom();
    	this.dateDebut=reservation.getDateReservation()+" : "+reservation.getHeureDebut();
    	this.duree=reservation.getDuree();
    	this.motif=reservation.getMotif();
    	this.idReservation=reservation.getIdReservation();
    }
	public String getNomutilisateur() {
		return nomutilisateur;
	}
	public String getNomTerrain() {
		return nomTerrain;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public Integer getDuree() {
		return duree;
	}
	public String getMotif() {
		return motif;
	}
	public Integer getIdReservation() {
		return idReservation;
	}
    
}
