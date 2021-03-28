package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface WebpTranscoder {
    boolean isWebpNativelySupported(ImageFormat imageFormat);

    void transcodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    void transcodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;
}
