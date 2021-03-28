package com.onesignal.outcomes.domain;

import com.onesignal.OneSignalApiResponseHandler;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import java.util.List;
import java.util.Set;

public interface OSOutcomeEventsRepository {
    List<OSInfluence> getNotCachedUniqueOutcome(String str, List<OSInfluence> list);

    List<OSOutcomeEventParams> getSavedOutcomeEvents();

    Set<String> getUnattributedUniqueOutcomeEventsSent();

    void removeEvent(OSOutcomeEventParams oSOutcomeEventParams);

    void requestMeasureOutcomeEvent(String str, int i, OSOutcomeEventParams oSOutcomeEventParams, OneSignalApiResponseHandler oneSignalApiResponseHandler);

    void saveOutcomeEvent(OSOutcomeEventParams oSOutcomeEventParams);

    void saveUnattributedUniqueOutcomeEventsSent(Set<String> set);

    void saveUniqueOutcomeNotifications(OSOutcomeEventParams oSOutcomeEventParams);
}
