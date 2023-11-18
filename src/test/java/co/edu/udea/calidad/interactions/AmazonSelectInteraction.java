package co.edu.udea.calidad.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.edu.udea.calidad.userinterfaces.AmazonProductDetailPage.SELECTED_PRODUCT;


public class AmazonSelectInteraction implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(SELECTED_PRODUCT));
        actor.attemptsTo(Click.on(SELECTED_PRODUCT).afterWaitingUntilEnabled());
    }

    public static AmazonSelectInteraction select(){
        return Tasks.instrumented(AmazonSelectInteraction.class);
    }
}