package com.ironsource.mediationsdk.utilities;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/ironsource/mediationsdk/utilities/IronSourcePreconditions;", "", "()V", "checkNotNull", "", "reference", "errorMessage", "", "shouldThrowException", "mediationsdk_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: IronSourcePreconditions.kt */
public final class IronSourcePreconditions {
    public static final IronSourcePreconditions INSTANCE = new IronSourcePreconditions();

    @JvmStatic
    public static final boolean checkNotNull(Object obj) {
        return checkNotNull$default(obj, null, false, 6, null);
    }

    @JvmStatic
    public static final boolean checkNotNull(Object obj, String str) {
        return checkNotNull$default(obj, str, false, 4, null);
    }

    private IronSourcePreconditions() {
    }

    public static /* synthetic */ boolean checkNotNull$default(Object obj, String str, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "reference is null";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return checkNotNull(obj, str, z);
    }

    @JvmStatic
    public static final boolean checkNotNull(Object obj, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "errorMessage");
        if (obj != null) {
            return true;
        }
        if (z) {
            throw new NullPointerException(str);
        } else if (!z) {
            IronLog.API.error(str);
            return false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
