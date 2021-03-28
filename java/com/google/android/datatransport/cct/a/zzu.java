package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzu implements ObjectEncoder<zzi> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
        zzi zzi = (zzi) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add("eventTimeMs", zzi.zza()).add("eventUptimeMs", zzi.zzb()).add("timezoneOffsetSeconds", zzi.zzc());
        if (zzi.zzf() != null) {
            objectEncoderContext2.add("sourceExtension", zzi.zzf());
        }
        if (zzi.zzg() != null) {
            objectEncoderContext2.add("sourceExtensionJsonProto3", zzi.zzg());
        }
        if (zzi.zzd() != Integer.MIN_VALUE) {
            objectEncoderContext2.add("eventCode", zzi.zzd());
        }
        if (zzi.zze() != null) {
            objectEncoderContext2.add("networkConnectionInfo", zzi.zze());
        }
    }
}
