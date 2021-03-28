package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

public class FirebaseInstallationsException extends FirebaseException {
    private final Status status;

    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(Status status2) {
        this.status = status2;
    }

    public FirebaseInstallationsException(String str, Status status2) {
        super(str);
        this.status = status2;
    }

    public FirebaseInstallationsException(String str, Status status2, Throwable th) {
        super(str, th);
        this.status = status2;
    }

    public Status getStatus() {
        return this.status;
    }
}
