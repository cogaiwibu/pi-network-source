package com.ironsource.sdk.controller;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.ironsource.sdk.Events.ISNEventParams;
import com.ironsource.sdk.Events.ISNEventsTracker;
import com.ironsource.sdk.Events.ISNEventsUtils;
import com.ironsource.sdk.Events.SDK5Events;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.data.ISNError;
import com.ironsource.sdk.listeners.OnNetworkSDKInitListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.internals.DSBannerListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import com.ironsource.sdk.service.TokenService;
import com.ironsource.sdk.utils.Logger;
import java.util.Map;
import org.json.JSONObject;

public class ControllerManager implements ControllerEventListener, IronSourceController {
    private static final Handler mUiHandler = new Handler(Looper.getMainLooper());
    private final String TAG = ControllerManager.class.getSimpleName();
    private final CommandExecutor mCommandExecutor = new CommandExecutor("NativeCommandExecutor");
    private IronSourceController mController;
    private final CommandExecutor mControllerCommandsExecutor = new CommandExecutor("ControllerCommandsExecutor");
    private ISNEnums.ControllerState mControllerState = ISNEnums.ControllerState.None;
    private CountDownTimer mGlobalControllerTimer;

    @Override // com.ironsource.sdk.controller.IronSourceController
    @Deprecated
    public void restoreSavedState() {
    }

    public ControllerManager(Context context, ContextProvider contextProvider, TokenService tokenService, DemandSourceManager demandSourceManager) {
        createController(context, contextProvider, tokenService, demandSourceManager);
    }

