package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Lb  reason: case insensitive filesystem */
public class C0532Lb extends RelativeLayout implements AbstractC0639Pf, AbstractC0620Om, AbstractC0637Pd {
    public static String[] A0D;
    public static final K3 A0E = new K3();
    public static final C0501Jt A0F = new C0501Jt();
    public static final JJ A0G = new JJ();
    public static final IO A0H = new IO();
    public static final IN A0I = new IN();
    public static final IA A0J = new IA();
    public static final C0459Hz A0K = new C0459Hz();
    public static final C0454Hu A0L = new C0454Hu();
    public int A00 = 200;
    public JL A01;
    public C0624Oq A02;
    public boolean A03;
    public boolean A04;
    public boolean A05 = true;
    public final Handler A06 = new Handler();
    public final Handler A07 = new Handler();
    public final View.OnTouchListener A08 = new View$OnTouchListenerC0618Ok(this);
    public final C0820Wh A09;
    public final AnonymousClass9J<AnonymousClass9K, AnonymousClass9I> A0A = new AnonymousClass9J<>();
    public final List<AbstractC0627Ot> A0B = new ArrayList();
    public final AbstractC0636Pc A0C;

    public static void A0H() {
        A0D = new String[]{"bTF0mPynjITMPKd7AWnGFE0wjuUHqGk", "NLuteA0O4hImypGMVaagZ7KROvpQko", "vHIsSgA1dNPe0TxNLDw8T5r", "Tu3OEd7", "fTm", "FLX2LFKD3Z9kyRG7iyj3Ajj18EKg1", "ES7oyLysdjBWPeOJZDQ9P8Sn", "e8"};
    }

    static {
        A0H();
    }

    public C0532Lb(C0820Wh wh) {
        super(wh);
        this.A09 = wh;
        if (A0P(wh)) {
            this.A0C = new GC(wh);
        } else {
            this.A0C = new GB(wh);
        }
        A0F();
    }

    public C0532Lb(C0820Wh wh, AttributeSet attributeSet) {
        super(wh, attributeSet);
        this.A09 = wh;
        if (A0P(wh)) {
            this.A0C = new GC(wh, attributeSet);
        } else {
            this.A0C = new GB(wh, attributeSet);
        }
        A0F();
    }

    public C0532Lb(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        this.A09 = wh;
        if (A0P(wh)) {
            this.A0C = new GC(wh, attributeSet, i);
        } else {
            this.A0C = new GB(wh, attributeSet, i);
        }
        A0F();
    }

    public static /* synthetic */ C0501Jt A0B() {
        C0501Jt jt = A0F;
        if (A0D[1].length() != 30) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[2] = "s0JISK";
        strArr[2] = "s0JISK";
        return jt;
    }

