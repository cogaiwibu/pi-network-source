package androidx.browser.browseractions;

import android.app.PendingIntent;

public class BrowserActionItem {
    private final PendingIntent mAction;
    private final int mIconId;
    private final String mTitle;

    public BrowserActionItem(String str, PendingIntent pendingIntent, int i) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i;
    }

    public BrowserActionItem(String str, PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public PendingIntent getAction() {
        return this.mAction;
    }
}
