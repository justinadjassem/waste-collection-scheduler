package com.wcs.waste_collection_scheduler.utils;

import com.wcs.waste_collection_scheduler.citizen.CitizenNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CitizenNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleCitizenNotFoundException(CitizenNotFoundException citizenNotFoundException, HttpServletRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Citizen Not Found",
                citizenNotFoundException.getMessage(),
                request.getRequestURI()
        );
        // Renvoie de message d'erreur à l'utilisateur
        //Map<String, String> response = new HashMap<>();
        //response.put("error", "Citizen Not Found");
        //response.put("message", citizenNotFoundException.getMessage());
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
