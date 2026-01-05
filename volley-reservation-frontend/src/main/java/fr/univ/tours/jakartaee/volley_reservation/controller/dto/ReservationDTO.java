package fr.univ.tours.jakartaee.volley_reservation.controller.dto;



public class ReservationDTO {

	private Integer idReservation;
    private String nomUtilisateur;
    private String nomTerrain;
    private String dateDebut;
    private Integer duree;
    private String motif;

    public ReservationDTO() {
    }
    
    public ReservationDTO(ReservationDTO reservation) {
    	
    	this.nomUtilisateur=reservation.getNomUtilisateur();
    	this.nomTerrain=reservation.getNomTerrain();
    	this.dateDebut=reservation.getDateDebut();
    	this.duree=reservation.getDuree();
    	this.motif=reservation.getMotif();
    	this.idReservation= reservation.getIdReservation();
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }


    public String getNomTerrain() {
        return nomTerrain;
    }

   
    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
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
