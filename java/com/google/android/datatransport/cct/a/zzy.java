package com.google.android.datatransport.cct.a;

import android.util.SparseArray;
import com.google.android.datatransport.cct.a.zzn;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public abstract class zzy {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static abstract class zza {
        public abstract zza zza(zzb zzb);

        public abstract zza zza(zzc zzc);

        public abstract zzy zza();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zzb extends Enum<zzb> {
        public static final zzb zza = new zzb("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
        public static final zzb zzb = new zzb("GPRS", 1, 1);
        public static final zzb zzc = new zzb("EDGE", 2, 2);
        public static final zzb zzd = new zzb("UMTS", 3, 3);
        public static final zzb zze = new zzb("CDMA", 4, 4);
        public static final zzb zzf = new zzb("EVDO_0", 5, 5);
        public static final zzb zzg = new zzb("EVDO_A", 6, 6);
        public static final zzb zzh = new zzb("RTT", 7, 7);
        public static final zzb zzi = new zzb("HSDPA", 8, 8);
        public static final zzb zzj = new zzb("HSUPA", 9, 9);
        public static final zzb zzk = new zzb("HSPA", 10, 10);
        public static final zzb zzl = new zzb("IDEN", 11, 11);
        public static final zzb zzm = new zzb("EVDO_B", 12, 12);
        public static final zzb zzn = new zzb("LTE", 13, 13);
        public static final zzb zzo = new zzb("EHRPD", 14, 14);
        public static final zzb zzp = new zzb("HSPAP", 15, 15);
        public static final zzb zzq = new zzb("GSM", 16, 16);
        public static final zzb zzr = new zzb("TD_SCDMA", 17, 17);
        public static final zzb zzs = new zzb("IWLAN", 18, 18);
        public static final zzb zzt = new zzb("LTE_CA", 19, 19);
        public static final zzb zzu = new zzb("COMBINED", 20, 100);
        private static final SparseArray<zzb> zzv;
        private final int zzw;

        static {
            SparseArray<zzb> sparseArray = new SparseArray<>();
            zzv = sparseArray;
            sparseArray.put(0, zza);
            zzv.put(1, zzb);
            zzv.put(2, zzc);
            zzv.put(3, zzd);
            zzv.put(4, zze);
            zzv.put(5, zzf);
            zzv.put(6, zzg);
            zzv.put(7, zzh);
            zzv.put(8, zzi);
            zzv.put(9, zzj);
            zzv.put(10, zzk);
            zzv.put(11, zzl);
            zzv.put(12, zzm);
            zzv.put(13, zzn);
            zzv.put(14, zzo);
            zzv.put(15, zzp);
            zzv.put(16, zzq);
            zzv.put(17, zzr);
            zzv.put(18, zzs);
            zzv.put(19, zzt);
        }

        private zzb(String str, int i, int i2) {
            this.zzw = i2;
        }

        public int zza() {
            return this.zzw;
        }

        public static zzb zza(int i) {
            return zzv.get(i);
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zzc extends Enum<zzc> {
        public static final zzc zza = new zzc("MOBILE", 0, 0);
        public static final zzc zzb = new zzc("WIFI", 1, 1);
        public static final zzc zzc = new zzc("MOBILE_MMS", 2, 2);
        public static final zzc zzd = new zzc("MOBILE_SUPL", 3, 3);
        public static final zzc zze = new zzc("MOBILE_DUN", 4, 4);
        public static final zzc zzf = new zzc("MOBILE_HIPRI", 5, 5);
        public static final zzc zzg = new zzc("WIMAX", 6, 6);
        public static final zzc zzh = new zzc("BLUETOOTH", 7, 7);
        public static final zzc zzi = new zzc("DUMMY", 8, 8);
        public static final zzc zzj = new zzc("ETHERNET", 9, 9);
        public static final zzc zzk = new zzc("MOBILE_FOTA", 10, 10);
        public static final zzc zzl = new zzc("MOBILE_IMS", 11, 11);
        public static final zzc zzm = new zzc("MOBILE_CBS", 12, 12);
        public static final zzc zzn = new zzc("WIFI_P2P", 13, 13);
        public static final zzc zzo = new zzc("MOBILE_IA", 14, 14);
        public static final zzc zzp = new zzc("MOBILE_EMERGENCY", 15, 15);
        public static final zzc zzq = new zzc("PROXY", 16, 16);
        public static final zzc zzr = new zzc("VPN", 17, 17);
        public static final zzc zzs = new zzc("NONE", 18, -1);
        private static final SparseArray<zzc> zzt;
        private final int zzu;

        static {
            SparseArray<zzc> sparseArray = new SparseArray<>();
            zzt = sparseArray;
            sparseArray.put(0, zza);
            zzt.put(1, zzb);
            zzt.put(2, zzc);
            zzt.put(3, zzd);
            zzt.put(4, zze);
            zzt.put(5, zzf);
            zzt.put(6, zzg);
            zzt.put(7, zzh);
            zzt.put(8, zzi);
            zzt.put(9, zzj);
            zzt.put(10, zzk);
            zzt.put(11, zzl);
            zzt.put(12, zzm);
            zzt.put(13, zzn);
            zzt.put(14, zzo);
            zzt.put(15, zzp);
            zzt.put(16, zzq);
            zzt.put(17, zzr);
            zzt.put(-1, zzs);
        }

        private zzc(String str, int i, int i2) {
            this.zzu = i2;
        }

        public int zza() {
            return this.zzu;
        }

        public static zzc zza(int i) {
            return zzt.get(i);
        }
    }

    public static zza zza() {
        return new zzn.zza();
    }
}
