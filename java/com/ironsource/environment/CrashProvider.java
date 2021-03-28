package com.ironsource.environment;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class CrashProvider extends ContentProvider {
    String AUTHORITY;
    String CONTENT_ITEM_TYPE;
    String CONTENT_TYPE;
    Uri CONTENT_URI;
    final String TABLE = "REPORTS";
    final int TASKS_ITEM = 2;
    final int TASKS_LIST = 1;
    Context mCtx;
    DbHandler mDb;
    UriMatcher uriMatcher = new UriMatcher(-1);

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        this.mCtx = getContext();
        this.mDb = new DbHandler(this.mCtx);
        this.AUTHORITY = this.mCtx.getPackageName();
        this.CONTENT_URI = Uri.parse("content://" + this.AUTHORITY + "/" + "REPORTS");
        this.CONTENT_TYPE = "vnd.android.cursor.dir/CrashReporter.Reports";
        this.CONTENT_ITEM_TYPE = "vnd.android.cursor.item/CrashReporter/Reports";
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int match = this.uriMatcher.match(uri);
        if (match == 1) {
            return DbHandler.getExceptionsCursor();
        }
        if (match == 2) {
            return DbHandler.getExceptionCursorById(Integer.parseInt(uri.getLastPathSegment()));
        }
        throw new IllegalArgumentException("Invalid URI: " + uri);
    }

    public String getType(Uri uri) {
        int match = this.uriMatcher.match(uri);
        if (match == 1) {
            return this.CONTENT_TYPE;
        }
        if (match == 2) {
            return this.CONTENT_ITEM_TYPE;
        }
        throw new IllegalArgumentException("Invalid URI: " + uri);
    }
}
