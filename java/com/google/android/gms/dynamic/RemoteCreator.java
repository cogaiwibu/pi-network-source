package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public abstract class RemoteCreator<T> {
    private final String zzis;
    private T zzit;

    protected RemoteCreator(String str) {
        this.zzis = str;
    }

    /* access modifiers changed from: protected */
    public abstract T getRemoteCreator(IBinder iBinder);

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* access modifiers changed from: protected */
    public final T getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        if (this.zzit == null) {
            Preconditions.checkNotNull(context);
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (remoteContext != null) {
                try {
                    this.zzit = getRemoteCreator((IBinder) remoteContext.getClassLoader().loadClass(this.zzis).newInstance());
                } catch (ClassNotFoundException e) {
                    throw new RemoteCreatorException("Could not load creator class.", e);
                } catch (InstantiationException e2) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e2);
                } catch (IllegalAccessException e3) {
                    throw new RemoteCreatorException("Could not access creator.", e3);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.zzit;
    }
}
