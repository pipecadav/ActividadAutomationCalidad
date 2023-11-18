package co.edu.udea.calidad.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.calidad.userinterfaces.AmazonProductDetailPage.CART_BUTTON;

public class CartInteraction implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_BUTTON).afterWaitingUntilPresent());
    }

    public static CartInteraction addToCart(){
        return Tasks.instrumented(CartInteraction.class);
    }
}