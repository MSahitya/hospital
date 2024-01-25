package com.HMS.hospital_mgmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@ControllerAdvice//to handle exceptions globally
public class GlobalExceptionHandler {
    //Handle specifi exceptions and Global Exceptions

    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
return new  ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
}


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleRException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new  ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleEntityNotFoundRException(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
        return new  ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
