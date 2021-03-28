package com.ironsource.environment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class UrlHandler {
    public static void openUrl(Context context, String str) throws Exception {
        if (str != null) {
            context.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)));
            return;
        }
        throw new Exception("url is null");
    }
}
