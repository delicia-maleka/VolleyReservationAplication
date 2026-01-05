package fr.univ.tours.jakartaee.volley_reservation.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.tours.jakartaee.volley_reservation.controller.dto.CreateReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.MyReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.ReservationDTO;
import fr.univ.tours.jakartaee.volley_reservation.controller.dto.ReservationListDTO;
import fr.univ.tours.jakartaee.volley_reservation.model.Reservation;
import fr.univ.tours.jakartaee.volley_reservation.model.Terrain;
import fr.univ.tours.jakartaee.volley_reservation.model.Utilisateur;
import fr.univ.tours.jakartaee.volley_reservation.repositorie.ReservationRepository;
import fr.univ.tours.jakartaee.volley_reservation.repositorie.TerrainRepository;
import fr.univ.tours.jakartaee.volley_reservation.repositorie.UtilisateurRepository;
import fr.univ.tours.jakartaee.volley_reservation.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation ;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;


@RestController
@RequestMapping("/home")
public class ReservationController {

	private final ReservationRepository reservationRepository;
	private final TerrainRepository terrainRepository;
	private final UtilisateurRepository utilisateurRepository;
	private final ReservationService reservationService;
	
	public ReservationController(ReservationRepository reservationRepository,TerrainRepository terrainRepository,UtilisateurRepository utilisateurRepository,ReservationService reservationService) {
		this.reservationRepository=reservationRepository;
		this.utilisateurRepository=utilisateurRepository;
		this.terrainRepository=terrainRepository;
		this.reservationService=reservationService;
	}
	
