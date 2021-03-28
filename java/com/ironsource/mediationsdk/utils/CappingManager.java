package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.PlacementAvailabilitySettings;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import java.util.Calendar;
import java.util.TimeZone;

public class CappingManager {
    private static final String CAPPING_TIME_THRESHOLD = "CappingManager.CAPPING_TIME_THRESHOLD";
    private static final String CAPPING_TYPE = "CappingManager.CAPPING_TYPE";
    private static final String CURRENT_NUMBER_OF_SHOWS = "CappingManager.CURRENT_NUMBER_OF_SHOWS";
    private static final String IS_CAPPING_ENABLED = "CappingManager.IS_CAPPING_ENABLED";
    private static final String IS_DELIVERY_ENABLED = "CappingManager.IS_DELIVERY_ENABLED";
    private static final String IS_PACING_ENABLED = "CappingManager.IS_PACING_ENABLED";
    private static final String MAX_NUMBER_OF_SHOWS = "CappingManager.MAX_NUMBER_OF_SHOWS";
    private static final String SECONDS_BETWEEN_SHOWS = "CappingManager.SECONDS_BETWEEN_SHOWS";
    private static final String TIME_OF_THE_PREVIOUS_SHOW = "CappingManager.TIME_OF_THE_PREVIOUS_SHOW";

