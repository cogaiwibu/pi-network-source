package com.google.zxing.datamatrix.encoder;

/* access modifiers changed from: package-private */
public interface Encoder {
    void encode(EncoderContext encoderContext);

    int getEncodingMode();
}
