package com.facebook.ads.internal.settings;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;

public class MultithreadedBundleWrapper {
    private final Bundle mBundle = new Bundle();

    public synchronized void putBoolean(String str, boolean z) {
        this.mBundle.putBoolean(str, z);
    }

    public synchronized boolean getBoolean(String str) {
        return this.mBundle.getBoolean(str);
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        return this.mBundle.getBoolean(str, z);
    }

    public synchronized ArrayList<String> getStringArrayList(String str) {
        return this.mBundle.getStringArrayList(str);
    }

    public synchronized void putStringArrayList(String str, ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
    }

    public synchronized String getString(String str, String str2) {
        return this.mBundle.getString(str, str2);
    }

    public synchronized void putString(String str, String str2) {
        this.mBundle.putString(str, str2);
    }

    public synchronized void putSerializable(String str, Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
    }

    public synchronized void putStringArray(String str, String[] strArr) {
        this.mBundle.putStringArray(str, strArr);
    }

    public synchronized String[] getStringArray(String str) {
        return this.mBundle.getStringArray(str);
    }

    public synchronized void putInteger(String str, Integer num) {
        if (num != null) {
            this.mBundle.putInt(str, num.intValue());
        } else {
            this.mBundle.remove(str);
        }
    }

    public synchronized Integer getInteger(String str) {
        return this.mBundle.containsKey(str) ? Integer.valueOf(this.mBundle.getInt(str)) : null;
    }

    public synchronized Serializable getSerializable(String str) {
        return this.mBundle.getSerializable(str);
    }

    public Bundle toBundle() {
        return new Bundle(this.mBundle);
    }

    public synchronized void reset(Bundle bundle) {
        this.mBundle.clear();
        this.mBundle.putAll(bundle);
    }
}
