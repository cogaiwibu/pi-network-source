package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;

public final class t implements bd {
    public static final t a = new t();

    @Override // com.tapjoy.internal.bf
    public final /* synthetic */ void a(OutputStream outputStream, Object obj) {
        if (!((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, outputStream)) {
            throw new RuntimeException();
        }
    }

    private t() {
    }

    /* renamed from: a */
    public final Bitmap b(final InputStream inputStream) {
        try {
            return (Bitmap) y.a(new bb() {
                /* class com.tapjoy.internal.t.AnonymousClass1 */

                @Override // java.util.concurrent.Callable, com.tapjoy.internal.bb
                public final /* synthetic */ Object call() {
                    InputStream inputStream = inputStream;
                    if (inputStream instanceof bc) {
                        return BitmapFactory.decodeStream(inputStream);
                    }
                    return BitmapFactory.decodeStream(new bc(inputStream));
                }
            });
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
