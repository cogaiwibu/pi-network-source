package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.b;
import com.tapjoy.internal.cb;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gi;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gw;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.he;
import com.tapjoy.internal.hg;
import com.tapjoy.internal.hi;
import com.tapjoy.internal.ij;
import com.tapjoy.internal.jq;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class TJCorePlacement {
    static final String a = TJCorePlacement.class.getSimpleName();
    private TJAdUnit.TJAdUnitVideoListener A = new TJAdUnit.TJAdUnitVideoListener() {
        /* class com.tapjoy.TJCorePlacement.AnonymousClass2 */

        @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
        public final void onVideoStart() {
            TJPlacement a2 = TJCorePlacement.this.a("SHOW");
            if (a2 != null && a2.getVideoListener() != null) {
                a2.getVideoListener().onVideoStart(a2);
            }
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
        public final void onVideoCompleted() {
            TJPlacement a2 = TJCorePlacement.this.a("SHOW");
            if (a2 != null && a2.getVideoListener() != null) {
                a2.getVideoListener().onVideoComplete(a2);
            }
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitVideoListener
        public final void onVideoError(String str) {
            TJPlacement a2 = TJCorePlacement.this.a("SHOW");
            if (a2 != null && a2.getVideoListener() != null) {
                a2.getVideoListener().onVideoError(a2, str);
            }
        }
    };
    Context b;
    TJPlacementData c;
    String d;
    long e;
    final fw f = new fw();
    TJAdUnit g;
    boolean h = false;
    hg i = null;
    boolean j;
    volatile boolean k = false;
    volatile boolean l = false;
    String m;
    String n;
    String o;
    String p;
    HashMap q;
    private Map r = new HashMap();
    private Map s;
    private fm t;
    private boolean u = false;
    private ij v = null;
    private volatile boolean w = false;
    private volatile boolean x = false;
    private boolean y;
    private TJAdUnit.TJAdUnitWebViewListener z = new TJAdUnit.TJAdUnitWebViewListener() {
        /* class com.tapjoy.TJCorePlacement.AnonymousClass1 */

        @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
        public final void onContentReady() {
            TJCorePlacement.this.e();
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
        public final void onClosed() {
            if (TJCorePlacement.this.h) {
                TJPlacementManager.decrementPlacementCacheCount();
                TJCorePlacement.this.h = false;
            }
            if (TJCorePlacement.this.u) {
                TJPlacementManager.decrementPlacementPreRenderCount();
                TJCorePlacement.this.u = false;
            }
        }

        @Override // com.tapjoy.TJAdUnit.TJAdUnitWebViewListener
        public final void onClick() {
            TJCorePlacement.e(TJCorePlacement.this);
        }
    };

    TJCorePlacement(String str, String str2, boolean z2) {
        Activity c2 = b.c();
        this.b = c2;
        if (c2 == null) {
            TapjoyLog.d(a, "getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        this.y = z2;
        TJPlacementData tJPlacementData = new TJPlacementData(str2, getPlacementContentUrl());
        this.c = tJPlacementData;
        tJPlacementData.setPlacementName(str);
        this.d = UUID.randomUUID().toString();
        TJAdUnit tJAdUnit = new TJAdUnit();
        this.g = tJAdUnit;
        tJAdUnit.setWebViewListener(this.z);
        this.g.setVideoListener(this.A);
    }

    /* access modifiers changed from: package-private */
    public final void a(TJPlacement tJPlacement) {
        boolean z2 = false;
        if (tJPlacement == null) {
            a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "Cannot request content from a NULL placement"));
            return;
        }
        a("REQUEST", tJPlacement);
        if (this.e - SystemClock.elapsedRealtime() > 0) {
            String str = a;
            TapjoyLog.d(str, "Content has not expired yet for " + this.c.getPlacementName());
            if (this.k) {
                gf.b("TJPlacement.requestContent").a(FirebaseAnalytics.Param.CONTENT_TYPE, a()).a(Constants.MessagePayloadKeys.FROM, "cache").c();
                this.x = false;
                b(tJPlacement);
                e();
                return;
            }
            gf.b("TJPlacement.requestContent").a(FirebaseAnalytics.Param.CONTENT_TYPE, "none").a(Constants.MessagePayloadKeys.FROM, "cache").c();
            b(tJPlacement);
            return;
        }
        if (this.k) {
            gf.c("TJPlacement.requestContent").a("was_available", (Object) true);
        }
        if (this.l) {
            gf.c("TJPlacement.requestContent").a("was_ready", (Object) true);
        }
        if (!jq.c(this.o)) {
            HashMap hashMap = new HashMap();
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_AGENT, this.o);
            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_ID, this.p);
            HashMap hashMap2 = this.q;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                z2 = true;
            }
            if (z2) {
                for (String str2 : this.q.keySet()) {
                    hashMap.put(TJAdUnitConstants.AUCTION_PARAM_PREFIX + str2, this.q.get(str2));
                }
                a(this.c.getAuctionMediationURL(), hashMap);
                return;
            }
            a(this.c.getMediationURL(), hashMap);
            return;
        }
        d();
    }

    private synchronized void d() {
        String url = this.c.getUrl();
        if (jq.c(url)) {
            url = getPlacementContentUrl();
            if (jq.c(url)) {
                gf.b("TJPlacement.requestContent").a("TJPlacement is missing APP_ID").c();
                a(TapjoyErrorMessage.ErrorType.SDK_ERROR, new TJError(0, "TJPlacement is missing APP_ID"));
                return;
            }
            this.c.updateUrl(url);
        }
        String str = a;
        TapjoyLog.d(str, "sendContentRequest -- URL: " + url + " name: " + this.c.getPlacementName());
        a(url, (Map) null);
    }

    private synchronized void a(final String str, Map map) {
        if (this.w) {
            String str2 = a;
            TapjoyLog.i(str2, "Placement " + this.c.getPlacementName() + " is already requesting content");
            gf.b("TJPlacement.requestContent").b("already doing").c();
            return;
        }
        this.c.resetPlacementRequestData();
        fw fwVar = this.f;
        String str3 = null;
        fwVar.b = null;
        fwVar.d = null;
        fwVar.a = null;
        this.g.resetContentLoadState();
        this.w = false;
        this.x = false;
        this.k = false;
        this.l = false;
        this.i = null;
        this.v = null;
        this.w = true;
        final TJPlacement a2 = a("REQUEST");
        if (!this.y) {
            Map genericURLParams = TapjoyConnectCore.getGenericURLParams();
            this.s = genericURLParams;
            genericURLParams.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        } else {
            Map limitedGenericURLParams = TapjoyConnectCore.getLimitedGenericURLParams();
            this.s = limitedGenericURLParams;
            limitedGenericURLParams.putAll(TapjoyConnectCore.getLimitedTimeStampAndVerifierParams());
        }
        TapjoyUtil.safePut(this.s, "event_name", this.c.getPlacementName(), true);
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, "true", true);
        TapjoyUtil.safePut(this.s, "debug", Boolean.toString(gw.a), true);
        gz a3 = gz.a();
        Map map2 = this.s;
        if (a3.b != null) {
            hi hiVar = a3.b;
            hiVar.b();
            str3 = hiVar.b.a();
        }
        TapjoyUtil.safePut(map2, TJAdUnitConstants.PARAM_ACTION_ID_EXCLUSION, str3, true);
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PLACEMENT_BY_SDK, String.valueOf(this.j), true);
        TapjoyUtil.safePut(this.s, TJAdUnitConstants.PARAM_PUSH_ID, a2.pushId, true);
        TapjoyUtil.safePut(this.s, TapjoyConstants.TJC_MEDIATION_SOURCE, this.m, true);
        TapjoyUtil.safePut(this.s, TapjoyConstants.TJC_ADAPTER_VERSION, this.n, true);
        if (!jq.c(TapjoyConnectCore.getCustomParameter())) {
            TapjoyUtil.safePut(this.s, TapjoyConstants.TJC_CUSTOM_PARAMETER, TapjoyConnectCore.getCustomParameter(), true);
        }
        if (map != null) {
            this.s.putAll(map);
        }
        final fi fiVar = new fi(ga.b().b("placement_request_content_retry_timeout"));
        final gi c2 = ga.b().c("placement_request_content_retry_backoff");
        final gf.a d2 = gf.d("TJPlacement.requestContent");
        new Thread() {
            /* class com.tapjoy.TJCorePlacement.AnonymousClass3 */

            public final void run() {
                gf.a("TJPlacement.requestContent", d2);
                int i = 0;
                while (!a()) {
                    i++;
                    TJCorePlacement.this.s.put(TapjoyConstants.TJC_RETRY, Integer.toString(i));
                    if (i == 1) {
                        d2.a("retry_timeout", Long.valueOf(fiVar.b));
                    }
                    d2.a("retry_count", (long) i);
                }
            }

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0317 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private boolean a() {
                /*
                // Method dump skipped, instructions count: 802
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.TJCorePlacement.AnonymousClass3.a():boolean");
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean b(String str) {
        try {
            ij.a aVar = (ij.a) this.v.a(URI.create(this.c.getUrl()), new ByteArrayInputStream(str.getBytes()));
            this.i = aVar.a;
            aVar.a.b();
            if (!aVar.a.c()) {
                TapjoyLog.e(a, "Failed to load fiverocks placement");
                return false;
            }
            fq fqVar = null;
            if (this.i instanceof he) {
                fqVar = new fu(this.c.getPlacementName(), this.c.getPlacementType(), this.t);
            } else if (this.i instanceof gv) {
                fqVar = new fv(this.c.getPlacementName(), this.c.getPlacementType(), this.t);
            }
            this.f.a = fqVar;
            return true;
        } catch (IOException e2) {
            TapjoyLog.e(a, e2.toString());
            e2.printStackTrace();
            return false;
        } catch (cb e3) {
            TapjoyLog.e(a, e3.toString());
            e3.printStackTrace();
            return false;
        }
    }

    public Context getContext() {
        return this.b;
    }

    public void setContext(Context context) {
        this.b = context;
    }

    public TJAdUnit getAdUnit() {
        return this.g;
    }

    public TJPlacementData getPlacementData() {
        return this.c;
    }

    public boolean isContentReady() {
        return this.l;
    }

    public boolean isContentAvailable() {
        return this.k;
    }

    public String getPlacementContentUrl() {
        String b2 = b();
        if (!jq.c(b2)) {
            return TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b2 + "/content?";
        }
        TapjoyLog.i(a, "Placement content URL cannot be generated for null app ID");
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        if (this.i != null) {
            return "mm";
        }
        return this.k ? "ad" : "none";
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, TJPlacement tJPlacement) {
        synchronized (this.r) {
            this.r.put(str, tJPlacement);
            if (tJPlacement != null) {
                String str2 = a;
                TapjoyLog.d(str2, "Setting " + str + " placement: " + tJPlacement.getGUID());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final TJPlacement a(String str) {
        TJPlacement tJPlacement;
        synchronized (this.r) {
            tJPlacement = (TJPlacement) this.r.get(str);
            if (tJPlacement != null) {
                String str2 = a;
                TapjoyLog.d(str2, "Returning " + str + " placement: " + tJPlacement.getGUID());
            }
        }
        return tJPlacement;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(TJPlacement tJPlacement) {
        fw fwVar = this.f;
        String placementName = this.c.getPlacementName();
        String placementType = this.c.getPlacementType();
        String a2 = a();
        fwVar.c = 0;
        fwVar.b = gf.e("PlacementContent.funnel").a().a(IronSourceConstants.EVENTS_PLACEMENT_NAME, placementName).a("placement_type", placementType).a(FirebaseAnalytics.Param.CONTENT_TYPE, a2).a("state", Integer.valueOf(fwVar.c));
        fwVar.b.c();
        if (!"none".equals(a2)) {
            fwVar.e = gf.e("PlacementContent.ready").a().a(IronSourceConstants.EVENTS_PLACEMENT_NAME, placementName).a("placement_type", placementType).a(FirebaseAnalytics.Param.CONTENT_TYPE, a2);
        }
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            String str = a;
            TapjoyLog.i(str, "Content request delivered successfully for placement " + this.c.getPlacementName() + ", contentAvailable: " + isContentAvailable() + ", mediationAgent: " + this.o);
            tJPlacement.getListener().onRequestSuccess(tJPlacement);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        a(a("REQUEST"), errorType, tJError);
    }

    /* access modifiers changed from: package-private */
    public final void a(TJPlacement tJPlacement, TapjoyErrorMessage.ErrorType errorType, TJError tJError) {
        String str = a;
        TapjoyLog.e(str, new TapjoyErrorMessage(errorType, "Content request failed for placement " + this.c.getPlacementName() + "; Reason= " + tJError.message));
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        if (!this.x) {
            this.l = true;
            String str = a;
            TapjoyLog.i(str, "Content is ready for placement " + this.c.getPlacementName());
            if (this.g.isPrerendered()) {
                fw fwVar = this.f;
                gf.a aVar = fwVar.b;
                if (aVar != null) {
                    aVar.a("prerendered", (Object) true);
                }
                gf.a aVar2 = fwVar.e;
                if (aVar2 != null) {
                    aVar2.a("prerendered", (Object) true);
                }
            }
            fw fwVar2 = this.f;
            gf.a aVar3 = fwVar2.e;
            if (aVar3 != null) {
                fwVar2.e = null;
                aVar3.b().c();
            }
            TJPlacement a2 = a("REQUEST");
            if (a2 != null && a2.getListener() != null) {
                a2.getListener().onContentReady(a2);
                this.x = true;
            }
        }
    }

    public boolean isLimited() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        if (!this.y) {
            return TapjoyConnectCore.getAppID();
        }
        return TapjoyConnectCore.getLimitedAppID();
    }

    static /* synthetic */ void e(TJCorePlacement tJCorePlacement) {
        TJPlacement a2 = tJCorePlacement.a("SHOW");
        String str = a;
        TapjoyLog.i(str, "Handle onClick for placement " + tJCorePlacement.c.getPlacementName());
        if (a2 != null && a2.getListener() != null) {
            a2.getListener().onClick(a2);
        }
    }

    static /* synthetic */ String g(TJCorePlacement tJCorePlacement) {
        return tJCorePlacement.c.getPlacementName();
    }

    static /* synthetic */ void j(TJCorePlacement tJCorePlacement) {
        fm fmVar = new fm(tJCorePlacement.c.getPlacementName(), tJCorePlacement.c.getPlacementType());
        tJCorePlacement.t = fmVar;
        tJCorePlacement.g.setAdContentTracker(fmVar);
    }

    static /* synthetic */ void a(TJCorePlacement tJCorePlacement, String str) {
        if (str != null) {
            try {
                String str2 = a;
                TapjoyLog.d(str2, "Disable preload flag is set for placement " + tJCorePlacement.c.getPlacementName());
                tJCorePlacement.c.setRedirectURL(new JSONObject(str).getString(TapjoyConstants.TJC_REDIRECT_URL));
                tJCorePlacement.c.setPreloadDisabled(true);
                tJCorePlacement.c.setHasProgressSpinner(true);
                String str3 = a;
                TapjoyLog.d(str3, "redirect_url:" + tJCorePlacement.c.getRedirectURL());
            } catch (JSONException unused) {
                throw new TapjoyException("TJPlacement request failed, malformed server response");
            }
        } else {
            throw new TapjoyException("TJPlacement request failed due to null response");
        }
    }

    static /* synthetic */ void l(TJCorePlacement tJCorePlacement) {
        tJCorePlacement.k = true;
        tJCorePlacement.b(tJCorePlacement.a("REQUEST"));
    }
}
