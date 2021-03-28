package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.tapjoy.TapjoyConnectCore;

public class ARTShapeShadowNode extends ARTVirtualNode {
    private static final int CAP_BUTT = 0;
    private static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    private static final int COLOR_TYPE_LINEAR_GRADIENT = 1;
    private static final int COLOR_TYPE_PATTERN = 3;
    private static final int COLOR_TYPE_RADIAL_GRADIENT = 2;
    private static final int COLOR_TYPE_SOLID_COLOR = 0;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    private static final int JOIN_ROUND = 1;
    private static final int PATH_TYPE_ARC = 4;
    private static final int PATH_TYPE_CLOSE = 1;
    private static final int PATH_TYPE_CURVETO = 3;
    private static final int PATH_TYPE_LINETO = 2;
    private static final int PATH_TYPE_MOVETO = 0;
    private float[] mBrushData;
    protected Path mPath;
    private int mStrokeCap = 1;
    private float[] mStrokeColor;
    private float[] mStrokeDash;
    private int mStrokeJoin = 1;
    private float mStrokeWidth = 1.0f;

    private float modulus(float f, float f2) {
        float f3 = f % f2;
        return f3 < 0.0f ? f3 + f2 : f3;
    }

    @ReactProp(name = "d")
    public void setShapePath(ReadableArray readableArray) {
        this.mPath = createPath(PropHelper.toFloatArray(readableArray));
        markUpdated();
    }

