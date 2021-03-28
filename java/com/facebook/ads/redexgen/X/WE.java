package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import java.util.Arrays;

public final class WE extends AnonymousClass6Z {
    public static byte[] A01;
    public final TelephonyManager A00;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{15, 7, 14, 13, 4};
    }

    public WE(Context context, C01725z r5) {
        super(context, r5);
        this.A00 = (TelephonyManager) context.getSystemService(A04(0, 5, 99));
    }

    public static int A01(CellInfo cellInfo) {
        if (cellInfo == null) {
            throw new NullPointerException();
        } else if (Build.VERSION.SDK_INT < 18) {
            throw new UnsupportedOperationException();
        } else if (cellInfo instanceof CellInfoCdma) {
            return ((CellInfoCdma) cellInfo).getCellSignalStrength().getLevel();
        } else {
            if (cellInfo instanceof CellInfoGsm) {
                return ((CellInfoGsm) cellInfo).getCellSignalStrength().getLevel();
            }
            if (cellInfo instanceof CellInfoLte) {
                return ((CellInfoLte) cellInfo).getCellSignalStrength().getLevel();
            }
            if (cellInfo instanceof CellInfoWcdma) {
                return ((CellInfoWcdma) cellInfo).getCellSignalStrength().getLevel();
            }
            throw new UnsupportedOperationException(cellInfo.getClass().getSimpleName());
        }
    }

    public final AbstractC01816i A0H() {
        return new W4(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final AbstractC01816i A0I() {
        return new W5(this);
    }

    public final AbstractC01816i A0J() {
        return new W9(this);
    }

    public final AbstractC01816i A0K() {
        return new WA(this);
    }

    public final AbstractC01816i A0L() {
        return new W8(this);
    }

    public final AbstractC01816i A0M() {
        return new W7(this);
    }

    public final AbstractC01816i A0N() {
        return new WD(this);
    }

    public final AbstractC01816i A0O() {
        return new W1(this);
    }

    public final AbstractC01816i A0P() {
        return new WB(this);
    }

    public final AbstractC01816i A0Q() {
        return new WC(this);
    }

    public final AbstractC01816i A0R() {
        return new W2(this);
    }

    public final AbstractC01816i A0S() {
        return new W3(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final AbstractC01816i A0T() {
        return new W6(this);
    }
}
