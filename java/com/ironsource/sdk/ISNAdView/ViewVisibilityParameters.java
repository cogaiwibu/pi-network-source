package com.ironsource.sdk.ISNAdView;

import java.util.HashMap;
import org.json.JSONObject;

public class ViewVisibilityParameters {
    private int mVisibility = 4;
    private HashMap<String, Boolean> mVisibilityParametersMap = new HashMap<String, Boolean>() {
        /* class com.ironsource.sdk.ISNAdView.ViewVisibilityParameters.AnonymousClass1 */

        {
            boolean z = true;
            put(ISNAdViewConstants.IS_VISIBLE_KEY, Boolean.valueOf(ViewVisibilityParameters.this.mVisibility == 0));
            put(ISNAdViewConstants.IS_WINDOW_VISIBLE_KEY, Boolean.valueOf(ViewVisibilityParameters.this.mWindowVisibility != 0 ? false : z));
            put(ISNAdViewConstants.IS_SHOWN_KEY, false);
            put(ISNAdViewConstants.IS_VIEW_VISIBLE, false);
        }
    };
    private int mWindowVisibility = 4;

    ViewVisibilityParameters() {
    }

    /* access modifiers changed from: package-private */
    public void updateViewVisibilityParameters(String str, int i, boolean z) {
        boolean z2 = true;
        if (this.mVisibilityParametersMap.containsKey(str)) {
            this.mVisibilityParametersMap.put(str, Boolean.valueOf(i == 0));
        }
        this.mVisibilityParametersMap.put(ISNAdViewConstants.IS_SHOWN_KEY, Boolean.valueOf(z));
        if ((!this.mVisibilityParametersMap.get(ISNAdViewConstants.IS_WINDOW_VISIBLE_KEY).booleanValue() && !this.mVisibilityParametersMap.get(ISNAdViewConstants.IS_VISIBLE_KEY).booleanValue()) || !this.mVisibilityParametersMap.get(ISNAdViewConstants.IS_SHOWN_KEY).booleanValue()) {
            z2 = false;
        }
        this.mVisibilityParametersMap.put(ISNAdViewConstants.IS_VIEW_VISIBLE, Boolean.valueOf(z2));
    }

    public JSONObject collectVisibilityParameters() {
        return new JSONObject(this.mVisibilityParametersMap);
    }
}
