package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfh {
    private final String zza;
    private final Bundle zzb = new Bundle();
    private boolean zzc;
    private Bundle zzd;
    private final /* synthetic */ zzfc zze;

    public zzfh(zzfc zzfc, String str, Bundle bundle) {
        this.zze = zzfc;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    public final Bundle zza() {
        if (!this.zzc) {
            this.zzc = true;
            String string = this.zze.zzf().getString(this.zza, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String string2 = jSONObject.getString("n");
                        String string3 = jSONObject.getString("t");
                        char c = 65535;
                        int hashCode = string3.hashCode();
                        if (hashCode != 100) {
                            if (hashCode != 108) {
                                if (hashCode == 115 && string3.equals("s")) {
                                    c = 0;
                                }
                            } else if (string3.equals("l")) {
                                c = 2;
                            }
                        } else if (string3.equals("d")) {
                            c = 1;
                        }
                        if (c == 0) {
                            bundle.putString(string2, jSONObject.getString("v"));
                        } else if (c == 1) {
                            bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                        } else if (c != 2) {
                            try {
                                this.zze.zzq().zze().zza("Unrecognized persisted bundle type. Type", string3);
                            } catch (NumberFormatException | JSONException unused) {
                                this.zze.zzq().zze().zza("Error reading value from SharedPreferences. Value dropped");
                            }
                        } else {
                            bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    this.zze.zzq().zze().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzb;
            }
        }
        return this.zzd;
    }

    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        if (bundle.size() == 0) {
            edit.remove(this.zza);
        } else {
            edit.putString(this.zza, zzb(bundle));
        }
        edit.apply();
        this.zzd = bundle;
    }

    private final String zzb(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    this.zze.zzq().zze().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }
}
