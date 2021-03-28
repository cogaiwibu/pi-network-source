package com.tapjoy.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

public final class bh implements bl {
    private final StringWriter a;
    private final bt b;

    public bh() {
        StringWriter stringWriter = new StringWriter();
        this.a = stringWriter;
        this.b = new bt(stringWriter);
    }

    public final String toString() {
        try {
            this.b.a.flush();
            return this.a.toString();
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    @Override // com.tapjoy.internal.bl
    public final void a(Writer writer) {
        try {
            this.b.a.flush();
            writer.write(this.a.toString());
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a() {
        try {
            this.b.a();
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh b() {
        try {
            this.b.b();
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh c() {
        try {
            this.b.c();
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh d() {
        try {
            this.b.d();
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a(String str) {
        try {
            this.b.a(str);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a(bl blVar) {
        try {
            this.b.a(blVar);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh b(String str) {
        try {
            this.b.b(str);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a(long j) {
        try {
            this.b.a(j);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a(Number number) {
        try {
            this.b.a(number);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    private bh b(Object obj) {
        try {
            this.b.a(obj);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a(Collection collection) {
        try {
            this.b.a(collection);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public final bh a(Map map) {
        try {
            this.b.a(map);
            return this;
        } catch (IOException e) {
            throw jr.a(e);
        }
    }

    public static String a(Object obj) {
        return new bh().b(obj).toString();
    }
}
