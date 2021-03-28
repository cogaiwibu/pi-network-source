package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: _ArraysJvm.kt */
public final class ArraysKt___ArraysJvmKt$asList$3 extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ int[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$3(int[] iArr) {
        this.$this_asList = iArr;
    }

    @Override // kotlin.collections.AbstractCollection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return contains(((Number) obj).intValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return indexOf(((Number) obj).intValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return lastIndexOf(((Number) obj).intValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractCollection
    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(int i) {
        return ArraysKt.contains(this.$this_asList, i);
    }

    @Override // java.util.List, kotlin.collections.AbstractList
    public Integer get(int i) {
        return Integer.valueOf(this.$this_asList[i]);
    }

    public int indexOf(int i) {
        return ArraysKt.indexOf(this.$this_asList, i);
    }

    public int lastIndexOf(int i) {
        return ArraysKt.lastIndexOf(this.$this_asList, i);
    }
}
