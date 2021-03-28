package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, d2 = {"Lkotlin/collections/UShortIterator;", "", "Lkotlin/UShort;", "()V", "next", "next-Mh2AYeg", "()S", "nextUShort", "nextUShort-Mh2AYeg", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: UIterators.kt */
public abstract class UShortIterator implements Iterator<UShort>, KMappedMarker {
    /* renamed from: nextUShort-Mh2AYeg  reason: not valid java name */
    public abstract short m438nextUShortMh2AYeg();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UShort next() {
        return UShort.m252boximpl(m437nextMh2AYeg());
    }

    /* renamed from: next-Mh2AYeg  reason: not valid java name */
    public final short m437nextMh2AYeg() {
        return m438nextUShortMh2AYeg();
    }
}
