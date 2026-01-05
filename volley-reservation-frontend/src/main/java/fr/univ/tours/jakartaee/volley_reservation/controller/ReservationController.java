package fr.univ.tours.jakartaee.volley_reservation.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.CreateReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.service.ReservationApiClient;



@Controller
@RequestMapping("/home")
public class ReservationController {

    private final ReservationApiClient reservationApiClient;
    
    public ReservationController(ReservationApiClient reservationApiClient) {
    	this.reservationApiClient = reservationApiClient;
    }
    
    @GetMapping
    public String home(Model model) {
        model.addAttribute("ReservationsListe", reservationApiClient.reservationList());
        model.addAttribute("MaReservationsListe",reservationApiClient.getReservationsUtilisateur(1));
        
        return "reservations";
    }
    

    
    @GetMapping("/reservations/detail/{id}")
    public String showReservation(@PathVariable Integer id, Model model) {
        model.addAttribute("reservation", reservationApiClient.getReservation(id));
        return "reservation-detail";
    }
    
    @GetMapping("/reservations/new")
    public String showCreateForm(Model model) {
    	String date= LocalDate.now().toString();
    	model.addAttribute("creneauxTerrain1", reservationApiClient.getCreneauxDisponibles(1, date));
        model.addAttribute("creneauxTerrain2", reservationApiClient.getCreneauxDisponibles(2, date));
        model.addAttribute("creneauxTerrain3", reservationApiClient.getCreneauxDisponibles(3, date));
        model.addAttribute("creneauxTerrain4", reservationApiClient.getCreneauxDisponibles(4, date));
   
        model.addAttribute("edit", false);

        return "form";
    }
    
    @GetMapping("/reservations/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {

        CreateReservationDTO reservation =reservationApiClient.getReservationComplet(id);
        
        model.addAttribute("reservation", new CreateReservationDTO(reservation));
        model.addAttribute("edit", true);

        return "form";
    }

    @PostMapping("/reservations")
    public String createReservation(@RequestParam Integer idUtilisateur, String creneau, @RequestParam String motif) {
    	if (motif == null) {
            throw new IllegalArgumentException("Le motif doit être sélectionné");
        }
    	if (creneau == null) {
            throw new IllegalArgumentException("Le créneau doit être sélectionné");
        }
    	// exp forme creneauChoisi "2|10:00"
    	String[] res = creneau.split("\\|");
    	Integer idTerrain = Integer.parseInt(res[0]);
        LocalTime heureDebut = LocalTime.parse(res[1]);
        
        CreateReservationDTO dto = new CreateReservationDTO();
        dto.setIdUtilisateur(idUtilisateur);
        dto.setIdTerrain(idTerrain);
        dto.setHeureDebut(heureDebut);
        dto.setMotif(motif);
        
    	reservationApiClient.createReservation(dto);
        return "redirect:/home"; 
    }
    
    @PostMapping("/reservations/{id}/edit")
    public String updateReservation(@PathVariable Integer id, CreateReservationDTO dto) {
        reservationApiClient.updateReservation(id, dto);
        return "redirect:/home/reservations/detail/"+id; 
    }

    @PostMapping("/reservations/{id}/delete")
    public String deleteReservation(@PathVariable Integer id) {
        reservationApiClient.deleteReservation(id);
        return "redirect:/home"; 
    }

}
