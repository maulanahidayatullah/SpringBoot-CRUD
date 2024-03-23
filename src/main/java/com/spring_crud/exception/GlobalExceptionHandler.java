package com.spring_crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring_crud.model.response.ErrorMessageResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @SuppressWarnings("null")
  public ResponseEntity<ErrorMessageResponse> handleCustomException(CustomException ex) {
    return ResponseEntity
        .status(ex.getHttpStatus())
        .body(
            ErrorMessageResponse.builder()
                .message(ex.getMessage())
                .build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    Map<String, String> errorMap = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
      errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
    });
    return ResponseEntity.badRequest().body(errorMap);
  }
}
