package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.g.l;
import com.ironsource.sdk.constants.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
/* compiled from: GetRequest */
public class d {
    private static final Pattern f = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern g = Pattern.compile("GET /(.*) HTTP");
    public final String a;
    public final long b;
    public boolean c;
    public int d = 204800;
    public boolean e;

    public d(String str) {
        boolean z = false;
        this.e = false;
        l.a(str);
        long a2 = a(str);
        this.b = Math.max(0L, a2);
        this.c = a2 >= 0 ? true : z;
        this.a = b(str);
        l.b("GetRequest", "GetRequest 解析后的uri= " + this.a);
    }

    public static d a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private long a(String str) {
        Matcher matcher = f.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1;
    }

    private String b(String str) {
        Matcher matcher = g.matcher(str);
        if (matcher.find()) {
            String c2 = o.c(matcher.group(1));
            if ("ping".equalsIgnoreCase(c2)) {
                return matcher.group(1);
            }
            l.b("GetRequest", "解码后的url decode =" + c2);
            String[] strArr = {c2};
            if (c2.contains("hasPrefix=false")) {
                strArr = c2.split("\\?size=");
                l.b("GetRequest", "原始url 无'?'符号-HAS_NOT_PREFIX- 分切后的urls: " + strArr[1]);
                strArr[1] = "size=" + strArr[1];
                l.b("GetRequest", "原始url 无'?'符号-HAS_NOT_PREFIX- 分切后拼接的urls: " + strArr[1]);
            } else if (c2.contains("hasPrefix=true")) {
                strArr = c2.split("&size=");
                l.b("GetRequest", "原始url 有'?'符号-HAS_PREFIX--分切后的urls: " + strArr[1]);
                strArr[1] = "size=" + strArr[1];
                l.b("GetRequest", "原始url 有'?'符号---分切后拼接的urls: " + strArr[1]);
            }
            if (strArr.length == 2 && strArr[1] != null) {
                String[] split = strArr[1].split(Constants.RequestParameters.AMPERSAND);
                l.b("GetRequest", "预加载传递过来的参数：params[0]=" + split[0] + ",params[1]=" + split[1]);
                if (split[0] != null) {
                    String[] split2 = split[0].split(Constants.RequestParameters.EQUAL);
                    if (split2.length == 2) {
                        this.d = Integer.parseInt(split2[1]);
                    }
                }
                if (split[1] != null) {
                    String[] split3 = split[1].split(Constants.RequestParameters.EQUAL);
                    if (split3.length == 2) {
                        this.e = Boolean.parseBoolean(split3[1]);
                    }
                }
            }
            return strArr[0];
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{uri='" + this.a + '\'' + ", rangeOffset=" + this.b + ", partial=" + this.c + ", preloadSize=" + this.d + ", isPreloadRequest=" + this.e + '}';
    }
}
