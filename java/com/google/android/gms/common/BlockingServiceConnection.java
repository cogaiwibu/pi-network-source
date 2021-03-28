package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public class BlockingServiceConnection implements ServiceConnection {
    private boolean zzu = false;
    private final BlockingQueue<IBinder> zzv = new LinkedBlockingQueue();

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzv.add(iBinder);
    }

    public IBinder getServiceWithTimeout(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.zzu) {
            this.zzu = true;
            IBinder poll = this.zzv.poll(j, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread("BlockingServiceConnection.getService() called on main thread");
        if (!this.zzu) {
            this.zzu = true;
            return this.zzv.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }
}
