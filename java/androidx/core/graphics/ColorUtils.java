package androidx.core.graphics;

import android.graphics.Color;
import androidx.core.view.ViewCompat;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private ColorUtils() {
    }

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i), alpha2, Color.red(i2), alpha, compositeAlpha), compositeComponent(Color.green(i), alpha2, Color.green(i2), alpha, compositeAlpha), compositeComponent(Color.blue(i), alpha2, Color.blue(i2), alpha, compositeAlpha));
    }

    public static Color compositeColors(Color color, Color color2) {
        if (C$r8$backportedMethods$utility$Objects$2$equals.equals(color.getModel(), color2.getModel())) {
            if (!C$r8$backportedMethods$utility$Objects$2$equals.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = color.alpha();
            float alpha2 = color2.alpha() * (1.0f - alpha);
            int componentCount = color2.getComponentCount() - 1;
            components2[componentCount] = alpha + alpha2;
            if (components2[componentCount] > 0.0f) {
                alpha /= components2[componentCount];
                alpha2 /= components2[componentCount];
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components[i] * alpha) + (components2[i] * alpha2);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
        throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static double calculateLuminance(int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) == 255) {
            if (Color.alpha(i) < 255) {
                i = compositeColors(i, i2);
            }
            double calculateLuminance = calculateLuminance(i) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    public static int calculateMinimumAlpha(int i, int i2, float f) {
        int i3 = 255;
        if (Color.alpha(i2) == 255) {
            double d = (double) f;
            if (calculateContrast(setAlphaComponent(i, 255), i2) < d) {
                return -1;
            }
            int i4 = 0;
            for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
                int i6 = (i4 + i3) / 2;
                if (calculateContrast(setAlphaComponent(i, i6), i2) < d) {
                    i4 = i6;
                } else {
                    i3 = i6;
                }
            }
            return i3;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
    }

    public static void RGBToHSL(int i, int i2, int i3, float[] fArr) {
        float f;
        float f2;
        float f3 = ((float) i) / 255.0f;
        float f4 = ((float) i2) / 255.0f;
        float f5 = ((float) i3) / 255.0f;
        float max = Math.max(f3, Math.max(f4, f5));
        float min = Math.min(f3, Math.min(f4, f5));
        float f6 = max - min;
        float f7 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            f = max == f3 ? ((f4 - f5) / f6) % 6.0f : max == f4 ? ((f5 - f3) / f6) + 2.0f : 4.0f + ((f3 - f4) / f6);
            f2 = f6 / (1.0f - Math.abs((2.0f * f7) - 1.0f));
        }
        float f8 = (f * 60.0f) % 360.0f;
        if (f8 < 0.0f) {
            f8 += 360.0f;
        }
        fArr[0] = constrain(f8, 0.0f, 360.0f);
        fArr[1] = constrain(f2, 0.0f, 1.0f);
        fArr[2] = constrain(f7, 0.0f, 1.0f);
    }

    public static void colorToHSL(int i, float[] fArr) {
        RGBToHSL(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static int HSLToColor(float[] fArr) {
        int i;
        int i2;
        int i3;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float abs = (1.0f - Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f) / 60) {
            case 0:
                i3 = Math.round((abs + f4) * 255.0f);
                i2 = Math.round((abs2 + f4) * 255.0f);
                i = Math.round(f4 * 255.0f);
                break;
            case 1:
                i3 = Math.round((abs2 + f4) * 255.0f);
                i2 = Math.round((abs + f4) * 255.0f);
                i = Math.round(f4 * 255.0f);
                break;
            case 2:
                i3 = Math.round(f4 * 255.0f);
                i2 = Math.round((abs + f4) * 255.0f);
                i = Math.round((abs2 + f4) * 255.0f);
                break;
            case 3:
                i3 = Math.round(f4 * 255.0f);
                i2 = Math.round((abs2 + f4) * 255.0f);
                i = Math.round((abs + f4) * 255.0f);
                break;
            case 4:
                i3 = Math.round((abs2 + f4) * 255.0f);
                i2 = Math.round(f4 * 255.0f);
                i = Math.round((abs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                i3 = Math.round((abs + f4) * 255.0f);
                i2 = Math.round(f4 * 255.0f);
                i = Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                i = 0;
                i3 = 0;
                i2 = 0;
                break;
        }
        return Color.rgb(constrain(i3, 0, 255), constrain(i2, 0, 255), constrain(i, 0, 255));
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & ViewCompat.MEASURED_SIZE_MASK) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static void colorToLAB(int i, double[] dArr) {
        RGBToLAB(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void RGBToLAB(int i, int i2, int i3, double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        double d;
        double d2;
        double d3;
        if (dArr.length == 3) {
            double d4 = (double) i;
            Double.isNaN(d4);
            double d5 = d4 / 255.0d;
            if (d5 < 0.04045d) {
                d = d5 / 12.92d;
            } else {
                d = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            }
            double d6 = (double) i2;
            Double.isNaN(d6);
            double d7 = d6 / 255.0d;
            if (d7 < 0.04045d) {
                d2 = d7 / 12.92d;
            } else {
                d2 = Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            }
            double d8 = (double) i3;
            Double.isNaN(d8);
            double d9 = d8 / 255.0d;
            if (d9 < 0.04045d) {
                d3 = d9 / 12.92d;
            } else {
                d3 = Math.pow((d9 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.4124d * d) + (0.3576d * d2) + (0.1805d * d3)) * XYZ_WHITE_REFERENCE_Y;
            dArr[1] = ((0.2126d * d) + (0.7152d * d2) + (0.0722d * d3)) * XYZ_WHITE_REFERENCE_Y;
            dArr[2] = ((d * 0.0193d) + (d2 * 0.1192d) + (d3 * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static void XYZToLAB(double d, double d2, double d3, double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d2 / XYZ_WHITE_REFERENCE_Y);
            double pivotXyzComponent3 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    public static void LABToXYZ(double d, double d2, double d3, double[] dArr) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double pow = Math.pow(d5, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d5 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double pow2 = d > 7.9996247999999985d ? Math.pow(d4, 3.0d) : d / XYZ_KAPPA;
        double pow3 = Math.pow(d6, 3.0d);
        if (pow3 <= XYZ_EPSILON) {
            pow3 = ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = pow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = pow3 * XYZ_WHITE_REFERENCE_Z;
    }

    public static int XYZToColor(double d, double d2, double d3) {
        double d4 = (((3.2406d * d) + (-1.5372d * d2)) + (-0.4986d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d5 = (((-0.9689d * d) + (1.8758d * d2)) + (0.0415d * d3)) / XYZ_WHITE_REFERENCE_Y;
        double d6 = (((0.0557d * d) + (-0.204d * d2)) + (1.057d * d3)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255));
    }

    public static int LABToColor(double d, double d2, double d3) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d2, d3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static double distanceEuclidean(double[] dArr, double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? Math.pow(d, 0.3333333333333333d) : ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    public static int blendARGB(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    public static void blendHSL(float[] fArr, float[] fArr2, float f, float[] fArr3) {
        if (fArr3.length == 3) {
            float f2 = 1.0f - f;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
            fArr3[1] = (fArr[1] * f2) + (fArr2[1] * f);
            fArr3[2] = (fArr[2] * f2) + (fArr2[2] * f);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(double[] dArr, double[] dArr2, double d, double[] dArr3) {
        if (dArr3.length == 3) {
            double d2 = 1.0d - d;
            dArr3[0] = (dArr[0] * d2) + (dArr2[0] * d);
            dArr3[1] = (dArr[1] * d2) + (dArr2[1] * d);
            dArr3[2] = (dArr[2] * d2) + (dArr2[2] * d);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    static float circularInterpolate(float f, float f2, float f3) {
        if (Math.abs(f2 - f) > 180.0f) {
            if (f2 > f) {
                f += 360.0f;
            } else {
                f2 += 360.0f;
            }
        }
        return (f + ((f2 - f) * f3)) % 360.0f;
    }

    private static double[] getTempDouble3Array() {
        double[] dArr = TEMP_ARRAY.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        TEMP_ARRAY.set(dArr2);
        return dArr2;
    }
}
