package C08_ExceptionAndErrorHandling.P05CustomException;

public class InvalidPersonNameException extends Throwable {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
