package kotlin;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

public final class DeepRecursiveKt {
    private static final Object UNDEFINED_RESULT = Result.m4constructorimpl(IntrinsicsKt.getCOROUTINE_SUSPENDED());

    private static /* synthetic */ void DeepRecursiveFunctionBlock$annotations() {
    }

    public static final <T, R> R invoke(DeepRecursiveFunction<T, R> deepRecursiveFunction, T t) {
        Intrinsics.checkNotNullParameter(deepRecursiveFunction, "$this$invoke");
        return (R) new DeepRecursiveScopeImpl(deepRecursiveFunction.getBlock$kotlin_stdlib(), t).runCallLoop();
    }

    static {
        Result.Companion companion = Result.Companion;
    }
}
