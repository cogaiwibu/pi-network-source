package com.RNAppleAuthentication;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toFunction", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "invertase_react-native-apple-authentication_release"}, k = 2, mv = {1, 4, 0})
/* compiled from: SignInWithAppleCallback.kt */
public final class SignInWithAppleCallbackKt {
    public static final Function1<SignInWithAppleResult, Unit> toFunction(SignInWithAppleCallback signInWithAppleCallback) {
        Intrinsics.checkNotNullParameter(signInWithAppleCallback, "$this$toFunction");
        return new SignInWithAppleCallbackKt$toFunction$1(signInWithAppleCallback);
    }
}
