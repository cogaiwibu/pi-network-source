package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;

public class RA extends AbstractRunnableC0510Kc {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ String A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] - i3) - 47;
            if (A02[6].charAt(27) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "CuQnTMvQt2iEBPylhK7T15";
            strArr[1] = "FSZFy24WJ9CShZHmahty6u";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A02[6].charAt(27) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "LuOw";
        strArr[3] = "LuOw";
        A01 = new byte[]{-99, -87, -100, -88, -84, -100, -91, -102, -80, -106, -102, -104, -89, -89, -96, -91, -98};
    }

    public static void A03() {
        A02 = new String[]{"CdCLIQRd", "Gozok8EGiq89CC7S8QZsNr", "pl5lQHAXyLio1ost", "M44cRouQCRL7K0vypo2P04DU", "Y2GzUIW8g3L", "Bs9wehYqNd3BdGUVOwkaAN", "ajmsB695tQiR2xtfKUGvlSwazulcZzs7", "Sy9bhDNhoUd7kDt0yrvFBLns12VVbk64"};
    }

    public RA(String str) {
        this.A00 = str;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        try {
            C00410u.A04.await();
            synchronized (C00410u.A00) {
                Iterator<String> keys = C00410u.A00.A04().keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (C00410u.A0K(this.A00)) {
                        C00410u.A0B((AnonymousClass1K) C00410u.A00.A04().get(next), next, next.equals(this.A00));
                    }
                }
                C00410u.A00.A05();
                C00410u.A07();
            }
        } catch (InterruptedException e) {
            C00410u.A01.A04().A82(A00(0, 17, 8), C02248i.A0w, new C02258j(e));
        } catch (JSONException e2) {
            C00410u.A08();
            C00410u.A01.A04().A82(A00(0, 17, 8), C02248i.A0v, new C02258j(e2));
        }
    }
}
