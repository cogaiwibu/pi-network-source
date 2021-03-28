package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashSet;

public class FacebookSignatureValidator {
    private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
    private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
    private static final String FBL2_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
    private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
    private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
    private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
    private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
    private static final HashSet<String> validAppSignatureHashes = buildAppSignatureHashes();

    private static HashSet<String> buildAppSignatureHashes() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(FBR_HASH);
        hashSet.add(FBR2_HASH);
        hashSet.add(FBI_HASH);
        hashSet.add(FBL_HASH);
        hashSet.add(FBL2_HASH);
        hashSet.add(MSR_HASH);
        hashSet.add(FBF_HASH);
        return hashSet;
    }

    public static boolean validateSignature(Context context, String str) {
        String str2 = Build.BRAND;
        int i = context.getApplicationInfo().flags;
        if (str2.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && (i & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                for (Signature signature : packageInfo.signatures) {
                    if (!validAppSignatureHashes.contains(Utility.sha1hash(signature.toByteArray()))) {
                        return false;
                    }
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