    @ReactProp(name = "stroke")
    public void setStroke(ReadableArray readableArray) {
        this.mStrokeColor = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "strokeDash")
    public void setStrokeDash(ReadableArray readableArray) {
        this.mStrokeDash = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "fill")
    public void setFill(ReadableArray readableArray) {
        this.mBrushData = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultFloat = TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, name = "strokeWidth")
    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeCap")
    public void setStrokeCap(int i) {
        this.mStrokeCap = i;
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeJoin")
    public void setStrokeJoin(int i) {
        this.mStrokeJoin = i;
        markUpdated();
    }

    @Override // com.facebook.react.views.art.ARTVirtualNode
    public void draw(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.mOpacity;
        if (f2 > 0.01f) {
            saveAndSetupCanvas(canvas);
            if (this.mPath != null) {
                if (setupFillPaint(paint, f2)) {
                    canvas.drawPath(this.mPath, paint);
                }
                if (setupStrokePaint(paint, f2)) {
                    canvas.drawPath(this.mPath, paint);
                }
                restoreCanvas(canvas);
            } else {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
        }
        markUpdateSeen();
    }

    /* access modifiers changed from: protected */
    public boolean setupStrokePaint(Paint paint, float f) {
        float[] fArr;
        if (this.mStrokeWidth == 0.0f || (fArr = this.mStrokeColor) == null || fArr.length == 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        int i = this.mStrokeCap;
        if (i == 0) {
            paint.setStrokeCap(Paint.Cap.BUTT);
        } else if (i == 1) {
            paint.setStrokeCap(Paint.Cap.ROUND);
        } else if (i == 2) {
            paint.setStrokeCap(Paint.Cap.SQUARE);
        } else {
            throw new JSApplicationIllegalArgumentException("strokeCap " + this.mStrokeCap + " unrecognized");
        }
        int i2 = this.mStrokeJoin;
        if (i2 == 0) {
            paint.setStrokeJoin(Paint.Join.MITER);
        } else if (i2 == 1) {
            paint.setStrokeJoin(Paint.Join.ROUND);
        } else if (i2 == 2) {
            paint.setStrokeJoin(Paint.Join.BEVEL);
        } else {
            throw new JSApplicationIllegalArgumentException("strokeJoin " + this.mStrokeJoin + " unrecognized");
        }
        paint.setStrokeWidth(this.mStrokeWidth * this.mScale);
        float[] fArr2 = this.mStrokeColor;
        int i3 = (int) (fArr2.length > 3 ? fArr2[3] * f * 255.0f : f * 255.0f);
        float[] fArr3 = this.mStrokeColor;
        paint.setARGB(i3, (int) (fArr3[0] * 255.0f), (int) (fArr3[1] * 255.0f), (int) (fArr3[2] * 255.0f));
        float[] fArr4 = this.mStrokeDash;
        if (fArr4 != null && fArr4.length > 0) {
            paint.setPathEffect(new DashPathEffect(this.mStrokeDash, 0.0f));
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setupFillPaint(Paint paint, float f) {
        float[] fArr;
        int[] iArr;
        float[] fArr2 = this.mBrushData;
        int i = 0;
        if (fArr2 == null || fArr2.length <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        float[] fArr3 = this.mBrushData;
        int i2 = (int) fArr3[0];
        if (i2 != 0) {
            if (i2 != 1) {
                FLog.w(ReactConstants.TAG, "ART: Color type " + i2 + " not supported!");
            } else {
                int i3 = 5;
                if (fArr3.length < 5) {
                    FLog.w(ReactConstants.TAG, "[ARTShapeShadowNode setupFillPaint] expects 5 elements, received " + this.mBrushData.length);
                    return false;
                }
                float f2 = fArr3[1] * this.mScale;
                float f3 = this.mBrushData[2] * this.mScale;
                float f4 = this.mBrushData[3] * this.mScale;
                float f5 = this.mBrushData[4] * this.mScale;
                int length = (this.mBrushData.length - 5) / 5;
                if (length > 0) {
                    int[] iArr2 = new int[length];
                    float[] fArr4 = new float[length];
                    while (i < length) {
                        float[] fArr5 = this.mBrushData;
                        fArr4[i] = fArr5[(length * 4) + i3 + i];
                        int i4 = (i * 4) + i3;
                        iArr2[i] = Color.argb((int) (fArr5[i4 + 3] * 255.0f), (int) (fArr5[i4 + 0] * 255.0f), (int) (fArr5[i4 + 1] * 255.0f), (int) (fArr5[i4 + 2] * 255.0f));
                        i++;
                        i3 = 5;
                    }
                    iArr = iArr2;
                    fArr = fArr4;
                } else {
                    iArr = null;
                    fArr = null;
                }
                paint.setShader(new LinearGradient(f2, f3, f4, f5, iArr, fArr, Shader.TileMode.CLAMP));
            }
            return true;
        }
        float f6 = fArr3.length > 4 ? fArr3[4] * f * 255.0f : f * 255.0f;
        float[] fArr6 = this.mBrushData;
        paint.setARGB((int) f6, (int) (fArr6[1] * 255.0f), (int) (fArr6[2] * 255.0f), (int) (fArr6[3] * 255.0f));
        return true;
    }

    private Path createPath(float[] fArr) {
        int i;
        int i2;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i3 = 0;
        while (i3 < fArr.length) {
            int i4 = i3 + 1;
            int i5 = (int) fArr[i3];
            if (i5 != 0) {
                boolean z = true;
                if (i5 == 1) {
                    path.close();
                    i3 = i4;
                } else if (i5 != 2) {
                    if (i5 == 3) {
                        int i6 = i4 + 1;
                        float f = fArr[i4] * this.mScale;
                        int i7 = i6 + 1;
                        float f2 = this.mScale * fArr[i6];
                        int i8 = i7 + 1;
                        float f3 = this.mScale * fArr[i7];
                        int i9 = i8 + 1;
                        float f4 = this.mScale * fArr[i8];
                        int i10 = i9 + 1;
                        i2 = i10 + 1;
                        path.cubicTo(f, f2, f3, f4, this.mScale * fArr[i9], fArr[i10] * this.mScale);
                    } else if (i5 == 4) {
                        int i11 = i4 + 1;
                        float f5 = fArr[i4] * this.mScale;
                        int i12 = i11 + 1;
                        float f6 = fArr[i11] * this.mScale;
                        int i13 = i12 + 1;
                        float f7 = fArr[i12] * this.mScale;
                        int i14 = i13 + 1;
                        float degrees = (float) Math.toDegrees((double) fArr[i13]);
                        int i15 = i14 + 1;
                        float degrees2 = (float) Math.toDegrees((double) fArr[i14]);
                        i2 = i15 + 1;
                        if (fArr[i15] == 1.0f) {
                            z = false;
                        }
                        float f8 = degrees2 - degrees;
                        if (Math.abs(f8) >= 360.0f) {
                            path.addCircle(f5, f6, f7, z ? Path.Direction.CCW : Path.Direction.CW);
                        } else {
                            float modulus = modulus(f8, 360.0f);
                            if (z && modulus < 360.0f) {
                                modulus = (360.0f - modulus) * -1.0f;
                            }
                            path.arcTo(new RectF(f5 - f7, f6 - f7, f5 + f7, f6 + f7), degrees, modulus);
                        }
                    } else {
                        throw new JSApplicationIllegalArgumentException("Unrecognized drawing instruction " + i5);
                    }
                    i3 = i2;
                } else {
                    int i16 = i4 + 1;
                    i = i16 + 1;
                    path.lineTo(fArr[i4] * this.mScale, fArr[i16] * this.mScale);
                }
            } else {
                int i17 = i4 + 1;
                i = i17 + 1;
                path.moveTo(fArr[i4] * this.mScale, fArr[i17] * this.mScale);
            }
            i3 = i;
        }
        return path;
    }
}
