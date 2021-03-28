package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzij extends IOException {
    private zzjj zza = null;

    public zzij(String str) {
        super(str);
    }

    static zzij zza() {
        return new zzij("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzij zzb() {
        return new zzij("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzij zzc() {
        return new zzij("CodedInputStream encountered a malformed varint.");
    }

    static zzij zzd() {
        return new zzij("Protocol message contained an invalid tag (zero).");
    }

    static zzij zze() {
        return new zzij("Protocol message end-group tag did not match expected tag.");
    }

    static zzii zzf() {
        return new zzii("Protocol message tag had invalid wire type.");
    }

    static zzij zzg() {
        return new zzij("Failed to parse the message.");
    }

    static zzij zzh() {
        return new zzij("Protocol message had invalid UTF-8.");
    }
}
