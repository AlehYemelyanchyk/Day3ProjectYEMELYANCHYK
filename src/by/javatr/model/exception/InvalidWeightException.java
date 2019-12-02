package by.javatr.model.exception;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */
public class InvalidWeightException extends RuntimeException {

    public InvalidWeightException() {
        super();
    }

    public InvalidWeightException(String message) {
        super(message);
    }
}
