package com.grydtech.ibuy.orderservice.responses;


public class GenericResponse {
    private Integer status;
    private String message;

    public GenericResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}