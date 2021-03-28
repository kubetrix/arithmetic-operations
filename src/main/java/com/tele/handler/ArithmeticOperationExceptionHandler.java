package com.tele.handler;

import com.tele.model.ResultBuilder;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ArithmeticOperationExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    ResultBuilder resultBuilder;

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = "The parameters need to be numeric";
        return handleExceptionInternal(ex, resultBuilder.getResultFromError(errorMessage), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status,
        WebRequest request) {
        return handleExceptionInternal(ex, resultBuilder.getResultFromError(ex.getMessage()), headers, status, request);
    }
}