package com.onesignal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

/* compiled from: BundleCompat */
class BundleCompatBundle implements BundleCompat<Bundle> {
    private Bundle mBundle;

    BundleCompatBundle() {
        this.mBundle = new Bundle();
    }

    BundleCompatBundle(Bundle bundle) {
        this.mBundle = bundle;
    }

    BundleCompatBundle(Intent intent) {
        this.mBundle = intent.getExtras();
    }

    @Override // com.onesignal.BundleCompat
    public void putString(String str, String str2) {
        this.mBundle.putString(str, str2);
    }

    @Override // com.onesignal.BundleCompat
    public void putInt(String str, Integer num) {
        this.mBundle.putInt(str, num.intValue());
    }

    @Override // com.onesignal.BundleCompat
    public void putLong(String str, Long l) {
        this.mBundle.putLong(str, l.longValue());
    }

    @Override // com.onesignal.BundleCompat
    public void putBoolean(String str, Boolean bool) {
        this.mBundle.putBoolean(str, bool.booleanValue());
    }

    @Override // com.onesignal.BundleCompat
    public String getString(String str) {
        return this.mBundle.getString(str);
    }

    @Override // com.onesignal.BundleCompat
    public Integer getInt(String str) {
        return Integer.valueOf(this.mBundle.getInt(str));
    }

    @Override // com.onesignal.BundleCompat
    public Long getLong(String str) {
        return Long.valueOf(this.mBundle.getLong(str));
    }

    @Override // com.onesignal.BundleCompat
    public boolean getBoolean(String str) {
        return this.mBundle.getBoolean(str);
    }

    @Override // com.onesignal.BundleCompat
    public boolean containsKey(String str) {
        return this.mBundle.containsKey(str);
    }

    @Override // com.onesignal.BundleCompat
    public Bundle getBundle() {
        return this.mBundle;
    }

    @Override // com.onesignal.BundleCompat
    public void setBundle(Parcelable parcelable) {
        this.mBundle = (Bundle) parcelable;
    }

    @Override // com.onesignal.BundleCompat
    public boolean getBoolean(String str, boolean z) {
        return this.mBundle.getBoolean(str, z);
    }
}
