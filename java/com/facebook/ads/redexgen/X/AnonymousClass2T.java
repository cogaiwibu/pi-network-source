package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.2T  reason: invalid class name */
public class AnonymousClass2T implements Parcelable.ClassLoaderCreator<AbsSavedState> {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 92);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{88, 94, 91, 78, 89, 120, 95, 74, 95, 78, 11, 70, 94, 88, 95, 11, 73, 78, 11, 69, 94, 71, 71};
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final AbsSavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return AbsSavedState.A02;
        }
        throw new IllegalStateException(A02(0, 23, 119));
    }

    /* access modifiers changed from: private */
    /* renamed from: A04 */
    public final AbsSavedState[] newArray(int i) {
        return new AbsSavedState[i];
    }
}
