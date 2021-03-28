package com.RNAppleAuthentication;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "", "onSignInWithAppleCancel", "", "onSignInWithAppleFailure", "error", "", "onSignInWithAppleSuccess", "code", "", "id_token", "state", "user", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SignInWithAppleCallback.kt */
public interface SignInWithAppleCallback {
    void onSignInWithAppleCancel();

    void onSignInWithAppleFailure(Throwable th);

    void onSignInWithAppleSuccess(String str, String str2, String str3, String str4);
}
