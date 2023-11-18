package co.edu.udea.calidad.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.edu.udea.calidad.userinterfaces.AmazonConsumerPage.INPUT_TEXT_FIELD;

public class AmazonSearchInteraction implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        CharSequence inputText = Serenity.sessionVariableCalled("product");
        actor.attemptsTo(Enter.theValue(inputText).into(INPUT_TEXT_FIELD).thenHit(Keys.RETURN));
    }

    public static AmazonSearchInteraction search(){
        return Tasks.instrumented(AmazonSearchInteraction.class);
    }
}
