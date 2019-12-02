package by.javatr.model;

import by.javatr.model.exception.InvalidColorException;
import by.javatr.model.exception.InvalidWeightException;
import by.javatr.model.validation.BallValidation;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Ball {
    private String color;
    private double weight;

    public Ball() {
    }

    public Ball(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws InvalidColorException {
        if (!BallValidation.isColorValid(color)) {
            throw new InvalidColorException("The color name is invalid. It may be weather empty or not assigned.");
        }
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws InvalidWeightException {
        if (!BallValidation.isWeightValid(weight)) {
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

        if (Double.compare(weight, ball.getWeight()) == 0) {
            if (color != null) {
                return color.equals(ball.getColor());
            } else return ball.getColor() == null;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * (color == null ? 0 : color.hashCode()) * (int) weight;
    }


    @Override
    public String toString() {
        return getClass().getName() + '@'
                + "color: " + color
                + ", weight: " + weight;
    }
}
