package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import com.onesignal.outcomes.OSOutcomeTableProvider;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class OneSignalDbHelper extends SQLiteOpenHelper implements OneSignalDb {
    private static final String COMMA_SEP = ",";
    private static final String DATABASE_NAME = "OneSignal.db";
    static final int DATABASE_VERSION = 8;
    private static final int DB_OPEN_RETRY_BACKOFF = 400;
    private static final int DB_OPEN_RETRY_MAX = 5;
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String INTEGER_PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
    private static final String INT_TYPE = " INTEGER";
    private static final Object LOCK = new Object();
    protected static final String SQL_CREATE_ENTRIES = "CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);";
    private static final String SQL_CREATE_IN_APP_MESSAGE_ENTRIES = "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);";
    protected static final String[] SQL_INDEX_ENTRIES = {OneSignalDbContract.NotificationTable.INDEX_CREATE_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_COLLAPSE_ID, OneSignalDbContract.NotificationTable.INDEX_CREATE_CREATED_TIME, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME};
    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private static OSLogger logger = new OSLogWrapper();
    private static OSOutcomeTableProvider outcomeTableProvider = new OSOutcomeTableProvider();
    private static OneSignalDbHelper sInstance;

    private static int getDbVersion() {
        return 8;
    }

    /* access modifiers changed from: package-private */
    public void setOutcomeTableProvider(OSOutcomeTableProvider oSOutcomeTableProvider) {
        outcomeTableProvider = oSOutcomeTableProvider;
    }

    OneSignalDbHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, getDbVersion());
    }

    public static OneSignalDbHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new OneSignalDbHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private SQLiteDatabase getSQLiteDatabase() {
        SQLiteDatabase writableDatabase;
        synchronized (LOCK) {
            try {
                writableDatabase = getWritableDatabase();
            } catch (SQLiteCantOpenDatabaseException e) {
                throw e;
            } catch (SQLiteDatabaseLockedException e2) {
                throw e2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return writableDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0014 A[Catch:{ SQLiteCantOpenDatabaseException -> 0x000e, SQLiteDatabaseLockedException -> 0x000c, all -> 0x000a }, LOOP:0: B:3:0x0004->B:15:0x0014, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x001b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.sqlite.SQLiteDatabase getSQLiteDatabaseWithRetries() {
        /*
            r4 = this;
            java.lang.Object r0 = com.onesignal.OneSignalDbHelper.LOCK
            monitor-enter(r0)
            r1 = 0
        L_0x0004:
            android.database.sqlite.SQLiteDatabase r1 = r4.getSQLiteDatabase()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x000e, SQLiteDatabaseLockedException -> 0x000c }
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r1
        L_0x000a:
            r1 = move-exception
            goto L_0x001c
        L_0x000c:
            r2 = move-exception
            goto L_0x000f
        L_0x000e:
            r2 = move-exception
        L_0x000f:
            int r1 = r1 + 1
            r3 = 5
            if (r1 >= r3) goto L_0x001b
            int r2 = r1 * 400
            long r2 = (long) r2     // Catch:{ all -> 0x000a }
            android.os.SystemClock.sleep(r2)     // Catch:{ all -> 0x000a }
            goto L_0x0004
        L_0x001b:
            throw r2     // Catch:{ all -> 0x000a }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            goto L_0x001f
        L_0x001e:
            throw r1
        L_0x001f:
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignalDbHelper.getSQLiteDatabaseWithRetries():android.database.sqlite.SQLiteDatabase");
    }

    @Override // com.onesignal.OneSignalDb
    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor query;
        synchronized (LOCK) {
            query = getSQLiteDatabaseWithRetries().query(str, strArr, str2, strArr2, str3, str4, str5);
        }
        return query;
    }

    @Override // com.onesignal.OneSignalDb
    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor query;
        synchronized (LOCK) {
            query = getSQLiteDatabaseWithRetries().query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        }
        return query;
    }

    @Override // com.onesignal.OneSignalDb
    public void insert(String str, String str2, ContentValues contentValues) {
        OSLogger oSLogger;
        String str3;
        OSLogger oSLogger2;
        String str4;
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                sQLiteDatabaseWithRetries.beginTransaction();
                sQLiteDatabaseWithRetries.insert(str, str2, contentValues);
                sQLiteDatabaseWithRetries.setTransactionSuccessful();
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e) {
                        e = e;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e2) {
                        e = e2;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (SQLiteException e3) {
                OSLogger oSLogger3 = logger;
                oSLogger3.error("Error inserting on table: " + str + " with nullColumnHack: " + str2 + " and values: " + contentValues, e3);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e4) {
                        e = e4;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e5) {
                        e = e5;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (IllegalStateException e6) {
                OSLogger oSLogger4 = logger;
                oSLogger4.error("Error under inserting transaction under table: " + str + " with nullColumnHack: " + str2 + " and values: " + contentValues, e6);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e7) {
                        e = e7;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e8) {
                        e = e8;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        logger.error("Error closing transaction! ", e9);
                    } catch (SQLiteException e10) {
                        logger.error("Error closing transaction! ", e10);
                    }
                }
                throw th;
            }
        }
        oSLogger.error(str3, e);
    }

    @Override // com.onesignal.OneSignalDb
    public void insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        OSLogger oSLogger;
        String str3;
        OSLogger oSLogger2;
        String str4;
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                sQLiteDatabaseWithRetries.beginTransaction();
                sQLiteDatabaseWithRetries.insertOrThrow(str, str2, contentValues);
                sQLiteDatabaseWithRetries.setTransactionSuccessful();
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e) {
                        e = e;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e2) {
                        e = e2;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (SQLiteException e3) {
                OSLogger oSLogger3 = logger;
                oSLogger3.error("Error inserting or throw on table: " + str + " with nullColumnHack: " + str2 + " and values: " + contentValues, e3);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e4) {
                        e = e4;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e5) {
                        e = e5;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (IllegalStateException e6) {
                OSLogger oSLogger4 = logger;
                oSLogger4.error("Error under inserting or throw transaction under table: " + str + " with nullColumnHack: " + str2 + " and values: " + contentValues, e6);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e7) {
                        e = e7;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e8) {
                        e = e8;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        logger.error("Error closing transaction! ", e9);
                    } catch (SQLiteException e10) {
                        logger.error("Error closing transaction! ", e10);
                    }
                }
                throw th;
            }
        }
        oSLogger.error(str3, e);
    }

    @Override // com.onesignal.OneSignalDb
    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        OSLogger oSLogger;
        String str3;
        OSLogger oSLogger2;
        String str4;
        int i = 0;
        if (contentValues == null || contentValues.toString().isEmpty()) {
            return 0;
        }
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                sQLiteDatabaseWithRetries.beginTransaction();
                i = sQLiteDatabaseWithRetries.update(str, contentValues, str2, strArr);
                sQLiteDatabaseWithRetries.setTransactionSuccessful();
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e) {
                        e = e;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e2) {
                        e = e2;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                        return i;
                    }
                }
            } catch (SQLiteException e3) {
                OSLogger oSLogger3 = logger;
                oSLogger3.error("Error updating on table: " + str + " with whereClause: " + str2 + " and whereArgs: " + strArr, e3);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e4) {
                        e = e4;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e5) {
                        e = e5;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                        return i;
                    }
                }
            } catch (IllegalStateException e6) {
                OSLogger oSLogger4 = logger;
                oSLogger4.error("Error under update transaction under table: " + str + " with whereClause: " + str2 + " and whereArgs: " + strArr, e6);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e7) {
                        e = e7;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e8) {
                        e = e8;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                        return i;
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        logger.error("Error closing transaction! ", e9);
                    } catch (SQLiteException e10) {
                        logger.error("Error closing transaction! ", e10);
                    }
                }
                throw th;
            }
        }
        return i;
        oSLogger.error(str3, e);
        return i;
    }

    @Override // com.onesignal.OneSignalDb
    public void delete(String str, String str2, String[] strArr) {
        OSLogger oSLogger;
        String str3;
        OSLogger oSLogger2;
        String str4;
        synchronized (LOCK) {
            SQLiteDatabase sQLiteDatabaseWithRetries = getSQLiteDatabaseWithRetries();
            try {
                sQLiteDatabaseWithRetries.beginTransaction();
                sQLiteDatabaseWithRetries.delete(str, str2, strArr);
                sQLiteDatabaseWithRetries.setTransactionSuccessful();
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e) {
                        e = e;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e2) {
                        e = e2;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (SQLiteException e3) {
                OSLogger oSLogger3 = logger;
                oSLogger3.error("Error deleting on table: " + str + " with whereClause: " + str2 + " and whereArgs: " + strArr, e3);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e4) {
                        e = e4;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e5) {
                        e = e5;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (IllegalStateException e6) {
                OSLogger oSLogger4 = logger;
                oSLogger4.error("Error under delete transaction under table: " + str + " with whereClause: " + str2 + " and whereArgs: " + strArr, e6);
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e7) {
                        e = e7;
                        oSLogger = logger;
                        str3 = "Error closing transaction! ";
                    } catch (SQLiteException e8) {
                        e = e8;
                        oSLogger2 = logger;
                        str4 = "Error closing transaction! ";
                        oSLogger2.error(str4, e);
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabaseWithRetries != null) {
                    try {
                        sQLiteDatabaseWithRetries.endTransaction();
                    } catch (IllegalStateException e9) {
                        logger.error("Error closing transaction! ", e9);
                    } catch (SQLiteException e10) {
                        logger.error("Error closing transaction! ", e10);
                    }
                }
                throw th;
            }
        }
        oSLogger.error(str3, e);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sQLiteDatabase.execSQL(OSOutcomeTableProvider.SQL_CREATE_OUTCOME_ENTRIES_V3);
        sQLiteDatabase.execSQL(OSOutcomeTableProvider.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V2);
        sQLiteDatabase.execSQL(SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
        for (String str : SQL_INDEX_ENTRIES) {
            sQLiteDatabase.execSQL(str);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.Log(log_level, "OneSignal Database onUpgrade from: " + i + " to: " + i2);
        try {
            internalOnUpgrade(sQLiteDatabase, i);
        } catch (SQLiteException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error in upgrade, migration may have already run! Skipping!", e);
        }
    }

    private synchronized void internalOnUpgrade(SQLiteDatabase sQLiteDatabase, int i) {
        if (i < 2) {
            try {
                upgradeToV2(sQLiteDatabase);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i < 3) {
            upgradeToV3(sQLiteDatabase);
        }
        if (i < 4) {
            upgradeToV4(sQLiteDatabase);
        }
        if (i < 5) {
            upgradeToV5(sQLiteDatabase);
        }
        if (i == 5) {
            upgradeFromV5ToV6(sQLiteDatabase);
        }
        if (i < 7) {
            upgradeToV7(sQLiteDatabase);
        }
        if (i < 8) {
            upgradeToV8(sQLiteDatabase);
        }
    }

    private static void upgradeToV2(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        safeExecSQL(sQLiteDatabase, OneSignalDbContract.NotificationTable.INDEX_CREATE_GROUP_ID);
    }

    private static void upgradeToV3(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        safeExecSQL(sQLiteDatabase, "UPDATE notification SET expire_time = created_time + 259200;");
        safeExecSQL(sQLiteDatabase, OneSignalDbContract.NotificationTable.INDEX_CREATE_EXPIRE_TIME);
    }

    private static void upgradeToV4(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, OSOutcomeTableProvider.SQL_CREATE_OUTCOME_ENTRIES_V1);
    }

    private static void upgradeToV5(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, OSOutcomeTableProvider.SQL_CREATE_UNIQUE_OUTCOME_ENTRIES_V1);
        upgradeFromV5ToV6(sQLiteDatabase);
    }

    private static void upgradeFromV5ToV6(SQLiteDatabase sQLiteDatabase) {
        outcomeTableProvider.upgradeOutcomeTableRevision1To2(sQLiteDatabase);
    }

    private static void upgradeToV7(SQLiteDatabase sQLiteDatabase) {
        safeExecSQL(sQLiteDatabase, SQL_CREATE_IN_APP_MESSAGE_ENTRIES);
    }

    private synchronized void upgradeToV8(SQLiteDatabase sQLiteDatabase) {
        outcomeTableProvider.upgradeOutcomeTableRevision2To3(sQLiteDatabase);
        outcomeTableProvider.upgradeCacheOutcomeTableRevision1To2(sQLiteDatabase);
    }

    private static void safeExecSQL(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: finally extract failed */
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.");
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        try {
            ArrayList<String> arrayList = new ArrayList(rawQuery.getCount());
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            for (String str : arrayList) {
                if (!str.startsWith("sqlite_")) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                }
            }
            rawQuery.close();
            onCreate(sQLiteDatabase);
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    static StringBuilder recentUninteractedWithNotificationsWhere() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder("created_time > " + (currentTimeMillis - 604800) + " AND " + "dismissed" + " = 0 AND " + OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED + " = 0 AND " + OneSignalDbContract.NotificationTable.COLUMN_NAME_IS_SUMMARY + " = 0");
        if (OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_RESTORE_TTL_FILTER, true)) {
            sb.append(" AND expire_time > " + currentTimeMillis);
        }
        return sb;
    }

    static void cleanOutcomeDatabaseTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete(OSOutcomeTableProvider.OUTCOME_EVENT_TABLE, null, null);
    }
}
