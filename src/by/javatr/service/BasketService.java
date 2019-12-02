package by.javatr.service;

import by.javatr.model.Ball;
import by.javatr.model.Basket;

import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class BasketService {

    public boolean addBallToBasket(Basket basket, Ball ball) {
        if (basket == null || ball == null) {
            return false;
        }
        int ballsAmount = basket.getBalls().size();
        if (ballsAmount < basket.getBasketCapacity()) {
            basket.getBalls().add(ball);
            return true;
        }
        return false;
    }

    public boolean removeBallFromBasket(Basket basket, Ball ball) {
        if (basket == null) {
            return false;
        }
        return basket.getBalls().remove(ball);
    }

    public Ball replaceBallInBasket(Basket basket, Ball ballOld, Ball ballNew) {
        if (basket == null || ballOld == null || ballNew == null) {
            return null;
        }

        List<Ball> balls = basket.getBalls();
        int index = findBallInBasket(balls, ballOld);
        if (index >= 0) {
            return balls.set(index, ballNew);
        }
        return null;
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
