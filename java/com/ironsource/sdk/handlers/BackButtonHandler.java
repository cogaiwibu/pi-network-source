package com.ironsource.sdk.handlers;

import android.app.Activity;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;

public class BackButtonHandler {
    public static BackButtonHandler mInstance;

    public static BackButtonHandler getInstance() {
        BackButtonHandler backButtonHandler = mInstance;
        return backButtonHandler == null ? new BackButtonHandler() : backButtonHandler;
    }

    public boolean handleBackButton(Activity activity) {
        if (AnonymousClass1.$SwitchMap$com$ironsource$sdk$data$ISNEnums$BackButtonState[IronSourceSharedPrefHelper.getSupersonicPrefHelper().getBackButtonState().ordinal()] != 3) {
            return false;
        }
        try {
            WebController webController = (WebController) IronSourceAdsPublisherAgent.getInstance(activity).getControllerManager().getController();
            if (webController == null) {
                return true;
            }
            webController.nativeNavigationPressed("back");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: com.ironsource.sdk.handlers.BackButtonHandler$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$sdk$data$ISNEnums$BackButtonState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.ironsource.sdk.data.ISNEnums$BackButtonState[] r0 = com.ironsource.sdk.data.ISNEnums.BackButtonState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.ironsource.sdk.handlers.BackButtonHandler.AnonymousClass1.$SwitchMap$com$ironsource$sdk$data$ISNEnums$BackButtonState = r0
                com.ironsource.sdk.data.ISNEnums$BackButtonState r1 = com.ironsource.sdk.data.ISNEnums.BackButtonState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.ironsource.sdk.handlers.BackButtonHandler.AnonymousClass1.$SwitchMap$com$ironsource$sdk$data$ISNEnums$BackButtonState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.sdk.data.ISNEnums$BackButtonState r1 = com.ironsource.sdk.data.ISNEnums.BackButtonState.Device     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.ironsource.sdk.handlers.BackButtonHandler.AnonymousClass1.$SwitchMap$com$ironsource$sdk$data$ISNEnums$BackButtonState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.sdk.data.ISNEnums$BackButtonState r1 = com.ironsource.sdk.data.ISNEnums.BackButtonState.Controller     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.handlers.BackButtonHandler.AnonymousClass1.<clinit>():void");
        }
    }
}
