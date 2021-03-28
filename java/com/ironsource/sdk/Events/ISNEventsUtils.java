package com.ironsource.sdk.Events;

import android.content.Context;
import android.util.Pair;
import com.ironsource.eventsTracker.EventsConfiguration;
import com.ironsource.sdk.Events.ISNEventsBaseData;
import com.ironsource.sdk.constants.Events;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.ISNEnums;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public class ISNEventsUtils {
    public static ISNEventsBaseData createEventsBaseData(Context context, String str, String str2, Map<String, String> map) throws Exception {
        ISNEventsBaseData.Builder builder = new ISNEventsBaseData.Builder();
        if (map != null && map.containsKey(Events.SESSION_ID)) {
            builder.setSessionId(map.get(Events.SESSION_ID));
        }
        builder.setContext(context);
        return builder.setUserId(str).setApplicationKey(str2).build();
    }

    public static EventsConfiguration createConfigurations(JSONObject jSONObject) {
        return new EventsConfiguration.Builder(jSONObject.optString(Events.END_POINT)).setHttpMethodGet().setEnableEvents(jSONObject.optBoolean("enabled")).setFormatter(new ISNEventsFormatter()).addHeaders(createHeaders()).setAllowLogs(false).build();
    }

    private static ArrayList<Pair<String, String>> createHeaders() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>(Events.CONTENT_TYPE, Events.APP_JSON));
        arrayList.add(new Pair<>(Events.CHARSET, Events.CHARSET_FORMAT));
        return arrayList;
    }

    public static boolean getIsBiddingInstance(DemandSource demandSource) {
        if (demandSource == null || demandSource.getExtraParams().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(demandSource.getExtraParams().get("inAppBidding"));
    }

    public static ISNEnums.ProductType getProductType(DemandSource demandSource, ISNEnums.ProductType productType) {
        if (demandSource == null || demandSource.getExtraParams() == null || demandSource.getExtraParams().get("rewarded") == null) {
            return productType;
        }
        return Boolean.parseBoolean(demandSource.getExtraParams().get("rewarded")) ? ISNEnums.ProductType.RewardedVideo : ISNEnums.ProductType.Interstitial;
    }
}
