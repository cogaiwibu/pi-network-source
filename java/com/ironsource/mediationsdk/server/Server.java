package com.ironsource.mediationsdk.server;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.ThreadExceptionHandler;
import org.json.JSONObject;

public class Server {
    /* access modifiers changed from: private */
    public static void callRequestURL(String str, boolean z, int i) {
        try {
            new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(str, z, i)));
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NETWORK;
            logger.log(ironSourceTag, "callRequestURL(reqUrl:" + str + ", hit:" + z + ")", 1);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("callRequestURL(reqUrl:");
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", hit:");
            sb.append(z);
            sb.append(")");
            IronSourceLoggerManager logger2 = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NETWORK;
            logger2.log(ironSourceTag2, sb.toString() + ", e:" + Log.getStackTraceString(th), 0);
        }
    }

    public static void callAsyncRequestURL(final String str, final boolean z, final int i) {
        Thread thread = new Thread(new Runnable() {
            /* class com.ironsource.mediationsdk.server.Server.AnonymousClass1 */

            public void run() {
                Server.callRequestURL(str, z, i);
            }
        }, "callAsyncRequestURL");
        thread.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        thread.start();
    }
}
