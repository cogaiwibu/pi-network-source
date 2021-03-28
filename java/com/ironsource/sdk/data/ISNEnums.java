package com.ironsource.sdk.data;

public class ISNEnums {

    public enum BackButtonState {
        None,
        Device,
        Controller
    }

    public enum ControllerState {
        None,
        Loaded,
        Ready,
        Failed
    }

    public enum ControllerType {
        Web,
        Native
    }

    public enum ProductType {
        Banner,
        OfferWall,
        Interstitial,
        OfferWallCredits,
        RewardedVideo
    }

    public enum DebugMode {
        MODE_0(0),
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);
        
        private int value;

        private DebugMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
