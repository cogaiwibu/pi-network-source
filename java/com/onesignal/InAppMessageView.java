package com.onesignal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.core.widget.PopupWindowCompat;
import com.onesignal.DraggableRelativeLayout;
import com.onesignal.OneSignal;
import com.onesignal.WebViewManager;

/* access modifiers changed from: package-private */
public class InAppMessageView {
    private static final int ACTIVITY_BACKGROUND_COLOR_EMPTY = Color.parseColor("#00000000");
    private static final int ACTIVITY_BACKGROUND_COLOR_FULL = Color.parseColor("#BB000000");
    private static final int ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS = 600;
    private static final int ACTIVITY_INIT_DELAY = 200;
    private static final int DRAG_THRESHOLD_PX_SIZE = OSViewUtils.dpToPx(4);
    private static final int IN_APP_BACKGROUND_ANIMATION_DURATION_MS = 400;
    private static final int IN_APP_BANNER_ANIMATION_DURATION_MS = 1000;
    private static final int IN_APP_CENTER_ANIMATION_DURATION_MS = 1000;
    private static final String IN_APP_MESSAGE_CARD_VIEW_TAG = "IN_APP_MESSAGE_CARD_VIEW_TAG";
    private static final int MARGIN_PX_SIZE = OSViewUtils.dpToPx(24);
    private Activity currentActivity;
    private double dismissDuration;
    private WebViewManager.Position displayLocation;
    private DraggableRelativeLayout draggableRelativeLayout;
    private final Handler handler = new Handler();
    private boolean hasBackground;
    private boolean isDragging = false;
    private InAppMessageViewListener messageController;
    private int pageHeight;
    private int pageWidth;
    private RelativeLayout parentRelativeLayout;
    private PopupWindow popupWindow;
    private Runnable scheduleDismissRunnable;
    private boolean shouldDismissWhenActive = false;
    private WebView webView;

    /* access modifiers changed from: package-private */
    public interface InAppMessageViewListener {
        void onMessageWasDismissed();

        void onMessageWasShown();
    }

    InAppMessageView(WebView webView2, WebViewManager.Position position, int i, double d) {
        this.webView = webView2;
        this.displayLocation = position;
        this.pageHeight = i;
        this.pageWidth = -1;
        this.dismissDuration = Double.isNaN(d) ? 0.0d : d;
        this.hasBackground = !position.isBanner();
    }

    /* access modifiers changed from: package-private */
    public void setWebView(WebView webView2) {
        this.webView = webView2;
    }

    /* access modifiers changed from: package-private */
    public void setMessageController(InAppMessageViewListener inAppMessageViewListener) {
        this.messageController = inAppMessageViewListener;
    }

    /* access modifiers changed from: package-private */
    public WebViewManager.Position getDisplayPosition() {
        return this.displayLocation;
    }

    /* access modifiers changed from: package-private */
    public void showView(Activity activity) {
        delayShowUntilAvailable(activity);
    }

