package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.0F  reason: invalid class name */
public final class AnonymousClass0F {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 71);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{53, 124, 102, 53, 123, 122, 97, 53, 113, 124, 103, 112, 118, 97, 122, 103, 108, 52, 7, 42, 49, 38, 32, 55, 44, 49, 58, 99, 102, 48, 99, 32, 34, 45, 100, 55, 99, 33, 38, 99, 32, 49, 38, 34, 55, 38, 39, 110, 89, 89, 68, 89, 11, 89, 78, 72, 89, 78, 74, 95, 78, 11, 81, 78, 89, 68, 6, 88, 66, 81, 78, 11, 77, 66, 71, 78, 11, 36, 19, 19, 14, 19, 65, 18, 4, 21, 65, 13, 0, 18, 21, 65, 12, 14, 5, 8, 7, 8, 4, 5, 65, 5, 0, 21, 4, 65, 21, 14, 65, 69, 106, 111, 102, 35, 99, 102, 117};
    }

    public static List<File> A01(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new AnonymousClass0E());
        return asList;
    }

    public static void A03(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                A04(file);
                if (file.lastModified() < currentTimeMillis) {
                    throw new IOException(A00(77, 32, 38) + file);
                }
            }
        }
    }

    public static void A04(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            A05(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, A00(114, 3, 86));
        randomAccessFile.seek(length - 1);
        byte lastByte = randomAccessFile.readByte();
        randomAccessFile.seek(length - 1);
        randomAccessFile.write(lastByte);
        randomAccessFile.close();
    }

    public static void A05(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException(A00(47, 30, 108) + file);
        }
    }

    public static synchronized void A06(File file) throws IOException {
        synchronized (AnonymousClass0F.class) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    throw new IOException(A00(109, 5, 68) + file + A00(0, 18, 82));
                }
            } else if (!file.mkdirs()) {
                throw new IOException(String.format(Locale.US, A00(18, 29, 4), file.getAbsolutePath()));
            }
        }
    }
}
