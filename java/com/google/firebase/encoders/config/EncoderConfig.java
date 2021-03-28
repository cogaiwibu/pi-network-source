package com.google.firebase.encoders.config;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public interface EncoderConfig<T extends EncoderConfig<T>> {
    <U> T registerEncoder(Class<U> cls, ObjectEncoder<? super U> objectEncoder);

    <U> T registerEncoder(Class<U> cls, ValueEncoder<? super U> valueEncoder);
}
