package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

public final class CustomTabsIntent {
    public static final String EXTRA_ACTION_BUTTON_BUNDLE = "android.support.customtabs.extra.ACTION_BUTTON_BUNDLE";
    public static final String EXTRA_CLOSE_BUTTON_ICON = "android.support.customtabs.extra.CLOSE_BUTTON_ICON";
    public static final String EXTRA_DEFAULT_SHARE_MENU_ITEM = "android.support.customtabs.extra.SHARE_MENU_ITEM";
    public static final String EXTRA_ENABLE_INSTANT_APPS = "android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS";
    public static final String EXTRA_ENABLE_URLBAR_HIDING = "android.support.customtabs.extra.ENABLE_URLBAR_HIDING";
    public static final String EXTRA_EXIT_ANIMATION_BUNDLE = "android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE";
    public static final String EXTRA_MENU_ITEMS = "android.support.customtabs.extra.MENU_ITEMS";
    public static final String EXTRA_REMOTEVIEWS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS";
    public static final String EXTRA_REMOTEVIEWS_CLICKED_ID = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_CLICKED_ID";
    public static final String EXTRA_REMOTEVIEWS_PENDINGINTENT = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT";
    public static final String EXTRA_REMOTEVIEWS_VIEW_IDS = "android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS";
    public static final String EXTRA_SECONDARY_TOOLBAR_COLOR = "android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR";
    public static final String EXTRA_SESSION = "android.support.customtabs.extra.SESSION";
    public static final String EXTRA_TINT_ACTION_BUTTON = "android.support.customtabs.extra.TINT_ACTION_BUTTON";
    public static final String EXTRA_TITLE_VISIBILITY_STATE = "android.support.customtabs.extra.TITLE_VISIBILITY";
    public static final String EXTRA_TOOLBAR_COLOR = "android.support.customtabs.extra.TOOLBAR_COLOR";
    public static final String EXTRA_TOOLBAR_ITEMS = "android.support.customtabs.extra.TOOLBAR_ITEMS";
    private static final String EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS = "android.support.customtabs.extra.user_opt_out";
    public static final String KEY_DESCRIPTION = "android.support.customtabs.customaction.DESCRIPTION";
    public static final String KEY_ICON = "android.support.customtabs.customaction.ICON";
    public static final String KEY_ID = "android.support.customtabs.customaction.ID";
    public static final String KEY_MENU_ITEM_TITLE = "android.support.customtabs.customaction.MENU_ITEM_TITLE";
    public static final String KEY_PENDING_INTENT = "android.support.customtabs.customaction.PENDING_INTENT";
    private static final int MAX_TOOLBAR_ITEMS = 5;
    public static final int NO_TITLE = 0;
    public static final int SHOW_PAGE_TITLE = 1;
    public static final int TOOLBAR_ACTION_BUTTON_ID = 0;
    public final Intent intent;
    public final Bundle startAnimationBundle;

    public static int getMaxToolbarItems() {
        return 5;
    }

    public void launchUrl(Context context, Uri uri) {
        this.intent.setData(uri);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }

    CustomTabsIntent(Intent intent2, Bundle bundle) {
        this.intent = intent2;
        this.startAnimationBundle = bundle;
    }

    public static final class Builder {
        private ArrayList<Bundle> mActionButtons;
        private boolean mInstantAppsEnabled;
        private final Intent mIntent;
        private ArrayList<Bundle> mMenuItems;
        private Bundle mStartAnimationBundle;

        public Builder() {
            this(null);
        }

