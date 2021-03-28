package io.invertase.firebase.common;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.OverridingMethodsMustInvokeSuper;

public class UniversalFirebaseModule {
    private static Map<String, ExecutorService> executors = new HashMap();
    private final Context context;
    private final String serviceName;

    protected UniversalFirebaseModule(Context context2, String str) {
        this.context = context2;
        this.serviceName = str;
    }

    public Context getContext() {
        return this.context;
    }

    public Context getApplicationContext() {
        return getContext().getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public ExecutorService getExecutor() {
        ExecutorService executorService = executors.get(getName());
        if (executorService != null) {
            return executorService;
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executors.put(getName(), newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public String getName() {
        return "Universal" + this.serviceName + "Module";
    }

    @OverridingMethodsMustInvokeSuper
    public void onTearDown() {
        ExecutorService executorService = executors.get(getName());
        if (executorService != null) {
            executorService.shutdownNow();
            executors.remove(getName());
        }
    }

    public Map<String, Object> getConstants() {
        return new HashMap();
    }
}
