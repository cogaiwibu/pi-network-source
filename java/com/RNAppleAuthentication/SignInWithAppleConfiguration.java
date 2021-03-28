package com.RNAppleAuthentication;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0003!\"#B?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "", "clientId", "", "redirectUri", "scope", "responseType", "state", "rawNonce", "nonce", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getNonce", "getRawNonce", "getRedirectUri", "getResponseType", "getScope", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Builder", "ResponseType", "Scope", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SignInWithAppleConfiguration.kt */
public final class SignInWithAppleConfiguration {
    private final String clientId;
    private final String nonce;
    private final String rawNonce;
    private final String redirectUri;
    private final String responseType;
    private final String scope;
    private final String state;

    public static /* synthetic */ SignInWithAppleConfiguration copy$default(SignInWithAppleConfiguration signInWithAppleConfiguration, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signInWithAppleConfiguration.clientId;
        }
        if ((i & 2) != 0) {
            str2 = signInWithAppleConfiguration.redirectUri;
        }
        if ((i & 4) != 0) {
            str3 = signInWithAppleConfiguration.scope;
        }
        if ((i & 8) != 0) {
            str4 = signInWithAppleConfiguration.responseType;
        }
        if ((i & 16) != 0) {
            str5 = signInWithAppleConfiguration.state;
        }
        if ((i & 32) != 0) {
            str6 = signInWithAppleConfiguration.rawNonce;
        }
        if ((i & 64) != 0) {
            str7 = signInWithAppleConfiguration.nonce;
        }
        return signInWithAppleConfiguration.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public final String component1() {
        return this.clientId;
    }

    public final String component2() {
        return this.redirectUri;
    }

    public final String component3() {
        return this.scope;
    }

    public final String component4() {
        return this.responseType;
    }

    public final String component5() {
        return this.state;
    }

    public final String component6() {
        return this.rawNonce;
    }

    public final String component7() {
        return this.nonce;
    }

