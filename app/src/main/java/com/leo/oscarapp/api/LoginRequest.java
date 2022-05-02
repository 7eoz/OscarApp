package com.leo.oscarapp.api;

public class LoginRequest {

    private String email;
    private String password_hash;

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password_hash;
    }

    public void setPassword(String password_hash) {
        this.password_hash = password_hash;
    }
}
