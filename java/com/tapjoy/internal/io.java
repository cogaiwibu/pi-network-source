package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class io extends RelativeLayout {
    private hr a;
    private a b;
    private aa c = aa.UNSPECIFIED;
    private int d = 0;
    private int e = 0;
    private ia f = null;
    private ArrayList g = null;
    private ArrayList h = null;

    public interface a {
        void a();

        void a(hz hzVar);
    }

    public io(Context context, hr hrVar, a aVar) {
        super(context);
        this.a = hrVar;
        this.b = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r18, int r19) {
        /*
        // Method dump skipped, instructions count: 284
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.io.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            ArrayList arrayList = this.h;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ig igVar = (ig) ((WeakReference) it.next()).get();
                    if (igVar != null) {
                        igVar.setVisibility(4);
                        igVar.b();
                    }
                }
            }
            ArrayList arrayList2 = this.g;
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ig igVar2 = (ig) ((WeakReference) it2.next()).get();
                    if (igVar2 != null) {
                        igVar2.setVisibility(0);
                        igVar2.a();
                    }
                }
                return;
            }
            return;
        }
        ArrayList arrayList3 = this.g;
        if (arrayList3 != null) {
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                ig igVar3 = (ig) ((WeakReference) it3.next()).get();
                if (igVar3 != null) {
                    igVar3.b();
                }
            }
        }
        ArrayList arrayList4 = this.h;
        if (arrayList4 != null) {
            Iterator it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                ig igVar4 = (ig) ((WeakReference) it4.next()).get();
                if (igVar4 != null) {
                    igVar4.b();
                }
            }
        }
    }

    private void a() {
        final ig igVar;
        final ig igVar2;
        Bitmap bitmap;
        Iterator it = this.a.a.iterator();
        ia iaVar = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ia iaVar2 = (ia) it.next();
            if (iaVar2.a == this.c) {
                iaVar = iaVar2;
                break;
            } else if (iaVar2.a == aa.UNSPECIFIED) {
                iaVar = iaVar2;
            }
        }
        removeAllViews();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ig igVar3 = (ig) ((WeakReference) it2.next()).get();
                if (igVar3 != null) {
                    igVar3.c();
                }
            }
            this.g.clear();
        }
        ArrayList arrayList2 = this.h;
        if (arrayList2 != null) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                ig igVar4 = (ig) ((WeakReference) it3.next()).get();
                if (igVar4 != null) {
                    igVar4.c();
                }
            }
            this.h.clear();
        }
        if (iaVar != null) {
            this.f = iaVar;
            Context context = getContext();
            Iterator it4 = iaVar.c.iterator();
            while (it4.hasNext()) {
                final hz hzVar = (hz) it4.next();
                final RelativeLayout relativeLayout = new RelativeLayout(context);
                if (hzVar.l.c != null) {
                    ig igVar5 = new ig(context);
                    igVar5.setScaleType(ImageView.ScaleType.FIT_XY);
                    igVar5.a(hzVar.l.d, hzVar.l.c);
                    if (this.g == null) {
                        this.g = new ArrayList();
                    }
                    this.g.add(new WeakReference(igVar5));
                    igVar = igVar5;
                } else {
                    igVar = null;
                }
                if (hzVar.m == null || hzVar.m.c == null) {
                    igVar2 = null;
                } else {
                    ig igVar6 = new ig(context);
                    igVar6.setScaleType(ImageView.ScaleType.FIT_XY);
                    igVar6.a(hzVar.m.d, hzVar.m.c);
                    if (this.h == null) {
                        this.h = new ArrayList();
                    }
                    this.h.add(new WeakReference(igVar6));
                    igVar2 = igVar6;
                }
                ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                Bitmap bitmap2 = hzVar.l.b;
                if (hzVar.m != null) {
                    bitmap = hzVar.m.b;
                } else {
                    bitmap = null;
                }
                final BitmapDrawable bitmapDrawable = bitmap2 != null ? new BitmapDrawable((Resources) null, bitmap2) : null;
                final BitmapDrawable bitmapDrawable2 = bitmap != null ? new BitmapDrawable((Resources) null, bitmap) : null;
                if (bitmapDrawable != null) {
                    ab.a(relativeLayout, bitmapDrawable);
                }
                if (igVar != null) {
                    relativeLayout.addView(igVar, layoutParams2);
                    igVar.a();
                }
                if (igVar2 != null) {
                    relativeLayout.addView(igVar2, layoutParams2);
                    igVar2.setVisibility(4);
                }
                relativeLayout.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tapjoy.internal.io.AnonymousClass1 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        ig igVar;
                        if (motionEvent.getAction() == 0) {
                            if (!(igVar2 == null && bitmapDrawable2 == null)) {
                                ig igVar2 = igVar;
                                if (igVar2 != null) {
                                    igVar2.b();
                                    igVar.setVisibility(4);
                                }
                                ab.a(view, null);
                            }
                            BitmapDrawable bitmapDrawable = bitmapDrawable2;
                            if (bitmapDrawable != null) {
                                ab.a(view, bitmapDrawable);
                            } else {
                                ig igVar3 = igVar2;
                                if (igVar3 != null) {
                                    igVar3.setVisibility(0);
                                    igVar2.a();
                                }
                            }
                        } else {
                            boolean z = true;
                            if (motionEvent.getAction() == 1) {
                                float x = motionEvent.getX();
                                float y = motionEvent.getY();
                                if (x >= 0.0f && x < ((float) view.getWidth()) && y >= 0.0f && y < ((float) view.getHeight())) {
                                    z = false;
                                }
                                if (z) {
                                    BitmapDrawable bitmapDrawable2 = bitmapDrawable;
                                    if (bitmapDrawable2 != null) {
                                        ab.a(view, bitmapDrawable2);
                                    } else if (bitmapDrawable2 != null) {
                                        ab.a(view, null);
                                    }
                                }
                                ig igVar4 = igVar2;
                                if (igVar4 != null) {
                                    igVar4.b();
                                    igVar2.setVisibility(4);
                                }
                                if (!((igVar2 == null && bitmapDrawable2 == null) || (igVar = igVar) == null || !z)) {
                                    igVar.setVisibility(0);
                                    igVar.a();
                                }
                            }
                        }
                        return false;
                    }
                });
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.tapjoy.internal.io.AnonymousClass2 */

                    public final void onClick(View view) {
                        ig igVar = igVar2;
                        if (igVar != null) {
                            igVar.b();
                            relativeLayout.removeView(igVar2);
                        }
                        ig igVar2 = igVar;
                        if (igVar2 != null) {
                            igVar2.b();
                            relativeLayout.removeView(igVar);
                        }
                        io.this.b.a(hzVar);
                    }
                });
                relativeLayout.setTag(hzVar);
                addView(relativeLayout, layoutParams);
            }
        }
    }
}
