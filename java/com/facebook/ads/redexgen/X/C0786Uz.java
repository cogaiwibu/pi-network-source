package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Uz  reason: case insensitive filesystem */
public class C0786Uz implements AbstractC01816i {
    public static String[] A02;
    public final /* synthetic */ V1 A00;
    public final /* synthetic */ List A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"IDUzbTXfLYpZDU4pK2kXQil8tMhG7RY8", "Z5d5k39m9crHDopO6AEw9f8SoKMTT7ix", "IveabQPx2elzsPaafQdxf", "DTCFkmk3oZJb2r35tHvEOgJ8FwtFSJKN", "oJAEAa909Y4vXdHyK3IPvCd4oyzp37cQ", "4smqyHOTFll606jIQbjCa", "GdFqyjY9JjKZ3ZH3Nsuny0jnLefl3EYG", "u7DTPzY4ZnL64vf2BaZ33uVh1ryYgEua"};
    }

    public C0786Uz(V1 v1, List list) {
        this.A00 = v1;
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        HashMap hashMap = new HashMap();
        Iterator it = this.A01.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A02;
            if (strArr[1].charAt(13) != strArr[7].charAt(13)) {
                String[] strArr2 = A02;
                strArr2[1] = "Um1XGSBPp3z3NkeiC1bP7QkPe7DiDluX";
                strArr2[7] = "6eK8uyM5uh6d0JMEhPLz83VmKAM97iIF";
                if (!hasNext) {
                    return this.A00.A03(hashMap);
                }
                C01806h r1 = (C01806h) it.next();
                if (r1.A02()) {
                    String str = (String) r1.A01();
                    hashMap.put(str, new V0(str));
                }
            } else {
                throw new RuntimeException();
            }
        }
    }
}
