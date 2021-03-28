package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.c.b;
import com.bytedance.sdk.openadsdk.c.c;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.g.k;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.v;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TTAndroidObject */
public class r implements b, v.a {
    private static final Map<String, Boolean> d;
    protected Map<String, Object> a;
    private WeakReference<WebView> b;
    private v c;
    private WeakReference<Context> e;
    private c f;
    private String g;
    private String h;
    private int i;
    private String j;
    private int k;
    private boolean l = true;
    private g m;

    /* compiled from: TTAndroidObject */
    public static class a {
        public String a;
        public String b;
        public String c;
        public JSONObject d;
        public int e;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        d = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        d.put("private", Boolean.TRUE);
        d.put("dispatch_message", Boolean.TRUE);
    }

    public r a(g gVar) {
        this.m = gVar;
        return this;
    }

    public r(Context context) {
        this.e = new WeakReference<>(context);
        this.c = new v(Looper.getMainLooper(), this);
    }

    private WebView d() {
        WeakReference<WebView> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public r a(WebView webView) {
        this.b = new WeakReference<>(webView);
        return this;
    }

    public r a(String str) {
        this.g = str;
        return this;
    }

    public r a(int i2) {
        this.k = i2;
        return this;
    }

    public r b(String str) {
        this.h = str;
        return this;
    }

    public r b(int i2) {
        this.i = i2;
        return this;
    }

    public r c(String str) {
        this.j = str;
        return this;
    }

    private List<String> e() {
        return Arrays.asList("appInfo", "adInfo");
    }

    public r a(Map<String, Object> map) {
        this.a = map;
        return this;
    }

    private void a(JSONObject jSONObject, int i2) throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String str : e()) {
            jSONArray.put(str);
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.a.a.a());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.a.a.e());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.a.a.b());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.a.a.c());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.a.a.d());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.a.a.f());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.a.a.a(j.a()));
    }

    private void a(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("cid", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("log_extra", this.h);
        }
        if (!TextUtils.isEmpty(this.j)) {
            jSONObject.put("download_url", this.j);
        }
    }

    private void a(a aVar) throws Exception {
        JSONObject jSONObject;
        if (NotificationCompat.CATEGORY_CALL.equals(aVar.a)) {
            JSONObject jSONObject2 = new JSONObject();
            if ("appInfo".equals(aVar.c)) {
                if (!TextUtils.isEmpty(aVar.b)) {
                    a(jSONObject2, aVar.e);
                    b(aVar.b, jSONObject2);
                }
            } else if ("adInfo".equals(aVar.c)) {
                if (!TextUtils.isEmpty(aVar.b)) {
                    a(jSONObject2);
                    b(aVar.b, jSONObject2);
                }
            } else if ("sendLog".equals(aVar.c)) {
                JSONObject jSONObject3 = aVar.d;
                if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("extJson")) != null && jSONObject.has("category") && jSONObject.has(ViewHierarchyConstants.TAG_KEY) && jSONObject.has("label")) {
                    String string = jSONObject.getString("category");
                    jSONObject.getString(ViewHierarchyConstants.TAG_KEY);
                    String string2 = jSONObject.getString("label");
                    long j2 = jSONObject3.getLong("value");
                    long j3 = jSONObject3.getLong("extValue");
                    try {
                        jSONObject.putOpt("ua_policy", Integer.valueOf(this.k));
                    } catch (Exception unused) {
                    }
                    if (TJAdUnitConstants.String.CLICK.equals(string2)) {
                        jSONObject = c(jSONObject);
                    }
                    d.a(this.m, string, t.a(this.i), string2, j2, j3, jSONObject);
                }
            } else {
                boolean a2 = a(aVar, jSONObject2);
                if (!TextUtils.isEmpty(aVar.b) && a2) {
                    b(aVar.b, jSONObject2);
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean a(a aVar, JSONObject jSONObject) {
        char c2;
        Context context;
        WeakReference<Context> weakReference;
        Context context2;
        WeakReference<Context> weakReference2;
        Context context3;
        String str = aVar.c;
        switch (str.hashCode()) {
            case -2036781162:
                if (str.equals("subscribe_app_ad")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 27837080:
                if (str.equals("download_app_ad")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 105049135:
                if (str.equals("unsubscribe_app_ad")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 672928467:
                if (str.equals("cancel_download_app_ad")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 2105008900:
                if (str.equals("landscape_click")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 == 1 || c2 == 2) {
                if (!(this.f == null || (weakReference = this.e) == null || (context2 = weakReference.get()) == null)) {
                    this.f.a(context2, aVar.d);
                }
            } else if (c2 == 3) {
                c cVar = this.f;
                if (cVar == null) {
                    return false;
                }
                cVar.a(aVar.d);
            } else if (c2 == 4 && (weakReference2 = this.e) != null && (context3 = weakReference2.get()) != null && (context3 instanceof TTBaseVideoActivity)) {
                ((TTBaseVideoActivity) context3).k();
            }
            return false;
        }
        f();
        WeakReference<Context> weakReference3 = this.e;
        if (!(weakReference3 == null || (context = weakReference3.get()) == null)) {
            this.f.a(context, aVar.d, this.h, this.i, this.l);
        }
        return false;
    }

    private void b(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            b(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        WebView d2;
        if (jSONObject != null && (d2 = d()) != null) {
            String str = "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")";
            k.a(d2, str);
            if (l.a()) {
                l.a("TTAndroidObject", "js_msg " + str);
            }
        }
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("__msg_type", "event");
                jSONObject2.put("__event_id", str);
                if (jSONObject != null) {
                    jSONObject2.put("__params", jSONObject);
                }
                b(jSONObject2);
            }
        } catch (Exception unused) {
        }
    }

    private void d(String str) {
        try {
            String str2 = new String(Base64.decode(str, 2));
            l.b("TTAndroidObject", str2);
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                a aVar = new a();
                aVar.a = jSONObject.getString("__msg_type");
                aVar.b = jSONObject.optString("__callback_id", null);
                aVar.c = jSONObject.optString("func");
                aVar.d = jSONObject.optJSONObject("params");
                aVar.e = jSONObject.optInt("JSSDK");
                if (!TextUtils.isEmpty(aVar.a)) {
                    if (!TextUtils.isEmpty(aVar.c)) {
                        Message obtainMessage = this.c.obtainMessage(11);
                        obtainMessage.obj = aVar;
                        this.c.sendMessage(obtainMessage);
                    }
                }
            }
        } catch (Exception unused) {
            if (l.a()) {
                l.d("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
                return;
            }
            l.d("TTAndroidObject", "failed to parse jsbridge msg queue");
        }
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (d.containsKey(uri.getHost())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public void b(Uri uri) {
        long j2;
        try {
            String host = uri.getHost();
            if ("log_event".equals(host)) {
                String queryParameter = uri.getQueryParameter("category");
                uri.getQueryParameter(ViewHierarchyConstants.TAG_KEY);
                String queryParameter2 = uri.getQueryParameter("label");
                long j3 = 0;
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("value"));
                } catch (Exception unused) {
                    j2 = 0;
                }
                try {
                    j3 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                JSONObject jSONObject = null;
                String queryParameter3 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(queryParameter3);
                        try {
                            jSONObject2.putOpt("ua_policy", Integer.valueOf(this.k));
                        } catch (Exception unused3) {
                        }
                        jSONObject = jSONObject2;
                    } catch (Exception unused4) {
                    }
                }
                d.a(this.m, queryParameter, t.a(this.i), queryParameter2, j2, j3, TJAdUnitConstants.String.CLICK.equals(queryParameter2) ? c(jSONObject) : jSONObject);
            } else if ("private".equals(host) || "dispatch_message".equals(host)) {
                e(uri.toString());
            } else {
                Log.w("TTAndroidObject", "handlrUir: not match schema host");
            }
        } catch (Exception e2) {
            Log.w("TTAndroidObject", "handleUri exception: " + e2);
        }
    }

    private JSONObject c(JSONObject jSONObject) {
        if (this.a != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                for (Map.Entry<String, Object> entry : this.a.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e2) {
                l.b(e2.toString());
            }
        }
        return jSONObject;
    }

    private void e(String str) {
        int indexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    WebView d2 = d();
                    if (d2 != null) {
                        k.a(d2, "javascript:ToutiaoJSBridge._fetchQueue()");
                    }
                } else if (str.startsWith("bytedance://private/setresult/") && (indexOf = str.indexOf(38, 30)) > 0) {
                    String substring = str.substring(30, indexOf);
                    String substring2 = str.substring(indexOf + 1);
                    if (substring.equals("SCENE_FETCHQUEUE") && substring2.length() > 0) {
                        d(substring2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void b() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void c() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof a)) {
            try {
                a((a) message.obj);
            } catch (Exception unused) {
            }
        }
    }

    private void f() {
        if (this.f == null) {
            this.f = com.bytedance.sdk.openadsdk.c.a.a(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.b
    public void a(String str, JSONObject jSONObject) {
        c(str, jSONObject);
    }
}
