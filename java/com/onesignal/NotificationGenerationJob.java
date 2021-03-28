package com.onesignal;

import android.content.Context;
import android.net.Uri;
import com.onesignal.NotificationExtenderService;
import java.security.SecureRandom;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class NotificationGenerationJob {
    Context context;
    boolean isInAppPreviewPush;
    JSONObject jsonPayload;
    Integer orgFlags;
    Uri orgSound;
    CharSequence overriddenBodyFromExtender;
    Integer overriddenFlags;
    Uri overriddenSound;
    CharSequence overriddenTitleFromExtender;
    NotificationExtenderService.OverrideSettings overrideSettings;
    boolean restoring;
    boolean showAsAlert;
    Long shownTimeStamp;

    NotificationGenerationJob(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getTitle() {
        CharSequence charSequence = this.overriddenTitleFromExtender;
        if (charSequence != null) {
            return charSequence;
        }
        return this.jsonPayload.optString("title", null);
    }

    /* access modifiers changed from: package-private */
    public CharSequence getBody() {
        CharSequence charSequence = this.overriddenBodyFromExtender;
        if (charSequence != null) {
            return charSequence;
        }
        return this.jsonPayload.optString("alert", null);
    }

    /* access modifiers changed from: package-private */
    public Integer getAndroidId() {
        if (this.overrideSettings == null) {
            this.overrideSettings = new NotificationExtenderService.OverrideSettings();
        }
        if (this.overrideSettings.androidNotificationId == null) {
            this.overrideSettings.androidNotificationId = Integer.valueOf(new SecureRandom().nextInt());
        }
        return this.overrideSettings.androidNotificationId;
    }

    /* access modifiers changed from: package-private */
    public int getAndroidIdWithoutCreate() {
        NotificationExtenderService.OverrideSettings overrideSettings2 = this.overrideSettings;
        if (overrideSettings2 == null || overrideSettings2.androidNotificationId == null) {
            return -1;
        }
        return this.overrideSettings.androidNotificationId.intValue();
    }

    /* access modifiers changed from: package-private */
    public boolean isNotificationToDisplay() {
        return getAndroidIdWithoutCreate() != -1;
    }

    /* access modifiers changed from: package-private */
    public String getApiNotificationId() {
        return OSNotificationFormatHelper.getOSNotificationIdFromJson(this.jsonPayload);
    }

    /* access modifiers changed from: package-private */
    public void setAndroidIdWithOutOverriding(Integer num) {
        if (num != null) {
            NotificationExtenderService.OverrideSettings overrideSettings2 = this.overrideSettings;
            if (overrideSettings2 == null || overrideSettings2.androidNotificationId == null) {
                if (this.overrideSettings == null) {
                    this.overrideSettings = new NotificationExtenderService.OverrideSettings();
                }
                this.overrideSettings.androidNotificationId = num;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasExtender() {
        NotificationExtenderService.OverrideSettings overrideSettings2 = this.overrideSettings;
        return (overrideSettings2 == null || overrideSettings2.extender == null) ? false : true;
    }
}
