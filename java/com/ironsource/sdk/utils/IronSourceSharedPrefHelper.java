package com.ironsource.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.data.ISNEnums;
import com.ironsource.sdk.data.SSAObj;
import com.tapjoy.TapjoyAuctionFlags;
import io.invertase.firebase.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceSharedPrefHelper {
    private static final String BACK_BUTTON_STATE = "back_button_state";
    private static final String SEARCH_KEYS = "search_keys";
    private static final String SUPERSONIC_SHARED_PREF = "supersonic_shared_preferen";
    private static final String TAG = IronSourceSharedPrefHelper.class.getSimpleName();
    private static final String VERSION = "version";
    private static IronSourceSharedPrefHelper mInstance;
    private SharedPreferences mSharedPreferences;

    private IronSourceSharedPrefHelper(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(SUPERSONIC_SHARED_PREF, 0);
    }

    public static synchronized IronSourceSharedPrefHelper getSupersonicPrefHelper(Context context) {
        IronSourceSharedPrefHelper ironSourceSharedPrefHelper;
        synchronized (IronSourceSharedPrefHelper.class) {
            if (mInstance == null) {
                mInstance = new IronSourceSharedPrefHelper(context);
            }
            ironSourceSharedPrefHelper = mInstance;
        }
        return ironSourceSharedPrefHelper;
    }

    public static synchronized IronSourceSharedPrefHelper getSupersonicPrefHelper() {
        IronSourceSharedPrefHelper ironSourceSharedPrefHelper;
        synchronized (IronSourceSharedPrefHelper.class) {
            ironSourceSharedPrefHelper = mInstance;
        }
        return ironSourceSharedPrefHelper;
    }

    public void setBackButtonState(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(BACK_BUTTON_STATE, str);
        edit.apply();
    }

    public ISNEnums.BackButtonState getBackButtonState() {
        int parseInt = Integer.parseInt(this.mSharedPreferences.getString(BACK_BUTTON_STATE, TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE));
        if (parseInt == 0) {
            return ISNEnums.BackButtonState.None;
        }
        if (parseInt == 1) {
            return ISNEnums.BackButtonState.Device;
        }
        if (parseInt == 2) {
            return ISNEnums.BackButtonState.Controller;
        }
        return ISNEnums.BackButtonState.Controller;
    }

    public void setSearchKeys(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(SEARCH_KEYS, str);
        edit.apply();
    }

    public List<String> getSearchKeys() {
        String string = this.mSharedPreferences.getString(SEARCH_KEYS, null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            SSAObj sSAObj = new SSAObj(string);
            if (sSAObj.containsKey(Constants.ParametersKeys.SEARCH_KEYS)) {
                try {
                    arrayList.addAll(sSAObj.toList((JSONArray) sSAObj.get(Constants.ParametersKeys.SEARCH_KEYS)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public boolean setUserData(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public String getUserData(String str) {
        String string = this.mSharedPreferences.getString(str, null);
        return string != null ? string : BuildConfig.FIREBASE_JSON_RAW;
    }

    public String getCurrentSDKVersion() {
        return this.mSharedPreferences.getString("version", "UN_VERSIONED");
    }

    public void setCurrentSDKVersion(String str) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString("version", str);
        edit.apply();
    }

    public String getCampaignLastUpdate(String str) {
        return this.mSharedPreferences.getString(str, null);
    }

    public void setCampaignLastUpdate(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public boolean setLatestCompletionsTime(String str, String str2, String str3) {
        String string = this.mSharedPreferences.getString("ssaUserData", null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putString("ssaUserData", jSONObject.toString());
            return edit.commit();
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
