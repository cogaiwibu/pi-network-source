package com.onesignal;

class UserStateEmail extends UserState {
    /* access modifiers changed from: protected */
    @Override // com.onesignal.UserState
    public void addDependFields() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserState
    public boolean isSubscribed() {
        return true;
    }

    UserStateEmail(String str, boolean z) {
        super("email" + str, z);
    }

    /* access modifiers changed from: package-private */
    @Override // com.onesignal.UserState
    public UserState newInstance(String str) {
        return new UserStateEmail(str, false);
    }
}
