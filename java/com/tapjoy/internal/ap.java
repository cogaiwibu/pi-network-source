package com.tapjoy.internal;

public final class ap {

    public static final class a implements as {
        private final aq a;

        public a(aq aqVar) {
            this.a = aqVar;
        }

        @Override // com.tapjoy.internal.an
        public final Object a(Object obj) {
            ao a2;
            Object a3;
            synchronized (this.a) {
                a2 = this.a.a(obj, false);
            }
            if (a2 == null) {
                return null;
            }
            synchronized (a2) {
                a3 = a2.a();
            }
            return a3;
        }

        @Override // com.tapjoy.internal.an
        public final void a(Object obj, Object obj2) {
            ao a2;
            synchronized (this.a) {
                a2 = this.a.a(obj, true);
            }
            synchronized (a2) {
                a2.a(obj2);
            }
        }
    }
}
