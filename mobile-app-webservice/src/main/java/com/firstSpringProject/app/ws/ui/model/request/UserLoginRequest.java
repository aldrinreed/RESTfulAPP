package com.firstSpringProject.app.ws.ui.model.request;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/30/2019
 * Time:   2:52 PM
 */


public class UserLoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
