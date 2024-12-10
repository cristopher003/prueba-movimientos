package com.example.prueba.application.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data 
@AllArgsConstructor  
public class ErrorResponse {
    // Información detallada del error
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

   
    public static ErrorResponse create(int status, String error, String message, String path) {
        return new ErrorResponse(
            LocalDateTime.now(),
            status,
            error,
            message,
            path
        );
    }

}
