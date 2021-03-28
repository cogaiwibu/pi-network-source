package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;

public class AuctionSettings {
    private ArrayList<String> disableLoadWhileShowSupportFor;
    private String mAuctionData;
    private long mAuctionRetryInterval;
    private int mAuctionSavedHistoryLimit;
    private long mAuctionTimeout;
    private boolean mCompressAuctionRequest;
    private boolean mCompressAuctionResponse;
    private boolean mIsAuctionOnShowStart;
    private boolean mIsLoadWhileShow;
    private boolean mIsProgrammatic;
    private int mMaxTrials;
    private long mMinTimeToWaitBeforeFirstAuction;
    private long mTimeToWaitBeforeAuction;
    private long mTimeToWaitBeforeLoad;
    private String mUrl;
    private int timeToDeleteOldWaterfallAfterAuction;

    AuctionSettings() {
        this.mAuctionData = "";
        this.mUrl = "";
        this.mIsProgrammatic = false;
        this.mMinTimeToWaitBeforeFirstAuction = 0;
        this.mAuctionRetryInterval = 0;
        this.mTimeToWaitBeforeAuction = 0;
        this.mTimeToWaitBeforeLoad = 0;
        this.mIsAuctionOnShowStart = true;
        this.mIsLoadWhileShow = true;
        this.disableLoadWhileShowSupportFor = new ArrayList<>();
        this.timeToDeleteOldWaterfallAfterAuction = 0;
        this.mCompressAuctionRequest = false;
        this.mCompressAuctionResponse = false;
    }

    AuctionSettings(String str, String str2, int i, int i2, long j, boolean z, long j2, long j3, long j4, long j5, boolean z2, boolean z3, int i3, boolean z4, boolean z5) {
        this.mAuctionData = str;
        this.mUrl = str2;
        this.mMaxTrials = i;
        this.mAuctionSavedHistoryLimit = i2;
        this.mAuctionTimeout = j;
        this.mIsProgrammatic = z;
        this.mMinTimeToWaitBeforeFirstAuction = j2;
        this.mAuctionRetryInterval = j3;
        this.mTimeToWaitBeforeAuction = j4;
        this.mTimeToWaitBeforeLoad = j5;
        this.mIsAuctionOnShowStart = z2;
        this.mIsLoadWhileShow = z3;
        this.timeToDeleteOldWaterfallAfterAuction = i3;
        this.disableLoadWhileShowSupportFor = new ArrayList<>();
        this.mCompressAuctionRequest = z4;
        this.mCompressAuctionResponse = z5;
    }

    public boolean getIsProgrammatic() {
        return this.mIsProgrammatic;
    }

    public String getAuctionData() {
        return this.mAuctionData;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public long getTimeToWaitBeforeFirstAuctionMs() {
        return this.mMinTimeToWaitBeforeFirstAuction;
    }

    public long getAuctionRetryInterval() {
        return this.mAuctionRetryInterval;
    }

    public long getTimeToWaitBeforeAuctionMs() {
        return this.mTimeToWaitBeforeAuction;
    }

    public long getTimeToWaitBeforeLoadMs() {
        return this.mTimeToWaitBeforeLoad;
    }

    public boolean getIsAuctionOnShowStart() {
        return this.mIsAuctionOnShowStart;
    }

    public boolean getIsLoadWhileShow() {
        return this.mIsLoadWhileShow;
    }

    public int getNumOfMaxTrials() {
        return this.mMaxTrials;
    }

    public long getTrialsInterval() {
        return this.mAuctionTimeout;
    }

    public int getAuctionSavedHistoryLimit() {
        return this.mAuctionSavedHistoryLimit;
    }

    public ArrayList<String> getLoadWhileShowSupportArray() {
        return this.disableLoadWhileShowSupportFor;
    }

    public void addLoadWhileShowSupportProvider(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.disableLoadWhileShowSupportFor.add(str);
        }
    }

    public int getTimeToDeleteOldWaterfallAfterAuction() {
        return this.timeToDeleteOldWaterfallAfterAuction;
    }

    public boolean isCompressAuctionRequest() {
        return this.mCompressAuctionRequest;
    }

    public boolean isCompressAuctionResponse() {
        return this.mCompressAuctionResponse;
    }
}
