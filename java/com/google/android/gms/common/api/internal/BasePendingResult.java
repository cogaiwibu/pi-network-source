package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zado = new zao();
    private zaa mResultGuardian;
    private Status mStatus;
    private R zacl;
    private final Object zadp;
    private final CallbackHandler<R> zadq;
    private final WeakReference<GoogleApiClient> zadr;
    private final CountDownLatch zads;
    private final ArrayList<PendingResult.StatusListener> zadt;
    private ResultCallback<? super R> zadu;
    private final AtomicReference<zacq> zadv;
    private volatile boolean zadw;
    private boolean zadx;
    private boolean zady;
    private ICancelToken zadz;
    private volatile zack<R> zaea;
    private boolean zaeb;

    /* access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public final class zaa {
        private zaa() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            BasePendingResult.zab(BasePendingResult.this.zacl);
            super.finalize();
        }

        /* synthetic */ zaa(BasePendingResult basePendingResult, zao zao) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zadp = new Object();
        this.zads = new CountDownLatch(1);
        this.zadt = new ArrayList<>();
        this.zadv = new AtomicReference<>();
        this.zaeb = false;
        this.zadq = new CallbackHandler<>(Looper.getMainLooper());
        this.zadr = new WeakReference<>(null);
    }

    /* access modifiers changed from: private */
    public static <R extends Result> ResultCallback<R> zaa(ResultCallback<R> resultCallback) {
        return resultCallback;
    }

    /* access modifiers changed from: protected */
    public abstract R createFailedResult(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer zal() {
        return null;
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    public static class CallbackHandler<R extends Result> extends zar {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public final void zaa(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(BasePendingResult.zaa(resultCallback), r)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.common.api.ResultCallback */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                } catch (RuntimeException e) {
                    BasePendingResult.zab(result);
                    throw e;
                }
            } else if (i != 2) {
                int i2 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).zab(Status.RESULT_TIMEOUT);
            }
        }
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zadp = new Object();
        this.zads = new CountDownLatch(1);
        this.zadt = new ArrayList<>();
        this.zadv = new AtomicReference<>();
        this.zaeb = false;
        this.zadq = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zadr = new WeakReference<>(googleApiClient);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zadp = new Object();
        this.zads = new CountDownLatch(1);
        this.zadt = new ArrayList<>();
        this.zadv = new AtomicReference<>();
        this.zaeb = false;
        this.zadq = new CallbackHandler<>(looper);
        this.zadr = new WeakReference<>(null);
    }

    protected BasePendingResult(CallbackHandler<R> callbackHandler) {
        this.zadp = new Object();
        this.zads = new CountDownLatch(1);
        this.zadt = new ArrayList<>();
        this.zadv = new AtomicReference<>();
        this.zaeb = false;
        this.zadq = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zadr = new WeakReference<>(null);
    }

    public final boolean isReady() {
        return this.zads.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        boolean z = true;
        Preconditions.checkState(!this.zadw, "Result has already been consumed");
        if (this.zaea != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            this.zads.await();
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        Preconditions.checkState(!this.zadw, "Result has already been consumed.");
        if (this.zaea != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            if (!this.zads.await(j, timeUnit)) {
                zab(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            zab(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.zadp) {
            if (resultCallback == null) {
                this.zadu = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.zadw, "Result has already been consumed.");
            if (this.zaea != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zadq.zaa(resultCallback, get());
                } else {
                    this.zadu = resultCallback;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.zadp) {
            if (resultCallback == null) {
                this.zadu = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.zadw, "Result has already been consumed.");
            if (this.zaea != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zadq.zaa(resultCallback, get());
                } else {
                    this.zadu = resultCallback;
                    CallbackHandler<R> callbackHandler = this.zadq;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zadp) {
            if (isReady()) {
                statusListener.onComplete(this.mStatus);
            } else {
                this.zadt.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zadp) {
            if (!this.zadx) {
                if (!this.zadw) {
                    if (this.zadz != null) {
                        try {
                            this.zadz.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                    zab(this.zacl);
                    this.zadx = true;
                    zaa(createFailedResult(Status.RESULT_CANCELED));
                }
            }
        }
    }

    public final boolean zaq() {
        boolean isCanceled;
        synchronized (this.zadp) {
            if (this.zadr.get() == null || !this.zaeb) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zadp) {
            z = this.zadx;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        Preconditions.checkState(!this.zadw, "Result has already been consumed.");
        synchronized (this.zadp) {
            boolean z = false;
            Preconditions.checkState(this.zaea == null, "Cannot call then() twice.");
            Preconditions.checkState(this.zadu == null, "Cannot call then() if callbacks are set.");
            if (!this.zadx) {
                z = true;
            }
            Preconditions.checkState(z, "Cannot call then() if result was canceled.");
            this.zaeb = true;
            this.zaea = new zack<>(this.zadr);
            then = this.zaea.then(resultTransform);
            if (isReady()) {
                this.zadq.zaa(this.zaea, get());
            } else {
                this.zadu = this.zaea;
            }
        }
        return then;
    }

    public final void setResult(R r) {
        synchronized (this.zadp) {
            if (this.zady || this.zadx) {
                zab(r);
                return;
            }
            isReady();
            boolean z = true;
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.zadw) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            zaa(r);
        }
    }

    public final void zab(Status status) {
        synchronized (this.zadp) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zady = true;
            }
        }
    }

    public final void zaa(zacq zacq) {
        this.zadv.set(zacq);
    }

    /* access modifiers changed from: protected */
    public final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zadp) {
            this.zadz = iCancelToken;
        }
    }

    public final void zar() {
        this.zaeb = this.zaeb || zado.get().booleanValue();
    }

    private final R get() {
        R r;
        synchronized (this.zadp) {
            Preconditions.checkState(!this.zadw, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.zacl;
            this.zacl = null;
            this.zadu = null;
            this.zadw = true;
        }
        zacq andSet = this.zadv.getAndSet(null);
        if (andSet != null) {
            andSet.zab(this);
        }
        return r;
    }

    private final void zaa(R r) {
        this.zacl = r;
        this.zadz = null;
        this.zads.countDown();
        this.mStatus = this.zacl.getStatus();
        if (this.zadx) {
            this.zadu = null;
        } else if (this.zadu != null) {
            this.zadq.removeMessages(2);
            this.zadq.zaa(this.zadu, get());
        } else if (this.zacl instanceof Releasable) {
            this.mResultGuardian = new zaa(this, null);
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zadt;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.onComplete(this.mStatus);
        }
        this.zadt.clear();
    }

    public static void zab(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }
}