        public Builder(CustomTabsSession customTabsSession) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.mIntent = intent;
            IBinder iBinder = null;
            this.mMenuItems = null;
            this.mStartAnimationBundle = null;
            this.mActionButtons = null;
            this.mInstantAppsEnabled = true;
            if (customTabsSession != null) {
                intent.setPackage(customTabsSession.getComponentName().getPackageName());
            }
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, CustomTabsIntent.EXTRA_SESSION, customTabsSession != null ? customTabsSession.getBinder() : iBinder);
            this.mIntent.putExtras(bundle);
        }

        public Builder setToolbarColor(int i) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, i);
            return this;
        }

        public Builder enableUrlBarHiding() {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, true);
            return this;
        }

        public Builder setCloseButtonIcon(Bitmap bitmap) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_CLOSE_BUTTON_ICON, bitmap);
            return this;
        }

        public Builder setShowTitle(boolean z) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TITLE_VISIBILITY_STATE, z ? 1 : 0);
            return this;
        }

        public Builder addMenuItem(String str, PendingIntent pendingIntent) {
            if (this.mMenuItems == null) {
                this.mMenuItems = new ArrayList<>();
            }
            Bundle bundle = new Bundle();
            bundle.putString(CustomTabsIntent.KEY_MENU_ITEM_TITLE, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mMenuItems.add(bundle);
            return this;
        }

        public Builder addDefaultShareMenuItem() {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_DEFAULT_SHARE_MENU_ITEM, true);
            return this;
        }

        public Builder setActionButton(Bitmap bitmap, String str, PendingIntent pendingIntent, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putInt(CustomTabsIntent.KEY_ID, 0);
            bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
            bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
            bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_TINT_ACTION_BUTTON, z);
            return this;
        }

        public Builder setActionButton(Bitmap bitmap, String str, PendingIntent pendingIntent) {
            return setActionButton(bitmap, str, pendingIntent, false);
        }

        @Deprecated
        public Builder addToolbarItem(int i, Bitmap bitmap, String str, PendingIntent pendingIntent) throws IllegalStateException {
            if (this.mActionButtons == null) {
                this.mActionButtons = new ArrayList<>();
            }
            if (this.mActionButtons.size() < 5) {
                Bundle bundle = new Bundle();
                bundle.putInt(CustomTabsIntent.KEY_ID, i);
                bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
                bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
                bundle.putParcelable(CustomTabsIntent.KEY_PENDING_INTENT, pendingIntent);
                this.mActionButtons.add(bundle);
                return this;
            }
            throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        }

        public Builder setSecondaryToolbarColor(int i) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, i);
            return this;
        }

        public Builder setSecondaryToolbarViews(RemoteViews remoteViews, int[] iArr, PendingIntent pendingIntent) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
            return this;
        }

        public Builder setInstantAppsEnabled(boolean z) {
            this.mInstantAppsEnabled = z;
            return this;
        }

        public Builder setStartAnimations(Context context, int i, int i2) {
            this.mStartAnimationBundle = ActivityOptionsCompat.makeCustomAnimation(context, i, i2).toBundle();
            return this;
        }

        public Builder setExitAnimations(Context context, int i, int i2) {
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_EXIT_ANIMATION_BUNDLE, ActivityOptionsCompat.makeCustomAnimation(context, i, i2).toBundle());
            return this;
        }

        public CustomTabsIntent build() {
            ArrayList<Bundle> arrayList = this.mMenuItems;
            if (arrayList != null) {
                this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_MENU_ITEMS, arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.mActionButtons;
            if (arrayList2 != null) {
                this.mIntent.putParcelableArrayListExtra(CustomTabsIntent.EXTRA_TOOLBAR_ITEMS, arrayList2);
            }
            this.mIntent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, this.mInstantAppsEnabled);
            return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
        }
    }

    public static Intent setAlwaysUseBrowserUI(Intent intent2) {
        if (intent2 == null) {
            intent2 = new Intent("android.intent.action.VIEW");
        }
        intent2.addFlags(268435456);
        intent2.putExtra(EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, true);
        return intent2;
    }

    public static boolean shouldAlwaysUseBrowserUI(Intent intent2) {
        if (!intent2.getBooleanExtra(EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS, false) || (intent2.getFlags() & 268435456) == 0) {
            return false;
        }
        return true;
    }
}
