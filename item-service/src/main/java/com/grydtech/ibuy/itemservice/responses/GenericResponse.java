package com.grydtech.ibuy.itemservice.responses;


public class GenericResponse implements Response{
    private Integer status;
    private String message;

    public GenericResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public GenericResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GenericResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}