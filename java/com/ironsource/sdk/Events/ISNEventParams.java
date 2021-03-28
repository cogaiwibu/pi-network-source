package com.ironsource.sdk.Events;

import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;

public class ISNEventParams {
    private HashMap<String, Object> params = new HashMap<>();

    public HashMap<String, Object> getData() {
        return this.params;
    }

    public ISNEventParams addPair(String str, Object obj) {
        if (obj != null) {
            this.params.put(str, SDKUtils.encodeString(obj.toString()));
        }
        return this;
    }
}
