package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"kotlin/collections/AbstractMap$values$1", "Lkotlin/collections/AbstractCollection;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: AbstractMap.kt */
public final class AbstractMap$values$1 extends AbstractCollection<V> {
    final /* synthetic */ AbstractMap this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    AbstractMap$values$1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override // kotlin.collections.AbstractCollection
    public boolean contains(Object obj) {
        return this.this$0.containsValue(obj);
    }

    @Override // java.util.Collection, kotlin.collections.AbstractCollection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new AbstractMap$values$1$iterator$1(this.this$0.entrySet().iterator());
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.this$0.size();
    }
}
