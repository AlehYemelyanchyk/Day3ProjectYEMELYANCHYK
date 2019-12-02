package by.javatr.model.exception;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */
public class InvalidColorException extends RuntimeException {

    public InvalidColorException() {
        super();
    }

    public InvalidColorException(String message) {
        super(message);
    }
}
