package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.ads.Ad;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.bZ  reason: case insensitive filesystem */
public final class C1007bZ implements Ad, NativeAdBaseApi, Repairable, AbstractC0491Jh {
    public static AnonymousClass7H A0g;
    public static byte[] A0h;
    public static String[] A0i;
    public static final String A0j = C1007bZ.class.getSimpleName();
    public static final WeakHashMap<View, WeakReference<C1007bZ>> A0k = new WeakHashMap<>();
    public long A00;
    @Nullable
    public Drawable A01;
    public View.OnTouchListener A02;
    @Nullable
    public View A03;
    public View A04;
    @Nullable
    public View A05;
    @Nullable
    public NativeAdLayout A06;
    public EnumC00460z A07;
    @Nullable
    public RL A08;
    public C0376Es A09;
    @Nullable
    public C0696Rk A0A;
    @Nullable
    public AnonymousClass7M A0B;
    @Nullable
    public AnonymousClass91 A0C;
    public JU A0D;
    public View$OnClickListenerC1005bX A0E;
    @Nullable
    public AbstractC1008ba A0F;
    public C0485Jb A0G;
    public EnumC0486Jc A0H;
    public EnumC0500Js A0I;
    public C0557Ma A0J;
    @Nullable
    public NS A0K;
    @Nullable
    public OV A0L;
    @DoNotStrip
    public AbstractC0640Pg A0M;
    public C0641Ph A0N;
    public String A0O;
    @Nullable
    public String A0P;
    public WeakReference<C0724Sp> A0Q;
    public WeakReference<AbstractC0640Pg> A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    @Nullable
    public RG A0W;
    public final AnonymousClass7H A0X;
    public final C0820Wh A0Y;
    public final JY A0Z;
    public final C0493Jj A0a;
    public final LX A0b;
    public final String A0c;
    public final String A0d;
    public final List<View> A0e;
    public volatile boolean A0f;

