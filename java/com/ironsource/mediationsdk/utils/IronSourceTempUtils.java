package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.Tester;

public class IronSourceTempUtils {
    public static String testKotlin() {
        try {
            return new Tester().test();
        } catch (Throwable unused) {
            return ",kiang";
        }
    }

    public static boolean isKotlinLibraryExist() {
        try {
            new Tester().test();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
