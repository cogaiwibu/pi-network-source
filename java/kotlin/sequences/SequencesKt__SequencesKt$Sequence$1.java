package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: Sequences.kt */
public final class SequencesKt__SequencesKt$Sequence$1 implements Sequence<T> {
    final /* synthetic */ Function0 $iterator;

    public SequencesKt__SequencesKt$Sequence$1(Function0 function0) {
        this.$iterator = function0;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return (Iterator) this.$iterator.invoke();
    }
}
