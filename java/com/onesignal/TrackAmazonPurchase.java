package com.onesignal;

import android.content.Context;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;
import com.onesignal.OneSignal;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class TrackAmazonPurchase {
    private boolean canTrack = false;
    private Context context;
    private Field listenerHandlerField;
    private Object listenerHandlerObject;
    private OSPurchasingListener osPurchasingListener;

    TrackAmazonPurchase(Context context2) {
        this.context = context2;
        try {
            Class<?> cls = Class.forName("com.amazon.device.iap.internal.d");
            this.listenerHandlerObject = cls.getMethod("d", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("f");
            this.listenerHandlerField = declaredField;
            declaredField.setAccessible(true);
            OSPurchasingListener oSPurchasingListener = new OSPurchasingListener(this, null);
            this.osPurchasingListener = oSPurchasingListener;
            oSPurchasingListener.orgPurchasingListener = (PurchasingListener) this.listenerHandlerField.get(this.listenerHandlerObject);
            this.canTrack = true;
            setListener();
        } catch (ClassNotFoundException e) {
            logAmazonIAPListenerError(e);
        } catch (IllegalAccessException e2) {
            logAmazonIAPListenerError(e2);
        } catch (InvocationTargetException e3) {
            logAmazonIAPListenerError(e3);
        } catch (NoSuchMethodException e4) {
            logAmazonIAPListenerError(e4);
        } catch (NoSuchFieldException e5) {
            logAmazonIAPListenerError(e5);
        }
    }

    private static void logAmazonIAPListenerError(Exception exc) {
        OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error adding Amazon IAP listener.", exc);
        exc.printStackTrace();
    }

    private void setListener() {
        PurchasingService.registerListener(this.context, this.osPurchasingListener);
    }

    /* access modifiers changed from: package-private */
    public void checkListener() {
        if (this.canTrack) {
            try {
                OSPurchasingListener oSPurchasingListener = (PurchasingListener) this.listenerHandlerField.get(this.listenerHandlerObject);
                if (oSPurchasingListener != this.osPurchasingListener) {
                    this.osPurchasingListener.orgPurchasingListener = oSPurchasingListener;
                    setListener();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public class OSPurchasingListener implements PurchasingListener {
        private String currentMarket;
        private RequestId lastRequestId;
        PurchasingListener orgPurchasingListener;

        private OSPurchasingListener() {
        }

        /* synthetic */ OSPurchasingListener(TrackAmazonPurchase trackAmazonPurchase, AnonymousClass1 r2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x0098 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x009b A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x009e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00ad A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String marketToCurrencyCode(java.lang.String r3) {
            /*
            // Method dump skipped, instructions count: 200
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.TrackAmazonPurchase.OSPurchasingListener.marketToCurrencyCode(java.lang.String):java.lang.String");
        }

        public void onProductDataResponse(ProductDataResponse productDataResponse) {
            RequestId requestId = this.lastRequestId;
            if (requestId == null || !requestId.toString().equals(productDataResponse.getRequestId().toString())) {
                PurchasingListener purchasingListener = this.orgPurchasingListener;
                if (purchasingListener != null) {
                    purchasingListener.onProductDataResponse(productDataResponse);
                    return;
                }
                return;
            }
            try {
                if (AnonymousClass1.$SwitchMap$com$amazon$device$iap$model$ProductDataResponse$RequestStatus[productDataResponse.getRequestStatus().ordinal()] == 1) {
                    JSONArray jSONArray = new JSONArray();
                    Map productData = productDataResponse.getProductData();
                    for (String str : productData.keySet()) {
                        Product product = (Product) productData.get(str);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sku", product.getSku());
                        jSONObject.put("iso", marketToCurrencyCode(this.currentMarket));
                        String price = product.getPrice();
                        if (!price.matches("^[0-9]")) {
                            price = price.substring(1);
                        }
                        jSONObject.put(TapjoyConstants.TJC_AMOUNT, price);
                        jSONArray.put(jSONObject);
                    }
                    OneSignal.sendPurchases(jSONArray, false, null);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
            if (purchaseResponse.getRequestStatus() == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                this.currentMarket = purchaseResponse.getUserData().getMarketplace();
                HashSet hashSet = new HashSet();
                hashSet.add(purchaseResponse.getReceipt().getSku());
                this.lastRequestId = PurchasingService.getProductData(hashSet);
            }
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                purchasingListener.onPurchaseResponse(purchaseResponse);
            }
        }

        public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                purchasingListener.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
            }
        }

        public void onUserDataResponse(UserDataResponse userDataResponse) {
            PurchasingListener purchasingListener = this.orgPurchasingListener;
            if (purchasingListener != null) {
                purchasingListener.onUserDataResponse(userDataResponse);
            }
        }
    }

    /* renamed from: com.onesignal.TrackAmazonPurchase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$iap$model$ProductDataResponse$RequestStatus;

        static {
            int[] iArr = new int[ProductDataResponse.RequestStatus.values().length];
            $SwitchMap$com$amazon$device$iap$model$ProductDataResponse$RequestStatus = iArr;
            try {
                iArr[ProductDataResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
