package com.bytedance.sdk.openadsdk.core.splash;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.g.n;
import pl.droidsonroids.gif.GifImageView;

public class TsView extends FrameLayout {
    private GifImageView a;
    private TextView b;

    /* access modifiers changed from: package-private */
    public void setSkipText(SpannableStringBuilder spannableStringBuilder) {
        this.b.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: package-private */
    public void setSkipIconVisibility(int i) {
        if (i == 8 || i == 4 || i == 0) {
            this.b.setVisibility(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setDrawable(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public View getDislikeView() {
        return this.b;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        n.a("不允许在Splash广告中注册OnClickListener");
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        n.a("不允许在Splash广告中注册OnTouchListener");
    }

    /* access modifiers changed from: package-private */
    public final void setOnTouchListenerInternal(View.OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
    }

    /* access modifiers changed from: package-private */
    public final void setOnClickListenerInternal(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public final void setSkipListener(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }
}
