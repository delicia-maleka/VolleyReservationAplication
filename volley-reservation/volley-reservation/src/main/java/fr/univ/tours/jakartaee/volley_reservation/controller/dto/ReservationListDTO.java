package fr.univ.tours.jakartaee.volley_reservation.controller.dto;

import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;

public class ReservationListDTO {
	private Integer idReservation;
	private String nomUtilisateur;
    private String prenomUtilisateur;
    private String date;
    private String heureDebut;
    private Integer duree;

    public ReservationListDTO() {}
    
    public ReservationListDTO(Reservation reservation) {
        this.nomUtilisateur=reservation.getUtilisateur().getNom();
        this.prenomUtilisateur=reservation.getUtilisateur().getPrenom();
        this.date=reservation.getDateReservation().toString(); 
        this.heureDebut=reservation.getHeureDebut().toString();
        this.duree=reservation.getDuree();
        this.idReservation=reservation.getIdReservation();
    }

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public String getDateDebut() {
		return heureDebut;
	}

	public Integer getDuree() {
		return duree;
	}
	
	public Integer idReservation() {
		return idReservation;
	}

	public String getDate() {
		return date;
	}

	public String getHeureDebut() {
		return heureDebut;
	}
	
   
}
