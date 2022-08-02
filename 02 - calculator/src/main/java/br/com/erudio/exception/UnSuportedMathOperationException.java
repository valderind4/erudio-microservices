package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnSuportedMathOperationException extends RuntimeException {

    private static final long serialVersionUID = 2559178692598327386L;

    public UnSuportedMathOperationException(String exception) {
        super(exception);
    }
}
