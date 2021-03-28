package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EM {
    public static String[] A0B;
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final List<EL> A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    static {
        A04();
    }

    public static void A04() {
        A0B = new String[]{"s27kRN", "abG5pKADna", "w2jztrB", "I7geUVX8H5XW4NGFgS7QGYJa3", "W37aGUNVZO5G", "W3qhVhIXcY", "2nbP2bKsNJFzfOABHc993I7Qj", "6HcftuEFFeXx4hy"};
    }

    public EM(long j, boolean z, boolean z2, boolean z3, List<EL> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
        this.A04 = j;
        this.A0A = z;
        this.A08 = z2;
        this.A09 = z3;
        this.A06 = Collections.unmodifiableList(list);
        this.A05 = j2;
        this.A07 = z4;
        this.A03 = j3;
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
    }

    public EM(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        this.A04 = parcel.readLong();
        boolean z4 = false;
        if (parcel.readByte() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.A0A = z;
        if (parcel.readByte() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.A08 = z2;
        if (parcel.readByte() == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.A09 = z3;
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(EL.A01(parcel));
        }
        this.A06 = Collections.unmodifiableList(arrayList);
        this.A05 = parcel.readLong();
        this.A07 = parcel.readByte() == 1 ? true : z4;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public static EM A00(Parcel parcel) {
        return new EM(parcel);
    }

    /* JADX INFO: Multiple debug info for r22v0 com.facebook.ads.redexgen.X.IQ: [D('outOfNetworkIndicator' boolean), D('firstByte' long), D('uniqueProgramId' int), D('componentTag' int)] */
    /* JADX INFO: Multiple debug info for r2v5 long: [D('breakDuration90khz' long), D('i' int)] */
    /* JADX INFO: Multiple debug info for r0v15 long: [D('programSpliceFlag' boolean), D('componentCount' int)] */
    public static EM A02(IQ iq) {
        boolean autoReturn;
        boolean z;
        long A0N = iq.A0N();
        if ((iq.A0F() & 128) != 0) {
            autoReturn = true;
        } else {
            autoReturn = false;
        }
        boolean z2 = false;
        boolean z3 = false;
        long j = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int headerByte = 0;
        int i2 = 0;
        boolean z4 = false;
        long j2 = -9223372036854775807L;
        if (!autoReturn) {
            int A0F = iq.A0F();
            if (A0B[2].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[6] = "oYMFgXMCdR9ldlOsYeO";
            strArr[6] = "oYMFgXMCdR9ldlOsYeO";
            if ((A0F & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((A0F & 64) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((A0F & 32) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z3) {
                j = iq.A0N();
            }
            if (!z3) {
                int A0F2 = iq.A0F();
                arrayList = new ArrayList(A0F2);
                for (int i3 = 0; i3 < A0F2; i3++) {
                    arrayList.add(new EL(iq.A0F(), iq.A0N(), null));
                }
            }
            if (z) {
                long A0F3 = (long) iq.A0F();
                if ((128 & A0F3) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                j2 = (1000 * (((1 & A0F3) << 32) | iq.A0N())) / 90;
            }
            i = iq.A0J();
            headerByte = iq.A0F();
            i2 = iq.A0F();
        }
        return new EM(A0N, autoReturn, z2, z3, arrayList, j, z4, j2, i, headerByte, i2);
    }

    /* access modifiers changed from: private */
    public void A05(Parcel parcel) {
        parcel.writeLong(this.A04);
        parcel.writeByte(this.A0A ? (byte) 1 : 0);
        parcel.writeByte(this.A08 ? (byte) 1 : 0);
        parcel.writeByte(this.A09 ? (byte) 1 : 0);
        int size = this.A06.size();
        parcel.writeInt(size);
        for (int i = 0; i < size; i++) {
            EL.A03(this.A06.get(i), parcel);
        }
        parcel.writeLong(this.A05);
        parcel.writeByte(this.A07 ? (byte) 1 : 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
