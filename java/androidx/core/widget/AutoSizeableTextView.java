package androidx.core.widget;

import android.os.Build;

public interface AutoSizeableTextView {
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = (Build.VERSION.SDK_INT >= 27);

    int getAutoSizeMaxTextSize();

    int getAutoSizeMinTextSize();

    int getAutoSizeStepGranularity();

    int[] getAutoSizeTextAvailableSizes();

    int getAutoSizeTextType();

    void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException;

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException;

    void setAutoSizeTextTypeWithDefaults(int i);
}
