package com.tapjoy.internal;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.ironsource.sdk.constants.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class bt implements Closeable {
    final Writer a;
    private final List b;
    private String c;
    private String d = ":";
    private boolean e;

    public bt(Writer writer) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(bq.EMPTY_DOCUMENT);
        if (writer != null) {
            this.a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final bt a() {
        return a(bq.EMPTY_ARRAY, Constants.RequestParameters.LEFT_BRACKETS);
    }

    public final bt b() {
        return a(bq.EMPTY_ARRAY, bq.NONEMPTY_ARRAY, Constants.RequestParameters.RIGHT_BRACKETS);
    }

    public final bt c() {
        return a(bq.EMPTY_OBJECT, "{");
    }

    public final bt d() {
        return a(bq.EMPTY_OBJECT, bq.NONEMPTY_OBJECT, "}");
    }

    private bt a(bq bqVar, String str) {
        a(true);
        this.b.add(bqVar);
        this.a.write(str);
        return this;
    }

    private bt a(bq bqVar, bq bqVar2, String str) {
        bq e2 = e();
        if (e2 == bqVar2 || e2 == bqVar) {
            List list = this.b;
            list.remove(list.size() - 1);
            if (e2 == bqVar2) {
                g();
            }
            this.a.write(str);
            return this;
        }
        throw new IllegalStateException("Nesting problem: " + this.b);
    }

    private bq e() {
        List list = this.b;
        return (bq) list.get(list.size() - 1);
    }

    private void a(bq bqVar) {
        List list = this.b;
        list.set(list.size() - 1, bqVar);
    }

    public final bt b(String str) {
        if (str == null) {
            return f();
        }
        a(false);
        c(str);
        return this;
    }

    private bt f() {
        a(false);
        this.a.write("null");
        return this;
    }

    public final bt a(long j) {
        a(false);
        this.a.write(Long.toString(j));
        return this;
    }

    public final bt a(Number number) {
        if (number == null) {
            return f();
        }
        String obj = number.toString();
        if (this.e || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            a(false);
            this.a.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
        if (e() != bq.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    private void c(String str) {
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                this.a.write("\\f");
            } else if (charAt != '\r') {
                if (charAt == '\"' || charAt == '\\') {
                    this.a.write(92);
                } else if (charAt != 8232 && charAt != 8233) {
                    switch (charAt) {
                        case '\b':
                            this.a.write("\\b");
                            break;
                        case '\t':
                            this.a.write("\\t");
                            break;
                        case '\n':
                            this.a.write("\\n");
                            break;
                        default:
                            if (charAt <= 31) {
                                this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                } else {
                    this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
                this.a.write(charAt);
            } else {
                this.a.write("\\r");
            }
        }
        this.a.write("\"");
    }

    private void g() {
        if (this.c != null) {
            this.a.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            for (int i = 1; i < this.b.size(); i++) {
                this.a.write(this.c);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.bt$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tapjoy.internal.bq[] r0 = com.tapjoy.internal.bq.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.bt.AnonymousClass1.a = r0
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.EMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.tapjoy.internal.bt.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.tapjoy.internal.bt.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.NONEMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.tapjoy.internal.bt.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.DANGLING_NAME     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = com.tapjoy.internal.bt.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tapjoy.internal.bq r1 = com.tapjoy.internal.bq.NONEMPTY_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bt.AnonymousClass1.<clinit>():void");
        }
    }

    private void a(boolean z) {
        int i = AnonymousClass1.a[e().ordinal()];
        if (i != 1) {
            if (i == 2) {
                a(bq.NONEMPTY_ARRAY);
                g();
            } else if (i == 3) {
                this.a.append(',');
                g();
            } else if (i == 4) {
                this.a.append((CharSequence) this.d);
                a(bq.NONEMPTY_OBJECT);
            } else if (i != 5) {
                throw new IllegalStateException("Nesting problem: " + this.b);
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (this.e || z) {
            a(bq.NONEMPTY_DOCUMENT);
        } else {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
    }

    public final bt a(Object obj) {
        if (obj == null) {
            return f();
        }
        if (obj instanceof br) {
            if (this.b.size() == this.b.size()) {
                return this;
            }
            throw new IllegalStateException(obj.getClass().getName() + ".writeToJson(JsonWriter) wrote incomplete value");
        } else if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            a(false);
            this.a.write(booleanValue ? "true" : "false");
            return this;
        } else if (obj instanceof Number) {
            if (obj instanceof Long) {
                return a(((Number) obj).longValue());
            }
            if (!(obj instanceof Double)) {
                return a((Number) obj);
            }
            double doubleValue = ((Number) obj).doubleValue();
            if (this.e || (!Double.isNaN(doubleValue) && !Double.isInfinite(doubleValue))) {
                a(false);
                this.a.append((CharSequence) Double.toString(doubleValue));
                return this;
            }
            throw new IllegalArgumentException("Numeric values must be finite, but was " + doubleValue);
        } else if (obj instanceof String) {
            return b((String) obj);
        } else {
            if (obj instanceof bl) {
                return a((bl) obj);
            }
            if (obj instanceof Collection) {
                return a((Collection) obj);
            }
            if (obj instanceof Map) {
                return a((Map) obj);
            }
            if (obj instanceof Date) {
                Date date = (Date) obj;
                if (date == null) {
                    return f();
                }
                return b(w.a(date));
            } else if (obj instanceof Object[]) {
                return a((Object[]) obj);
            } else {
                throw new IllegalArgumentException("Unknown type: " + obj.getClass().getName());
            }
        }
    }

    private bt a(Object[] objArr) {
        if (objArr == null) {
            return f();
        }
        a();
        for (Object obj : objArr) {
            a(obj);
        }
        b();
        return this;
    }

    public final bt a(bl blVar) {
        a(false);
        blVar.a(this.a);
        return this;
    }

    public final bt a(Collection collection) {
        if (collection == null) {
            return f();
        }
        a();
        for (Object obj : collection) {
            a(obj);
        }
        b();
        return this;
    }

    public final bt a(String str) {
        if (str != null) {
            bq e2 = e();
            if (e2 == bq.NONEMPTY_OBJECT) {
                this.a.write(44);
            } else if (e2 != bq.EMPTY_OBJECT) {
                throw new IllegalStateException("Nesting problem: " + this.b);
            }
            g();
            a(bq.DANGLING_NAME);
            c(str);
            return this;
        }
        throw new NullPointerException("name == null");
    }

    public final bt a(Map map) {
        if (map == null) {
            return f();
        }
        c();
        for (Map.Entry entry : map.entrySet()) {
            a(String.valueOf(entry.getKey()));
            a(entry.getValue());
        }
        d();
        return this;
    }
}
