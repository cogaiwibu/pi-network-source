package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zaj;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public abstract class zab {
    final zaa zamz;
    private int zana = 0;
    protected int zanb = 0;
    private boolean zanc = false;
    private boolean zand = true;
    private boolean zane = false;
    private boolean zanf = true;

    public zab(Uri uri, int i) {
        this.zamz = new zaa(uri);
        this.zanb = i;
    }

    /* access modifiers changed from: protected */
    public abstract void zaa(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: package-private */
    public final void zaa(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* access modifiers changed from: package-private */
    public final void zaa(Context context, zaj zaj) {
        if (this.zanf) {
            zaa(null, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zaa(Context context, zaj zaj, boolean z) {
        int i = this.zanb;
        zaa(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }

    /* access modifiers changed from: protected */
    public final boolean zaa(boolean z, boolean z2) {
        return this.zand && !z2 && !z;
    }
}
