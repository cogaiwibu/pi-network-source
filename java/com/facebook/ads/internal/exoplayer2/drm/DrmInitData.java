package com.facebook.ads.internal.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.Bx;
import com.facebook.ads.redexgen.X.C02669y;
import com.facebook.ads.redexgen.X.C0309By;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.I1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static String[] A04;
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Bx();
    public int A00;
    public final int A01;
    @Nullable
    public final String A02;
    public final SchemeData[] A03;

    public static void A01() {
        A04 = new String[]{"8bdUvaky5WHdDfVtqwXLakhjtGg6hs0c", "CSUdOCO5ftZIoIqJhT3Nbwo3RnwWTbkq", "vzkDrAJxp6TV0asAVFNpHo5ff03W8L4C", "3CPPKLCdNdSlf2uW7xM1UEZDCok6HZIU", "mnhq363EVnPm6bnzgoRKNwVQQZg6aqu6", "KD2Si0NJCJWXzNPR5NKnBolICvozfmpB", "Z", "WysYYCxVTVW1uXFpDxeWkwgjJbtDWfH7"};
    }

    public static final class SchemeData implements Parcelable {
        public static String[] A06;
        public static final Parcelable.Creator<SchemeData> CREATOR = new C0309By();
        public int A00;
        @Nullable
        public final String A01;
        public final String A02;
        public final boolean A03;
        public final byte[] A04;
        public final UUID A05;

        public static void A01() {
            A06 = new String[]{"FfOodbYcKtbLKDRgim9u7cuo", "NIbXOynBiooMG0S9J28EQxAtJZpLZjNW", "C", "V6JUT1Nk4hAUvorEbipITNdn0olHm5RE", "eq3iucunEPOJjPN", "pnR6rnWbcJIrtQWCkJwENO", "PAZI29otaA64eWNvlBcxsuWWkBf029P2", "o6I7wssHkhPR10FgybVRhye00pbKkIDj"};
        }

        static {
            A01();
        }

        public SchemeData(Parcel parcel) {
            boolean z;
            this.A05 = new UUID(parcel.readLong(), parcel.readLong());
            this.A01 = parcel.readString();
            this.A02 = parcel.readString();
            this.A04 = parcel.createByteArray();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.A03 = z;
        }

        public SchemeData(UUID uuid, @Nullable String str, String str2, byte[] bArr, boolean z) {
            this.A05 = (UUID) I1.A01(uuid);
            this.A01 = str;
            this.A02 = (String) I1.A01(str2);
            this.A04 = bArr;
            this.A03 = z;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this(uuid, null, str, bArr, z);
        }

        public final boolean A02() {
            return this.A04 != null;
        }

        public final boolean A03(UUID uuid) {
            return C02669y.A04.equals(this.A05) || uuid.equals(this.A05);
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            if (!C0466Ig.A0h(this.A01, schemeData.A01) || !C0466Ig.A0h(this.A02, schemeData.A02) || !C0466Ig.A0h(this.A05, schemeData.A05) || !Arrays.equals(this.A04, schemeData.A04)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int hashCode;
            if (this.A00 == 0) {
                int hashCode2 = this.A05.hashCode() * 31;
                String str = this.A01;
                if (A06[5].length() != 21) {
                    String[] strArr = A06;
                    strArr[2] = "3";
                    strArr[2] = "3";
                    if (str == null) {
                        hashCode = 0;
                    } else {
                        hashCode = str.hashCode();
                    }
                    this.A00 = ((((hashCode2 + hashCode) * 31) + this.A02.hashCode()) * 31) + Arrays.hashCode(this.A04);
                } else {
                    throw new RuntimeException();
                }
            }
            return this.A00;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.A05.getMostSignificantBits());
            parcel.writeLong(this.A05.getLeastSignificantBits());
            parcel.writeString(this.A01);
            parcel.writeString(this.A02);
            parcel.writeByteArray(this.A04);
            parcel.writeByte(this.A03 ? (byte) 1 : 0);
        }
    }

    static {
        A01();
    }

    public DrmInitData(Parcel parcel) {
        this.A02 = parcel.readString();
        this.A03 = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.A01 = this.A03.length;
    }

    public DrmInitData(@Nullable String str, boolean z, SchemeData... schemeDataArr) {
        this.A02 = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr, this);
        this.A03 = schemeDataArr;
        this.A01 = schemeDataArr.length;
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(null, schemeDataArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final int compare(SchemeData schemeData, SchemeData schemeData2) {
        if (!C02669y.A04.equals(schemeData.A05)) {
            return schemeData.A05.compareTo(schemeData2.A05);
        }
        UUID uuid = C02669y.A04;
        String[] strArr = A04;
        if (strArr[2].charAt(27) != strArr[1].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[2] = "UJNVxnyD05Ff97smdNbQ52dPpWZWnGWu";
        strArr2[1] = "8h5dygAHbIm1cQj3dlT8FNkqjk3WwzL5";
        return uuid.equals(schemeData2.A05) ? 0 : 1;
    }

    public final SchemeData A02(int i) {
        return this.A03[i];
    }

    public final DrmInitData A03(@Nullable String str) {
        if (C0466Ig.A0h(this.A02, str)) {
            return this;
        }
        return new DrmInitData(str, false, this.A03);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        if (!C0466Ig.A0h(this.A02, drmInitData.A02) || !Arrays.equals(this.A03, drmInitData.A03)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        if (this.A00 == 0) {
            String str = this.A02;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            this.A00 = (hashCode * 31) + Arrays.hashCode(this.A03);
        }
        return this.A00;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeTypedArray(this.A03, 0);
    }
}
