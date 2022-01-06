package co.com.sofka.utils.service.soap.calculadora.add;

public enum Response {
    ADD_RESPONSE("<CelsiusToFahrenheitResult>%s</CelsiusToFahrenheitResult>");

    private final String value;

    Response(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
