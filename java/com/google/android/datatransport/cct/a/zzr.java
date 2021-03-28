package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzr implements ObjectEncoder<zzg> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
        zzg zzg = (zzg) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        if (zzg.zzc() != null) {
            objectEncoderContext2.add("clientType", zzg.zzc().name());
        }
        if (zzg.zzb() != null) {
            objectEncoderContext2.add("androidClientInfo", zzg.zzb());
        }
    }
}
