package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BannerUtils {

    interface CreateCandidatesListener {
        void onFinish(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    /* access modifiers changed from: package-private */
    public interface VerifyBannerListener {
        void failed(String str);

        void success();
    }

    static boolean isBannerLayoutReady(IronSourceBannerLayout ironSourceBannerLayout) {
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    static void verifyLoadBanner(IronSourceBannerLayout ironSourceBannerLayout, BannerPlacement bannerPlacement, VerifyBannerListener verifyBannerListener) {
        String str;
        if (!isBannerLayoutReady(ironSourceBannerLayout)) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        } else {
            str = null;
        }
        if (bannerPlacement == null || TextUtils.isEmpty(bannerPlacement.getPlacementName())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = bannerPlacement == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
        }
        if (!TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error(str);
            verifyBannerListener.failed(str);
            return;
        }
        verifyBannerListener.success();
    }

    static void verifyDestroyBanner(IronSourceBannerLayout ironSourceBannerLayout, VerifyBannerListener verifyBannerListener) {
        if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            verifyBannerListener.failed(String.format("can't destroy banner - %s", objArr));
            return;
        }
        verifyBannerListener.success();
    }

    static long getTimeToWaitBeforeFirstAuction(long j, long j2) {
        return j2 - (new Date().getTime() - j);
    }

    static void createAuctionCandidates(String str, ConcurrentHashMap<String, ProgBannerSmash> concurrentHashMap, CreateCandidatesListener createCandidatesListener) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (!CappingManager.isBnPlacementCapped(ContextProvider.getInstance().getCurrentActiveActivity(), str)) {
            for (ProgBannerSmash progBannerSmash : concurrentHashMap.values()) {
                if (progBannerSmash.isBidder()) {
                    Map<String, Object> biddingData = progBannerSmash.getBiddingData();
                    if (biddingData != null) {
                        hashMap.put(progBannerSmash.getInstanceName(), biddingData);
                        sb.append(TapjoyAuctionFlags.AUCTION_TYPE_SECOND_PRICE + progBannerSmash.getInstanceName() + ",");
                    }
                } else if (!progBannerSmash.isBidder()) {
                    arrayList.add(progBannerSmash.getInstanceName());
                    sb.append("1" + progBannerSmash.getInstanceName() + ",");
                }
            }
        }
        createCandidatesListener.onFinish(hashMap, arrayList, sb);
    }
}
