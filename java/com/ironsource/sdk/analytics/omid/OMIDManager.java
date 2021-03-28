package com.ironsource.sdk.analytics.omid;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.ironsrc.Omid;
import com.iab.omid.library.ironsrc.adsession.AdEvents;
import com.iab.omid.library.ironsrc.adsession.AdSession;
import com.iab.omid.library.ironsrc.adsession.AdSessionConfiguration;
import com.iab.omid.library.ironsrc.adsession.AdSessionContext;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.Partner;
import com.ironsource.sdk.WPAD.AdViewsManager;
import com.ironsource.sdk.data.SSAObj;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONObject;

public class OMIDManager {
    private static final String INVALID_OMID_IMPRESSION_OWNER_MESSAGE = "%s | Invalid OMID impressionOwner";
    private static final String INVALID_OMID_VIDEO_EVENTS_TYPE_MESSAGE = "%s | Invalid OMID videoEventsOwner";
    private static final String MISSING_OMID_IMPRESSION_OWNER_MESSAGE = "Missing OMID impressionOwner";
    private static final String MISSING_OMID_VIDEO_EVENTS_CREATIVE_TYPE_MESSAGE = "Missing OMID creativeType";
    private static final String MISSING_OMID_VIDEO_EVENTS_IMPRESSION_TYPE_MESSAGE = "Missing OMID impressionType";
    private static final String MISSING_OMID_VIDEO_EVENTS_OWNER_MESSAGE = "Missing OMID videoEventsOwner";
    private static final String MISSING_OMID_WEBVIEW_MESSAGE = "Missing OMID webview id";
    private static final String OMID_HAS_NOT_BEEN_ACTIVATED_MESSAGE = "OMID has not been activated";
    public static final String OMID_PARTNER_NAME = "Ironsrc";
    public static final String OMID_PARTNER_NAME_PROPERTY_NAME = "omidPartnerName";
    public static final String OMID_PARTNER_VERSION = "7";
    public static final String OMID_PARTNER_VERSION_PROPERTY_NAME = "omidPartnerVersion";
    private static final String OMID_SESSION_HAS_ALREADY_STARTED_MESSAGE = "OMID Session has already started";
    private static final String OMID_SESSION_HAS_NOT_STARTED_MESSAGE = "OMID Session has not started";
    public static final String OMID_VERSION_PROPERTY_NAME = "omidVersion";
    private static final String OMID_WEBVIEW_NOT_FOUND_MESSAGE = "webview not found";
    private static AdSession mAdSession;
    private static boolean mIsActivated = false;
    private static final Partner mPartner = Partner.createPartner(OMID_PARTNER_NAME, OMID_PARTNER_VERSION);

    /* access modifiers changed from: package-private */
    public static class OMIDOptions {
        private static final String AD_VIEW_ID = "adViewId";
        private static final String CREATIVE_TYPE = "creativeType";
        private static final String CUSTOM_REFERENCE_DATA = "customReferenceData";
        private static final String IMPRESSION_OWNER = "impressionOwner";
        private static final String IMPRESSION_TYPE = "impressionType";
        private static final String ISOLATE_VERIFICATION_SCRIPTS = "isolateVerificationScripts";
        private static final String MEDIA_EVENTS_OWNER = "mediaEventsOwner";
        private static final String SIGNAL_LOADED = "signalLoaded";
        private static final String VIDEO_EVENTS_OWNER = "videoEventsOwner";
        public String adViewId;
        public CreativeType creativeType;
        public String customReferenceData;
        public Owner impressionOwner;
        public ImpressionType impressionType;
        public boolean isolateVerificationScripts;
        public Owner mediaEventsOwner;
        public boolean signalLoaded;
        public Owner videoEventsOwner;

