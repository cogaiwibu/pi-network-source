package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.u;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView;
import com.bytedance.sdk.openadsdk.g.t;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;

/* compiled from: ClickCreativeListener */
public class a extends b {
    private boolean a = true;
    private boolean x = false;
    private int y;

    public a(Context context, g gVar, String str, int i) {
        super(context, gVar, str, i);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b(boolean z) {
        this.x = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void b(View view, int i, int i2, int i3, int i4) {
        View view2;
        if (a() && b(view)) {
            super.b(view, i, i2, i3, i4);
        } else if (this.b != null) {
            long j = this.s;
            long j2 = this.t;
            if (this.f == null) {
                view2 = null;
            } else {
                view2 = (View) this.f.get();
            }
            this.h = a(i, i2, i3, i4, j, j2, view2, this.g == null ? null : (View) this.g.get());
            int g = this.c.g();
            if (g == 2 || g == 3) {
                if (this.j != null || this.x) {
                    d.a(this.b, "click_button", this.c, this.h, this.d, true, (Map<String, Object>) this.n);
                }
                u.a(true);
                boolean a2 = u.a(this.b, this.c, this.e, this.k, this.j, t.a(this.e), this.m);
                if (this.a) {
                    d.a(this.b, TJAdUnitConstants.String.CLICK, this.c, this.h, this.d, a2, this.n);
                }
            } else if (g != 4) {
                if (g != 5) {
                    g = -1;
                } else {
                    String a3 = a(this.d);
                    if (!TextUtils.isEmpty(a3)) {
                        d.a(this.b, "click_call", this.c, this.h, a3, true, (Map<String, Object>) this.n);
                    }
                    d.a(this.b, TJAdUnitConstants.String.CLICK, this.c, this.h, this.d, t.d(view.getContext(), this.c.k()), this.n);
                }
            } else if (this.m != null) {
                this.m.a();
                if (this.a) {
                    d.a(this.b, TJAdUnitConstants.String.CLICK, this.c, this.h, this.d, true, (Map<String, Object>) this.n);
                }
            }
            if (this.i != null) {
                this.i.a(view, g);
            }
        }
    }

    private boolean b(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoAdView) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (b(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean a() {
        if (this.c == null) {
            return false;
        }
        if (this.c.v() != 5 && this.c.v() != 15) {
            return false;
        }
        if (this.y == 0) {
            this.y = t.b(this.c.u());
        }
        int i = this.y;
        if (i == 1 || i == 2 || i == 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private String a(String str) {
        char c;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0 || c == 1) {
            return "feed_call";
        }
        if (c == 2 || c == 3) {
            return "banner_call";
        }
        if (c != 4) {
            return c != 5 ? "" : "splash_ad";
        }
        return "interaction_call";
    }
}
