package by.javatr.model;

import org.junit.Test;

/**
 * @author Aleh Yemelyanchyk on 12/1/2019.
 */
public class BasketTest {

    private Basket basket = new Basket();

    @Test(expected = NullPointerException.class)
    public void setBallsWithNullTest() {
        basket.setBalls(null);
    }
}