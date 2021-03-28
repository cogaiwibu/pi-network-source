package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0466Ig;
import com.facebook.ads.redexgen.X.E6;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static byte[] A06;
    public static String[] A07;
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new E6();
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final String A04;
    public final Id3Frame[] A05;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A07;
            if (strArr[2].charAt(7) != strArr[0].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "hk5Yo8HG0iFyBsfqJ1cZvcD46s4xS3Im";
            strArr2[7] = "hk5Yo8HG0iFyBsfqJ1cZvcD46s4xS3Im";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 106);
            i4++;
        }
    }

    public static void A01() {
        A06 = new byte[]{-8, -3, -10, 5};
    }

    public static void A02() {
        A07 = new String[]{"GWf8uKqsfvaGUlkt0BhXFWoASdgMsHRN", "1uUtSVmrf1POvzM4cm1EH", "ZO7MghhsAapkkjefU321avSkRWZWBMAu", "GT5gZr6sKzf9s3UvJF0bkk", "G1LpoTCkaTmfFLDCiyRgtkZuciVWUChZ", "TJO8eIHQYE6Bw6RKRlnJr", "gl6", "UcHnHjLRU0SMjCpK61vZZpBDqAm68hmZ"};
    }

    static {
        A02();
        A01();
    }

    public ChapterFrame(Parcel parcel) {
        super(A00(0, 4, 75));
        this.A04 = parcel.readString();
        this.A01 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A03 = parcel.readLong();
        this.A02 = parcel.readLong();
        int readInt = parcel.readInt();
        this.A05 = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.A05[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super(A00(0, 4, 75));
        this.A04 = str;
        this.A01 = i;
        this.A00 = i2;
        this.A03 = j;
        this.A02 = j2;
        this.A05 = id3FrameArr;
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
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
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.A01 == chapterFrame.A01 && this.A00 == chapterFrame.A00 && this.A03 == chapterFrame.A03 && this.A02 == chapterFrame.A02 && C0466Ig.A0h(this.A04, chapterFrame.A04)) {
            Id3Frame[] id3FrameArr = this.A05;
            Id3Frame[] id3FrameArr2 = chapterFrame.A05;
            String[] strArr = A07;
            if (strArr[2].charAt(7) != strArr[0].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[6] = "CDR";
            strArr2[3] = "u0ZPA012b2bRTkfI4ipvZt";
            if (Arrays.equals(id3FrameArr, id3FrameArr2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result;
        int i = ((((((((17 * 31) + this.A01) * 31) + this.A00) * 31) + ((int) this.A03)) * 31) + ((int) this.A02)) * 31;
        String str = this.A04;
        if (str != null) {
            result = str.hashCode();
        } else {
            result = 0;
        }
        return i + result;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A04);
        parcel.writeInt(this.A01);
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A03);
        parcel.writeLong(this.A02);
        parcel.writeInt(this.A05.length);
        for (Id3Frame subFrame : this.A05) {
            parcel.writeParcelable(subFrame, 0);
        }
    }
}
