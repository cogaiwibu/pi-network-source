package com.google.android.gms.common.images;

import com.anythink.reactnativejs.utils.Const;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class Size {
    private final int zanj;
    private final int zank;

    public Size(int i, int i2) {
        this.zanj = i;
        this.zank = i2;
    }

    public final int getWidth() {
        return this.zanj;
    }

    public final int getHeight() {
        return this.zank;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.zanj == size.zanj && this.zank == size.zank;
        }
    }

    public final String toString() {
        int i = this.zanj;
        int i2 = this.zank;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append(Const.X);
        sb.append(i2);
        return sb.toString();
    }

    private static NumberFormatException zah(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str != null) {
            int indexOf = str.indexOf(42);
            if (indexOf < 0) {
                indexOf = str.indexOf(120);
            }
            if (indexOf >= 0) {
                try {
                    return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
                } catch (NumberFormatException unused) {
                    throw zah(str);
                }
            } else {
                throw zah(str);
            }
        } else {
            throw new IllegalArgumentException("string must not be null");
        }
    }

    public final int hashCode() {
        int i = this.zank;
        int i2 = this.zanj;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
