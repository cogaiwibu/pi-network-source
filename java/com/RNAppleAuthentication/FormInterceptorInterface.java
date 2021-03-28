package com.RNAppleAuthentication;

import android.webkit.JavascriptInterface;
import com.RNAppleAuthentication.SignInWithAppleResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/RNAppleAuthentication/FormInterceptorInterface;", "", "expectedState", "", "callback", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "processFormData", "formData", "Companion", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FormInterceptorInterface.kt */
public final class FormInterceptorInterface {
    private static final String CODE = "code";
    public static final Companion Companion = new Companion(null);
    private static final String FORM_DATA_SEPARATOR = "|";
    private static final String JS_TO_INJECT = "function parseForm(form){\n\n    var values = '';\n    for(var i=0 ; i< form.elements.length; i++){\n        values +=\n            form.elements[i].name +\n            '=' +\n            form.elements[i].value +\n            '|'\n    }\n    FormInterceptorInterface.processFormData(values);\n}\n\n\nfor(var i=0 ; i< document.forms.length ; i++){\n    parseForm(document.forms[i]);\n}";
    private static final String KEY_VALUE_SEPARATOR = "=";
    public static final String NAME = "FormInterceptorInterface";
    private static final String STATE = "state";
    private static final String TOKEN = "id_token";
    private static final String USER = "user";
    private final Function1<SignInWithAppleResult, Unit> callback;
    private final String expectedState;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.RNAppleAuthentication.SignInWithAppleResult, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public FormInterceptorInterface(String str, Function1<? super SignInWithAppleResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "expectedState");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.expectedState = str;
        this.callback = function1;
    }

    @JavascriptInterface
    public final void processFormData(String str) {
        String str2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(str, "formData");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{FORM_DATA_SEPARATOR}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        while (true) {
            str2 = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.startsWith$default((String) obj, TOKEN, false, 2, (Object) null)) {
                break;
            }
        }
        String str3 = (String) obj;
        Iterator it2 = split$default.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (StringsKt.startsWith$default((String) obj2, CODE, false, 2, (Object) null)) {
                break;
            }
        }
        String str4 = (String) obj2;
        Iterator it3 = split$default.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (StringsKt.startsWith$default((String) obj3, "state", false, 2, (Object) null)) {
                break;
            }
        }
        String str5 = (String) obj3;
        Iterator it4 = split$default.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it4.next();
            if (StringsKt.startsWith$default((String) obj4, USER, false, 2, (Object) null)) {
                break;
            }
        }
        String str6 = (String) obj4;
        if (str5 == null || (str4 == null && str3 == null && str6 == null)) {
            this.callback.invoke(SignInWithAppleResult.Cancel.INSTANCE);
            return;
        }
        String substringAfter$default = StringsKt.substringAfter$default(str5, "=", (String) null, 2, (Object) null);
        String substringAfter$default2 = str4 != null ? StringsKt.substringAfter$default(str4, "=", (String) null, 2, (Object) null) : null;
        String substringAfter$default3 = str3 != null ? StringsKt.substringAfter$default(str3, "=", (String) null, 2, (Object) null) : null;
        if (str6 != null) {
            str2 = StringsKt.substringAfter$default(str6, "=", (String) null, 2, (Object) null);
        }
        if (Intrinsics.areEqual(substringAfter$default, this.expectedState)) {
            Function1<SignInWithAppleResult, Unit> function1 = this.callback;
            if (substringAfter$default2 == null) {
                substringAfter$default2 = "";
            }
            if (substringAfter$default3 == null) {
                substringAfter$default3 = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            function1.invoke(new SignInWithAppleResult.Success(substringAfter$default2, substringAfter$default3, substringAfter$default, str2));
            return;
        }
        this.callback.invoke(new SignInWithAppleResult.Failure(new IllegalArgumentException("state does not match")));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/RNAppleAuthentication/FormInterceptorInterface$Companion;", "", "()V", "CODE", "", "FORM_DATA_SEPARATOR", "JS_TO_INJECT", "getJS_TO_INJECT", "()Ljava/lang/String;", "KEY_VALUE_SEPARATOR", "NAME", "STATE", "TOKEN", "USER", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FormInterceptorInterface.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getJS_TO_INJECT() {
            return FormInterceptorInterface.JS_TO_INJECT;
        }
    }
}
