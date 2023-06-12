package fr.esgi.plage.controller;

import fr.esgi.plage.business.Reservation;
import fr.esgi.plage.dto.ReservationDto;
import fr.esgi.plage.exception.ReservationDateInvalideException;
import fr.esgi.plage.exception.ReservationExisteDejaException;
import fr.esgi.plage.exception.ReservationInexistantException;
import fr.esgi.plage.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/")
@RestController
@AllArgsConstructor
public class ReservationRestController {

    private ReservationService reservationService;

    @GetMapping("reservations")
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("reservations/{id}")
    public Reservation getReservation(Long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping("reservations")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Reservation postReservation(@RequestBody ReservationDto reservation) {
        return reservationService.createReservation(reservation);
    }
    @PutMapping("reservations")
    public Reservation putReservation(@RequestBody ReservationDto reservation) {
        return reservationService.modifyReservation(reservation);
    }

    @DeleteMapping("reservations/{id}")
    public boolean deleteReservation(Long id) {
        return reservationService.deleteReservation(id);
    }

    @ExceptionHandler(ReservationExisteDejaException.class)
    @ResponseStatus(code= HttpStatus.CONFLICT)
    public String traiterReservationDejaPresent(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(ReservationInexistantException.class)
    @ResponseStatus(code= HttpStatus.CONFLICT)
    public String traiterReservationInexistant(Exception e) {
        return e.getMessage();
    }

    @ExceptionHandler(ReservationDateInvalideException.class)
    @ResponseStatus(code= HttpStatus.CONFLICT)
    public String traiterReservationDateInvalide(Exception e) {
        return e.getMessage();
    }
}
