package by.javatr.service;

import by.javatr.model.Ball;
import by.javatr.model.Basket;
import by.javatr.model.exception.FullBasketException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 11/20/2019.
 */
public class BasketServiceTest {

    private static final double DELTA = 0.0001;
    private static final int MAX_CAPACITY = 4;
    private BasketService basketService = new BasketService();
    private Basket basket = new Basket(MAX_CAPACITY);
    private Ball ball1 = new Ball("Blue", 2.5);
    private Ball ball2 = new Ball("Red", 3.5);
    private Ball ball3 = new Ball("Blue", 5.0);

    @Before
    public void addThreeBallsToBasket() {
        basket.getBalls().add(ball1);
        basket.getBalls().add(ball2);
        basket.getBalls().add(ball3);
    }

    @Test
    public void addBallToBasketAddingTest() {
        int expected = 4;
        basketService.addBallToBasket(basket, ball2);
        List<Ball> result = basket.getBalls();
        Assert.assertNotNull(result);
        int actual = basket.getBalls().size();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addBallToNullBasketTest() {
        basketService.addBallToBasket(null, ball1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullToBasketTest() {
        basketService.addBallToBasket(basket, null);
    }

    @Test(expected = FullBasketException.class)
    public void addBallToBasketMoreThanMaxCapacityTest() {
        Ball ball = new Ball("Green", 5.0);
        basketService.addBallToBasket(basket, ball);
        basketService.addBallToBasket(basket, ball);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeBallFromNullBasketTest() {
        basketService.removeBallFromBasket(null, ball1);
    }

    @Test
    public void removeBallFromBasketTest() {
        int expected = 2;
        Assert.assertTrue(basketService.removeBallFromBasket(basket, ball1));
        List<Ball> result = basket.getBalls();
        Assert.assertNotNull(result);
        int actual = result.size();
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(result.contains(ball1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFromNullBasketTest() {
        basketService.removeBallFromBasket(null, ball2);
    }

    @Test
    public void removeNullFromBasketTest() {
        Assert.assertFalse(basketService.removeBallFromBasket(basket, null));
    }

    @Test
    public void replaceBallInBasketTest() {
        Ball newBall = new Ball("Yellow", 3.5);
        Ball expected = ball2;
        Ball actual = basketService.replaceBallInBasket(basket, ball2, newBall);
        Assert.assertEquals(expected, actual);
        List<Ball> result = basket.getBalls();
        Assert.assertNotNull(result);
        Assert.assertFalse(result.contains(ball2));
        Assert.assertTrue(result.contains(newBall));
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