package com.ironsource.sdk.data;

public class AdUnitsReady extends SSAObj {
    private static String FIRST_CAMPAIGN_CREDITS = "firstCampaignCredits";
    private static String NUM_OF_AD_UNITS = "numOfAdUnits";
    private static String PRODUCT_TYPE = "productType";
    private static String TOTAL_NUMBER_CREDITS = "totalNumberCredits";
    private static String TYPE = "type";
    private String mFirstCampaignCredits;
    private String mNumOfAdUnits;
    private boolean mNumOfAdUnitsExist;
    private String mProductType;
    private String mTotalNumberCredits;
    private String mType;

    public AdUnitsReady(String str) {
        super(str);
        if (containsKey(TYPE)) {
            setType(getString(TYPE));
        }
        if (containsKey(NUM_OF_AD_UNITS)) {
            setNumOfAdUnits(getString(NUM_OF_AD_UNITS));
            setNumOfAdUnitsExist(true);
        } else {
            setNumOfAdUnitsExist(false);
        }
        if (containsKey(FIRST_CAMPAIGN_CREDITS)) {
            setFirstCampaignCredits(getString(FIRST_CAMPAIGN_CREDITS));
        }
        if (containsKey(TOTAL_NUMBER_CREDITS)) {
            setTotalNumberCredits(getString(TOTAL_NUMBER_CREDITS));
        }
        if (containsKey(PRODUCT_TYPE)) {
            setProductType(getString(PRODUCT_TYPE));
        }
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getNumOfAdUnits() {
        return this.mNumOfAdUnits;
    }

    public void setNumOfAdUnits(String str) {
        this.mNumOfAdUnits = str;
    }

    public String getFirstCampaignCredits() {
        return this.mFirstCampaignCredits;
    }

    public void setFirstCampaignCredits(String str) {
        this.mFirstCampaignCredits = str;
    }

    public String getTotalNumberCredits() {
        return this.mTotalNumberCredits;
    }

    public void setTotalNumberCredits(String str) {
        this.mTotalNumberCredits = str;
    }

    private void setNumOfAdUnitsExist(boolean z) {
        this.mNumOfAdUnitsExist = z;
    }

    public boolean isNumOfAdUnitsExist() {
        return this.mNumOfAdUnitsExist;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public void setProductType(String str) {
        this.mProductType = str;
    }
}
