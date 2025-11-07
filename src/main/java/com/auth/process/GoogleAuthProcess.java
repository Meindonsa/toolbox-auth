package com.auth.process;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.GoogleAuthenticatorQRGenerator;

import java.util.Base64;

public class GoogleAuthProcess {

    private GoogleAuthProcess() {}

    private static final GoogleAuthenticator gAuth = new GoogleAuthenticator();

    public static String generateSecret() {
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        return key.getKey();
    }

    public static String getOtpAuthUrl(String secret, String account, String issuer) {
        return GoogleAuthenticatorQRGenerator.getOtpAuthTotpURL(
                issuer, account, new GoogleAuthenticatorKey.Builder(secret).build());
    }

    public static String generateQRCodeBase64(String otpAuthUrl) throws Exception {
        BitMatrix matrix =
                new MultiFormatWriter().encode(otpAuthUrl, BarcodeFormat.QR_CODE, 250, 250);

        var baos = new java.io.ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", baos);
        String base64 = Base64.getEncoder().encodeToString(baos.toByteArray());
        return "data:image/png;base64," + base64;
    }

    public static boolean isValidCode(String secret, int code) {
        return gAuth.authorize(secret, code);
    }

    public static boolean isValidCodeWithTolerance(String secret, int code) {
        return gAuth.authorize(secret, code, System.currentTimeMillis());
    }
}
