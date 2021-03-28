package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fn;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gs;
import com.tapjoy.internal.gv;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.he;
import com.tapjoy.internal.jq;
import java.util.HashMap;
import java.util.UUID;

public class TJPlacement {
    TJPlacementListener a;
    private TJCorePlacement b;
    private TJPlacementListener c;
    private TJPlacementVideoListener d;
    private String e;
    public String pushId;

    @Deprecated
    public TJPlacement(Context context, String str, TJPlacementListener tJPlacementListener) {
        TJCorePlacement a2 = TJPlacementManager.a(str);
        a2 = a2 == null ? TJPlacementManager.a(str, "", "", false, false) : a2;
        a2.setContext(context);
        a(a2, tJPlacementListener);
    }

    TJPlacement(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        a(tJCorePlacement, tJPlacementListener);
    }

    private void a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.b = tJCorePlacement;
        this.e = UUID.randomUUID().toString();
        this.c = tJPlacementListener;
        this.a = tJPlacementListener != null ? (TJPlacementListener) fn.a(tJPlacementListener, TJPlacementListener.class) : null;
        FiveRocksIntegration.addPlacementCallback(getName(), this);
    }

    public TJPlacementListener getListener() {
        return this.c;
    }

    public void setVideoListener(TJPlacementVideoListener tJPlacementVideoListener) {
        this.d = tJPlacementVideoListener;
    }

    public TJPlacementVideoListener getVideoListener() {
        return this.d;
    }

    public String getName() {
        return this.b.getPlacementData() != null ? this.b.getPlacementData().getPlacementName() : "";
    }

    public boolean isLimited() {
        return this.b.isLimited();
    }

    public boolean isContentReady() {
        boolean isContentReady = this.b.isContentReady();
        fw fwVar = this.b.f;
        if (isContentReady) {
            fwVar.a(4);
        } else {
            fwVar.a(2);
        }
        return isContentReady;
    }

    public boolean isContentAvailable() {
        this.b.f.a(1);
        return this.b.isContentAvailable();
    }

    public void setMediationId(String str) {
        this.b.p = str;
    }

    public void requestContent() {
        boolean z;
        String name = getName();
        TapjoyLog.i("TJPlacement", "requestContent() called for placement " + name);
        gf.a("TJPlacement.requestContent").a(IronSourceConstants.EVENTS_PLACEMENT_NAME, name).a("placement_type", this.b.c.getPlacementType());
        if (ge.a() != null && jq.c(ge.a().b)) {
            TapjoyLog.w("TJPlacement", "[INFO] Your application calls requestContent without having previously called setUserConsent. You can review Tapjoy supported consent API here - https://dev.tapjoy.com/sdk-integration/#sdk11122_gdpr_release.");
        }
        if (!isLimited()) {
            z = TapjoyConnectCore.isConnected();
        } else {
            z = TapjoyConnectCore.isLimitedConnected();
        }
        if (!z) {
            gf.b("TJPlacement.requestContent").b("not connected").c();
            a(new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
        } else if (this.b.getContext() == null) {
            gf.b("TJPlacement.requestContent").b("no context").c();
            a(new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
        } else if (jq.c(name)) {
            gf.b("TJPlacement.requestContent").b("invalid name").c();
            a(new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
        } else {
            try {
                this.b.a(this);
            } finally {
                gf.d("TJPlacement.requestContent");
            }
        }
    }

    public void showContent() {
        String name = getName();
        TapjoyLog.i("TJPlacement", "showContent() called for placement " + name);
        TJCorePlacement tJCorePlacement = this.b;
        gf.a("TJPlacement.showContent").a(IronSourceConstants.EVENTS_PLACEMENT_NAME, tJCorePlacement.c.getPlacementName()).a("placement_type", tJCorePlacement.c.getPlacementType()).a(FirebaseAnalytics.Param.CONTENT_TYPE, tJCorePlacement.a());
        fw fwVar = tJCorePlacement.f;
        fwVar.a(8);
        fq fqVar = fwVar.a;
        if (fqVar != null) {
            fqVar.a();
        }
        if (!this.b.isContentAvailable()) {
            TapjoyLog.e("TJPlacement", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            gf.b("TJPlacement.showContent").b("no content").c();
            return;
        }
        try {
            TJCorePlacement tJCorePlacement2 = this.b;
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                TapjoyLog.w(TJCorePlacement.a, "Only one view can be presented at a time.");
                gf.b("TJPlacement.showContent").b("another content showing").c();
            } else {
                if (TapjoyConnectCore.isViewOpen()) {
                    TapjoyLog.w(TJCorePlacement.a, "Will close N2E content.");
                    TJPlacementManager.dismissContentShowing(false);
                }
                tJCorePlacement2.a("SHOW", this);
                gf.a d2 = gf.d("TJPlacement.showContent");
                int i = 1;
                if (tJCorePlacement2.g.isPrerendered()) {
                    d2.a("prerendered", (Object) true);
                }
                if (tJCorePlacement2.isContentReady()) {
                    d2.a("content_ready", (Object) true);
                }
                tJCorePlacement2.f.d = d2;
                String uuid = UUID.randomUUID().toString();
                if (tJCorePlacement2.i != null) {
                    tJCorePlacement2.i.f = uuid;
                    if (tJCorePlacement2.i != null) {
                        if (tJCorePlacement2.i instanceof gv) {
                            i = 3;
                        } else {
                            i = tJCorePlacement2.i instanceof he ? 2 : 0;
                        }
                    }
                    TapjoyConnectCore.viewWillOpen(uuid, i);
                    tJCorePlacement2.i.e = new gs(uuid) {
                        /* class com.tapjoy.TJCorePlacement.AnonymousClass4 */
                        final /* synthetic */ String a;

                        {
                            this.a = r2;
                        }

                        @Override // com.tapjoy.internal.gs
                        public final void a(Context context, String str, String str2) {
                            if (str2 == null) {
                                TJCorePlacement.this.c.setRedirectURL(str);
                            } else {
                                TJCorePlacement.this.c.setBaseURL(str);
                                TJCorePlacement.this.c.setHttpResponse(str2);
                            }
                            TJCorePlacement.this.c.setHasProgressSpinner(true);
                            TJCorePlacement.this.c.setContentViewId(this.a);
                            Intent intent = new Intent(TJCorePlacement.this.b, TJAdUnitActivity.class);
                            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, TJCorePlacement.this.c);
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                        }
                    };
                    gz.a(new Runnable() {
                        /* class com.tapjoy.TJCorePlacement.AnonymousClass5 */

                        public final void run() {
                            TJCorePlacement.this.i.a(gz.a().p, TJCorePlacement.this.f);
                        }
                    });
                } else {
                    tJCorePlacement2.c.setContentViewId(uuid);
                    Intent intent = new Intent(tJCorePlacement2.b, TJAdUnitActivity.class);
                    intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, tJCorePlacement2.c);
                    intent.setFlags(268435456);
                    tJCorePlacement2.b.startActivity(intent);
                }
                tJCorePlacement2.e = 0;
                tJCorePlacement2.k = false;
                tJCorePlacement2.l = false;
            }
        } finally {
            gf.d("TJPlacement.showContent");
        }
    }

    public void setAuctionData(HashMap hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            TapjoyLog.d("TJPlacement", "auctionData can not be null or empty");
            return;
        }
        TJCorePlacement tJCorePlacement = this.b;
        tJCorePlacement.q = hashMap;
        String b2 = tJCorePlacement.b();
        if (!jq.c(b2)) {
            tJCorePlacement.c.setAuctionMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b2 + "/bid_content?");
            return;
        }
        TapjoyLog.i(TJCorePlacement.a, "Placement auction data can not be set for a null app ID");
    }

    public void setMediationName(String str) {
        TapjoyLog.d("TJPlacement", "setMediationName=" + str);
        if (!jq.c(str)) {
            TJCorePlacement tJCorePlacement = this.b;
            Context context = tJCorePlacement != null ? tJCorePlacement.getContext() : null;
            TJCorePlacement a2 = TJPlacementManager.a(getName(), str, "", false, isLimited());
            this.b = a2;
            a2.o = str;
            a2.m = str;
            a2.c.setPlacementType(str);
            String b2 = a2.b();
            if (!jq.c(b2)) {
                a2.c.setMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + b2 + "/mediation_content?");
            } else {
                TapjoyLog.i(TJCorePlacement.a, "Placement mediation name can not be set for a null app ID");
            }
            if (context != null) {
                this.b.setContext(context);
            }
        }
    }

    public void setAdapterVersion(String str) {
        this.b.n = str;
    }

    public static void dismissContent() {
        TJPlacementManager.dismissContentShowing("true".equals(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL")));
    }

    public String getGUID() {
        return this.e;
    }

    private void a(TJError tJError) {
        this.b.a(this, TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, tJError);
    }
}
