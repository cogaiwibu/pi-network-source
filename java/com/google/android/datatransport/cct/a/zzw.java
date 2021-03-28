package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzw implements ObjectEncoder<zzk> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
        zzk zzk = (zzk) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("requestTimeMs", zzk.zzf()).add("requestUptimeMs", zzk.zzg());
        if (zzk.zzb() != null) {
            objectEncoderContext2.add("clientInfo", zzk.zzb());
        }
        if (zzk.zze() != null) {
            objectEncoderContext2.add("logSourceName", zzk.zze());
        } else if (zzk.zzd() != Integer.MIN_VALUE) {
            objectEncoderContext2.add("logSource", zzk.zzd());
        } else {
            throw new EncodingException("Log request must have either LogSourceName or LogSource");
        }
        if (!zzk.zzc().isEmpty()) {
            objectEncoderContext2.add("logEvent", zzk.zzc());
        }
    }
}
