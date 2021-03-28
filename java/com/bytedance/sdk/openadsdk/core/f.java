package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.f.g;
import com.bytedance.sdk.openadsdk.g.l;

/* access modifiers changed from: package-private */
/* compiled from: DBHelper */
public class f {
    private static final Object c = new Object();
    private c a;
    private Context b;

    f(Context context) {
        Context context2;
        if (context == null) {
            try {
                context2 = j.a();
            } catch (Throwable unused) {
                return;
            }
        } else {
            context2 = context.getApplicationContext();
        }
        this.b = context2;
        if (this.a == null) {
            this.a = new c();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Context c() {
        Context context = this.b;
        return context == null ? j.a() : context;
    }

    /* compiled from: DBHelper */
    public class c {
        private SQLiteDatabase b = null;

        public c() {
        }

        private synchronized void d() {
            try {
                synchronized (f.c) {
                    if (this.b == null || !this.b.isOpen()) {
                        SQLiteDatabase writableDatabase = new a(f.this.c()).getWritableDatabase();
                        this.b = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized void a(String str) throws SQLException {
            try {
                d();
                this.b.execSQL(str);
            } catch (Throwable th) {
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                d();
                cursor = this.b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (!e()) {
                    cursor = bVar;
                } else {
                    throw th;
                }
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                d();
                i = this.b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!e()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                d();
                j = this.b.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                if (!e()) {
                    j = -1;
                } else {
                    throw e;
                }
            }
            return j;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i;
            try {
                d();
                i = this.b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                if (!e()) {
                    i = 0;
                } else {
                    throw e;
                }
            }
            return i;
        }

        public synchronized void a() {
            d();
            if (this.b != null) {
                this.b.beginTransaction();
            }
        }

        public synchronized void b() {
            d();
            if (this.b != null) {
                this.b.setTransactionSuccessful();
            }
        }

        public synchronized void c() {
            d();
            if (this.b != null) {
                this.b.endTransaction();
            }
        }

        private synchronized boolean e() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = this.b;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: DBHelper */
    public class a extends SQLiteOpenHelper {
        final Context a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 4);
            this.a = context;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.a);
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            l.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.b.f.d());
            sQLiteDatabase.execSQL(g.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.b.b.a());
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                l.b("DBHelper", "onUpgrade....数据库版本升级.....");
                if (i == 1) {
                    l.b("DBHelper", "onUpgrade.....执行表创建.....");
                } else if (i == 2) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                } else if (i == 3) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.d.b.b.a());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public c a() {
        return this.a;
    }

    /* compiled from: DBHelper */
    private class b extends AbstractCursor {
        public String[] getColumnNames() {
            return new String[0];
        }

        public int getCount() {
            return 0;
        }

        public double getDouble(int i) {
            return 0.0d;
        }

        public float getFloat(int i) {
            return 0.0f;
        }

        public int getInt(int i) {
            return 0;
        }

        public long getLong(int i) {
            return 0;
        }

        public short getShort(int i) {
            return 0;
        }

        public String getString(int i) {
            return null;
        }

        public boolean isNull(int i) {
            return true;
        }

        private b() {
        }
    }
}
