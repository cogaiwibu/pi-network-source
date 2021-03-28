package com.google.zxing.client.result;

public final class ExpandedProductResultParser extends ResultParser {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01fb, code lost:
        if (r1.equals("10") != false) goto L_0x0216;
     */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0260  */
    @Override // com.google.zxing.client.result.ResultParser
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.ExpandedProductParsedResult parse(com.google.zxing.Result r25) {
        /*
        // Method dump skipped, instructions count: 778
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ExpandedProductResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.ExpandedProductParsedResult");
    }

    private static String findAIvalue(int i, String str) {
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        for (int i2 = 0; i2 < substring.length(); i2++) {
            char charAt = substring.charAt(i2);
            if (charAt == '(') {
                if (findAIvalue(i2, substring) != null) {
                    break;
                }
                sb.append('(');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
