package com.RNAppleAuthentication;

import com.RNAppleAuthentication.SignInWithAppleResult;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", IronSourceConstants.EVENTS_RESULT, "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: SignInWithAppleCallback.kt */
public final class SignInWithAppleCallbackKt$toFunction$1 extends Lambda implements Function1<SignInWithAppleResult, Unit> {
    final /* synthetic */ SignInWithAppleCallback $this_toFunction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignInWithAppleCallbackKt$toFunction$1(SignInWithAppleCallback signInWithAppleCallback) {
        super(1);
        this.$this_toFunction = signInWithAppleCallback;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SignInWithAppleResult signInWithAppleResult) {
        invoke(signInWithAppleResult);
        return Unit.INSTANCE;
    }

    public final void invoke(SignInWithAppleResult signInWithAppleResult) {
        Intrinsics.checkNotNullParameter(signInWithAppleResult, IronSourceConstants.EVENTS_RESULT);
        if (signInWithAppleResult instanceof SignInWithAppleResult.Success) {
            SignInWithAppleResult.Success success = (SignInWithAppleResult.Success) signInWithAppleResult;
            this.$this_toFunction.onSignInWithAppleSuccess(success.getCode(), success.getId_token(), success.getState(), success.getUser());
        } else if (signInWithAppleResult instanceof SignInWithAppleResult.Failure) {
            this.$this_toFunction.onSignInWithAppleFailure(((SignInWithAppleResult.Failure) signInWithAppleResult).getError());
        } else if (signInWithAppleResult instanceof SignInWithAppleResult.Cancel) {
            this.$this_toFunction.onSignInWithAppleCancel();
        }
    }
}
