package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
abstract class zzf extends zzd {
    private static final WeakReference<byte[]> zzah = new WeakReference<>(null);
    private WeakReference<byte[]> zzag = zzah;

    zzf(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] zzd();

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzd
    public final byte[] getBytes() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.zzag.get();
            if (bArr == null) {
                bArr = zzd();
                this.zzag = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
