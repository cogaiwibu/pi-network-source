package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.fr;
import java.util.Map;
import java.util.UUID;
import org.w3c.dom.Document;

public class TJCurrency {
    private static TJGetCurrencyBalanceListener d;
    private static TJSpendCurrencyListener e;
    private static TJAwardCurrencyListener f;
    private static TJEarnedCurrencyListener g;
    String a = null;
    int b = 0;
    Context c;

    public TJCurrency(Context context) {
        this.c = context;
    }

    public void saveCurrencyBalance(int i) {
        SharedPreferences.Editor edit = this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putInt(TapjoyConstants.PREF_LAST_CURRENCY_BALANCE, i);
        edit.apply();
    }

    public int getLocalCurrencyBalance() {
        return this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).getInt(TapjoyConstants.PREF_LAST_CURRENCY_BALANCE, -9999);
    }

    public void getCurrencyBalance(TJGetCurrencyBalanceListener tJGetCurrencyBalanceListener) {
        d = tJGetCurrencyBalanceListener;
        final Map uRLParams = TapjoyConnectCore.getURLParams();
        new Thread(new Runnable() {
            /* class com.tapjoy.TJCurrency.AnonymousClass1 */

            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                TJCurrency.this.a(tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_GET_CURRENCY_BALANCE_URL_PATH, uRLParams));
            }
        }).start();
    }

    public void spendCurrency(int i, TJSpendCurrencyListener tJSpendCurrencyListener) {
        if (i < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the spendCurrency API"));
            return;
        }
        this.a = String.valueOf(i);
        e = tJSpendCurrencyListener;
        final Map uRLParams = TapjoyConnectCore.getURLParams();
        TapjoyUtil.safePut(uRLParams, TapjoyConstants.TJC_CURRENCY, this.a, true);
        new Thread(new Runnable() {
            /* class com.tapjoy.TJCurrency.AnonymousClass2 */

            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                TJCurrency.this.b(tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_SPEND_CURRENCY_URL_PATH, uRLParams));
            }
        }).start();
    }

    public void awardCurrency(int i, TJAwardCurrencyListener tJAwardCurrencyListener) {
        if (i < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the awardCurrency API"));
            return;
        }
        this.b = i;
        f = tJAwardCurrencyListener;
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        final Map genericURLParams = TapjoyConnectCore.getGenericURLParams();
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_CURRENCY, String.valueOf(this.b), true);
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_GUID, uuid, true);
        TapjoyUtil.safePut(genericURLParams, "timestamp", String.valueOf(currentTimeMillis), true);
        TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_VERIFIER, TapjoyConnectCore.getAwardCurrencyVerifier(currentTimeMillis, this.b, uuid), true);
        new Thread(new Runnable() {
            /* class com.tapjoy.TJCurrency.AnonymousClass3 */

            public final void run() {
                TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
                TJCurrency.this.c(tapjoyURLConnection.getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_AWARD_CURRENCY_URL_PATH, genericURLParams));
            }
        }).start();
    }

    public void setEarnedCurrencyListener(TJEarnedCurrencyListener tJEarnedCurrencyListener) {
        g = tJEarnedCurrencyListener;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void a(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        if (tapjoyHttpURLResponse.response != null) {
            Document buildDocument = TapjoyUtil.buildDocument(tapjoyHttpURLResponse.response);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue == null || !nodeTrimValue.equals("true")) {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing <Success> tag."));
                } else {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue2 == null || nodeTrimValue3 == null) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing tags."));
                    } else {
                        try {
                            int parseInt = Integer.parseInt(nodeTrimValue2);
                            int localCurrencyBalance = getLocalCurrencyBalance();
                            if (!(g == null || localCurrencyBalance == -9999 || parseInt <= localCurrencyBalance)) {
                                StringBuilder sb = new StringBuilder("earned: ");
                                int i = parseInt - localCurrencyBalance;
                                sb.append(i);
                                TapjoyLog.i("TJCurrency", sb.toString());
                                g.onEarnedCurrency(nodeTrimValue3, i);
                            }
                            saveCurrencyBalance(parseInt);
                            if (d != null) {
                                d.onGetCurrencyBalanceResponse(nodeTrimValue3, parseInt);
                            }
                            return;
                        } catch (Exception e2) {
                            TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.SERVER_ERROR;
                            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(errorType, "Error parsing XML and calling listener: " + e2.toString()));
                        }
                    }
                }
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "getCurrencyBalance response is NULL"));
        }
        if (d != null) {
            d.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void b(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = "Failed to spend currency";
        if (tapjoyHttpURLResponse.response != null) {
            Document buildDocument = TapjoyUtil.buildDocument(tapjoyHttpURLResponse.response);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue != null && nodeTrimValue.equals("true")) {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue2 == null || nodeTrimValue3 == null) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing tags."));
                    } else {
                        int parseInt = Integer.parseInt(nodeTrimValue2);
                        saveCurrencyBalance(parseInt);
                        if (e != null) {
                            e.onSpendCurrencyResponse(nodeTrimValue3, parseInt);
                        }
                        return;
                    }
                } else if (nodeTrimValue == null || !nodeTrimValue.endsWith("false")) {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing <Success> tag."));
                } else {
                    str = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Message"));
                    TapjoyLog.i("TJCurrency", str);
                    if ("BalanceTooLowError".equals(TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("MessageCode")))) {
                        fr.a();
                    }
                }
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "spendCurrency response is NULL"));
        }
        if (e != null) {
            e.onSpendCurrencyResponseFailure(str);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void c(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = "Failed to award currency";
        if (tapjoyHttpURLResponse.response != null) {
            Document buildDocument = TapjoyUtil.buildDocument(tapjoyHttpURLResponse.response);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue != null && nodeTrimValue.equals("true")) {
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue3 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue2 == null || nodeTrimValue3 == null) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing tags."));
                    } else {
                        int parseInt = Integer.parseInt(nodeTrimValue2);
                        saveCurrencyBalance(parseInt);
                        if (f != null) {
                            f.onAwardCurrencyResponse(nodeTrimValue3, parseInt);
                        }
                        return;
                    }
                } else if (nodeTrimValue == null || !nodeTrimValue.endsWith("false")) {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing <Success> tag."));
                } else {
                    str = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Message"));
                    TapjoyLog.i("TJCurrency", str);
                }
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SERVER_ERROR, "awardCurrency response is NULL"));
        }
        if (f != null) {
            f.onAwardCurrencyResponseFailure(str);
        }
    }
}
