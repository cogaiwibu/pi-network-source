package com.ironsource.mediationsdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;

public class IronSourceBannerLayout extends FrameLayout {
    private boolean isDestroyed = false;
    private Activity mActivity;
    private BannerListener mBannerListener;
    private View mBannerView;
    private boolean mIsBannerDisplayed = false;
    private String mPlacementName;
    private ISBannerSize mSize;

    public IronSourceBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.mActivity = activity;
        this.mSize = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    /* access modifiers changed from: protected */
    public void destroyBanner() {
        this.isDestroyed = true;
        this.mBannerListener = null;
        this.mActivity = null;
        this.mSize = null;
        this.mPlacementName = null;
        this.mBannerView = null;
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }

    public View getBannerView() {
        return this.mBannerView;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public ISBannerSize getSize() {
        return this.mSize;
    }

    public String getPlacementName() {
        return this.mPlacementName;
    }

    public void setPlacementName(String str) {
        this.mPlacementName = str;
    }

    public void setBannerListener(BannerListener bannerListener) {
        IronLog.API.info("");
        this.mBannerListener = bannerListener;
    }

    public void removeBannerListener() {
        IronLog.API.info("");
        this.mBannerListener = null;
    }

    public BannerListener getBannerListener() {
        return this.mBannerListener;
    }

    /* access modifiers changed from: package-private */
    public void sendBannerAdLoaded(String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("smash - " + str);
        if (this.mBannerListener != null && !this.mIsBannerDisplayed) {
            IronLog.CALLBACK.info("");
            this.mBannerListener.onBannerAdLoaded();
        }
        this.mIsBannerDisplayed = true;
    }

    /* access modifiers changed from: package-private */
    public void sendBannerAdLoadFailed(final IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.CALLBACK;
        ironLog.info("error=" + ironSourceError);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.ironsource.mediationsdk.IronSourceBannerLayout.AnonymousClass1 */

            public void run() {
                if (IronSourceBannerLayout.this.mIsBannerDisplayed) {
                    IronSourceBannerLayout.this.mBannerListener.onBannerAdLoadFailed(ironSourceError);
                    return;
                }
                try {
                    if (IronSourceBannerLayout.this.mBannerView != null) {
                        IronSourceBannerLayout.this.removeView(IronSourceBannerLayout.this.mBannerView);
                        IronSourceBannerLayout.this.mBannerView = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (IronSourceBannerLayout.this.mBannerListener != null) {
                    IronSourceBannerLayout.this.mBannerListener.onBannerAdLoadFailed(ironSourceError);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void sendBannerAdClicked() {
        if (this.mBannerListener != null) {
            IronLog.CALLBACK.info("");
            this.mBannerListener.onBannerAdClicked();
        }
    }

    /* access modifiers changed from: package-private */
    public void sendBannerAdScreenPresented() {
        if (this.mBannerListener != null) {
            IronLog.CALLBACK.info("");
            this.mBannerListener.onBannerAdScreenPresented();
        }
    }

    /* access modifiers changed from: package-private */
    public void sendBannerAdScreenDismissed() {
        if (this.mBannerListener != null) {
            IronLog.CALLBACK.info("");
            this.mBannerListener.onBannerAdScreenDismissed();
        }
    }

    /* access modifiers changed from: package-private */
    public void sendBannerAdLeftApplication() {
        if (this.mBannerListener != null) {
            IronLog.CALLBACK.info("");
            this.mBannerListener.onBannerAdLeftApplication();
        }
    }

    /* access modifiers changed from: package-private */
    public void addViewWithFrameLayoutParams(final View view, final FrameLayout.LayoutParams layoutParams) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.ironsource.mediationsdk.IronSourceBannerLayout.AnonymousClass2 */

            public void run() {
                IronSourceBannerLayout.this.removeAllViews();
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                IronSourceBannerLayout.this.mBannerView = view;
                IronSourceBannerLayout.this.addView(view, 0, layoutParams);
            }
        });
    }
}
