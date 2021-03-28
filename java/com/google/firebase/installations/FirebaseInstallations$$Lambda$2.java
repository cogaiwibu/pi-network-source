package com.google.firebase.installations;

/* compiled from: FirebaseInstallations */
final /* synthetic */ class FirebaseInstallations$$Lambda$2 implements Runnable {
    private final FirebaseInstallations arg$1;
    private final boolean arg$2;

    private FirebaseInstallations$$Lambda$2(FirebaseInstallations firebaseInstallations, boolean z) {
        this.arg$1 = firebaseInstallations;
        this.arg$2 = z;
    }

    public static Runnable lambdaFactory$(FirebaseInstallations firebaseInstallations, boolean z) {
        return new FirebaseInstallations$$Lambda$2(firebaseInstallations, z);
    }

    public void run() {
        this.arg$1.doRegistrationOrRefresh(this.arg$2);
    }
}
