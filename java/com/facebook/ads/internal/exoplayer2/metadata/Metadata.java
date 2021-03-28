package com.facebook.ads.internal.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0357Dv;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static String[] A01;
    public static final Parcelable.Creator<Metadata> CREATOR = new C0357Dv();
    public final Entry[] A00;

    public interface Entry extends Parcelable {
    }

    public static void A00() {
        A01 = new String[]{"JICwwT8G5kbXiXHOOMThkmmR", "YwNgc7idcv9rJFlnp1abcUxGz", "KSwlDsi", "Z", "0246QI2TxmfSwaLWPqM7pslFpj9YbyND", "Xr5SiPlZDFoSUesanKDgUhWdC", "ROXHenNovbqvYQv4gdp5KTMra8", "BPS7NXJzE3eQ4STyzWDaFmaROpCtx1Hv"};
    }

    static {
        A00();
    }

    public Metadata(Parcel parcel) {
        this.A00 = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            Entry[] entryArr = this.A00;
            if (i < entryArr.length) {
                entryArr[i] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public Metadata(List<? extends Entry> list) {
        if (list != null) {
            this.A00 = new Entry[list.size()];
            list.toArray(this.A00);
            return;
        }
        this.A00 = new Entry[0];
    }

    public Metadata(Entry... entryArr) {
        this.A00 = entryArr == null ? new Entry[0] : entryArr;
    }

    public final int A01() {
        return this.A00.length;
    }

    public final Entry A02(int i) {
        return this.A00[i];
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Arrays.equals(this.A00, ((Metadata) obj).A00);
        }
        String[] strArr = A01;
        if (strArr[2].length() != strArr[0].length()) {
            String[] strArr2 = A01;
            strArr2[3] = "ZgMQrDUDbDT4";
            strArr2[3] = "ZgMQrDUDbDT4";
            return false;
        }
        throw new RuntimeException();
    }

    public final int hashCode() {
        return Arrays.hashCode(this.A00);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A00.length);
        Entry[] entryArr = this.A00;
        for (Entry entry : entryArr) {
            if (A01[3].length() != 24) {
                String[] strArr = A01;
                strArr[6] = "4bWMxAxjkYjebJNSgeb4pE4Ns8";
                strArr[6] = "4bWMxAxjkYjebJNSgeb4pE4Ns8";
                parcel.writeParcelable(entry, 0);
            } else {
                throw new RuntimeException();
            }
        }
    }
}