    private void createController(final Context context, final ContextProvider contextProvider, final TokenService tokenService, final DemandSourceManager demandSourceManager) {
        mUiHandler.post(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass1 */

            public void run() {
                try {
                    ControllerManager.this.mController = ControllerManager.this.createWebController(context, contextProvider, tokenService, demandSourceManager);
                    ControllerManager.this.mGlobalControllerTimer = new CountDownTimer(200000, 1000) {
                        /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass1.AnonymousClass1 */

                        public void onTick(long j) {
                            String str = ControllerManager.this.TAG;
                            Logger.i(str, "Global Controller Timer Tick " + j);
                        }

                        public void onFinish() {
                            Logger.i(ControllerManager.this.TAG, "Global Controller Timer Finish");
                            ControllerManager.this.destroyWebControllerIfExist();
                            ControllerManager.mUiHandler.post(new Runnable() {
                                /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    ControllerManager.this.createNativeController(Constants.ErrorCodes.CONTROLLER_HTML_DOWNLOAD_TIMEOUT);
                                }
                            });
                        }
                    }.start();
                    ((WebController) ControllerManager.this.mController).downloadController();
                    ControllerManager.this.mCommandExecutor.setReady();
                    ControllerManager.this.mCommandExecutor.purgeDelayedCommands();
                } catch (Exception e) {
                    ControllerManager.this.createNativeController(Log.getStackTraceString(e));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private WebController createWebController(Context context, ContextProvider contextProvider, TokenService tokenService, DemandSourceManager demandSourceManager) throws Exception {
        ISNEventsTracker.logEvent(SDK5Events.createControllerWeb);
        WebController webController = new WebController(context, demandSourceManager, contextProvider, this);
        webController.addTokenJSInterface(new TokenJSAdapter(context, tokenService));
        webController.addOmidJSInterface(new OMIDJSAdapter(context));
        webController.addPermissionsJSInterface(new PermissionsJSAdapter(context));
        webController.addBannerJSInterface(new BannerJSAdapter());
        webController.addDeviceDataJSInterface(new DeviceDataJSAdapter(context));
        webController.addAdViewsJSInterface(new AdViewsJSAdapter(contextProvider));
        return webController;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void destroyWebControllerIfExist() {
        IronSourceController ironSourceController = this.mController;
        if (ironSourceController != null) {
            ironSourceController.destroy();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void createNativeController(String str) {
        ISNEventsTracker.logEvent(SDK5Events.createControllerNative, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, str).getData());
        NativeController nativeController = new NativeController(this);
        this.mController = nativeController;
        nativeController.setFailedControllerReason(str);
        this.mCommandExecutor.setReady();
        this.mCommandExecutor.purgeDelayedCommands();
    }

    private boolean isControllerStateReady() {
        return ISNEnums.ControllerState.Ready.equals(this.mControllerState);
    }

    public void executeCommand(Runnable runnable) {
        this.mCommandExecutor.executeCommand(runnable);
    }

    @Override // com.ironsource.sdk.controller.ControllerEventListener
    public void handleControllerLoaded() {
        this.mControllerState = ISNEnums.ControllerState.Loaded;
    }

    @Override // com.ironsource.sdk.controller.ControllerEventListener
    public void handleControllerReady() {
        if (ISNEnums.ControllerType.Web.equals(getType())) {
            ISNEventsTracker.logEvent(SDK5Events.controllerStageReady);
            reportInitSDKSuccessToCaller();
        }
        handleReadyState();
    }

    private void handleReadyState() {
        this.mControllerState = ISNEnums.ControllerState.Ready;
        CountDownTimer countDownTimer = this.mGlobalControllerTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mControllerCommandsExecutor.setReady();
        this.mControllerCommandsExecutor.purgeDelayedCommands();
        this.mController.restoreSavedState();
    }

    private void reportInitSDKSuccessToCaller() {
        OnNetworkSDKInitListener initListener = IronSourceNetwork.getInitListener();
        if (initListener != null) {
            initListener.onSuccess();
        }
    }

    @Override // com.ironsource.sdk.controller.ControllerEventListener
    public void handleControllerFailed(final String str) {
        ISNEventsTracker.logEvent(SDK5Events.controllerFailed, new ISNEventParams().addPair(Events.CALL_FAILED_REASON, str).getData());
        reportInitSDKFailedToCaller(str);
        CountDownTimer countDownTimer = this.mGlobalControllerTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        destroyWebControllerIfExist();
        mUiHandler.post(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass2 */

            public void run() {
                ControllerManager.this.createNativeController(str);
            }
        });
    }

    private void reportInitSDKFailedToCaller(String str) {
        OnNetworkSDKInitListener initListener = IronSourceNetwork.getInitListener();
        if (initListener != null) {
            initListener.onFail(new ISNError(1001, str));
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public ISNEnums.ControllerType getType() {
        return this.mController.getType();
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initOfferWall(final String str, final String str2, final Map<String, String> map, final OnOfferWallListener onOfferWallListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass3 */

            public void run() {
                ControllerManager.this.mController.initOfferWall(str, str2, map, onOfferWallListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showOfferWall(final Map<String, String> map) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass4 */

            public void run() {
                ControllerManager.this.mController.showOfferWall(map);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void getOfferWallCredits(final String str, final String str2, final OnOfferWallListener onOfferWallListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass5 */

            public void run() {
                ControllerManager.this.mController.getOfferWallCredits(str, str2, onOfferWallListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initRewardedVideo(final String str, final String str2, final DemandSource demandSource, final DSRewardedVideoListener dSRewardedVideoListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass6 */

            public void run() {
                ControllerManager.this.mController.initRewardedVideo(str, str2, demandSource, dSRewardedVideoListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showRewardedVideo(final JSONObject jSONObject, final DSRewardedVideoListener dSRewardedVideoListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass7 */

            public void run() {
                ControllerManager.this.mController.showRewardedVideo(jSONObject, dSRewardedVideoListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initInterstitial(final String str, final String str2, final DemandSource demandSource, final DSInterstitialListener dSInterstitialListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass8 */

            public void run() {
                ControllerManager.this.mController.initInterstitial(str, str2, demandSource, dSInterstitialListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadInterstitial(final String str, final DSInterstitialListener dSInterstitialListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass9 */

            public void run() {
                ControllerManager.this.mController.loadInterstitial(str, dSInterstitialListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadInterstitial(final DemandSource demandSource, final Map<String, String> map, final DSInterstitialListener dSInterstitialListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass10 */

            public void run() {
                ISNEventsTracker.logEvent(SDK5Events.loadProduct, new ISNEventParams().addPair(Events.DEMAND_SOURCE_NAME, demandSource.getDemandSourceName()).addPair(Events.PRODUCT_TYPE, ISNEventsUtils.getProductType(demandSource, ISNEnums.ProductType.Interstitial)).addPair(Events.IS_BIDDING_INSTANCE, Boolean.valueOf(ISNEventsUtils.getIsBiddingInstance(demandSource))).getData());
                ControllerManager.this.mController.loadInterstitial(demandSource, map, dSInterstitialListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showInterstitial(final JSONObject jSONObject, final DSInterstitialListener dSInterstitialListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass11 */

            public void run() {
                ControllerManager.this.mController.showInterstitial(jSONObject, dSInterstitialListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void showInterstitial(final DemandSource demandSource, final Map<String, String> map, final DSInterstitialListener dSInterstitialListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass12 */

            public void run() {
                ControllerManager.this.mController.showInterstitial(demandSource, map, dSInterstitialListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public boolean isInterstitialAdAvailable(String str) {
        if (!isControllerStateReady()) {
            return false;
        }
        return this.mController.isInterstitialAdAvailable(str);
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void initBanner(final String str, final String str2, final DemandSource demandSource, final DSBannerListener dSBannerListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass13 */

            public void run() {
                ControllerManager.this.mController.initBanner(str, str2, demandSource, dSBannerListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void loadBanner(final JSONObject jSONObject, final DSBannerListener dSBannerListener) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass14 */

            public void run() {
                ControllerManager.this.mController.loadBanner(jSONObject, dSBannerListener);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void updateConsentInfo(final JSONObject jSONObject) {
        this.mControllerCommandsExecutor.executeCommand(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass15 */

            public void run() {
                ControllerManager.this.mController.updateConsentInfo(jSONObject);
            }
        });
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void enterForeground() {
        if (isControllerStateReady()) {
            this.mController.enterForeground();
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void enterBackground() {
        if (isControllerStateReady()) {
            this.mController.enterBackground();
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void registerConnectionReceiver(Context context) {
        if (isControllerStateReady()) {
            this.mController.registerConnectionReceiver(context);
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void unregisterConnectionReceiver(Context context) {
        if (isControllerStateReady()) {
            this.mController.unregisterConnectionReceiver(context);
        }
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void destroy() {
        CountDownTimer countDownTimer = this.mGlobalControllerTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mGlobalControllerTimer = null;
        mUiHandler.post(new Runnable() {
            /* class com.ironsource.sdk.controller.ControllerManager.AnonymousClass16 */

            public void run() {
                if (ControllerManager.this.mController != null) {
                    ControllerManager.this.mController.destroy();
                    ControllerManager.this.mController = null;
                }
            }
        });
    }

    public IronSourceController getController() {
        return this.mController;
    }

    @Override // com.ironsource.sdk.controller.IronSourceController
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
        IronSourceController ironSourceController = this.mController;
        if (ironSourceController != null) {
            ironSourceController.setCommunicationWithAdView(iSNAdView);
        }
    }
}
