package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gz;

public class TJAdUnitActivity extends Activity implements View.OnClickListener {
    private static TJAdUnitActivity c;
    TJAdUnit a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private TJPlacementData d;
    private TJAdUnitSaveStateData e = new TJAdUnitSaveStateData();
    private RelativeLayout f = null;
    private TJCloseButton g;
    private ProgressBar h;
    private boolean i = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        TapjoyLog.d("TJAdUnitActivity", "TJAdUnitActivity onCreate: " + bundle);
        super.onCreate(bundle);
        c = this;
        if (bundle != null) {
            TJAdUnitSaveStateData tJAdUnitSaveStateData = (TJAdUnitSaveStateData) bundle.getSerializable("ad_unit_bundle");
            this.e = tJAdUnitSaveStateData;
            if (tJAdUnitSaveStateData != null && tJAdUnitSaveStateData.isVideoComplete) {
                TapjoyLog.d("TJAdUnitActivity", "finishing TJAdUnitActivity");
                finish();
                return;
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null || extras.getSerializable(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA) == null) {
            TapjoyLog.e("TJAdUnitActivity", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Failed to launch AdUnit Activity"));
            finish();
            return;
        }
        TJPlacementData tJPlacementData = (TJPlacementData) extras.getSerializable(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA);
        this.d = tJPlacementData;
        if (tJPlacementData.getContentViewId() != null) {
            TapjoyConnectCore.viewWillOpen(this.d.getContentViewId(), 1);
        }
        if (TJPlacementManager.a(this.d.getKey()) != null) {
            this.a = TJPlacementManager.a(this.d.getKey()).getAdUnit();
        } else {
            this.a = new TJAdUnit();
            this.a.setAdContentTracker(new fm(this.d.getPlacementName(), this.d.getPlacementType()));
        }
        if (!this.a.hasCalledLoad()) {
            TapjoyLog.d("TJAdUnitActivity", "No content loaded for ad unit -- loading now");
            this.a.load(this.d, false, this);
        }
        this.a.setAdUnitActivity(this);
        if (Build.VERSION.SDK_INT < 11) {
            setTheme(16973829);
        } else {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f.setBackgroundColor(0);
        TJWebView backgroundWebView = this.a.getBackgroundWebView();
        backgroundWebView.setLayoutParams(layoutParams);
        if (backgroundWebView.getParent() != null) {
            ((ViewGroup) backgroundWebView.getParent()).removeView(backgroundWebView);
        }
        TJWebView webView = this.a.getWebView();
        webView.setLayoutParams(layoutParams);
        if (webView.getParent() != null) {
            ((ViewGroup) webView.getParent()).removeView(webView);
        }
        this.f.addView(backgroundWebView);
        VideoView videoView = this.a.getVideoView();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (videoView.getParent() != null) {
            ((ViewGroup) videoView.getParent()).removeView(videoView);
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(17);
        linearLayout.addView(videoView, new LinearLayout.LayoutParams(-1, -1));
        this.f.addView(linearLayout, layoutParams2);
        this.f.addView(webView);
        this.h = new ProgressBar(this, null, 16842874);
        if (this.d.hasProgressSpinner()) {
            setProgressSpinnerVisibility(true);
        } else {
            setProgressSpinnerVisibility(false);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        this.h.setLayoutParams(layoutParams3);
        this.f.addView(this.h);
        TJCloseButton tJCloseButton = new TJCloseButton(this);
        this.g = tJCloseButton;
        tJCloseButton.setOnClickListener(this);
        this.f.addView(this.g);
        setContentView(this.f);
        this.a.setVisible(true);
        TJCorePlacement a2 = TJPlacementManager.a(this.d.getKey());
        if (a2 != null) {
            String str = TJCorePlacement.a;
            TapjoyLog.i(str, "Content shown for placement " + a2.c.getPlacementName());
            a2.f.a();
            TJPlacement a3 = a2.a("SHOW");
            if (a3 != null && a3.getListener() != null) {
                a3.getListener().onContentShow(a3);
            }
        }
    }

    public void setCloseButtonVisibility(boolean z) {
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(4);
        }
    }

    public void setCloseButtonClickable(boolean z) {
        this.g.setClickableRequested(z);
    }

    public void setProgressSpinnerVisibility(boolean z) {
        if (z) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(4);
        }
    }

    public void onBackPressed() {
        handleClose();
    }

    public void handleClose() {
        handleClose(false);
    }

    public void handleClose(boolean z) {
        if (!this.a.getCloseRequested()) {
            TapjoyLog.d("TJAdUnitActivity", TJAdUnitConstants.String.CLOSE_REQUESTED);
            this.a.closeRequested(z);
            this.b.postDelayed(new Runnable() {
                /* class com.tapjoy.TJAdUnitActivity.AnonymousClass1 */

                public final void run() {
                    if (TJAdUnitActivity.this.a.getCloseRequested()) {
                        TapjoyLog.d("TJAdUnitActivity", "Did not receive callback from content. Closing ad.");
                        TJAdUnitActivity.this.finish();
                    }
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        TJPlacement a2;
        super.onDestroy();
        c = null;
        TapjoyLog.d("TJAdUnitActivity", "onDestroy");
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit != null) {
            tJAdUnit.destroy();
        }
        TJPlacementData tJPlacementData = this.d;
        if (tJPlacementData != null && tJPlacementData.isBaseActivity()) {
            if (this.d.getContentViewId() != null) {
                TapjoyConnectCore.viewDidClose(this.d.getContentViewId());
            }
            TJCorePlacement a3 = TJPlacementManager.a(this.d.getKey());
            if (a3 != null && (a2 = a3.a("SHOW")) != null && a2.getListener() != null) {
                String str = TJCorePlacement.a;
                TapjoyLog.i(str, "Content dismissed for placement " + a3.c.getPlacementName());
                fq fqVar = a3.f.a;
                if (fqVar != null) {
                    fqVar.b.clear();
                }
                if (a2 != null && a2.a != null) {
                    a2.a.onContentDismiss(a2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        TapjoyLog.d("TJAdUnitActivity", "onResume");
        super.onResume();
        if (this.a.isLockedOrientation()) {
            setRequestedOrientation(this.a.getLockedOrientation());
        }
        this.a.resume(this.e);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        TapjoyLog.d("TJAdUnitActivity", "onStart");
        if (gz.a().n) {
            this.i = true;
            gn.a(this);
        }
        if (!this.d.isBaseActivity()) {
            setResult(-1, getIntent());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        TapjoyLog.d("TJAdUnitActivity", "onPause");
        this.a.pause();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TapjoyLog.d("TJAdUnitActivity", "onSaveInstanceState");
        this.e.seekTime = this.a.getVideoSeekTime();
        this.e.isVideoComplete = this.a.isVideoComplete();
        this.e.isVideoMuted = this.a.isMuted();
        bundle.putSerializable("ad_unit_bundle", this.e);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (this.i) {
            this.i = false;
            gn.b(this);
        }
        super.onStop();
        TapjoyLog.d("TJAdUnitActivity", "onStop");
    }

    public void showErrorDialog() {
        if (isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            new AlertDialog.Builder(this, 16974394).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                /* class com.tapjoy.TJAdUnitActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create().show();
        } else {
            new AlertDialog.Builder(this).setMessage("An error occured. Please try again later.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                /* class com.tapjoy.TJAdUnitActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    TJAdUnitActivity.this.handleClose();
                    dialogInterface.cancel();
                }
            }).create().show();
        }
    }

    public void onClick(View view) {
        handleClose();
    }

    static void a() {
        TJAdUnitActivity tJAdUnitActivity = c;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.handleClose(true);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a.notifyOrientationChanged();
    }
}
