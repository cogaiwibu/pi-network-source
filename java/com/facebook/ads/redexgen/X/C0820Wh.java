package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.Repairable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Wh  reason: case insensitive filesystem */
public class C0820Wh extends AnonymousClass8H {
    public static String[] A03;
    public WeakHashMap<Repairable, Boolean> A00 = new WeakHashMap<>();
    public final WeakReference<Activity> A01;
    public final AtomicReference<AnonymousClass0S> A02 = new AtomicReference<>();

    static {
        A01();
    }

    public static void A01() {
        A03 = new String[]{"X2XwTp9cKPrsKt8nnsNrr4kzY8H6fo9U", "SYDx4pa2oLtOnCxt4l9slcAsJVX17", "Ktbncp6BUHUyG8VpVa87zDZ4pVgXb", "697llskWaiD0", "zjkPaZGeICZRQbBHOdPJm8zqRs5ofq42", "OjtN7hHvLZrci2lMJuqCcc7IsxYWRGMj", "Pfr7ktMWLkOUKtldLLax33ooDo", "AIe8uS1x9EYXvM4HhYe86uhhSayJeZWe"};
    }

    public C0820Wh(Activity activity, AnonymousClass8J r3, AnonymousClass0S r4) {
        super(activity.getApplicationContext(), r3);
        this.A02.set(r4);
        this.A01 = new WeakReference<>(activity);
    }

    public C0820Wh(Context context, AnonymousClass8J r4, AnonymousClass0S r5) {
        super(context.getApplicationContext(), r4);
        this.A02.set(r5);
        Activity A002 = A00(context);
        if (A002 != null) {
            this.A01 = new WeakReference<>(A002);
        } else {
            this.A01 = new WeakReference<>(null);
        }
    }

    @Nullable
    public static Activity A00(Context context) {
        while (true) {
            boolean z = context instanceof ContextWrapper;
            if (A03[3].length() != 12) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "yJQbBA22nGzLcakEAa6nG1va8g";
            strArr[6] = "yJQbBA22nGzLcakEAa6nG1va8g";
            if (!z) {
                return null;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if ((context instanceof C0820Wh) && ((C0820Wh) context).A09() != null) {
                return ((C0820Wh) context).A09();
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    @Nullable
    public final Activity A09() {
        return this.A01.get();
    }

    public AnonymousClass0S A0A() {
        AnonymousClass0S r0 = this.A02.get();
        if (r0 == null) {
            return new R4();
        }
        return r0;
    }

    public final void A0B(AnonymousClass0S r2) {
        this.A02.set(r2);
    }

    public final void A0C(Repairable repairable) {
        this.A00.put(repairable, true);
    }

    public final void A0D(C0820Wh wh) {
        wh.A00.putAll(this.A00);
        this.A00 = wh.A00;
    }

    public final void A0E(Throwable th) {
        for (Map.Entry<Repairable, Boolean> entry : this.A00.entrySet()) {
            if (A03[3].length() != 12) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[7] = "uNK1zxgBt2FFcnYPdsvApaChXeSIkfOy";
            strArr[7] = "uNK1zxgBt2FFcnYPdsvApaChXeSIkfOy";
            entry.getKey().repair(th);
        }
    }
}
