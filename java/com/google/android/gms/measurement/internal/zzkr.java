package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzji;
import com.ironsource.sdk.constants.Constants;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzkr extends zzki {
    zzkr(zzkl zzkl) {
        super(zzkl);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzki
    public final boolean zzd() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcd.zzk.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zzb(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzq().zze().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcd.zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc().zze();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zza.zza(zza((Bundle[]) obj));
        } else {
            zzq().zze().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    static zzcd.zze zza(zzcd.zzc zzc, String str) {
        for (zzcd.zze zze : zzc.zza()) {
            if (zze.zzb().equals(str)) {
                return zze;
            }
        }
        return null;
    }

    static Object zzb(zzcd.zzc zzc, String str) {
        zzcd.zze zza = zza(zzc, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzc()) {
            return zza.zzd();
        }
        if (zza.zze()) {
            return Long.valueOf(zza.zzf());
        }
        if (zza.zzi()) {
            return Double.valueOf(zza.zzj());
        }
        if (zza.zzl() <= 0) {
            return null;
        }
        List<zzcd.zze> zzk = zza.zzk();
        ArrayList arrayList = new ArrayList();
        for (zzcd.zze zze : zzk) {
            if (zze != null) {
                Bundle bundle = new Bundle();
                for (zzcd.zze zze2 : zze.zzk()) {
                    if (zze2.zzc()) {
                        bundle.putString(zze2.zzb(), zze2.zzd());
                    } else if (zze2.zze()) {
                        bundle.putLong(zze2.zzb(), zze2.zzf());
                    } else if (zze2.zzi()) {
                        bundle.putDouble(zze2.zzb(), zze2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* access modifiers changed from: package-private */
    public final zzcd.zzc zza(zzan zzan) {
        zzcd.zzc.zza zzb = zzcd.zzc.zzj().zzb(zzan.zzd);
        Iterator<String> it = zzan.zze.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzcd.zze.zza zza = zzcd.zze.zzm().zza(next);
            zza(zza, zzan.zze.zza(next));
            zzb.zza(zza);
        }
        return (zzcd.zzc) ((zzhy) zzb.zzy());
    }

    static void zza(zzcd.zzc.zza zza, String str, Object obj) {
        List<zzcd.zze> zza2 = zza.zza();
        int i = 0;
        while (true) {
            if (i >= zza2.size()) {
                i = -1;
                break;
            } else if (str.equals(zza2.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzcd.zze.zza zza3 = zzcd.zze.zzm().zza(str);
        if (obj instanceof Long) {
            zza3.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza3.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza3.zza(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            zza3.zza(zza((Bundle[]) obj));
        }
        if (i >= 0) {
            zza.zza(i, zza3);
        } else {
            zza.zza(zza3);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzcd.zzf zzf) {
        if (zzf == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzcd.zzg zzg : zzf.zza()) {
            if (zzg != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (zzg.zza()) {
                    zza(sb, 1, "protocol_version", Integer.valueOf(zzg.zzb()));
                }
                zza(sb, 1, TapjoyConstants.TJC_PLATFORM, zzg.zzq());
                if (zzg.zzz()) {
                    zza(sb, 1, "gmp_version", Long.valueOf(zzg.zzaa()));
                }
                if (zzg.zzab()) {
                    zza(sb, 1, "uploading_gmp_version", Long.valueOf(zzg.zzac()));
                }
                if (zzg.zzbc()) {
                    zza(sb, 1, "dynamite_version", Long.valueOf(zzg.zzbd()));
                }
                if (zzg.zzau()) {
                    zza(sb, 1, "config_version", Long.valueOf(zzg.zzav()));
                }
                zza(sb, 1, "gmp_app_id", zzg.zzam());
                zza(sb, 1, "admob_app_id", zzg.zzbb());
                zza(sb, 1, "app_id", zzg.zzx());
                zza(sb, 1, TapjoyConstants.TJC_APP_VERSION_NAME, zzg.zzy());
                if (zzg.zzar()) {
                    zza(sb, 1, "app_version_major", Integer.valueOf(zzg.zzas()));
                }
                zza(sb, 1, "firebase_instance_id", zzg.zzaq());
                if (zzg.zzah()) {
                    zza(sb, 1, "dev_cert_hash", Long.valueOf(zzg.zzai()));
                }
                zza(sb, 1, "app_store", zzg.zzw());
                if (zzg.zzg()) {
                    zza(sb, 1, "upload_timestamp_millis", Long.valueOf(zzg.zzh()));
                }
                if (zzg.zzi()) {
                    zza(sb, 1, "start_timestamp_millis", Long.valueOf(zzg.zzj()));
                }
                if (zzg.zzk()) {
                    zza(sb, 1, "end_timestamp_millis", Long.valueOf(zzg.zzl()));
                }
                if (zzg.zzm()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzg.zzn()));
                }
                if (zzg.zzo()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzg.zzp()));
                }
                zza(sb, 1, "app_instance_id", zzg.zzag());
                zza(sb, 1, "resettable_device_id", zzg.zzad());
                zza(sb, 1, "device_id", zzg.zzat());
                zza(sb, 1, "ds_id", zzg.zzay());
                if (zzg.zzae()) {
                    zza(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzg.zzaf()));
                }
                zza(sb, 1, TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, zzg.zzr());
                zza(sb, 1, "device_model", zzg.zzs());
                zza(sb, 1, "user_default_language", zzg.zzt());
                if (zzg.zzu()) {
                    zza(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzg.zzv()));
                }
                if (zzg.zzaj()) {
                    zza(sb, 1, "bundle_sequential_index", Integer.valueOf(zzg.zzak()));
                }
                if (zzg.zzan()) {
                    zza(sb, 1, "service_upload", Boolean.valueOf(zzg.zzao()));
                }
                zza(sb, 1, "health_monitor", zzg.zzal());
                if (!zzs().zza(zzas.zzbx) && zzg.zzaw() && zzg.zzax() != 0) {
                    zza(sb, 1, TapjoyConstants.TJC_ANDROID_ID, Long.valueOf(zzg.zzax()));
                }
                if (zzg.zzaz()) {
                    zza(sb, 1, "retry_counter", Integer.valueOf(zzg.zzba()));
                }
                if (zzg.zzbf()) {
                    zza(sb, 1, "consent_signals", zzg.zzbg());
                }
                List<zzcd.zzk> zze = zzg.zze();
                if (zze != null) {
                    for (zzcd.zzk zzk : zze) {
                        if (zzk != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            Double d = null;
                            zza(sb, 2, "set_timestamp_millis", zzk.zza() ? Long.valueOf(zzk.zzb()) : null);
                            zza(sb, 2, "name", zzn().zzc(zzk.zzc()));
                            zza(sb, 2, "string_value", zzk.zze());
                            zza(sb, 2, "int_value", zzk.zzf() ? Long.valueOf(zzk.zzg()) : null);
                            if (zzk.zzh()) {
                                d = Double.valueOf(zzk.zzi());
                            }
                            zza(sb, 2, "double_value", d);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzcd.zza> zzap = zzg.zzap();
                String zzx = zzg.zzx();
                if (zzap != null) {
                    for (zzcd.zza zza : zzap) {
                        if (zza != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zza.zza()) {
                                zza(sb, 2, "audience_id", Integer.valueOf(zza.zzb()));
                            }
                            if (zza.zzf()) {
                                zza(sb, 2, "new_audience", Boolean.valueOf(zza.zzg()));
                            }
                            zza(sb, 2, "current_data", zza.zzc(), zzx);
                            if (zza.zzd()) {
                                zza(sb, 2, "previous_data", zza.zze(), zzx);
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzcd.zzc> zzc = zzg.zzc();
                if (zzc != null) {
                    for (zzcd.zzc zzc2 : zzc) {
                        if (zzc2 != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, "name", zzn().zza(zzc2.zzc()));
                            if (zzc2.zzd()) {
                                zza(sb, 2, "timestamp_millis", Long.valueOf(zzc2.zze()));
                            }
                            if (zzc2.zzf()) {
                                zza(sb, 2, "previous_timestamp_millis", Long.valueOf(zzc2.zzg()));
                            }
                            if (zzc2.zzh()) {
                                zza(sb, 2, NewHtcHomeBadger.COUNT, Integer.valueOf(zzc2.zzi()));
                            }
                            if (zzc2.zzb() != 0) {
                                zza(sb, 2, zzc2.zza());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbv.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzb.zza()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzb.zzb()));
        }
        zza(sb, 0, "event_name", zzn().zza(zzb.zzc()));
        String zza = zza(zzb.zzh(), zzb.zzi(), zzb.zzk());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        if (zzb.zzf()) {
            zza(sb, 1, "event_count_filter", zzb.zzg());
        }
        if (zzb.zze() > 0) {
            sb.append("  filters {\n");
            for (zzbv.zzc zzc : zzb.zzd()) {
                zza(sb, 2, zzc);
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbv.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zze.zza()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zze.zzb()));
        }
        zza(sb, 0, "property_name", zzn().zzc(zze.zzc()));
        String zza = zza(zze.zze(), zze.zzf(), zze.zzh());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        zza(sb, 1, zze.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private final void zza(StringBuilder sb, int i, List<zzcd.zze> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzcd.zze zze : list) {
                if (zze != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    zza(sb, i2, "name", zze.zza() ? zzn().zzb(zze.zzb()) : null);
                    zza(sb, i2, "string_value", zze.zzc() ? zze.zzd() : null);
                    zza(sb, i2, "int_value", zze.zze() ? Long.valueOf(zze.zzf()) : null);
                    if (zze.zzi()) {
                        d = Double.valueOf(zze.zzj());
                    }
                    zza(sb, i2, "double_value", d);
                    if (zze.zzl() > 0) {
                        zza(sb, i2, zze.zzk());
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzcd.zzi zzi, String str2) {
        if (zzi != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzi.zzd() != 0) {
                zza(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : zzi.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append('\n');
            }
            if (zzi.zzb() != 0) {
                zza(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : zzi.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append('\n');
            }
            if (zzi.zzf() != 0) {
                zza(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzcd.zzb zzb : zzi.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzb.zza() ? Integer.valueOf(zzb.zzb()) : null);
                    sb.append(":");
                    sb.append(zzb.zzc() ? Long.valueOf(zzb.zzd()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzi.zzh() != 0) {
                zza(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzcd.zzj zzj : zzi.zzg()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(zzj.zza() ? Integer.valueOf(zzj.zzb()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long l3 : zzj.zzc()) {
                        long longValue = l3.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue);
                        i10 = i11;
                    }
                    sb.append(Constants.RequestParameters.RIGHT_BRACKETS);
                    i8 = i9;
                }
                sb.append("}\n");
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzbv.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zza()) {
                zza(sb, i, "comparison_type", zzd.zzb().name());
            }
            if (zzd.zzc()) {
                zza(sb, i, "match_as_float", Boolean.valueOf(zzd.zzd()));
            }
            if (zzd.zze()) {
                zza(sb, i, "comparison_value", zzd.zzf());
            }
            if (zzd.zzg()) {
                zza(sb, i, "min_comparison_value", zzd.zzh());
            }
            if (zzd.zzi()) {
                zza(sb, i, "max_comparison_value", zzd.zzj());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, zzbv.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            if (zzc.zze()) {
                zza(sb, i, "complement", Boolean.valueOf(zzc.zzf()));
            }
            if (zzc.zzg()) {
                zza(sb, i, "param_name", zzn().zzb(zzc.zzh()));
            }
            if (zzc.zza()) {
                int i2 = i + 1;
                zzbv.zzf zzb = zzc.zzb();
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (zzb.zza()) {
                        zza(sb, i2, "match_type", zzb.zzb().name());
                    }
                    if (zzb.zzc()) {
                        zza(sb, i2, "expression", zzb.zzd());
                    }
                    if (zzb.zze()) {
                        zza(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        zza(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String str : zzb.zzg()) {
                            zza(sb, i2 + 2);
                            sb.append(str);
                            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                        }
                        sb.append("}\n");
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
            if (zzc.zzc()) {
                zza(sb, i + 1, "number_filter", zzc.zzd());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append('\n');
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzq().zze().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.zzeq r5 = r4.zzq()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzes r5 = r5.zze()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkr.zza(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    static boolean zza(zzaq zzaq, zzn zzn) {
        Preconditions.checkNotNull(zzaq);
        Preconditions.checkNotNull(zzn);
        return !TextUtils.isEmpty(zzn.zzb) || !TextUtils.isEmpty(zzn.zzr);
    }

    static boolean zza(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzq().zzh().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzq().zzh().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            size = size2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, size);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzl().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzo().zzc();
        MessageDigest zzh = zzkv.zzh();
        if (zzh != null) {
            return zzkv.zza(zzh.digest(bArr));
        }
        zzq().zze().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzq().zze().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzq().zze().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final List<Integer> zze() {
        Map<String, String> zza = zzas.zza(this.zza.zzm());
        if (zza == null || zza.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzas.zzao.zza(null).intValue();
        Iterator<Map.Entry<String, String>> it = zza.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, String> next = it.next();
            if (next.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzq().zzh().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzq().zzh().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    static <Builder extends zzji> Builder zza(Builder builder, byte[] bArr) throws zzij {
        zzhl zzb = zzhl.zzb();
        return zzb != null ? (Builder) builder.zza(bArr, zzb) : (Builder) builder.zza(bArr);
    }

    static int zza(zzcd.zzg.zza zza, String str) {
        if (zza == null) {
            return -1;
        }
        for (int i = 0; i < zza.zze(); i++) {
            if (str.equals(zza.zzd(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    private static List<zzcd.zze> zza(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzcd.zze.zza zzm = zzcd.zze.zzm();
                for (String str : bundle.keySet()) {
                    zzcd.zze.zza zza = zzcd.zze.zzm().zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zza.zza(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zza.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zza.zza(((Double) obj).doubleValue());
                    }
                    zzm.zza(zza);
                }
                if (zzm.zzd() > 0) {
                    arrayList.add((zzcd.zze) ((zzhy) zzm.zzy()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzjr zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzkr f_() {
        return super.f_();
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzr zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzaf zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzkj
    public final /* bridge */ /* synthetic */ zzfo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }
}
