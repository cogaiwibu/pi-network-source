package com.RNAppleAuthentication.webview;

import com.RNAppleAuthentication.SignInWithAppleResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: SignInWebViewDialogFragment.kt */
final /* synthetic */ class SignInWebViewDialogFragment$onCreateView$formInterceptorInterface$1 extends FunctionReferenceImpl implements Function1<SignInWithAppleResult, Unit> {
    SignInWebViewDialogFragment$onCreateView$formInterceptorInterface$1(SignInWebViewDialogFragment signInWebViewDialogFragment) {
        super(1, signInWebViewDialogFragment, SignInWebViewDialogFragment.class, "onCallback", "onCallback(Lcom/RNAppleAuthentication/SignInWithAppleResult;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SignInWithAppleResult signInWithAppleResult) {
        invoke(signInWithAppleResult);
        return Unit.INSTANCE;
    }

    public final void invoke(SignInWithAppleResult signInWithAppleResult) {
        Intrinsics.checkNotNullParameter(signInWithAppleResult, "p1");
        ((SignInWebViewDialogFragment) this.receiver).onCallback(signInWithAppleResult);
    }
}
