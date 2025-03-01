package tech.springular_crud.employeemanager.exceptions;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
    private final HttpStatus status;

    public AppException(String message, HttpStatus status1) {
        super(message);
        this.status = status1;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
