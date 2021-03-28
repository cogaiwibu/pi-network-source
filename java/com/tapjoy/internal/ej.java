package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

public abstract class ej {
    public static final ej c = new ej(eg.VARINT, Boolean.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass1 */

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ int a(Object obj) {
            return 1;
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.c(((Boolean) obj).booleanValue() ? 1 : 0);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            int d = ekVar.d();
            if (d == 0) {
                return Boolean.FALSE;
            }
            if (d == 1) {
                return Boolean.TRUE;
            }
            throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(d)));
        }
    };
    public static final ej d = new ej(eg.VARINT, Integer.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass7 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0) {
                return el.a(intValue);
            }
            return 10;
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            int intValue = ((Integer) obj).intValue();
            if (intValue >= 0) {
                elVar.c(intValue);
            } else {
                elVar.c((long) intValue);
            }
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return Integer.valueOf(ekVar.d());
        }
    };
    public static final ej e = new ej(eg.VARINT, Integer.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass8 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            return el.a(((Integer) obj).intValue());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.c(((Integer) obj).intValue());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return Integer.valueOf(ekVar.d());
        }
    };
    public static final ej f = new ej(eg.VARINT, Integer.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass9 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            return el.a(el.b(((Integer) obj).intValue()));
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.c(el.b(((Integer) obj).intValue()));
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            int d = ekVar.d();
            return Integer.valueOf((-(d & 1)) ^ (d >>> 1));
        }
    };
    public static final ej g;
    public static final ej h;
    public static final ej i = new ej(eg.VARINT, Long.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass11 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            return el.a(((Long) obj).longValue());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.c(((Long) obj).longValue());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return Long.valueOf(ekVar.e());
        }
    };
    public static final ej j = new ej(eg.VARINT, Long.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass12 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            return el.a(((Long) obj).longValue());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.c(((Long) obj).longValue());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return Long.valueOf(ekVar.e());
        }
    };
    public static final ej k = new ej(eg.VARINT, Long.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass13 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            return el.a(el.b(((Long) obj).longValue()));
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.c(el.b(((Long) obj).longValue()));
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            long e = ekVar.e();
            return Long.valueOf((-(e & 1)) ^ (e >>> 1));
        }
    };
    public static final ej l;
    public static final ej m;
    public static final ej n = new ej(eg.FIXED32, Float.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass2 */

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ int a(Object obj) {
            return 4;
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.d(Float.floatToIntBits(((Float) obj).floatValue()));
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return Float.valueOf(Float.intBitsToFloat(ekVar.f()));
        }
    };
    public static final ej o = new ej(eg.FIXED64, Double.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass3 */

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ int a(Object obj) {
            return 8;
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.d(Double.doubleToLongBits(((Double) obj).doubleValue()));
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return Double.valueOf(Double.longBitsToDouble(ekVar.g()));
        }
    };
    public static final ej p = new ej(eg.LENGTH_DELIMITED, String.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass4 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            int i;
            String str = (String) obj;
            int length = str.length();
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt >= 128) {
                    if (charAt < 2048) {
                        i3 += 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i3 += 3;
                    } else if (charAt <= 56319 && (i = i2 + 1) < length && str.charAt(i) >= 56320 && str.charAt(i) <= 57343) {
                        i3 += 4;
                        i2 = i;
                    }
                    i2++;
                }
                i3++;
                i2++;
            }
            return i3;
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ void a(el elVar, Object obj) {
            elVar.a.b((String) obj);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return ekVar.a.c(ekVar.h());
        }
    };
    public static final ej q = new ej(eg.LENGTH_DELIMITED, iu.class) {
        /* class com.tapjoy.internal.ej.AnonymousClass5 */

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            return ((iu) obj).c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            elVar.a((iu) obj);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return ekVar.a.b(ekVar.h());
        }
    };
    final Class a;
    ej b;
    private final eg r;

    public abstract int a(Object obj);

    public abstract Object a(ek ekVar);

    public abstract void a(el elVar, Object obj);

    public ej(eg egVar, Class cls) {
        this.r = egVar;
        this.a = cls;
    }

    public int a(int i2, Object obj) {
        int a2 = a(obj);
        if (this.r == eg.LENGTH_DELIMITED) {
            a2 += el.a(a2);
        }
        return a2 + el.a(el.a(i2, eg.VARINT));
    }

    public void a(el elVar, int i2, Object obj) {
        elVar.c(el.a(i2, this.r));
        if (this.r == eg.LENGTH_DELIMITED) {
            elVar.c(a(obj));
        }
        a(elVar, obj);
    }

    private void a(is isVar, Object obj) {
        ei.a(obj, "value == null");
        ei.a(isVar, "sink == null");
        a(new el(isVar), obj);
    }

    public final byte[] b(Object obj) {
        ei.a(obj, "value == null");
        ir irVar = new ir();
        try {
            a(irVar, obj);
            return irVar.g();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void a(OutputStream outputStream, Object obj) {
        ei.a(obj, "value == null");
        ei.a(outputStream, "stream == null");
        is a2 = iv.a(iv.a(outputStream));
        a(a2, obj);
        a2.a();
    }

    public final Object a(byte[] bArr) {
        ei.a(bArr, "bytes == null");
        ir irVar = new ir();
        if (bArr != null) {
            return a((it) irVar.a(bArr, 0, bArr.length));
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Object a(InputStream inputStream) {
        ei.a(inputStream, "stream == null");
        return a(iv.a(iv.a(inputStream)));
    }

    private Object a(it itVar) {
        ei.a(itVar, "source == null");
        return a(new ek(itVar));
    }

    public static String c(Object obj) {
        return obj.toString();
    }

    static {
        AnonymousClass10 r0 = new ej(eg.FIXED32, Integer.class) {
            /* class com.tapjoy.internal.ej.AnonymousClass10 */

            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 4;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.d(((Integer) obj).intValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Integer.valueOf(ekVar.f());
            }
        };
        g = r0;
        h = r0;
        AnonymousClass14 r02 = new ej(eg.FIXED64, Long.class) {
            /* class com.tapjoy.internal.ej.AnonymousClass14 */

            @Override // com.tapjoy.internal.ej
            public final /* bridge */ /* synthetic */ int a(Object obj) {
                return 8;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                elVar.d(((Long) obj).longValue());
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Long.valueOf(ekVar.g());
            }
        };
        l = r02;
        m = r02;
    }

    public final ej a() {
        ej ejVar = this.b;
        if (ejVar != null) {
            return ejVar;
        }
        AnonymousClass6 r0 = new ej(this.r, List.class) {
            /* class com.tapjoy.internal.ej.AnonymousClass6 */

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(int i, Object obj) {
                List list = (List) obj;
                int size = list.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i2 += ej.this.a(i, list.get(i3));
                }
                return i2;
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, int i, Object obj) {
                List list = (List) obj;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ej.this.a(elVar, i, list.get(i2));
                }
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ Object a(ek ekVar) {
                return Collections.singletonList(ej.this.a(ekVar));
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ void a(el elVar, Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
            }

            @Override // com.tapjoy.internal.ej
            public final /* synthetic */ int a(Object obj) {
                throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
            }
        };
        this.b = r0;
        return r0;
    }

    public static final class a extends IllegalArgumentException {
        public final int a;

        a(int i, Class cls) {
            super("Unknown enum tag " + i + " for " + cls.getCanonicalName());
            this.a = i;
        }
    }
}
