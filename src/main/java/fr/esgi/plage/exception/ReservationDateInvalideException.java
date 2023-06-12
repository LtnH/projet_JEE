package fr.esgi.plage.exception;

import java.io.Serial;

public class ReservationDateInvalideException extends RuntimeException {

     @Serial
     private static final long serialVersionUID=1L;

    public ReservationDateInvalideException(String message){
        super(message);
    }
}
