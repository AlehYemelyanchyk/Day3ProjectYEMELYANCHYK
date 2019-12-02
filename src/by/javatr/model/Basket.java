package by.javatr.model;

import by.javatr.model.validation.BasketValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Basket {
    private final int basketCapacity;
    private List<Ball> balls;

    public Basket() {
        basketCapacity = 10;
        this.balls = new ArrayList<>();
    }

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

    public void setBalls(List<Ball> balls) throws NullPointerException {
        if (!BasketValidation.isBallsValid(balls)) {
            throw new NullPointerException("Balls list haven't been initialized.");
        }
        this.balls = balls;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Basket basket = (Basket) object;

        return basketCapacity == basket.getBasketCapacity() &&
                balls.equals(basket.getBalls());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 * basketCapacity;
        for (Ball ball : balls) {
            result += 31 * (ball == null ? 0 : ball.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + '@'
                + "basketCapacity: " + basketCapacity
                + "balls: " + balls;
    }
}
