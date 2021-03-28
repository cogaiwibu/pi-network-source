package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ProviderSettingsHolder {
    private static ProviderSettingsHolder mInstance;
    private ArrayList<ProviderSettings> mProviderSettingsArrayList = new ArrayList<>();

    public static synchronized ProviderSettingsHolder getProviderSettingsHolder() {
        ProviderSettingsHolder providerSettingsHolder;
        synchronized (ProviderSettingsHolder.class) {
            if (mInstance == null) {
                mInstance = new ProviderSettingsHolder();
            }
            providerSettingsHolder = mInstance;
        }
        return providerSettingsHolder;
    }

    private ProviderSettingsHolder() {
    }

    public void addProviderSettings(ProviderSettings providerSettings) {
        if (providerSettings != null) {
            this.mProviderSettingsArrayList.add(providerSettings);
        }
    }

    public ProviderSettings getProviderSettings(String str) {
        Iterator<ProviderSettings> it = this.mProviderSettingsArrayList.iterator();
        while (it.hasNext()) {
            ProviderSettings next = it.next();
            if (next.getProviderName().equals(str)) {
                return next;
            }
        }
        ProviderSettings providerSettings = new ProviderSettings(str);
        addProviderSettings(providerSettings);
        return providerSettings;
    }

    public HashSet<String> getProviderSettingsByReflectionName(String str, String str2) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            Iterator<ProviderSettings> it = this.mProviderSettingsArrayList.iterator();
            while (it.hasNext()) {
                ProviderSettings next = it.next();
                if (next.getProviderTypeForReflection().equals(str)) {
                    if (next.getRewardedVideoSettings() != null && next.getRewardedVideoSettings().length() > 0 && !TextUtils.isEmpty(next.getRewardedVideoSettings().optString(str2))) {
                        hashSet.add(next.getRewardedVideoSettings().optString(str2));
                    }
                    if (next.getInterstitialSettings() != null && next.getInterstitialSettings().length() > 0 && !TextUtils.isEmpty(next.getInterstitialSettings().optString(str2))) {
                        hashSet.add(next.getInterstitialSettings().optString(str2));
                    }
                    if (next.getBannerSettings() != null && next.getBannerSettings().length() > 0 && !TextUtils.isEmpty(next.getBannerSettings().optString(str2))) {
                        hashSet.add(next.getBannerSettings().optString(str2));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hashSet;
    }

    public boolean containsProviderSettings(String str) {
        Iterator<ProviderSettings> it = this.mProviderSettingsArrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getProviderName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ProviderSettings> getProviderSettingsArrayList() {
        return this.mProviderSettingsArrayList;
    }

    public void fillSubProvidersDetails() {
        Iterator<ProviderSettings> it = this.mProviderSettingsArrayList.iterator();
        while (it.hasNext()) {
            ProviderSettings next = it.next();
            if (next.isMultipleInstances() && !TextUtils.isEmpty(next.getProviderTypeForReflection())) {
                ProviderSettings providerSettings = getProviderSettings(next.getProviderTypeForReflection());
                next.setInterstitialSettings(IronSourceUtils.mergeJsons(next.getInterstitialSettings(), providerSettings.getInterstitialSettings()));
                next.setRewardedVideoSettings(IronSourceUtils.mergeJsons(next.getRewardedVideoSettings(), providerSettings.getRewardedVideoSettings()));
                next.setBannerSettings(IronSourceUtils.mergeJsons(next.getBannerSettings(), providerSettings.getBannerSettings()));
            }
        }
    }
}
