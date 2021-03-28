package com.onesignal;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
public class OSObservable<ObserverType, StateType> {
    private boolean fireOnMainThread;
    private String methodName;
    private List<Object> observers = new ArrayList();

    OSObservable(String str, boolean z) {
        this.methodName = str;
        this.fireOnMainThread = z;
    }

    /* access modifiers changed from: package-private */
    public void addObserver(ObserverType observertype) {
        this.observers.add(new WeakReference(observertype));
    }

    /* access modifiers changed from: package-private */
    public void addObserverStrong(ObserverType observertype) {
        this.observers.add(observertype);
    }

    /* access modifiers changed from: package-private */
    public void removeObserver(ObserverType observertype) {
        for (int i = 0; i < this.observers.size(); i++) {
            if (((WeakReference) this.observers.get(i)).get().equals(observertype)) {
                this.observers.remove(i);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean notifyChange(final StateType statetype) {
        Iterator<Object> it = this.observers.iterator();
        boolean z = false;
        while (it.hasNext()) {
            final Object next = it.next();
            if (next instanceof WeakReference) {
                next = ((WeakReference) next).get();
            }
            if (next != null) {
                Class<?> cls = next.getClass();
                try {
                    final Method declaredMethod = cls.getDeclaredMethod(this.methodName, statetype.getClass());
                    declaredMethod.setAccessible(true);
                    if (this.fireOnMainThread) {
                        OSUtils.runOnMainUIThread(new Runnable() {
                            /* class com.onesignal.OSObservable.AnonymousClass1 */

                            public void run() {
                                try {
                                    declaredMethod.invoke(next, statetype);
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                    } else {
                        try {
                            declaredMethod.invoke(next, statetype);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                        }
                    }
                    z = true;
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return z;
    }
}
