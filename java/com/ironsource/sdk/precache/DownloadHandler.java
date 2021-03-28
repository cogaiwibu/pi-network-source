package com.ironsource.sdk.precache;

import android.os.Handler;
import android.os.Message;
import com.ironsource.sdk.data.SSAFile;
import com.ironsource.sdk.utils.Logger;

public class DownloadHandler extends Handler {
    private static final String TAG = "DownloadHandler";
    OnPreCacheCompletion mListener;

    public void setOnPreCacheCompletion(OnPreCacheCompletion onPreCacheCompletion) {
        if (onPreCacheCompletion != null) {
            this.mListener = onPreCacheCompletion;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void handleMessage(Message message) {
        if (this.mListener == null) {
            Logger.i(TAG, "OnPreCacheCompletion listener is null, msg: " + message.toString());
            return;
        }
        try {
            if (message.what == 1016) {
                this.mListener.onFileDownloadSuccess((SSAFile) message.obj);
            } else {
                this.mListener.onFileDownloadFail((SSAFile) message.obj);
            }
        } catch (Throwable th) {
            Logger.i(TAG, "handleMessage | Got exception: " + th.getMessage());
            th.printStackTrace();
        }
    }

    public void release() {
        this.mListener = null;
    }
}
