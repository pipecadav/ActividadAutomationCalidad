package co.edu.udea.calidad.userinterfaces;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AmazonConsumerPage extends PageObject {

    public static final Target INPUT_TEXT_FIELD = Target.the("INPUT TEXT FIELD")
            .located(By.id("twotabsearchtextbox"));
    public static final Target RESULTS_TITLE = Target.the("RESULTS TITLE")
            .located(By.cssSelector("div[data-cel-widget='MAIN-TOP_BANNER_MESSAGE-0'] span.a-text-bold"));

}
