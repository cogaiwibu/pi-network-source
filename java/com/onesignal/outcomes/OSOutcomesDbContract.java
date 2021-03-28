package com.onesignal.outcomes;

import android.provider.BaseColumns;

class OSOutcomesDbContract {

    public static class OutcomeEventsTable implements BaseColumns {
        static final String COLUMN_NAME_IAM_IDS = "iam_ids";
        static final String COLUMN_NAME_IAM_INFLUENCE_TYPE = "iam_influence_type";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_NOTIFICATION_IDS = "notification_ids";
        static final String COLUMN_NAME_NOTIFICATION_INFLUENCE_TYPE = "notification_influence_type";
        static final String COLUMN_NAME_PARAMS = "params";
        static final String COLUMN_NAME_SESSION = "session";
        static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        static final String COLUMN_NAME_WEIGHT = "weight";
        static final String TABLE_NAME = "outcome";
    }

    OSOutcomesDbContract() {
    }

    static class CachedUniqueOutcomeTable implements BaseColumns {
        static final String COLUMN_CHANNEL_INFLUENCE_ID = "channel_influence_id";
        static final String COLUMN_CHANNEL_TYPE = "channel_type";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_NOTIFICATION_ID = "notification_id";
        static final String TABLE_NAME = "cached_unique_outcome";
        static final String TABLE_NAME_V1 = "cached_unique_outcome_notification";
        static final String TABLE_NAME_V2 = "cached_unique_outcome";

        CachedUniqueOutcomeTable() {
        }
    }
}
