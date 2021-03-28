package com.google.android.datatransport.cct.a;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public final class zzz implements ObjectEncoder<zzn> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.firebase.encoders.Encoder
    public void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws EncodingException, IOException {
        zzn zzn = (zzn) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        if (zzn.zzb() != null) {
            objectEncoderContext2.add("mobileSubtype", zzn.zzb().name());
        }
        if (zzn.zzc() != null) {
            objectEncoderContext2.add("networkType", zzn.zzc().name());
        }
    }
}
