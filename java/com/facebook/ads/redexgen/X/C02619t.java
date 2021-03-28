package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.imageutils.TiffUtil;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.9t  reason: invalid class name and case insensitive filesystem */
public final class C02619t extends C0532Lb {
    public static byte[] A0E;
    public static final String A0F = C02619t.class.getSimpleName();
    @Nullable
    public Uri A00;
    @Nullable
    public NativeAd A01;
    public JE A02;
    @Nullable
    public ME A03;
    @Nullable
    public AnonymousClass7w A04;
    @Nullable
    public String A05;
    @Nullable
    public String A06;
    @Nullable
    public String A07;
    public final AnonymousClass14 A08;
    public final C0820Wh A09;
    public final K4 A0A = new C02629u(this);
    public final AbstractC0506Jy A0B = new C02639v(this);
    public final AbstractC0494Jk A0C = new C02649w(this);
    public final String A0D = UUID.randomUUID().toString();

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0E = new byte[]{122, -104, -91, 94, -85, 87, -86, -85, -104, -87, -85, 87, 120, -84, -101, -96, -100, -91, -102, -100, -123, -100, -85, -82, -90, -87, -94, 120, -102, -85, -96, -83, -96, -85, -80, 101, 87, -124, -104, -94, -100, 87, -86, -84, -87, -100, 87, -85, -97, -104, -85, 87, -96, -85, 94, -86, 87, -96, -91, 87, -80, -90, -84, -87, 87, 120, -91, -101, -87, -90, -96, -101, -124, -104, -91, -96, -99, -100, -86, -85, 101, -81, -92, -93, 87, -99, -96, -93, -100, 101, -77, -32, -32, -35, -32, -88, -114, 109, 105, 104, -100, -117, -112, -116, -107, -118, -116, 117, -116, -101, -98, -106, -103, -110, 113, -103, -105, -104, 68, -105, -119, -104, 103, -112, -115, -119, -110, -104, 120, -109, -113, -119, -110, 68, -118, -115, -106, -105, -104, 113, -103, -105, -104, 68, -105, -119, -104, 122, -115, -120, -119, -109, 121, 118, 109, 68, -109, -106, 68, -105, -119, -104, 122, -115, -120, -119, -109, 113, 116, 104, 68, -118, -115, -106, -105, -104, -16, -3, -18, -16, -14, 3, -8, 5, -8, 3, 8, -80, -71, -74, -78, -69, -63, -95, -68, -72, -78, -69, -7, -22, -5, -4, -14, -9, -16, -107, -105, -118, -119, -118, -117, -114, -109, -118, -119, 116, -105, -114, -118, -109, -103, -122, -103, -114, -108, -109, 112, -118, -98, -48, -55, -60, -52, -48, -64, -92, -65, -39, -41, -55, -78, -59, -40, -51, -38, -55, -89, -40, -59, -90, -39, -40, -40, -45, -46, -41, -54, -59, -58, -48, -83, -48, -56, -56, -58, -45, -22, -35, -40, -39, -29, -63, -60, -72, -120, 123, 118, 119, -127, 101, 119, 119, 125, 102, 123, ByteCompanionObject.MAX_VALUE, 119, -40, -53, -58, -57, -47, -73, -76, -82, -3, -16, -21, -20, -10, -26, -5, -16, -12, -20, -26, -9, -10, -13, -13, -16, -11, -18, -26, -16, -11, -5, -20, -7, -3, -24, -13, -87, -100, -104, -86, -121, -84, -93, -104};
    }

    static {
        A03();
    }

    public C02619t(C0820Wh wh) {
        super(wh);
        this.A08 = new AnonymousClass14(this, wh);
        this.A09 = wh;
        A02();
    }

    public C02619t(C0820Wh wh, AttributeSet attributeSet) {
        super(wh, attributeSet);
        this.A08 = new AnonymousClass14(this, wh);
        this.A09 = wh;
        A02();
    }

    public C02619t(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        this.A08 = new AnonymousClass14(this, wh);
        this.A09 = wh;
        A02();
    }

    private void A02() {
        getEventBus().A04(this.A0C, this.A0B, this.A0A);
    }

    private void A04(Intent intent) {
        if (this.A04 == null) {
            A05(A01(114, 25, 19));
        } else if (this.A00 == null && this.A07 == null) {
            A05(A01(139, 37, 19));
        } else {
            intent.putExtra(A01(237, 18, 83), this.A06);
            intent.putExtra(A01(322, 8, 34), KL.A05);
            intent.putExtra(A01(287, 8, 81), this.A00.toString());
            String str = this.A05;
            if (str == null) {
                str = A01(0, 0, 39);
            }
            intent.putExtra(A01(187, 11, 60), str);
            intent.putExtra(A01(266, 8, 99), this.A07);
            intent.putExtra(A01(205, 24, 20), 13);
            intent.putExtra(A01(TiffUtil.TIFF_TAG_ORIENTATION, 13, 1), getCurrentPositionInMillis());
            intent.putExtra(A01(229, 8, 74), this.A0D);
            intent.putExtra(A01(255, 11, 80), this.A04.A0W());
            intent.putExtra(A01(295, 27, 118), getVideoProgressReportIntervalMs());
            intent.addFlags(268435456);
        }
    }

    private void A05(String str) {
        AbstractC02238h A042 = this.A09.A04();
        int i = C02248i.A1n;
        String defaultErrorMessage = AdErrorType.PARSER_FAILURE.getDefaultErrorMessage();
        A042.A82(A01(198, 7, 120), i, new C02258j(defaultErrorMessage, A01(90, 7, 93) + str));
        if (AdInternalSettings.isDebugBuild()) {
            Log.w(A0F, str);
        }
    }

    public final void A0i() {
        NativeAd nativeAd = this.A01;
        if (nativeAd != null) {
            nativeAd.onCtaBroadcast();
        }
    }

    public final void A0j() {
        AdActivityIntent A042 = C0523Kq.A04(this.A09);
        A04(A042);
        try {
            A0b(false, 6);
            setVisibility(8);
            C0523Kq.A0A(this.A09, A042);
        } catch (Exception e) {
            this.A09.A04().A82(A01(176, 11, 126), C02248i.A05, new C02258j(e));
            Log.e(A01(97, 17, 22), A01(0, 90, 38), e);
        }
    }

    @Nullable
    public ME getListener() {
        return this.A03;
    }

    public String getUniqueId() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.X.C0532Lb
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A08.A03();
    }

    @Override // com.facebook.ads.redexgen.X.C0532Lb
    public final void onDetachedFromWindow() {
        this.A08.A04();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(JE je) {
        this.A02 = je;
    }

    public void setClientToken(@Nullable String str) {
        AnonymousClass7w r2;
        AnonymousClass7w r0 = this.A04;
        if (r0 != null) {
            r0.A0h();
        }
        this.A05 = str;
        if (str != null) {
            r2 = new AnonymousClass7w(this.A09, this.A02, this, str);
        } else {
            r2 = null;
        }
        this.A04 = r2;
    }

    public void setEnableBackgroundVideo(boolean z) {
        super.A0C.setBackgroundPlaybackEnabled(z);
    }

    public void setListener(@Nullable ME me) {
        this.A03 = me;
    }

    public void setNativeAd(@Nullable NativeAd nativeAd) {
        this.A01 = nativeAd;
    }

    public void setVideoCTA(@Nullable String str) {
        this.A06 = str;
    }

    @Override // com.facebook.ads.redexgen.X.C0532Lb
    public void setVideoMPD(@Nullable String str) {
        if (str == null || this.A04 != null) {
            this.A07 = str;
            super.setVideoMPD(str);
            return;
        }
        A05(A01(114, 25, 19));
    }

    @Override // com.facebook.ads.redexgen.X.C0532Lb
    public void setVideoURI(@Nullable Uri uri) {
        if (uri == null || this.A04 != null) {
            this.A00 = uri;
            super.setVideoURI(uri);
            return;
        }
        A05(A01(114, 25, 19));
    }
}
