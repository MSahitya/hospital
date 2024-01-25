package com.HMS.hospital_mgmt.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class EntityNotFoundException extends  RuntimeException{
public EntityNotFoundException(String exception){
    super(exception);
}
}
