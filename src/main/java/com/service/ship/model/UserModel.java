package com.service.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.service.ship.audit.Auditable;

@Entity
@Table(name="user_ship")
public class UserModel extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "encryted_password")
    private String encrytedPassword;

    @Column(name = "enabled")
    private boolean enabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
