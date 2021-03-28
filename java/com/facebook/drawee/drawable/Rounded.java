package com.facebook.drawee.drawable;

public interface Rounded {
    int getBorderColor();

    float getBorderWidth();

    float getPadding();

    boolean getPaintFilterBitmap();

    float[] getRadii();

    boolean getScaleDownInsideBorders();

    boolean isCircle();

    void setBorder(int i, float f);

    void setCircle(boolean z);

    void setPadding(float f);

    void setPaintFilterBitmap(boolean z);

    void setRadii(float[] fArr);

    void setRadius(float f);

    void setScaleDownInsideBorders(boolean z);
}
