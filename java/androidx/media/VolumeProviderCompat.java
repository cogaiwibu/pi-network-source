package androidx.media;

import android.os.Build;
import androidx.media.VolumeProviderCompatApi21;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        this.mControlType = i;
        this.mMaxVolume = i2;
        this.mCurrentVolume = i3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final void setCurrentVolume(int i) {
        this.mCurrentVolume = i;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null && Build.VERSION.SDK_INT >= 21) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onVolumeChanged(this);
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj == null && Build.VERSION.SDK_INT >= 21) {
            this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new VolumeProviderCompatApi21.Delegate() {
                /* class androidx.media.VolumeProviderCompat.AnonymousClass1 */

                @Override // androidx.media.VolumeProviderCompatApi21.Delegate
                public void onSetVolumeTo(int i) {
                    VolumeProviderCompat.this.onSetVolumeTo(i);
                }

                @Override // androidx.media.VolumeProviderCompatApi21.Delegate
                public void onAdjustVolume(int i) {
                    VolumeProviderCompat.this.onAdjustVolume(i);
                }
            });
        }
        return this.mVolumeProviderObj;
    }
}
