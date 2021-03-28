package com.tapjoy.internal;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONObject;

public final class dc {
    private final cz a;

    private dc(cz czVar) {
        this.a = czVar;
    }

    private static void b(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Invalid Video volume");
        }
    }

    public static dc a(cs csVar) {
        cz czVar = (cz) csVar;
        Cdo.a(csVar, "AdSession is null");
        if (!(cw.NATIVE == czVar.a.b)) {
            throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
        } else if (!czVar.d) {
            Cdo.a(czVar);
            if (czVar.c.c == null) {
                dc dcVar = new dc(czVar);
                czVar.c.c = dcVar;
                return dcVar;
            }
            throw new IllegalStateException("VideoEvents already exists for AdSession");
        } else {
            throw new IllegalStateException("AdSession is started");
        }
    }

    public final void a(db dbVar) {
        Cdo.a(dbVar, "VastProperties is null");
        Cdo.a(this.a);
        this.a.c.a(Constants.ParametersKeys.LOADED, dbVar.a());
    }

    public final void a(float f, float f2) {
        if (f > 0.0f) {
            b(f2);
            Cdo.b(this.a);
            JSONObject jSONObject = new JSONObject();
            dm.a(jSONObject, IronSourceConstants.EVENTS_DURATION, Float.valueOf(f));
            dm.a(jSONObject, "videoPlayerVolume", Float.valueOf(f2));
            dm.a(jSONObject, "deviceVolume", Float.valueOf(dh.a().a));
            this.a.c.a("start", jSONObject);
            return;
        }
        throw new IllegalArgumentException("Invalid Video duration");
    }

    public final void a() {
        Cdo.b(this.a);
        this.a.c.a(TJAdUnitConstants.String.VIDEO_FIRST_QUARTILE);
    }

    public final void b() {
        Cdo.b(this.a);
        this.a.c.a(TJAdUnitConstants.String.VIDEO_MIDPOINT);
    }

    public final void c() {
        Cdo.b(this.a);
        this.a.c.a(TJAdUnitConstants.String.VIDEO_THIRD_QUARTILE);
    }

    public final void d() {
        Cdo.b(this.a);
        this.a.c.a(TJAdUnitConstants.String.VIDEO_COMPLETE);
    }

    public final void e() {
        Cdo.b(this.a);
        this.a.c.a("pause");
    }

    public final void f() {
        Cdo.b(this.a);
        this.a.c.a("resume");
    }

    public final void g() {
        Cdo.b(this.a);
        this.a.c.a(TJAdUnitConstants.String.VIDEO_BUFFER_START);
    }

    public final void h() {
        Cdo.b(this.a);
        this.a.c.a("bufferFinish");
    }

    public final void i() {
        Cdo.b(this.a);
        this.a.c.a(TJAdUnitConstants.String.VIDEO_SKIPPED);
    }

    public final void a(float f) {
        b(f);
        Cdo.b(this.a);
        JSONObject jSONObject = new JSONObject();
        dm.a(jSONObject, "videoPlayerVolume", Float.valueOf(f));
        dm.a(jSONObject, "deviceVolume", Float.valueOf(dh.a().a));
        this.a.c.a("volumeChange", jSONObject);
    }
}
