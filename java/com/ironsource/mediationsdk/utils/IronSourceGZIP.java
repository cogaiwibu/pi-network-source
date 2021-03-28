package com.ironsource.mediationsdk.utils;

import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class IronSourceGZIP {
    public static byte[] compress(String str) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("compressed string: " + Base64.encodeToString(byteArray, 0));
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String decompress(byte[] bArr) {
        try {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("compressed string: " + Base64.encodeToString(bArr, 0));
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("exception while decompressing " + e);
            return null;
        }
    }
}
