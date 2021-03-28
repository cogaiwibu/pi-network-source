package com.ironsource.sdk.Events;

import android.util.Base64;
import com.ironsource.eventsTracker.IFormatter;
import com.ironsource.sdk.constants.Events;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ISNEventsFormatter implements IFormatter {
    @Override // com.ironsource.eventsTracker.IFormatter
    public String format(Map<String, Object> map) {
        try {
            return String.format("%s=%s", "data", Base64.encodeToString(new JSONObject().put(Events.TABLE, Events.TABLE_VALUE).put("data", new JSONObject(map)).toString().getBytes(), 2));
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
