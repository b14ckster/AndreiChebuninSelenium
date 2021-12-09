package hw6.service.exceptions;

public class WebDriverTypeException extends RuntimeException {

    public WebDriverTypeException() {
        super("Unsupported driver type. Supported types: local and remote");
    }
}
