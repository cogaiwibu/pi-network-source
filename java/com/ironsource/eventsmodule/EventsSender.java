package com.ironsource.eventsmodule;

import android.os.AsyncTask;
import android.util.Pair;
import com.ironsource.network.ISHttpService;
import java.util.ArrayList;

public class EventsSender extends AsyncTask<Object, Void, Boolean> {
    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPE_FIELD = "Content-Type";
    private ArrayList extraData;
    private IEventsSenderResultListener mResultListener;

    public EventsSender() {
    }

    public EventsSender(IEventsSenderResultListener iEventsSenderResultListener) {
        this.mResultListener = iEventsSenderResultListener;
    }

    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Boolean doInBackground(Object... objArr) {
        try {
            this.extraData = (ArrayList) objArr[2];
            boolean z = true;
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", "application/json"));
            if (ISHttpService.sendPOSTRequest((String) objArr[1], (String) objArr[0], arrayList).responseCode != 200) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Boolean bool) {
        IEventsSenderResultListener iEventsSenderResultListener = this.mResultListener;
        if (iEventsSenderResultListener != null) {
            iEventsSenderResultListener.onEventsSenderResult(this.extraData, bool.booleanValue());
        }
    }
}
