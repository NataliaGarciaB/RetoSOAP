package co.com.sofka.runners.services.soap.conversor.celsius.test;

import co.com.sofka.ServiceSetup;
import co.com.sofka.models.Operation;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static co.com.sofka.questions.ResturnSoapServiceResponse.resturnSoapServiceResponse;
import static co.com.sofka.tasks.DoPost.doPost;
import static co.com.sofka.utils.FileUtilities.readFile;
import static co.com.sofka.utils.service.soap.calculadora.add.Patch.ADD;
import static co.com.sofka.utils.service.soap.calculadora.add.Response.ADD_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.containsString;

public class ConversorTest extends ServiceSetup {

    private Operation oper;

    @Before
    public void setUp(){
        Operation oper = new Operation();
        oper.setA(35);
        oper.setOutcome(95);
        super.setup();
    }

    @Test
    public void celsius(){
        actor.attemptsTo(
                doPost()
                        .withTheResource(RESOURCE)
                        .andTheHeaders(super.headers())
                        .andTheBodyRequest(bodyRequest())
        );

        actor.should(
                seeThatResponse("El codigo de respuesta HTTP debe ser: ",
                        response -> response.statusCode(HttpStatus.SC_OK)),
                seeThat("El resultado de la conversion debe ser: ",
                        resturnSoapServiceResponse(),
                        containsString(bodyResponse()))
        );
    }

    private Operation operation(){

        return oper;
    }

    private String bodyRequest(){
        return String.format(readFile(ADD.getValue()), operation().getA());
    }

    private String bodyResponse(){
        return String.format(ADD_RESPONSE.getValue(), operation().getOutcome());
    }


}
