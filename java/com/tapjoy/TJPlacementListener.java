package com.tapjoy;

public interface TJPlacementListener {
    void onClick(TJPlacement tJPlacement);

    void onContentDismiss(TJPlacement tJPlacement);

    void onContentReady(TJPlacement tJPlacement);

    void onContentShow(TJPlacement tJPlacement);

    void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str);

    void onRequestFailure(TJPlacement tJPlacement, TJError tJError);

    void onRequestSuccess(TJPlacement tJPlacement);

    void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i);
}
