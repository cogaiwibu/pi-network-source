package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

public class BlurPostProcessor extends BasePostprocessor {
    private static final int DEFAULT_ITERATIONS = 3;
    private static final boolean canUseRenderScript = RenderScriptBlurFilter.canUseRenderScript();
    private final int mBlurRadius;
    private CacheKey mCacheKey;
    private final Context mContext;
    private final int mIterations;

    public BlurPostProcessor(int i, Context context, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0 && i <= 25);
        Preconditions.checkArgument(i2 <= 0 ? false : z);
        Preconditions.checkNotNull(context);
        this.mIterations = i2;
        this.mBlurRadius = i;
        this.mContext = context;
    }

    public BlurPostProcessor(int i, Context context) {
        this(i, context, 3);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        if (canUseRenderScript) {
            RenderScriptBlurFilter.blurBitmap(bitmap, bitmap2, this.mContext, this.mBlurRadius);
        } else {
            super.process(bitmap, bitmap2);
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        IterativeBoxBlurFilter.boxBlurBitmapInPlace(bitmap, this.mIterations, this.mBlurRadius);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor, com.facebook.imagepipeline.request.BasePostprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        String str;
        if (this.mCacheKey == null) {
            if (canUseRenderScript) {
                str = String.format(null, "IntrinsicBlur;%d", Integer.valueOf(this.mBlurRadius));
            } else {
                str = String.format(null, "IterativeBoxBlur;%d;%d", Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius));
            }
            this.mCacheKey = new SimpleCacheKey(str);
        }
        return this.mCacheKey;
    }
}
