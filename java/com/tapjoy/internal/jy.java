package com.tapjoy.internal;

import java.nio.CharBuffer;

public final class jy {
    private static long a(Readable readable, Appendable appendable) {
        CharBuffer allocate = CharBuffer.allocate(2048);
        long j = 0;
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return j;
            }
            allocate.flip();
            appendable.append(allocate, 0, read);
            j += (long) read;
        }
    }

    public static String a(Readable readable) {
        StringBuilder sb = new StringBuilder();
        a(readable, sb);
        return sb.toString();
    }
}
