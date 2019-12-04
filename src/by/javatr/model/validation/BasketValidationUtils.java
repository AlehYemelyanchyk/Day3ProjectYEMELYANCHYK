package by.javatr.model.validation;

import by.javatr.model.Ball;

import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */
public final class BasketValidationUtils {

    private BasketValidationUtils() {
    }

    public static boolean isBallsValid(List<Ball> balls) {
        return balls != null;
    }

    public static boolean isCapacityValid(int capacity) {
        return capacity > 0;
    }
}
