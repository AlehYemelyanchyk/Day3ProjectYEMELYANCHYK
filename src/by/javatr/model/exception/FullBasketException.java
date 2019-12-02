package by.javatr.model.exception;

/**
 * @author Aleh Yemelyanchyk on 12/2/2019.
 */
public class FullBasketException extends RuntimeException {

    public FullBasketException() {
        super();
    }

    public FullBasketException(String message) {
        super(message);
    }
}