    public static String A0S(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0h, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 40);
        }
        return new String(copyOfRange);
    }

    public static void A0X() {
        A0h = new byte[]{89, -116, 91, 95, 90, 95, -118, 96, -90, -89, -38, -88, -86, -86, -92, -40, -75, -77, -75, -30, -73, -27, -71, -28, -38, -40, -34, 11, 8, 12, 10, 11, 114, 114, -95, 112, 117, 116, 117, -99, -67, -32, -100, -22, -21, -16, -100, -24, -21, -35, -32, -31, -32, -110, -75, -102, -76, -64, -65, -89, -70, -74, -56, 113, -70, -60, 113, -66, -70, -60, -60, -70, -65, -72, ByteCompanionObject.MAX_VALUE, -88, -53, -69, -52, -44, -41, -45, -56, -37, -52, -121, -114, -116, -38, -114, -121, -48, -38, -121, -43, -42, -37, -121, -56, -121, -43, -56, -37, -48, -35, -52, -121, -56, -53, -96, -100, -101, -49, -66, -61, -65, -56, -67, -65, -88, -65, -50, -47, -55, -52, -59, -82, -55, -47, -44, -51, -52, -120, -36, -41, -120, -44, -41, -55, -52, -120, -75, -51, -52, -47, -55, -106, -50, -23, -15, -12, -19, -20, -88, -4, -9, -88, -9, -22, -4, -23, -15, -10, -88, -4, -19, -11, -8, -12, -23, -4, -19, -88, -47, -52, -88, -18, -6, -9, -11, -88, -22, -15, -20, -88, -8, -23, 1, -12, -9, -23, -20, -88, -81, -83, -5, -81, -77, -40, -34, -49, -36, -40, -53, -42, -118, -49, -36, -36, -39, -36, -104, 116, -75, -38, -30, -51, -40, -43, -48, -116, -33, -47, -32, -116, -37, -46, -116, -49, -40, -43, -49, -41, -51, -50, -40, -47, -116, -30, -43, -47, -29, -33, -117, -93, -94, -89, -97, -108, -89, -93, -75, 94, -89, -79, 94, -85, -89, -79, -79, -89, -84, -91, 108, -50, -10, -12, -11, -95, -15, -13, -16, -9, -22, -27, -26, -95, -30, -95, -41, -22, -26, -8, -115, -96, -77, -88, -75, -92, 95, ByteCompanionObject.MIN_VALUE, -93, 95, -74, -96, -78, 95, -96, -85, -79, -92, -96, -93, -72, 95, -79, -92, -90, -88, -78, -77, -92, -79, -92, -93, 95, -74, -88, -77, -89, 95, -96, 95, -107, -88, -92, -74, 109, 95, ByteCompanionObject.MIN_VALUE, -76, -77, -82, 95, -76, -83, -79, -92, -90, -88, -78, -77, -92, -79, -88, -83, -90, 95, -96, -83, -93, 95, -81, -79, -82, -94, -92, -92, -93, -88, -83, -90, 109, -40, -21, -2, -13, 0, -17, -86, -21, -18, -86, -18, -17, -3, -2, -4, -7, 3, -17, -18, -123, -104, -85, -96, -83, -100, 87, -104, -101, 87, -93, -90, -104, -101, 87, -87, -100, -88, -84, -100, -86, -85, -100, -101, -58, -39, -43, -25, -112, -47, -36, -30, -43, -47, -44, -23, -112, -30, -43, -41, -39, -29, -28, -43, -30, -43, -44, -112, -25, -39, -28, -40, -112, -47, -112, -66, -47, -28, -39, -26, -43, -79, -44, -98, -112, -79, -27, -28, -33, -112, -27, -34, -30, -43, -41, -39, -29, -28, -43, -30, -39, -34, -41, -112, -47, -34, -44, -112, -32, -30, -33, -45, -43, -43, -44, -39, -34, -41, -98, -115, -96, -100, -82, 87, -91, -90, -85, 87, -87, -100, -98, -96, -86, -85, -100, -87, -100, -101, 87, -82, -96, -85, -97, 87, -85, -97, -96, -86, 87, -123, -104, -85, -96, -83, -100, 120, -101, -116, 91, 93, -115, 98, 94, 96, -112, -109, 79, -100, -108, -109, -104, -112, 79, -93, -88, -97, -108, 79, -104, -94, 79, -99, -98, -93, 79, -94, -92, -97, -97, -98, -95, -93, -108, -109, 93, -105, -102, -107, -86, -88, -105, -92, -87, -94, -105, -86, -97, -91, -92, -4, -1, 17, 0, 13, 15, 4, 14, 0, 13, -6, 9, -4, 8, 0, -30, -15, -22, -69, -56, -67, -46, -72, -74, -63, -63, -76, -55, -60, -76, -74, -72, -55, -66, -60, -61, -4, -3, 11, 12, 10, 7, 17, -90, -93, -97, -94, -86, -89, -84, -93, -54, -57, -52, -55, -67, -62, -61, -47, -63, -48, -57, -50, -46, -57, -51, -52, -75, -72, -86, -83, -118, -83, -91, -88, -102, -99, 122, -99, 97, 98, 89, -100, -102, -91, -91, -98, -99, 89, -90, -88, -85, -98, 89, -83, -95, -102, -89, 89, -88, -89, -100, -98, -94, -91, -105, -102, 119, -102, 124, -88, -91, -93, 120, -97, -102, -28, -41, -22, -33, -20, -37, -44, -59, -39, -41, -55, -61, -40, -42, -59, -46, -41, -48, -59, -40, -51, -45, -46, -94, -98, -109, -85, -111, -90, -92, -109, -96, -91, -98, -109, -90, -101, -95, -96, -15, -13, -16, -18, -16, -11, -26, -27, -32, -11, -13, -30, -17, -12, -19, -30, -11, -22, -16, -17, -32, -36, -48, -42, -50, -39, -52, -48, -36, -37, -31, -46, -27, -31, -79, -82, -83, -84, -79, -83, -80, -93, -94, -99, -78, -80, -97, -84, -79, -86, -97, -78, -89, -83, -84};
    }

    public static void A0Y() {
        A0i = new String[]{"Bl7Z7O36thNMsAQG86cT5hXAswukL2TU", "w0l3kgVUfrf8f1EzcfbBJ9JqF1JIQyF1", "3FYeVZ4P9Hva0brxRfDXnSutu97odoaf", "TkemScCQ72wM3yeu7V5OcaIZTlgQuG0T", "aV5nfdXEnoj7uvLi", "brDFWAS69jf159nGVdOYVvf", "WGIwYSb5Wjcv", "W7skGFSknqdZoaqu210O1mF"};
    }

    static {
        A0Y();
        A0X();
    }

    public C1007bZ(Context context, String str, JY jy, boolean z) {
        this.A0d = UUID.randomUUID().toString();
        this.A0I = EnumC0500Js.A06;
        this.A0Q = new WeakReference<>(null);
        this.A0e = new ArrayList();
        this.A0b = new LX();
        this.A0V = false;
        this.A0U = false;
        this.A0D = JU.A04;
        this.A07 = EnumC00460z.A03;
        this.A00 = -1;
        if (!z) {
            this.A0Y = AnonymousClass57.A04(context);
        } else {
            this.A0Y = AnonymousClass57.A02(context);
        }
        this.A0Y.A0C(this);
        this.A0c = str;
        this.A0Z = jy;
        AnonymousClass7H r0 = A0g;
        if (r0 != null) {
            this.A0X = r0;
        } else {
            this.A0X = new AnonymousClass7H(this.A0Y);
        }
        this.A04 = new View(context);
        this.A0a = new C0493Jj(this.A0Y, this);
    }

    public C1007bZ(C0820Wh wh, RG rg, @Nullable AnonymousClass91 r5, JY jy) {
        this((Context) wh, (String) null, jy, true);
        this.A0W = rg;
        this.A0C = r5;
        this.A0f = true;
        this.A04 = new View(wh);
    }

    public C1007bZ(C0820Wh wh, RG rg, @Nullable AnonymousClass91 r3, JY jy, @Nullable C0696Rk rk) {
        this(wh, rg, r3, jy);
        this.A0A = rk;
    }

    public C1007bZ(C1007bZ bZVar) {
        this((Context) bZVar.A0Y, (String) null, bZVar.A0Z, true);
        this.A0C = bZVar.A0C;
        this.A0W = bZVar.A0W;
        this.A0A = bZVar.A0A;
        this.A0f = true;
        this.A04 = new View(this.A0Y);
    }

    private int A00() {
        AnonymousClass91 r0 = this.A0C;
        if (r0 != null) {
            return r0.A04();
        }
        C0376Es es = this.A09;
        if (es == null || es.A0H() == null) {
            return 1;
        }
        return this.A09.A0H().A04();
    }

    private int A01() {
        AnonymousClass91 r0 = this.A0C;
        if (r0 != null) {
            return r0.A07();
        }
        RG rg = this.A0W;
        if (rg != null) {
            int A0G2 = rg.A0G();
            String[] strArr = A0i;
            if (strArr[1].charAt(16) != strArr[3].charAt(16)) {
                String[] strArr2 = A0i;
                strArr2[7] = "EUscbuPuA5cZxxPx7y6ncGc";
                strArr2[5] = "07NrZ6juCFttxvE5hiFlF8c";
                return A0G2;
            }
            throw new RuntimeException();
        }
        C0376Es es = this.A09;
        if (es == null || es.A0H() == null) {
            return 0;
        }
        return this.A09.A0H().A07();
    }

    private int A02() {
        AnonymousClass91 r0 = this.A0C;
        if (r0 != null) {
            return r0.A08();
        }
        RG rg = this.A0W;
        if (rg != null) {
            int A0H2 = rg.A0H();
            String[] strArr = A0i;
            if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
                String[] strArr2 = A0i;
                strArr2[1] = "wlXrbCoONy6aNPfJSLZ4JGG9g8lWOQWJ";
                strArr2[3] = "zMDzXw8vWIk5v34E7N5RdIcOKoPIh5je";
                return A0H2;
            }
            throw new RuntimeException();
        }
        C0376Es es = this.A09;
        String[] strArr3 = A0i;
        if (strArr3[4].length() != strArr3[6].length()) {
            String[] strArr4 = A0i;
            strArr4[7] = "IJhE7OuQr9AUmHg0gZAU0NE";
            strArr4[5] = "Tpbr9nnLmrgR8Cas3OKWnYo";
            if (es == null) {
                return 1000;
            }
        } else {
            String[] strArr5 = A0i;
            strArr5[0] = "x7i9CQzVOJPdqJX1dHOWNRL80PPtBuUS";
            strArr5[2] = "xh5QtfSCbDAINUU48h4MV8p0ljd4aaCa";
            if (es == null) {
                return 1000;
            }
        }
        if (es.A0H() != null) {
            return this.A09.A0H().A08();
        }
        return 1000;
    }

    private int A03() {
        AnonymousClass91 r0 = this.A0C;
        if (r0 != null) {
            return r0.A09();
        }
        C0376Es es = this.A09;
        if (es == null || es.A0H() == null) {
            return 0;
        }
        return this.A09.A0H().A09();
    }

    public static Drawable A05(C0820Wh wh, Bitmap bitmap, boolean z, @Nullable String str) {
        BitmapDrawable A002;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(wh.getResources(), bitmap);
        if (!z || (A002 = OU.A00(wh, str)) == null) {
            return bitmapDrawable;
        }
        return new LayerDrawable(new Drawable[]{bitmapDrawable, A002});
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws C0496Jn {
        EnumC0500Js A002 = C0505Jx.A00(str2);
        if (A002 != null) {
            EnumC0500Js js = EnumC0500Js.A05;
            String[] strArr = A0i;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[0] = "9sjWaS9CbZxjWOFrlYfgckD2h0ahWze6";
            strArr2[2] = "CgLfFBC4KJYZcdRIWMiGUMQeYT9XpqO1";
            if (A002 == js) {
                return new NativeBannerAd(context, str);
            }
            if (A002 == EnumC0500Js.A06) {
                return new NativeAd(context, str);
            }
            throw new C0496Jn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0S(75, 34, 63), A002));
        }
        throw new C0496Jn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0S(147, 50, 96), str2));
    }

    @Nullable
    private final RG A0C() {
        RG rg = this.A0W;
        if (rg == null || !rg.A0g()) {
            return null;
        }
        return rg;
    }

    public static JY A0I() {
        return new bW();
    }

    public static C1007bZ A0J(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (C1007bZ) ((C01344m) Proxy.getInvocationHandler(nativeAdBaseApi)).A05();
        }
        return (C1007bZ) nativeAdBaseApi;
    }

    /* access modifiers changed from: private */
    @Nullable
    /* renamed from: A0L */
    public final C0484Ja getAdStarRating() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0L();
    }

    private AdPlacementType A0O() {
        return this.A0I == EnumC0500Js.A06 ? AdPlacementType.NATIVE : AdPlacementType.NATIVE_BANNER;
    }

    private void A0V() {
        for (View view : this.A0e) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0e.clear();
    }

    private void A0W() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            Kw.A09(new Kw(), this.A0Y, Uri.parse(getAdChoicesLinkUrl()), A15());
        }
    }

    public static void A0Z(@Nullable Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(null);
        } else {
            imageView.setBackgroundDrawable(null);
        }
    }

    private void A0a(View view) {
        this.A0e.add(view);
        view.setOnClickListener(this.A0E);
        view.setOnTouchListener(this.A0E);
        if (Build.VERSION.SDK_INT >= 18) {
            boolean A0q = J8.A0q(view.getContext());
            String[] strArr = A0i;
            if (strArr[1].charAt(16) != strArr[3].charAt(16)) {
                String[] strArr2 = A0i;
                strArr2[4] = "GeTsVetQiODT9yUx";
                strArr2[6] = "UPeG8QvAHkrx";
                if (A0q) {
                    view.setOnLongClickListener(this.A0E);
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0b(View view, View view2, List<View> list, boolean z) {
        boolean z2;
        AbstractC1008ba baVar;
        View view3 = view2;
        if (!A0n()) {
            this.A0Y.A0A().ACC();
        }
        if (view == null) {
            String A0S2 = A0S(264, 19, 89);
            if (!A0n()) {
                this.A0Y.A0A().ACB(A0S2);
            }
            throw new IllegalArgumentException(A0S2);
        } else if (list == null || list.size() == 0) {
            String A0S3 = A0S(213, 30, 68);
            if (!A0n()) {
                this.A0Y.A0A().ACB(A0S3);
            }
            throw new IllegalArgumentException(A0S3);
        } else {
            RG A0C2 = A0C();
            if (A0C2 == null) {
                String A0S4 = A0S(40, 13, 84);
                if (!A0n()) {
                    this.A0Y.A0A().ACB(A0S4);
                }
                Log.e(A0j, A0S4);
                C0495Jm jm = new C0495Jm(AdErrorType.NATIVE_AD_IS_NOT_LOADED, A0S4);
                A0x().A0A().A2d(LW.A01(this.A00), jm.A04().getErrorCode(), jm.A05());
                if (J8.A1X(this.A0Y) && (baVar = this.A0F) != null) {
                    baVar.A9X(jm);
                    return;
                }
                return;
            }
            String str = this.A0P;
            boolean z3 = view instanceof FrameLayout;
            String[] strArr = A0i;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[0] = "EctJGKY0XxsuqG0UQd3u1zsk6i1LiKEB";
            strArr2[2] = "xfmrtxxFdZMJNwdY4ICwqytBKlocc6OO";
            if (z3 && str != null) {
                A0c((FrameLayout) view, str);
            }
            NativeAdLayout nativeAdLayout = this.A06;
            if (nativeAdLayout != null) {
                ((T4) nativeAdLayout.getNativeAdLayoutApi()).A03();
            }
            C0724Sp sp = this.A0Q.get();
            if (sp != null && A0C2.A0B() == 1) {
                sp.A03(EnumC0543Lm.AN_INFO_ICON);
            }
            if (view3 != null) {
                boolean z4 = false;
                if (!(view3 instanceof AdNativeComponentView) || ((AdNativeComponentView) view3).getAdContentsView() == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z && (view3 instanceof ImageView)) {
                    z4 = true;
                }
                if (z2 || z4) {
                    if (this.A03 != null) {
                        Log.w(A0j, A0S(283, 80, 23));
                        unregisterView();
                    }
                    boolean containsKey = A0k.containsKey(view);
                    String[] strArr3 = A0i;
                    if (strArr3[7].length() != strArr3[5].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A0i;
                    strArr4[7] = "Yitqb4l5O5wHhToyiUZG328";
                    strArr4[5] = "n4uNZUYEyoiQJdMJgH58rRy";
                    if (containsKey && A0k.get(view).get() != null) {
                        Log.w(A0j, A0S(406, 75, 72));
                        A0k.get(view).get().unregisterView();
                    }
                    this.A0E = new View$OnClickListenerC1005bX(this, this.A0Y, null);
                    this.A03 = view;
                    this.A05 = view3;
                    if (view instanceof ViewGroup) {
                        this.A0J = new C0557Ma(this.A0Y, new C1003bU(this));
                        ((ViewGroup) view).addView(this.A0J);
                    }
                    ArrayList<View> arrayList = new ArrayList(list);
                    View view4 = this.A04;
                    if (view4 != null) {
                        arrayList.add(view4);
                    }
                    for (View view5 : arrayList) {
                        A0a(view5);
                    }
                    int A002 = A00();
                    this.A0M = new C1004bV(this, view3, z4, A0C2);
                    if (view3 instanceof AdNativeComponentView) {
                        view3 = ((AdNativeComponentView) view3).getAdContentsView();
                    }
                    this.A0N = new C0641Ph(view3, A002, A03(), true, new WeakReference(this.A0M), this.A0Y);
                    this.A0N.A0a(true ^ A0n());
                    this.A0N.A0Y(A01());
                    this.A0N.A0Z(A02());
                    this.A08 = new RL(this.A0Y, new C1006bY(this, null), this.A0N, this.A0W);
                    this.A08.A0E(arrayList);
                    A0k.put(view, new WeakReference<>(this));
                    if (Build.VERSION.SDK_INT >= 18 && J8.A0q(this.A0Y)) {
                        this.A0K = new NS();
                        this.A0K.A0D(this.A0c);
                        this.A0K.A0C(this.A0Y.getPackageName());
                        this.A0K.A0B(this.A0N);
                        if (this.A0W.A0C() > 0) {
                            this.A0K.A09(this.A0W.A0C(), this.A0W.A0D());
                        }
                        AnonymousClass91 r0 = this.A0C;
                        if (r0 != null) {
                            this.A0K.A0A(r0.A0C());
                        } else {
                            C0376Es es = this.A09;
                            if (!(es == null || es.A0H() == null)) {
                                this.A0K.A0A(this.A09.A0H().A0C());
                            }
                        }
                        this.A03.getOverlay().add(this.A0K);
                    }
                } else if (this.A0F != null) {
                    C0495Jm jm2 = new C0495Jm(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0S(IronSourceError.ERROR_CAPPED_PER_SESSION, 31, 7));
                    A0x().A0A().A2d(LW.A01(this.A00), jm2.A04().getErrorCode(), jm2.A05());
                    this.A0F.A9X(jm2);
                }
            } else if (this.A0I == EnumC0500Js.A06) {
                AdErrorType adErrorType = AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD;
                String A0S5 = A0S(243, 21, 22);
                C0495Jm jm3 = new C0495Jm(adErrorType, A0S5);
                A0x().A0A().A2d(LW.A01(this.A00), jm3.A04().getErrorCode(), jm3.A05());
                AbstractC1008ba baVar2 = this.A0F;
                if (baVar2 != null) {
                    baVar2.A9X(jm3);
                }
                if (AdInternalSettings.isDebugBuild()) {
                    Log.e(A0j, A0S5);
                }
            } else {
                AdErrorType adErrorType2 = AdErrorType.NO_ICONVIEW_IN_NATIVEBANNERAD;
                String A0S6 = A0S(53, 22, 41);
                C0495Jm jm4 = new C0495Jm(adErrorType2, A0S6);
                A0x().A0A().A2d(LW.A01(this.A00), jm4.A04().getErrorCode(), jm4.A05());
                AbstractC1008ba baVar3 = this.A0F;
                if (baVar3 != null) {
                    baVar3.A9X(jm4);
                }
                if (AdInternalSettings.isDebugBuild()) {
                    Log.e(A0j, A0S6);
                }
            }
        }
    }

    private void A0c(FrameLayout frameLayout, String str) {
        OV ov = this.A0L;
        if (ov != null) {
            frameLayout.removeView(ov);
        }
        this.A0L = OU.A01(AnonymousClass57.A02(this.A0Y), str);
        OV ov2 = this.A0L;
        if (ov2 != null) {
            frameLayout.addView(ov2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0L);
        }
    }

    /* access modifiers changed from: private */
    public void A0d(@Nullable RG rg, boolean z) {
        if (rg != null) {
            if (this.A0D.equals(JU.A04)) {
                String A5j = rg.A5j();
                if (!TextUtils.isEmpty(A5j)) {
                    this.A0X.A0X(new JL(A5j, this.A0Y.A06()));
                }
                if (rg.A0K() != null) {
                    AnonymousClass7E r4 = new AnonymousClass7E(rg.A0K().getUrl(), rg.A0K().getHeight(), rg.A0K().getWidth(), rg.A0R(), A0S(687, 6, 78));
                    r4.A00 = this.A0B;
                    this.A0X.A0P();
                    this.A0X.A0R(r4);
                }
                if (!this.A0I.equals(EnumC0500Js.A05)) {
                    if (rg.A0J() != null) {
                        this.A0X.A0R(new AnonymousClass7E(rg.A0J().getUrl(), rg.A0J().getHeight(), rg.A0J().getWidth(), rg.A0R(), A0S(687, 6, 78)));
                    }
                    List<C1007bZ> A0V2 = rg.A0V();
                    String[] strArr = A0i;
                    if (strArr[1].charAt(16) != strArr[3].charAt(16)) {
                        String[] strArr2 = A0i;
                        strArr2[1] = "BiVeVWtUTguxpSjeMqAkCwQXeKWOVTz4";
                        strArr2[3] = "8sdR9nWPZ664Gt9BvBocaDJi5It1hBkX";
                        if (A0V2 != null) {
                            for (C1007bZ bZVar : rg.A0V()) {
                                if (bZVar.getAdCoverImage() != null) {
                                    this.A0X.A0R(new AnonymousClass7E(bZVar.getAdCoverImage().getUrl(), bZVar.getAdCoverImage().getHeight(), bZVar.getAdCoverImage().getWidth(), rg.A0R(), A0S(687, 6, 78)));
                                }
                            }
                        }
                        String A0T2 = rg.A0T();
                        if (!TextUtils.isEmpty(A0T2)) {
                            this.A0X.A0W(new AnonymousClass7G(A0T2, rg.A0R(), A0S(687, 6, 78), rg.A0N().longValue()));
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
            this.A0X.A0Q(new C1002bT(this, rg, z), new AnonymousClass7A(rg.A0R(), A0S(687, 6, 78)));
        }
    }

    /* access modifiers changed from: private */
    public void A0e(AnonymousClass11 r2) {
        RG rg = this.A0W;
        if (rg != null) {
            rg.A0X(r2);
        }
    }

    public static void A0f(NativeAdImageApi nativeAdImageApi, ImageView imageView, C0820Wh wh) {
        if (nativeAdImageApi != null && imageView != null) {
            new AsyncTaskC0831Ws(imageView, wh).A06(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A08(nativeAdImageApi.getUrl());
        }
    }

    private final void A0g(JU ju, @Nullable String str) {
        A1N(ju, str, new AnonymousClass7M(false, -1, -1));
    }

    private final void A0j(AbstractC1008ba baVar) {
        this.A0F = baVar;
    }

    private final void A0k(String str) {
        this.A0O = str;
    }

    private void A0l(List<View> list, View view) {
        JY jy = this.A0Z;
        if (jy != null && jy.ADA(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                String[] strArr = A0i;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0i;
                strArr2[1] = "SQxDsveS3BVeMl0nUnJayKxDlwKiSRwM";
                strArr2[3] = "CPUPH8uU8pe6dd8URnD7AGDEQ4lKFlLs";
                A0l(list, childAt);
            }
            return;
        }
        list.add(view);
    }

    /* access modifiers changed from: private */
    public boolean A0m() {
        return A14() == EnumC0488Je.A05 || A14() == EnumC0488Je.A03;
    }

    /* access modifiers changed from: private */
    public boolean A0n() {
        RG rg = this.A0W;
        return rg != null && rg.A0h();
    }

    public final long A0u() {
        return this.A00;
    }

    @Nullable
    public final RG A0v() {
        return this.A0W;
    }

    public final AnonymousClass7H A0w() {
        return this.A0X;
    }

    public final C0820Wh A0x() {
        return this.A0Y;
    }

    @Nullable
    /* renamed from: A0y */
    public final JZ getAdChoicesIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0I();
    }

    @Nullable
    /* renamed from: A0z */
    public final JZ getAdCoverImage() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0J();
    }

    @Nullable
    /* renamed from: A10 */
    public final JZ getAdIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0K();
    }

    @Nullable
    public final AbstractC1008ba A11() {
        return this.A0F;
    }

    public final C0485Jb A12() {
        return this.A0G;
    }

    public final EnumC0486Jc A13() {
        return this.A0H;
    }

    public final EnumC0488Je A14() {
        if (!isAdLoaded()) {
            return EnumC0488Je.A03;
        }
        return this.A0W.A0M();
    }

    @Nullable
    public final String A15() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A5j();
    }

    @Nullable
    public final String A16() {
        return this.A0P;
    }

    @Nullable
    public final String A17() {
        return A1B(A0S(693, 17, 60));
    }

    @Nullable
    public final String A18() {
        return A1B(A0S(710, 16, 10));
    }

    @Nullable
    public final String A19() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0S();
    }

    @Nullable
    public final String A1A() {
        if (!isAdLoaded() || TextUtils.isEmpty(this.A0W.A0T())) {
            return null;
        }
        return this.A0X.A0M(this.A0W.A0T());
    }

    @Nullable
    public final String A1B(String str) {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0U(str);
    }

    @Nullable
    public final List<C1007bZ> A1C() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0V();
    }

    public final void A1D() {
        if (!AnonymousClass23.A0Q(this.A0Y.A00(), false)) {
            A0W();
            return;
        }
        C0820Wh wh = this.A0Y;
        AbstractC0563Mg A012 = C0564Mh.A01(wh, wh.A06(), A15(), this.A06);
        if (A012 == null) {
            A0W();
            return;
        }
        ((T4) this.A06.getNativeAdLayoutApi()).A04(A012);
        A012.A0J();
    }

    public final void A1E(@Nullable Drawable drawable) {
        boolean z;
        this.A01 = drawable;
        if (drawable != null) {
            z = true;
        } else {
            z = false;
        }
        A1U(z, true);
        String[] strArr = A0i;
        if (strArr[4].length() != strArr[6].length()) {
            String[] strArr2 = A0i;
            strArr2[4] = "Q96JEqttX0oIb74l";
            strArr2[6] = "mqYIcYUMJzEb";
            return;
        }
        throw new RuntimeException();
    }

    public final void A1F(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0l(arrayList, view);
        A0b(view, imageView, arrayList, true);
    }

    public final void A1G(View view, ImageView imageView, List<View> list) {
        A0b(view, imageView, list, true);
    }

    public final void A1H(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0l(arrayList, view);
        A0b(view, adNativeComponentView, arrayList, false);
    }

    public final void A1I(View view, AdNativeComponentView adNativeComponentView, List<View> list) {
        A0b(view, adNativeComponentView, list, false);
    }

    public final void A1J(MediaView mediaView) {
        if (mediaView != null) {
            this.A0U = true;
        }
    }

    public final void A1K(MediaView mediaView) {
        if (mediaView != null) {
            this.A0V = true;
        }
    }

    public final void A1L(@Nullable NativeAdLayout nativeAdLayout) {
        this.A06 = nativeAdLayout;
    }

    public final void A1M(@Nullable C0724Sp sp) {
        this.A0Q = new WeakReference<>(sp);
    }

    /* JADX INFO: Multiple debug info for r8v0 'this'  com.facebook.ads.redexgen.X.bZ: [D('adControllerConfig' com.facebook.ads.redexgen.X.1k), D('integrationErrorMode' com.facebook.ads.AdSettings$IntegrationErrorMode)] */
    public final void A1N(JU ju, @Nullable String str, AnonymousClass7M r11) {
        this.A00 = System.currentTimeMillis();
        if (this.A0f) {
            AdSettings.IntegrationErrorMode A002 = C00581l.A00(this.A0Y);
            String A0S2 = A0S(644, 30, 17);
            if (!AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE.equals(A002)) {
                C0495Jm jm = new C0495Jm(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0S(644, 30, 17));
                A0x().A0A().A2d(LW.A01(this.A00), jm.A04().getErrorCode(), jm.A05());
                AbstractC1008ba baVar = this.A0F;
                if (baVar != null) {
                    baVar.A9X(jm);
                } else {
                    Log.e(A0S(109, 17, 50), A0S2);
                }
                C02258j r5 = new C02258j(A0S2);
                A0x().A04().A82(A0S(586, 3, 89), C02248i.A0R, r5);
            } else {
                throw new C00631q(A0S2);
            }
        }
        this.A0f = true;
        this.A0D = ju;
        if (ju.equals(JU.A05)) {
            this.A07 = EnumC00460z.A05;
        }
        this.A0B = r11;
        C00571k r2 = new C00571k(this.A0c, this.A0I, A0O(), null, 1);
        r2.A04(ju);
        r2.A05(this.A0O);
        r2.A06(this.A0P);
        this.A09 = new C0376Es(this.A0Y, r2);
        this.A09.A0R(new C1001bS(this));
        this.A09.A0T(str);
    }

    public final void A1O(C0485Jb jb) {
        this.A0G = jb;
    }

    public final void A1P(EnumC0486Jc jc) {
        this.A0H = jc;
    }

    public final void A1Q(EnumC0500Js js) {
        if (!A0n()) {
            if (EnumC0500Js.A05.equals(js)) {
                C0820Wh wh = this.A0Y;
                String[] strArr = A0i;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0i;
                strArr2[7] = "er71GFUENUkH6mVEmd80tsw";
                strArr2[5] = "eRFgtOOg0hnVr16Te1PNaNs";
                wh.A0A().A2j(AdPlacementType.NATIVE_BANNER.toString());
            } else {
                this.A0Y.A0A().A2j(AdPlacementType.NATIVE.toString());
            }
        }
        this.A0I = js;
    }

    public final void A1R(AbstractC0640Pg pg) {
        this.A0R = new WeakReference<>(pg);
    }

    public final void A1S(boolean z) {
        this.A0S = z;
    }

    public final void A1T(boolean z) {
        this.A0T = z;
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.bZ: [D('error' com.facebook.ads.redexgen.X.Jm), D('adapter' com.facebook.ads.redexgen.X.RG)] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        if (r3 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e4, code lost:
        if (r3 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e7, code lost:
        r2 = A0S(0, 0, 21);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A1U(boolean r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1007bZ.A1U(boolean, boolean):void");
    }

    public final boolean A1V() {
        return this.A06 == null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0491Jh
    public final int A5s() {
        View view = this.A05;
        if (!(view instanceof AdNativeComponentView)) {
            return -1;
        }
        View videoView = ((AdNativeComponentView) view).getAdContentsView();
        if (videoView instanceof C0624Oq) {
            return ((C0624Oq) videoView).getCurrentPosition();
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C0489Jf(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.NativeAdBaseApi
    public final void destroy() {
        K0.A05(A0S(IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, 7, 112), A0S(363, 19, 98), A0S(32, 8, 20));
        if (!A0n()) {
            this.A0Y.A0A().A2k();
        }
        C0376Es es = this.A09;
        if (es != null) {
            es.A0W(true);
            this.A09 = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0D.equals(JU.A05)) {
            this.A07 = EnumC00460z.A04;
        }
        this.A0D = JU.A04;
        A0d(this.A0W, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdBodyText() {
        if (isAdLoaded()) {
            return this.A0W.A0O();
        }
        String[] strArr = A0i;
        if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
            String[] strArr2 = A0i;
            strArr2[0] = "hTgZwGr1QjZPArcNv2XISvdh6HkvBsNu";
            strArr2[2] = "WdfIathAKVLlC1caO5TsuRke00xxoQup";
            return null;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdCallToAction() {
        return A1B(A0S(593, 14, 45));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        JZ A0y = getAdChoicesIcon();
        String[] strArr = A0i;
        if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
            String[] strArr2 = A0i;
            strArr2[7] = "MRTmAh7YnfwjJHGdoro5GGF";
            strArr2[5] = "5NAjexdbITBZf7E7VHPXfXw";
            return A0y.getUrl();
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesLinkUrl() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0P();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesText() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0Q();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdHeadline() {
        return A1B(A0S(IronSourceError.ERROR_BN_RELOAD_SKIP_BACKGROUND, 8, 22));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdLinkDescription() {
        return A1B(A0S(622, 16, 54));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdSocialContext() {
        return A1B(A0S(746, 14, 69));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdTranslation() {
        return A1B(A0S(557, 14, 14));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdUntrimmedBodyText() {
        return A1B(A0S(589, 4, 49));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdvertiserName() {
        return A1B(A0S(571, 15, 115));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        RG rg = this.A0W;
        if (rg == null) {
            return 0.0f;
        }
        JZ A0J2 = rg.A0J();
        int width = A0J2.getWidth();
        String[] strArr = A0i;
        if (strArr[7].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[1] = "Gk0JtmCCXYpL8dPDyrRdSPBqQO7pSw2M";
        strArr2[3] = "hZFl2ZrFl9W40ZKmdwMt57qcTxbjzHrP";
        int height = A0J2.getHeight();
        if (height > 0) {
            return ((float) width) / ((float) height);
        }
        return 0.0f;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        String str = this.A0d;
        String[] strArr = A0i;
        if (strArr[4].length() != strArr[6].length()) {
            String[] strArr2 = A0i;
            strArr2[7] = "iawtn5ImZtHDfKUJHK1ePg9";
            strArr2[5] = "61vZsTsWUXSHOR043CjOsZn";
            return str;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getPlacementId() {
        return this.A0c;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final Drawable getPreloadedIconViewDrawable() {
        JZ adIcon;
        Bitmap A0I2;
        RG rg = this.A0W;
        if (rg == null || (adIcon = rg.A0K()) == null || (A0I2 = this.A0X.A0I(adIcon.getUrl())) == null) {
            return null;
        }
        C0820Wh A0x = A0x();
        boolean A1V = A1V();
        String[] strArr = A0i;
        if (strArr[0].charAt(5) != strArr[2].charAt(5)) {
            String[] strArr2 = A0i;
            strArr2[4] = "5rXv1LFjMRKkpcU7";
            strArr2[6] = "SFgDKFOuseBk";
            return A05(A0x, A0I2, A1V, A16());
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getPromotedTranslation() {
        return A1B(A0S(726, 20, 89));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getSponsoredTranslation() {
        return A1B(A0S(760, 21, 22));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        RG rg = this.A0W;
        return rg != null && rg.A0f();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdInvalidated() {
        boolean z = true;
        C0376Es es = this.A09;
        if (es != null) {
            z = es.A0X();
        } else {
            C0696Rk rk = this.A0A;
            String[] strArr = A0i;
            if (strArr[1].charAt(16) != strArr[3].charAt(16)) {
                String[] strArr2 = A0i;
                strArr2[7] = "v5uFzvuQ32LyebguaenlI2Y";
                strArr2[5] = "nsJGpwd0QPZOfVeZMyNRGWR";
                if (rk != null) {
                    z = rk.A0B();
                }
            } else {
                throw new RuntimeException();
            }
        }
        this.A0Y.A0A().A4X(z);
        return z;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        RG rg = this.A0W;
        return rg != null && rg.A0g();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd() {
        K0.A05(A0S(638, 6, 33), A0S(382, 24, 15), A0S(8, 8, 76));
        loadAd(NativeAdBase.MediaCacheFlag.ALL);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        K0.A05(A0S(638, 6, 33), A0S(382, 24, 15), A0S(519, 7, 3));
        A0g(JU.A00(mediaCacheFlag), null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        K0.A05(A0S(638, 6, 33), A0S(382, 24, 15), A0S(0, 8, 0));
        ((C0489Jf) nativeLoadAdConfig).loadAd();
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAdFromBid(String str) {
        K0.A05(A0S(674, 13, 14), A0S(382, 24, 15), A0S(24, 8, 126));
        loadAdFromBid(str, NativeAdBase.MediaCacheFlag.ALL);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAdFromBid(String str, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        K0.A05(A0S(674, 13, 14), A0S(382, 24, 15), A0S(16, 8, 89));
        A0g(JU.A00(mediaCacheFlag), str);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        this.A04.performClick();
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        View view = this.A03;
        if (view != null) {
            view.post(new C0999bQ(this));
        }
        String str = A0S(197, 16, 66) + LN.A03(this.A0Y, th);
        A0x().A0A().A2d(LW.A01(this.A00), 2001, str);
        AbstractC1008ba baVar = this.A0F;
        if (baVar != null) {
            baVar.A9X(new C0495Jm(2001, str));
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setAdListener(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        if (nativeAdListener != null) {
            A0j(new A0(nativeAdListener, nativeAdBase));
        }
    }

    @Override // com.facebook.ads.Ad, com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints != null) {
            A0k(extraHints.getHints());
            this.A0P = extraHints.getMediationData();
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
        if (r5.containsKey(r4) != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fd, code lost:
        if (r5.containsKey(r4) != false) goto L_0x0074;
     */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void unregisterView() {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1007bZ.unregisterView():void");
    }
}
