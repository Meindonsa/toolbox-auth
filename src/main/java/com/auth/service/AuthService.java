package com.auth.service;

import com.auth.process.GoogleAuthProcess;
import com.auth.view.AuthSetupResponse;

import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Override
    public boolean verifyCode(String secret, int code) {
        return GoogleAuthProcess.isValidCode(secret, code);
    }

    @Override
    public AuthSetupResponse setup2FA(String userName, String appName) {
        String secret = GoogleAuthProcess.generateSecret();
        String otpAuthUrl = GoogleAuthProcess.getOtpAuthUrl(secret, userName, appName);
        String qrCodeBase64;
        try {
            qrCodeBase64 = GoogleAuthProcess.generateQRCodeBase64(otpAuthUrl);
        } catch (Exception e) {
            throw new RuntimeException("Erreur génération QR code", e);
        }
        return AuthSetupResponse.builder()
                .otpAuthUrl(otpAuthUrl)
                .secret(secret)
                .qrCodeBase64(qrCodeBase64)
                .build();
    }
}
