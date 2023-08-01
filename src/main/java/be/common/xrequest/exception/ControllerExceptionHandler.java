package be.common.xrequest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({
            XRequestNotFoundException.class,
            AuthorNotFoundException.class,
            PlaceNotFoundException.class
    })

    protected ResponseEntity<String> handleBadRequestRE(Exception exception) {
        return new ResponseEntity<>(
                "{\"message\":\"" + exception.getMessage() + "\"}",
                null, HttpStatus.BAD_REQUEST.value()
        );
    }
}
