package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zaae {
    private final ApiKey<?> zaft;
    private final TaskCompletionSource<Boolean> zafu = new TaskCompletionSource<>();

    public zaae(ApiKey<?> apiKey) {
        this.zaft = apiKey;
    }

    public final ApiKey<?> getApiKey() {
        return this.zaft;
    }

    public final TaskCompletionSource<Boolean> zaaj() {
        return this.zafu;
    }
}
