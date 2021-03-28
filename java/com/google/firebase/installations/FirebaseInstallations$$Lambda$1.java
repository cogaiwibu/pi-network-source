package com.google.firebase.installations;

/* access modifiers changed from: package-private */
/* compiled from: FirebaseInstallations */
public final /* synthetic */ class FirebaseInstallations$$Lambda$1 implements Runnable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$1(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Runnable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        return new FirebaseInstallations$$Lambda$1(firebaseInstallations);
    }

    public void run() {
        this.arg$1.doRegistrationOrRefresh(false);
    }
}
