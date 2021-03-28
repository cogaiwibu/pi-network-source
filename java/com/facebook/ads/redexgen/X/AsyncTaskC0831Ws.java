package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.anythink.reactnativejs.utils.Const;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ws  reason: case insensitive filesystem */
public final class AsyncTaskC0831Ws extends AsyncTask<String, Void, Bitmap[]> implements AnonymousClass8F {
    public static byte[] A0A;
    public static String[] A0B;
    public int A00;
    public int A01;
    public NT A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    @Nullable
    public final WeakReference<NR> A06;
    public final WeakReference<C0820Wh> A07;
    @Nullable
    public final WeakReference<ImageView> A08;
    @Nullable
    public final WeakReference<ViewGroup> A09;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 48);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-89, -91, -82, -91, -78, -87, -93};
    }

    public static void A02() {
        A0B = new String[]{"Y", "r8ye64eLoQHeOJVpmB1uxWw1zCCHhuzX", "pvZIfONmKv3cVbimQPa9", "RLgA2SApOIsDDawooMs2KL5D8ZiCWoW1", "kM6akDIqkvY", "0vJdyNO9qrz2JF8Kt31GcmRDql8haFQB", "b8N1ZLVb0I2QrMIKflin5UtA7D7V4D", "X"};
    }

    public AsyncTaskC0831Ws(ViewGroup viewGroup, int i, int i2, C0820Wh wh) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(wh);
        this.A06 = null;
        this.A08 = null;
        this.A09 = new WeakReference<>(viewGroup);
        this.A04 = i;
        this.A05 = i2;
    }

    public AsyncTaskC0831Ws(ViewGroup viewGroup, C0820Wh wh) {
        this(viewGroup, 12, 16, wh);
    }

    public AsyncTaskC0831Ws(ImageView imageView, C0820Wh wh) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(wh);
        this.A06 = null;
        this.A08 = new WeakReference<>(imageView);
        this.A09 = null;
        this.A04 = 0;
        this.A05 = 1;
    }

    public AsyncTaskC0831Ws(NR nr, C0820Wh wh) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(wh);
        this.A06 = new WeakReference<>(nr);
        this.A08 = null;
        this.A09 = null;
        this.A04 = 12;
        this.A05 = 16;
    }

    /* JADX INFO: Multiple debug info for r8v0 android.graphics.Bitmap[]: [D('blurBorderView' com.facebook.ads.redexgen.X.NR), D('imageView' android.widget.ImageView)] */
    private final void A03(Bitmap[] bitmapArr) {
        NR nr;
        if (!KU.A02(this)) {
            try {
                boolean z = false;
                if (this.A08 != null) {
                    ImageView imageView = this.A08.get();
                    if (bitmapArr[1] != null && !this.A03 && this.A04 != 0 && imageView != null) {
                        imageView.setImageBitmap(bitmapArr[1]);
                        return;
                    } else if (imageView != null) {
                        imageView.setImageBitmap(bitmapArr[0]);
                    }
                }
                if (!(this.A06 == null || (nr = this.A06.get()) == null)) {
                    nr.setImage(bitmapArr[0], bitmapArr[1]);
                }
                if (!(this.A09 == null || this.A09.get() == null || bitmapArr[1] == null)) {
                    C0535Le.A0W(this.A09.get(), new BitmapDrawable(this.A07.get().getResources(), bitmapArr[1]));
                }
                if (this.A02 != null) {
                    NT nt = this.A02;
                    if (bitmapArr[0] != null) {
                        z = true;
                    }
                    nt.A9g(z);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }

    private final Bitmap[] A04(String... strArr) {
        if (KU.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            Bitmap bitmap = null;
            Bitmap bitmap2 = null;
            C0820Wh wh = this.A07.get();
            if (wh == null) {
                return new Bitmap[]{null, null};
            }
            try {
                bitmap = new AnonymousClass7H(wh).A0J(str, this.A00, this.A01);
                if (bitmap != null && !this.A03) {
                    bitmap2 = C0542Ll.A01(wh, bitmap, this.A04, this.A05);
                }
            } catch (Throwable th) {
                wh.A04().A82(A00(0, 7, 16), C02248i.A1D, new C02258j(th));
            }
            return new Bitmap[]{bitmap, bitmap2};
        } catch (Throwable th2) {
            KU.A00(th2, this);
            return null;
        }
    }

    public final AsyncTaskC0831Ws A05() {
        this.A00 = -1;
        this.A01 = -1;
        return this;
    }

    public final AsyncTaskC0831Ws A06(int i, int i2) {
        this.A00 = i;
        this.A01 = i2;
        return this;
    }

    public final AsyncTaskC0831Ws A07(NT nt) {
        this.A02 = nt;
        return this;
    }

    public final void A08(String str) {
        if (TextUtils.isEmpty(str)) {
            NT nt = this.A02;
            if (nt != null) {
                nt.A9g(false);
                return;
            }
            return;
        }
        executeOnExecutor(ExecutorC0540Lj.A06, str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8F
    @Nullable
    public final C0820Wh A5G() {
        return this.A07.get();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Bitmap[] doInBackground(String[] strArr) {
        if (KU.A02(this)) {
            return null;
        }
        try {
            return A04(strArr);
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) {
        if (!KU.A02(this)) {
            try {
                A03(bitmapArr);
            } catch (Throwable th) {
                KU.A00(th, this);
                String[] strArr = A0B;
                if (strArr[0].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0B;
                strArr2[0] = "X";
                strArr2[7] = Const.Y;
            }
        }
    }
}
