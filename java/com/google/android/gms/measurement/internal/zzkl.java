package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public class zzkl implements zzgt {
    private static volatile zzkl zza;
    private final zzky zzaa;
    private zzfo zzb;
    private zzex zzc;
    private zzaf zzd;
    private zzfa zze;
    private zzkh zzf;
    private zzr zzg;
    private final zzkr zzh;
    private zzih zzi;
    private zzjr zzj;
    private final zzfu zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;
    private final Map<String, zzac> zzz;

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public class zza implements zzah {
        zzcd.zzg zza;
        List<Long> zzb;
        List<zzcd.zzc> zzc;
        private long zzd;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final void zza(zzcd.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        @Override // com.google.android.gms.measurement.internal.zzah
        public final boolean zza(long j, zzcd.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbp = this.zzd + ((long) zzc2.zzbp());
            if (zzbp >= ((long) Math.max(0, zzas.zzh.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbp;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzas.zzi.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzcd.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzkl zzkl, zzkk zzkk) {
            this();
        }
    }

    public static zzkl zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzkl.class) {
                if (zza == null) {
                    zza = new zzkl(new zzks(context));
                }
            }
        }
        return zza;
    }

    private zzkl(zzks zzks) {
        this(zzks, null);
    }

    private zzkl(zzks zzks, zzfu zzfu) {
        this.zzl = false;
        this.zzaa = new zzko(this);
        Preconditions.checkNotNull(zzks);
        this.zzk = zzfu.zza(zzks.zza, null, null);
        this.zzy = -1;
        zzkr zzkr = new zzkr(this);
        zzkr.zzak();
        this.zzh = zzkr;
        zzex zzex = new zzex(this);
        zzex.zzak();
        this.zzc = zzex;
        zzfo zzfo = new zzfo(this);
        zzfo.zzak();
        this.zzb = zzfo;
        this.zzz = new HashMap();
        this.zzk.zzp().zza(new zzkk(this, zzks));
    }

    /* access modifiers changed from: private */
    public final void zza(zzks zzks) {
        this.zzk.zzp().zzc();
        zzaf zzaf = new zzaf(this);
        zzaf.zzak();
        this.zzd = zzaf;
        this.zzk.zza().zza(this.zzb);
        zzjr zzjr = new zzjr(this);
        zzjr.zzak();
        this.zzj = zzjr;
        zzr zzr2 = new zzr(this);
        zzr2.zzak();
        this.zzg = zzr2;
        zzih zzih = new zzih(this);
        zzih.zzak();
        this.zzi = zzih;
        zzkh zzkh = new zzkh(this);
        zzkh.zzak();
        this.zzf = zzkh;
        this.zze = new zzfa(this);
        if (this.zzp != this.zzq) {
            this.zzk.zzq().zze().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzl = true;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzk.zzp().zzc();
        zze().zzu();
        if (this.zzk.zzb().zzc.zza() == 0) {
            this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
        }
        zzab();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzt() {
        return this.zzk.zzt();
    }

    public final zzab zzb() {
        return this.zzk.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzeq zzq() {
        return this.zzk.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzfr zzp() {
        return this.zzk.zzp();
    }

    public final zzfo zzc() {
        zzb(this.zzb);
        return this.zzb;
    }

    public final zzex zzd() {
        zzb(this.zzc);
        return this.zzc;
    }

    public final zzaf zze() {
        zzb(this.zzd);
        return this.zzd;
    }

    private final zzfa zzv() {
        zzfa zzfa = this.zze;
        if (zzfa != null) {
            return zzfa;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzkh zzw() {
        zzb(this.zzf);
        return this.zzf;
    }

    public final zzr zzf() {
        zzb(this.zzg);
        return this.zzg;
    }

    public final zzih zzg() {
        zzb(this.zzi);
        return this.zzi;
    }

    public final zzkr zzh() {
        zzb(this.zzh);
        return this.zzh;
    }

    public final zzjr zzi() {
        return this.zzj;
    }

    public final zzeo zzj() {
        return this.zzk.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzm() {
        return this.zzk.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzl() {
        return this.zzk.zzl();
    }

    public final zzkv zzk() {
        return this.zzk.zzh();
    }

    private final void zzx() {
        this.zzk.zzp().zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zzn() {
        if (!this.zzl) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzki zzki) {
        if (zzki == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzki.zzai()) {
            String valueOf = String.valueOf(zzki.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzac zzac) {
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            this.zzz.put(str, zzac);
            zzaf zze2 = zze();
            if (zzml.zzb() && zze2.zzs().zza(zzas.zzci)) {
                Preconditions.checkNotNull(str);
                Preconditions.checkNotNull(zzac);
                zze2.zzc();
                zze2.zzaj();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", zzac.zza());
                try {
                    if (zze2.c_().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        zze2.zzq().zze().zza("Failed to insert/update consent setting (got -1). appId", zzeq.zza(str));
                    }
                } catch (SQLiteException e) {
                    zze2.zzq().zze().zza("Error storing consent setting. appId, error", zzeq.zza(str), e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzac zza(String str) {
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzx();
            zzn();
            zzac = this.zzz.get(str);
            if (zzac == null) {
                zzac = zze().zzj(str);
                if (zzac == null) {
                    zzac = zzac.zza;
                }
                zza(str, zzac);
            }
        }
        return zzac;
    }

    private final long zzy() {
        long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
        zzfc zzb2 = this.zzk.zzb();
        zzb2.zzab();
        zzb2.zzc();
        long zza2 = zzb2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzb2.zzo().zzg().nextInt(86400000));
            zzb2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, String str) {
        boolean z;
        String str2;
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping event", str);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzaq.zza)) {
                this.zzk.zzq().zzh().zza("Could not find package. appId", zzeq.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzk.zzq().zze().zza("App version does not match; dropping event. appId", zzeq.zza(str));
            return;
        }
        String zze2 = zzb2.zze();
        String zzl2 = zzb2.zzl();
        long zzm2 = zzb2.zzm();
        String zzn2 = zzb2.zzn();
        long zzo2 = zzb2.zzo();
        long zzp2 = zzb2.zzp();
        boolean zzr2 = zzb2.zzr();
        String zzi2 = zzb2.zzi();
        long zzae = zzb2.zzae();
        boolean zzaf = zzb2.zzaf();
        boolean zzag = zzb2.zzag();
        String zzf2 = zzb2.zzf();
        Boolean zzah = zzb2.zzah();
        long zzq2 = zzb2.zzq();
        List<String> zzai = zzb2.zzai();
        if (zznv.zzb()) {
            z = zzr2;
            if (this.zzk.zza().zze(zzb2.zzc(), zzas.zzbi)) {
                str2 = zzb2.zzg();
                zzb(zzaq, new zzn(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, z, false, zzi2, zzae, 0L, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2, (zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza()));
            }
        } else {
            z = zzr2;
        }
        str2 = null;
        zzb(zzaq, new zzn(str, zze2, zzl2, zzm2, zzn2, zzo2, zzp2, (String) null, z, false, zzi2, zzae, 0L, 0, zzaf, zzag, false, zzf2, zzah, zzq2, zzai, str2, (zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza()));
    }

    private final void zzb(zzaq zzaq, zzn zzn2) {
        if (zznw.zzb() && this.zzk.zza().zza(zzas.zzbz)) {
            zzeu zza2 = zzeu.zza(zzaq);
            this.zzk.zzh().zza(zza2.zzb, zze().zzi(zzn2.zza));
            this.zzk.zzh().zza(zza2, this.zzk.zza().zza(zzn2.zza));
            zzaq = zza2.zza();
        }
        if (this.zzk.zza().zza(zzas.zzbd) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaq.zza) && "referrer API v2".equals(zzaq.zzb.zzd("_cis"))) {
            String zzd2 = zzaq.zzb.zzd("gclid");
            if (!TextUtils.isEmpty(zzd2)) {
                zza(new zzku("_lgclid", zzaq.zzd, zzd2, "auto"), zzn2);
            }
        }
        zza(zzaq, zzn2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaq zzaq, zzn zzn2) {
        List<zzz> list;
        List<zzz> list2;
        List<zzz> list3;
        zzaq zzaq2 = zzaq;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzx();
        zzn();
        String str = zzn2.zza;
        long j = zzaq2.zzd;
        zzh();
        if (zzkr.zza(zzaq, zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            if (zzn2.zzu != null) {
                if (zzn2.zzu.contains(zzaq2.zza)) {
                    Bundle zzb2 = zzaq2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzaq2 = new zzaq(zzaq2.zza, new zzap(zzb2), zzaq2.zzc, zzaq2.zzd);
                } else {
                    this.zzk.zzq().zzv().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaq2.zza, zzaq2.zzc);
                    return;
                }
            }
            zze().zze();
            try {
                zzaf zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzc();
                zze2.zzaj();
                if (j < 0) {
                    zze2.zzq().zzh().zza("Invalid time querying timed out conditional properties", zzeq.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzz2 : list) {
                    if (zzz2 != null) {
                        this.zzk.zzq().zzw().zza("User property timed out", zzz2.zza, this.zzk.zzi().zzc(zzz2.zzc.zza), zzz2.zzc.zza());
                        if (zzz2.zzg != null) {
                            zzc(new zzaq(zzz2.zzg, j), zzn2);
                        }
                        zze().zze(str, zzz2.zzc.zza);
                    }
                }
                zzaf zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzc();
                zze3.zzaj();
                if (j < 0) {
                    zze3.zzq().zzh().zza("Invalid time querying expired conditional properties", zzeq.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzz zzz3 : list2) {
                    if (zzz3 != null) {
                        this.zzk.zzq().zzw().zza("User property expired", zzz3.zza, this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                        zze().zzb(str, zzz3.zzc.zza);
                        if (zzz3.zzk != null) {
                            arrayList.add(zzz3.zzk);
                        }
                        zze().zze(str, zzz3.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzc(new zzaq((zzaq) obj, j), zzn2);
                }
                zzaf zze4 = zze();
                String str2 = zzaq2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzc();
                zze4.zzaj();
                if (j < 0) {
                    zze4.zzq().zzh().zza("Invalid time querying triggered conditional properties", zzeq.zza(str), zze4.zzn().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzz zzz4 : list3) {
                    if (zzz4 != null) {
                        zzku zzku = zzz4.zzc;
                        zzkw zzkw = new zzkw(zzz4.zza, zzz4.zzb, zzku.zza, j, zzku.zza());
                        if (zze().zza(zzkw)) {
                            this.zzk.zzq().zzw().zza("User property triggered", zzz4.zza, this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        } else {
                            this.zzk.zzq().zze().zza("Too many active user properties, ignoring", zzeq.zza(zzz4.zza), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        }
                        if (zzz4.zzi != null) {
                            arrayList3.add(zzz4.zzi);
                        }
                        zzz4.zzc = new zzku(zzkw);
                        zzz4.zze = true;
                        zze().zza(zzz4);
                    }
                }
                zzc(zzaq2, zzn2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzaq((zzaq) obj2, j), zzn2);
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:282:0x0973  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzc(com.google.android.gms.measurement.internal.zzaq r27, com.google.android.gms.measurement.internal.zzn r28) {
        /*
        // Method dump skipped, instructions count: 2510
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzc(com.google.android.gms.measurement.internal.zzaq, com.google.android.gms.measurement.internal.zzn):void");
    }

    private final String zza(zzac zzac) {
        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zze()) {
            return zzz();
        }
        return null;
    }

    @Deprecated
    private final String zzz() {
        byte[] bArr = new byte[16];
        this.zzk.zzh().zzg().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* access modifiers changed from: package-private */
    public final void zzo() {
        zzf zzb2;
        String str;
        zzx();
        zzn();
        this.zzt = true;
        try {
            Boolean zzaf = this.zzk.zzv().zzaf();
            if (zzaf == null) {
                this.zzk.zzq().zzh().zza("Upload data called on the client side before use of service was decided");
            } else if (zzaf.booleanValue()) {
                this.zzk.zzq().zze().zza("Upload called in the client side when service should be used");
                this.zzt = false;
                zzac();
            } else if (this.zzn > 0) {
                zzab();
                this.zzt = false;
                zzac();
            } else {
                zzx();
                if (this.zzw != null) {
                    this.zzk.zzq().zzw().zza("Uploading requested multiple times");
                    this.zzt = false;
                    zzac();
                } else if (!zzd().zze()) {
                    this.zzk.zzq().zzw().zza("Network not connected, ignoring upload request");
                    zzab();
                    this.zzt = false;
                    zzac();
                } else {
                    long currentTimeMillis = this.zzk.zzl().currentTimeMillis();
                    int zzb3 = this.zzk.zza().zzb(null, zzas.zzap);
                    long zzv2 = currentTimeMillis - zzab.zzv();
                    for (int i = 0; i < zzb3 && zza((String) null, zzv2); i++) {
                    }
                    long zza2 = this.zzk.zzb().zzc.zza();
                    if (zza2 != 0) {
                        this.zzk.zzq().zzv().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza2)));
                    }
                    String d_ = zze().d_();
                    if (!TextUtils.isEmpty(d_)) {
                        if (this.zzy == -1) {
                            this.zzy = zze().zzz();
                        }
                        List<Pair<zzcd.zzg, Long>> zza3 = zze().zza(d_, this.zzk.zza().zzb(d_, zzas.zzf), Math.max(0, this.zzk.zza().zzb(d_, zzas.zzg)));
                        if (!zza3.isEmpty()) {
                            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zzc()) {
                                Iterator<Pair<zzcd.zzg, Long>> it = zza3.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        str = null;
                                        break;
                                    }
                                    zzcd.zzg zzg2 = (zzcd.zzg) it.next().first;
                                    if (!TextUtils.isEmpty(zzg2.zzad())) {
                                        str = zzg2.zzad();
                                        break;
                                    }
                                }
                                if (str != null) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= zza3.size()) {
                                            break;
                                        }
                                        zzcd.zzg zzg3 = (zzcd.zzg) zza3.get(i2).first;
                                        if (!(TextUtils.isEmpty(zzg3.zzad()) || zzg3.zzad().equals(str))) {
                                            zza3 = zza3.subList(0, i2);
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                            }
                            zzcd.zzf.zza zzb4 = zzcd.zzf.zzb();
                            int size = zza3.size();
                            ArrayList arrayList = new ArrayList(zza3.size());
                            boolean z = this.zzk.zza().zzh(d_) && (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zzc());
                            boolean z2 = !zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zzc();
                            boolean z3 = !zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zza(d_).zze();
                            int i3 = 0;
                            while (i3 < size) {
                                zzcd.zzg.zza zza4 = (zzcd.zzg.zza) ((zzcd.zzg) zza3.get(i3).first).zzbo();
                                arrayList.add((Long) zza3.get(i3).second);
                                zza4.zzg(33025L).zza(currentTimeMillis).zzb(false);
                                if (!z) {
                                    zza4.zzr();
                                }
                                if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
                                    if (!z2) {
                                        zza4.zzk();
                                        zza4.zzl();
                                    }
                                    if (!z3) {
                                        zza4.zzm();
                                    }
                                }
                                if (this.zzk.zza().zze(d_, zzas.zzaw)) {
                                    zza4.zzl(zzh().zza(((zzcd.zzg) ((zzhy) zza4.zzy())).zzbk()));
                                }
                                zzb4.zza(zza4);
                                i3++;
                                arrayList = arrayList;
                            }
                            String zza5 = this.zzk.zzq().zza(2) ? zzh().zza((zzcd.zzf) ((zzhy) zzb4.zzy())) : null;
                            zzh();
                            byte[] zzbk = ((zzcd.zzf) ((zzhy) zzb4.zzy())).zzbk();
                            String zza6 = zzas.zzp.zza(null);
                            try {
                                URL url = new URL(zza6);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzw != null) {
                                    this.zzk.zzq().zze().zza("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzw = new ArrayList(arrayList);
                                }
                                this.zzk.zzb().zzd.zza(currentTimeMillis);
                                String str2 = "?";
                                if (size > 0) {
                                    str2 = zzb4.zza(0).zzx();
                                }
                                this.zzk.zzq().zzw().zza("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zzbk.length), zza5);
                                this.zzs = true;
                                zzex zzd2 = zzd();
                                zzkn zzkn = new zzkn(this, d_);
                                zzd2.zzc();
                                zzd2.zzaj();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzbk);
                                Preconditions.checkNotNull(zzkn);
                                zzd2.zzp().zzc(new zzfb(zzd2, d_, url, zzbk, null, zzkn));
                            } catch (MalformedURLException unused) {
                                this.zzk.zzq().zze().zza("Failed to parse upload URL. Not uploading. appId", zzeq.zza(d_), zza6);
                            }
                        }
                    } else {
                        this.zzy = -1;
                        String zza7 = zze().zza(currentTimeMillis - zzab.zzv());
                        if (!TextUtils.isEmpty(zza7) && (zzb2 = zze().zzb(zza7)) != null) {
                            zza(zzb2);
                        }
                    }
                    this.zzt = false;
                    zzac();
                }
            }
        } finally {
            this.zzt = false;
            zzac();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0282, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a5, code lost:
        r6 = r0;
        r25 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:559:0x1037, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0252, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0259, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x025c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x025d, code lost:
        r25 = "";
        r4 = r6;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0263, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0264, code lost:
        r6 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0497  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0502 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0539  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x059b  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x059f  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0605  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x062e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0637  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0656  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x074a  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x08d8  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x08f0  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x090a  */
    /* JADX WARNING: Removed duplicated region for block: B:443:0x0c93  */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x0ca6  */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x0ca9  */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0cd0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x011c A[Catch:{ SQLiteException -> 0x0250, all -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:554:0x1020  */
    /* JADX WARNING: Removed duplicated region for block: B:559:0x1037  */
    /* JADX WARNING: Removed duplicated region for block: B:576:0x04fe A[EDGE_INSN: B:576:0x04fe->B:187:0x04fe ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0259 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:17:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0263 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r44, long r45) {
        /*
        // Method dump skipped, instructions count: 4170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, long):boolean");
    }

    private final void zza(zzcd.zzg.zza zza2, long j, boolean z) {
        zzkw zzkw;
        String str = z ? "_se" : "_lte";
        zzkw zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzkw = new zzkw(zza2.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzkw = new zzkw(zza2.zzj(), "auto", str, this.zzk.zzl().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzcd.zzk zzk2 = (zzcd.zzk) ((zzhy) zzcd.zzk.zzj().zza(str).zza(this.zzk.zzl().currentTimeMillis()).zzb(((Long) zzkw.zze).longValue()).zzy());
        boolean z2 = false;
        int zza3 = zzkr.zza(zza2, str);
        if (zza3 >= 0) {
            zza2.zza(zza3, zzk2);
            z2 = true;
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzkw);
            this.zzk.zzq().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzkw.zze);
        }
    }

    private final boolean zza(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkr.zza((zzcd.zzc) ((zzhy) zza2.zzy()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzd();
        }
        zzh();
        zzcd.zze zza5 = zzkr.zza((zzcd.zzc) ((zzhy) zza3.zzy()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzcd.zzc.zza zza2, zzcd.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzd()));
        zzh();
        zzcd.zze zza4 = zzkr.zza((zzcd.zzc) ((zzhy) zza2.zzy()), "_et");
        if (zza4.zze() && zza4.zzf() > 0) {
            long zzf2 = zza4.zzf();
            zzh();
            zzcd.zze zza5 = zzkr.zza((zzcd.zzc) ((zzhy) zza3.zzy()), "_et");
            if (zza5 != null && zza5.zzf() > 0) {
                zzf2 += zza5.zzf();
            }
            zzh();
            zzkr.zza(zza3, "_et", Long.valueOf(zzf2));
            zzh();
            zzkr.zza(zza2, "_fr", (Object) 1L);
        }
    }

    private static void zza(zzcd.zzc.zza zza2, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zzb())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    private static void zza(zzcd.zzc.zza zza2, int i, String str) {
        List<zzcd.zze> zza3 = zza2.zza();
        for (int i2 = 0; i2 < zza3.size(); i2++) {
            if ("_err".equals(zza3.get(i2).zzb())) {
                return;
            }
        }
        zza2.zza((zzcd.zze) ((zzhy) zzcd.zze.zzm().zza("_err").zza(Long.valueOf((long) i).longValue()).zzy())).zza((zzcd.zze) ((zzhy) zzcd.zze.zzm().zza("_ev").zzb(str).zzy()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx();
        zzn();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzac();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzk.zzb().zzc.zza(this.zzk.zzl().currentTimeMillis());
                this.zzk.zzb().zzd.zza(0);
                zzab();
                this.zzk.zzq().zzw().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zze();
                try {
                    for (Long l : list) {
                        try {
                            zzaf zze2 = zze();
                            long longValue = l.longValue();
                            zze2.zzc();
                            zze2.zzaj();
                            try {
                                if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zze2.zzq().zze().zza("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            if (this.zzx == null || !this.zzx.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzg();
                    this.zzx = null;
                    if (!zzd().zze() || !zzaa()) {
                        this.zzy = -1;
                        zzab();
                    } else {
                        zzo();
                    }
                    this.zzn = 0;
                } catch (Throwable th3) {
                    zze().zzg();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzk.zzq().zze().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzn = this.zzk.zzl().elapsedRealtime();
                this.zzk.zzq().zzw().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzk.zzq().zzw().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzb().zzd.zza(this.zzk.zzl().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzk.zzb().zze.zza(this.zzk.zzl().currentTimeMillis());
            }
            zze().zza(list);
            zzab();
        }
        this.zzs = false;
        zzac();
    }

    private final boolean zzaa() {
        zzx();
        zzn();
        return zze().zzx() || !TextUtils.isEmpty(zze().d_());
    }

    private final void zza(zzf zzf2) {
        ArrayMap arrayMap;
        zzx();
        if (!zznv.zzb() || !this.zzk.zza().zze(zzf2.zzc(), zzas.zzbi)) {
            if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzf())) {
                zza(zzf2.zzc(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(zzf2.zze()) && TextUtils.isEmpty(zzf2.zzg()) && TextUtils.isEmpty(zzf2.zzf())) {
            zza(zzf2.zzc(), 204, null, null, null);
            return;
        }
        String zza2 = this.zzk.zza().zza(zzf2);
        try {
            URL url = new URL(zza2);
            this.zzk.zzq().zzw().zza("Fetching remote configuration", zzf2.zzc());
            zzca.zzb zza3 = zzc().zza(zzf2.zzc());
            String zzb2 = zzc().zzb(zzf2.zzc());
            if (zza3 == null || TextUtils.isEmpty(zzb2)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzb2);
                arrayMap = arrayMap2;
            }
            this.zzr = true;
            zzex zzd2 = zzd();
            String zzc2 = zzf2.zzc();
            zzkm zzkm = new zzkm(this);
            zzd2.zzc();
            zzd2.zzaj();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkm);
            zzd2.zzp().zzc(new zzfb(zzd2, zzc2, url, null, arrayMap, zzkm));
        } catch (MalformedURLException unused) {
            this.zzk.zzq().zze().zza("Failed to parse config URL. Not fetching. appId", zzeq.zza(zzf2.zzc()), zza2);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzab() {
        /*
        // Method dump skipped, instructions count: 627
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzab():void");
    }

    /* access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        zzx();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    private final void zzac() {
        zzx();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzk.zzq().zzw().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzk.zzq().zzw().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.zzo.clear();
        }
    }

    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzm() != -2147483648L) {
                if (zzf2.zzm() == ((long) Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzk.zzm()).getPackageInfo(zzf2.zzc(), 0).versionName;
                if (zzf2.zzl() != null && zzf2.zzl().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzx();
        zzn();
        if (!this.zzm) {
            this.zzm = true;
            if (zzad()) {
                int zza2 = zza(this.zzv);
                int zzae = this.zzk.zzx().zzae();
                zzx();
                if (zza2 > zzae) {
                    this.zzk.zzq().zze().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                } else if (zza2 >= zzae) {
                } else {
                    if (zza(zzae, this.zzv)) {
                        this.zzk.zzq().zzw().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    } else {
                        this.zzk.zzq().zze().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    }
                }
            }
        }
    }

    private final boolean zzad() {
        FileLock fileLock;
        zzx();
        if (!this.zzk.zza().zza(zzas.zzbh) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzk.zzm().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzv = channel;
                FileLock tryLock = channel.tryLock();
                this.zzu = tryLock;
                if (tryLock != null) {
                    this.zzk.zzq().zzw().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzk.zzq().zze().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzk.zzq().zze().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzk.zzq().zze().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzk.zzq().zzh().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzk.zzq().zzw().zza("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzk.zzq().zzh().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzx();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzk.zzq().zze().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            if (this.zzk.zza().zza(zzas.zzbr) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0L);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzk.zzq().zze().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzk.zzq().zze().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzn zzn2) {
        if (this.zzw != null) {
            ArrayList arrayList = new ArrayList();
            this.zzx = arrayList;
            arrayList.addAll(this.zzw);
        }
        zzaf zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzc();
        zze2.zzaj();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr) + c_.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzq().zzw().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzq().zze().zza("Error resetting analytics data. appId, error", zzeq.zza(str), e);
        }
        if (zzn2.zzh) {
            zzb(zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzku zzku, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            int zzb2 = this.zzk.zzh().zzb(zzku.zza);
            if (zzb2 != 0) {
                this.zzk.zzh();
                this.zzk.zzh().zza(this.zzaa, zzn2.zza, zzb2, "_ev", zzkv.zza(zzku.zza, 24, true), zzku.zza != null ? zzku.zza.length() : 0);
                return;
            }
            int zzb3 = this.zzk.zzh().zzb(zzku.zza, zzku.zza());
            if (zzb3 != 0) {
                this.zzk.zzh();
                String zza2 = zzkv.zza(zzku.zza, 24, true);
                Object zza3 = zzku.zza();
                this.zzk.zzh().zza(this.zzaa, zzn2.zza, zzb3, "_ev", zza2, (zza3 == null || (!(zza3 instanceof String) && !(zza3 instanceof CharSequence))) ? 0 : String.valueOf(zza3).length());
                return;
            }
            Object zzc2 = this.zzk.zzh().zzc(zzku.zza, zzku.zza());
            if (zzc2 != null) {
                if ("_sid".equals(zzku.zza)) {
                    long j = zzku.zzb;
                    String str = zzku.zze;
                    long j2 = 0;
                    zzkw zzc3 = zze().zzc(zzn2.zza, "_sno");
                    if (zzc3 == null || !(zzc3.zze instanceof Long)) {
                        if (zzc3 != null) {
                            this.zzk.zzq().zzh().zza("Retrieved last session number from database does not contain a valid (long) value", zzc3.zze);
                        }
                        zzam zza4 = zze().zza(zzn2.zza, "_s");
                        if (zza4 != null) {
                            j2 = zza4.zzc;
                            this.zzk.zzq().zzw().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                        }
                    } else {
                        j2 = ((Long) zzc3.zze).longValue();
                    }
                    zza(new zzku("_sno", j, Long.valueOf(j2 + 1), str), zzn2);
                }
                zzkw zzkw = new zzkw(zzn2.zza, zzku.zze, zzku.zza, zzku.zzb, zzc2);
                this.zzk.zzq().zzw().zza("Setting user property", this.zzk.zzi().zzc(zzkw.zzc), zzc2);
                zze().zze();
                try {
                    zzc(zzn2);
                    boolean zza5 = zze().zza(zzkw);
                    zze().b_();
                    if (!zza5) {
                        this.zzk.zzq().zze().zza("Too many unique user properties are set. Ignoring user property", this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                        this.zzk.zzh().zza(this.zzaa, zzn2.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zze().zzg();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzku zzku, zzn zzn2) {
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
            } else if (!"_npa".equals(zzku.zza) || zzn2.zzs == null) {
                this.zzk.zzq().zzv().zza("Removing user property", this.zzk.zzi().zzc(zzku.zza));
                zze().zze();
                try {
                    zzc(zzn2);
                    zze().zzb(zzn2.zza, zzku.zza);
                    zze().b_();
                    this.zzk.zzq().zzv().zza("User property removed", this.zzk.zzi().zzc(zzku.zza));
                } finally {
                    zze().zzg();
                }
            } else {
                this.zzk.zzq().zzv().zza("Falling back to manifest metadata value for ad personalization");
                zza(new zzku("_npa", this.zzk.zzl().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), "auto"), zzn2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzki zzki) {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final void zzs() {
        this.zzq++;
    }

    /* access modifiers changed from: package-private */
    public final zzfu zzu() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x011b A[Catch:{ all -> 0x04af }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0255  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.measurement.internal.zzn r22) {
        /*
        // Method dump skipped, instructions count: 1210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zzb(com.google.android.gms.measurement.internal.zzn):void");
    }

    private final zzn zzb(String str) {
        zzf zzb2 = zze().zzb(str);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzl())) {
            this.zzk.zzq().zzv().zza("No app data available; dropping", str);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            return new zzn(str, zzb2.zze(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), zzb2.zzo(), zzb2.zzp(), (String) null, zzb2.zzr(), false, zzb2.zzi(), zzb2.zzae(), 0L, 0, zzb2.zzaf(), zzb2.zzag(), false, zzb2.zzf(), zzb2.zzah(), zzb2.zzq(), zzb2.zzai(), (!zznv.zzb() || !this.zzk.zza().zze(str, zzas.zzbi)) ? null : zzb2.zzg(), (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) ? "" : zza(str).zza());
        }
        this.zzk.zzq().zze().zza("App version does not match; dropping. appId", zzeq.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz zzz2) {
        zzn zzb2 = zzb(zzz2.zza);
        if (zzb2 != null) {
            zza(zzz2, zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzz zzz2, zzn zzn2) {
        Preconditions.checkNotNull(zzz2);
        Preconditions.checkNotEmpty(zzz2.zza);
        Preconditions.checkNotNull(zzz2.zzb);
        Preconditions.checkNotNull(zzz2.zzc);
        Preconditions.checkNotEmpty(zzz2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zzz zzz3 = new zzz(zzz2);
            boolean z = false;
            zzz3.zze = false;
            zze().zze();
            try {
                zzz zzd2 = zze().zzd(zzz3.zza, zzz3.zzc.zza);
                if (zzd2 != null && !zzd2.zzb.equals(zzz3.zzb)) {
                    this.zzk.zzq().zzh().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzb, zzd2.zzb);
                }
                if (zzd2 != null && zzd2.zze) {
                    zzz3.zzb = zzd2.zzb;
                    zzz3.zzd = zzd2.zzd;
                    zzz3.zzh = zzd2.zzh;
                    zzz3.zzf = zzd2.zzf;
                    zzz3.zzi = zzd2.zzi;
                    zzz3.zze = zzd2.zze;
                    zzz3.zzc = new zzku(zzz3.zzc.zza, zzd2.zzc.zzb, zzz3.zzc.zza(), zzd2.zzc.zze);
                } else if (TextUtils.isEmpty(zzz3.zzf)) {
                    zzz3.zzc = new zzku(zzz3.zzc.zza, zzz3.zzd, zzz3.zzc.zza(), zzz3.zzc.zze);
                    zzz3.zze = true;
                    z = true;
                }
                if (zzz3.zze) {
                    zzku zzku = zzz3.zzc;
                    zzkw zzkw = new zzkw(zzz3.zza, zzz3.zzb, zzku.zza, zzku.zzb, zzku.zza());
                    if (zze().zza(zzkw)) {
                        this.zzk.zzq().zzv().zza("User property updated immediately", zzz3.zza, this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                    } else {
                        this.zzk.zzq().zze().zza("(2)Too many active user properties, ignoring", zzeq.zza(zzz3.zza), this.zzk.zzi().zzc(zzkw.zzc), zzkw.zze);
                    }
                    if (z && zzz3.zzi != null) {
                        zzc(new zzaq(zzz3.zzi, zzz3.zzd), zzn2);
                    }
                }
                if (zze().zza(zzz3)) {
                    this.zzk.zzq().zzv().zza("Conditional property added", zzz3.zza, this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                } else {
                    this.zzk.zzq().zze().zza("Too many conditional properties, ignoring", zzeq.zza(zzz3.zza), this.zzk.zzi().zzc(zzz3.zzc.zza), zzz3.zzc.zza());
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzz zzz2) {
        zzn zzb2 = zzb(zzz2.zza);
        if (zzb2 != null) {
            zzb(zzz2, zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzz zzz2, zzn zzn2) {
        Preconditions.checkNotNull(zzz2);
        Preconditions.checkNotEmpty(zzz2.zza);
        Preconditions.checkNotNull(zzz2.zzc);
        Preconditions.checkNotEmpty(zzz2.zzc.zza);
        zzx();
        zzn();
        if (zze(zzn2)) {
            if (!zzn2.zzh) {
                zzc(zzn2);
                return;
            }
            zze().zze();
            try {
                zzc(zzn2);
                zzz zzd2 = zze().zzd(zzz2.zza, zzz2.zzc.zza);
                if (zzd2 != null) {
                    this.zzk.zzq().zzv().zza("Removing conditional user property", zzz2.zza, this.zzk.zzi().zzc(zzz2.zzc.zza));
                    zze().zze(zzz2.zza, zzz2.zzc.zza);
                    if (zzd2.zze) {
                        zze().zzb(zzz2.zza, zzz2.zzc.zza);
                    }
                    if (zzz2.zzk != null) {
                        Bundle bundle = null;
                        if (zzz2.zzk.zzb != null) {
                            bundle = zzz2.zzk.zzb.zzb();
                        }
                        zzc(this.zzk.zzh().zza(zzz2.zza, zzz2.zzk.zza, bundle, zzd2.zzb, zzz2.zzk.zzd, true, false, zzlo.zzb() && this.zzk.zza().zza(zzas.zzcl)), zzn2);
                    }
                } else {
                    this.zzk.zzq().zzh().zza("Conditional user property doesn't exist", zzeq.zza(zzz2.zza), this.zzk.zzi().zzc(zzz2.zzc.zza));
                }
                zze().b_();
            } finally {
                zze().zzg();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0206  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzf zza(com.google.android.gms.measurement.internal.zzn r9, com.google.android.gms.measurement.internal.zzf r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 585
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.zza(com.google.android.gms.measurement.internal.zzn, com.google.android.gms.measurement.internal.zzf, java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* access modifiers changed from: package-private */
    public final zzf zzc(zzn zzn2) {
        String str;
        zzx();
        zzn();
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn2.zza);
        zzf zzb2 = zze().zzb(zzn2.zza);
        zzac zzac = zzac.zza;
        if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci)) {
            zzac = zza(zzn2.zza).zzb(zzac.zza(zzn2.zzw));
        }
        if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) {
            str = this.zzj.zza(zzn2.zza);
        } else {
            str = "";
        }
        if (!zzne.zzb() || !this.zzk.zza().zza(zzas.zzbn)) {
            return zza(zzn2, zzb2, str);
        }
        if (zzb2 == null) {
            zzb2 = new zzf(this.zzk, zzn2.zza);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzb2.zza(zzz());
                zzb2.zze(str);
            } else {
                if (zzac.zze()) {
                    zzb2.zza(zza(zzac));
                }
                if (zzac.zzc()) {
                    zzb2.zze(str);
                }
            }
        } else if ((!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci) || zzac.zzc()) && !str.equals(zzb2.zzh())) {
            zzb2.zze(str);
            if (!zzml.zzb() || !this.zzk.zza().zza(zzas.zzci)) {
                zzb2.zza(zzz());
            } else {
                zzb2.zza(zza(zzac));
            }
        } else if (zzml.zzb() && this.zzk.zza().zza(zzas.zzci) && TextUtils.isEmpty(zzb2.zzd()) && zzac.zze()) {
            zzb2.zza(zza(zzac));
        }
        zzb2.zzb(zzn2.zzb);
        zzb2.zzc(zzn2.zzr);
        if (zznv.zzb() && this.zzk.zza().zze(zzb2.zzc(), zzas.zzbi)) {
            zzb2.zzd(zzn2.zzv);
        }
        if (!TextUtils.isEmpty(zzn2.zzk)) {
            zzb2.zzf(zzn2.zzk);
        }
        if (zzn2.zze != 0) {
            zzb2.zzd(zzn2.zze);
        }
        if (!TextUtils.isEmpty(zzn2.zzc)) {
            zzb2.zzg(zzn2.zzc);
        }
        zzb2.zzc(zzn2.zzj);
        if (zzn2.zzd != null) {
            zzb2.zzh(zzn2.zzd);
        }
        zzb2.zze(zzn2.zzf);
        zzb2.zza(zzn2.zzh);
        if (!TextUtils.isEmpty(zzn2.zzg)) {
            zzb2.zzi(zzn2.zzg);
        }
        if (!this.zzk.zza().zza(zzas.zzbx)) {
            zzb2.zzp(zzn2.zzl);
        }
        zzb2.zzb(zzn2.zzo);
        zzb2.zzc(zzn2.zzp);
        zzb2.zza(zzn2.zzs);
        zzb2.zzf(zzn2.zzt);
        if (zzb2.zza()) {
            zze().zza(zzb2);
        }
        return zzb2;
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzk.zzp().zza(new zzkp(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzk.zzq().zze().zza("Failed to get app instance id. appId", zzeq.zza(zzn2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzab();
    }

    private final boolean zze(zzn zzn2) {
        return (!zznv.zzb() || !this.zzk.zza().zze(zzn2.zza, zzas.zzbi)) ? !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzr) : !TextUtils.isEmpty(zzn2.zzb) || !TextUtils.isEmpty(zzn2.zzv) || !TextUtils.isEmpty(zzn2.zzr);
    }
}
