package be.common.xrequest.exception;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(String author) {
        super("The author(s) [" + author + "] was/were not found: ");
    }
}
