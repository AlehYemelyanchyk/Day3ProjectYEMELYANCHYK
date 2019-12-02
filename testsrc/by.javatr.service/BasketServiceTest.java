package by.javatr.service;

import by.javatr.model.Ball;
import by.javatr.model.Basket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class BasketServiceTest {

    private static final double DELTA = 0.0001;
    private static final int MAX_CAPACITY = 3;
    private BasketService basketService = new BasketService();
    private Basket basket = new Basket(MAX_CAPACITY);
    private Ball ball1 = new Ball("Blue", 2.5);
    private Ball ball2 = new Ball("Red", 3.5);
    private Ball ball3 = new Ball("Blue", 5.0);

    @Before
    public void addThreeBallsToBasket() {
        basketService.addBallToBasket(basket, ball1);
        basketService.addBallToBasket(basket, ball2);
        basketService.addBallToBasket(basket, ball3);
    }

    @Test
    public void addBallToBasketAddingTest() {
        int expected = 3;
        List<Ball> result = basket.getBalls();
        Assert.assertNotNull(result);
        int actual = basket.getBalls().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addBallToNullBasketTest() {
        Assert.assertFalse(basketService.addBallToBasket(null, ball1));
    }

    @Test
    public void addNullToBasketTest() {
        Assert.assertFalse(basketService.addBallToBasket(basket, null));
    }

    @Test
    public void addBallToBasketMoreThanMaxCapacityTest() {
        int expected = 3;
        Ball ball = new Ball("Green", 5.0);
        basketService.addBallToBasket(basket, ball);
        List<Ball> balls = basket.getBalls();
        Assert.assertNotNull(balls);
        int actual = balls.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeBallFromNullBasketTest() {
        Assert.assertFalse(basketService.removeBallFromBasket(null, ball1));
    }

//    @Test
//    public void removeBallFromBasketTest() {
//        int expected = 2;
//        basketService.removeBallFromBasket(basket, ball1);
//        List<Ball> result = basket.getBalls();
//        Assert.assertNotNull(result);
//        int actual = result.size();
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void removeBallFromBasketTest() {
        Assert.assertTrue(basketService.removeBallFromBasket(basket, ball1));
    }

//    @Test
//    public void removeNullFromBasketTest() {
//        int expected = 3;
//        basketService.removeBallFromBasket(basket, null);
//        List<Ball> result = basket.getBalls();
//        Assert.assertNotNull(result);
//        int actual = result.size();
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void removeFromBasketNullArgumentTest() {
        Assert.assertFalse(basketService.removeBallFromBasket(null, ball2));
        Assert.assertFalse(basketService.removeBallFromBasket(basket, null));
    }

    @Test
    public void replaceBallInBasketTest() {
        Ball newBall = new Ball("Yellow", 3.5);
        Ball expected = ball2;
        Ball actual = basketService.replaceBallInBasket(basket, ball2, newBall);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceBallInBasketNullArgumentTest() {
        Ball newBall = new Ball("Yellow", 3.5);
        Assert.assertNull(basketService.replaceBallInBasket(null, ball2, newBall));
        Assert.assertNull(basketService.replaceBallInBasket(basket, null, newBall));
        Assert.assertNull(basketService.replaceBallInBasket(basket, ball2, null));
    }

    @Test
    public void countBasketWeightCalculationTest() {
        double expected = 11.0;
        double actual = basketService.countBasketWeight(basket);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void countBasketWeightNullArgumentTest() {
        double expected = 0.0;
        double actual = basketService.countBasketWeight(null);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void countBallsByColorFilteringTest() {
        int expected = 2;
        int actual = basketService.countBallsByColor(basket, "Blue");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countBallsByColorNullArgumentTest() {
        int expected = 0;
        int actual = basketService.countBallsByColor(null, "Blue");
        Assert.assertEquals(expected, actual);
        actual = basketService.countBallsByColor(basket, null);
        Assert.assertEquals(expected, actual);
    }
}