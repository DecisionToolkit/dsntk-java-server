package org.decisiontoolkit.server.rest.errors;

import org.decisiontoolkit.server.rest.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorAdvice {

    @ResponseBody
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto noHandlerFoundExceptionHandler(Exception e) {
        return new ErrorDto("endpoint not found");
    }

    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
        return new ErrorDto("HTTP method not supported");
    }

    @ResponseBody
    @ExceptionHandler(RpcException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto rpcExceptionHandler(RpcException e) {
        return new ErrorDto(e.getMessage());
    }
}
