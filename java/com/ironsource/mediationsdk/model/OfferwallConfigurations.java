package com.ironsource.mediationsdk.model;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class OfferwallConfigurations {
    private static final String ADAPTER_NAME = "adapterName";
    private static final int DEFAULT_OW_PLACEMENT_ID = 0;
    private OfferwallPlacement mDefaultOWPlacement;
    private ApplicationEvents mEvents;
    private ArrayList<OfferwallPlacement> mOWPlacements = new ArrayList<>();
    private JSONObject mOWSection;

    public OfferwallConfigurations(ApplicationEvents applicationEvents) {
        this.mEvents = applicationEvents;
    }

    public void addOfferwallPlacement(OfferwallPlacement offerwallPlacement) {
        if (offerwallPlacement != null) {
            this.mOWPlacements.add(offerwallPlacement);
            if (this.mDefaultOWPlacement == null) {
                this.mDefaultOWPlacement = offerwallPlacement;
            } else if (offerwallPlacement.getPlacementId() == 0) {
                this.mDefaultOWPlacement = offerwallPlacement;
            }
        }
    }

    public OfferwallPlacement getOfferwallPlacement(String str) {
        Iterator<OfferwallPlacement> it = this.mOWPlacements.iterator();
        while (it.hasNext()) {
            OfferwallPlacement next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public OfferwallPlacement getDefaultOfferwallPlacement() {
        Iterator<OfferwallPlacement> it = this.mOWPlacements.iterator();
        while (it.hasNext()) {
            OfferwallPlacement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.mDefaultOWPlacement;
    }

    public ApplicationEvents getOfferWallEventsConfigurations() {
        return this.mEvents;
    }

    public String getOfferWallAdapterName() {
        JSONObject jSONObject = this.mOWSection;
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString(ADAPTER_NAME))) ? IronSourceConstants.SUPERSONIC_CONFIG_NAME : this.mOWSection.optString(ADAPTER_NAME);
    }

    public void setOfferWallSection(JSONObject jSONObject) {
        this.mOWSection = jSONObject;
    }
}
