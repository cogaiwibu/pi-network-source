package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.NavigableSet;

/* renamed from: com.facebook.ads.redexgen.X.Hl  reason: case insensitive filesystem */
public interface AbstractC0445Hl {
    void A3Q(String str, C0457Hx hx) throws C0443Hj;

    void A44(File file) throws C0443Hj;

    long A5Z();

    long A5a(String str, long j, long j2);

    @NonNull
    NavigableSet<C0449Hp> A5b(String str);

    long A5m(String str);

    AbstractC0455Hv A5n(String str);

    void ACH(C0449Hp hp);

    void ACO(C0449Hp hp) throws C0443Hj;

    void ACu(String str, long j) throws C0443Hj;

    File ADJ(String str, long j, long j2) throws C0443Hj;

    C0449Hp ADL(String str, long j) throws InterruptedException, C0443Hj;

    @Nullable
    C0449Hp ADM(String str, long j) throws C0443Hj;
}
