package com.facebook.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.ads.Ad;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.NativeAdRatingApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import org.json.JSONObject;

public abstract class NativeAdBase implements Ad {
    final NativeAdBaseApi mNativeAdBaseApi;

    public enum MediaCacheFlag {
        NONE,
        ALL
    }

    public interface NativeAdLoadConfigBuilder extends Ad.LoadConfigBuilder {
        public static final int UNKNOWN_IMAGE_SIZE = -1;

        @Override // com.facebook.ads.Ad.LoadConfigBuilder
        NativeLoadAdConfig build();

        @Deprecated
        void loadAd();

        NativeAdLoadConfigBuilder withAdListener(NativeAdListener nativeAdListener);

        @Override // com.facebook.ads.Ad.LoadConfigBuilder
        NativeAdLoadConfigBuilder withBid(String str);

        NativeAdLoadConfigBuilder withMediaCacheFlag(MediaCacheFlag mediaCacheFlag);

        NativeAdLoadConfigBuilder withPreloadedIconView(int i, int i2);
    }

    public interface NativeLoadAdConfig extends Ad.LoadAdConfig {
    }

    @Deprecated
    public boolean isNativeConfigEnabled() {
        return false;
    }

    public static NativeAdBase fromBidPayload(Context context, String str, String str2) throws Exception {
        return DynamicLoaderFactory.makeLoader(context).createNativeAdBaseFromBidPayload(context, str, str2);
    }

    public static class Image {
        private final NativeAdImageApi mNativeAdImageApi;

        Image(NativeAdImageApi nativeAdImageApi) {
            this.mNativeAdImageApi = nativeAdImageApi;
        }

        public int getWidth() {
            return this.mNativeAdImageApi.getWidth();
        }

        public int getHeight() {
            return this.mNativeAdImageApi.getHeight();
        }

        public String getUrl() {
            return this.mNativeAdImageApi.getUrl();
        }

        public static Image fromJSONObject(JSONObject jSONObject) {
            NativeAdImageApi createNativeAdImageApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdImageApi(jSONObject);
            if (createNativeAdImageApi == null) {
                return null;
            }
            return new Image(createNativeAdImageApi);
        }
    }

    public static class Rating {
        private final NativeAdRatingApi mNativeAdRatingApi;

        Rating(NativeAdRatingApi nativeAdRatingApi) {
            this.mNativeAdRatingApi = nativeAdRatingApi;
        }

        public double getValue() {
            return this.mNativeAdRatingApi.getValue();
        }

        public double getScale() {
            return this.mNativeAdRatingApi.getScale();
        }

        public static Rating fromJSONObject(JSONObject jSONObject) {
            NativeAdRatingApi createNativeAdRatingApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdRatingApi(jSONObject);
            if (createNativeAdRatingApi == null) {
                return null;
            }
            return new Rating(createNativeAdRatingApi);
        }
    }

    public enum NativeComponentTag {
        AD_ICON,
        AD_TITLE,
        AD_COVER_IMAGE,
        AD_SUBTITLE,
        AD_BODY,
        AD_CALL_TO_ACTION,
        AD_SOCIAL_CONTEXT,
        AD_CHOICES_ICON,
        AD_OPTIONS_VIEW,
        AD_MEDIA;

        public static void tagView(View view, NativeComponentTag nativeComponentTag) {
            DynamicLoaderFactory.makeLoader(view.getContext()).createNativeComponentTagApi().tagView(view, nativeComponentTag);
        }
    }

    public NativeAdBase(Context context, String str) {
        this.mNativeAdBaseApi = DynamicLoaderFactory.makeLoader(context).createNativeAdBaseApi(context, str);
    }

    public NativeAdBase(NativeAdBaseApi nativeAdBaseApi) {
        this.mNativeAdBaseApi = nativeAdBaseApi;
    }

    NativeAdBase(Context context, NativeAdBase nativeAdBase) {
        this.mNativeAdBaseApi = DynamicLoaderFactory.makeLoader(context).createNativeAdBaseApi(nativeAdBase.mNativeAdBaseApi);
    }

    public NativeAdBaseApi getInternalNativeAd() {
        return this.mNativeAdBaseApi;
    }

    @Deprecated
    public void setAdListener(NativeAdListener nativeAdListener) {
        this.mNativeAdBaseApi.setAdListener(nativeAdListener, this);
    }

