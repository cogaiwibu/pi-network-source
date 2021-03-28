package androidx.appcompat.view.menu;

/* access modifiers changed from: package-private */
public class BaseWrapper<T> {
    final T mWrappedObject;

    BaseWrapper(T t) {
        if (t != null) {
            this.mWrappedObject = t;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public T getWrappedObject() {
        return this.mWrappedObject;
    }
}
