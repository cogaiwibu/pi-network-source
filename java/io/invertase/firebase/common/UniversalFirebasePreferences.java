package io.invertase.firebase.common;

import android.content.SharedPreferences;
import io.invertase.firebase.app.ReactNativeFirebaseApp;

public class UniversalFirebasePreferences {
    private static final String PREFERENCES_FILE = "io.invertase.firebase";
    private static UniversalFirebasePreferences sharedInstance = new UniversalFirebasePreferences();
    private SharedPreferences preferences;

    public static UniversalFirebasePreferences getSharedInstance() {
        return sharedInstance;
    }

    public boolean contains(String str) {
        return getPreferences().contains(str);
    }

    public void setBooleanValue(String str, boolean z) {
        getPreferences().edit().putBoolean(str, z).apply();
    }

    public boolean getBooleanValue(String str, boolean z) {
        return getPreferences().getBoolean(str, z);
    }

    public void setIntValue(String str, int i) {
        getPreferences().edit().putInt(str, i).apply();
    }

    public int getIntValue(String str, int i) {
        return getPreferences().getInt(str, i);
    }

    public void setLongValue(String str, long j) {
        getPreferences().edit().putLong(str, j).apply();
    }

    public long getLongValue(String str, long j) {
        return getPreferences().getLong(str, j);
    }

    public void setStringValue(String str, String str2) {
        getPreferences().edit().putString(str, str2).apply();
    }

    public String getStringValue(String str, String str2) {
        return getPreferences().getString(str, str2);
    }

    public void clearAll() {
        getPreferences().edit().clear().apply();
    }

    public SharedPreferences.Editor remove(String str) {
        return getPreferences().edit().remove(str);
    }

    private SharedPreferences getPreferences() {
        if (this.preferences == null) {
            this.preferences = ReactNativeFirebaseApp.getApplicationContext().getSharedPreferences("io.invertase.firebase", 0);
        }
        return this.preferences;
    }
}
