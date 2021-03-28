package com.onesignal.outcomes;

import com.onesignal.OSLogger;
import com.onesignal.OneSignalApiResponseHandler;
import com.onesignal.outcomes.domain.OutcomeEventsService;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import com.tapjoy.TapjoyConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSOutcomeEventsV2Repository extends OSOutcomeEventsRepository {
    OSOutcomeEventsV2Repository(OSLogger oSLogger, OSOutcomeEventsCache oSOutcomeEventsCache, OutcomeEventsService outcomeEventsService) {
        super(oSLogger, oSOutcomeEventsCache, outcomeEventsService);
    }

    @Override // com.onesignal.outcomes.OSOutcomeEventsRepository, com.onesignal.outcomes.domain.OSOutcomeEventsRepository
    public void requestMeasureOutcomeEvent(String str, int i, OSOutcomeEventParams oSOutcomeEventParams, OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        try {
            JSONObject jSONObject = oSOutcomeEventParams.toJSONObject();
            jSONObject.put("app_id", str);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, i);
            this.outcomeEventsService.sendOutcomeEvent(jSONObject, oneSignalApiResponseHandler);
        } catch (JSONException e) {
            this.logger.error("Generating indirect outcome:JSON Failed.", e);
        }
    }
}
