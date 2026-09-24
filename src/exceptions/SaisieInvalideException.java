package exceptions;

public class SaisieInvalideException extends Exception {
    public SaisieInvalideException(String message){
        super(message, null, false, false);
    }
}
