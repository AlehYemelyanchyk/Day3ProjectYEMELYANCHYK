package by.javatr.service;

import by.javatr.model.Ball;
import by.javatr.model.Basket;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class BasketService {

    public void addBallToBasket(Basket basket, Ball ball) {
        if (basket != null && ball != null) {
            basket.getBalls().add(ball);
        }
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


}
