package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imageutils.JfifUtil;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class J8 {
    public static J8 A01;
    public static byte[] A02;
    public static String[] A03;
    public static final String[] A04 = new String[0];
    public static final String[] A05 = {A0N(86, 5, 14), A0N(65, 9, 115), A0N(74, 12, 88)};
    public final SharedPreferences A00;

    public static String A0N(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[5].charAt(10) != 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "rwxiKY1yX8M1uCycGOqUPfCL86zZ3gS";
            strArr[0] = "P38LhqS18Cw18aUWRDVsuYtPAT7MPJu";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 46);
            i4++;
        }
    }

    public static void A0Y() {
        A02 = new byte[]{108, 73, 107, 100, 105, 111, 102, 82, 126, ByteCompanionObject.MAX_VALUE, 101, 120, ByteCompanionObject.MAX_VALUE, 100, 116, 3, 47, 46, 52, 41, 46, 53, 37, ByteCompanionObject.MAX_VALUE, 106, 92, 70, 19, 68, 90, 95, 95, 19, 81, 86, 19, 71, 82, 88, 86, 93, 19, 71, 92, 19, 82, 93, 92, 71, 91, 86, 65, 19, 87, 86, 64, 71, 90, 93, 82, 71, 90, 92, 93, 29, 6, 17, 25, 8, 112, 109, 112, 109, 0, 45, 58, 50, 35, 91, 71, 91, 71, 70, 70, 70, 43, 123, 108, 100, 117, 125, 12, 10, 121, 123, 123, 113, 124, 125, 118, 108, 121, 116, 71, 123, 116, 113, 123, 115, 107, 71, 123, 119, 118, 126, 113, ByteCompanionObject.MAX_VALUE, 34, 32, 32, 42, 39, 38, 45, 55, 34, 47, 28, 32, 47, 42, 32, 40, 48, 28, 32, 44, 45, 37, 42, 36, 109, 55, 52, 44, 28, 48, 55, 38, 51, 28, 32, 34, 45, 32, 38, 47, 28, 33, 54, 55, 55, 44, 45, 28, 55, 38, 59, 55, 25, 27, 27, 17, 28, 29, 22, 12, 25, 20, 39, 27, 20, 17, 27, 19, 11, 39, 27, 23, 22, 30, 17, 31, 86, 12, 15, 23, 39, 11, 12, 29, 8, 39, 27, 23, 22, 30, 17, 10, 21, 39, 26, 13, 12, 12, 23, 22, 39, 12, 29, 0, 12, 3, 1, 1, 11, 6, 7, 12, 22, 3, 14, 61, 1, 14, 11, 1, 9, 17, 61, 1, 13, 12, 4, 11, 5, 76, 22, 21, 13, 61, 17, 22, 7, 18, 61, 1, 13, 12, 4, 11, 16, 15, 3, 22, 11, 13, 12, 68, 70, 70, 76, 65, 64, 75, 81, 68, 73, 122, 70, 73, 76, 70, 78, 86, 122, 70, 74, 75, 67, 76, 66, 11, 81, 82, 74, 122, 86, 81, 64, 85, 122, 70, 74, 75, 67, 76, 87, 72, 68, 81, 76, 74, 75, 122, 71, 74, 65, 92, 30, 28, 28, 22, 27, 26, 17, 11, 30, 19, 32, 28, 19, 22, 28, 20, 12, 32, 28, 16, 17, 25, 22, 24, 81, 11, 8, 16, 32, 12, 11, 26, 15, 32, 28, 16, 17, 25, 22, 13, 18, 30, 11, 22, 16, 17, 32, 11, 22, 11, 19, 26, 100, 97, 107, 114, 90, 100, 102, 102, 96, 117, 113, 100, 103, 105, 96, 90, 118, 113, 100, 102, 110, 113, 119, 100, 102, 96, 90, 102, 106, 107, 113, 96, 125, 113, 90, 99, 108, 105, 113, 96, 119, 90, 118, 108, ByteCompanionObject.MAX_VALUE, 96, 23, 18, 24, 1, 41, 23, 21, 21, 19, 6, 2, 23, 20, 26, 19, 41, 5, 2, 23, 21, 29, 2, 4, 23, 21, 19, 41, 26, 19, 24, 17, 2, 30, 63, 58, 48, 41, 1, 63, 48, 58, 44, 49, 55, 58, 1, 63, 50, 50, 49, 41, 1, 50, 49, 63, 58, 1, 58, 43, 44, 55, 48, 57, 1, 45, 54, 49, 41, 55, 48, 57, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 121, 118, 106, 71, 124, 125, 108, 125, 123, 108, 119, 106, 71, 125, 118, 121, 122, 116, 125, 31, 26, 16, 9, 33, 31, 16, 26, 12, 17, 23, 26, 33, 31, 16, 12, 33, 26, 27, 10, 27, 29, 10, 17, 12, 33, 10, 23, 19, 27, 17, 11, 10, 33, 19, 13, 46, 43, 33, 56, 16, 46, 33, 43, 61, 32, 38, 43, 16, 45, 35, 46, 44, 36, 35, 38, 60, 59, 42, 43, 16, 38, 33, 59, 42, 33, 59, 16, 58, 61, 35, 16, 63, 61, 42, 41, 38, 55, 42, 60, 62, 59, 49, 40, 0, 62, 49, 59, 45, 48, 54, 59, 0, 60, 62, 60, 55, 58, 0, 50, 48, 59, 42, 51, 58, 0, 50, 62, 39, 0, 44, 54, 37, 58, 112, 117, ByteCompanionObject.MAX_VALUE, 102, 78, 112, ByteCompanionObject.MAX_VALUE, 117, 99, 126, 120, 117, 78, 114, 112, 114, 121, 116, 78, 124, 126, 117, 100, 125, 116, 78, 99, 116, 101, 99, 104, 78, 125, 120, 124, 120, 101, 33, 36, 46, 55, 31, 33, 46, 36, 50, 47, 41, 36, 31, 35, 47, 45, 48, 50, 37, 51, 51, 31, 41, 45, 33, 39, 37, 51, 31, 36, 53, 50, 41, 46, 39, 31, 36, 47, 55, 46, 44, 47, 33, 36, 5, 0, 10, 19, 59, 5, 10, 0, 22, 11, 13, 0, 59, 0, 1, 2, 5, 17, 8, 16, 59, 5, 23, 23, 1, 16, 59, 20, 22, 1, 8, 11, 5, 0, 59, 23, 13, 30, 1, 59, 6, 29, 16, 1, 23, 115, 118, 124, 101, 77, 115, 124, 118, 96, 125, 123, 118, 77, 118, 123, 97, 115, 112, 126, 119, 77, 98, 126, 115, 107, 115, 112, 126, 119, 77, 98, 96, 119, 113, 115, 113, 122, 119, 28, 25, 19, 10, 34, 28, 19, 25, 15, 18, 20, 25, 34, 24, 19, 28, 31, 17, 24, 34, 19, 28, 9, 20, 11, 24, 34, 27, 8, 19, 19, 24, 17, 69, 64, 74, 83, 123, 69, 74, 64, 86, 75, 77, 64, 123, 66, 69, 77, 72, 123, 75, 74, 123, 83, 65, 70, 82, 77, 65, 83, 123, 65, 86, 86, 75, 86, 87, 97, 100, 110, 119, 95, 97, 110, 100, 114, 111, 105, 100, 95, 105, 109, 97, 103, 101, 95, 99, 97, 99, 104, 101, 95, 115, 116, 111, 114, 101, 95, 98, 121, 116, 101, 95, 99, 111, 117, 110, 116, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 75, 67, 75, 73, 84, 95, 121, 73, 86, 82, 126, 123, 113, 104, 64, 126, 113, 123, 109, 112, 118, 123, 64, 114, 109, 124, 64, 118, 114, 111, 109, 122, 108, 108, 118, 112, 113, 64, 121, 112, 109, 64, 113, 126, 107, 118, 105, 122, 64, 105, 118, 123, 122, 112, 64, 126, 123, 108, 125, 120, 114, 107, 67, 125, 114, 120, 110, 115, 117, 120, 67, 113, 110, ByteCompanionObject.MAX_VALUE, 67, 117, 113, 108, 110, 121, 111, 111, 117, 115, 114, 67, 122, 115, 110, 67, 114, 125, 104, 117, 106, 121, 67, 106, 117, 120, 121, 115, 67, 125, 120, 111, 67, 106, 46, 55, 50, 56, 33, 9, 55, 56, 50, 36, 57, 63, 50, 9, 56, 51, 34, 33, 57, 36, 61, 9, 50, 51, 48, 55, 35, 58, 34, 9, 53, 57, 56, 56, 51, 53, 34, 63, 57, 56, 9, 34, 63, 59, 51, 57, 35, 34, 9, 59, 37, 80, 85, 95, 70, 110, 80, 95, 85, 67, 94, 88, 85, 110, 95, 84, 69, 70, 94, 67, 90, 110, 85, 84, 87, 80, 68, 93, 69, 110, 67, 84, 80, 85, 110, 69, 88, 92, 84, 94, 68, 69, 110, 92, 66, 12, 9, 3, 26, 50, 12, 3, 9, 31, 2, 4, 9, 50, 3, 8, 25, 26, 2, 31, 6, 50, 9, 8, 11, 12, 24, 1, 25, 50, 31, 8, 25, 31, 4, 8, 30, 50, 3, 24, 0, 120, 125, 119, 110, 70, 120, 119, 125, 107, 118, 112, 125, 70, 119, 124, 109, 110, 118, 107, 114, 70, 125, 124, ByteCompanionObject.MAX_VALUE, 120, 108, 117, 109, 70, 109, 113, 107, 118, 109, 109, 117, 124, 70, 109, 112, 116, 124, 118, 108, 109, 70, 116, 106, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 101, 110, ByteCompanionObject.MAX_VALUE, 124, 100, 121, 96, 84, 111, 110, 109, 106, 126, 103, ByteCompanionObject.MAX_VALUE, 84, ByteCompanionObject.MAX_VALUE, 98, 102, 110, 100, 126, ByteCompanionObject.MAX_VALUE, 84, 102, 120, 10, 15, 5, 28, 52, 10, 5, 15, 25, 4, 2, 15, 52, 25, 14, 27, 4, 25, 31, 52, 27, 25, 14, 24, 14, 5, 31, 10, 31, 2, 4, 5, 52, 14, 25, 25, 4, 25, 52, 28, 3, 14, 5, 52, 5, 4, 52, 2, 6, 27, 25, 14, 24, 24, 2, 4, 5, 21, 16, 26, 3, 43, 21, 26, 16, 6, 27, 29, 16, 43, 6, 17, 4, 27, 6, 0, 43, 4, 6, 17, 7, 17, 26, 0, 21, 0, 29, 27, 26, 43, 17, 6, 6, 27, 6, 7, 43, 29, 26, 7, 0, 17, 21, 16, 43, 27, 18, 43, 29, 26, 0, 17, 6, 26, 21, 24, 106, 111, 101, 124, 84, 106, 101, 111, 121, 100, 98, 111, 84, 126, 105, 125, 121, 104, 43, 46, 36, 61, 21, 43, 36, 46, 56, 37, 35, 46, 21, 63, 57, 47, 21, 41, 43, 41, 34, 47, 21, 39, 37, 46, 63, 38, 47, 21, 44, 37, 56, 21, 35, 39, 43, 45, 47, 57, 71, 66, 72, 81, 121, 71, 72, 66, 84, 73, 79, 66, 121, 83, 85, 67, 121, 85, 82, 67, 71, 75, 79, 72, 65, 121, 79, 75, 71, 65, 67, 121, 66, 67, 69, 73, 66, 79, 72, 65, 121, 124, 118, 111, 71, 121, 118, 124, 106, 119, 113, 124, 71, 111, 112, 113, 108, 125, 116, 113, 107, 108, 125, 124, 71, 113, 118, 108, 125, 118, 108, 71, 109, 106, 116, 71, 104, 106, 125, 126, 113, 96, 125, 107, 103, 98, 104, 113, 89, 100, 103, 104, 104, 99, 116, 89, 104, 105, 114, 111, 96, ByteCompanionObject.MAX_VALUE, 89, 103, 98, 89, 106, 105, 103, 98, 99, 98, 89, 105, 104, 89, 103, 117, 117, 99, 114, 117, 89, 106, 105, 103, 98, 99, 98, 124, 121, 115, 106, 66, ByteCompanionObject.MAX_VALUE, 120, 115, 126, 117, 112, 124, 111, 118, 66, 111, 120, 109, 114, 111, 105, 66, 116, 115, 105, 120, 111, 107, 124, 113, 66, 112, 110, 56, 61, 55, 46, 6, 59, 53, 54, 58, 50, 6, 53, 54, 58, 50, 42, 58, 43, 60, 60, 55, 86, 83, 89, 64, 104, 84, 69, 86, 68, 95, 104, 68, 95, 94, 82, 91, 83, 104, 82, 89, 86, 85, 91, 82, 83, 91, 94, 84, 77, 101, 89, 78, 91, 101, 91, 84, 83, 87, 91, 78, 83, 85, 84, 101, 94, 95, 86, 91, 67, 101, 87, 73, 52, 49, 59, 34, 10, 54, 33, 52, 10, 56, 60, 59, 10, 38, 54, 52, 57, 48, 10, 52, 59, 60, 56, 52, 33, 60, 58, 59, 10, 37, 48, 39, 54, 48, 59, 33, 52, 50, 48, 14, 11, 1, 24, 48, 11, 0, 48, 1, 0, 27, 48, 29, 10, 3, 0, 14, 11, 48, 6, 1, 27, 10, 29, 28, 27, 6, 27, 6, 14, 3, 48, 14, 11, 14, 31, 27, 10, 29, 109, 104, 98, 123, 83, 105, 98, 109, 110, 96, 105, 83, 109, 121, 120, 99, 83, 104, 105, ByteCompanionObject.MAX_VALUE, 120, 126, 99, 117, 83, 96, 105, 109, 103, ByteCompanionObject.MAX_VALUE, 58, 63, 53, 44, 4, 62, 53, 58, 57, 55, 62, 4, 57, 50, 63, 63, 62, 41, 4, 47, 52, 48, 62, 53, 4, 50, 53, 61, 52, 35, 38, 44, 53, 29, 39, 44, 35, 32, 46, 39, 29, 38, 39, 32, 55, 37, 29, 45, 52, 39, 48, 46, 35, 59, 91, 94, 84, 77, 101, 95, 84, 91, 88, 86, 95, 101, 95, 66, 85, 74, 86, 91, 67, 95, 72, 101, 89, 91, 89, 82, 95, 45, 40, 34, 59, 19, 41, 34, 45, 46, 32, 41, 19, 41, 52, 35, 60, 32, 45, 53, 41, 62, 19, 58, 126, 7, 2, 8, 17, 57, 3, 8, 7, 4, 10, 3, 57, 0, 19, 8, 8, 3, 10, 41, 44, 38, 63, 23, 45, 38, 41, 42, 36, 45, 23, 33, 41, 42, 114, 119, 125, 100, 76, 118, 125, 114, 113, ByteCompanionObject.MAX_VALUE, 118, 76, 122, 125, ByteCompanionObject.MAX_VALUE, 122, 125, 118, 76, 107, 76, 124, 102, 103, 76, 125, 124, 125, 76, 117, 102, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, 96, 112, 97, 118, 118, 125, 76, 124, 125, 76, 96, 119, 120, 122, ByteCompanionObject.MAX_VALUE, 117, 108, 68, 126, 117, 122, 121, 119, 126, 68, 117, 126, 111, 108, 116, 105, 112, 21, 16, 26, 3, 43, 17, 26, 21, 22, 24, 17, 43, 27, 24, 16, 43, 7, 13, 26, 23, 43, 23, 21, 24, 24, 91, 94, 84, 77, 101, 95, 84, 91, 88, 86, 95, 101, 74, 72, 95, 86, 85, 91, 94, 51, 54, 60, 37, 13, 55, 60, 51, 48, 62, 55, 13, 32, 51, 53, 55, 13, 33, 58, 51, 57, 55, 35, 38, 44, 53, 29, 39, 44, 35, 32, 46, 39, 29, 49, 59, 44, 33, 26, 31, 21, 12, 36, 29, 18, 23, 15, 30, 9, 36, 25, 18, 31, 31, 18, 21, 28, 36, 15, 20, 16, 30, 21, 66, 71, 77, 84, 124, 74, 77, 87, 70, 81, 80, 87, 74, 87, 74, 66, 79, 124, 77, 70, 84, 124, 74, 78, 66, 68, 70, 124, 71, 70, 80, 74, 68, 77, 52, 49, 59, 34, 10, 57, 58, 50, 50, 60, 59, 50, 10, 48, 59, 49, 37, 58, 60, 59, 33, 10, 37, 39, 48, 51, 60, 45, 37, 32, 42, 51, 27, 42, 37, 48, 45, 50, 33, 27, 39, 37, 54, 43, 49, 55, 33, 40, 27, 39, 43, 41, 52, 37, 39, 48, 27, 48, 44, 54, 33, 55, 44, 43, 40, 32, 89, 92, 86, 79, 103, 86, 89, 76, 81, 78, 93, 103, 78, 81, 93, 79, 103, 75, 86, 89, 72, 75, 80, 87, 76, 103, 84, 87, 95, 95, 81, 86, 95, 103, 93, 86, 89, 90, 84, 93, 92, 87, 82, 88, 65, 105, 88, 83, 65, 105, 90, 87, 88, 82, 69, 85, 87, 70, 83, 105, 83, 88, 82, 85, 87, 68, 82, 58, 63, 53, 44, 4, 52, 53, 63, 62, 45, 50, 56, 62, 4, 51, 50, 40, 47, 52, 41, 34, 4, 63, 58, 47, 58, 4, 62, 53, 58, 57, 55, 62, 63, 47, 42, 32, 57, 17, 62, 34, 47, 55, 47, 44, 34, 43, 17, 45, 34, 39, 45, 37, 17, 35, 47, 54, 17, 42, 43, 34, 47, 55, 17, 35, 61, 10, 15, 5, 28, 52, 27, 7, 10, 18, 10, 9, 7, 14, 24, 52, 7, 4, 12, 12, 2, 5, 12, 52, 14, 5, 10, 9, 7, 14, 15, 65, 68, 78, 87, ByteCompanionObject.MAX_VALUE, 80, 76, 65, 89, 65, 66, 76, 69, 83, ByteCompanionObject.MAX_VALUE, 78, 69, 87, ByteCompanionObject.MAX_VALUE, 68, 69, 83, 73, 71, 78, 94, 91, 81, 72, 96, 79, 83, 94, 70, 94, 93, 83, 90, 76, 96, 76, 87, 80, 72, 96, 90, 81, 91, 92, 94, 77, 91, 24, 29, 23, 14, 38, 9, 11, 28, 15, 28, 23, 13, 38, 9, 21, 24, 0, 24, 27, 21, 28, 38, 24, 12, 13, 22, 38, 26, 21, 16, 26, 18, 13, 8, 2, 27, 51, 28, 25, 30, 11, 9, 51, 3, 2, 51, 88, 93, 95, 51, 30, 9, 31, 28, 3, 2, 31, 9, 77, 72, 66, 91, 115, 94, 73, 79, 67, 65, 92, 89, 88, 73, 115, 78, 88, 115, 77, 74, 88, 73, 94, 115, 73, 84, 88, 94, 77, 95, 115, 79, 68, 77, 66, 75, 73, 27, 30, 20, 13, 37, 8, 31, 23, 21, 12, 31, 37, 18, 31, 27, 30, 22, 19, 20, 31, 37, 28, 21, 8, 37, 27, 30, 37, 30, 31, 14, 27, 19, 22, 9, 100, 97, 107, 114, 90, 119, 115, 90, 103, 112, 99, 99, 96, 119, 90, 102, 109, 96, 102, 110, 90, 96, 107, 100, 103, 105, 96, 97, 79, 74, 64, 89, 113, 92, 88, 113, 94, 66, 79, 87, 76, 79, 77, 69, 113, 77, 92, 79, 93, 70, 113, 72, 79, 66, 66, 76, 79, 77, 69, 96, 101, 111, 118, 94, 114, 105, 110, 116, 109, 101, 94, 96, 101, 101, 94, 100, 121, 117, 100, 111, 114, 104, 110, 111, 94, 117, 110, 94, 113, 109, 96, 120, 96, 99, 109, 100, 114, 15, 10, 0, 25, 49, 29, 6, 1, 27, 2, 10, 49, 13, 2, 11, 15, 28, 49, 8, 11, 15, 26, 27, 28, 11, 49, 13, 1, 0, 8, 7, 9, 49, 1, 0, 49, 13, 28, 15, 29, 6, 11, 29, 20, 17, 27, 2, 42, 6, 29, 26, 0, 25, 17, 42, 28, 18, 27, 26, 7, 16, 42, 17, 16, 6, 1, 7, 26, 12, 42, 22, 20, 25, 25, 117, 112, 122, 99, 75, 103, 124, 123, 97, 120, 112, 75, 125, 122, 119, 102, 113, 121, 113, 122, 96, 75, 102, 113, 96, 102, 109, 75, 119, 123, 97, 122, 96, 113, 102, 75, 123, 122, 75, 113, 121, 100, 96, 109, 75, 102, 113, 103, 100, 123, 122, 103, 113, 121, 124, 118, 111, 71, 107, 112, 119, 109, 116, 124, 71, 113, 118, 113, 108, 71, 126, 106, 119, 117, 71, 123, 119, 118, 108, 125, 118, 108, 71, 104, 106, 119, 110, 113, 124, 125, 106, 123, 126, 116, 109, 69, 105, 114, 117, 111, 118, 126, 69, 115, 116, 115, 110, 69, 117, 116, 69, 121, 118, 123, 105, 105, 69, 118, 117, 123, 126, 115, 116, 125, 43, 46, 36, 61, 21, 57, 34, 37, 63, 38, 46, 21, 38, 37, 45, 21, 43, 57, 57, 47, 62, 21, 63, 56, 38, 56, 61, 55, 46, 6, 42, 49, 54, 44, 53, 61, 6, 41, 43, 60, 58, 54, 52, 41, 44, 45, 60, 6, 59, 48, 61, 61, 60, 43, 6, 45, 54, 50, 60, 55, 109, 104, 98, 123, 83, ByteCompanionObject.MAX_VALUE, 100, 99, 123, 83, 109, 124, 124, 83, 101, 98, ByteCompanionObject.MAX_VALUE, 120, 109, 96, 96, 83, 109, 104, 83, 104, 105, 120, 109, 101, 96, ByteCompanionObject.MAX_VALUE, 10, 15, 5, 28, 52, 24, 31, 10, 8, 0, 31, 25, 10, 8, 14, 52, 12, 25, 4, 30, 27, 2, 5, 12, 52, 14, 5, 10, 9, 7, 14, 15, 100, 97, 107, 114, 90, 118, 114, 100, 117, 90, 119, 96, 117, 106, 119, 113, 90, 100, 107, 97, 90, 102, 105, 106, 118, 96, 0, 5, 15, 22, 62, 18, 24, 15, 2, 62, 0, 7, 21, 4, 19, 62, 0, 5, 62, 13, 14, 0, 5, 23, 18, 24, 1, 41, 5, 15, 24, 21, 41, 19, 24, 18, 6, 25, 31, 24, 2, 41, 6, 4, 19, 16, 31, 14, 52, 49, 59, 34, 10, 33, 60, 56, 48, 10, 33, 58, 10, 34, 52, 60, 33, 10, 51, 58, 39, 10, 35, 60, 49, 48, 58, 10, 37, 57, 52, 44, 10, 56, 38, 81, 84, 94, 71, 111, 68, 89, 93, 85, 111, 68, 95, 111, 71, 81, 89, 68, 111, 86, 95, 66, 111, 70, 89, 84, 85, 95, 111, 64, 66, 85, 64, 81, 66, 85, 84, 111, 93, 67, 115, 118, 124, 101, 77, 102, 123, ByteCompanionObject.MAX_VALUE, 119, 125, 103, 102, 77, 96, 119, 101, 115, 96, 118, 119, 118, 77, 100, 123, 118, 119, 125, 61, 56, 50, 43, 3, 40, 46, 53, 59, 59, 57, 46, 3, 50, 61, 40, 53, 42, 57, 3, 46, 57, 59, 53, 47, 40, 57, 46, 3, 42, 53, 57, 43, 3, 57, 46, 46, 51, 46, 3, 63, 61, 48, 48, 62, 61, 63, 55, 71, 66, 72, 81, 121, 83, 72, 79, 87, 83, 67, 121, 66, 68, 121, 72, 71, 75, 67, 121, 86, 67, 84, 121, 86, 84, 73, 69, 67, 85, 85, 99, 102, 108, 117, 93, 119, 113, 103, 93, 99, 114, 114, 93, 107, 108, 113, 118, 99, 110, 110, 93, 118, 109, 109, 110, 96, 99, 112, 58, 63, 53, 44, 4, 46, 40, 62, 4, 56, 58, 56, 51, 62, 63, 4, 62, 35, 62, 56, 46, 47, 52, 41, 4, 61, 52, 41, 4, 53, 62, 47, 44, 52, 41, 48, 121, 124, 118, 111, 71, 109, 107, 125, 71, 123, 121, 123, 112, 125, 124, 71, 125, 96, 125, 123, 109, 108, 119, 106, 71, 113, 118, 71, 123, 121, 123, 112, 125, 71, 117, 121, 118, 121, ByteCompanionObject.MAX_VALUE, 125, 106, 34, 39, 45, 52, 28, 54, 48, 38, 28, 49, 42, 51, 51, 47, 38, 28, 34, 45, 42, 46, 34, 55, 42, 44, 45, 25, 28, 22, 15, 39, 14, 17, 29, 15, 25, 26, 17, 20, 17, 12, 1, 39, 27, 16, 29, 27, 19, 39, 25, 10, 29, 25, 39, 26, 25, 11, 29, 28, 94, 74, 75, 80, 77, 80, 75, 94, 75, 90, 96, 91, 86, 76, 94, 93, 83, 90, 91, 44, 56, 57, 34, 63, 34, 57, 44, 57, 40, 18, 40, 35, 44, 47, 33, 40, 41, 34, 45, 40, 34, 42, 38, 52, 32, 51, 37, 30, 53, 40, 44, 36, 30, 44, 50, ByteCompanionObject.MAX_VALUE, 115, 113, 50, 122, 125, ByteCompanionObject.MAX_VALUE, 121, 126, 115, 115, 119, 50, 125, 120, 111, 50, 90, 89, 93, 72, 73, 78, 89, 67, 95, 83, 82, 90, 85, 91, 72, 76, 75, 76, 72, 80, 72, 122, 64, 73, 68, 85, 86, 64, 65, 122, 81, 76, 72, 64, 122, 68, 67, 81, 64, 87, 122, 76, 72, 85, 87, 64, 86, 86, 76, 74, 75, 45, 54, 47, 47, 25, 14, 24, 31, 25, 2, 8, 31, 14, 15, 52, 15, 10, 31, 10, 52, 27, 25, 4, 8, 14, 24, 24, 2, 5, 12, 52, 8, 4, 6, 9, 2, 5, 10, 31, 2, 4, 5, 24, 60, 59, 46, 44, 36, 16, 59, 61, 46, 44, 42, 16, 60, 46, 34, 63, 35, 42, 16, 61, 46, 59, 42, 22, 9, 4, 5, 15, 63, 1, 14, 4, 63, 5, 14, 4, 3, 1, 18, 4, 63, 1, 21, 20, 15, 18, 15, 20, 1, 20, 5, 34, 34, 34};
    }

    public static void A0Z() {
        A03 = new String[]{"lby1W0wNbQrJZLPqMH4DTOw3yxUdqdf", "kgmV30Pytio8Y45c0SmevPSfJ", "GuqAlZnTPhAyqf6xpABukX78gW1eK", "0NViSQPmvGXLcgxETt4LuQqf8msO5qX", "Lug9XUXTwCkms8e17b8k", "9KOEFfUvG6glq1MfonBkT6Lvp1EWxJyS", "tUrZTe4M4NOwFWRIXhIm4QJOvCAxV", "2InOXM9Ds0dFubkAVSo31GYyY3vE8A8q"};
    }

    static {
        A0Z();
        A0Y();
    }

    public J8(Context context) {
        this.A00 = context.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A0N(3413, 31, 50), context), 0);
    }

    public static float A00(Context context) {
        return A0M(context).A1i(A0N(1659, 39, 123), 0.98f);
    }

    public static int A01(Context context) {
        return A0M(context).A1j(A0N(417, 33, 88), 100);
    }

    public static int A02(Context context) {
        return A0M(context).A1j(A0N(1553, 33, 51), 0);
    }

    public static int A03(Context context) {
        return A0M(context).A1j(A0N(1632, 27, 20), -1);
    }

    public static int A04(Context context) {
        return A0M(context).A1j(A0N(634, 37, 63), 3);
    }

    public static int A05(Context context) {
        return A0M(context).A1j(A0N(3395, 18, 111), 0);
    }

    public static int A06(Context context) {
        return A0M(context).A1j(A0N(IronSourceError.ERROR_NO_INTERNET_CONNECTION, 36, 80), 3000);
    }

    public static int A07(Context context) {
        return A0M(context).A1j(A0N(IronSourceError.ERROR_RV_LOAD_SUCCESS_WRONG_AUCTION_ID, 50, 120), HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
    }

    public static int A08(Context context) {
        return A0M(context).A1j(A0N(1123, 40, 67), 3);
    }

    public static int A09(Context context) {
        return A0M(context).A1j(A0N(1079, 44, 31), 8000);
    }

    public static int A0A(Context context) {
        return A0M(context).A1j(A0N(1163, 48, 55), 100);
    }

    public static int A0B(Context context) {
        return A0M(context).A1j(A0N(IronSourceConstants.RV_INSTANCE_READY_FALSE, 39, 37), 60000);
    }

    public static int A0C(Context context) {
        return A0M(context).A1j(A0N(2139, 38, 106), JfifUtil.MARKER_APP1);
    }

    public static int A0D(Context context) {
        return A0M(context).A1j(A0N(866, 41, 46), 3145728);
    }

    public static int A0E(Context context) {
        return A0M(context).A1j(A0N(3444, 37, 11), -1);
    }

    public static int A0F(Context context) {
        return A0M(context).A1j(A0N(2278, 32, 96), 2000);
    }

    public static int A0G(Context context) {
        return A0M(context).A1j(A0N(371, 46, 43), -1);
    }

    public static int A0H(Context context) {
        return A0M(context).A1j(A0N(3524, 23, 97), 0);
    }

    public static int A0I(Context context) {
        return A0M(context).A1j(A0N(IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS, 35, 123), 1000);
    }

    public static int A0J(Context context) {
        return A0M(context).A1j(A0N(3050, 39, 30), 3000);
    }

    public static long A0K(Context context) {
        return A0M(context).A1k(A0N(IronSourceError.ERROR_BN_LOAD_AFTER_INIT_FAILED, 34, 113), 67108864);
    }

    public static long A0L(Context context) {
        return A0M(context).A1k(A0N(715, 45, 74), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
    }

    public static synchronized J8 A0M(Context context) {
        J8 j8;
        synchronized (J8.class) {
            if (A01 == null) {
                A01 = new J8(context);
            }
            j8 = A01;
        }
        return j8;
    }

    public static String A0O(Context context) {
        return A0M(context).A1l(A0N(IronSourceConstants.IS_CALLBACK_AD_SHOW_ERROR, 28, 123), A0N(3575, 3, 123));
    }

    public static String A0P(Context context) {
        return A0M(context).A1l(A0N(2990, 25, 88), A0N(3575, 3, 123));
    }

    public static String A0Q(Context context) {
        return A0M(context).A1l(A0N(117, 52, 109), A0N(1, 6, 36));
    }

    public static String A0R(Context context) {
        return A0M(context).A1l(A0N(268, 51, 11), A0N(24, 41, 29));
    }

    public static String A0S(Context context) {
        return A0M(context).A1l(A0N(169, 53, 86), A0N(7, 8, 63));
    }

    public static String A0T(Context context) {
        return A0M(context).A1l(A0N(319, 52, 81), A0N(15, 9, 110));
    }

    public static Set<String> A0U(Context context) {
        return A0M(context).A0X(A0N(556, 44, 97), A04);
    }

    public static Set<String> A0V(Context context) {
        return A0M(context).A0X(A0N(3485, 39, 69), A05);
    }

    public static Set<String> A0W(Context context) {
        return A0M(context).A0X(A0N(1464, 44, 54), A04);
    }

    private Set<String> A0X(String str, String[] strArr) {
        JSONArray jSONArray;
        String A1l = A1l(str, null);
        if (A1l == null) {
            jSONArray = new JSONArray((Collection) Arrays.asList(strArr));
        } else {
            try {
                jSONArray = new JSONArray(A1l);
            } catch (JSONException unused) {
                return new LinkedHashSet();
            }
        }
        int length = jSONArray.length();
        LinkedHashSet linkedHashSet = new LinkedHashSet(length);
        for (int i = 0; i < length; i++) {
            linkedHashSet.add(jSONArray.getString(i));
        }
        return linkedHashSet;
    }

    public static void A0a(Context context) {
        A0M(context).A00.edit().clear().commit();
    }

    private void A0b(@Nullable String str, @Nullable String str2) throws JSONException {
        if (str != null && !str.isEmpty() && !str.equals(A0N(91, 2, 121))) {
            SharedPreferences.Editor edit = this.A00.edit();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equals(A0N(93, 24, 54))) {
                    A0b(jSONObject.getString(next), next);
                } else {
                    String str3 = next;
                    if (str2 != null) {
                        str3 = str2 + A0N(0, 1, 108) + str3;
                    }
                    edit.putString(str3, jSONObject.getString(next));
                }
            }
            edit.apply();
        }
    }

    public static boolean A0c(Context context) {
        return A0M(context).A1l(A0N(3547, 28, 78), A0N(3358, 19, 17)).equals(A0N(3377, 18, 99));
    }

    public static boolean A0d(Context context) {
        return A0M(context).A1n(A0N(450, 38, 112), false);
    }

    public static boolean A0e(Context context) {
        return A0M(context).A1n(A0N(2450, 37, 2), false);
    }

    public static boolean A0f(Context context) {
        return A0M(context).A1n(A0N(1767, 29, 117), true);
    }

    public static boolean A0g(Context context) {
        return A0M(context).A1n(A0N(2365, 27, 17), false);
    }

    public static boolean A0h(Context context) {
        return A0M(context).A1n(A0N(671, 44, 110), true);
    }

    public static boolean A0i(Context context) {
        return A0M(context).A1n(A0N(1607, 25, 25), true);
    }

    public static boolean A0j(Context context) {
        return A0M(context).A1n(A0N(1698, 39, 65), true);
    }

    public static boolean A0k(Context context) {
        return A0M(context).A1n(A0N(1737, 30, 34), false);
    }

    public static boolean A0l(Context context) {
        return A0M(context).A1n(A0N(798, 33, 83), true);
    }

    public static boolean A0m(Context context) {
        return A0M(context).A1n(A0N(831, 35, 10), false);
    }

    public static boolean A0n(Context context) {
        return A0M(context).A1n(A0N(1872, 18, 72), false);
    }

    public static boolean A0o(Context context) {
        return A0M(context).A1n(A0N(488, 32, 54), false);
    }

    public static boolean A0p(Context context) {
        return A0M(context).A1n(A0N(2052, 25, 85), false);
    }

    public static boolean A0q(Context context) {
        if (Build.VERSION.SDK_INT < 18) {
            return false;
        }
        J8 A0M = A0M(context);
        String A0N = A0N(1796, 25, 108);
        if (A03[5].charAt(10) != 'g') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "eVi9wsoxiKuO8fS3Ni664QsxmOwf4Hz";
        strArr[0] = "nOcXZ0DMfofG3U9htYbEeRQSfAelmGW";
        if (A0M.A1n(A0N, false)) {
            return true;
        }
        return false;
    }

    public static boolean A0r(Context context) {
        return A0M(context).A1n(A0N(2244, 34, 117), false);
    }

    public static boolean A0s(Context context) {
        if (Build.VERSION.SDK_INT < 19 || !A0M(context).A1n(A0N(1890, 15, 102), false)) {
            return false;
        }
        return true;
    }

    public static boolean A0t(Context context) {
        return A0M(context).A1n(A0N(907, 23, 8), false);
    }

    public static boolean A0u(Context context) {
        return A0M(context).A1n(A0N(2177, 41, 22), false);
    }

    public static boolean A0v(Context context) {
        return A0M(context).A1n(A0N(2014, 22, 124), false);
    }

    public static boolean A0w(Context context) {
        return A0M(context).A1n(A0N(2522, 28, 43), true);
    }

    public static boolean A0x(Context context) {
        return A0M(context).A1n(A0N(2550, 31, 0), true);
    }

    public static boolean A0y(Context context) {
        return A0M(context).A1n(A0N(2909, 32, 69), false);
    }

    public static boolean A0z(Context context) {
        return A0M(context).A1n(A0N(222, 46, 76), false);
    }

    public static boolean A10(Context context) {
        return A0M(context).A1n(A0N(1951, 19, 53), true);
    }

    public static boolean A11(Context context) {
        return A0M(context).A1n(A0N(1508, 45, 40), false);
    }

    public static boolean A12(Context context) {
        return A0M(context).A1n(A0N(1970, 25, 90), false);
    }

    public static boolean A13(Context context) {
        return A0M(context).A1n(A0N(1995, 19, 20), true);
    }

    public static boolean A14(Context context) {
        return A0M(context).A1n(A0N(2392, 32, 87), true);
    }

    public static boolean A15(Context context) {
        return A0M(context).A1n(A0N(1250, 57, 69), false);
    }

    public static boolean A16(Context context) {
        return A0M(context).A1n(A0N(1307, 59, 90), true);
    }

    public static boolean A17(Context context) {
        return A0M(context).A1n(A0N(2581, 38, 47), true);
    }

    public static boolean A18(Context context) {
        return A0M(context).A1n(A0N(1586, 21, 119), false);
    }

    public static boolean A19(Context context) {
        return A0M(context).A1n(A0N(2619, 43, 64), true);
    }

    public static boolean A1A(Context context) {
        return A0M(context).A1n(A0N(760, 38, 60), false);
    }

    public static boolean A1B(Context context) {
        return A0M(context).A1n(A0N(IronSourceConstants.IS_AUCTION_REQUEST_WATERFALL, 30, 69), true);
    }

    public static boolean A1C(Context context) {
        return A0M(context).A1n(A0N(930, 48, 49), false);
    }

    public static boolean A1D(Context context) {
        return A0M(context).A1n(A0N(978, 51, 50), false);
    }

    public static boolean A1E(Context context) {
        return A0M(context).A1n(A0N(2662, 31, 91), false);
    }

    public static boolean A1F(Context context) {
        return A0M(context).A1n(A0N(2693, 53, 58), false);
    }

    public static boolean A1G(Context context) {
        return A0M(context).A1n(A0N(2746, 38, 54), true);
    }

    public static boolean A1H(Context context) {
        return A0M(context).A1n(A0N(2784, 33, 52), false);
    }

    public static boolean A1I(Context context) {
        return A0M(context).A1n(A0N(2817, 25, 100), false);
    }

    public static boolean A1J(Context context) {
        return A0M(context).A1n(A0N(2842, 35, 119), false);
    }

    public static boolean A1K(Context context) {
        return A0M(context).A1n(A0N(2424, 26, 66), false);
    }

    public static boolean A1L(Context context) {
        return A0M(context).A1n(A0N(2487, 35, 84), false);
    }

    public static boolean A1M(Context context) {
        return A0M(context).A1n(A0N(2877, 32, 34), false);
    }

    public static boolean A1N(Context context) {
        return A0M(context).A1n(A0N(2941, 26, 43), false);
    }

    public static boolean A1O(Context context) {
        return A0M(context).A1n(A0N(2967, 23, 79), true);
    }

    public static boolean A1P(Context context) {
        return A0M(context).A1n(A0N(3089, 27, 60), false);
    }

    public static boolean A1Q(Context context) {
        return A0M(context).A1n(A0N(3195, 28, 44), false);
    }

    public static boolean A1R(Context context) {
        return A0M(context).A1n(A0N(3325, 33, 86), false);
    }

    public static boolean A1S(Context context) {
        return A0M(context).A1n(A0N(1905, 46, 61), true);
    }

    public static boolean A1T(Context context) {
        return A0M(context).A1n(A0N(2077, 34, 13), false);
    }

    public static boolean A1U(Context context) {
        return A0M(context).A1n(A0N(IronSourceConstants.BN_INSTANCE_LOAD_ERROR, 25, 109), false);
    }

    public static boolean A1V(Context context) {
        return A0M(context).A1n(A0N(3164, 31, 8), false);
    }

    public static boolean A1W(Context context) {
        return A0M(context).A1n(A0N(2036, 16, 108), true);
    }

    public static boolean A1X(Context context) {
        return A0M(context).A1n(A0N(IronSourceConstants.BN_CALLBACK_RELOAD_SUCCESS, 48, 114), false);
    }

    public static boolean A1Y(Context context) {
        return A0M(context).A1n(A0N(1366, 18, 37), false);
    }

    public static boolean A1Z(Context context) {
        return A0M(context).A1n(A0N(1384, 40, 100), false);
    }

    public static boolean A1a(Context context) {
        return A0M(context).A1n(A0N(3223, 36, 117), false);
    }

    public static boolean A1b(Context context) {
        return A0M(context).A1n(A0N(3259, 41, 54), true);
    }

    public static boolean A1c(Context context) {
        if (!A1d(context) || !A0M(context).A1n(A0N(1821, 27, 20), false)) {
            return false;
        }
        return true;
    }

    public static boolean A1d(Context context) {
        if (Build.VERSION.SDK_INT < 19 || !A0M(context).A1n(A0N(1848, 24, 98), false)) {
            return false;
        }
        return true;
    }

    public static boolean A1e(Context context) {
        return A0M(context).A1n(A0N(2218, 26, 24), false);
    }

    public static boolean A1f(Context context) {
        return A0M(context).A1n(A0N(2340, 25, 14), false);
    }

    public static boolean A1g(Context context) {
        return A0M(context).A1n(A0N(1424, 40, 8), true);
    }

    public final double A1h(String str, double d) {
        String string = this.A00.getString(str, String.valueOf(d));
        if (string == null) {
            return d;
        }
        try {
            return string.equals(A0N(3481, 4, 109)) ? d : Double.valueOf(string).doubleValue();
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public final float A1i(String str, float f) {
        String string = this.A00.getString(str, String.valueOf(f));
        if (string == null) {
            return f;
        }
        try {
            return string.equals(A0N(3481, 4, 109)) ? f : Float.valueOf(string).floatValue();
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public final int A1j(String str, int i) {
        String string = this.A00.getString(str, String.valueOf(i));
        if (string == null) {
            return i;
        }
        try {
            return string.equals(A0N(3481, 4, 109)) ? i : Integer.valueOf(string).intValue();
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public final long A1k(String str, long j) {
        String string = this.A00.getString(str, String.valueOf(j));
        if (string == null) {
            return j;
        }
        try {
            return string.equals(A0N(3481, 4, 109)) ? j : Long.valueOf(string).longValue();
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public final String A1l(String str, String str2) {
        String string = this.A00.getString(str, str2);
        return (string == null || string.equals(A0N(3481, 4, 109))) ? str2 : string;
    }

    public final void A1m(@Nullable String str) throws JSONException {
        A0b(str, null);
    }

    public final boolean A1n(String str, boolean z) {
        String string = this.A00.getString(str, String.valueOf(z));
        if (string == null) {
            return z;
        }
        boolean equals = string.equals(A0N(3481, 4, 109));
        if (A03[5].charAt(10) != 'g') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[7] = "2ZyfpebDvRtNljKwQKDVcWpHPVLB6mST";
        strArr[7] = "2ZyfpebDvRtNljKwQKDVcWpHPVLB6mST";
        if (equals) {
            return z;
        }
        Boolean valueOf = Boolean.valueOf(string);
        String[] strArr2 = A03;
        if (strArr2[3].length() != strArr2[0].length()) {
            String[] strArr3 = A03;
            strArr3[3] = "hV4gkZa6iTnBQtPHVFcfTHmR1bNEdnz";
            strArr3[0] = "i5HGVVHoY9v13oxeOLvfdWmm2ZFB1W9";
            return valueOf.booleanValue();
        }
        String[] strArr4 = A03;
        strArr4[3] = "399Nx2YcC1GvFjLdWekHdHFO2r6iBpJ";
        strArr4[0] = "0IRISDuTH5uUbCTD7GqL21M5oCfRTNA";
        return valueOf.booleanValue();
    }
}
