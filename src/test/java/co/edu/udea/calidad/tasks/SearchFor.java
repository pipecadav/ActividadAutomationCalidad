package co.edu.udea.calidad.tasks;

import co.edu.udea.calidad.interactions.AmazonSearchInteraction;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SearchFor implements Task {

    private PageObject page;

    public SearchFor(PageObject page){
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(AmazonSearchInteraction.search());
    }

    public static SearchFor productIn(PageObject page){
        return Tasks.instrumented(SearchFor.class, page);
    }
}
