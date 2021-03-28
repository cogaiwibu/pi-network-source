package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;

public class ImageFormatChecker {
    private static ImageFormatChecker sInstance;
    @Nullable
    private List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
    private final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
    private int mMaxHeaderLength;

    private ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> list) {
        this.mCustomImageFormatCheckers = list;
        updateMaxHeaderLength();
    }

    public ImageFormat determineImageFormat(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        int i = this.mMaxHeaderLength;
        byte[] bArr = new byte[i];
        int readHeaderFromStream = readHeaderFromStream(i, inputStream, bArr);
        ImageFormat determineFormat = this.mDefaultFormatChecker.determineFormat(bArr, readHeaderFromStream);
        if (!(determineFormat == null || determineFormat == ImageFormat.UNKNOWN)) {
            return determineFormat;
        }
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                ImageFormat determineFormat2 = formatChecker.determineFormat(bArr, readHeaderFromStream);
                if (!(determineFormat2 == null || determineFormat2 == ImageFormat.UNKNOWN)) {
                    return determineFormat2;
                }
            }
        }
        return ImageFormat.UNKNOWN;
    }

    private void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, formatChecker.getHeaderSize());
            }
        }
    }

    private static int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length >= i);
        if (!inputStream.markSupported()) {
            return ByteStreams.read(inputStream, bArr, 0, i);
        }
        try {
            inputStream.mark(i);
            return ByteStreams.read(inputStream, bArr, 0, i);
        } finally {
            inputStream.reset();
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (sInstance == null) {
                sInstance = new ImageFormatChecker();
            }
            imageFormatChecker = sInstance;
        }
        return imageFormatChecker;
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        return getInstance().determineImageFormat(inputStream);
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|9|12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r2 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.imageformat.ImageFormat getImageFormat(java.lang.String r2) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0015 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0015 }
            com.facebook.imageformat.ImageFormat r2 = getImageFormat(r1)     // Catch:{ IOException -> 0x0011, all -> 0x000e }
            com.facebook.common.internal.Closeables.closeQuietly(r1)
            return r2
        L_0x000e:
            r2 = move-exception
            r0 = r1
            goto L_0x001b
        L_0x0011:
            r0 = r1
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            goto L_0x001b
        L_0x0015:
            com.facebook.imageformat.ImageFormat r2 = com.facebook.imageformat.ImageFormat.UNKNOWN     // Catch:{ all -> 0x0013 }
            com.facebook.common.internal.Closeables.closeQuietly(r0)
            return r2
        L_0x001b:
            com.facebook.common.internal.Closeables.closeQuietly(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageformat.ImageFormatChecker.getImageFormat(java.lang.String):com.facebook.imageformat.ImageFormat");
    }
}