    @Override // com.facebook.ads.Ad
    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mNativeAdBaseApi.setExtraHints(extraHints);
    }

    @Override // com.facebook.ads.Ad
    public void loadAd() {
        this.mNativeAdBaseApi.loadAd();
    }

    public void loadAd(NativeLoadAdConfig nativeLoadAdConfig) {
        this.mNativeAdBaseApi.loadAd(nativeLoadAdConfig);
    }

    @Deprecated
    public void loadAd(MediaCacheFlag mediaCacheFlag) {
        this.mNativeAdBaseApi.loadAd(mediaCacheFlag);
    }

    @Override // com.facebook.ads.Ad
    @Deprecated
    public void loadAdFromBid(String str) {
        this.mNativeAdBaseApi.loadAdFromBid(str);
    }

    @Deprecated
    public void loadAdFromBid(String str, MediaCacheFlag mediaCacheFlag) {
        this.mNativeAdBaseApi.loadAdFromBid(str, mediaCacheFlag);
    }

    public void downloadMedia() {
        this.mNativeAdBaseApi.downloadMedia();
    }

    @Override // com.facebook.ads.Ad
    public void destroy() {
        this.mNativeAdBaseApi.destroy();
    }

    @Override // com.facebook.ads.Ad
    public String getPlacementId() {
        return this.mNativeAdBaseApi.getPlacementId();
    }

    @Override // com.facebook.ads.Ad
    public boolean isAdInvalidated() {
        return this.mNativeAdBaseApi.isAdInvalidated();
    }

    public boolean isAdLoaded() {
        return this.mNativeAdBaseApi.isAdLoaded();
    }

    public boolean hasCallToAction() {
        return this.mNativeAdBaseApi.hasCallToAction();
    }

    public Image getAdIcon() {
        if (this.mNativeAdBaseApi.getAdIcon() == null) {
            return null;
        }
        return new Image(this.mNativeAdBaseApi.getAdIcon());
    }

    public Image getAdCoverImage() {
        if (this.mNativeAdBaseApi.getAdCoverImage() == null) {
            return null;
        }
        return new Image(this.mNativeAdBaseApi.getAdCoverImage());
    }

    @Deprecated
    public NativeAdViewAttributes getAdViewAttributes() {
        return new NativeAdViewAttributes();
    }

    public String getAdvertiserName() {
        return this.mNativeAdBaseApi.getAdvertiserName();
    }

    public String getAdHeadline() {
        return this.mNativeAdBaseApi.getAdHeadline();
    }

    public String getAdBodyText() {
        return this.mNativeAdBaseApi.getAdBodyText();
    }

    public String getAdUntrimmedBodyText() {
        return this.mNativeAdBaseApi.getAdUntrimmedBodyText();
    }

    public String getAdCallToAction() {
        return this.mNativeAdBaseApi.getAdCallToAction();
    }

    public String getAdSocialContext() {
        return this.mNativeAdBaseApi.getAdSocialContext();
    }

    public String getAdLinkDescription() {
        return this.mNativeAdBaseApi.getAdLinkDescription();
    }

    public String getSponsoredTranslation() {
        return this.mNativeAdBaseApi.getSponsoredTranslation();
    }

    public String getAdTranslation() {
        return this.mNativeAdBaseApi.getAdTranslation();
    }

    public String getPromotedTranslation() {
        return this.mNativeAdBaseApi.getPromotedTranslation();
    }

    @Deprecated
    public Rating getAdStarRating() {
        if (this.mNativeAdBaseApi.getAdStarRating() == null) {
            return null;
        }
        return new Rating(this.mNativeAdBaseApi.getAdStarRating());
    }

    public String getId() {
        return this.mNativeAdBaseApi.getId();
    }

    public Image getAdChoicesIcon() {
        if (this.mNativeAdBaseApi.getAdChoicesIcon() == null) {
            return null;
        }
        return new Image(this.mNativeAdBaseApi.getAdChoicesIcon());
    }

    public String getAdChoicesImageUrl() {
        return this.mNativeAdBaseApi.getAdChoicesImageUrl();
    }

    public float getAspectRatio() {
        return this.mNativeAdBaseApi.getAspectRatio();
    }

    public String getAdChoicesLinkUrl() {
        return this.mNativeAdBaseApi.getAdChoicesLinkUrl();
    }

    public String getAdChoicesText() {
        return this.mNativeAdBaseApi.getAdChoicesText();
    }

    public Drawable getPreloadedIconViewDrawable() {
        return this.mNativeAdBaseApi.getPreloadedIconViewDrawable();
    }

    public void onCtaBroadcast() {
        this.mNativeAdBaseApi.onCtaBroadcast();
    }

    public void unregisterView() {
        this.mNativeAdBaseApi.unregisterView();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mNativeAdBaseApi.setOnTouchListener(onTouchListener);
    }

    public NativeAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mNativeAdBaseApi.buildLoadAdConfig(this);
    }
}
