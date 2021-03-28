package com.ironsource.mediationsdk;

import android.util.Pair;
import java.util.ArrayList;

public class IntegrationData {
    public String[] activities = null;
    public ArrayList<Pair<String, String>> externalLibs = null;
    public String name;
    public String[] providers = null;
    public String sdkVersion;
    public String[] services = null;
    public boolean validateWriteExternalStorage = false;
    public String version;

    public IntegrationData(String str, String str2) {
        this.name = str;
        this.version = str2;
    }
}
