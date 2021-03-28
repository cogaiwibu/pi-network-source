package com.ironsource.sdk.Events;

import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Events;

public class SDK5Events {
    public static Event adunitCouldNotLoadToWebView = new Event(2016, formatEventName("adunitcouldnotloadtowebview"));
    public static Event adunitCouldNotLoadToWebViewBanners = new Event(2019, formatEventName("adunitcouldnotloadtowebviewbanners"));
    public static Event appendNativeFeaturesDataFailed = new Event(2015, formatEventName("appendnativefeaturesdatafailed"));
    public static Event bannerAlreadyDestroyed = new Event(2020, formatEventName("banneralreadydestroyed"));
    public static Event controllerFailed = new Event(2013, formatEventName("controllerfailed"));
    public static Event controllerStageReady = new Event(2004, formatEventName("controllerstageready"));
    public static Event createControllerNative = new Event(2003, formatEventName("createcontrollernative"));
    public static Event createControllerWeb = new Event(2002, formatEventName("createcontrollerweb"));
    public static Event extractInstalledPackagesFailed = new Event(2014, formatEventName("extractinstalledpackagesfailed"));
    public static Event failedRegisterActivityLifecycle = new Event(2021, formatEventName("fialedregactlifecycle"));
    public static Event initProduct = new Event(2007, formatEventName("initproduct"));
    public static Event initProductFailed = new Event(AdError.REMOTE_ADS_SERVICE_ERROR, formatEventName("initproductfailed"));
    public static Event initSDK = new Event(2001, formatEventName("initsdk"));
    public static Event loadAd = new Event(IronSourceConstants.IS_INSTANCE_OPENED, formatEventName("loadad"));
    public static Event loadAdFailed = new Event(2006, formatEventName("loadadfailed"));
    public static Event loadAdSuccess = new Event(2011, formatEventName("loadadsuccess"));
    public static Event loadProduct = new Event(AdError.INTERSTITIAL_AD_TIMEOUT, formatEventName("loadproduct"));
    public static Event parseAdmFailed = new Event(2010, formatEventName("parseadmfailed"));
    public static Event removeWebViewFailed = new Event(2018, formatEventName("removewebviewfailed"));
    public static Event webViewCleanUpFailed = new Event(2017, formatEventName("webviewcleanupfailed"));

    /* access modifiers changed from: package-private */
    public static class Event {
        int id;
        String name;

        Event(int i, String str) {
            this.id = i;
            this.name = str;
        }
    }

    static String formatEventName(String str) {
        return Events.EVENT_PREFIX + str;
    }
}
