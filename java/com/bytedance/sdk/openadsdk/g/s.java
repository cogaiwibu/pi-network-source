package com.bytedance.sdk.openadsdk.g;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* compiled from: SlotUtils */
public class s {
    public static AdSlot a(String str) {
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static AdSlot a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        try {
            int i = jSONObject.getInt("width");
            int i2 = jSONObject.getInt("height");
            builder.setAdCount(jSONObject.getInt("adCount"));
            builder.setCodeId(jSONObject.getString("codeId"));
            builder.setImageAcceptedSize(i, i2);
            builder.setMediaExtra(jSONObject.getString("extra"));
            builder.setNativeAdType(jSONObject.getInt("adType"));
            builder.setOrientation(jSONObject.getInt("orientation"));
            builder.setRewardAmount(jSONObject.getInt(IronSourceConstants.EVENTS_REWARD_AMOUNT));
            builder.setRewardName(jSONObject.getString(IronSourceConstants.EVENTS_REWARD_NAME));
            builder.setSupportDeepLink(jSONObject.getBoolean("supportDeepLink"));
            builder.setUserID(jSONObject.getString("userId"));
        } catch (Exception unused) {
        }
        return builder.build();
    }

    public static String a(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adCount", adSlot.getAdCount());
            jSONObject.put("codeId", adSlot.getCodeId());
            jSONObject.put("width", adSlot.getImgAcceptedWidth());
            jSONObject.put("height", adSlot.getImgAcceptedHeight());
            jSONObject.put("extra", adSlot.getMediaExtra());
            jSONObject.put("adType", adSlot.getNativeAdType());
            jSONObject.put("orientation", adSlot.getOrientation());
            jSONObject.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, adSlot.getRewardAmount());
            jSONObject.put(IronSourceConstants.EVENTS_REWARD_NAME, adSlot.getRewardName());
            jSONObject.put("supportDeepLink", adSlot.isSupportDeepLink());
            jSONObject.put("userId", adSlot.getUserID());
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }
}
