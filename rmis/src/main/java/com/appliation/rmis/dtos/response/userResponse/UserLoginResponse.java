package com.appliation.rmis.dtos.response.userResponse;

import com.appliation.rmis.data.models.Roles;
import lombok.Data;

@Data
public class UserLoginResponse {
    private Roles role;
    private String token;

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
