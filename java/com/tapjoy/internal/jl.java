package com.tapjoy.internal;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

public final class jl {
    final String a;
    final CharSequence b;
    final CharSequence[] c;
    final boolean d;
    final Bundle e;
    final Set f;

    static RemoteInput[] a(jl[] jlVarArr) {
        if (jlVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[jlVarArr.length];
        for (int i = 0; i < jlVarArr.length; i++) {
            jl jlVar = jlVarArr[i];
            remoteInputArr[i] = new RemoteInput.Builder(jlVar.a).setLabel(jlVar.b).setChoices(jlVar.c).setAllowFreeFormInput(jlVar.d).addExtras(jlVar.e).build();
        }
        return remoteInputArr;
    }
}
