package com.google.firebase.installations;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
public interface FirebaseInstallationsApi {
    Task<Void> delete();

    Task<String> getId();

    Task<InstallationTokenResult> getToken(boolean z);
}
