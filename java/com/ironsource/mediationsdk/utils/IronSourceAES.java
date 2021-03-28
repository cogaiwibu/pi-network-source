package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class IronSourceAES {
    public static synchronized String encode(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                return encodeFromBytes(str, str2.getBytes("UTF8"));
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static synchronized String encodeFromBytes(String str, byte[] bArr) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (bArr == null) {
                return "";
            }
            try {
                SecretKeySpec key = getKey(str);
                byte[] bArr2 = new byte[16];
                Arrays.fill(bArr2, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(1, key, ivParameterSpec);
                return Base64.encodeToString(instance.doFinal(bArr), 0).replaceAll(System.getProperty("line.separator"), "");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static synchronized String decode(String str, String str2) {
        synchronized (IronSourceAES.class) {
            byte[] decodeToBytes = decodeToBytes(str, str2);
            if (decodeToBytes == null) {
                return "";
            }
            return new String(decodeToBytes);
        }
    }

    public static synchronized byte[] decodeToBytes(String str, String str2) {
        synchronized (IronSourceAES.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                SecretKeySpec key = getKey(str);
                byte[] bArr = new byte[16];
                Arrays.fill(bArr, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                byte[] decode = Base64.decode(str2, 0);
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
                instance.init(2, key, ivParameterSpec);
                return instance.doFinal(decode);
            } catch (Exception e) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception on decryption error: " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    private static SecretKeySpec getKey(String str) throws UnsupportedEncodingException {
        int i = 32;
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        byte[] bytes = str.getBytes("UTF-8");
        if (bytes.length < 32) {
            i = bytes.length;
        }
        System.arraycopy(bytes, 0, bArr, 0, i);
        return new SecretKeySpec(bArr, "AES");
    }
}
