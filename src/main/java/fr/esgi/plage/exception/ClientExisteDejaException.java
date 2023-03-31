package fr.esgi.plage.exception;

import java.io.Serial;

public class ClientExisteDejaException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ClientExisteDejaException(String message) {
        super(message);
    }
}
