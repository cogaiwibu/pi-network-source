package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.ironsource.mediationsdk.utils.GeneralPropertiesWorker;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzb implements ObjectEncoder<zzd> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
        zzd zzd = (zzd) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        if (zzd.zzi() != Integer.MIN_VALUE) {
            objectEncoderContext2.add(GeneralPropertiesWorker.SDK_VERSION, zzd.zzi());
        }
        if (zzd.zzf() != null) {
            objectEncoderContext2.add("model", zzd.zzf());
        }
        if (zzd.zzd() != null) {
            objectEncoderContext2.add("hardware", zzd.zzd());
        }
        if (zzd.zzb() != null) {
            objectEncoderContext2.add("device", zzd.zzb());
        }
        if (zzd.zzh() != null) {
            objectEncoderContext2.add("product", zzd.zzh());
        }
        if (zzd.zzg() != null) {
            objectEncoderContext2.add("osBuild", zzd.zzg());
        }
        if (zzd.zze() != null) {
            objectEncoderContext2.add("manufacturer", zzd.zze());
        }
        if (zzd.zzc() != null) {
            objectEncoderContext2.add("fingerprint", zzd.zzc());
        }
    }
}
