package com.ironsource.mediationsdk.utilities;

import java.util.HashMap;
import java.util.Map;

public class IronsourceMapUtilities {
    public static Map<String, Object> createMap(Object[][] objArr) {
        HashMap hashMap = new HashMap();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    hashMap.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }
}
