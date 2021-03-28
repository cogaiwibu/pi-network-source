package com.tapjoy;

import com.tapjoy.internal.jq;
import java.io.Serializable;

public class TJPlacementData implements Serializable {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private String i;
    private int j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private String o;
    private boolean p = true;
    private boolean q = false;

    public TJPlacementData(String str, String str2) {
        setKey(str);
        updateUrl(str2);
        setPlacementType(TapjoyConstants.TJC_APP_PLACEMENT);
    }

    public TJPlacementData(String str, String str2, String str3) {
        setBaseURL(str);
        setHttpResponse(str2);
        this.n = str3;
        this.p = false;
        setPlacementType(TapjoyConstants.TJC_APP_PLACEMENT);
    }

    public void resetPlacementRequestData() {
        setHttpResponse(null);
        setHttpStatusCode(0);
        setRedirectURL(null);
        setHasProgressSpinner(false);
        setPrerenderingRequested(false);
        setPreloadDisabled(false);
        setContentViewId(null);
    }

    public String getCallbackID() {
        return this.n;
    }

    public boolean isBaseActivity() {
        return this.p;
    }

    public void setKey(String str) {
        this.a = str;
    }

    public void setBaseURL(String str) {
        this.c = str;
    }

    public void setMediationURL(String str) {
        this.d = str;
    }

    public void setAuctionMediationURL(String str) {
        this.e = str;
    }

    public void setHttpResponse(String str) {
        this.f = str;
    }

    public void setHttpStatusCode(int i2) {
        this.g = i2;
    }

    public void setPlacementName(String str) {
        this.h = str;
    }

    public void setPlacementType(String str) {
        this.i = str;
    }

    public void setViewType(int i2) {
        this.j = i2;
    }

    public void setRedirectURL(String str) {
        this.l = str;
    }

    public void setHasProgressSpinner(boolean z) {
        this.k = z;
    }

    public void setContentViewId(String str) {
        this.o = str;
    }

    public String getUrl() {
        return this.b;
    }

    public String getKey() {
        return this.a;
    }

    public String getBaseURL() {
        return this.c;
    }

    public String getMediationURL() {
        return this.d;
    }

    public String getAuctionMediationURL() {
        return this.e;
    }

    public String getHttpResponse() {
        return this.f;
    }

    public int getHttpStatusCode() {
        return this.g;
    }

    public String getPlacementName() {
        return this.h;
    }

    public String getPlacementType() {
        return this.i;
    }

    public int getViewType() {
        return this.j;
    }

    public String getRedirectURL() {
        return this.l;
    }

    public String getContentViewId() {
        return this.o;
    }

    public boolean hasProgressSpinner() {
        return this.k;
    }

    public void setPreloadDisabled(boolean z) {
        this.q = z;
    }

    public boolean isPreloadDisabled() {
        return this.q;
    }

    public boolean isPrerenderingRequested() {
        return this.m;
    }

    public void setPrerenderingRequested(boolean z) {
        this.m = z;
    }

    public void updateUrl(String str) {
        this.b = str;
        if (!jq.c(str)) {
            setBaseURL(str.substring(0, str.indexOf(47, str.indexOf("//") + 3)));
        }
    }
}
