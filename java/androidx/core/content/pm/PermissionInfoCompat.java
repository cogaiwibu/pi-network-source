package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    public static int getProtection(PermissionInfo permissionInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return permissionInfo.getProtection();
        }
        return permissionInfo.protectionLevel & 15;
    }

    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return permissionInfo.getProtectionFlags();
        }
        return permissionInfo.protectionLevel & -16;
    }
}
