package com.HMS.hospital_mgmt.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class ResourceNotFoundException extends  RuntimeException{
private String resourceName;
private String filedName;
private String filedValue;

    public ResourceNotFoundException(String resourceName, String filedName, String filedValue) {
        super(String.format("%s not found with %s:'%s",resourceName,filedName,filedValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFiledName() {
        return filedName;
    }

    public String getFiledValue() {
        return filedValue;
    }
}
