package by.javatr.model;

import by.javatr.model.exception.InvalidColorException;
import by.javatr.model.exception.InvalidWeightException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */

public class BallTest {

    private Ball ball = new Ball("Blue", 2.5);

    @Test(expected = InvalidColorException.class)
    public void setColorNullParameterTest() {
        ball.setColor(null);
    }

    @Test(expected = InvalidColorException.class)
    public void setColorEmptyNameParameterTest() {
        ball.setColor("");
    }

    @Test(expected = InvalidWeightException.class)
    public void setNegativeWeightTest() {
        ball.setWeight(-1);
    }

    @Test(expected = InvalidWeightException.class)
    public void setZeroWeightTest() {
        ball.setWeight(0);
    }

    @Test(expected = InvalidWeightException.class)
    public void setTooBigWeightTest() {
        ball.setWeight(11);
    }

    @Test
    public void equalsTest() {
        Ball ballNew = new Ball("Blue", 2.5);
        Assert.assertEquals(ball, ballNew);
    }

    @Test(expected = InvalidColorException.class)
    public void equalsBothNullColorsTest() {
        Ball ball1 = new Ball(null, 2.5);
        Ball ball2 = new Ball(null, 2.5);
        ball1.equals(ball2);
    }

    @Test(expected = InvalidColorException.class)
    public void equalsBothEmptyColorsTest() {
        Ball ball1 = new Ball("", 2.5);
        Ball ball2 = new Ball("", 2.5);
        ball1.equals(ball2);
    }

    @Test(expected = InvalidColorException.class)
    public void equalsCompareToNullColorTest() {
        Ball ball1 = new Ball("Blue", 2.5);
        Ball ball2 = new Ball(null, 2.5);
        ball1.equals(ball2);
    }

    @Test(expected = InvalidColorException.class)
    public void equalsNullColorTest() {
        Ball ball1 = new Ball(null, 2.5);
        Ball ball2 = new Ball("Blue", 2.5);
        ball1.equals(ball2);
    }

    @Test
    public void equalsOtherTypeObjectTest() {
        Object object = new Object();
        Assert.assertNotEquals(ball, object);
        Assert.assertNotEquals(ball, "string");
        Assert.assertNotEquals(ball, 5);
        Assert.assertNotEquals(ball, true);
        Assert.assertNotEquals(ball, false);
    }

    @Test
    public void equalsSameInvalidParameterTest() {
        Assert.assertNotEquals(ball, null);
    }

    @Test
    public void hashCodeSameObjectsTest() {
        Ball newBall = new Ball("Blue", 2.5);
        Assert.assertEquals(ball.hashCode(), newBall.hashCode());
    }

    @Test
    public void hashCodeDifferentColorObjectsTest() {
        Ball newBall = new Ball("Red", 2.5);
        Assert.assertNotEquals(ball.hashCode(), newBall.hashCode());
    }

    @Test
    public void hashCodeDifferentWeightObjectsTest() {
        Ball newBall = new Ball("Blue", 2.45);
        Assert.assertNotEquals(ball.hashCode(), newBall.hashCode());
    }

    @Test(expected = InvalidColorException.class)
    public void hashCodeNullColorObjectsTest() {
        Ball newBall = new Ball(null, 2.5);
        Assert.assertNotEquals(ball.hashCode(), newBall.hashCode());
    }
}