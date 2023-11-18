package co.edu.udea.calidad.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


import static co.edu.udea.calidad.userinterfaces.AmazonConsumerPage.RESULTS_TITLE;

public class ResultsQuestion implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String results = actor.asksFor(Text.of(RESULTS_TITLE));
        return results.equals("Results");
    }

    public static ResultsQuestion isInResultPage(){
        return new ResultsQuestion();
    }
}
