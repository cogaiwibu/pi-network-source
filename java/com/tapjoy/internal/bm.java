package com.tapjoy.internal;

import java.io.Writer;

public final class bm implements bl {
    public final String a;

    public bm(String str) {
        this.a = str;
    }

    @Override // com.tapjoy.internal.bl
    public final void a(Writer writer) {
        writer.write(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bm) {
            return this.a.equals(((bm) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
