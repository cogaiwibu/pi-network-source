package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ex  reason: case insensitive filesystem */
public final class C0381Ex extends RM implements AbstractC00430w {
    public static byte[] A0C;
    public static String[] A0D;
    public long A00;
    public AnonymousClass12 A01;
    public AnonymousClass13 A02;
    public AnonymousClass16 A03;
    public C0820Wh A04;
    public JL A05;
    public KL A06;
    public String A07;
    @Nullable
    public String A08;
    public String A09;
    public final String A0A = UUID.randomUUID().toString();
    public final AtomicBoolean A0B = new AtomicBoolean();

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0C = new byte[]{56, 52, 54, 54, 48, 57, 48, 39, 58, 56, 48, 33, 48, 39, 10, 39, 58, 33, 52, 33, 60, 58, 59, 110, 97, 100, 104, 99, 121, 89, 98, 102, 104, 99, 14, 11, 30, 11, 77, 76, 79, 64, 71, 64, 93, 64, 70, 71, 17, 25, 24, 21, 29, 8, 21, 19, 18, 56, 29, 8, 29, 87, 75, 70, 68, 66, 74, 66, 73, 83, 110, 67, 6, 4, 19, 18, 19, 16, 31, 24, 19, 18, 57, 4, 31, 19, 24, 2, 23, 2, 31, 25, 24, 61, 19, 15, 104, ByteCompanionObject.MAX_VALUE, 107, 111, ByteCompanionObject.MAX_VALUE, 105, 110, 78, 115, 119, ByteCompanionObject.MAX_VALUE, 25, 14, 28, 10, 25, 15, 56, 14, 25, 29, 14, 25, 62, 57, 39, 87, 64, 82, 68, 87, 65, 64, 65, 115, 76, 65, 64, 74, 100, 65, 97, 68, 81, 68, 103, 80, 75, 65, 73, 64, 123, 108, 126, 104, 123, 109, 108, 109, 86, ByteCompanionObject.MAX_VALUE, 96, 109, 108, 102, 80, 75, 76, 84, 80, 64, 108, 65, 88, 71, 75, 89, 122, 87, 94, 75};
    }

    public static void A06() {
        A0D = new String[]{"YJVWhBFSVFKs7NrWmWULGh", "0GvTyPfIpVaCupDTXIuhVv", "vKmpQ0k2zgunQxdAFsx7Wlk6dmYtSCUc", "dqRYVPDeGy45RCRFCWIUPRHRtp9NBigI", "NSweCua6lZ8ChPFZ3cKnaOBscLcsrWLc", "HenZyTRrHhMHTWT00jKprDJGPW9d4C4V", "lvvcgtkpn6JHhS0LrJ19j3FN0lJsZZOv", "GmBDkEWrzwPugE8SLtTHysECIxUFQGpg"};
    }

    private void A03() {
        AnonymousClass2F A002 = AnonymousClass2F.A00(this.A04);
        AnonymousClass13 r1 = this.A02;
        A002.A07(r1, r1.A01());
    }

    private void A04() {
        if (this.A02 != null) {
            try {
                AnonymousClass2F.A00(this.A04).A06(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A07(Intent intent) {
        int i = super.A00;
        String A012 = A01(72, 24, 8);
        if (i != -1) {
            ContentResolver contentResolver = this.A04.getContentResolver();
            if (A0D[3].charAt(29) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[7] = "ryaiaZaF8EzuUPZd67FeoIG9jUALGHZG";
            strArr[6] = "XITZtpYy2wf6QHmOozCOnY6Xlkm3ca51";
            if (Settings.System.getInt(contentResolver, A01(1, 22, 43), 0) != 1) {
                int i2 = super.A00;
                if (A0D[2].charAt(2) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[1] = "mo2n49jFbf8CHvb7nubztA";
                strArr2[0] = "3h0LYrxRFByrgEG7Z48zJG";
                intent.putExtra(A012, i2);
                return;
            }
        }
        if (!J8.A0c(this.A04)) {
            intent.putExtra(A012, 6);
        }
    }

    private void A08(boolean z) {
        if (this.A06 == KL.A0B) {
            A0A(z);
            return;
        }
        KL kl = this.A06;
        String[] strArr = A0D;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[4] = "1yOiFacRiwJanRzqDJ6A5hJ77lYfziAe";
        strArr2[5] = "McEelBumOV7dKb1zb6BdvUT5HG6VvrgI";
        if (kl == KL.A0A) {
            A09(z);
        } else {
            A0A(z);
        }
    }

    private void A09(boolean z) {
        RH rh = new RH(this, this);
        AnonymousClass7H r5 = new AnonymousClass7H(this.A04);
        C00501d r4 = new C00501d(this, this.A03, A01(147, 14, 119), r5);
        if (r4.A09()) {
            r5.A0X(new JL(this.A03.A0Q(), this.A04.A06()));
            r4.A08();
            return;
        }
        C00551i.A03(this.A04, this.A03, z, rh);
    }

    private void A0A(boolean z) {
        AnonymousClass7H r6 = new AnonymousClass7H(this.A04);
        r6.A0X(this.A05);
        AnonymousClass16 r3 = this.A03;
        String A012 = A01(147, 14, 119);
        C00501d r4 = new C00501d(this, r3, A012, r6);
        if (r4.A09()) {
            r4.A08();
            return;
        }
        RR rr = (RR) this.A03;
        if (TextUtils.isEmpty(rr.A0M().A0E().A08())) {
            this.A01.AAs(this, AdError.INTERNAL_ERROR);
            return;
        }
        C00561j.A02(r6, rr);
        r6.A0Q(new C0382Ey(this, z, this), new AnonymousClass7A(rr.A0U(), A012));
    }

    @Override // com.facebook.ads.redexgen.X.RM
    public final int A0B() {
        AnonymousClass16 r0 = this.A03;
        if (r0 != null) {
            return r0.A0J();
        }
        String[] strArr = A0D;
        if (strArr[4].charAt(5) != strArr[5].charAt(5)) {
            String[] strArr2 = A0D;
            strArr2[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
            strArr2[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
            return -1;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.RM
    public final boolean A0C() {
        if (!this.A0B.get()) {
            return false;
        }
        String A032 = C0612Oe.A03(super.A01, this.A0A, this.A07);
        this.A03.A0a(super.A01);
        this.A03.A0d(A032);
        AdActivityIntent A042 = C0523Kq.A04(this.A04);
        A042.putExtra(A01(169, 8, 80), this.A06);
        A042.putExtra(A01(122, 25, 91), this.A03);
        A042.putExtra(A01(161, 8, 91), this.A0A);
        if (A032 != null) {
            A042.putExtra(A01(107, 15, 21), A032);
        }
        A042.putExtra(A01(61, 11, 89), this.A09);
        A042.putExtra(A01(96, 11, 100), this.A00);
        String str = this.A08;
        if (str != null) {
            A042.putExtra(A01(48, 13, 2), str);
        }
        A07(A042);
        A042.setFlags(A042.getFlags() | 268435456);
        A042.putExtra(A01(23, 11, 115), this.A03.A0Q());
        C0523Kq.A0A(this.A04, A042);
        return true;
    }

    public final void A0D(C0820Wh wh, AnonymousClass12 r10, Map<String, Object> map, boolean z, @Nullable String str, @Nullable String str2) {
        String str3;
        this.A0B.set(false);
        this.A04 = wh;
        this.A01 = r10;
        this.A09 = (String) map.get(A01(61, 11, 89));
        this.A00 = ((Long) map.get(A01(96, 11, 100))).longValue();
        this.A08 = str2;
        String str4 = this.A09;
        if (str4 == null) {
            str3 = A01(0, 0, 20);
        } else if (A0D[2].charAt(2) != 'm') {
            throw new RuntimeException();
        } else {
            String[] strArr = A0D;
            strArr[7] = "e6RM8yaPLIljQgE3BUpQbpnA92TvZvU8";
            strArr[6] = "ffjbG0C858y3IrNljjKglLsYE4qM5rpD";
            str3 = str4.split(A01(0, 1, 25))[0];
        }
        this.A07 = str3;
        this.A03 = RR.A01((JSONObject) map.get(A01(34, 4, 20)));
        this.A03.A0b(str);
        this.A03.A0Z(((AnonymousClass91) map.get(A01(38, 10, 87))).A06());
        this.A05 = new JL(this.A03.A0Q(), wh.A06());
        if (TextUtils.isEmpty(this.A03.A0R()) || Build.VERSION.SDK_INT < 21) {
            int A0I = this.A03.A0I();
            if (A0I == 0) {
                this.A06 = KL.A0B;
                this.A04.A0A().AD7(EnumC00240d.A08);
            } else if (A0I == 1) {
                this.A06 = KL.A0A;
                this.A04.A0A().AD7(EnumC00240d.A07);
            }
        } else {
            this.A06 = KL.A04;
            this.A04.A0A().AD7(EnumC00240d.A05);
        }
        this.A02 = new AnonymousClass13(this.A0A, this, r10);
        A03();
        A08(z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final String A5j() {
        return this.A03.A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00430w
    public final void A96() {
        this.A0B.set(true);
        this.A01.AAp(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00430w
    public final void A97() {
        this.A01.AAs(this, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00340n
    public final void onDestroy() {
        A04();
    }
}
