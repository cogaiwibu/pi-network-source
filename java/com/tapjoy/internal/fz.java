package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyLog;
import java.util.Observable;
import java.util.Observer;

/* access modifiers changed from: package-private */
public abstract class fz {
    volatile a b;

    /* access modifiers changed from: protected */
    public abstract TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj);

    /* access modifiers changed from: protected */
    public abstract String a(Object obj);

    fz() {
    }

    public final boolean c(Object obj) {
        if (!a()) {
            return false;
        }
        a aVar = null;
        synchronized (this) {
            if (this.b == null) {
                aVar = b(obj);
                this.b = aVar;
            }
        }
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    /* access modifiers changed from: protected */
    public a b(Object obj) {
        return new a(this, obj);
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    /* access modifiers changed from: protected */
    public boolean a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            fs.e.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            fs.e.deleteObserver(observer);
        }
        if (gz.a().d()) {
            return true;
        }
        fs.c.addObserver(observer);
        if (!gz.a().d()) {
            return false;
        }
        fs.c.deleteObserver(observer);
        return true;
    }

    /* access modifiers changed from: package-private */
    public class a implements TJPlacementListener, Observer {
        private final Object b;
        private final fi c;
        private volatile boolean d;
        private TJPlacement e;

        @Override // com.tapjoy.TJPlacementListener
        public final void onClick(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onContentDismiss(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onContentShow(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onRequestSuccess(TJPlacement tJPlacement) {
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i) {
        }

        a(fz fzVar, Object obj) {
            this(obj, new fi(TapjoyConstants.TIMER_INCREMENT));
        }

        a(Object obj, fi fiVar) {
            this.b = obj;
            this.c = fiVar;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            synchronized (this) {
                if (!this.d) {
                    if (this.c.a()) {
                        a("Timed out");
                        return;
                    }
                    if (!TapjoyConnectCore.isConnected()) {
                        fs.a.addObserver(this);
                        if (TapjoyConnectCore.isConnected()) {
                            fs.a.deleteObserver(this);
                        } else {
                            return;
                        }
                    }
                    if (this.e == null) {
                        if (!fz.this.a()) {
                            a("Cannot request");
                            return;
                        }
                        TJPlacement a2 = fz.this.a(TapjoyConnectCore.getContext(), this, this.b);
                        this.e = a2;
                        a2.requestContent();
                    } else if (this.e.isContentReady()) {
                        if (fz.this.a((Observer) this)) {
                            this.e.showContent();
                            a(null);
                        }
                    }
                }
            }
        }

        private void a(String str) {
            synchronized (this) {
                String a2 = fz.this.a(this.b);
                if (str == null) {
                    TapjoyLog.i("SystemPlacement", "Placement " + a2 + " is presented now");
                } else {
                    TapjoyLog.i("SystemPlacement", "Cannot show placement " + a2 + " now (" + str + ")");
                }
                this.d = true;
                this.e = null;
                fs.a.deleteObserver(this);
                fs.e.deleteObserver(this);
                fs.c.deleteObserver(this);
            }
            fz fzVar = fz.this;
            synchronized (fzVar) {
                if (fzVar.b == this) {
                    fzVar.b = null;
                }
            }
        }

        public final void update(Observable observable, Object obj) {
            a();
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
            a(tJError.message);
        }

        @Override // com.tapjoy.TJPlacementListener
        public final void onContentReady(TJPlacement tJPlacement) {
            a();
        }
    }
}
