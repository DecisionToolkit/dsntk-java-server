package io.dsntk.server.rest.errors;

import io.dsntk.server.rest.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class ErrorAdvice {
  @ResponseBody
  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDto noHandlerFoundExceptionHandler(Exception e) {
    return ErrorDto.createFrom("endpoint not found");
  }

  @ResponseBody
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDto httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e) {
    return ErrorDto.createFrom("HTTP method not supported");
  }

  @ResponseBody
  @ExceptionHandler(RpcException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto rpcExceptionHandler(RpcException e) {
    return ErrorDto.createFrom(e.getMessage());
  }
}
