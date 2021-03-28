package com.ironsource.environment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public DbHandler(Context context) {
        super(context, "reports", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS REPORTS(id INTEGER PRIMARY KEY AUTOINCREMENT , stack_trace TEXT NOT NULL, crash_date TEXT NOT NULL );");
    }

    public static void addReport(ExceptionLog exceptionLog) {
        SQLiteDatabase writableDatabase = new DbHandler(CrashReporter.getInstance().getContext()).getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            String stacktrace = exceptionLog.getStacktrace();
            String date = exceptionLog.getDate();
            contentValues.put("stack_trace", stacktrace);
            contentValues.put("crash_date", date);
            writableDatabase.insert("REPORTS", null, contentValues);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public static ExceptionLog getReportById(int i) {
        SQLiteDatabase readableDatabase = new DbHandler(CrashReporter.getInstance().getContext()).getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM REPORTSWHERE id= " + i + ";", null);
        int i2 = rawQuery.getInt(0);
        String string = rawQuery.getString(1);
        String string2 = rawQuery.getString(2);
        rawQuery.close();
        readableDatabase.close();
        return new ExceptionLog(i2, string, string2);
    }

    public static Cursor getExceptionCursorById(int i) {
        SQLiteDatabase readableDatabase = new DbHandler(CrashReporter.getInstance().getContext()).getReadableDatabase();
        return readableDatabase.rawQuery("SELECT * FROM REPORTSWHERE id= " + i + ";", null);
    }

    public static List<ExceptionLog> getAllReports() {
        DbHandler dbHandler = new DbHandler(CrashReporter.getInstance().getContext());
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = dbHandler.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM REPORTS ;", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(new ExceptionLog(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(2)));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        readableDatabase.close();
        return arrayList;
    }

    public static Cursor getExceptionsCursor() {
        DbHandler dbHandler = new DbHandler(CrashReporter.getInstance().getContext());
        new ArrayList();
        return dbHandler.getReadableDatabase().rawQuery("SELECT * FROM REPORTS;", null);
    }

    public static void deleteAllReports() {
        SQLiteDatabase writableDatabase = new DbHandler(CrashReporter.getInstance().getContext()).getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM REPORTS WHERE id >= 0;");
        writableDatabase.close();
    }
}
