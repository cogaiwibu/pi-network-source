package com.tapjoy.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public final class iv {
    static final Logger a = Logger.getLogger(iv.class.getName());

    private iv() {
    }

    public static it a(jc jcVar) {
        if (jcVar != null) {
            return new ix(jcVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static is a(jb jbVar) {
        if (jbVar != null) {
            return new iw(jbVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static jb a(final OutputStream outputStream) {
        final jd jdVar = new jd();
        if (outputStream != null) {
            return new jb() {
                /* class com.tapjoy.internal.iv.AnonymousClass1 */

                @Override // com.tapjoy.internal.jb
                public final void a(ir irVar, long j) {
                    je.a(irVar.b, 0, j);
                    while (j > 0) {
                        jdVar.a();
                        iy iyVar = irVar.a;
                        int min = (int) Math.min(j, (long) (iyVar.c - iyVar.b));
                        outputStream.write(iyVar.a, iyVar.b, min);
                        iyVar.b += min;
                        long j2 = (long) min;
                        j -= j2;
                        irVar.b -= j2;
                        if (iyVar.b == iyVar.c) {
                            irVar.a = iyVar.a();
                            iz.a(iyVar);
                        }
                    }
                }

                @Override // com.tapjoy.internal.jb, java.io.Flushable
                public final void flush() {
                    outputStream.flush();
                }

                @Override // com.tapjoy.internal.jb, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    outputStream.close();
                }

                public final String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("out == null");
    }

    public static jc a(final InputStream inputStream) {
        final jd jdVar = new jd();
        if (inputStream != null) {
            return new jc() {
                /* class com.tapjoy.internal.iv.AnonymousClass2 */

                @Override // com.tapjoy.internal.jc
                public final long b(ir irVar, long j) {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        try {
                            jdVar.a();
                            iy c = irVar.c(1);
                            int read = inputStream.read(c.a, c.c, (int) Math.min(j, (long) (8192 - c.c)));
                            if (read == -1) {
                                return -1;
                            }
                            c.c += read;
                            long j2 = (long) read;
                            irVar.b += j2;
                            return j2;
                        } catch (AssertionError e) {
                            if (iv.a(e)) {
                                throw new IOException(e);
                            }
                            throw e;
                        }
                    }
                }

                @Override // com.tapjoy.internal.jc, java.io.Closeable, java.lang.AutoCloseable
                public final void close() {
                    inputStream.close();
                }

                public final String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
