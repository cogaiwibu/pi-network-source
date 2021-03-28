package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;
import javax.annotation.Nullable;

public final class s extends ContentHandler {
    public static final s a = new s();

    @Override // java.net.ContentHandler
    @Nullable
    public final /* synthetic */ Object getContent(URLConnection uRLConnection) {
        return a(uRLConnection);
    }

    private s() {
    }

    @Nullable
    private static Bitmap a(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            return t.a.b(inputStream);
        } finally {
            inputStream.close();
        }
    }

    @Nullable
    public static Bitmap a(InputStream inputStream) {
        try {
            return t.a.b(inputStream);
        } finally {
            inputStream.close();
        }
    }
}
