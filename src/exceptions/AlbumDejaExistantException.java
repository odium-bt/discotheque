package exceptions;

public class AlbumDejaExistantException extends Exception {
    public AlbumDejaExistantException(String message){
        super(message, null, false, false);
    }
}
