package fr.univ.tours.jakartaee.volley_reservation.controller.dto;



public class ReservationListDTO {

	private Integer idReservation;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String date;
    private String heureDebut;
    private Integer duree;

    public ReservationListDTO() {
    }
    public ReservationListDTO(ReservationListDTO reservation) {
        this.nomUtilisateur=reservation.nomUtilisateur;
        this.prenomUtilisateur=reservation.prenomUtilisateur;
        this.date=reservation.date;
        this.heureDebut=reservation.heureDebut;
        this.duree=reservation.getDuree();
        this.idReservation=reservation.idReservation;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

   

    public Integer getDuree() {
        return duree;
    }

   
    public Integer getIdReservation() {
        return idReservation;
    }
    public String getDate() {
		return date;
	}

	public String getHeureDebut() {
		return heureDebut;
	}
	
}