    public static /* synthetic */ JJ A0C() {
        JJ jj = A0G;
        if (A0D[0].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[6] = "XnBln0F0zo0j2g49JSScdoR2";
        strArr[6] = "XnBln0F0zo0j2g49JSScdoR2";
        return jj;
    }

    private void A0F() {
        this.A09.A0A().A2u();
        this.A0C.setRequestedVolume(1.0f);
        this.A0C.setVideoStateChangeListener(this);
        this.A02 = new C0624Oq(this.A09, this.A0C);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
        setOnTouchListener(this.A08);
    }

    /* access modifiers changed from: private */
    public void A0G() {
        this.A06.postDelayed(new MO(this), (long) this.A00);
    }

    private final void A0I() {
        for (AbstractC0627Ot plugin : this.A0B) {
            if (plugin instanceof K6) {
                A0N((K6) plugin);
            }
            plugin.A7s(this);
        }
    }

    /* access modifiers changed from: private */
    public void A0J(JK jk) {
        JL jl = this.A01;
        if (jl != null) {
            jl.A03(jk, null);
        }
    }

    private void A0M(AbstractC0627Ot ot) {
        if (ot instanceof K6) {
            A0O((K6) ot);
        }
        ot.ADa(this);
    }

    private void A0N(K6 k6) {
        if (k6.getParent() != null) {
            return;
        }
        if (k6 instanceof C01997a) {
            this.A02.A01(k6);
        } else {
            addView(k6);
        }
    }

    private void A0O(K6 k6) {
        if (k6 instanceof C01997a) {
            this.A02.A02(k6);
        } else {
            C0535Le.A0M(k6);
        }
    }

    private boolean A0P(C0820Wh wh) {
        if (GC.A0A()) {
            boolean A1d = J8.A1d(wh);
            if (A0D[2].length() != 19) {
                String[] strArr = A0D;
                strArr[0] = "Y2Yi8VJKipCio7lj7Ydrs3ww6YI9yuS";
                strArr[0] = "Y2Yi8VJKipCio7lj7Ydrs3ww6YI9yuS";
                if (A1d) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    public final void A0S() {
        this.A0C.setVideoStateChangeListener(null);
        this.A0C.destroy();
    }

    public final void A0T() {
        if (!A0f()) {
            this.A0C.A7E();
        }
    }

    public final void A0U() {
        Iterator<AbstractC0627Ot> it = this.A0B.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A0D[0].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[0] = "GYUlZXdJo7nruMh2UHaMalRUd7rYm0D";
            strArr[0] = "GYUlZXdJo7nruMh2UHaMalRUd7rYm0D";
            if (hasNext) {
                A0M(it.next());
            } else {
                this.A0B.clear();
                String[] strArr2 = A0D;
                if (strArr2[4].length() != strArr2[3].length()) {
                    String[] strArr3 = A0D;
                    strArr3[4] = "dBG";
                    strArr3[3] = "pEPub8w";
                    return;
                }
                return;
            }
        }
    }

    public final void A0V(int i) {
        this.A06.removeCallbacksAndMessages(null);
        this.A0C.seekTo(i);
    }

    public final void A0W(int i) {
        this.A0C.ADO(i);
    }

    public final void A0X(EnumC0622Oo oo) {
        this.A07.post(new C0533Lc(this));
        this.A0C.ADE(oo.A02());
    }

    public final void A0Y(EnumC0626Os os, int i) {
        if (this.A03 && this.A0C.getState() == EnumC0638Pe.A06) {
            this.A03 = false;
        }
        this.A0C.ADI(os, i);
    }

    public final void A0Z(AbstractC0627Ot ot) {
        this.A0B.add(ot);
    }

    public final void A0a(AbstractC0627Ot ot) {
        this.A0B.remove(ot);
        A0M(ot);
    }

    public final void A0b(boolean z, int i) {
        if (!A0f()) {
            this.A0C.ABX(z, i);
        }
    }

    public final void A0c(boolean z, boolean z2, int i) {
        this.A05 = z2;
        A0b(z, i);
    }

    public final boolean A0d() {
        return this.A0C.A7L();
    }

    public final boolean A0e() {
        return getVolume() == 0.0f;
    }

    public final boolean A0f() {
        return getState() == EnumC0638Pe.A05;
    }

    public final boolean A0g() {
        return A0f() && this.A0C.A7h();
    }

    public final boolean A0h() {
        return getState() == EnumC0638Pe.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public final boolean A7b() {
        return A0P(this.A09);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public final boolean A7d() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0639Pf
    public final void AA7() {
        A0b(true, 4);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0639Pf
    public final void AA8() {
        A0Y(EnumC0626Os.A05, 6);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0639Pf
    public final void AAt(int i, int i2) {
        this.A07.post(new MM(this, i, i2));
        A0G();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0639Pf
    public final void ABN(EnumC0638Pe pe) {
        int currentPositionInMillis = getCurrentPositionInMillis();
        this.A07.post(new MN(this, pe, getDuration(), currentPositionInMillis));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public int getCurrentPositionInMillis() {
        return this.A0C.getCurrentPosition();
    }

    public int getDuration() {
        return this.A0C.getDuration();
    }

    @NonNull
    public AnonymousClass9J<AnonymousClass9K, AnonymousClass9I> getEventBus() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public long getInitialBufferTime() {
        return this.A0C.getInitialBufferTime();
    }

    public EnumC0638Pe getState() {
        return this.A0C.getState();
    }

    public Handler getStateHandler() {
        return this.A07;
    }

    public TextureView getTextureView() {
        return (TextureView) this.A0C;
    }

    public int getVideoHeight() {
        return this.A0C.getVideoHeight();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public EnumC0626Os getVideoStartReason() {
        return this.A0C.getStartReason();
    }

    public View getVideoView() {
        return this.A02;
    }

    public int getVideoWidth() {
        return this.A0C.getVideoWidth();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0620Om
    public float getVolume() {
        return this.A0C.getVolume();
    }

    public void onAttachedToWindow() {
        this.A0A.A03(A0K);
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.A0A.A03(A0L);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        AbstractC0636Pc pc = this.A0C;
        if (pc != null) {
            pc.setControlsAnchorView(view);
        }
    }

    public void setFunnelLoggingHandler(JL jl) {
        this.A01 = jl;
    }

    public void setIsFullScreen(boolean z) {
        this.A04 = z;
        this.A0C.setFullScreen(z);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(@Nullable String str) {
        this.A0C.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i) {
        this.A00 = i;
    }

    public void setVideoURI(@Nullable Uri uri) {
        if (uri == null) {
            A0U();
        } else {
            A0I();
            this.A0C.setup(uri);
        }
        this.A03 = false;
    }

    public void setVideoURI(@Nullable String str) {
        Uri uri;
        this.A09.A0A().A31(str);
        if (str != null) {
            uri = Uri.parse(str);
        } else {
            uri = null;
        }
        setVideoURI(uri);
    }

    public void setVolume(float f) {
        if (f == 1.0f) {
            A0J(JK.A0b);
            this.A09.A0A().A35();
        } else {
            A0J(JK.A0a);
            this.A09.A0A().A34();
        }
        this.A0C.setRequestedVolume(f);
        AnonymousClass9J<AnonymousClass9K, AnonymousClass9I> eventBus = getEventBus();
        if (A0D[2].length() != 19) {
            String[] strArr = A0D;
            strArr[2] = "etD2zaPMct9y2wbR2YehsJmmTem";
            strArr[2] = "etD2zaPMct9y2wbR2YehsJmmTem";
            eventBus.A03(A0J);
            return;
        }
        throw new RuntimeException();
    }
}
