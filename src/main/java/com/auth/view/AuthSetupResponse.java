package com.auth.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthSetupResponse {
    private String secret;
    private String qrCodeBase64;
    private String otpAuthUrl;
}
