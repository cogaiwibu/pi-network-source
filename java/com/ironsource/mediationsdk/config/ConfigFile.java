package com.ironsource.mediationsdk.config;

import java.util.Arrays;

public class ConfigFile {
    private static ConfigFile mInstance;
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mPluginVersion;
    private String[] mSupportedPlugins = {"Unity", "AdobeAir", "Xamarin", "Corona", "AdMob", "MoPub"};

    public static synchronized ConfigFile getConfigFile() {
        ConfigFile configFile;
        synchronized (ConfigFile.class) {
            if (mInstance == null) {
                mInstance = new ConfigFile();
            }
            configFile = mInstance;
        }
        return configFile;
    }

    public void setPluginData(String str, String str2, String str3) {
        if (str != null) {
            if (Arrays.asList(this.mSupportedPlugins).contains(str)) {
                this.mPluginType = str;
            } else {
                this.mPluginType = null;
            }
        }
        if (str2 != null) {
            this.mPluginVersion = str2;
        }
        if (str3 != null) {
            this.mPluginFrameworkVersion = str3;
        }
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getPluginVersion() {
        return this.mPluginVersion;
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }
}
