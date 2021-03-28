package androidx.core.util;

import android.util.SparseBooleanArray;
import com.ironsource.sdk.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006H\b\u001aE\u0010\u000b\u001a\u00020\f*\u00020\u000226\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f0\u000eH\b\u001a\u001d\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\b\u001a#\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\b\u001a\r\u0010\u0015\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\b\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0002\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u001b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002\u001a\u001a\u0010\u001c\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006\u001a\u001d\u0010\u001d\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\n\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006 "}, d2 = {"size", "", "Landroid/util/SparseBooleanArray;", "getSize", "(Landroid/util/SparseBooleanArray;)I", "contains", "", Constants.ParametersKeys.KEY, "containsKey", "containsValue", "value", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/BooleanIterator;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: SparseBooleanArray.kt */
public final class SparseBooleanArrayKt {
    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$size");
        return sparseBooleanArray.size();
    }

    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$contains");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$set");
        sparseBooleanArray.put(i, z);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$containsKey");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$containsValue");
        return sparseBooleanArray.indexOfValue(z) != -1;
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$getOrDefault");
        return sparseBooleanArray.get(i, z);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        return indexOfKey != -1 ? sparseBooleanArray.valueAt(indexOfKey) : function0.invoke().booleanValue();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$isEmpty");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$isNotEmpty");
        return sparseBooleanArray.size() != 0;
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$remove");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        if (indexOfKey == -1 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
        }
    }

    public static final IntIterator keyIterator(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$keyIterator");
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    public static final BooleanIterator valueIterator(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$valueIterator");
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        for (int i = 0; i < size; i++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
        }
    }
}
