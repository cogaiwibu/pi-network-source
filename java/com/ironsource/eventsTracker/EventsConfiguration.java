package com.ironsource.eventsTracker;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public final class EventsConfiguration {
    private boolean allowLogs = false;
    private boolean areEventsEnabled;
    private String endpoint;
    private IFormatter formatter;
    private ArrayList<Pair<String, String>> headers;
    private String httpMethod;

    EventsConfiguration(Builder builder) {
        this.endpoint = builder.endpoint;
        this.areEventsEnabled = builder.areEventEnabled;
        this.httpMethod = builder.httpMethod;
        this.formatter = builder.formatter;
        this.allowLogs = builder.allowLogs;
        if (builder.headers != null) {
            this.headers = new ArrayList<>(builder.headers);
        }
    }

    public boolean areEventsEnabled() {
        return this.areEventsEnabled;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public IFormatter getFormatter() {
        return this.formatter;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public boolean isAllowLogs() {
        return this.allowLogs;
    }

    public ArrayList<Pair<String, String>> getHeaders() {
        return new ArrayList<>(this.headers);
    }

    public static class Builder {
        private boolean allowLogs = false;
        private boolean areEventEnabled = false;
        private String endpoint = "";
        private IFormatter formatter;
        private ArrayList<Pair<String, String>> headers = new ArrayList<>();
        private String httpMethod = NativeEventsConstants.HTTP_METHOD_POST;

        public Builder(String str) {
            if (str != null && !str.isEmpty()) {
                this.endpoint = str;
            }
        }

        public Builder setEnableEvents(boolean z) {
            this.areEventEnabled = z;
            return this;
        }

        public Builder setHttpMethodGet() {
            this.httpMethod = NativeEventsConstants.HTTP_METHOD_GET;
            return this;
        }

        public Builder setHttpMethodPost() {
            this.httpMethod = NativeEventsConstants.HTTP_METHOD_POST;
            return this;
        }

        public Builder setFormatter(IFormatter iFormatter) {
            this.formatter = iFormatter;
            return this;
        }

        public Builder addHeader(Pair<String, String> pair) {
            this.headers.add(pair);
            return this;
        }

        public Builder addHeaders(List<Pair<String, String>> list) {
            this.headers.addAll(list);
            return this;
        }

        public Builder setAllowLogs(boolean z) {
            this.allowLogs = z;
            return this;
        }

        public EventsConfiguration build() {
            return new EventsConfiguration(this);
        }
    }
}
