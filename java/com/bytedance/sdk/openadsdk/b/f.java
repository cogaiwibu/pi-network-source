package com.bytedance.sdk.openadsdk.b;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.g.j;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedList;
import java.util.List;

/* compiled from: AdEventRepertoryImpl */
public class f implements e<a> {
    private final Context a;
    private final d b;

    public f(Context context) {
        this.a = context.getApplicationContext();
        this.b = d.a(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|23|21|5|4) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0022 A[LOOP:0: B:4:0x0022->B:21:0x0022, LOOP_START, SYNTHETIC, Splitter:B:4:0x0022] */
    @Override // com.bytedance.sdk.openadsdk.b.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.bytedance.sdk.openadsdk.b.a> a() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.LinkedList r0 = new java.util.LinkedList     // Catch:{ all -> 0x0059 }
            r0.<init>()     // Catch:{ all -> 0x0059 }
            android.content.Context r1 = r9.a     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = "adevent"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x0059 }
            r4 = 0
            java.lang.String r5 = "id"
            r3[r4] = r5     // Catch:{ all -> 0x0059 }
            r4 = 1
            java.lang.String r5 = "value"
            r3[r4] = r5     // Catch:{ all -> 0x0059 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = com.bytedance.sdk.openadsdk.multipro.a.a.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0059 }
            if (r1 == 0) goto L_0x0057
        L_0x0022:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x004a
            java.lang.String r2 = "id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = "value"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0050 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0022 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0022 }
            com.bytedance.sdk.openadsdk.b.a r3 = new com.bytedance.sdk.openadsdk.b.a     // Catch:{ JSONException -> 0x0022 }
            r3.<init>(r2, r4)     // Catch:{ JSONException -> 0x0022 }
            r0.add(r3)     // Catch:{ JSONException -> 0x0022 }
            goto L_0x0022
        L_0x004a:
            if (r1 == 0) goto L_0x0057
            r1.close()
            goto L_0x0057
        L_0x0050:
            r0 = move-exception
            if (r1 == 0) goto L_0x0056
            r1.close()
        L_0x0056:
            throw r0
        L_0x0057:
            monitor-exit(r9)
            return r0
        L_0x0059:
            r0 = move-exception
            monitor-exit(r9)
            goto L_0x005d
        L_0x005c:
            throw r0
        L_0x005d:
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.b.f.a():java.util.List");
    }

    public synchronized void a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.a);
        contentValues.put("value", aVar.b.toString());
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put(TapjoyConstants.TJC_RETRY, (Integer) 0);
        a.a(this.a, "adevent", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public synchronized void a(List<a> list) {
        if (!j.a(list)) {
            LinkedList linkedList = new LinkedList();
            for (a aVar : list) {
                linkedList.add(aVar.a);
            }
            a.a(this.a, "DELETE FROM adevent WHERE " + a("id", linkedList, 1000, true));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public synchronized void a(int i, long j) {
        b(i, j);
    }

    private synchronized void b(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Context context = this.a;
        a.a(context, "adevent", "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i + ""});
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public synchronized void a(List<a> list, int i, long j) {
        if (!j.a(list)) {
            try {
                b(list);
                b(i, j);
            } catch (Exception unused) {
            }
        }
    }

    private synchronized void b(List<a> list) {
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.a);
        }
        a.a(this.a, "UPDATE " + "adevent" + " SET " + TapjoyConstants.TJC_RETRY + " = " + TapjoyConstants.TJC_RETRY + "+1" + " WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public void a(boolean z) {
        this.b.a("serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public boolean b() {
        return this.b.b("serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public int c() {
        return this.b.b("serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.b.e
    public void a(int i) {
        this.b.a("serverbusy_retrycount", i);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS " + "adevent" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + "value" + " TEXT ," + "gen_time" + " TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0" + ")";
    }

    private static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String a2 = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a2);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
