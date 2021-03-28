package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.E5;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static String[] A01;
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new E5();
    public final byte[] A00;

    public static void A00() {
        A01 = new String[]{"7I8ByvYIxSCthXwQgZUxBbO6MrgPm3a2", "Aotrd2iEMgveLl8vQA6aCYWsKDDhtlXe", "Qu4A80he5UvBCJt6sY5OPydeiYt4T3DJ", "h563m8r7YKrZnjInan8U4LFDYfkXwskw", "M16axV3J", "BUyqEEJsV2YgLKNMo1K7EsNVHhkUuDnI", "eEBATBFYUp70gHXme0z6ms43UYUPOoJj", "UvzuR6baVszWBvzDMt3B0F14O1ipohwY"};
    }

    static {
        A00();
    }

    public BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.createByteArray();
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.A00 = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (super.A00.equals(((Id3Frame) binaryFrame).A00)) {
            byte[] bArr = this.A00;
            if (A01[3].charAt(0) != 'X') {
                String[] strArr = A01;
                strArr[2] = "4v8hvUTZL3so7eNuHQHoz0JRLr1Gn80z";
                strArr[6] = "8p7NFpdJ3Ru5gkWuUhdagWmcX99TdvPx";
                if (Arrays.equals(bArr, binaryFrame.A00)) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((17 * 31) + super.A00.hashCode()) * 31) + Arrays.hashCode(this.A00);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.A00);
        parcel.writeByteArray(this.A00);
    }
}
