package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.HashMap;
import java.util.List;

public class UC implements AbstractC01816i {
    public static String[] A02;
    public final /* synthetic */ UE A00;
    public final /* synthetic */ List A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"8IgbQbzIeG7tuzbPw4WpTReJHEXOOBaI", "uwr3gwrpCwnsdPI6tcqzo06z5LPFYArK", "KUvtzgiNenvKoXYdIGr4T", "ebtfEWeeh2etvFgGs478sf7cOArxhZcn", "MQ8ux5tmWncWP0t9wyLsU5JzQOIFN", "7dBSxWLu4PAR6eol7PDhhjCLapQyD", "DfYXUN1CCnyCs44nd3kIcNIJOWqVY6eS", "5gEsKmvQZ2K3SsZVO0OSc0798tOlDhoK"};
    }

    public UC(UE ue, List list) {
        this.A00 = ue;
        this.A01 = list;
    }

    /* JADX INFO: Multiple debug info for r0v23 int: [D('currentVolume' int), D('maxVolume' int)] */
    /* JADX INFO: Multiple debug info for r1v12 com.facebook.ads.redexgen.X.UD: [D('minVolume' int), D('audioStreamVolume' com.facebook.ads.redexgen.X.UD)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        C01806h r1;
        int streamKey;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            List list = this.A01;
            if (A02[2].length() != 9) {
                String[] strArr = A02;
                strArr[7] = "wkxUGDPvutXhqdGlSbbbG0nh4qVsuIhH";
                strArr[1] = "9se0a2PCPvuNc9uYSGqMP0X6BOz38YUy";
                if (i >= list.size()) {
                    return this.A00.A03(hashMap);
                }
                List list2 = this.A01;
                String[] strArr2 = A02;
                if (strArr2[5].length() != strArr2[4].length()) {
                    String[] strArr3 = A02;
                    strArr3[7] = "w6bkI8mcFJbdIq2JUa0cw0U5M6INIj0g";
                    strArr3[1] = "5vzP4JEpPTq7RU19xyhl907HqVfLv1o1";
                    r1 = (C01806h) list2.get(i);
                    if (!r1.A02()) {
                        i++;
                    }
                } else {
                    String[] strArr4 = A02;
                    strArr4[0] = "CIZgFD3PxrctzWhUemjZg0F42IFR8Khz";
                    strArr4[3] = "vl3ScUwT7Dxtepa46leMofObvUClFSdC";
                    r1 = (C01806h) list2.get(i);
                    if (!r1.A02()) {
                        i++;
                    }
                }
                int intValue = ((Integer) r1.A01()).intValue();
                if (Build.VERSION.SDK_INT >= 28) {
                    streamKey = this.A00.A00.getStreamMinVolume(intValue);
                } else {
                    streamKey = -1;
                }
                hashMap.put(Integer.valueOf(intValue), new UD(streamKey, this.A00.A00.getStreamVolume(intValue), this.A00.A00.getStreamMaxVolume(intValue)));
                i++;
            } else {
                throw new RuntimeException();
            }
        }
    }
}
