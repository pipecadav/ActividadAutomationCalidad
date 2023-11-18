package co.edu.udea.calidad.tasks;

import co.edu.udea.calidad.interactions.AmazonSelectInteraction;
import co.edu.udea.calidad.interactions.CartInteraction;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.calidad.userinterfaces.AmazonProductDetailPage.CART_COUNTER;

public class AddToCart implements Task {

    private PageObject page;

    public AddToCart(PageObject page){
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(AmazonSelectInteraction.select());
        actor.attemptsTo(CartInteraction.addToCart());
        actor.attemptsTo(WaitUntil.the(CART_COUNTER, WebElementStateMatchers.isVisible()).forNoMoreThan(5).seconds());
    }

    public static AddToCart selectedProduct(PageObject page){
        return Tasks.instrumented(AddToCart.class,page);
    }
}