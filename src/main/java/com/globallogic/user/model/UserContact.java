package com.globallogic.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by cristianfgr on 12-02-20.
 */
@Entity
@Table(name = "users",
       uniqueConstraints = {@UniqueConstraint(columnNames = "email")} )
public class UserContact extends AuditUser {

    @Id
    private String id;

    @NotEmpty(message = "name may not be empty")
    private String name;

    @NotEmpty(message = "Email may not be empty")
    @Email(message = "Email must be a well-formed email address")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "password may not be empty")
    @Size(min = 5, message = "the minimum length for the password allowed is 5 characters")
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userContact")
    @JsonProperty("phones")
    private List<UserInformation> userInformations;

    @JsonProperty("last_login")
    private Date lastLogin;

    private String token;

    @JsonProperty("isactive")
    private boolean isActive;

    public UserContact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<UserInformation> getUserInformations() {
        return userInformations;
    }

    public void setUserInformations(List<UserInformation> userInformations) {
        this.userInformations = userInformations;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
