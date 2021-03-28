package com.ironsource.mediationsdk.metadata;

import com.ironsource.mediationsdk.metadata.MetaData;
import java.util.ArrayList;
import java.util.List;

public class MetaDataUtils {
    public static MetaData.MetaDataValueTypes getValueTypeForKey(String str) {
        if (str.equalsIgnoreCase(MetaDataConstants.META_DATA_CCPA_KEY) || str.equalsIgnoreCase(MetaDataConstants.META_DATA_COPPA_KEY)) {
            return MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN;
        }
        return MetaData.MetaDataValueTypes.META_DATA_VALUE_STRING;
    }

    public static boolean isKnownKey(String str) {
        return str.equalsIgnoreCase(MetaDataConstants.META_DATA_CCPA_KEY) || str.equalsIgnoreCase(MetaDataConstants.META_DATA_COPPA_KEY);
    }

    public static boolean isMediationOnlyKey(String str) {
        return str.equalsIgnoreCase(MetaDataConstants.META_DATA_COPPA_KEY);
    }

    public static String formatValueForType(String str, MetaData.MetaDataValueTypes metaDataValueTypes) {
        if (metaDataValueTypes != MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN) {
            return str;
        }
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes")) {
            return "true";
        }
        if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no")) {
            return "false";
        }
        return "";
    }

    public static MetaData formatMetaData(String str, List<String> list) {
        if (!isKnownKey(str)) {
            return new MetaData(str, list);
        }
        String lowerCase = str.toLowerCase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : list) {
            MetaData.MetaDataValueTypes valueTypeForKey = getValueTypeForKey(lowerCase);
            String formatValueForType = formatValueForType(str2, valueTypeForKey);
            arrayList.add(valueTypeForKey);
            arrayList2.add(formatValueForType);
        }
        return new MetaData(lowerCase, arrayList2, arrayList);
    }

    public static String checkMetaDataKeyValidity(String str) {
        return (str == null || str.length() > 64 || !str.matches("[A-Za-z0-9_\\-.]+")) ? "The MetaData key you entered is invalid. Please enter a key of maximum 64 characters that consists of only letters, digits and the following characters: . - _" : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String checkMetaDataValueValidity(java.util.List<java.lang.String> r3) {
        /*
            int r0 = r3.size()
            if (r0 != 0) goto L_0x0009
            java.lang.String r3 = "The MetaData list should include at least one element."
            return r3
        L_0x0009:
            java.util.Iterator r3 = r3.iterator()
        L_0x000d:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r3.next()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x002b
            int r1 = r0.length()
            r2 = 64
            if (r1 > r2) goto L_0x002b
            java.lang.String r1 = "[A-Za-z0-9_\\-.]+"
            boolean r0 = r0.matches(r1)
            if (r0 != 0) goto L_0x000d
        L_0x002b:
            java.lang.String r3 = "The MetaData value(s) you entered is invalid. Please enter a value of maximum 64 characters that consists of only letters, digits and the following characters: . - _"
            return r3
        L_0x002e:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.metadata.MetaDataUtils.checkMetaDataValueValidity(java.util.List):java.lang.String");
    }

    public static boolean isValidCCPAMetaData(String str, String str2) {
        return str.equals(MetaDataConstants.META_DATA_CCPA_KEY) && str2.length() > 0;
    }

    public static boolean getMetaDataBooleanValue(String str) {
        return !str.equals("false");
    }
}
