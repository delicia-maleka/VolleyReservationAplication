package fr.univ.tours.jakartaee.volley_reservation.controller.dto;



public class MyReservationDTO {
	private Integer idReservation;
	private String date;
    private String terrain;
    private String heureDebut;
    private String heureFin;
    private String motif;

    public MyReservationDTO() {}

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

