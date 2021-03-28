package com.bytedance.sdk.openadsdk.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TrackRetryRepertoryImpl */
public class g implements f {
    private Context a;

    public g(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.f.f
    public synchronized List<e> a() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor a2 = a.a(this.a, "trackurl", null, null, null, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    linkedList.add(new e(a2.getString(a2.getColumnIndex("id")), a2.getString(a2.getColumnIndex("url")), a2.getInt(a2.getColumnIndex(TapjoyConstants.TJC_RETRY))));
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.f.f
    public synchronized void a(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", eVar.a());
        contentValues.put("url", eVar.b());
        contentValues.put("replaceholder", (Integer) 1);
        contentValues.put(TapjoyConstants.TJC_RETRY, Integer.valueOf(eVar.c()));
        a.a(this.a, "trackurl", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.f.f
    public synchronized void b(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", eVar.a());
        contentValues.put("url", eVar.b());
        contentValues.put("replaceholder", (Integer) 1);
        contentValues.put(TapjoyConstants.TJC_RETRY, Integer.valueOf(eVar.c()));
        a.a(this.a, "trackurl", contentValues, "id=?", new String[]{eVar.a()});
    }

    @Override // com.bytedance.sdk.openadsdk.f.f
    public synchronized void c(e eVar) {
        a.a(this.a, "trackurl", "id=?", new String[]{eVar.a()});
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS " + "trackurl" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + "url" + " TEXT ," + "replaceholder" + " INTEGER default 0, " + TapjoyConstants.TJC_RETRY + " INTEGER default 0" + ")";
    }
}
