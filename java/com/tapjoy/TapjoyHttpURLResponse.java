package com.tapjoy;

import java.util.List;
import java.util.Map;

public class TapjoyHttpURLResponse {
    public int contentLength;
    public long date;
    public long expires;
    public Map headerFields;
    public String redirectURL;
    public String response;
    public int statusCode;

    public String getHeaderFieldAsString(String str) {
        List list;
        Map map = this.headerFields;
        return (map == null || (list = (List) map.get(str)) == null || list.get(0) == null) ? "" : (String) list.get(0);
    }
}
