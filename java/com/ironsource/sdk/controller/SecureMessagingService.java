package com.ironsource.sdk.controller;

import com.facebook.appevents.AppEventsConstants;
import com.ironsource.sdk.utils.MD5Hashing;
import java.security.MessageDigest;
import java.util.UUID;
import kotlin.UByte;

/* access modifiers changed from: package-private */
public final class SecureMessagingService {
    private static final String SECURE_HASHING_ALGORITHM = "MD5";
    private String mTokenForMessaging;

    SecureMessagingService(String str) {
        this.mTokenForMessaging = str;
    }

    static String generateToken() {
        return UUID.randomUUID().toString();
    }

    private String hashMessage(String str) {
        try {
            return MD5Hashing.getHashString(str);
        } catch (Exception e) {
            e.printStackTrace();
            return hashWithDigest(str);
        }
    }

    private String hashWithDigest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(SECURE_HASHING_ALGORITHM);
            instance.update(str.getBytes());
            return formatDigestToString(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String formatDigestToString(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() < 2) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public boolean isValidMessage(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(hashMessage(str + str2 + this.mTokenForMessaging));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public String getTokenForMessaging() {
        return this.mTokenForMessaging;
    }
}
