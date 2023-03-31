package fr.esgi.plage.exception;

import java.io.Serial;

public class ReservationInexistantException extends RuntimeException {
    @Serial

    private static final long serialVersionUID = 1L;
    public ReservationInexistantException(String message) {
        super(message);
    }
}
