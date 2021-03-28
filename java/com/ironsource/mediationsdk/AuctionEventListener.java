package com.ironsource.mediationsdk;

import java.util.List;
import org.json.JSONObject;

public interface AuctionEventListener {
    void onAuctionFailed(int i, String str, int i2, String str2, long j);

    void onAuctionSuccess(List<AuctionResponseItem> list, String str, AuctionResponseItem auctionResponseItem, JSONObject jSONObject, int i, long j);
}
