package com.facebook.react.uimanager.debug;

public interface NotThreadSafeViewHierarchyUpdateDebugListener {
    void onViewHierarchyUpdateEnqueued();

    void onViewHierarchyUpdateFinished();
}
