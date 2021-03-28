package com.bytedance.sdk.openadsdk.multipro.b;

import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* compiled from: VideoControllerDataModel */
public class a {
    public boolean a;
    public boolean b;
    public boolean c;
    public long d;
    public long e;
    public long f;

    public a a(boolean z) {
        this.a = z;
        return this;
    }

    public a b(boolean z) {
        this.b = z;
        return this;
    }

    public a c(boolean z) {
        this.c = z;
        return this;
    }

    public a a(long j) {
        this.d = j;
        return this;
    }

    public a b(long j) {
        this.e = j;
        return this;
    }

    public a c(long j) {
        this.f = j;
        return this;
    }

    public static a a(c cVar) {
        a aVar = new a();
        aVar.f = cVar.g();
        aVar.a = cVar.p();
        aVar.e = cVar.i();
        aVar.d = cVar.l();
        return aVar;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.a);
            jSONObject.put("isFromVideoDetailPage", this.b);
            jSONObject.put("isFromDetailPage", this.c);
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, this.d);
            jSONObject.put("totalPlayDuration", this.e);
            jSONObject.put("currentPlayPosition", this.f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.a(jSONObject.optBoolean("isCompleted"));
        aVar.b(jSONObject.optBoolean("isFromVideoDetailPage"));
        aVar.c(jSONObject.optBoolean("isFromDetailPage"));
        aVar.a(jSONObject.optLong(IronSourceConstants.EVENTS_DURATION));
        aVar.b(jSONObject.optLong("totalPlayDuration"));
        aVar.c(jSONObject.optLong("currentPlayPosition"));
        return aVar;
    }

    public String toString() {
        return "VideoControllerDataModel{isCompleted=" + this.a + ", isFromVideoDetailPage=" + this.b + ", isFromDetailPage=" + this.c + ", duration=" + this.d + ", totalPlayDuration=" + this.e + ", currentPlayPosition=" + this.f + '}';
    }
}
