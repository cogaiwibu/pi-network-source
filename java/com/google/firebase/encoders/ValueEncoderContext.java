package com.google.firebase.encoders;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d) throws IOException, EncodingException;

    ValueEncoderContext add(int i) throws IOException, EncodingException;

    ValueEncoderContext add(long j) throws IOException, EncodingException;

    ValueEncoderContext add(String str) throws IOException, EncodingException;

    ValueEncoderContext add(boolean z) throws IOException, EncodingException;

    ValueEncoderContext add(byte[] bArr) throws IOException, EncodingException;
}
