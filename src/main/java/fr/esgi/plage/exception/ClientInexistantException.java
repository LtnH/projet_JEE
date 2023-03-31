package fr.esgi.plage.exception;

import java.io.Serial;

public class ClientInexistantException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ClientInexistantException(String message) {
        super(message);
    }
}
