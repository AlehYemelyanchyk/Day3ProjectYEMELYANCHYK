package by.javatr.runner;

import by.javatr.model.Ball;
import by.javatr.model.Basket;
import by.javatr.service.BasketService;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class Run {

    public static void main(String[] args) {
        BasketService basketService = new BasketService();
        Basket basket = new Basket(5);
        Ball ball1 = new Ball("Blue", 2.5);
        Ball ball2 = new Ball("Red", 3.5);
        Ball ball3 = new Ball("Blue", 5.0);
        Ball ball4 = new Ball("Red", 1.5);
        Ball ball5 = new Ball("Yellow", 2.5);

        basketService.addBallToBasket(basket, ball1);
        basketService.addBallToBasket(basket, ball2);
        basketService.addBallToBasket(basket, ball3);
        basketService.addBallToBasket(basket, ball4);
        basketService.addBallToBasket(basket, ball5);

        System.out.println("All balls in the basket weight " +
                basketService.countBasketWeight(basket));

        String color = "blue";

        System.out.println("There are " + basketService.countBallsByColor(basket, color)
                + " " + color + " balls in the basket");

    }
}
