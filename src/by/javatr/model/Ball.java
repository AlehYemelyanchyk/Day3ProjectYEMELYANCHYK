package by.javatr.model;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Ball {
    private final String color;
    private final double weight;

    public Ball(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
}
