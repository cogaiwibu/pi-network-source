package com.tapjoy.internal;

import java.io.IOException;
import java.io.Serializable;

public abstract class eh implements Serializable {
    transient int a = 0;
    protected transient int b = 0;
    private final transient ej c;
    private final transient iu d;

    protected eh(ej ejVar, iu iuVar) {
        if (ejVar == null) {
            throw new NullPointerException("adapter == null");
        } else if (iuVar != null) {
            this.c = ejVar;
            this.d = iuVar;
        } else {
            throw new NullPointerException("unknownFields == null");
        }
    }

    public final iu a() {
        iu iuVar = this.d;
        if (iuVar != null) {
            return iuVar;
        }
        return iu.b;
    }

    public String toString() {
        return ej.c(this);
    }

    public static abstract class a {
        ir a;
        el b;

        protected a() {
        }

        public final a a(iu iuVar) {
            if (iuVar.c() > 0) {
                if (this.b == null) {
                    ir irVar = new ir();
                    this.a = irVar;
                    this.b = new el(irVar);
                }
                try {
                    this.b.a(iuVar);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final a a(int i, eg egVar, Object obj) {
            if (this.b == null) {
                ir irVar = new ir();
                this.a = irVar;
                this.b = new el(irVar);
            }
            try {
                egVar.a().a(this.b, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final iu a() {
            ir irVar = this.a;
            return irVar != null ? new iu(irVar.clone().g()) : iu.b;
        }
    }
}
