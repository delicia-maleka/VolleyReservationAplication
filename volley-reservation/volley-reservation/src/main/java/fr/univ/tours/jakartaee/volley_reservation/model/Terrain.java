package fr.univ.tours.jakartaee.volley_reservation.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "terrain")
public class Terrain {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_terrain")
    private Integer idTerrain;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "type", nullable = false, length = 50)
    private String type;

    
    @OneToMany(mappedBy = "terrain")
    private List<Reservation> reservations;

    
    public Integer getIdTerrain() {
        return idTerrain;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
