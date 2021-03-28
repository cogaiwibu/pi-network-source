package com.google.firebase.encoders;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(String str, double d) throws IOException, EncodingException;

    ObjectEncoderContext add(String str, int i) throws IOException, EncodingException;

    ObjectEncoderContext add(String str, long j) throws IOException, EncodingException;

    ObjectEncoderContext add(String str, Object obj) throws IOException, EncodingException;

    ObjectEncoderContext add(String str, boolean z) throws IOException, EncodingException;

    ObjectEncoderContext nested(String str) throws IOException;
}
