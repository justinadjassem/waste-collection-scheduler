package com.wcs.waste_collection_scheduler.citizen;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CitizenGlobalExceptionHandler {
    @ExceptionHandler(CitizenNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCitizenNotFoundException(CitizenNotFoundException citizenNotFoundException) {
        // Renvoie de message d'erreur à l'utilisateur
        Map<String, String> response = new HashMap<>();
        response.put("error", "Citizen Not Found");
        response.put("message", citizenNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

}
