package com.ironsource.eventsmodule;

import java.util.ArrayList;
import java.util.List;

public interface IEventsStorageHelper {
    void clearEvents(String str);

    ArrayList<EventData> loadEvents(String str);

    void saveEvents(List<EventData> list, String str);
}
