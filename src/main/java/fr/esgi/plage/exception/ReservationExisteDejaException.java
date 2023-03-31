package fr.esgi.plage.exception;

import java.io.Serial;

public class ReservationExisteDejaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ReservationExisteDejaException(String message) {
        super(message);
    }
}