    public final SignInWithAppleConfiguration copy(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        Intrinsics.checkNotNullParameter(str2, "redirectUri");
        Intrinsics.checkNotNullParameter(str3, "scope");
        Intrinsics.checkNotNullParameter(str4, "responseType");
        Intrinsics.checkNotNullParameter(str5, "state");
        Intrinsics.checkNotNullParameter(str6, "rawNonce");
        Intrinsics.checkNotNullParameter(str7, "nonce");
        return new SignInWithAppleConfiguration(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignInWithAppleConfiguration)) {
            return false;
        }
        SignInWithAppleConfiguration signInWithAppleConfiguration = (SignInWithAppleConfiguration) obj;
        return Intrinsics.areEqual(this.clientId, signInWithAppleConfiguration.clientId) && Intrinsics.areEqual(this.redirectUri, signInWithAppleConfiguration.redirectUri) && Intrinsics.areEqual(this.scope, signInWithAppleConfiguration.scope) && Intrinsics.areEqual(this.responseType, signInWithAppleConfiguration.responseType) && Intrinsics.areEqual(this.state, signInWithAppleConfiguration.state) && Intrinsics.areEqual(this.rawNonce, signInWithAppleConfiguration.rawNonce) && Intrinsics.areEqual(this.nonce, signInWithAppleConfiguration.nonce);
    }

    public int hashCode() {
        String str = this.clientId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.redirectUri;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.scope;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.responseType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.rawNonce;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.nonce;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "SignInWithAppleConfiguration(clientId=" + this.clientId + ", redirectUri=" + this.redirectUri + ", scope=" + this.scope + ", responseType=" + this.responseType + ", state=" + this.state + ", rawNonce=" + this.rawNonce + ", nonce=" + this.nonce + ")";
    }

    private SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.clientId = str;
        this.redirectUri = str2;
        this.scope = str3;
        this.responseType = str4;
        this.state = str5;
        this.rawNonce = str6;
        this.nonce = str7;
    }

    public /* synthetic */ SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getState() {
        return this.state;
    }

    public final String getRawNonce() {
        return this.rawNonce;
    }

    public final String getNonce() {
        return this.nonce;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000fJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Builder;", "", "()V", "clientId", "", "nonce", "rawNonce", "redirectUri", "responseType", "scope", "state", "build", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "type", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleConfiguration.kt */
    public static final class Builder {
        private String clientId;
        private String nonce;
        private String rawNonce;
        private String redirectUri;
        private String responseType;
        private String scope;
        private String state;

        public final Builder clientId(String str) {
            Intrinsics.checkNotNullParameter(str, "clientId");
            Builder builder = this;
            builder.clientId = str;
            return builder;
        }

        public final Builder redirectUri(String str) {
            Intrinsics.checkNotNullParameter(str, "redirectUri");
            Builder builder = this;
            builder.redirectUri = str;
            return builder;
        }

        public final Builder scope(Scope scope2) {
            Intrinsics.checkNotNullParameter(scope2, "scope");
            Builder builder = this;
            builder.scope = scope2.signal();
            return builder;
        }

        public final Builder responseType(ResponseType responseType2) {
            Intrinsics.checkNotNullParameter(responseType2, "type");
            Builder builder = this;
            builder.responseType = responseType2.signal();
            return builder;
        }

        public final Builder state(String str) {
            Intrinsics.checkNotNullParameter(str, "state");
            Builder builder = this;
            builder.state = str;
            return builder;
        }

        public final Builder rawNonce(String str) {
            Intrinsics.checkNotNullParameter(str, "rawNonce");
            Builder builder = this;
            builder.rawNonce = str;
            return builder;
        }

        public final Builder nonce(String str) {
            Intrinsics.checkNotNullParameter(str, "nonce");
            Builder builder = this;
            builder.nonce = str;
            return builder;
        }

        public final SignInWithAppleConfiguration build() {
            String str = this.clientId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clientId");
            }
            String str2 = this.redirectUri;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redirectUri");
            }
            String str3 = this.scope;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
            }
            String str4 = this.responseType;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("responseType");
            }
            String str5 = this.state;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("state");
            }
            String str6 = this.rawNonce;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rawNonce");
            }
            String str7 = this.nonce;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonce");
            }
            return new SignInWithAppleConfiguration(str, str2, str3, str4, str5, str6, str7, null);
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "", "(Ljava/lang/String;I)V", "signal", "", "CODE", "ID_TOKEN", "ALL", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleConfiguration.kt */
    public static final class ResponseType extends Enum<ResponseType> {
        private static final /* synthetic */ ResponseType[] $VALUES;
        public static final ResponseType ALL;
        public static final ResponseType CODE;
        public static final ResponseType ID_TOKEN;

        static {
            CODE code = new CODE("CODE", 0);
            CODE = code;
            ID_TOKEN id_token = new ID_TOKEN("ID_TOKEN", 1);
            ID_TOKEN = id_token;
            ALL all = new ALL("ALL", 2);
            ALL = all;
            $VALUES = new ResponseType[]{code, id_token, all};
        }

        public static ResponseType valueOf(String str) {
            return (ResponseType) Enum.valueOf(ResponseType.class, str);
        }

        public static ResponseType[] values() {
            return (ResponseType[]) $VALUES.clone();
        }

        public abstract String signal();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$CODE;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class CODE extends ResponseType {
            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "code";
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            CODE(String str, int i) {
                super(str, i, null);
            }
        }

        private ResponseType(String str, int i) {
        }

        public /* synthetic */ ResponseType(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$ID_TOKEN;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class ID_TOKEN extends ResponseType {
            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "id_token";
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            ID_TOKEN(String str, int i) {
                super(str, i, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType$ALL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class ALL extends ResponseType {
            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "code id_token";
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            ALL(String str, int i) {
                super(str, i, null);
            }
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "", "(Ljava/lang/String;I)V", "signal", "", "NAME", "EMAIL", "ALL", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleConfiguration.kt */
    public static final class Scope extends Enum<Scope> {
        private static final /* synthetic */ Scope[] $VALUES;
        public static final Scope ALL;
        public static final Scope EMAIL;
        public static final Scope NAME;

        static {
            NAME name = new NAME("NAME", 0);
            NAME = name;
            EMAIL email = new EMAIL("EMAIL", 1);
            EMAIL = email;
            ALL all = new ALL("ALL", 2);
            ALL = all;
            $VALUES = new Scope[]{name, email, all};
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }

        public abstract String signal();

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$NAME;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class NAME extends Scope {
            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "name";
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            NAME(String str, int i) {
                super(str, i, null);
            }
        }

        private Scope(String str, int i) {
        }

        public /* synthetic */ Scope(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$EMAIL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class EMAIL extends Scope {
            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "email";
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            EMAIL(String str, int i) {
                super(str, i, null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope$ALL;", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
        /* compiled from: SignInWithAppleConfiguration.kt */
        static final class ALL extends Scope {
            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "name email";
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            ALL(String str, int i) {
                super(str, i, null);
            }
        }
    }
}
