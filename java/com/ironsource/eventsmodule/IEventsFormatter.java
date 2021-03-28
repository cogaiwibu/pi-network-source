package com.ironsource.eventsmodule;

import java.util.ArrayList;
import org.json.JSONObject;

public interface IEventsFormatter {
    String format(ArrayList<EventData> arrayList, JSONObject jSONObject);
}