        private static ImpressionType getImpressionType(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString(IMPRESSION_TYPE, "");
            if (!TextUtils.isEmpty(optString)) {
                ImpressionType[] values = ImpressionType.values();
                for (ImpressionType impressionType2 : values) {
                    if (optString.equalsIgnoreCase(impressionType2.toString())) {
                        return impressionType2;
                    }
                }
                throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_VIDEO_EVENTS_CREATIVE_TYPE_MESSAGE, optString));
            }
            throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_VIDEO_EVENTS_CREATIVE_TYPE_MESSAGE, optString));
        }

        private static boolean getSignalLoaded(JSONObject jSONObject) throws IllegalArgumentException {
            return jSONObject.optBoolean(SIGNAL_LOADED, false);
        }

        private static String getViewId(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString("adViewId", "");
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
            throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_WEBVIEW_MESSAGE, optString));
        }

        private static CreativeType getCreativeType(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString(CREATIVE_TYPE, "");
            if (!TextUtils.isEmpty(optString)) {
                CreativeType[] values = CreativeType.values();
                for (CreativeType creativeType2 : values) {
                    if (optString.equalsIgnoreCase(creativeType2.toString())) {
                        return creativeType2;
                    }
                }
                throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_VIDEO_EVENTS_CREATIVE_TYPE_MESSAGE, optString));
            }
            throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_VIDEO_EVENTS_CREATIVE_TYPE_MESSAGE, optString));
        }

        private static Owner getVideoEventsOwner(JSONObject jSONObject) throws IllegalArgumentException {
            String optString = jSONObject.optString(VIDEO_EVENTS_OWNER, "");
            Owner owner = Owner.NONE;
            try {
                return Owner.valueOf(optString.toUpperCase());
            } catch (IllegalArgumentException unused) {
                return owner;
            }
        }

        public static OMIDOptions createFromJSON(JSONObject jSONObject) throws IllegalArgumentException {
            OMIDOptions oMIDOptions = new OMIDOptions();
            oMIDOptions.isolateVerificationScripts = jSONObject.optBoolean(ISOLATE_VERIFICATION_SCRIPTS, false);
            String optString = jSONObject.optString(IMPRESSION_OWNER, "");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    oMIDOptions.impressionOwner = Owner.valueOf(optString.toUpperCase());
                    String optString2 = jSONObject.optString(VIDEO_EVENTS_OWNER, "");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            oMIDOptions.videoEventsOwner = Owner.valueOf(optString2.toUpperCase());
                            oMIDOptions.customReferenceData = jSONObject.optString(CUSTOM_REFERENCE_DATA, "");
                            oMIDOptions.creativeType = getCreativeType(jSONObject);
                            oMIDOptions.impressionType = getImpressionType(jSONObject);
                            oMIDOptions.adViewId = getViewId(jSONObject);
                            getSignalLoaded(jSONObject);
                            oMIDOptions.mediaEventsOwner = getVideoEventsOwner(jSONObject);
                            return oMIDOptions;
                        } catch (IllegalArgumentException unused) {
                            throw new IllegalArgumentException(String.format(OMIDManager.INVALID_OMID_VIDEO_EVENTS_TYPE_MESSAGE, optString2));
                        }
                    } else {
                        throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_VIDEO_EVENTS_OWNER_MESSAGE, optString2));
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new IllegalArgumentException(String.format(OMIDManager.INVALID_OMID_IMPRESSION_OWNER_MESSAGE, optString));
                }
            } else {
                throw new IllegalArgumentException(String.format(OMIDManager.MISSING_OMID_IMPRESSION_OWNER_MESSAGE, optString));
            }
        }
    }

    public static void activate(Context context) throws IllegalArgumentException {
        if (!mIsActivated) {
            Omid.activate(context);
            mIsActivated = true;
        }
    }

    public static SSAObj getOMIDData() {
        SSAObj sSAObj = new SSAObj();
        sSAObj.put(SDKUtils.encodeString("omidVersion"), SDKUtils.encodeString(Omid.getVersion()));
        sSAObj.put(SDKUtils.encodeString(OMID_PARTNER_NAME_PROPERTY_NAME), SDKUtils.encodeString(OMID_PARTNER_NAME));
        sSAObj.put(SDKUtils.encodeString("omidPartnerVersion"), SDKUtils.encodeString(OMID_PARTNER_VERSION));
        return sSAObj;
    }

    public static void startSession(JSONObject jSONObject, WebView webView) throws IllegalStateException, IllegalArgumentException {
        startSession(OMIDOptions.createFromJSON(jSONObject), webView);
    }

    public static void startSession(OMIDOptions oMIDOptions, WebView webView) throws IllegalStateException, IllegalArgumentException {
        if (!mIsActivated) {
            throw new IllegalStateException(OMID_HAS_NOT_BEEN_ACTIVATED_MESSAGE);
        } else if (mAdSession != null) {
            throw new IllegalStateException(OMID_SESSION_HAS_ALREADY_STARTED_MESSAGE);
        } else if (TextUtils.isEmpty(oMIDOptions.adViewId) || (webView = AdViewsManager.getInstance().getAdViewById(oMIDOptions.adViewId)) != null) {
            AdSession createSession = createSession(oMIDOptions, webView);
            mAdSession = createSession;
            createSession.start();
        } else {
            throw new IllegalStateException(OMID_WEBVIEW_NOT_FOUND_MESSAGE);
        }
    }

    private static AdSession createSession(OMIDOptions oMIDOptions, WebView webView) throws IllegalArgumentException {
        AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(oMIDOptions.creativeType, oMIDOptions.impressionType, oMIDOptions.impressionOwner, oMIDOptions.videoEventsOwner, oMIDOptions.isolateVerificationScripts), AdSessionContext.createHtmlAdSessionContext(mPartner, webView, null, oMIDOptions.customReferenceData));
        createAdSession.registerAdView(webView);
        return createAdSession;
    }

    public static void finishSession() throws IllegalStateException {
        assertAdSession();
        mAdSession.finish();
        mAdSession = null;
    }

    public static void impressionOccurred(JSONObject jSONObject) throws IllegalArgumentException, IllegalStateException {
        assertAdSession();
        AdEvents createAdEvents = AdEvents.createAdEvents(mAdSession);
        try {
            if (((Boolean) jSONObject.get("signalLoaded")).booleanValue()) {
                createAdEvents.loaded();
            }
        } catch (Exception unused) {
        }
        createAdEvents.impressionOccurred();
    }

    private static void assertAdSession() throws IllegalStateException {
        if (!mIsActivated) {
            throw new IllegalStateException(OMID_HAS_NOT_BEEN_ACTIVATED_MESSAGE);
        } else if (mAdSession == null) {
            throw new IllegalStateException(OMID_SESSION_HAS_NOT_STARTED_MESSAGE);
        }
    }
}
