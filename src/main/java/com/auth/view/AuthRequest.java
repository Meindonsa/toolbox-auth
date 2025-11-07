package com.auth.view;

import com.auth.enumeration.AuthType;

import lombok.Data;

@Data
public class AuthRequest {
    private AuthType type;
    private String appName;
    private String userName;
}
