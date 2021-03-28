package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\n¨\u0006\u0006"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: Size.kt */
public final class SizeKt {
    public static final int component1(Size size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$component1");
        return size.getWidth();
    }

    public static final int component2(Size size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$component2");
        return size.getHeight();
    }

    public static final float component1(SizeF sizeF) {
        Intrinsics.checkParameterIsNotNull(sizeF, "$this$component1");
        return sizeF.getWidth();
    }

    public static final float component2(SizeF sizeF) {
        Intrinsics.checkParameterIsNotNull(sizeF, "$this$component2");
        return sizeF.getHeight();
    }
}