	//Liste Generale (Home)
	@Operation (
            description = "Liste toute les reservations",
            responses = @ApiResponse(responseCode = "200",
                    description = "Liste des reservations",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = ReservationListDTO.class))))
    )
	
	@GetMapping
    public ResponseEntity<List<ReservationListDTO>> reservationList() {

        List<ReservationListDTO> reservations =reservationRepository.findAll().stream().map(ReservationListDTO::new).toList();
        return ResponseEntity.ok(reservations);
    }
	
	// list des reservations de l'utilisteur (Mes Reservations)
	@Operation(
            description = "trouver les reservation d'un utilisateur par son id ", 
            parameters = @Parameter(name = "id", in = PATH, description = "Id_reservation"), 
            responses = {@ApiResponse(responseCode = "200", description = "Reservation found",content = @Content(schema = @Schema(implementation = ReservationDTO.class))),@ApiResponse(responseCode = "404", description = "Reservation not found")}
            )
	
	@GetMapping("/reservations/user/{id}")
    public ResponseEntity<List<MyReservationDTO>> getReservationsUtilisateur(@PathVariable Integer id) {
        return ResponseEntity.ok(reservationRepository.findByUtilisateur_IdUtilisateur(id).stream().map(MyReservationDTO::new).toList());
    }
	
	//detail
	@Operation(
            description = "afficher les details d'une reservation d'un utilisateur ", 
            parameters = @Parameter(name = "id", in = PATH, description = "id_utilisateur "), responses = {@ApiResponse(responseCode = "200", description = "Reservation found",content = @Content(schema = @Schema(implementation = ReservationDTO.class))),@ApiResponse(responseCode = "404", description = "Reservation not found")}
    )
	
	@GetMapping("/reservations/detail/{id}")
	public ResponseEntity<ReservationDTO> getReservation(@PathVariable Integer id) {
	    return ResponseEntity.of(reservationRepository.findById(id).map(ReservationDTO::new));
	}
	@GetMapping("/reservations/detail/complet/{id}")
	public ResponseEntity<CreateReservationDTO> getReservationComplet(@PathVariable Integer id) {
	    return ResponseEntity.of(reservationRepository.findById(id).map(CreateReservationDTO::new));
	}
	
	@Operation(
            description = "nouvelle reservation", 
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "reservation à crée",required = true,content = @Content(schema = @Schema(implementation = CreateReservationDTO.class))),
            responses = {@ApiResponse(responseCode = "201", description = "Reservation crée"),@ApiResponse(responseCode = "400", description = "donnée invalide")}
    )
	@Transactional
	@PostMapping("/reservations")
	public ResponseEntity<Void> createReservation( @RequestBody CreateReservationDTO dto) {
	     	Reservation reservation = new Reservation(dto);
	     	
	     	Utilisateur utilisateur=utilisateurRepository.getReferenceById(dto.getIdUtilisateur());
	     	Terrain terrain=terrainRepository.getReferenceById(dto.getIdTerrain());
	     	reservation.setUtilisateur(utilisateur);
	     	reservation.setTerrain(terrain);
	     	reservation.setDateReservation(LocalDate.now());
		    reservation.setHeureDebut(dto.getHeureDebut());
		    reservation.setHeureFin(reservation.getHeureDebut().plusHours(2));
		    reservation.setMotif(dto.getMotif());
		    reservationRepository.save(reservation);
		    reservationRepository.save(reservation);
		    return ResponseEntity.created(URI.create("/reservations/" + reservation.getIdReservation())).build();
	}
	
	 @Operation(
	            description = "Update la reservation avec son id ",
	            parameters = @Parameter(name = "id", in = PATH, description = "id_reservation"),requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Donnée modifier ",required = true,content = @Content(schema = @Schema(implementation = CreateReservationDTO.class))),responses = {@ApiResponse(responseCode = "204", description = "Reservation modifier avec succès !"),@ApiResponse(responseCode = "404", description = "Reservation not found")}
	    )
	 
	@Transactional
	@PutMapping("/reservations/{id}")
	public ResponseEntity<Void> updateReservation(@PathVariable Integer id, @RequestBody CreateReservationDTO dto) {

	    Reservation reservation = reservationRepository.getReferenceById(id);
	    
	    reservation.setDateReservation(dto.getDateReservation());
	    reservation.setHeureDebut(dto.getHeureDebut());
	    reservation.setHeureFin(dto.getHeureFin());
	    reservation.setMotif(dto.getMotif());
	    reservationRepository.save(reservation);
	    return ResponseEntity.noContent().location(URI.create("/reservations/" + reservation.getIdReservation())).build();
	}  
	
	 @Operation(
	            description = "Delete la reservation avec son id  ",
	            parameters = @Parameter(name = "id", in = PATH, description = "id_reservation"),
	            responses = {@ApiResponse(responseCode = "204", description = "Reservation deleted"),@ApiResponse(responseCode = "404", description = "Reservation not found")}
	    )
	@Transactional
	@DeleteMapping("/reservations/{id}")
	public ResponseEntity<Void> deleteReservation(@PathVariable Integer id) {

	    reservationRepository.deleteById(id);

	    return ResponseEntity.noContent().build();
	}
	
	
	
	// A FAIRE la methode pour donner les creneaux disponible 
	 
	 @Operation(
	            description = "trouver les crenneau disponibles au jour même",
	            parameters = {@Parameter(name = "id_Terrain", in = PATH, description = "id_terrain"),@Parameter(name = "date", in = PATH, description = "Date (format YYYY-MM-DD)")},
	            responses = {@ApiResponse(responseCode = "200", description = "Liste des crenneaux disponible d'un terrain",content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),@ApiResponse(responseCode = "404", description = "time slot not found")}
	    )
	 
	@GetMapping("/reservations/terrain/{idTerrain}/date/{date}")
	
	public ResponseEntity<List<LocalTime>> getCreneauxDisponibles(@PathVariable Integer idTerrain,@PathVariable LocalDate date) {

	    List<LocalTime> creneauxdisponible = reservationService.getCreneauxDisponibles(idTerrain, date);
	    return ResponseEntity.ok(creneauxdisponible);
	   
	}

}
