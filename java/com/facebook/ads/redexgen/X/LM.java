package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.Writer;

public class LM extends Writer {
    public static String[] A03;
    public int A00;
    public char[] A01 = new char[1024];
    public final LL A02;

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"m3VYVt1tyYlWEg8H2HS3pUr0VsrhpbIN", "rEdvzR", "IUQqTrakmjCy7RtoUebGZ8YLkwuKbv7t", "x1ufNW", "e7NtJ1", "AK7iWzpXctzvcUrQA38QQTSmPkrm2HP", "25DCnOqD1cr08G9nl6wTfczykol7NaSA", "0bM1VBntYb2o4FFsMu8yzxmwObMsLmHM"};
    }

    public LM(LL ll) {
        this.A02 = ll;
    }

    private void A00() {
        this.A02.ABm(new String(this.A01, 0, this.A00));
        this.A00 = 0;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public final void close() {
        flush();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        if (this.A00 > 0) {
            A00();
        }
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i2) throws IOException {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            String[] strArr = A03;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "5m1TKypG4e5yu";
            strArr2[5] = "5m1TKypG4e5yu";
            if (i3 < i4) {
                if (cArr[i3] != '\n') {
                    int i5 = this.A00;
                    char[] cArr2 = this.A01;
                    if (i5 != cArr2.length) {
                        cArr2[i5] = cArr[i3];
                        this.A00 = i5 + 1;
                        i3++;
                    }
                }
                A00();
                i3++;
            } else {
                return;
            }
        }
    }
}
