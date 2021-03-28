package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public final class bo extends bn {
    public static final bn.a a = new bn.a() {
        /* class com.tapjoy.internal.bo.AnonymousClass1 */

        @Override // com.tapjoy.internal.bn.a
        public final bn a(Reader reader) {
            return new bo(reader);
        }

        @Override // com.tapjoy.internal.bn.a
        public final bn a(String str) {
            return new bo(new StringReader(str));
        }
    };
    private final cj b = new cj();
    private final Reader c;
    private boolean d = false;
    private final char[] e = new char[1024];
    private int f = 0;
    private int g = 0;
    private int h = 1;
    private int i = 1;
    private final List j = new ArrayList();
    private bs k;
    private String l;
    private String m;
    private int n;
    private int o;
    private boolean p;

    public bo(Reader reader) {
        a(bq.EMPTY_DOCUMENT);
        this.p = false;
        if (reader != null) {
            this.c = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    @Override // com.tapjoy.internal.bp
    public final void f() {
        a(bs.BEGIN_ARRAY);
    }

    @Override // com.tapjoy.internal.bp
    public final void g() {
        a(bs.END_ARRAY);
    }

    @Override // com.tapjoy.internal.bp
    public final void h() {
        a(bs.BEGIN_OBJECT);
    }

    @Override // com.tapjoy.internal.bp
    public final void i() {
        a(bs.END_OBJECT);
    }

    private void a(bs bsVar) {
        k();
        if (this.k == bsVar) {
            t();
            return;
        }
        throw new IllegalStateException("Expected " + bsVar + " but was " + k());
    }

    @Override // com.tapjoy.internal.bp
    public final boolean j() {
        k();
        return (this.k == bs.END_OBJECT || this.k == bs.END_ARRAY) ? false : true;
    }

    @Override // com.tapjoy.internal.bp
    public final bs k() {
        bs bsVar = this.k;
        if (bsVar != null) {
            return bsVar;
        }
        int[] iArr = AnonymousClass2.a;
        List list = this.j;
        switch (iArr[((bq) list.get(list.size() - 1)).ordinal()]) {
            case 1:
                b(bq.NONEMPTY_DOCUMENT);
                bs v = v();
                if (this.d || this.k == bs.BEGIN_ARRAY || this.k == bs.BEGIN_OBJECT) {
                    return v;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.k);
            case 2:
                return a(true);
            case 3:
                return a(false);
            case 4:
                return b(true);
            case 5:
                int y = y();
                if (y != 58) {
                    if (y == 61) {
                        z();
                        if (this.f < this.g || a(1)) {
                            char[] cArr = this.e;
                            int i2 = this.f;
                            if (cArr[i2] == '>') {
                                this.f = i2 + 1;
                            }
                        }
                    } else {
                        throw d("Expected ':'");
                    }
                }
                b(bq.NONEMPTY_OBJECT);
                return v();
            case 6:
                return b(false);
            case 7:
                try {
                    bs v2 = v();
                    if (this.d) {
                        return v2;
                    }
                    throw d("Expected EOF");
                } catch (EOFException unused) {
                    bs bsVar2 = bs.END_DOCUMENT;
                    this.k = bsVar2;
                    return bsVar2;
                }
            case 8:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.bo$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tapjoy.internal.bq[] r0 = com.tapjoy.internal.bq.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.bo.AnonymousClass2.a = r0
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.EMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.NONEMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.EMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.DANGLING_NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.NONEMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.NONEMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = com.tapjoy.internal.bo.AnonymousClass2.a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.CLOSED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.AnonymousClass2.<clinit>():void");
        }
    }

    private bs t() {
        k();
        bs bsVar = this.k;
        this.k = null;
        this.m = null;
        this.l = null;
        return bsVar;
    }

    @Override // com.tapjoy.internal.bp
    public final String l() {
        k();
        if (this.k == bs.NAME) {
            String str = this.l;
            t();
            return str;
        }
        throw new IllegalStateException("Expected a name but was " + k());
    }

    @Override // com.tapjoy.internal.bp
    public final String m() {
        k();
        if (this.k == bs.STRING || this.k == bs.NUMBER) {
            String str = this.m;
            t();
            return str;
        }
        throw new IllegalStateException("Expected a string but was " + k());
    }

    @Override // com.tapjoy.internal.bp
    public final boolean n() {
        k();
        if (this.k == bs.BOOLEAN) {
            boolean z = this.m == "true";
            t();
            return z;
        }
        throw new IllegalStateException("Expected a boolean but was " + this.k);
    }

    @Override // com.tapjoy.internal.bp
    public final void o() {
        k();
        if (this.k == bs.NULL) {
            t();
            return;
        }
        throw new IllegalStateException("Expected null but was " + this.k);
    }

    @Override // com.tapjoy.internal.bp
    public final double p() {
        k();
        if (this.k == bs.STRING || this.k == bs.NUMBER) {
            double parseDouble = Double.parseDouble(this.m);
            t();
            return parseDouble;
        }
        throw new IllegalStateException("Expected a double but was " + this.k);
    }

    @Override // com.tapjoy.internal.bp
    public final long q() {
        long j2;
        k();
        if (this.k == bs.STRING || this.k == bs.NUMBER) {
            try {
                j2 = Long.parseLong(this.m);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.m);
                long j3 = (long) parseDouble;
                if (((double) j3) == parseDouble) {
                    j2 = j3;
                } else {
                    throw new NumberFormatException(this.m);
                }
            }
            t();
            return j2;
        }
        throw new IllegalStateException("Expected a long but was " + this.k);
    }

    @Override // com.tapjoy.internal.bp
    public final int r() {
        int i2;
        k();
        if (this.k == bs.STRING || this.k == bs.NUMBER) {
            try {
                i2 = Integer.parseInt(this.m);
            } catch (NumberFormatException unused) {
                double parseDouble = Double.parseDouble(this.m);
                int i3 = (int) parseDouble;
                if (((double) i3) == parseDouble) {
                    i2 = i3;
                } else {
                    throw new NumberFormatException(this.m);
                }
            }
            t();
            return i2;
        }
        throw new IllegalStateException("Expected an int but was " + this.k);
    }

    @Override // com.tapjoy.internal.bp, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.m = null;
        this.k = null;
        this.j.clear();
        this.j.add(bq.CLOSED);
        this.c.close();
    }

    @Override // com.tapjoy.internal.bp
    public final void s() {
        k();
        if (this.k == bs.END_ARRAY || this.k == bs.END_OBJECT) {
            throw new IllegalStateException("Expected a value but was " + this.k);
        }
        this.p = true;
        int i2 = 0;
        do {
            try {
                bs t = t();
                if (t != bs.BEGIN_ARRAY) {
                    if (t != bs.BEGIN_OBJECT) {
                        if (t == bs.END_ARRAY || t == bs.END_OBJECT) {
                            i2--;
                            continue;
                        }
                    }
                }
                i2++;
                continue;
            } finally {
                this.p = false;
            }
        } while (i2 != 0);
    }

    private bq u() {
        List list = this.j;
        return (bq) list.remove(list.size() - 1);
    }

    private void a(bq bqVar) {
        this.j.add(bqVar);
    }

    private void b(bq bqVar) {
        List list = this.j;
        list.set(list.size() - 1, bqVar);
    }

    private bs a(boolean z) {
        if (z) {
            b(bq.NONEMPTY_ARRAY);
        } else {
            int y = y();
            if (y != 44) {
                if (y == 59) {
                    z();
                } else if (y == 93) {
                    u();
                    bs bsVar = bs.END_ARRAY;
                    this.k = bsVar;
                    return bsVar;
                } else {
                    throw d("Unterminated array");
                }
            }
        }
        int y2 = y();
        if (!(y2 == 44 || y2 == 59)) {
            if (y2 != 93) {
                this.f--;
                return v();
            } else if (z) {
                u();
                bs bsVar2 = bs.END_ARRAY;
                this.k = bsVar2;
                return bsVar2;
            }
        }
        z();
        this.f--;
        this.m = "null";
        bs bsVar3 = bs.NULL;
        this.k = bsVar3;
        return bsVar3;
    }

    private bs b(boolean z) {
        if (!z) {
            int y = y();
            if (!(y == 44 || y == 59)) {
                if (y == 125) {
                    u();
                    bs bsVar = bs.END_OBJECT;
                    this.k = bsVar;
                    return bsVar;
                }
                throw d("Unterminated object");
            }
        } else if (y() != 125) {
            this.f--;
        } else {
            u();
            bs bsVar2 = bs.END_OBJECT;
            this.k = bsVar2;
            return bsVar2;
        }
        int y2 = y();
        if (y2 != 34) {
            if (y2 != 39) {
                z();
                this.f--;
                String c2 = c(false);
                this.l = c2;
                if (c2.length() == 0) {
                    throw d("Expected name");
                }
                b(bq.DANGLING_NAME);
                bs bsVar3 = bs.NAME;
                this.k = bsVar3;
                return bsVar3;
            }
            z();
        }
        this.l = a((char) y2);
        b(bq.DANGLING_NAME);
        bs bsVar32 = bs.NAME;
        this.k = bsVar32;
        return bsVar32;
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tapjoy.internal.bs v() {
        /*
        // Method dump skipped, instructions count: 485
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.v():com.tapjoy.internal.bs");
    }

    private boolean a(int i2) {
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            i3 = this.f;
            if (i5 >= i3) {
                break;
            }
            if (this.e[i5] == '\n') {
                this.h++;
                this.i = 1;
            } else {
                this.i++;
            }
            i5++;
        }
        int i6 = this.g;
        if (i6 != i3) {
            int i7 = i6 - i3;
            this.g = i7;
            char[] cArr = this.e;
            System.arraycopy(cArr, i3, cArr, 0, i7);
        } else {
            this.g = 0;
        }
        this.f = 0;
        do {
            Reader reader = this.c;
            char[] cArr2 = this.e;
            int i8 = this.g;
            int read = reader.read(cArr2, i8, cArr2.length - i8);
            if (read == -1) {
                return false;
            }
            int i9 = this.g + read;
            this.g = i9;
            if (this.h == 1 && (i4 = this.i) == 1 && i9 > 0 && this.e[0] == 65279) {
                this.f++;
                this.i = i4 - 1;
            }
        } while (this.g < i2);
        return true;
    }

    private int w() {
        int i2 = this.h;
        for (int i3 = 0; i3 < this.f; i3++) {
            if (this.e[i3] == '\n') {
                i2++;
            }
        }
        return i2;
    }

    private int x() {
        int i2 = this.i;
        for (int i3 = 0; i3 < this.f; i3++) {
            i2 = this.e[i3] == '\n' ? 1 : i2 + 1;
        }
        return i2;
    }

    private int y() {
        while (true) {
            boolean z = true;
            if (this.f < this.g || a(1)) {
                char[] cArr = this.e;
                int i2 = this.f;
                int i3 = i2 + 1;
                this.f = i3;
                char c2 = cArr[i2];
                if (!(c2 == '\t' || c2 == '\n' || c2 == '\r' || c2 == ' ')) {
                    if (c2 == '#') {
                        z();
                        A();
                    } else if (c2 != '/') {
                        return c2;
                    } else {
                        if (i3 == this.g && !a(1)) {
                            return c2;
                        }
                        z();
                        char[] cArr2 = this.e;
                        int i4 = this.f;
                        char c3 = cArr2[i4];
                        if (c3 == '*') {
                            this.f = i4 + 1;
                            while (true) {
                                if (this.f + 2 > this.g && !a(2)) {
                                    z = false;
                                    break;
                                }
                                for (int i5 = 0; i5 < 2; i5++) {
                                    if (this.e[this.f + i5] != "*/".charAt(i5)) {
                                        this.f++;
                                    }
                                }
                                break;
                            }
                            if (z) {
                                this.f += 2;
                            } else {
                                throw d("Unterminated comment");
                            }
                        } else if (c3 != '/') {
                            return c2;
                        } else {
                            this.f = i4 + 1;
                            A();
                        }
                    }
                }
            } else {
                throw new EOFException("End of input");
            }
        }
    }

    private void z() {
        if (!this.d) {
            throw d("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void A() {
        char c2;
        do {
            if (this.f < this.g || a(1)) {
                char[] cArr = this.e;
                int i2 = this.f;
                this.f = i2 + 1;
                c2 = cArr[i2];
                if (c2 == '\r') {
                    return;
                }
            } else {
                return;
            }
        } while (c2 != '\n');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ba, code lost:
        if (r0 != null) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bc, code lost:
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c1, code lost:
        r0.append(r6.e, r1, r6.f - r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(char r7) {
        /*
        // Method dump skipped, instructions count: 218
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.a(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        z();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(boolean r8) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.c(boolean):java.lang.String");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" near ");
        StringBuilder sb2 = new StringBuilder();
        int min = Math.min(this.f, 20);
        sb2.append(this.e, this.f - min, min);
        sb2.append(this.e, this.f, Math.min(this.g - this.f, 20));
        sb.append((Object) sb2);
        return sb.toString();
    }

    private IOException d(String str) {
        throw new bu(str + " at line " + w() + " column " + x());
    }
}
