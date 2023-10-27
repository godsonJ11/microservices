package com.productModule.product.Response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class Response {
    private HttpStatus status;
    private String error;
    private  Object data;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
