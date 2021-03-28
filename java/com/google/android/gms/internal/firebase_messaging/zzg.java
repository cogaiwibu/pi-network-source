package com.google.android.gms.internal.firebase_messaging;

import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
final class zzg extends OutputStream {
    zzg() {
    }

    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        zze.zza(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        zze.zza(bArr);
    }
}
