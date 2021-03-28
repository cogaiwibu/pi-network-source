package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionMapper {

    public interface Collection<T> {
        Object get(T t);

        Iterator<T> keyIterator();

        void set(T t, Object obj, OnErrorListener onErrorListener);
    }

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    public interface OnMapValueCompleteListener extends OnErrorListener {
        void onComplete(Object obj);
    }

    public interface OnMapperCompleteListener extends OnErrorListener {
        void onComplete();
    }

    public interface ValueMapper {
        void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.facebook.internal.CollectionMapper$Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void iterate(final Collection<T> collection, ValueMapper valueMapper, final OnMapperCompleteListener onMapperCompleteListener) {
        final Mutable mutable = new Mutable(false);
        final Mutable mutable2 = new Mutable(1);
        final AnonymousClass1 r3 = new OnMapperCompleteListener() {
            /* class com.facebook.internal.CollectionMapper.AnonymousClass1 */

            @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
            public void onComplete() {
                if (!mutable.value.booleanValue()) {
                    Mutable mutable = mutable2;
                    T t = (T) Integer.valueOf(mutable.value.intValue() - 1);
                    mutable.value = t;
                    if (t.intValue() == 0) {
                        onMapperCompleteListener.onComplete();
                    }
                }
            }

            @Override // com.facebook.internal.CollectionMapper.OnErrorListener
            public void onError(FacebookException facebookException) {
                if (!mutable.value.booleanValue()) {
                    mutable.value = (T) true;
                    onMapperCompleteListener.onError(facebookException);
                }
            }
        };
        Iterator keyIterator = collection.keyIterator();
        LinkedList linkedList = new LinkedList();
        while (keyIterator.hasNext()) {
            linkedList.add(keyIterator.next());
        }
        for (final Object obj : linkedList) {
            Object obj2 = collection.get(obj);
            AnonymousClass2 r5 = new OnMapValueCompleteListener() {
                /* class com.facebook.internal.CollectionMapper.AnonymousClass2 */

                @Override // com.facebook.internal.CollectionMapper.OnMapValueCompleteListener
                public void onComplete(Object obj) {
                    collection.set(obj, obj, r3);
                    r3.onComplete();
                }

                @Override // com.facebook.internal.CollectionMapper.OnErrorListener
                public void onError(FacebookException facebookException) {
                    r3.onError(facebookException);
                }
            };
            T t = mutable2.value;
            mutable2.value = (T) Integer.valueOf(mutable2.value.intValue() + 1);
            valueMapper.mapValue(obj2, r5);
        }
        r3.onComplete();
    }

    private CollectionMapper() {
    }
}
