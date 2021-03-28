package com.tkporter.sendsms;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.ironsource.sdk.constants.Constants;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class SendSMSObserver extends ContentObserver {
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_TYPE = "type";
    private static final int MESSAGE_TYPE_ALL = 0;
    private static final int MESSAGE_TYPE_DRAFT = 3;
    private static final int MESSAGE_TYPE_FAILED = 5;
    private static final int MESSAGE_TYPE_INBOX = 1;
    private static final int MESSAGE_TYPE_OUTBOX = 4;
    private static final int MESSAGE_TYPE_QUEUED = 6;
    private static final int MESSAGE_TYPE_SENT = 2;
    private static final String[] PROJECTION = {COLUMN_ADDRESS, "type"};
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final Uri uri = Uri.parse("content://sms/");
    private boolean isAuthorizedForCallback;
    private SendSMSModule module;
    private ContentResolver resolver = null;
    private ReadableArray successTypes;
    private Map<String, Integer> types;

    public SendSMSObserver(Context context, SendSMSModule sendSMSModule, ReadableMap readableMap) {
        super(handler);
        HashMap hashMap = new HashMap();
        this.types = hashMap;
        hashMap.put("all", 0);
        this.types.put("inbox", 1);
        this.types.put("sent", 2);
        this.types.put("draft", 3);
        this.types.put("outbox", 4);
        this.types.put(Constants.ParametersKeys.FAILED, 5);
        this.types.put("queued", 6);
        this.successTypes = getSuccessTypes(readableMap);
        this.module = sendSMSModule;
        this.resolver = context.getContentResolver();
        this.isAuthorizedForCallback = isAuthorizedForCallback(readableMap);
    }

    private ReadableArray getSuccessTypes(ReadableMap readableMap) {
        if (readableMap.hasKey("successTypes")) {
            return readableMap.getArray("successTypes");
        }
        throw new IllegalStateException("Must provide successTypes. Read react-native-sms/README.md");
    }

    private boolean isAuthorizedForCallback(ReadableMap readableMap) {
        if (readableMap.hasKey("isAuthorizedForCallback")) {
            return readableMap.getBoolean("isAuthorizedForCallback");
        }
        return false;
    }

    public void start() {
        if (this.isAuthorizedForCallback) {
            ContentResolver contentResolver = this.resolver;
            if (contentResolver != null) {
                contentResolver.registerContentObserver(uri, true, this);
                return;
            }
            throw new IllegalStateException("Current SmsSendObserver instance is invalid");
        }
    }

    public void stop() {
        ContentResolver contentResolver = this.resolver;
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this);
        }
    }

    private void messageSuccess() {
        this.module.sendCallback(true, false, false);
        stop();
    }

    private void messageGeneric() {
        this.module.sendCallback(false, false, false);
        stop();
    }

    private void messageError() {
        this.module.sendCallback(false, false, true);
    }

    public void onChange(boolean z) {
        Cursor cursor = null;
        try {
            if (!this.isAuthorizedForCallback) {
                messageGeneric();
                return;
            }
            cursor = this.resolver.query(uri, PROJECTION, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int i = cursor.getInt(cursor.getColumnIndex("type"));
                PrintStream printStream = System.out;
                printStream.println("onChange() type: " + i);
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.successTypes.size()) {
                        break;
                    } else if (i == this.types.get(this.successTypes.getString(i2)).intValue()) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    messageSuccess();
                } else {
                    messageError();
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
