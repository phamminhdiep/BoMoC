package com.example.BoMoC.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    private String status;
    private String message;
    private Object data;

    public ApiResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResponseEntity<Object> buildResponseSuccess(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Success");
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Object> buildResponseError(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Failed");
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.FAILED_DEPENDENCY);
    }
}
