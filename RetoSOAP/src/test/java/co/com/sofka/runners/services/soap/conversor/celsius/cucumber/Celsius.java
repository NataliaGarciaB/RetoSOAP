package co.com.sofka.runners.services.soap.conversor.celsius.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features.services.soap.conversor.celsius/celsiusaf.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.soap.conversor.celsius"}
)
public class Celsius {
}
