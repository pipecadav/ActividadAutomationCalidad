package co.edu.udea.calidad.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AmazonProductDetailPage extends PageObject {

    public static final Target SELECTED_PRODUCT = Target.the("SELECTED PRODUCT")
            .located(org.openqa.selenium.By.cssSelector("img[alt='LG LM577B 32-in 720P HD LCD 60Hz Smart TV 32LM577BPUA (2021)']"));
    public static final Target CART_BUTTON = Target.the("CART BUTTON")
            .located(By.cssSelector(".a-button input#add-to-cart-button"));
    public static final Target CART_COUNTER = Target.the("CART COUNTER")
            .located(By.id("nav-cart-count"));

}
