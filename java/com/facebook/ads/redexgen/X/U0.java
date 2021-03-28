package com.facebook.ads.redexgen.X;

public class U0 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ U7 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"CyYconlRA", "Z99FvxWAH", "r", "I6nMbGSwO", "f1HEaIkkO6UN2Wyn2K6t6YhOL5YQHMub", "q7TOnFp8MDH9pVcAi7q7X5O", "kHDnEbJrZHu3VwOwnck16fHaeHzzt8", "W41og5bN"};
    }

    public U0(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A01 != null) {
            U7 u7 = this.A00;
            String[] strArr = A01;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "ZWV";
            strArr2[2] = "ZWV";
            return u7.A09(u7.A01.sourceDir);
        }
        U7 u72 = this.A00;
        if (A01[6].length() == 14) {
            return u72.A08(EnumC01926t.A07);
        }
        String[] strArr3 = A01;
        strArr3[6] = "1VAENbmq7tYIb9ZQI0D0jEbiw3q";
        strArr3[6] = "1VAENbmq7tYIb9ZQI0D0jEbiw3q";
        return u72.A08(EnumC01926t.A07);
    }
}
