package be.common.xrequest.exception;

public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException(String place){
        super("place(s) ["+place+"] was/were not found");
    }
}
