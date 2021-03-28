package com.RNAppleAuthentication;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "()V", "Cancel", "Failure", "Success", "Lcom/RNAppleAuthentication/SignInWithAppleResult$Success;", "Lcom/RNAppleAuthentication/SignInWithAppleResult$Failure;", "Lcom/RNAppleAuthentication/SignInWithAppleResult$Cancel;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SignInWithAppleResult.kt */
public abstract class SignInWithAppleResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleResult$Success;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "code", "", "id_token", "state", "user", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getId_token", "getState", "getUser", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleResult.kt */
    public static final class Success extends SignInWithAppleResult {
        private final String code;
        private final String id_token;
        private final String state;
        private final String user;

        public static /* synthetic */ Success copy$default(Success success, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = success.code;
            }
            if ((i & 2) != 0) {
                str2 = success.id_token;
            }
            if ((i & 4) != 0) {
                str3 = success.state;
            }
            if ((i & 8) != 0) {
                str4 = success.user;
            }
            return success.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.id_token;
        }

        public final String component3() {
            return this.state;
        }

        public final String component4() {
            return this.user;
        }

        public final Success copy(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, "id_token");
            Intrinsics.checkNotNullParameter(str3, "state");
            Intrinsics.checkNotNullParameter(str4, "user");
            return new Success(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual(this.code, success.code) && Intrinsics.areEqual(this.id_token, success.id_token) && Intrinsics.areEqual(this.state, success.state) && Intrinsics.areEqual(this.user, success.user);
        }

        public int hashCode() {
            String str = this.code;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.id_token;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.state;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.user;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "Success(code=" + this.code + ", id_token=" + this.id_token + ", state=" + this.state + ", user=" + this.user + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(String str, String str2, String str3, String str4) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "code");
            Intrinsics.checkNotNullParameter(str2, "id_token");
            Intrinsics.checkNotNullParameter(str3, "state");
            Intrinsics.checkNotNullParameter(str4, "user");
            this.code = str;
            this.id_token = str2;
            this.state = str3;
            this.user = str4;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getId_token() {
            return this.id_token;
        }

        public final String getState() {
            return this.state;
        }

        public final String getUser() {
            return this.user;
        }
    }

    private SignInWithAppleResult() {
    }

    public /* synthetic */ SignInWithAppleResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleResult$Failure;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleResult.kt */
    public static final class Failure extends SignInWithAppleResult {
        private final Throwable error;

        public static /* synthetic */ Failure copy$default(Failure failure, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = failure.error;
            }
            return failure.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final Failure copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "error");
            return new Failure(th);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Failure) && Intrinsics.areEqual(this.error, ((Failure) obj).error);
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.error;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Failure(error=" + this.error + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleResult$Cancel;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "()V", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SignInWithAppleResult.kt */
    public static final class Cancel extends SignInWithAppleResult {
        public static final Cancel INSTANCE = new Cancel();

        private Cancel() {
            super(null);
        }
    }
}
