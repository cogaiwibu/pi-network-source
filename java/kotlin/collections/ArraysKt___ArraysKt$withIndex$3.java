package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\n\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: _Arrays.kt */
final class ArraysKt___ArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends Short>> {
    final /* synthetic */ short[] $this_withIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$3(short[] sArr) {
        super(0);
        this.$this_withIndex = sArr;
    }

    /* Return type fixed from 'java.util.Iterator<java.lang.Short>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Iterator<? extends Short> invoke() {
        return ArrayIteratorsKt.iterator(this.$this_withIndex);
    }
}
