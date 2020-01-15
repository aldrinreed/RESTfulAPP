package com.firstSpringProject.app.ws.ui.model.response;

/**
 * Title:  mobile-app-webservice
 * Author: Aldrin Warrick
 * Date:   10/28/2019
 * Time:   4:56 PM
 */
public class UserREST {
        private String userID;
        private String firstName;
        private String lastName;
        private String email;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
