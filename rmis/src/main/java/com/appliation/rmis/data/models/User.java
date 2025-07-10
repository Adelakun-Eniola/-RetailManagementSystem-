package com.appliation.rmis.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Long phoneNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Roles Roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public com.appliation.rmis.data.models.Roles getRoles() {
        return Roles;
    }

    public void setRoles(com.appliation.rmis.data.models.Roles roles) {
        Roles = roles;
    }
}
