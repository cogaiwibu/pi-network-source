package com.tapjoy;

import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.ironsource.sdk.constants.Constants;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

public class HmacSignature {
    private String a;
    private String b;

    public HmacSignature(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String sign(String str, Map map) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.b.getBytes(), this.a);
            Mac instance = Mac.getInstance(this.a);
            instance.init(secretKeySpec);
            Uri parse = Uri.parse(str);
            String str2 = parse.getScheme() + "://" + parse.getHost();
            if (!((parse.getScheme().equals(UriUtil.HTTP_SCHEME) && parse.getPort() == 80) || (parse.getScheme().equals(UriUtil.HTTPS_SCHEME) && parse.getPort() == 443)) && -1 != parse.getPort()) {
                str2 = str2 + ":" + parse.getPort();
            }
            String str3 = str2.toLowerCase() + parse.getPath();
            String a2 = a(map);
            String str4 = "POST&" + Uri.encode(str3) + Constants.RequestParameters.AMPERSAND + Uri.encode(a2);
            TapjoyLog.v("HmacSignature", "Base Url: " + str4);
            byte[] doFinal = instance.doFinal(str4.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : doFinal) {
                String hexString = Integer.toHexString(b2 & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean matches(String str, Map map, String str2) {
        return sign(str, map).equals(str2);
    }

    private static String a(Map map) {
        TreeSet treeSet = new TreeSet(map.keySet());
        StringBuilder sb = new StringBuilder();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            sb.append(str + Constants.RequestParameters.EQUAL + ((String) map.get(str)) + Constants.RequestParameters.AMPERSAND);
        }
        sb.deleteCharAt(sb.lastIndexOf(Constants.RequestParameters.AMPERSAND));
        TapjoyLog.v("HmacSignature", "Unhashed String: " + sb.toString());
        return sb.toString();
    }
}
