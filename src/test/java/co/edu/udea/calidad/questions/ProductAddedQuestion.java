package co.edu.udea.calidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.calidad.userinterfaces.AmazonProductDetailPage.CART_COUNTER;

public class ProductAddedQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String results = actor.asksFor(Text.of(CART_COUNTER));
        return results.equals("1");
    }

    public static ProductAddedQuestion isProductAdded(){
        return new ProductAddedQuestion();
    }
}