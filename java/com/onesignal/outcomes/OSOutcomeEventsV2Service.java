package com.onesignal.outcomes;

import com.onesignal.OneSignalAPIClient;
import com.onesignal.OneSignalApiResponseHandler;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class OSOutcomeEventsV2Service extends OSOutcomeEventsClient {
    OSOutcomeEventsV2Service(OneSignalAPIClient oneSignalAPIClient) {
        super(oneSignalAPIClient);
    }

    @Override // com.onesignal.outcomes.OSOutcomeEventsClient, com.onesignal.outcomes.domain.OutcomeEventsService
    public void sendOutcomeEvent(JSONObject jSONObject, OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        this.client.post("outcomes/measure_sources", jSONObject, oneSignalApiResponseHandler);
    }
}