    public enum ECappingStatus {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    public static synchronized void addCappingInfo(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (CappingManager.class) {
            if (context != null && interstitialPlacement != null) {
                PlacementAvailabilitySettings placementAvailabilitySettings = interstitialPlacement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    addCappingInfo(context, "Interstitial", interstitialPlacement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void addCappingInfo(Context context, Placement placement) {
        synchronized (CappingManager.class) {
            if (context != null && placement != null) {
                PlacementAvailabilitySettings placementAvailabilitySettings = placement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    addCappingInfo(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void addCappingInfo(Context context, BannerPlacement bannerPlacement) {
        synchronized (CappingManager.class) {
            if (context != null && bannerPlacement != null) {
                PlacementAvailabilitySettings placementAvailabilitySettings = bannerPlacement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    addCappingInfo(context, IronSourceConstants.BANNER_AD_UNIT, bannerPlacement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized ECappingStatus isPlacementCapped(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (CappingManager.class) {
            if (!(context == null || interstitialPlacement == null)) {
                if (interstitialPlacement.getPlacementAvailabilitySettings() != null) {
                    return isPlacementCapped(context, "Interstitial", interstitialPlacement.getPlacementName());
                }
            }
            return ECappingStatus.NOT_CAPPED;
        }
    }

    public static synchronized boolean isInterstitialPlacementCapped(Context context, String str) {
        boolean z;
        synchronized (CappingManager.class) {
            z = isPlacementCapped(context, "Interstitial", str) != ECappingStatus.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized boolean isBnPlacementCapped(Context context, String str) {
        boolean z;
        synchronized (CappingManager.class) {
            z = isPlacementCapped(context, IronSourceConstants.BANNER_AD_UNIT, str) != ECappingStatus.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized ECappingStatus isPlacementCapped(Context context, Placement placement) {
        synchronized (CappingManager.class) {
            if (!(context == null || placement == null)) {
                if (placement.getPlacementAvailabilitySettings() != null) {
                    return isPlacementCapped(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
                }
            }
            return ECappingStatus.NOT_CAPPED;
        }
    }

    public static synchronized boolean isRvPlacementCapped(Context context, String str) {
        boolean z;
        synchronized (CappingManager.class) {
            z = isPlacementCapped(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str) != ECappingStatus.NOT_CAPPED;
        }
        return z;
    }

    public static synchronized void incrementShowCounter(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (CappingManager.class) {
            if (interstitialPlacement != null) {
                incrementShowCounter(context, "Interstitial", interstitialPlacement.getPlacementName());
            }
        }
    }

    public static synchronized void incrementIsShowCounter(Context context, String str) {
        synchronized (CappingManager.class) {
            incrementShowCounter(context, "Interstitial", str);
        }
    }

    public static synchronized void incrementShowCounter(Context context, Placement placement) {
        synchronized (CappingManager.class) {
            if (placement != null) {
                incrementShowCounter(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
            }
        }
    }

    public static synchronized void incrementRvShowCounter(Context context, String str) {
        synchronized (CappingManager.class) {
            incrementShowCounter(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str);
        }
    }

    public static synchronized void incrementBnShowCounter(Context context, String str) {
        synchronized (CappingManager.class) {
            if (!TextUtils.isEmpty(str)) {
                incrementShowCounter(context, IronSourceConstants.BANNER_AD_UNIT, str);
            }
        }
    }

    private static String constructSharedPrefsKey(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    private static ECappingStatus isPlacementCapped(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, constructSharedPrefsKey(str, IS_DELIVERY_ENABLED, str2), true)) {
            return ECappingStatus.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, constructSharedPrefsKey(str, IS_PACING_ENABLED, str2), false)) {
            if (currentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, constructSharedPrefsKey(str, TIME_OF_THE_PREVIOUS_SHOW, str2), 0) < ((long) (IronSourceUtils.getIntFromSharedPrefs(context, constructSharedPrefsKey(str, SECONDS_BETWEEN_SHOWS, str2), 0) * 1000))) {
                return ECappingStatus.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, constructSharedPrefsKey(str, IS_CAPPING_ENABLED, str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, constructSharedPrefsKey(str, MAX_NUMBER_OF_SHOWS, str2), 0);
            String constructSharedPrefsKey = constructSharedPrefsKey(str, CURRENT_NUMBER_OF_SHOWS, str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, constructSharedPrefsKey, 0);
            String constructSharedPrefsKey2 = constructSharedPrefsKey(str, CAPPING_TIME_THRESHOLD, str2);
            if (currentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, constructSharedPrefsKey2, 0)) {
                IronSourceUtils.saveIntToSharedPrefs(context, constructSharedPrefsKey, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, constructSharedPrefsKey2, 0);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return ECappingStatus.CAPPED_PER_COUNT;
            }
        }
        return ECappingStatus.NOT_CAPPED;
    }

    private static void incrementShowCounter(Context context, String str, String str2) {
        int i = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, constructSharedPrefsKey(str, IS_PACING_ENABLED, str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, constructSharedPrefsKey(str, TIME_OF_THE_PREVIOUS_SHOW, str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, constructSharedPrefsKey(str, IS_CAPPING_ENABLED, str2), false)) {
            IronSourceUtils.getIntFromSharedPrefs(context, constructSharedPrefsKey(str, MAX_NUMBER_OF_SHOWS, str2), 0);
            String constructSharedPrefsKey = constructSharedPrefsKey(str, CURRENT_NUMBER_OF_SHOWS, str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, constructSharedPrefsKey, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, constructSharedPrefsKey(str, CAPPING_TYPE, str2), PlacementCappingType.PER_DAY.toString());
                PlacementCappingType placementCappingType = null;
                PlacementCappingType[] values = PlacementCappingType.values();
                int length = values.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    PlacementCappingType placementCappingType2 = values[i];
                    if (placementCappingType2.value.equals(stringFromSharedPrefs)) {
                        placementCappingType = placementCappingType2;
                        break;
                    }
                    i++;
                }
                IronSourceUtils.saveLongToSharedPrefs(context, constructSharedPrefsKey(str, CAPPING_TIME_THRESHOLD, str2), initTimeThreshold(placementCappingType));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, constructSharedPrefsKey, intFromSharedPrefs + 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.ironsource.mediationsdk.utils.CappingManager$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$mediationsdk$model$PlacementCappingType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.ironsource.mediationsdk.model.PlacementCappingType[] r0 = com.ironsource.mediationsdk.model.PlacementCappingType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ironsource.mediationsdk.utils.CappingManager.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$model$PlacementCappingType = r0
                com.ironsource.mediationsdk.model.PlacementCappingType r1 = com.ironsource.mediationsdk.model.PlacementCappingType.PER_DAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.ironsource.mediationsdk.utils.CappingManager.AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$model$PlacementCappingType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.model.PlacementCappingType r1 = com.ironsource.mediationsdk.model.PlacementCappingType.PER_HOUR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.CappingManager.AnonymousClass1.<clinit>():void");
        }
    }

    private static long initTimeThreshold(PlacementCappingType placementCappingType) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i = AnonymousClass1.$SwitchMap$com$ironsource$mediationsdk$model$PlacementCappingType[placementCappingType.ordinal()];
        if (i == 1) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(11, 0);
            instance.add(6, 1);
        } else if (i == 2) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.add(11, 1);
        }
        return instance.getTimeInMillis();
    }

    private static void addCappingInfo(Context context, String str, String str2, PlacementAvailabilitySettings placementAvailabilitySettings) {
        boolean isDeliveryEnabled = placementAvailabilitySettings.isDeliveryEnabled();
        IronSourceUtils.saveBooleanToSharedPrefs(context, constructSharedPrefsKey(str, IS_DELIVERY_ENABLED, str2), isDeliveryEnabled);
        if (isDeliveryEnabled) {
            boolean isCappingEnabled = placementAvailabilitySettings.isCappingEnabled();
            IronSourceUtils.saveBooleanToSharedPrefs(context, constructSharedPrefsKey(str, IS_CAPPING_ENABLED, str2), isCappingEnabled);
            if (isCappingEnabled) {
                IronSourceUtils.saveIntToSharedPrefs(context, constructSharedPrefsKey(str, MAX_NUMBER_OF_SHOWS, str2), placementAvailabilitySettings.getCappingValue());
                IronSourceUtils.saveStringToSharedPrefs(context, constructSharedPrefsKey(str, CAPPING_TYPE, str2), placementAvailabilitySettings.getCappingType().toString());
            }
            boolean isPacingEnabled = placementAvailabilitySettings.isPacingEnabled();
            IronSourceUtils.saveBooleanToSharedPrefs(context, constructSharedPrefsKey(str, IS_PACING_ENABLED, str2), isPacingEnabled);
            if (isPacingEnabled) {
                IronSourceUtils.saveIntToSharedPrefs(context, constructSharedPrefsKey(str, SECONDS_BETWEEN_SHOWS, str2), placementAvailabilitySettings.getPacingValue());
            }
        }
    }
}
