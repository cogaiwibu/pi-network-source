package com.bytedance.sdk.openadsdk.core.c;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AdInfo */
public class a {
    private String a;
    private int b;
    private String c;
    private List<g> d = new ArrayList();
    private String e;
    private long f;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public List<g> c() {
        return this.d;
    }

    public void a(g gVar) {
        this.d.add(gVar);
    }

    public void c(String str) {
        this.e = str;
    }

    public void a(long j) {
        this.f = j;
    }
}
