package com.facebook.appevents.eventdeactivation;

import com.facebook.appevents.AppEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class EventDeactivationManager {
    private static final Set<String> deprecatedEvents = new HashSet();
    private static final List<DeprecatedParamFilter> deprecatedParamFilters = new ArrayList();
    private static boolean enabled = false;

    public static void enable() {
        enabled = true;
        initialize();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void initialize() {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.eventdeactivation.EventDeactivationManager.initialize():void");
    }

    public static void processEvents(List<AppEvent> list) {
        if (enabled) {
            Iterator<AppEvent> it = list.iterator();
            while (it.hasNext()) {
                if (deprecatedEvents.contains(it.next().getName())) {
                    it.remove();
                }
            }
        }
    }

    public static void processDeprecatedParameters(Map<String, String> map, String str) {
        if (enabled) {
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            for (DeprecatedParamFilter deprecatedParamFilter : new ArrayList(deprecatedParamFilters)) {
                if (deprecatedParamFilter.eventName.equals(str)) {
                    for (String str2 : arrayList) {
                        if (deprecatedParamFilter.deprecateParams.contains(str2)) {
                            map.remove(str2);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class DeprecatedParamFilter {
        List<String> deprecateParams;
        String eventName;

        DeprecatedParamFilter(String str, List<String> list) {
            this.eventName = str;
            this.deprecateParams = list;
        }
    }
}
