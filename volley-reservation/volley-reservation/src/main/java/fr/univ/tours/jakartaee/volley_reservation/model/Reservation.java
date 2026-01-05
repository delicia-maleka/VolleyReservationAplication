package fr.univ.tours.jakartaee.volley_reservation.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import fr.univ.tours.jakartaee.volley_reservation.controller.dto.CreateReservationDTO;

@Entity
@Table(name = "reservation")
public class Reservation {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_reservation")
	    private Integer idReservation;

	    @Column(name = "date_reservation", nullable = false)
	    private LocalDate dateReservation;

	    @Column(name = "heure_debut", nullable = false)
	    private LocalTime heureDebut;

	    @Column(name = "heure_fin", nullable = false)
	    private LocalTime heureFin;

	    @Column(name = "motif", nullable = false, length = 255)
	    private String motif;

	    
	    @ManyToOne
	    @JoinColumn(name = "terrain_id", nullable = false)
	    private Terrain terrain;

	    
	    @ManyToOne
	    @JoinColumn(name = "utilisateur_id", nullable = false)
	    private Utilisateur utilisateur;
	    
	    // construteur vide pour jpa 
	    public Reservation() {}
	    
	    public Reservation(CreateReservationDTO dto) {
	        this.dateReservation=dto.getDateReservation();
	        this.heureDebut=dto.getHeureDebut();
	        this.heureFin=dto.getHeureFin();
	        this.motif=dto.getMotif();
	        
	    }
	    
	    
	    public Integer getIdReservation() {
	        return idReservation;
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

	    public Terrain getTerrain() {
	        return terrain;
	    }

	    public void setTerrain(Terrain terrain) {
	        this.terrain = terrain;
	    }

	    public Utilisateur getUtilisateur() {
	        return utilisateur;
	    }

	    public void setUtilisateur(Utilisateur utilisateur) {
	        this.utilisateur = utilisateur;
	    }
	    
	    public Integer getDuree() {
	        return (heureFin.getHour() - heureDebut.getHour());
	    }

	
}
