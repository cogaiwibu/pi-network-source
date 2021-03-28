package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;

public class TJSpendCurrencyListenerNative implements TJSpendCurrencyListener {
    private final long a;

    private static native void onSpendCurrencyResponseFailureNative(long j, String str);

    private static native void onSpendCurrencyResponseNative(long j, String str, int i);

    private TJSpendCurrencyListenerNative(long j) {
        if (j != 0) {
            this.a = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.tapjoy.TJSpendCurrencyListener
    public void onSpendCurrencyResponse(String str, int i) {
        onSpendCurrencyResponseNative(this.a, str, i);
    }

    @Override // com.tapjoy.TJSpendCurrencyListener
    public void onSpendCurrencyResponseFailure(String str) {
        onSpendCurrencyResponseFailureNative(this.a, str);
    }

    static Object create(long j) {
        return new TJSpendCurrencyListenerNative(j);
    }
}
