package com.example.exceptions.dto;

public class MyErrorResponse {

    private Integer status;
    private String error;

    public MyErrorResponse() {
    }

    public MyErrorResponse(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
