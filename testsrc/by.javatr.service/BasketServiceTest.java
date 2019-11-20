package by.javatr.service;

import by.javatr.model.Ball;
import by.javatr.model.Basket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class BasketServiceTest {

    private static final double DELTA = 0.0001;
    private BasketService basketService = new BasketService();
    private Basket basket = new Basket();
    private Ball ball1 = new Ball("Blue", 2.5);
    private Ball ball2 = new Ball("Red", 3.5);
    private Ball ball3 = new Ball("Blue", 5.0);

    @Before
    public void addTreeBallsToBasket() {
        basketService.addBallToBasket(basket, ball1);
        basketService.addBallToBasket(basket, ball2);
        basketService.addBallToBasket(basket, ball3);
    }

    @Test
    public void addBallToBasket() {
        int expected = 3;
        int actual = basket.getBalls().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countBasketWeightCalculationTest() {
        double expected = 11.0;
        double actual = basketService.countBasketWeight(basket);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void countBallByColor() {
        int expected = 2;
        int actual = basketService.countBallByColor(basket, "Blue");
        Assert.assertEquals(expected, actual);
    }
}