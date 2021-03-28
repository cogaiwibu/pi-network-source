package com.bytedance.sdk.openadsdk.core.video.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.multipro.aidl.a;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.facebook.AccessToken;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* compiled from: TTRewardVideoAdImpl */
public class f implements TTRewardVideoAd {
    private final Context a;
    private final g b;
    private final AdSlot c;
    private TTRewardVideoAd.RewardAdInteractionListener d;
    private boolean e = true;
    private boolean f;
    private String g;
    private final TTAdNative.RewardVideoAdListener h;
    private String i;

    f(Context context, g gVar, AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.a = context;
        this.b = gVar;
        this.c = adSlot;
        this.h = rewardVideoAdListener;
        this.f = false;
    }

    public void a(String str) {
        this.f = true;
        this.g = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.d = rewardAdInteractionListener;
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        g gVar = this.b;
        if (gVar == null) {
            return -1;
        }
        return gVar.g();
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        this.e = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        if (!activity.isFinishing()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Intent intent = new Intent(activity, TTRewardVideoActivity.class);
                intent.putExtra("reward_name", this.c.getRewardName());
                intent.putExtra("reward_amount", this.c.getRewardAmount());
                intent.putExtra("media_extra", this.c.getMediaExtra());
                intent.putExtra(AccessToken.USER_ID_KEY, this.c.getUserID());
                intent.putExtra("show_download_bar", this.e);
                intent.putExtra("orientation", this.c.getOrientation());
                if (!TextUtils.isEmpty(this.i)) {
                    intent.putExtra("rit_scene", this.i);
                }
                if (this.f) {
                    g gVar = this.b;
                    if (gVar != null && gVar.e() != null) {
                        intent.putExtra("video_cache_url", this.g);
                    } else {
                        return;
                    }
                }
                if (b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.b.C().toString());
                } else {
                    o.a().h();
                    o.a().a(this.b);
                    o.a().a(this.d);
                }
                activity.startActivity(intent);
                if (!TextUtils.isEmpty(this.b.u())) {
                    try {
                        String optString = new JSONObject(this.b.u()).optString("rit", null);
                        AdSlot b2 = e.a(this.a).b(optString);
                        e.a(activity).a(optString);
                        e.a(activity).a(b2);
                    } catch (Exception unused) {
                    }
                }
            } else {
                throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (ritScenes == null) {
            l.e("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
            this.i = str;
        } else {
            this.i = ritScenes.getScenesName();
        }
        showRewardVideoAd(activity);
    }

    private void a(final int i2) {
        if (b.b()) {
            new Thread(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.b.f.AnonymousClass1 */

                public void run() {
                    a a2 = a.a(f.this.a);
                    if (i2 == 0 && f.this.d != null) {
                        l.b("MultiProcess", "start registerRewardVideoListener ! ");
                        com.bytedance.sdk.openadsdk.multipro.aidl.b.b bVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.b(f.this.d);
                        IListenerManager asInterface = e.asInterface(a2.a(0));
                        if (asInterface != null) {
                            try {
                                asInterface.registerRewardVideoListener(bVar);
                                l.b("MultiProcess", "end registerRewardVideoListener ! ");
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
    }
}
