package com.appliation.rmis.dtos.response.userResponse.staffResponse;

import lombok.Data;

@Data
public class StaffSignUpResponse {
    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
