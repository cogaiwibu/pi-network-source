package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

public final class iq extends RelativeLayout implements View.OnClickListener {
    private boolean a;
    private float b = 1.0f;
    private View c;
    private View d;
    private FrameLayout e;
    private ImageView f;
    private in g;
    private hu h;
    private a i;

    public interface a {
        void a();

        void a(hs hsVar);

        void b();
    }

    public iq(Context context, hu huVar, a aVar) {
        super(context);
        this.h = huVar;
        this.i = aVar;
        Context context2 = getContext();
        View view = new View(context2);
        this.c = view;
        boolean z = true;
        view.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.c, layoutParams);
        this.d = new View(context2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams2.addRule(13);
        addView(this.d, layoutParams2);
        this.e = new FrameLayout(context2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams3.addRule(13);
        addView(this.e, layoutParams3);
        ImageView imageView = new ImageView(context2);
        this.f = imageView;
        imageView.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(0, 0);
        layoutParams4.addRule(7, this.c.getId());
        layoutParams4.addRule(6, this.c.getId());
        addView(this.f, layoutParams4);
        if (this.h.m != null) {
            hv hvVar = this.h.m;
            if (hvVar.a == null || (hvVar.b == null && hvVar.c == null)) {
                z = false;
            }
            if (z) {
                in inVar = new in(context2);
                this.g = inVar;
                inVar.setOnClickListener(this);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(0, 0);
                layoutParams5.addRule(5, this.d.getId());
                layoutParams5.addRule(8, this.d.getId());
                addView(this.g, layoutParams5);
            }
        }
        this.f.setImageBitmap(huVar.c.b);
        if (this.g != null && huVar.m != null && huVar.m.a != null) {
            this.g.setImageBitmap(huVar.m.a.b);
        }
    }

    public final void setLandscape(boolean z) {
        Bitmap bitmap;
        ArrayList arrayList;
        Bitmap bitmap2;
        this.a = z;
        if (z) {
            bitmap = this.h.b.b;
            bitmap2 = this.h.f.b;
            arrayList = this.h.j;
        } else {
            bitmap = this.h.a.b;
            bitmap2 = this.h.e.b;
            arrayList = this.h.i;
        }
        ab.a(this.c, new BitmapDrawable((Resources) null, bitmap));
        ab.a(this.d, new BitmapDrawable((Resources) null, bitmap2));
        if (this.e.getChildCount() > 0) {
            this.e.removeAllViews();
        }
        Context context = getContext();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = new View(context);
            view.setTag((hs) it.next());
            view.setOnClickListener(this);
            this.e.addView(view, new FrameLayout.LayoutParams(0, 0, 51));
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int i4;
        Point point;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (this.a) {
            this.b = Math.min(((float) size) / 480.0f, ((float) size2) / 320.0f);
        } else {
            this.b = Math.min(((float) size) / 320.0f, ((float) size2) / 480.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
        int i5 = 480;
        layoutParams.width = a(this.a ? 480 : 320);
        if (this.a) {
            i5 = 320;
        }
        layoutParams.height = a(i5);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        int i6 = 448;
        layoutParams2.width = a(this.a ? 448 : 290);
        if (this.a) {
            i6 = 290;
        }
        layoutParams2.height = a(i6);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams3.width = layoutParams2.width;
        layoutParams3.height = layoutParams2.height;
        for (View view : ac.a(this.e)) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) view.getLayoutParams();
            Rect rect = ((hs) view.getTag()).a;
            layoutParams4.width = a(rect.width());
            layoutParams4.height = a(rect.height());
            layoutParams4.leftMargin = a(rect.left);
            layoutParams4.topMargin = a(rect.top);
        }
        int i7 = 0;
        int a2 = a(0);
        this.f.setPadding(a2, a2, a2, a2);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams5.width = a(30);
        layoutParams5.height = layoutParams5.width;
        int i8 = -a2;
        layoutParams5.rightMargin = a(this.h.d.x) + i8;
        layoutParams5.topMargin = i8 + a(this.h.d.y);
        if (this.g != null) {
            int i9 = 16;
            int a3 = a(this.a ? 16 : 15);
            if (this.a) {
                i9 = 15;
            }
            int a4 = a(i9);
            this.g.setPadding(a2, a2, a2, a2);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams6.width = a(26);
            layoutParams6.height = layoutParams6.width;
            if (this.h.m != null) {
                if (this.a) {
                    hv hvVar = this.h.m;
                    if (hvVar.b == null) {
                        point = hvVar.c;
                    } else {
                        point = hvVar.b;
                    }
                } else {
                    hv hvVar2 = this.h.m;
                    if (hvVar2.c == null) {
                        point = hvVar2.b;
                    } else {
                        point = hvVar2.c;
                    }
                }
                if (point != null) {
                    i7 = point.x;
                    i4 = point.y;
                    layoutParams6.leftMargin = a3 + a(i7);
                    layoutParams6.topMargin = a4 + a(i4);
                }
            }
            i4 = 0;
            layoutParams6.leftMargin = a3 + a(i7);
            layoutParams6.topMargin = a4 + a(i4);
        }
        super.onMeasure(i2, i3);
    }

    private int a(int i2) {
        return (int) (((float) i2) * this.b);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public final void onClick(View view) {
        in inVar;
        if (view == this.f) {
            this.i.a();
        } else if (view != null && view == (inVar = this.g)) {
            inVar.a = !inVar.a;
            inVar.a();
            inVar.invalidate();
            this.i.b();
        } else if (view.getTag() instanceof hs) {
            this.i.a((hs) view.getTag());
        }
    }
}
