package com.facebook.common.internal;

public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier<Boolean>() {
        /* class com.facebook.common.internal.Suppliers.AnonymousClass3 */

        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return false;
        }
    };
    public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier<Boolean>() {
        /* class com.facebook.common.internal.Suppliers.AnonymousClass2 */

        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return true;
        }
    };

    public static <T> Supplier<T> of(final T t) {
        return new Supplier<T>() {
            /* class com.facebook.common.internal.Suppliers.AnonymousClass1 */

            @Override // com.facebook.common.internal.Supplier
            public T get() {
                return (T) t;
            }
        };
    }
}
