package ru.kpfu.models;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Integer id;
    private String role;
    private Integer user_id;

    public Role(Integer id, Integer user_id, String role) {
        this.id = id;
        this.user_id = user_id;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
