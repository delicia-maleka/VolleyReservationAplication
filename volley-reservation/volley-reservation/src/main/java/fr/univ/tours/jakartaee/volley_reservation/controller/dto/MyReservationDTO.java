package fr.univ.tours.jakartaee.volley_reservation.controller.dto;

import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;

public class MyReservationDTO {
	private Integer idReservation;
	private String date;
	private String terrain;
    private String heureDebut;
    private String heureFin;
    private String motif;

    public MyReservationDTO() {}
    public MyReservationDTO(Reservation reservation) {
    	this.date=reservation.getDateReservation().toString();
        this.terrain = reservation.getTerrain().getNom(); 
        this.heureDebut = reservation.getHeureDebut().toString();
        this.heureFin = reservation.getHeureFin().toString();
        this.motif = reservation.getMotif();
        this.idReservation=reservation.getIdReservation();
    }
    public MyReservationDTO(MyReservationDTO reservation) {
    	this.date=reservation.getDate();
        this.terrain = reservation.getTerrain();
        this.heureDebut = reservation.getHeureDebut();
        this.heureFin = reservation.getHeureFin();
        this.motif = reservation.getMotif();
        this.idReservation= reservation.getIdReservation();
    }
    
	public String getTerrain() {
		return terrain;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public String getMotif() {
		return motif;
	}
	public String getDate() {
		return date;
	}
	public Integer getIdReservation() {
		return idReservation;
	}
    
}
