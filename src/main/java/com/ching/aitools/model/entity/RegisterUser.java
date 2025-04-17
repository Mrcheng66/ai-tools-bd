package com.ching.aitools.model.entity;

import lombok.Data;

@Data
public class RegisterUser {
    public String username;

    public String password;

    public String secondPassword;
}
