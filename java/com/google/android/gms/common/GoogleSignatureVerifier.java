package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zzat;
    private final Context mContext;
    private volatile String zzau;

    private GoogleSignatureVerifier(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zzat == null) {
                zzc.zza(context);
                zzat = new GoogleSignatureVerifier(context);
            }
        }
        return zzat;
    }

    public boolean isUidGoogleSigned(int i) {
        zzl zzl;
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            zzl = zzl.zzb("no pkgs");
        } else {
            zzl = null;
            for (String str : packagesForUid) {
                zzl = zza(str, i);
                if (zzl.zzap) {
                    break;
                }
            }
        }
        zzl.zzf();
        return zzl.zzap;
    }

    public boolean isPackageGoogleSigned(String str) {
        zzl zzc = zzc(str);
        zzc.zzf();
        return zzc.zzap;
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        zzd zzd;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzd = zza(packageInfo, zzi.zzaj);
            } else {
                zzd = zza(packageInfo, zzi.zzaj[0]);
            }
            if (zzd != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    private final zzl zza(String str, int i) {
        try {
            PackageInfo zza = Wrappers.packageManager(this.mContext).zza(str, 64, i);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
            if (zza == null) {
                return zzl.zzb("null pkg");
            }
            if (zza.signatures != null) {
                if (zza.signatures.length == 1) {
                    zzg zzg = new zzg(zza.signatures[0].toByteArray());
                    String str2 = zza.packageName;
                    zzl zza2 = zzc.zza(str2, zzg, honorsDebugCertificates, false);
                    if (!zza2.zzap || zza.applicationInfo == null || (zza.applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzg, false, true).zzap) {
                        return zza2;
                    }
                    return zzl.zzb("debuggable release cert app rejected");
                }
            }
            return zzl.zzb("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzl.zzb(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    private final zzl zzc(String str) {
        zzl zzl;
        if (str == null) {
            return zzl.zzb("null pkg");
        }
        if (str.equals(this.zzau)) {
            return zzl.zze();
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(this.mContext).getPackageInfo(str, 64);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
            if (packageInfo == null) {
                zzl = zzl.zzb("null pkg");
            } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                zzl = zzl.zzb("single cert required");
            } else {
                zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
                String str2 = packageInfo.packageName;
                zzl zza = zzc.zza(str2, zzg, honorsDebugCertificates, false);
                zzl = (!zza.zzap || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzg, false, true).zzap) ? zza : zzl.zzb("debuggable release cert app rejected");
            }
            if (zzl.zzap) {
                this.zzau = str;
            }
            return zzl;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzl.zzb(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    private static zzd zza(PackageInfo packageInfo, zzd... zzdArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzdArr.length; i++) {
            if (zzdArr[i].equals(zzg)) {
                return zzdArr[i];
            }
        }
        return null;
    }
}
