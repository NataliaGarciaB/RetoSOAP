package co.com.sofka.utils.service.soap.calculadora.add;


public enum Patch {
    ADD(System.getProperty("user.dir")
            + "src\\test\\resources\\files.services.soap.conversor.celsius\\celsius.xml");

    private final String value;

    Patch(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
