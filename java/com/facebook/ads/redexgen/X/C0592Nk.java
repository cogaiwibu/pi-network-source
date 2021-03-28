package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Nk  reason: case insensitive filesystem */
public final class C0592Nk extends AnonymousClass4X {
    public static String[] A0A;
    @DoNotStrip
    public AbstractC0640Pg A00;
    public C0641Ph A01;
    @Nullable
    public C0641Ph A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final SparseBooleanArray A07;
    public final C0820Wh A08;
    public final AbstractC0670Qk A09;

    static {
        A08();
    }

    public static void A08() {
        A0A = new String[]{"av2tITPhYKbVn20ukUfJR25ELbcgjHbj", "MLeLe181lhP7dC21QqjxU1VDKV9lNkzJ", "XUmY4VBJ2tlJWKlPJ7YkBdCsKtcC", "bK6oHsXedskfaWsjnVeS6YyvP0sRA20b", "BhCeFQN4dHt9z3MLE3p7bnIzhrf86Cw8", "mLW9T0fP2Q5Hob07hRXsv0QUH1fN4", "pNzPXZ5fcby2PvmlRsfUzns43oHDF5Mi", "3YktW7BrcDIc4Xw2f2zdWv5xFETbHIAE"};
    }

    public C0592Nk(AbstractC0670Qk qk, SparseBooleanArray sparseBooleanArray, C0641Ph ph, int i, int i2, int i3, int i4, C0820Wh wh) {
        super(qk);
        this.A08 = wh;
        this.A09 = qk;
        this.A07 = sparseBooleanArray;
        this.A01 = ph;
        this.A03 = i;
        this.A04 = i2;
        this.A05 = i3;
        this.A06 = i4;
    }

    private void A09(JE je, LX lx, String str, OQ oq) {
        if (!this.A07.get(oq.A02())) {
            C0641Ph ph = this.A02;
            if (ph != null) {
                ph.A0X();
                if (A0A[4].charAt(16) != 'E') {
                    throw new RuntimeException();
                }
                String[] strArr = A0A;
                strArr[4] = "iteeE4SnfkkyQnEAEqI0za4snrHpWaXy";
                strArr[4] = "iteeE4SnfkkyQnEAEqI0za4snrHpWaXy";
                this.A02 = null;
            }
            this.A00 = new OL(this, str, oq, je, oq.A04(), lx);
            this.A02 = new C0641Ph(this.A09, 10, new WeakReference(this.A00), this.A08);
            this.A02.A0a(false);
            this.A02.A0Y(100);
            this.A02.A0Z(100);
            this.A09.setOnAssetsLoadedListener(new O0(this, oq));
        }
    }

    public final void A0m(OQ oq, JE je, AnonymousClass7H r8, LX lx, String videoUrl) {
        int i;
        int i2;
        int A022 = oq.A02();
        this.A09.setTag(-1593835536, Integer.valueOf(A022));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.A03, -2);
        if (A022 == 0) {
            i = this.A04;
        } else {
            i = this.A05;
        }
        if (A022 >= this.A06 - 1) {
            i2 = this.A04;
        } else {
            i2 = this.A05;
        }
        marginLayoutParams.setMargins(i, 0, i2, 0);
        String A072 = oq.A03().A0E().A07();
        String A082 = oq.A03().A0E().A08();
        this.A09.setIsVideo(!TextUtils.isEmpty(A082));
        if (this.A09.A0k()) {
            this.A09.setVideoPlaceholderUrl(A072);
            this.A09.setVideoUrl(r8.A0M(A082));
        } else {
            this.A09.setImageUrl(A072);
        }
        this.A09.setLayoutParams(marginLayoutParams);
        this.A09.setAdTitleAndDescription(oq.A03().A0F().A06(), oq.A03().A0F().A01());
        this.A09.setCTAInfo(oq.A03().A0G(), oq.A04());
        this.A09.A0i(oq.A04());
        A09(je, lx, videoUrl, oq);
    }
}
