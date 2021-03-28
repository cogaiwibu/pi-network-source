package com.onesignal.outcomes.model;

import com.onesignal.influence.model.OSInfluenceChannel;

public class OSCachedUniqueOutcome {
    private OSInfluenceChannel channel;
    private String influenceId;

    public OSCachedUniqueOutcome(String str, OSInfluenceChannel oSInfluenceChannel) {
        this.influenceId = str;
        this.channel = oSInfluenceChannel;
    }

    public String getInfluenceId() {
        return this.influenceId;
    }

    public OSInfluenceChannel getChannel() {
        return this.channel;
    }
}
