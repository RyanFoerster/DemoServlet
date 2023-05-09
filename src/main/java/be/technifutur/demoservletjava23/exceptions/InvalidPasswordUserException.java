package be.technifutur.demoservletjava23.exceptions;

public class InvalidPasswordUserException extends RuntimeException{

    public InvalidPasswordUserException() {
        super("Invalid password");
    }

    public InvalidPasswordUserException(String message) {
        super(message);
    }
}
