package kotlin;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b¸\u0006\u0000"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", IronSourceConstants.EVENTS_RESULT, "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: Continuation.kt */
public final class DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1 implements Continuation<Object> {
    final /* synthetic */ Continuation $cont$inlined;
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function3 $currentFunction$inlined;
    final /* synthetic */ DeepRecursiveScopeImpl this$0;

    public DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1(CoroutineContext coroutineContext, DeepRecursiveScopeImpl deepRecursiveScopeImpl, Function3 function3, Continuation continuation) {
        this.$context = coroutineContext;
        this.this$0 = deepRecursiveScopeImpl;
        this.$currentFunction$inlined = function3;
        this.$cont$inlined = continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.$context;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.this$0.function = this.$currentFunction$inlined;
        this.this$0.cont = this.$cont$inlined;
        this.this$0.result = obj;
    }
}
