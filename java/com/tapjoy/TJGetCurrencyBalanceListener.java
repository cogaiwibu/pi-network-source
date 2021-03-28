package com.tapjoy;

public interface TJGetCurrencyBalanceListener {
    void onGetCurrencyBalanceResponse(String str, int i);

    void onGetCurrencyBalanceResponseFailure(String str);
}
