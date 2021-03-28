package com.bytedance.sdk.openadsdk.h.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.h.l;
import com.bytedance.sdk.openadsdk.h.r;

/* access modifiers changed from: package-private */
/* compiled from: DatabaseSourceInfoStorage */
public class a extends SQLiteOpenHelper implements c {
    private static final String[] a = {"_id", "url", "length", "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        l.a(context);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        l.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    @Override // com.bytedance.sdk.openadsdk.h.c.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.openadsdk.h.r a(java.lang.String r11) {
        /*
            r10 = this;
            com.bytedance.sdk.openadsdk.h.l.a(r11)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "SourceInfo"
            java.lang.String[] r3 = com.bytedance.sdk.openadsdk.h.c.a.a     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = "url=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ all -> 0x0031 }
            r6 = 0
            r5[r6] = r11     // Catch:{ all -> 0x0031 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0031 }
            if (r11 == 0) goto L_0x002b
            boolean r1 = r11.moveToFirst()     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x0024
            goto L_0x002b
        L_0x0024:
            com.bytedance.sdk.openadsdk.h.r r0 = r10.a(r11)     // Catch:{ all -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r0 = move-exception
            goto L_0x0035
        L_0x002b:
            if (r11 == 0) goto L_0x0030
            r11.close()
        L_0x0030:
            return r0
        L_0x0031:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0035:
            if (r11 == 0) goto L_0x003a
            r11.close()
        L_0x003a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.c.a.a(java.lang.String):com.bytedance.sdk.openadsdk.h.r");
    }

    @Override // com.bytedance.sdk.openadsdk.h.c.c
    public void a(String str, r rVar) {
        l.a(str, rVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(rVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    private r a(Cursor cursor) {
        return new r(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    private ContentValues a(r rVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", rVar.a);
        contentValues.put("length", Long.valueOf(rVar.b));
        contentValues.put("mime", rVar.c);
        return contentValues;
    }
}
