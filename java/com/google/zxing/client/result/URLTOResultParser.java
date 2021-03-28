package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class URLTOResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        int indexOf;
        String massagedText = getMassagedText(result);
        String str = null;
        if ((!massagedText.startsWith("urlto:") && !massagedText.startsWith("URLTO:")) || (indexOf = massagedText.indexOf(58, 6)) < 0) {
            return null;
        }
        if (indexOf > 6) {
            str = massagedText.substring(6, indexOf);
        }
        return new URIParsedResult(massagedText.substring(indexOf + 1), str);
    }
}
