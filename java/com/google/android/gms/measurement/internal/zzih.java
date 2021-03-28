package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zznw;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzih extends zzki {
    public zzih(zzkl zzkl) {
        super(zzkl);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzki
    public final boolean zzd() {
        return false;
    }

    public final byte[] zza(zzaq zzaq, String str) {
        zzkw zzkw;
        Bundle bundle;
        zzcd.zzf.zza zza;
        zzcd.zzg.zza zza2;
        zzf zzf;
        byte[] bArr;
        Bundle bundle2;
        zzam zzam;
        long j;
        zzc();
        this.zzy.zzad();
        Preconditions.checkNotNull(zzaq);
        Preconditions.checkNotEmpty(str);
        if (!zzs().zze(str, zzas.zzav)) {
            zzq().zzv().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        } else if ("_iap".equals(zzaq.zza) || "_iapx".equals(zzaq.zza)) {
            zzcd.zzf.zza zzb = zzcd.zzf.zzb();
            zzi().zze();
            try {
                zzf zzb2 = zzi().zzb(str);
                if (zzb2 == null) {
                    zzq().zzv().zza("Log and bundle not available. package_name", str);
                    return new byte[0];
                } else if (!zzb2.zzr()) {
                    zzq().zzv().zza("Log and bundle disabled. package_name", str);
                    byte[] bArr2 = new byte[0];
                    zzi().zzg();
                    return bArr2;
                } else {
                    zzcd.zzg.zza zza3 = zzcd.zzg.zzbh().zza(1).zza("android");
                    if (!TextUtils.isEmpty(zzb2.zzc())) {
                        zza3.zzf(zzb2.zzc());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzn())) {
                        zza3.zze(zzb2.zzn());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzl())) {
                        zza3.zzg(zzb2.zzl());
                    }
                    if (zzb2.zzm() != -2147483648L) {
                        zza3.zzh((int) zzb2.zzm());
                    }
                    zza3.zzf(zzb2.zzo()).zzk(zzb2.zzq());
                    if (!zznv.zzb() || !zzs().zze(zzb2.zzc(), zzas.zzbi)) {
                        if (!TextUtils.isEmpty(zzb2.zze())) {
                            zza3.zzk(zzb2.zze());
                        } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                            zza3.zzo(zzb2.zzf());
                        }
                    } else if (!TextUtils.isEmpty(zzb2.zze())) {
                        zza3.zzk(zzb2.zze());
                    } else if (!TextUtils.isEmpty(zzb2.zzg())) {
                        zza3.zzp(zzb2.zzg());
                    } else if (!TextUtils.isEmpty(zzb2.zzf())) {
                        zza3.zzo(zzb2.zzf());
                    }
                    zzac zza4 = this.zza.zza(str);
                    zza3.zzh(zzb2.zzp());
                    if (this.zzy.zzaa() && zzs().zzh(zza3.zzj())) {
                        if (!zzml.zzb() || !zzs().zza(zzas.zzci)) {
                            zza3.zzj();
                            if (!TextUtils.isEmpty(null)) {
                                zza3.zzn(null);
                            }
                        } else if (zza4.zzc() && !TextUtils.isEmpty(null)) {
                            zza3.zzn(null);
                        }
                    }
                    if (zzml.zzb() && zzs().zza(zzas.zzci)) {
                        zza3.zzq(zza4.zza());
                    }
                    if (!zzml.zzb() || !zzs().zza(zzas.zzci) || zza4.zzc()) {
                        Pair<String, Boolean> zza5 = zzf().zza(zzb2.zzc(), zza4);
                        if (zzb2.zzaf() && zza5 != null && !TextUtils.isEmpty((CharSequence) zza5.first)) {
                            try {
                                zza3.zzh(zza((String) zza5.first, Long.toString(zzaq.zzd)));
                                if (zza5.second != null) {
                                    zza3.zza(((Boolean) zza5.second).booleanValue());
                                }
                            } catch (SecurityException e) {
                                zzq().zzv().zza("Resettable device id encryption failed", e.getMessage());
                                byte[] bArr3 = new byte[0];
                                zzi().zzg();
                                return bArr3;
                            }
                        }
                    }
                    zzk().zzab();
                    zzcd.zzg.zza zzc = zza3.zzc(Build.MODEL);
                    zzk().zzab();
                    zzc.zzb(Build.VERSION.RELEASE).zzf((int) zzk().zze()).zzd(zzk().zzf());
                    try {
                        if (!zzml.zzb() || !zzs().zza(zzas.zzci) || zza4.zze()) {
                            zza3.zzi(zza(zzb2.zzd(), Long.toString(zzaq.zzd)));
                        }
                        if (!TextUtils.isEmpty(zzb2.zzi())) {
                            zza3.zzl(zzb2.zzi());
                        }
                        String zzc2 = zzb2.zzc();
                        List<zzkw> zza6 = zzi().zza(zzc2);
                        Iterator<zzkw> it = zza6.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzkw = null;
                                break;
                            }
                            zzkw = it.next();
                            if ("_lte".equals(zzkw.zzc)) {
                                break;
                            }
                        }
                        if (zzkw == null || zzkw.zze == null) {
                            zzkw zzkw2 = new zzkw(zzc2, "auto", "_lte", zzl().currentTimeMillis(), 0L);
                            zza6.add(zzkw2);
                            zzi().zza(zzkw2);
                        }
                        zzkr f_ = f_();
                        f_.zzq().zzw().zza("Checking account type status for ad personalization signals");
                        if (f_.zzk().zzi()) {
                            String zzc3 = zzb2.zzc();
                            if (zzb2.zzaf() && f_.zzj().zze(zzc3)) {
                                f_.zzq().zzv().zza("Turning off ad personalization due to account type");
                                Iterator<zzkw> it2 = zza6.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    } else if ("_npa".equals(it2.next().zzc)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                zza6.add(new zzkw(zzc3, "auto", "_npa", f_.zzl().currentTimeMillis(), 1L));
                            }
                        }
                        zzcd.zzk[] zzkArr = new zzcd.zzk[zza6.size()];
                        for (int i = 0; i < zza6.size(); i++) {
                            zzcd.zzk.zza zza7 = zzcd.zzk.zzj().zza(zza6.get(i).zzc).zza(zza6.get(i).zzd);
                            f_().zza(zza7, zza6.get(i).zze);
                            zzkArr[i] = (zzcd.zzk) ((zzhy) zza7.zzy());
                        }
                        zza3.zzb(Arrays.asList(zzkArr));
                        if (!zznw.zzb() || !zzs().zza(zzas.zzbz) || !zzs().zza(zzas.zzca)) {
                            bundle = zzaq.zzb.zzb();
                        } else {
                            zzeu zza8 = zzeu.zza(zzaq);
                            zzo().zza(zza8.zzb, zzi().zzi(str));
                            zzo().zza(zza8, zzs().zza(str));
                            bundle = zza8.zzb;
                        }
                        bundle.putLong("_c", 1);
                        zzq().zzv().zza("Marking in-app purchase as real-time");
                        bundle.putLong("_r", 1);
                        bundle.putString("_o", zzaq.zzc);
                        if (zzo().zze(zza3.zzj())) {
                            zzo().zza(bundle, "_dbg", (Object) 1L);
                            zzo().zza(bundle, "_r", (Object) 1L);
                        }
                        zzam zza9 = zzi().zza(str, zzaq.zza);
                        if (zza9 == null) {
                            zzf = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle2 = bundle;
                            bArr = null;
                            zzam = new zzam(str, zzaq.zza, 0, 0, zzaq.zzd, 0, null, null, null, null);
                            j = 0;
                        } else {
                            zzf = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle2 = bundle;
                            bArr = null;
                            j = zza9.zzf;
                            zzam = zza9.zza(zzaq.zzd);
                        }
                        zzi().zza(zzam);
                        zzan zzan = new zzan(this.zzy, zzaq.zzc, str, zzaq.zza, zzaq.zzd, j, bundle2);
                        zzcd.zzc.zza zzb3 = zzcd.zzc.zzj().zza(zzan.zzc).zza(zzan.zzb).zzb(zzan.zzd);
                        Iterator<String> it3 = zzan.zze.iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            zzcd.zze.zza zza10 = zzcd.zze.zzm().zza(next);
                            f_().zza(zza10, zzan.zze.zza(next));
                            zzb3.zza(zza10);
                        }
                        zza2.zza(zzb3).zza(zzcd.zzh.zza().zza(zzcd.zzd.zza().zza(zzam.zzc).zza(zzaq.zza)));
                        zza2.zzc(zzh().zza(zzf.zzc(), Collections.emptyList(), zza2.zzd(), Long.valueOf(zzb3.zzf()), Long.valueOf(zzb3.zzf())));
                        if (zzb3.zze()) {
                            zza2.zzb(zzb3.zzf()).zzc(zzb3.zzf());
                        }
                        long zzk = zzf.zzk();
                        if (zzk != 0) {
                            zza2.zze(zzk);
                        }
                        long zzj = zzf.zzj();
                        if (zzj != 0) {
                            zza2.zzd(zzj);
                        } else if (zzk != 0) {
                            zza2.zzd(zzk);
                        }
                        zzf.zzv();
                        zza2.zzg((int) zzf.zzs()).zzg(33025L).zza(zzl().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
                        zza.zza(zza2);
                        zzf.zza(zza2.zzf());
                        zzf.zzb(zza2.zzg());
                        zzi().zza(zzf);
                        zzi().b_();
                        zzi().zzg();
                        try {
                            return f_().zzc(((zzcd.zzf) ((zzhy) zza.zzy())).zzbk());
                        } catch (IOException e2) {
                            zzq().zze().zza("Data loss. Failed to bundle and serialize. appId", zzeq.zza(str), e2);
                            return bArr;
                        }
                    } catch (SecurityException e3) {
                        zzq().zzv().zza("app instance id encryption failed", e3.getMessage());
                        byte[] bArr4 = new byte[0];
                        zzi().zzg();
                        return bArr4;
                    }
                }
            } finally {
                zzi().zzg();
            }
        } else {
            zzq().zzv().zza("Generating a payload for this event is not available. package_name, event_name", str, zzaq.zza);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
