package fr.univ.tours.jakartaee.volley_reservation.repositorie;

import fr.univ.tours.jakartaee.volley_reservation.model.Utilisateur;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// je vais pouvoir acceder a la BD (ajout,supression,update) sans ecrire le sql a la main 
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

	
}
