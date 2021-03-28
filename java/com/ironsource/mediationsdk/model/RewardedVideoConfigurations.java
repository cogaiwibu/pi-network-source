package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.AuctionSettings;
import java.util.ArrayList;
import java.util.Iterator;

public class RewardedVideoConfigurations {
    private static final int DEFAULT_RV_PLACEMENT_ID = 0;
    private String mBackFillProviderName;
    private Placement mDefaultRVPlacement;
    private int mExpiredDurationInMinutes;
    private int mManualLoadIntervalInSeconds;
    private String mPremiumProviderName;
    private int mRVAdaptersSmartLoadAmount;
    private int mRVAdaptersTimeoutInSeconds;
    private boolean mRVAdvancedLoading;
    private AuctionSettings mRVAuctionSettings;
    private ApplicationEvents mRVEvents;
    private ArrayList<Placement> mRVPlacements;

    public RewardedVideoConfigurations() {
        this.mRVPlacements = new ArrayList<>();
        this.mRVEvents = new ApplicationEvents();
    }

    public RewardedVideoConfigurations(int i, boolean z, int i2, int i3, int i4, ApplicationEvents applicationEvents, AuctionSettings auctionSettings) {
        this.mRVPlacements = new ArrayList<>();
        this.mRVAdaptersSmartLoadAmount = i;
        this.mRVAdvancedLoading = z;
        this.mRVAdaptersTimeoutInSeconds = i2;
        this.mManualLoadIntervalInSeconds = i3;
        this.mRVEvents = applicationEvents;
        this.mExpiredDurationInMinutes = i4;
        this.mRVAuctionSettings = auctionSettings;
    }

    public int getRewardedVideoAdaptersSmartLoadTimeout() {
        return this.mRVAdaptersTimeoutInSeconds;
    }

    public void addRewardedVideoPlacement(Placement placement) {
        if (placement != null) {
            this.mRVPlacements.add(placement);
            if (this.mDefaultRVPlacement == null) {
                this.mDefaultRVPlacement = placement;
            } else if (placement.getPlacementId() == 0) {
                this.mDefaultRVPlacement = placement;
            }
        }
    }

    public Placement getRewardedVideoPlacement(String str) {
        Iterator<Placement> it = this.mRVPlacements.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public Placement getDefaultRewardedVideoPlacement() {
        Iterator<Placement> it = this.mRVPlacements.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.mDefaultRVPlacement;
    }

    public int getRewardedVideoAdaptersSmartLoadAmount() {
        return this.mRVAdaptersSmartLoadAmount;
    }

    public boolean getRewardedVideoAdvancedLoading() {
        return this.mRVAdvancedLoading;
    }

    public int getManualLoadIntervalInSeconds() {
        return this.mManualLoadIntervalInSeconds;
    }

    public ApplicationEvents getRewardedVideoEventsConfigurations() {
        return this.mRVEvents;
    }

    public String getBackFillProviderName() {
        return this.mBackFillProviderName;
    }

    public void setBackFillProviderName(String str) {
        this.mBackFillProviderName = str;
    }

    public String getPremiumProviderName() {
        return this.mPremiumProviderName;
    }

    public void setPremiumProviderName(String str) {
        this.mPremiumProviderName = str;
    }

    public AuctionSettings getRewardedVideoAuctionSettings() {
        return this.mRVAuctionSettings;
    }

    public int getExpiredDurationInMinutes() {
        return this.mExpiredDurationInMinutes;
    }
}
