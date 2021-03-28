package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public class gg extends gf {
    private final File b;
    private final gy c;
    private volatile SQLiteDatabase d;
    private long e;
    private long f;
    private long g;

    public gg(File file, gy gyVar) {
        this.b = file;
        this.c = gyVar;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (this.d != null) {
            jz.a(this.d);
            this.d = null;
        }
        super.finalize();
    }

    /* access modifiers changed from: protected */
    /* JADX INFO: finally extract failed */
    @Override // com.tapjoy.internal.gf
    public void a(long j) {
        if (this.d == null) {
            this.d = SQLiteDatabase.openOrCreateDatabase(this.b, (SQLiteDatabase.CursorFactory) null);
            int version = this.d.getVersion();
            if (version == 0) {
                this.d.beginTransaction();
                try {
                    this.d.execSQL("CREATE TABLE IF NOT EXISTS UsageStats(name TEXT,dimensions TEXT,count INTEGER,first_time INTEGER,last_time INTEGER,PRIMARY KEY(name, dimensions))");
                    this.d.execSQL("CREATE TABLE IF NOT EXISTS UsageStatValues(stat_id LONG,name TEXT,count INTEGER,avg REAL,max INTEGER,PRIMARY KEY(stat_id, name))");
                    this.d.setVersion(1);
                    this.d.setTransactionSuccessful();
                } finally {
                    this.d.endTransaction();
                }
            } else if (version != 1) {
                throw new SQLException("Unknown database version: " + version);
            }
            Cursor rawQuery = this.d.rawQuery("SELECT MIN(first_time), MAX(last_time) FROM UsageStats", null);
            try {
                if (rawQuery.moveToNext()) {
                    this.f = rawQuery.getLong(0);
                    this.g = rawQuery.getLong(1);
                }
                rawQuery.close();
                long j2 = this.f;
                if (j2 > 0 && j2 + 86400000 <= j) {
                    b();
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tapjoy.internal.gf
    public void a() {
        if (this.d != null) {
            jz.a(this.d);
            this.d = null;
        }
        this.b.delete();
        this.g = 0;
        this.f = 0;
    }

    /* access modifiers changed from: protected */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0129 */
    /* JADX DEBUG: Multi-variable search result rejected for r9v7, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r9v11, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r9v12, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r9v18, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r9v19, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // com.tapjoy.internal.gf
    public void a(long j, String str, @Nullable String str2, @Nullable Map map) {
        Cursor cursor;
        Throwable th;
        String str3;
        long j2;
        Throwable th2;
        long j3;
        String str4;
        String str5;
        if (this.d != null) {
            long j4 = this.e;
            if (j4 == 0) {
                this.g = j;
                this.e = j;
            } else if (j < j4 || j >= j4 + 86400000) {
                if (j >= this.e || this.g - j >= 86400000) {
                    b();
                    this.g = j;
                    this.e = j;
                } else {
                    this.e = j;
                }
            } else if (j > this.g) {
                this.g = j;
            }
            String str6 = str2 == null ? "" : str2;
            char c2 = 0;
            char c3 = 1;
            Cursor rawQuery = this.d.rawQuery("SELECT ROWID,count,first_time,last_time FROM UsageStats WHERE name = ? AND dimensions = ?", new String[]{str, str6});
            try {
                ContentValues contentValues = new ContentValues();
                boolean moveToNext = rawQuery.moveToNext();
                String str7 = "name";
                String str8 = NewHtcHomeBadger.COUNT;
                if (moveToNext) {
                    long j5 = rawQuery.getLong(0);
                    int i = rawQuery.getInt(1);
                    long j6 = rawQuery.getLong(2);
                    long j7 = rawQuery.getLong(3);
                    contentValues.put(str8, Integer.valueOf(i + 1));
                    if (j < j6) {
                        contentValues.put("first_time", Long.valueOf(j));
                    }
                    if (j > j7) {
                        contentValues.put("last_time", Long.valueOf(j));
                    }
                    SQLiteDatabase sQLiteDatabase = this.d;
                    sQLiteDatabase.update("UsageStats", contentValues, "ROWID = " + j5, null);
                    str3 = "ROWID = ";
                    j2 = j5;
                } else {
                    str3 = "ROWID = ";
                    contentValues.put(str7, str);
                    contentValues.put(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS, str6);
                    contentValues.put(str8, (Integer) 1);
                    contentValues.put("first_time", Long.valueOf(j));
                    contentValues.put("last_time", Long.valueOf(j));
                    j2 = this.d.insert("UsageStats", null, contentValues);
                }
                if (map != null && !map.isEmpty()) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry.getValue() != null) {
                            String str9 = (String) entry.getKey();
                            long longValue = ((Long) entry.getValue()).longValue();
                            String[] strArr = new String[2];
                            strArr[c2] = Long.toString(j2);
                            strArr[c3] = str9;
                            String str10 = "SELECT ROWID, * FROM UsageStatValues WHERE stat_id = ? AND name = ?";
                            Cursor rawQuery2 = this.d.rawQuery(str10, strArr);
                            try {
                                if (rawQuery2.moveToNext()) {
                                    j3 = j2;
                                    long j8 = rawQuery2.getLong(0);
                                    int i2 = rawQuery2.getInt(3);
                                    double d2 = rawQuery2.getDouble(4);
                                    long j9 = rawQuery2.getLong(5);
                                    contentValues.clear();
                                    int i3 = i2 + 1;
                                    contentValues.put(str8, Integer.valueOf(i3));
                                    str10 = rawQuery;
                                    double d3 = (double) longValue;
                                    Double.isNaN(d3);
                                    double d4 = (double) i3;
                                    Double.isNaN(d4);
                                    try {
                                        contentValues.put("avg", Double.valueOf(d2 + ((d3 - d2) / d4)));
                                        if (longValue > j9) {
                                            contentValues.put("max", Long.valueOf(longValue));
                                        }
                                        SQLiteDatabase sQLiteDatabase2 = this.d;
                                        sQLiteDatabase2.update("UsageStatValues", contentValues, str3 + j8, null);
                                        str4 = str8;
                                        str5 = str7;
                                        str10 = str10;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        cursor = str10;
                                        cursor.close();
                                        throw th;
                                    }
                                } else {
                                    j3 = j2;
                                    str10 = rawQuery;
                                    contentValues.clear();
                                    contentValues.put("stat_id", Long.valueOf(j3));
                                    str5 = str7;
                                    contentValues.put(str5, str9);
                                    str4 = str8;
                                    contentValues.put(str4, (Integer) 1);
                                    contentValues.put("avg", Long.valueOf(longValue));
                                    contentValues.put("max", Long.valueOf(longValue));
                                    this.d.insert("UsageStatValues", null, contentValues);
                                }
                                rawQuery2.close();
                                it = it;
                                j2 = j3;
                                str7 = str5;
                                rawQuery = str10;
                                str8 = str4;
                                c2 = 0;
                            } catch (Throwable th4) {
                                th2 = th4;
                                rawQuery2.close();
                                throw th2;
                            }
                        } else {
                            str8 = str8;
                        }
                        c3 = 1;
                    }
                }
                rawQuery.close();
            } catch (Throwable th5) {
                th = th5;
                cursor = rawQuery;
                cursor.close();
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void b() {
        HashMap hashMap;
        Set set = gf.a;
        String str = null;
        Cursor rawQuery = this.d.rawQuery("SELECT ROWID, * FROM UsageStats ORDER BY ROWID ASC", null);
        try {
            Cursor rawQuery2 = this.d.rawQuery("SELECT * FROM UsageStatValues ORDER BY stat_id ASC", null);
            try {
                rawQuery2.moveToNext();
                while (rawQuery.moveToNext()) {
                    int i = 0;
                    long j = rawQuery.getLong(0);
                    int i2 = 1;
                    String string = rawQuery.getString(1);
                    String string2 = rawQuery.getString(2);
                    String str2 = string2.isEmpty() ? str : string2;
                    int i3 = rawQuery.getInt(3);
                    long j2 = rawQuery.getLong(4);
                    long j3 = rawQuery.getLong(5);
                    if (!rawQuery2.isAfterLast()) {
                        hashMap = null;
                        while (true) {
                            if (rawQuery2.getLong(i) != j) {
                                break;
                            }
                            if (hashMap == null) {
                                hashMap = new HashMap();
                            }
                            String string3 = rawQuery2.getString(i2);
                            long j4 = rawQuery2.getLong(3);
                            long j5 = rawQuery2.getLong(4);
                            hashMap.put(string3, Long.valueOf(j4));
                            hashMap.put(string3 + "_max", Long.valueOf(j5));
                            if (!rawQuery2.moveToNext()) {
                                break;
                            }
                            i = 0;
                            i2 = 1;
                        }
                    } else {
                        hashMap = null;
                    }
                    if (set != null) {
                        if (set.contains(string)) {
                            str = null;
                        }
                    }
                    this.c.a(string, str2, i3, j2, j3, hashMap);
                    str = null;
                }
                rawQuery2.close();
                rawQuery.close();
                this.d.execSQL("DELETE FROM UsageStats");
                this.d.execSQL("DELETE FROM UsageStatValues");
                this.g = 0;
                this.f = 0;
            } catch (Throwable th) {
                rawQuery2.close();
                throw th;
            }
        } catch (Throwable th2) {
            rawQuery.close();
            throw th2;
        }
    }
}
