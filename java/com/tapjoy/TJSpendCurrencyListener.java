package com.tapjoy;

public interface TJSpendCurrencyListener {
    void onSpendCurrencyResponse(String str, int i);

    void onSpendCurrencyResponseFailure(String str);
}
