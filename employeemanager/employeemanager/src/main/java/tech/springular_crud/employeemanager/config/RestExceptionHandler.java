package tech.springular_crud.employeemanager.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.springular_crud.employeemanager.dtos.ErrorDto;
import tech.springular_crud.employeemanager.exceptions.AppException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value= AppException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex){
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDto(ex.getMessage()));
    }
}