    /* access modifiers changed from: package-private */
    public void checkIfShouldDismiss() {
        if (this.shouldDismissWhenActive) {
            this.shouldDismissWhenActive = false;
            finishAfterDelay(null);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateHeight(final int i) {
        this.pageHeight = i;
        OSUtils.runOnMainUIThread(new Runnable() {
            /* class com.onesignal.InAppMessageView.AnonymousClass1 */

            public void run() {
                if (InAppMessageView.this.webView == null) {
                    OneSignal.onesignalLog(OneSignal.LOG_LEVEL.WARN, "WebView height update skipped, new height will be used once it is displayed.");
                    return;
                }
                ViewGroup.LayoutParams layoutParams = InAppMessageView.this.webView.getLayoutParams();
                layoutParams.height = i;
                InAppMessageView.this.webView.setLayoutParams(layoutParams);
                if (InAppMessageView.this.draggableRelativeLayout != null) {
                    DraggableRelativeLayout draggableRelativeLayout = InAppMessageView.this.draggableRelativeLayout;
                    InAppMessageView inAppMessageView = InAppMessageView.this;
                    draggableRelativeLayout.setParams(inAppMessageView.createDraggableLayoutParams(i, inAppMessageView.displayLocation));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void showInAppMessageView(Activity activity) {
        this.currentActivity = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.pageHeight);
        layoutParams.addRule(13);
        LinearLayout.LayoutParams createParentLinearLayoutParams = this.hasBackground ? createParentLinearLayoutParams() : null;
        WebViewManager.Position position = this.displayLocation;
        showDraggableView(position, layoutParams, createParentLinearLayoutParams, createDraggableLayoutParams(this.pageHeight, position));
    }

    private int getDisplayYSize() {
        return OSViewUtils.getWindowHeight(this.currentActivity);
    }

    private LinearLayout.LayoutParams createParentLinearLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.pageWidth, -1);
        int i = AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position[this.displayLocation.ordinal()];
        if (i == 1) {
            layoutParams.gravity = 49;
        } else if (i == 2) {
            layoutParams.gravity = 81;
        } else if (i == 3 || i == 4) {
            layoutParams.gravity = 17;
        }
        return layoutParams;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.onesignal.InAppMessageView$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$onesignal$WebViewManager$Position;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.onesignal.WebViewManager$Position[] r0 = com.onesignal.WebViewManager.Position.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.onesignal.InAppMessageView.AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position = r0
                com.onesignal.WebViewManager$Position r1 = com.onesignal.WebViewManager.Position.TOP_BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.onesignal.InAppMessageView.AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position     // Catch:{ NoSuchFieldError -> 0x001d }
                com.onesignal.WebViewManager$Position r1 = com.onesignal.WebViewManager.Position.BOTTOM_BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.onesignal.InAppMessageView.AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.onesignal.WebViewManager$Position r1 = com.onesignal.WebViewManager.Position.CENTER_MODAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.onesignal.InAppMessageView.AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.onesignal.WebViewManager$Position r1 = com.onesignal.WebViewManager.Position.FULL_SCREEN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.InAppMessageView.AnonymousClass9.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private DraggableRelativeLayout.Params createDraggableLayoutParams(int i, WebViewManager.Position position) {
        DraggableRelativeLayout.Params params = new DraggableRelativeLayout.Params();
        params.maxXPos = MARGIN_PX_SIZE;
        params.maxYPos = MARGIN_PX_SIZE;
        params.messageHeight = i;
        params.height = getDisplayYSize();
        int i2 = AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position[position.ordinal()];
        int i3 = 1;
        if (i2 == 1) {
            params.dragThresholdY = MARGIN_PX_SIZE - DRAG_THRESHOLD_PX_SIZE;
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    i = getDisplayYSize() - (MARGIN_PX_SIZE * 2);
                    params.messageHeight = i;
                }
            }
            int displayYSize = (getDisplayYSize() / 2) - (i / 2);
            params.dragThresholdY = DRAG_THRESHOLD_PX_SIZE + displayYSize;
            params.maxYPos = displayYSize;
            params.posY = displayYSize;
        } else {
            params.posY = getDisplayYSize() - i;
            params.dragThresholdY = MARGIN_PX_SIZE + DRAG_THRESHOLD_PX_SIZE;
        }
        if (position == WebViewManager.Position.TOP_BANNER) {
            i3 = 0;
        }
        params.dragDirection = i3;
        return params;
    }

    private void showDraggableView(final WebViewManager.Position position, final RelativeLayout.LayoutParams layoutParams, final LinearLayout.LayoutParams layoutParams2, final DraggableRelativeLayout.Params params) {
        OSUtils.runOnMainUIThread(new Runnable() {
            /* class com.onesignal.InAppMessageView.AnonymousClass2 */

            public void run() {
                if (InAppMessageView.this.webView != null) {
                    InAppMessageView.this.webView.setLayoutParams(layoutParams);
                    Context applicationContext = InAppMessageView.this.currentActivity.getApplicationContext();
                    InAppMessageView.this.setUpDraggableLayout(applicationContext, layoutParams2, params);
                    InAppMessageView.this.setUpParentLinearLayout(applicationContext);
                    InAppMessageView inAppMessageView = InAppMessageView.this;
                    inAppMessageView.createPopupWindow(inAppMessageView.parentRelativeLayout);
                    if (InAppMessageView.this.messageController != null) {
                        InAppMessageView inAppMessageView2 = InAppMessageView.this;
                        inAppMessageView2.animateInAppMessage(position, inAppMessageView2.draggableRelativeLayout, InAppMessageView.this.parentRelativeLayout);
                        InAppMessageView.this.messageController.onMessageWasShown();
                    }
                    InAppMessageView.this.startDismissTimerIfNeeded();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createPopupWindow(RelativeLayout relativeLayout) {
        int i;
        int i2 = -1;
        int i3 = this.hasBackground ? -1 : this.pageWidth;
        if (!this.hasBackground) {
            i2 = -2;
        }
        PopupWindow popupWindow2 = new PopupWindow(relativeLayout, i3, i2);
        this.popupWindow = popupWindow2;
        popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow.setTouchable(true);
        if (!this.hasBackground) {
            int i4 = AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position[this.displayLocation.ordinal()];
            if (i4 == 1) {
                i = 49;
            } else if (i4 == 2) {
                i = 81;
            }
            PopupWindowCompat.setWindowLayoutType(this.popupWindow, 1003);
            this.popupWindow.showAtLocation(this.currentActivity.getWindow().getDecorView().getRootView(), i, 0, 0);
        }
        i = 0;
        PopupWindowCompat.setWindowLayoutType(this.popupWindow, 1003);
        this.popupWindow.showAtLocation(this.currentActivity.getWindow().getDecorView().getRootView(), i, 0, 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUpParentLinearLayout(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.parentRelativeLayout = relativeLayout;
        relativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        this.parentRelativeLayout.setClipChildren(false);
        this.parentRelativeLayout.setClipToPadding(false);
        this.parentRelativeLayout.addView(this.draggableRelativeLayout);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUpDraggableLayout(Context context, LinearLayout.LayoutParams layoutParams, DraggableRelativeLayout.Params params) {
        DraggableRelativeLayout draggableRelativeLayout2 = new DraggableRelativeLayout(context);
        this.draggableRelativeLayout = draggableRelativeLayout2;
        if (layoutParams != null) {
            draggableRelativeLayout2.setLayoutParams(layoutParams);
        }
        this.draggableRelativeLayout.setParams(params);
        this.draggableRelativeLayout.setListener(new DraggableRelativeLayout.DraggableListener() {
            /* class com.onesignal.InAppMessageView.AnonymousClass3 */

            @Override // com.onesignal.DraggableRelativeLayout.DraggableListener
            public void onDismiss() {
                InAppMessageView.this.finishAfterDelay(null);
            }

            @Override // com.onesignal.DraggableRelativeLayout.DraggableListener
            public void onDragStart() {
                InAppMessageView.this.isDragging = true;
            }

            @Override // com.onesignal.DraggableRelativeLayout.DraggableListener
            public void onDragEnd() {
                InAppMessageView.this.isDragging = false;
            }
        });
        if (this.webView.getParent() != null) {
            ((ViewGroup) this.webView.getParent()).removeAllViews();
        }
        CardView createCardView = createCardView(context);
        createCardView.setTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        createCardView.addView(this.webView);
        DraggableRelativeLayout draggableRelativeLayout3 = this.draggableRelativeLayout;
        int i = MARGIN_PX_SIZE;
        draggableRelativeLayout3.setPadding(i, i, i, i);
        this.draggableRelativeLayout.setClipChildren(false);
        this.draggableRelativeLayout.setClipToPadding(false);
        this.draggableRelativeLayout.addView(createCardView);
    }

    /* access modifiers changed from: package-private */
    public boolean isDragging() {
        return this.isDragging;
    }

    private CardView createCardView(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.displayLocation == WebViewManager.Position.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        if (Build.VERSION.SDK_INT == 23) {
            cardView.setCardElevation(0.0f);
        } else {
            cardView.setCardElevation((float) OSViewUtils.dpToPx(5));
        }
        cardView.setRadius((float) OSViewUtils.dpToPx(8));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        return cardView;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void startDismissTimerIfNeeded() {
        if (this.dismissDuration > 0.0d && this.scheduleDismissRunnable == null) {
            AnonymousClass4 r0 = new Runnable() {
                /* class com.onesignal.InAppMessageView.AnonymousClass4 */

                public void run() {
                    if (InAppMessageView.this.currentActivity != null) {
                        InAppMessageView.this.dismissAndAwaitNextMessage(null);
                        InAppMessageView.this.scheduleDismissRunnable = null;
                        return;
                    }
                    InAppMessageView.this.shouldDismissWhenActive = true;
                }
            };
            this.scheduleDismissRunnable = r0;
            this.handler.postDelayed(r0, ((long) this.dismissDuration) * 1000);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void delayShowUntilAvailable(final Activity activity) {
        if (!OSViewUtils.isActivityFullyReady(activity) || this.parentRelativeLayout != null) {
            new Handler().postDelayed(new Runnable() {
                /* class com.onesignal.InAppMessageView.AnonymousClass5 */

                public void run() {
                    InAppMessageView.this.delayShowUntilAvailable(activity);
                }
            }, 200);
        } else {
            showInAppMessageView(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void dismissAndAwaitNextMessage(WebViewManager.OneSignalGenericCallback oneSignalGenericCallback) {
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        if (draggableRelativeLayout2 == null) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "No host presenter to trigger dismiss animation, counting as dismissed already", new Throwable());
            dereferenceViews();
            if (oneSignalGenericCallback != null) {
                oneSignalGenericCallback.onComplete();
                return;
            }
            return;
        }
        draggableRelativeLayout2.dismiss();
        finishAfterDelay(oneSignalGenericCallback);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void finishAfterDelay(final WebViewManager.OneSignalGenericCallback oneSignalGenericCallback) {
        OSUtils.runOnMainThreadDelayed(new Runnable() {
            /* class com.onesignal.InAppMessageView.AnonymousClass6 */

            public void run() {
                if (!InAppMessageView.this.hasBackground || InAppMessageView.this.parentRelativeLayout == null) {
                    InAppMessageView.this.cleanupViewsAfterDismiss();
                    WebViewManager.OneSignalGenericCallback oneSignalGenericCallback = oneSignalGenericCallback;
                    if (oneSignalGenericCallback != null) {
                        oneSignalGenericCallback.onComplete();
                        return;
                    }
                    return;
                }
                InAppMessageView inAppMessageView = InAppMessageView.this;
                inAppMessageView.animateAndDismissLayout(inAppMessageView.parentRelativeLayout, oneSignalGenericCallback);
            }
        }, 600);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void cleanupViewsAfterDismiss() {
        removeAllViews();
        InAppMessageViewListener inAppMessageViewListener = this.messageController;
        if (inAppMessageViewListener != null) {
            inAppMessageViewListener.onMessageWasDismissed();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeAllViews() {
        OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "InAppMessageView removing views");
        Runnable runnable = this.scheduleDismissRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.scheduleDismissRunnable = null;
        }
        DraggableRelativeLayout draggableRelativeLayout2 = this.draggableRelativeLayout;
        if (draggableRelativeLayout2 != null) {
            draggableRelativeLayout2.removeAllViews();
        }
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
        dereferenceViews();
    }

    private void dereferenceViews() {
        this.parentRelativeLayout = null;
        this.draggableRelativeLayout = null;
        this.webView = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void animateInAppMessage(WebViewManager.Position position, View view, View view2) {
        CardView cardView = (CardView) view.findViewWithTag(IN_APP_MESSAGE_CARD_VIEW_TAG);
        Animation.AnimationListener createAnimationListenerForAndroidApi23Elevation = Build.VERSION.SDK_INT == 23 ? createAnimationListenerForAndroidApi23Elevation(cardView) : null;
        int i = AnonymousClass9.$SwitchMap$com$onesignal$WebViewManager$Position[position.ordinal()];
        if (i == 1) {
            animateTop(cardView, this.webView.getHeight(), createAnimationListenerForAndroidApi23Elevation);
        } else if (i == 2) {
            animateBottom(cardView, this.webView.getHeight(), createAnimationListenerForAndroidApi23Elevation);
        } else if (i == 3 || i == 4) {
            animateCenter(view, view2, createAnimationListenerForAndroidApi23Elevation, null);
        }
    }

    private Animation.AnimationListener createAnimationListenerForAndroidApi23Elevation(final CardView cardView) {
        return new Animation.AnimationListener() {
            /* class com.onesignal.InAppMessageView.AnonymousClass7 */

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                cardView.setCardElevation((float) OSViewUtils.dpToPx(5));
            }
        };
    }

    private void animateTop(View view, int i, Animation.AnimationListener animationListener) {
        OneSignalAnimate.animateViewByTranslation(view, (float) ((-i) - MARGIN_PX_SIZE), 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener).start();
    }

    private void animateBottom(View view, int i, Animation.AnimationListener animationListener) {
        OneSignalAnimate.animateViewByTranslation(view, (float) (i + MARGIN_PX_SIZE), 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener).start();
    }

    private void animateCenter(View view, View view2, Animation.AnimationListener animationListener, Animator.AnimatorListener animatorListener) {
        Animation animateViewSmallToLarge = OneSignalAnimate.animateViewSmallToLarge(view, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), animationListener);
        ValueAnimator animateBackgroundColor = animateBackgroundColor(view2, 400, ACTIVITY_BACKGROUND_COLOR_EMPTY, ACTIVITY_BACKGROUND_COLOR_FULL, animatorListener);
        animateViewSmallToLarge.start();
        animateBackgroundColor.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void animateAndDismissLayout(View view, final WebViewManager.OneSignalGenericCallback oneSignalGenericCallback) {
        animateBackgroundColor(view, 400, ACTIVITY_BACKGROUND_COLOR_FULL, ACTIVITY_BACKGROUND_COLOR_EMPTY, new AnimatorListenerAdapter() {
            /* class com.onesignal.InAppMessageView.AnonymousClass8 */

            public void onAnimationEnd(Animator animator) {
                InAppMessageView.this.cleanupViewsAfterDismiss();
                WebViewManager.OneSignalGenericCallback oneSignalGenericCallback = oneSignalGenericCallback;
                if (oneSignalGenericCallback != null) {
                    oneSignalGenericCallback.onComplete();
                }
            }
        }).start();
    }

    private ValueAnimator animateBackgroundColor(View view, int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        return OneSignalAnimate.animateViewColor(view, i, i2, i3, animatorListener);
    }
}
