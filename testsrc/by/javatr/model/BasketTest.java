package by.javatr.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */
public class BasketTest {

    private Basket basket = new Basket();
    private Ball ball1 = new Ball("Blue", 2.5);
    private Ball ball2 = new Ball("Red", 3.5);
    private Ball ball3 = new Ball("Blue", 5.0);

    @Before
    public void addThreeBallsToBasket() {
        basket.getBalls().add(ball1);
        basket.getBalls().add(ball2);
        basket.getBalls().add(ball3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBallsWithNullTest() {
        basket.setBalls(null);
    }

    @Test
    public void setBallsTest() {
        List<Ball> balls = new ArrayList<>();
        basket.setBalls(balls);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBasketCapacityNegativeArgumentTest() {
        basket.setBasketCapacity(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBasketCapacityZeroArgumentTest() {
        basket.setBasketCapacity(0);
    }

    @Test
    public void setBasketCapacityRightArgumentTest() {
        basket.setBasketCapacity(12);
    }

    @Test
    public void equalsSameObjectsTest() {
        Basket newBasket = new Basket();
        List<Ball> newBasketBalls = newBasket.getBalls();
        Assert.assertNotNull(newBasketBalls);
        newBasketBalls.add(ball1);
        newBasketBalls.add(ball2);
        newBasketBalls.add(ball3);
        Assert.assertEquals(basket, newBasket);
    }

    @Test
    public void equalsDifferentCapacityObjectsTest() {
        Basket newBasket = new Basket(5);
        Assert.assertNotEquals(basket, newBasket);
    }

    @Test
    public void equalsDifferentBallsCapacityObjectsTest() {
        Basket newBasket = new Basket(5);
        Ball newBall1 = new Ball("Red", 3.5);
        Ball newBall2 = new Ball("Blue", 5.0);
        List<Ball> newBasketBalls = newBasket.getBalls();
        Assert.assertNotNull(newBasketBalls);
        newBasketBalls.add(newBall1);
        newBasketBalls.add(newBall2);
        Assert.assertNotEquals(basket.getBalls(), newBasketBalls);
    }

    @Test
    public void hashCodeSameObjectsTest(){
        Basket newBasket = new Basket();
        List<Ball> newBasketBalls = newBasket.getBalls();
        Assert.assertNotNull(newBasketBalls);
        newBasketBalls.add(ball1);
        newBasketBalls.add(ball2);
        newBasketBalls.add(ball3);
        Assert.assertEquals(basket.hashCode(),newBasket.hashCode());
    }

    @Test
    public void hashCodeDifferentCapacityTest(){
        Basket newBasket = new Basket(6);
        List<Ball> newBasketBalls = newBasket.getBalls();
        Assert.assertNotNull(newBasketBalls);
        newBasketBalls.add(ball1);
        newBasketBalls.add(ball2);
        newBasketBalls.add(ball3);
        Assert.assertNotEquals(basket.hashCode(),newBasket.hashCode());
    }

    @Test
    public void hashCodeDifferentContentTest(){
        Basket newBasket = new Basket();
        List<Ball> newBasketBalls = newBasket.getBalls();
        Assert.assertNotNull(newBasketBalls);
        newBasketBalls.add(ball1);
        newBasketBalls.add(ball2);
        Assert.assertNotEquals(basket.hashCode(),newBasket.hashCode());
    }
}