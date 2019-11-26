package by.javatr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Basket {
    private final int basketCapacity;
    private final List<Ball> balls;

    public Basket(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        this.balls = new ArrayList<>(basketCapacity);
    }

    public int getBasketCapacity() {
        return basketCapacity;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
