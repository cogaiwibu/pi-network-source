package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: _Collections.kt */
public final class CollectionsKt___CollectionsKt$groupingBy$1 implements Grouping<T, K> {
    final /* synthetic */ Function1 $keySelector;
    final /* synthetic */ Iterable $this_groupingBy;

    public CollectionsKt___CollectionsKt$groupingBy$1(Iterable<? extends T> iterable, Function1 function1) {
        this.$this_groupingBy = iterable;
        this.$keySelector = function1;
    }

    @Override // kotlin.collections.Grouping
    public Iterator<T> sourceIterator() {
        return this.$this_groupingBy.iterator();
    }

    @Override // kotlin.collections.Grouping
    public K keyOf(T t) {
        return (K) this.$keySelector.invoke(t);
    }
}
