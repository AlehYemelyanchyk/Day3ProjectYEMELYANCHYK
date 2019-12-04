package by.javatr.service.validation;

import by.javatr.model.Basket;

/**
 * @author Aleh Yemelyanchyk on 12/2/2019.
 */
public final class BasketServiceValidationUtils {

    private BasketServiceValidationUtils() {
    }

    public static boolean isFull(Basket basket) {
        int ballsAmount = basket.getBalls().size();
        return ballsAmount >= basket.getBasketCapacity();
    }
}
