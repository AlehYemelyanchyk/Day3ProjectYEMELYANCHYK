package by.javatr.model;

import by.javatr.model.exception.InvalidColorException;
import by.javatr.model.exception.InvalidWeightException;
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
}