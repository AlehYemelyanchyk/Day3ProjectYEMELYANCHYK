package by.javatr.model;

import by.javatr.model.exception.InvalidColorException;
import by.javatr.model.exception.InvalidWeightException;
import by.javatr.model.validation.BallValidationUtils;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Ball {
    private String color;
    private double weight;

    protected Ball() {
    }

    public Ball(String color, double weight) {
        setColor(color);
        setWeight(weight);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws InvalidColorException {
        if (!BallValidationUtils.isColorValid(color)) {
            throw new InvalidColorException("The color name is invalid. It should not be empty.");
        }
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidWeightException {
        if (!BallValidationUtils.isWeightValid(weight)) {
            throw new InvalidWeightException("A ball weight should be more than 0 and less than 10.");
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Ball ball = (Ball) object;

        if (Double.compare(this.getWeight(), ball.getWeight()) == 0) {
            return this.getColor().equalsIgnoreCase(ball.getColor());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (int) ((color == null ? 0 : color.hashCode()) * weight);
    }


    @Override
    public String toString() {
        return getClass().getName() + '@'
                + "color: " + color
                + ", weight: " + weight;
    }
}
