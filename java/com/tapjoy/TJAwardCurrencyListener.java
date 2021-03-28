package com.tapjoy;

public interface TJAwardCurrencyListener {
    void onAwardCurrencyResponse(String str, int i);

    void onAwardCurrencyResponseFailure(String str);
}
