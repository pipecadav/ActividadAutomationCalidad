package co.edu.udea.calidad.stepdefinitions;


import co.edu.udea.calidad.questions.ProductAddedQuestion;
import co.edu.udea.calidad.questions.ResultsQuestion;
import co.edu.udea.calidad.tasks.AddToCart;
import co.edu.udea.calidad.tasks.OpenThe;
import co.edu.udea.calidad.tasks.SearchFor;
import co.edu.udea.calidad.userinterfaces.AmazonConsumerPage;
import co.edu.udea.calidad.userinterfaces.AmazonProductDetailPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FindProductStepDefinitions {

    @Managed(driver = "chrome")
    public WebDriver driver;
    public Actor amazonConsumer = Actor.named("felipe");

    public AmazonConsumerPage amazonConsumerPage = new AmazonConsumerPage();
    public AmazonProductDetailPage amazonProductDetailPage = new AmazonProductDetailPage();


    @Before
    public void preStage(){
        driver.manage().window().maximize();
        amazonConsumer.can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @Given("^que me encuentro en la pagina de Amazon$")
    public void queMeEncuentroEnLaPaginaDeAmazon() {
        amazonConsumer.attemptsTo(OpenThe.browser(amazonConsumerPage));
    }


    @When("^busco el producto \"([^\"]*)\" en el buscador$")
    public void buscoElProductoEnElBuscador(String producto)  {
        Serenity.setSessionVariable("product").to(producto);
        amazonConsumer.attemptsTo(SearchFor.productIn(amazonConsumerPage));

    }


    @Then("^debo ver la pagina de resultados$")
    public void deboLaPaginaDeResultados() {
        amazonConsumer.should(seeThat(ResultsQuestion.isInResultPage(), equalTo(true)));
    }


    @When("^agrego el resultado al carrito$")
    public void agregoElResultadoAlCarrito() {
        amazonConsumer.attemptsTo(AddToCart.selectedProduct(amazonProductDetailPage));
    }


    @Then("^debo ver el carrito con el producto$")
    public void deboVerElCarritoConElProducto() {
        amazonConsumer.should(seeThat(ProductAddedQuestion.isProductAdded(), equalTo(true)));
    }
}
