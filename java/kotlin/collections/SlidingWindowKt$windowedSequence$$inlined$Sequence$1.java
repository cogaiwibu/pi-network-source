package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: Sequences.kt */
public final class SlidingWindowKt$windowedSequence$$inlined$Sequence$1 implements Sequence<List<? extends T>> {
    final /* synthetic */ boolean $partialWindows$inlined;
    final /* synthetic */ boolean $reuseBuffer$inlined;
    final /* synthetic */ int $size$inlined;
    final /* synthetic */ int $step$inlined;
    final /* synthetic */ Sequence $this_windowedSequence$inlined;

    public SlidingWindowKt$windowedSequence$$inlined$Sequence$1(Sequence sequence, int i, int i2, boolean z, boolean z2) {
        this.$this_windowedSequence$inlined = sequence;
        this.$size$inlined = i;
        this.$step$inlined = i2;
        this.$partialWindows$inlined = z;
        this.$reuseBuffer$inlined = z2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<List<? extends T>> iterator() {
        return SlidingWindowKt.windowedIterator(this.$this_windowedSequence$inlined.iterator(), this.$size$inlined, this.$step$inlined, this.$partialWindows$inlined, this.$reuseBuffer$inlined);
    }
}
