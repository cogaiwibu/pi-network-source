package com.tapjoy.internal;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.ironsource.sdk.constants.Constants;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.UByte;

public class iu implements Serializable, Comparable {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final iu b = new iu((byte[]) new byte[0].clone());
    final byte[] c;
    transient int d;
    transient String e;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        iu iuVar = (iu) obj;
        int c2 = c();
        int c3 = iuVar.c();
        int min = Math.min(c2, c3);
        for (int i = 0; i < min; i++) {
            int a2 = a(i) & UByte.MAX_VALUE;
            int a3 = iuVar.a(i) & UByte.MAX_VALUE;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (c2 == c3) {
            return 0;
        }
        return c2 < c3 ? -1 : 1;
    }

    public iu(byte[] bArr) {
        this.c = bArr;
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, je.a);
        this.e = str2;
        return str2;
    }

    public String b() {
        byte[] bArr = this.c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public iu a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.c;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.c, i, bArr2, 0, i3);
                    return new iu(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte a(int i) {
        return this.c[i];
    }

    public int c() {
        return this.c.length;
    }

    public byte[] d() {
        return (byte[]) this.c.clone();
    }

    /* access modifiers changed from: package-private */
    public void a(ir irVar) {
        byte[] bArr = this.c;
        irVar.a(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && je.a(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof iu) {
            iu iuVar = (iu) obj;
            int c2 = iuVar.c();
            byte[] bArr = this.c;
            return c2 == bArr.length && iuVar.a(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int length = a2.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = a2.length();
                break;
            } else if (i2 == 64) {
                break;
            } else {
                int codePointAt = a2.codePointAt(i);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i2++;
                    i += Character.charCount(codePointAt);
                }
            }
        }
        i = -1;
        if (i != -1) {
            String replace = a2.substring(0, i).replace("\\", "\\\\").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\\n").replace("\r", "\\r");
            if (i < a2.length()) {
                return "[size=" + this.c.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + Constants.RequestParameters.RIGHT_BRACKETS;
        } else if (this.c.length <= 64) {
            return "[hex=" + b() + Constants.RequestParameters.RIGHT_BRACKETS;
        } else {
            return "[size=" + this.c.length + " hex=" + a(0, 64).b() + "…]";
        }
    }
}
