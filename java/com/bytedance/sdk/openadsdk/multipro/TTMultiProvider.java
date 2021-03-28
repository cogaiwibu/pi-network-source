package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class TTMultiProvider extends ContentProvider {
    public boolean onCreate() {
        f.b(getContext()).a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return f.b(getContext()).a(uri, strArr, str, strArr2, str2);
    }

    public String getType(Uri uri) {
        return f.b(getContext()).a(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return f.b(getContext()).a(uri, contentValues);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return f.b(getContext()).a(uri, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return f.b(getContext()).a(uri, contentValues, str, strArr);
    }
}
