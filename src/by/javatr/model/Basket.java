package by.javatr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Basket {
    private final List<Ball> balls;

    public Basket() {
        this.balls = new ArrayList<>();
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
