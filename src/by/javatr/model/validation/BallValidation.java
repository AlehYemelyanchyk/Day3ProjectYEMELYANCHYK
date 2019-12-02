package by.javatr.model.validation;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */
public final class BallValidation {

    private BallValidation() {
    }

    public static boolean isColorValid(String color) {
        return color != null && color.length() != 0;
    }

    public static boolean isWeightValid(double weight) {
        return weight > 0 && weight <= 10.0;
    }
}
