package com.ironsource.eventsmodule;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import com.facebook.common.statfs.StatFsHelper;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;

public class DataBaseEventsStorage extends SQLiteOpenHelper implements IEventsStorageHelper {
    private static final String COMMA_SEP = ",";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String TYPE_TEXT = " TEXT";
    private static DataBaseEventsStorage mInstance;
    private final int DB_OPEN_BACKOFF_TIME = StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
    private final int DB_RETRY_NUM = 4;
    private final String SQL_CREATE_ENTRIES = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";
    private final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS events";

    public DataBaseEventsStorage(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
    }

    public static synchronized DataBaseEventsStorage getInstance(Context context, String str, int i) {
        DataBaseEventsStorage dataBaseEventsStorage;
        synchronized (DataBaseEventsStorage.class) {
            if (mInstance == null) {
                mInstance = new DataBaseEventsStorage(context, str, i);
            }
            dataBaseEventsStorage = mInstance;
        }
        return dataBaseEventsStorage;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: android.database.sqlite.SQLiteDatabase */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2 */
    @Override // com.ironsource.eventsmodule.IEventsStorageHelper
    public synchronized void saveEvents(List<EventData> list, String str) {
        Throwable th;
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = 0;
                try {
                    SQLiteDatabase dataBaseWithRetries = getDataBaseWithRetries(true);
                    try {
                        for (EventData eventData : list) {
                            ContentValues contentValuesForEvent = getContentValuesForEvent(eventData, str);
                            if (!(dataBaseWithRetries == null || contentValuesForEvent == null)) {
                                dataBaseWithRetries.insert("events", sQLiteDatabase, contentValuesForEvent);
                            }
                        }
                        if (dataBaseWithRetries != null && dataBaseWithRetries.isOpen()) {
                            dataBaseWithRetries.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = dataBaseWithRetries;
                        try {
                            Log.e(IronSourceConstants.IRONSOURCE_CONFIG_NAME, "Exception while saving events: ", th);
                        } finally {
                            if (sQLiteDatabase != 0 && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    Log.e(IronSourceConstants.IRONSOURCE_CONFIG_NAME, "Exception while saving events: ", th);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        if (r11.isOpen() != false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r11.isOpen() != false) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    @Override // com.ironsource.eventsmodule.IEventsStorageHelper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.ArrayList<com.ironsource.eventsmodule.EventData> loadEvents(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.eventsmodule.DataBaseEventsStorage.loadEvents(java.lang.String):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r0.isOpen() != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r0.isOpen() != false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r0.close();
     */
    @Override // com.ironsource.eventsmodule.IEventsStorageHelper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void clearEvents(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.lang.String r1 = "type = ?"
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ all -> 0x003f }
            r4 = 0
            r3[r4] = r6     // Catch:{ all -> 0x003f }
            android.database.sqlite.SQLiteDatabase r0 = r5.getDataBaseWithRetries(r2)     // Catch:{ all -> 0x001f }
            java.lang.String r6 = "events"
            r0.delete(r6, r1, r3)     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0030
            boolean r6 = r0.isOpen()
            if (r6 == 0) goto L_0x0030
        L_0x001b:
            r0.close()
            goto L_0x0030
        L_0x001f:
            r6 = move-exception
            java.lang.String r1 = "IronSource"
            java.lang.String r2 = "Exception while clearing events: "
            android.util.Log.e(r1, r2, r6)     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0030
            boolean r6 = r0.isOpen()
            if (r6 == 0) goto L_0x0030
            goto L_0x001b
        L_0x0030:
            monitor-exit(r5)
            return
        L_0x0032:
            r6 = move-exception
            if (r0 == 0) goto L_0x003e
            boolean r1 = r0.isOpen()
            if (r1 == 0) goto L_0x003e
            r0.close()
        L_0x003e:
            throw r6
        L_0x003f:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x0043
        L_0x0042:
            throw r6
        L_0x0043:
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.eventsmodule.DataBaseEventsStorage.clearEvents(java.lang.String):void");
    }

    private ContentValues getContentValuesForEvent(EventData eventData, String str) {
        if (eventData == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("eventid", Integer.valueOf(eventData.getEventId()));
        contentValues.put("timestamp", Long.valueOf(eventData.getTimeStamp()));
        contentValues.put("type", str);
        contentValues.put("data", eventData.getAdditionalData());
        return contentValues;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    private synchronized SQLiteDatabase getDataBaseWithRetries(boolean z) throws Throwable {
        int i = 0;
        while (z) {
            try {
                return getWritableDatabase();
            } catch (Throwable th) {
                throw th;
            }
        }
        return getReadableDatabase();
    }

    static abstract class EventEntry implements BaseColumns {
        public static final String COLUMN_NAME_DATA = "data";
        public static final String COLUMN_NAME_EVENT_ID = "eventid";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final int NUMBER_OF_COLUMNS = 4;
        public static final String TABLE_NAME = "events";

        EventEntry() {
        }
    }
}
