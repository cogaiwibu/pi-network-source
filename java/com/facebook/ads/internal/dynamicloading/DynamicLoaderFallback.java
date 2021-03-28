package com.facebook.ads.internal.dynamicloading;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InstreamVideoAdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* access modifiers changed from: package-private */
public class DynamicLoaderFallback {
    private static final WeakHashMap<Object, AdListener> sApiProxyToAdListenersMap = new WeakHashMap<>();

    DynamicLoaderFallback() {
    }

    static DynamicLoader makeFallbackLoader() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        final ArrayList arrayList4 = new ArrayList();
        final ArrayList arrayList5 = new ArrayList();
        final ArrayList arrayList6 = new ArrayList();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        SimpleMethodCaptor simpleMethodCaptor = new SimpleMethodCaptor();
        DynamicLoader dynamicLoader = (DynamicLoader) simpleMethodCaptor.mock(DynamicLoader.class);
        dynamicLoader.createInterstitialAd(null, null, null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createRewardedVideoAd(null, null, null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createInstreamVideoAdViewApi(null, null, null, null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createAdViewApi((Context) null, (String) null, (AdSize) null, (AdViewParentApi) null, (AdView) null);
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        try {
            dynamicLoader.createAdViewApi((Context) null, (String) null, (String) null, (AdViewParentApi) null, (AdView) null);
        } catch (Exception unused) {
        }
        arrayList6.add(simpleMethodCaptor.getLastMethod());
        dynamicLoader.createNativeAdApi(null, null);
        final Method lastMethod = simpleMethodCaptor.getLastMethod();
        dynamicLoader.createNativeBannerAdApi(null, null);
        final Method lastMethod2 = simpleMethodCaptor.getLastMethod();
        NativeAdBaseApi nativeAdBaseApi = (NativeAdBaseApi) simpleMethodCaptor.mock(NativeAdBaseApi.class);
        nativeAdBaseApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAd((NativeAdBase.NativeLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAd((NativeAdBase.MediaCacheFlag) null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAdFromBid(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.loadAdFromBid(null, null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.buildLoadAdConfig(null);
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        nativeAdBaseApi.setAdListener(null, null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        InterstitialAdApi interstitialAdApi = (InterstitialAdApi) simpleMethodCaptor.mock(InterstitialAdApi.class);
        interstitialAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAd((EnumSet<CacheFlag>) null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAd((InterstitialAd.InterstitialLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.loadAdFromBid(null, null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        interstitialAdApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        RewardedVideoAdApi rewardedVideoAdApi = (RewardedVideoAdApi) simpleMethodCaptor.mock(RewardedVideoAdApi.class);
        rewardedVideoAdApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAd((RewardedVideoAd.RewardedVideoLoadAdConfig) null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAd(false);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.loadAdFromBid(null, false);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        rewardedVideoAdApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        InstreamVideoAdViewApi instreamVideoAdViewApi = (InstreamVideoAdViewApi) simpleMethodCaptor.mock(InstreamVideoAdViewApi.class);
        instreamVideoAdViewApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.loadAdFromBid(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        instreamVideoAdViewApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        AdViewApi adViewApi = (AdViewApi) simpleMethodCaptor.mock(AdViewApi.class);
        adViewApi.loadAd();
        arrayList.add(simpleMethodCaptor.getLastMethod());
        adViewApi.loadAd(null);
        arrayList2.add(simpleMethodCaptor.getLastMethod());
        adViewApi.loadAdFromBid(null);
        arrayList.add(simpleMethodCaptor.getLastMethod());
        adViewApi.setAdListener(null);
        arrayList3.add(simpleMethodCaptor.getLastMethod());
        adViewApi.buildLoadAdConfig();
        arrayList5.add(simpleMethodCaptor.getLastMethod());
        ((AdView.AdViewLoadConfigBuilder) simpleMethodCaptor.mock(AdView.AdViewLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        NativeAdBase.NativeAdLoadConfigBuilder nativeAdLoadConfigBuilder = (NativeAdBase.NativeAdLoadConfigBuilder) simpleMethodCaptor.mock(NativeAdBase.NativeAdLoadConfigBuilder.class);
        nativeAdLoadConfigBuilder.withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((InterstitialAd.InterstitialAdLoadConfigBuilder) simpleMethodCaptor.mock(InterstitialAd.InterstitialAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((RewardedVideoAd.RewardedVideoAdLoadConfigBuilder) simpleMethodCaptor.mock(RewardedVideoAd.RewardedVideoAdLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        ((InstreamVideoAdView.InstreamVideoLoadConfigBuilder) simpleMethodCaptor.mock(InstreamVideoAdView.InstreamVideoLoadConfigBuilder.class)).withAdListener(null);
        arrayList4.add(simpleMethodCaptor.getLastMethod());
        nativeAdLoadConfigBuilder.loadAd();
        final Method lastMethod3 = simpleMethodCaptor.getLastMethod();
        AnonymousClass1 r14 = new InvocationHandler() {
            /* class com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.AnonymousClass1 */

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                Object obj2;
                if (method.getReturnType().isPrimitive()) {
                    if (!method.getReturnType().equals(Void.TYPE)) {
                        return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
                    }
                    Iterator it = arrayList3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (DynamicLoaderFallback.equalsMethods(method, (Method) it.next())) {
                                DynamicLoaderFallback.sApiProxyToAdListenersMap.put(obj, (AdListener) objArr[0]);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it2.next()) || !DynamicLoaderFallback.reportError(obj, hashMap))) {
                    }
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext() && (!DynamicLoaderFallback.equalsMethods(method, (Method) it3.next()) || !DynamicLoaderFallback.reportError(obj, hashMap))) {
                    }
                    if (!DynamicLoaderFallback.equalsMethods(method, lastMethod3)) {
                        return null;
                    }
                    DynamicLoaderFallback.reportError(hashMap2.get(obj), hashMap);
                    return null;
                } else if (method.getReturnType().equals(String.class)) {
                    return "";
                } else {
                    if (method.getReturnType().equals(obj.getClass().getInterfaces()[0])) {
                        obj2 = obj;
                    } else {
                        obj2 = Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{method.getReturnType()}, this);
                    }
                    Iterator it4 = arrayList4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            if (DynamicLoaderFallback.equalsMethods(method, (Method) it4.next())) {
                                DynamicLoaderFallback.sApiProxyToAdListenersMap.put(hashMap2.get(obj), (AdListener) objArr[0]);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    for (Method method2 : arrayList5) {
                        if (DynamicLoaderFallback.equalsMethods(method, method2)) {
                            hashMap2.put(obj2, obj);
                        }
                    }
                    for (Method method3 : arrayList6) {
                        if (DynamicLoaderFallback.equalsMethods(method, method3)) {
                            for (Object obj3 : objArr) {
                                if (obj3 instanceof Ad) {
                                    hashMap.put(obj2, (Ad) obj3);
                                }
                            }
                        }
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, lastMethod)) {
                        hashMap.put(objArr[1], (Ad) objArr[0]);
                    }
                    if (DynamicLoaderFallback.equalsMethods(method, lastMethod2)) {
                        hashMap.put(objArr[1], (Ad) objArr[0]);
                    }
                    return obj2;
                }
            }
        };
        return (DynamicLoader) Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{DynamicLoader.class}, r14);
    }

    /* access modifiers changed from: private */
    public static boolean reportError(Object obj, Map<Object, Ad> map) {
        if (obj == null) {
            return false;
        }
        final AdListener adListener = sApiProxyToAdListenersMap.get(obj);
        final Ad ad = map.get(obj);
        if (adListener == null) {
            return false;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.AnonymousClass2 */

            public void run() {
                adListener.onError(ad, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network.dex is inside of assets folder."));
            }
        }, 500);
        return true;
    }

    /* access modifiers changed from: private */
    public static class SimpleMethodCaptor {
        private final InvocationHandler mInvocationHandler;
        private Method mLastInvokedMethod;

        private SimpleMethodCaptor() {
            this.mInvocationHandler = new InvocationHandler() {
                /* class com.facebook.ads.internal.dynamicloading.DynamicLoaderFallback.SimpleMethodCaptor.AnonymousClass1 */

                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if ("toString".equals(method.getName())) {
                        return null;
                    }
                    SimpleMethodCaptor.this.mLastInvokedMethod = method;
                    return null;
                }
            };
        }

        public <T> T mock(Class<T> cls) {
            return cls.cast(Proxy.newProxyInstance(DynamicLoaderFallback.class.getClassLoader(), new Class[]{cls}, this.mInvocationHandler));
        }

        /* access modifiers changed from: package-private */
        public Method getLastMethod() {
            return this.mLastInvokedMethod;
        }
    }

    /* access modifiers changed from: private */
    public static boolean equalsMethods(Method method, Method method2) {
        return method != null && method2 != null && method.getDeclaringClass().equals(method2.getDeclaringClass()) && method.getName().equals(method2.getName()) && equalsMethodParams(method, method2);
    }

    private static boolean equalsMethodParams(Method method, Method method2) {
        return Arrays.equals(method.getParameterTypes(), method2.getParameterTypes());
    }
}
