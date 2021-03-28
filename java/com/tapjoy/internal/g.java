package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public final class g extends at implements ax, Closeable {
    private SQLiteDatabase a;
    private final bd b;
    private int c;

    public g(File file, bd bdVar) {
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        this.a = openOrCreateDatabase;
        this.b = bdVar;
        if (openOrCreateDatabase.getVersion() != 1) {
            this.a.beginTransaction();
            try {
                this.a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
                this.a.setVersion(1);
                this.a.setTransactionSuccessful();
            } finally {
                this.a.endTransaction();
            }
        }
        this.c = a();
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
            this.a = null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    private int a() {
        Cursor cursor = 0;
        try {
            cursor = this.a.rawQuery("SELECT COUNT(1) FROM List", cursor);
            if (cursor.moveToNext()) {
                return cursor.getInt(0);
            }
            a(cursor);
            return 0;
        } finally {
            a((Cursor) cursor);
        }
    }

    public final int size() {
        return this.c;
    }

    public final void clear() {
        this.a.delete("List", "1", null);
        this.c = 0;
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        jp.a(obj);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.b.a(byteArrayOutputStream, obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            jz.a(byteArrayOutputStream);
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", byteArray);
            if (this.a.insert("List", null, contentValues) == -1) {
                return false;
            }
            this.c++;
            return true;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (Throwable th) {
            jz.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // java.util.Queue
    public final Object poll() {
        if (this.c <= 0) {
            return null;
        }
        Object peek = peek();
        b(1);
        return peek;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (this.c > 0) {
            return a(0);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String[], android.database.Cursor] */
    @Override // com.tapjoy.internal.ax
    public final Object a(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException();
        }
        Cursor cursor = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.a;
            cursor = sQLiteDatabase.rawQuery("SELECT value FROM List ORDER BY rowid LIMIT " + i + ",1", cursor);
            if (cursor.moveToNext()) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(0));
                try {
                    Object b2 = this.b.b(byteArrayInputStream);
                    jz.a(byteArrayInputStream);
                    return b2;
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    jz.a(byteArrayInputStream);
                    throw th;
                }
            } else {
                throw new NoSuchElementException();
            }
        } finally {
            a((Cursor) cursor);
        }
    }

    @Override // com.tapjoy.internal.ax
    public final void b(int i) {
        int i2;
        Throwable th;
        if (i <= 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException();
        } else if (i == i2) {
            clear();
        } else {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.a;
                StringBuilder sb = new StringBuilder("SELECT rowid FROM List ORDER BY rowid LIMIT ");
                sb.append(i - 1);
                sb.append(",1");
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                try {
                    if (rawQuery.moveToNext()) {
                        long j = rawQuery.getLong(0);
                        rawQuery.close();
                        SQLiteDatabase sQLiteDatabase2 = this.a;
                        int delete = sQLiteDatabase2.delete("List", "rowid <= " + j, null);
                        this.c = this.c - delete;
                        if (delete == i) {
                            a((Cursor) null);
                            return;
                        }
                        throw new IllegalStateException("Try to delete " + i + ", but deleted " + delete);
                    }
                    throw new IllegalStateException();
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    a(cursor);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a(cursor);
                throw th;
            }
        }
    }

    private static Cursor a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        cursor.close();
        return null;
    }
}
