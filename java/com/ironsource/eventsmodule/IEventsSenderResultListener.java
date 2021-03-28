package com.ironsource.eventsmodule;

import java.util.ArrayList;

public interface IEventsSenderResultListener {
    void onEventsSenderResult(ArrayList<EventData> arrayList, boolean z);
}
