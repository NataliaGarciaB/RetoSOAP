package co.com.sofka.stepdefinitions.services.soap.conversor.celsius;

import co.com.sofka.ServiceSetup;
import co.com.sofka.models.Operation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;

import static co.com.sofka.questions.ResturnSoapServiceResponse.resturnSoapServiceResponse;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.utils.FileUtilities.readFile;
import static co.com.sofka.utils.service.soap.calculadora.add.Patch.ADD;
import static co.com.sofka.utils.service.soap.calculadora.add.Response.ADD_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class AddStepDefinition extends ServiceSetup {

    private Operation operation;

    @Given("que el usuario del conversor ha definido como {int}")
    public void queElUsuarioDeLConversorHaDefinidoComo(Integer conversionA) {
        super.setup();
        operation = new Operation();
        operation.setA(conversionA);
    }

    @When("el usuario del conversor ejecuta la conversion")
    public void elUsuarioDelConversorEjecutaLaConversion() {
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequest())
        );
    }
    @Then("el ususario debería obtener el resultado {int}")
    public void elUsusarioDeberiaObtenerElResultado(Integer outcome) {
        operation.setOutcome(outcome);
        actor.should(
                seeThatResponse("El código de rspuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El resultado de la conversión debe ser: ",
                        resturnSoapServiceResponse(),
                        containsString(bodyResponse()))
        );
    }

    private Operation operation(){
        return operation;
    }

    private String bodyRequest(){
        return String.format(readFile(ADD.getValue()), operation().getA());
    }

    private String bodyResponse(){
        return String.format(ADD_RESPONSE.getValue(), operation().getOutcome());
    }

}
