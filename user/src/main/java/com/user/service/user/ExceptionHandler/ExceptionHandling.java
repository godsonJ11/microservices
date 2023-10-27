package com.user.service.user.ExceptionHandler;

import com.user.service.user.Response.Response;
import com.user.service.user.customException.NullValueOrEmptyDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
    @Autowired
    private Response response;
    @ExceptionHandler(NullValueOrEmptyDataException.class)
    public ResponseEntity<Response>dataNullOrEmptyException(NullValueOrEmptyDataException exception){
        System.out.println(exception.getStackTrace());
        System.out.println(exception.getSuppressed());

         response.setData(exception.getCause());
         response.setError(exception.getMessage());
         response.setStatus(HttpStatus.BAD_REQUEST);
         return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
