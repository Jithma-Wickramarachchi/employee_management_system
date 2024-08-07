package com.teccience.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee id not found")
public class EmployeeIdNotFoundException extends RuntimeException{
    public EmployeeIdNotFoundException(Integer id){
        super("Item Id not found! id:"+id);
    }
}
