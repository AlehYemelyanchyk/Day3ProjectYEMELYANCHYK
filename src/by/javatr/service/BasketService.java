package by.javatr.service;

import by.javatr.model.Ball;
import by.javatr.model.Basket;
import by.javatr.model.exception.FullBasketException;
import by.javatr.service.validation.BasketServiceValidationUtils;

import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class BasketService {

    public boolean addBallToBasket(Basket basket, Ball ball)
            throws IllegalArgumentException, FullBasketException {
        if (basket == null || ball == null) {
            throw new IllegalArgumentException("Basket or ball not found.");
        }
        if (BasketServiceValidationUtils.isFull(basket)) {
            throw new FullBasketException("The basket is full.");
        }
        return basket.getBalls().add(ball);
    }

    public boolean removeBallFromBasket(Basket basket, Ball ball) throws IllegalArgumentException {
        if (basket == null) {
            throw new IllegalArgumentException("Basket not found.");
        }
        return basket.getBalls().remove(ball);
    }

    public Ball replaceBallInBasket(Basket basket, Ball ballOld, Ball ballNew) {
        if (basket == null || ballOld == null || ballNew == null) {
            return null;
        }

        List<Ball> balls = basket.getBalls();
        int index = findBallInBasket(balls, ballOld);
        if (index == -1) {
            return null;
        }
        return balls.set(index, ballNew);
    }

    public double countBasketWeight(Basket basket) {
        double weightSum = 0.0;
        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                weightSum += ball.getWeight();
            }
        }
        return weightSum;
    }

    public int countBallsByColor(Basket basket, String color) {
        int amount = 0;
        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                String ballColor = ball.getColor();
                if (ballColor.equalsIgnoreCase(color)) {
                    amount++;
                }
            }
        }
        return amount;
    }

    private int findBallInBasket(List<Ball> balls, Ball ball) {
        int index = -1;
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i).equals(ball)) {
                index = i;
            }
        }
        return index;
    }
}
