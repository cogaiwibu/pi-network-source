package com.RNAppleAuthentication.webview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import com.RNAppleAuthentication.FormInterceptorInterface;
import com.RNAppleAuthentication.R;
import com.RNAppleAuthentication.SignInWithAppleResult;
import com.RNAppleAuthentication.SignInWithAppleService;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY, "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "callback", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "webViewIfCreated", "Landroid/webkit/WebView;", "getWebViewIfCreated", "()Landroid/webkit/WebView;", "configure", "onCallback", IronSourceConstants.EVENTS_RESULT, "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onStart", "Companion", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SignInWebViewDialogFragment.kt */
public final class SignInWebViewDialogFragment extends DialogFragment {
    private static final String AUTHENTICATION_ATTEMPT_KEY = "authenticationAttempt";
    public static final Companion Companion = new Companion(null);
    private static final String WEB_VIEW_KEY = "webView";
    private SignInWithAppleService.AuthenticationAttempt authenticationAttempt;
    private Function1<? super SignInWithAppleResult, Unit> callback;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewDialogFragment$Companion;", "", "()V", "AUTHENTICATION_ATTEMPT_KEY", "", "WEB_VIEW_KEY", "newInstance", "Lcom/RNAppleAuthentication/webview/SignInWebViewDialogFragment;", SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY, "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWebViewDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignInWebViewDialogFragment newInstance(SignInWithAppleService.AuthenticationAttempt authenticationAttempt) {
            Intrinsics.checkNotNullParameter(authenticationAttempt, SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY);
            SignInWebViewDialogFragment signInWebViewDialogFragment = new SignInWebViewDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY, authenticationAttempt);
            Unit unit = Unit.INSTANCE;
            signInWebViewDialogFragment.setArguments(bundle);
            return signInWebViewDialogFragment;
        }
    }

    private final WebView getWebViewIfCreated() {
        View view = getView();
        if (!(view instanceof WebView)) {
            view = null;
        }
        return (WebView) view;
    }

    public final void configure(Function1<? super SignInWithAppleResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.callback = function1;
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt2 = arguments != null ? (SignInWithAppleService.AuthenticationAttempt) arguments.getParcelable(AUTHENTICATION_ATTEMPT_KEY) : null;
        Intrinsics.checkNotNull(authenticationAttempt2);
        this.authenticationAttempt = authenticationAttempt2;
        setStyle(0, R.style.sign_in_with_apple_button_DialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        WebView webView = new WebView(context);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt2 = this.authenticationAttempt;
        if (authenticationAttempt2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AUTHENTICATION_ATTEMPT_KEY);
        }
        webView.addJavascriptInterface(new FormInterceptorInterface(authenticationAttempt2.getState(), new SignInWebViewDialogFragment$onCreateView$formInterceptorInterface$1(this)), FormInterceptorInterface.NAME);
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt3 = this.authenticationAttempt;
        if (authenticationAttempt3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AUTHENTICATION_ATTEMPT_KEY);
        }
        webView.setWebViewClient(new SignInWebViewClient(authenticationAttempt3, FormInterceptorInterface.Companion.getJS_TO_INJECT()));
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle(WEB_VIEW_KEY);
            if (bundle2 != null) {
                webView.restoreState(bundle2);
            }
        } else {
            SignInWithAppleService.AuthenticationAttempt authenticationAttempt4 = this.authenticationAttempt;
            if (authenticationAttempt4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AUTHENTICATION_ATTEMPT_KEY);
            }
            webView.loadUrl(authenticationAttempt4.getAuthenticationUri());
        }
        return webView;
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = new Bundle();
        WebView webViewIfCreated = getWebViewIfCreated();
        if (webViewIfCreated != null) {
            webViewIfCreated.saveState(bundle2);
        }
        Unit unit = Unit.INSTANCE;
        bundle.putBundle(WEB_VIEW_KEY, bundle2);
    }

    @Override // androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void onCancel(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        onCallback(SignInWithAppleResult.Cancel.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void onCallback(SignInWithAppleResult signInWithAppleResult) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        Function1<? super SignInWithAppleResult, Unit> function1 = this.callback;
        if (function1 != null) {
            function1.invoke(signInWithAppleResult);
        }
    }
}
