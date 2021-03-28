package com.RNAppleAuthentication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.RNAppleAuthentication.webview.SignInWebViewDialogFragment;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\rR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService;", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragmentTag", "", "configuration", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "callback", "Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;Lcom/RNAppleAuthentication/SignInWithAppleCallback;)V", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;Lkotlin/jvm/functions/Function1;)V", "show", "AuthenticationAttempt", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SignInWithAppleService.kt */
public final class SignInWithAppleService {
    private final Function1<SignInWithAppleResult, Unit> callback;
    private final SignInWithAppleConfiguration configuration;
    private final FragmentManager fragmentManager;
    private final String fragmentTag;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super com.RNAppleAuthentication.SignInWithAppleResult, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public SignInWithAppleService(FragmentManager fragmentManager2, String str, SignInWithAppleConfiguration signInWithAppleConfiguration, Function1<? super SignInWithAppleResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, "fragmentTag");
        Intrinsics.checkNotNullParameter(signInWithAppleConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.fragmentManager = fragmentManager2;
        this.fragmentTag = str;
        this.configuration = signInWithAppleConfiguration;
        this.callback = function1;
        Fragment findFragmentByTag = fragmentManager2.findFragmentByTag(str);
        SignInWebViewDialogFragment signInWebViewDialogFragment = (SignInWebViewDialogFragment) (!(findFragmentByTag instanceof SignInWebViewDialogFragment) ? null : findFragmentByTag);
        if (signInWebViewDialogFragment != null) {
            signInWebViewDialogFragment.configure(this.callback);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SignInWithAppleService(FragmentManager fragmentManager2, String str, SignInWithAppleConfiguration signInWithAppleConfiguration, SignInWithAppleCallback signInWithAppleCallback) {
        this(fragmentManager2, str, signInWithAppleConfiguration, SignInWithAppleCallbackKt.toFunction(signInWithAppleCallback));
        Intrinsics.checkNotNullParameter(fragmentManager2, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, "fragmentTag");
        Intrinsics.checkNotNullParameter(signInWithAppleConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(signInWithAppleCallback, "callback");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "authenticationUri", "", "redirectUri", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthenticationUri", "()Ljava/lang/String;", "getRedirectUri", "getState", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleService.kt */
    public static final class AuthenticationAttempt implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR(null);
        private final String authenticationUri;
        private final String redirectUri;
        private final String state;

        public static /* synthetic */ AuthenticationAttempt copy$default(AuthenticationAttempt authenticationAttempt, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = authenticationAttempt.authenticationUri;
            }
            if ((i & 2) != 0) {
                str2 = authenticationAttempt.redirectUri;
            }
            if ((i & 4) != 0) {
                str3 = authenticationAttempt.state;
            }
            return authenticationAttempt.copy(str, str2, str3);
        }

        public final String component1() {
            return this.authenticationUri;
        }

        public final String component2() {
            return this.redirectUri;
        }

        public final String component3() {
            return this.state;
        }

        public final AuthenticationAttempt copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "authenticationUri");
            Intrinsics.checkNotNullParameter(str2, "redirectUri");
            Intrinsics.checkNotNullParameter(str3, "state");
            return new AuthenticationAttempt(str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AuthenticationAttempt)) {
                return false;
            }
            AuthenticationAttempt authenticationAttempt = (AuthenticationAttempt) obj;
            return Intrinsics.areEqual(this.authenticationUri, authenticationAttempt.authenticationUri) && Intrinsics.areEqual(this.redirectUri, authenticationAttempt.redirectUri) && Intrinsics.areEqual(this.state, authenticationAttempt.state);
        }

        public int hashCode() {
            String str = this.authenticationUri;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.redirectUri;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.state;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "AuthenticationAttempt(authenticationUri=" + this.authenticationUri + ", redirectUri=" + this.redirectUri + ", state=" + this.state + ")";
        }

        public AuthenticationAttempt(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "authenticationUri");
            Intrinsics.checkNotNullParameter(str2, "redirectUri");
            Intrinsics.checkNotNullParameter(str3, "state");
            this.authenticationUri = str;
            this.redirectUri = str2;
            this.state = str3;
        }

        public final String getAuthenticationUri() {
            return this.authenticationUri;
        }

        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final String getState() {
            return this.state;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AuthenticationAttempt(android.os.Parcel r4) {
            /*
                r3 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r0 = r4.readString()
                java.lang.String r1 = "invalid"
                if (r0 == 0) goto L_0x000e
                goto L_0x000f
            L_0x000e:
                r0 = r1
            L_0x000f:
                java.lang.String r2 = r4.readString()
                if (r2 == 0) goto L_0x0016
                goto L_0x0017
            L_0x0016:
                r2 = r1
            L_0x0017:
                java.lang.String r4 = r4.readString()
                if (r4 == 0) goto L_0x001e
                r1 = r4
            L_0x001e:
                r3.<init>(r0, r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.RNAppleAuthentication.SignInWithAppleService.AuthenticationAttempt.<init>(android.os.Parcel):void");
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.authenticationUri);
            parcel.writeString(this.redirectUri);
            parcel.writeString(this.state);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "()V", "create", "configuration", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleService.kt */
        public static final class CREATOR implements Parcelable.Creator<AuthenticationAttempt> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            public AuthenticationAttempt createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AuthenticationAttempt(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public AuthenticationAttempt[] newArray(int i) {
                return new AuthenticationAttempt[i];
            }

            public final AuthenticationAttempt create(SignInWithAppleConfiguration signInWithAppleConfiguration) {
                Intrinsics.checkNotNullParameter(signInWithAppleConfiguration, "configuration");
                Uri.Builder buildUpon = Uri.parse("https://appleid.apple.com/auth/authorize").buildUpon();
                buildUpon.appendQueryParameter("client_id", signInWithAppleConfiguration.getClientId());
                buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, signInWithAppleConfiguration.getRedirectUri());
                buildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, signInWithAppleConfiguration.getResponseType());
                buildUpon.appendQueryParameter("scope", signInWithAppleConfiguration.getScope());
                buildUpon.appendQueryParameter("response_mode", "form_post");
                buildUpon.appendQueryParameter("state", signInWithAppleConfiguration.getState());
                if (!StringsKt.isBlank(signInWithAppleConfiguration.getNonce())) {
                    buildUpon.appendQueryParameter("nonce", signInWithAppleConfiguration.getNonce());
                }
                String uri = buildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "Uri\n          .parse(\"ht…d()\n          .toString()");
                return new AuthenticationAttempt(uri, signInWithAppleConfiguration.getRedirectUri(), signInWithAppleConfiguration.getState());
            }
        }
    }

    public final void show() {
        SignInWebViewDialogFragment newInstance = SignInWebViewDialogFragment.Companion.newInstance(AuthenticationAttempt.CREATOR.create(this.configuration));
        newInstance.configure(this.callback);
        newInstance.show(this.fragmentManager, this.fragmentTag);
    }
}
