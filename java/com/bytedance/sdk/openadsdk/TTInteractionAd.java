package com.bytedance.sdk.openadsdk;

import android.app.Activity;

public interface TTInteractionAd {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();
    }

    int getInteractionType();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void showInteractionAd(Activity activity);
}
