package com.onesignal.outcomes;

import com.onesignal.OSLogger;
import com.onesignal.OSSharedPreferences;
import com.onesignal.OneSignalAPIClient;
import com.onesignal.OneSignalDb;
import com.onesignal.outcomes.domain.OSOutcomeEventsRepository;

public class OSOutcomeEventsFactory {
    private final OneSignalAPIClient apiClient;
    private final OSLogger logger;
    private final OSOutcomeEventsCache outcomeEventsCache;
    private OSOutcomeEventsRepository repository;

    public OSOutcomeEventsFactory(OSLogger oSLogger, OneSignalAPIClient oneSignalAPIClient, OneSignalDb oneSignalDb, OSSharedPreferences oSSharedPreferences) {
        this.logger = oSLogger;
        this.apiClient = oneSignalAPIClient;
        this.outcomeEventsCache = new OSOutcomeEventsCache(oSLogger, oneSignalDb, oSSharedPreferences);
    }

    public OSOutcomeEventsRepository getRepository() {
        if (this.repository == null) {
            createRepository();
        } else {
            validateRepositoryVersion();
        }
        return this.repository;
    }

    private void validateRepositoryVersion() {
        if (!this.outcomeEventsCache.isOutcomesV2ServiceEnabled() && (this.repository instanceof OSOutcomeEventsV1Repository)) {
            return;
        }
        if (!this.outcomeEventsCache.isOutcomesV2ServiceEnabled() || !(this.repository instanceof OSOutcomeEventsV2Repository)) {
            createRepository();
        }
    }

    private void createRepository() {
        if (this.outcomeEventsCache.isOutcomesV2ServiceEnabled()) {
            this.repository = new OSOutcomeEventsV2Repository(this.logger, this.outcomeEventsCache, new OSOutcomeEventsV2Service(this.apiClient));
        } else {
            this.repository = new OSOutcomeEventsV1Repository(this.logger, this.outcomeEventsCache, new OSOutcomeEventsV1Service(this.apiClient));
        }
    }
}
