package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public interface zzei extends IInterface {
    List<zzku> zza(zzn zzn, boolean z) throws RemoteException;

    List<zzz> zza(String str, String str2, zzn zzn) throws RemoteException;

    List<zzz> zza(String str, String str2, String str3) throws RemoteException;

    List<zzku> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zzku> zza(String str, String str2, boolean z, zzn zzn) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzn zzn) throws RemoteException;

    void zza(zzaq zzaq, zzn zzn) throws RemoteException;

    void zza(zzaq zzaq, String str, String str2) throws RemoteException;

    void zza(zzku zzku, zzn zzn) throws RemoteException;

    void zza(zzn zzn) throws RemoteException;

    void zza(zzz zzz) throws RemoteException;

    void zza(zzz zzz, zzn zzn) throws RemoteException;

    byte[] zza(zzaq zzaq, String str) throws RemoteException;

    void zzb(zzn zzn) throws RemoteException;

    String zzc(zzn zzn) throws RemoteException;

    void zzd(zzn zzn) throws RemoteException;

    void zze(zzn zzn) throws RemoteException;
}
