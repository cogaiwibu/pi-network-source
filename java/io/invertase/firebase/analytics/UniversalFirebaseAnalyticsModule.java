package io.invertase.firebase.analytics;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.common.UniversalFirebaseModule;
import java.util.Set;
import java.util.concurrent.Callable;

public class UniversalFirebaseAnalyticsModule extends UniversalFirebaseModule {
    UniversalFirebaseAnalyticsModule(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> logEvent(String str, Bundle bundle) {
        return Tasks.call(new Callable(str, bundle) {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$ZQe_Xsa0OplZCH9I7qfMtrOQi6Q */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ Bundle f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$logEvent$0$UniversalFirebaseAnalyticsModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ Void lambda$logEvent$0$UniversalFirebaseAnalyticsModule(String str, Bundle bundle) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).logEvent(str, bundle);
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> setAnalyticsCollectionEnabled(Boolean bool) {
        return Tasks.call(new Callable(bool) {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$h7XtGyeEPyOdtSL3TV6rQUGC5N8 */
            private final /* synthetic */ Boolean f$1;

            {
                this.f$1 = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$setAnalyticsCollectionEnabled$1$UniversalFirebaseAnalyticsModule(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$setAnalyticsCollectionEnabled$1$UniversalFirebaseAnalyticsModule(Boolean bool) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setAnalyticsCollectionEnabled(bool.booleanValue());
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> setSessionTimeoutDuration(long j) {
        return Tasks.call(new Callable(j) {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$kFpwn5QUucNzcudYufxtxoOAl58 */
            private final /* synthetic */ long f$1;

            {
                this.f$1 = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$setSessionTimeoutDuration$2$UniversalFirebaseAnalyticsModule(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$setSessionTimeoutDuration$2$UniversalFirebaseAnalyticsModule(long j) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setSessionTimeoutDuration(j);
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> setUserId(String str) {
        return Tasks.call(new Callable(str) {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$H15IcDZFJD1Dlb0ghoNtmLIdRo */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$setUserId$3$UniversalFirebaseAnalyticsModule(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$setUserId$3$UniversalFirebaseAnalyticsModule(String str) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setUserId(str);
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> setUserProperty(String str, String str2) {
        return Tasks.call(new Callable(str, str2) {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$hfaEsFTWz3H4iTmrYLqGV7x1bRo */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$setUserProperty$4$UniversalFirebaseAnalyticsModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ Void lambda$setUserProperty$4$UniversalFirebaseAnalyticsModule(String str, String str2) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setUserProperty(str, str2);
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> setUserProperties(Bundle bundle) {
        return Tasks.call(new Callable(bundle) {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$I_5KrFilAfj3tOBDDdYvhHPqxWo */
            private final /* synthetic */ Bundle f$1;

            {
                this.f$1 = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$setUserProperties$5$UniversalFirebaseAnalyticsModule(this.f$1);
            }
        });
    }

    public /* synthetic */ Void lambda$setUserProperties$5$UniversalFirebaseAnalyticsModule(Bundle bundle) throws Exception {
        Set<String> keySet = bundle.keySet();
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(getContext());
        for (String str : keySet) {
            instance.setUserProperty(str, (String) bundle.get(str));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Task<Void> resetAnalyticsData() {
        return Tasks.call(new Callable() {
            /* class io.invertase.firebase.analytics.$$Lambda$UniversalFirebaseAnalyticsModule$vEBRPt1tqPVmAXG_XTs0YmdWQKA */

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseAnalyticsModule.this.lambda$resetAnalyticsData$6$UniversalFirebaseAnalyticsModule();
            }
        });
    }

    public /* synthetic */ Void lambda$resetAnalyticsData$6$UniversalFirebaseAnalyticsModule() throws Exception {
        FirebaseAnalytics.getInstance(getContext()).resetAnalyticsData();
        return null;
    }
}
