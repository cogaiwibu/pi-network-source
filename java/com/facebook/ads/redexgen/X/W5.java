package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;

public class W5 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ WE A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"fhgAKr3d26sPe206xi", "SjffeijJA1Vv6PcXWUgct", "EsQusZwl1jUwipz2lU1dtOeOynoqp4qu", "0VpWGFYwNM1shdn7oayU", "oGsU7X9gn8B3aKKKnK6Um4C", "3PuUzv37NfYax6hYz8jf", "w27NqvUy0J9VzwNZKDXUsnO8qh2oDxhJ", "FZXbTPmbge4RvKyxAzubgHD8Txvy8Otv"};
    }

    public W5(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null) {
            AbstractC01966x A08 = this.A00.A08(EnumC01926t.A07);
            if (A01[6].charAt(19) != 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "mdGsZgeczhjsROxHbS4UhtOI0ggMdB2A";
            strArr[6] = "mdGsZgeczhjsROxHbS4UhtOI0ggMdB2A";
            return A08;
        } else if (Build.VERSION.SDK_INT >= 24) {
            WE we = this.A00;
            TelephonyManager telephonyManager = we.A00;
            String[] strArr2 = A01;
            if (strArr2[3].length() != strArr2[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[1] = "gYbGBXsMnQLVbPxH35aVX";
            strArr3[4] = "c9uQZVFrEkdSbUXAtWNBNx9";
            return we.A05(telephonyManager.getDataNetworkType());
        } else {
            WE we2 = this.A00;
            String[] strArr4 = A01;
            if (strArr4[2].length() != strArr4[0].length()) {
                String[] strArr5 = A01;
                strArr5[6] = "dEMR1C0fCLJEsmN6YStUhJGVUagFQ5EF";
                strArr5[6] = "dEMR1C0fCLJEsmN6YStUhJGVUagFQ5EF";
                return we2.A05(we2.A00.getNetworkType());
            }
            String[] strArr6 = A01;
            strArr6[7] = "IeVVB4pQAR4pX23W54Z95CGRKG6wHZI8";
            strArr6[7] = "IeVVB4pQAR4pX23W54Z95CGRKG6wHZI8";
            return we2.A05(we2.A00.getNetworkType());
        }
    }
}
