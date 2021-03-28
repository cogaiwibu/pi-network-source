package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007\u001a\u000e\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t\u001a\u000e\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b\u001a\u000e\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r\u001a\u000e\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f\u001a\u000e\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, k = 2, mv = {1, 4, 0})
/* compiled from: ArrayIterators.kt */
public final class ArrayIteratorsKt {
    public static final ByteIterator iterator(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "array");
        return new ArrayByteIterator(bArr);
    }

    public static final CharIterator iterator(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        return new ArrayCharIterator(cArr);
    }

    public static final ShortIterator iterator(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        return new ArrayShortIterator(sArr);
    }

    public static final IntIterator iterator(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "array");
        return new ArrayIntIterator(iArr);
    }

    public static final LongIterator iterator(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "array");
        return new ArrayLongIterator(jArr);
    }

    public static final FloatIterator iterator(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        return new ArrayFloatIterator(fArr);
    }

    public static final DoubleIterator iterator(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "array");
        return new ArrayDoubleIterator(dArr);
    }

    public static final BooleanIterator iterator(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "array");
        return new ArrayBooleanIterator(zArr);
    }
}
