package com.ironsource.mediationsdk.events;

import com.ironsource.eventsmodule.EventData;
import com.onesignal.outcomes.OSOutcomeTableProvider;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OutcomeEventsFormatter extends AbstractEventsFormatter {
    private final String DEFAULT_OC_EVENTS_URL = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";

    @Override // com.ironsource.mediationsdk.events.AbstractEventsFormatter
    public String getDefaultEventsUrl() {
        return "https://outcome-ssp.supersonicads.com/mediation?adUnit=3";
    }

    @Override // com.ironsource.mediationsdk.events.AbstractEventsFormatter
    public String getFormatterType() {
        return OSOutcomeTableProvider.OUTCOME_EVENT_TABLE;
    }

    OutcomeEventsFormatter(int i) {
        this.mAdUnit = i;
    }

    @Override // com.ironsource.mediationsdk.events.AbstractEventsFormatter
    public String format(ArrayList<EventData> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.mGeneralProperties = new JSONObject();
        } else {
            this.mGeneralProperties = jSONObject;
        }
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<EventData> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject createJSONForEvent = createJSONForEvent(it.next());
                if (createJSONForEvent != null) {
                    jSONArray.put(createJSONForEvent);
                }
            }
        }
        return createDataToSend(jSONArray);
    }
}
