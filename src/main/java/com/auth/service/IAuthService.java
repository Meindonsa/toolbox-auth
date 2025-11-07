package com.auth.service;

import com.auth.view.AuthSetupResponse;

public interface IAuthService {

    boolean verifyCode(String secret, int code);

    AuthSetupResponse setup2FA(String userName, String appName);
}
