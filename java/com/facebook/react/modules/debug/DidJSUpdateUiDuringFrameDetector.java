package com.facebook.react.modules.debug;

import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LongArray;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;

public class DidJSUpdateUiDuringFrameDetector implements NotThreadSafeBridgeIdleDebugListener, NotThreadSafeViewHierarchyUpdateDebugListener {
    private final LongArray mTransitionToBusyEvents = LongArray.createWithInitialCapacity(20);
    private final LongArray mTransitionToIdleEvents = LongArray.createWithInitialCapacity(20);
    private final LongArray mViewHierarchyUpdateEnqueuedEvents = LongArray.createWithInitialCapacity(20);
    private final LongArray mViewHierarchyUpdateFinishedEvents = LongArray.createWithInitialCapacity(20);
    private volatile boolean mWasIdleAtEndOfLastFrame = true;

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeIdle() {
        this.mTransitionToIdleEvents.add(System.nanoTime());
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onTransitionToBridgeBusy() {
        this.mTransitionToBusyEvents.add(System.nanoTime());
    }

    @Override // com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener
    public synchronized void onBridgeDestroyed() {
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public synchronized void onViewHierarchyUpdateEnqueued() {
        this.mViewHierarchyUpdateEnqueuedEvents.add(System.nanoTime());
    }

    @Override // com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener
    public synchronized void onViewHierarchyUpdateFinished() {
        this.mViewHierarchyUpdateFinishedEvents.add(System.nanoTime());
    }

    public synchronized boolean getDidJSHitFrameAndCleanup(long j, long j2) {
        boolean z;
        boolean hasEventBetweenTimestamps = hasEventBetweenTimestamps(this.mViewHierarchyUpdateFinishedEvents, j, j2);
        boolean didEndFrameIdle = didEndFrameIdle(j, j2);
        z = true;
        if (!hasEventBetweenTimestamps) {
            if (!didEndFrameIdle || hasEventBetweenTimestamps(this.mViewHierarchyUpdateEnqueuedEvents, j, j2)) {
                z = false;
            }
        }
        cleanUp(this.mTransitionToIdleEvents, j2);
        cleanUp(this.mTransitionToBusyEvents, j2);
        cleanUp(this.mViewHierarchyUpdateEnqueuedEvents, j2);
        cleanUp(this.mViewHierarchyUpdateFinishedEvents, j2);
        this.mWasIdleAtEndOfLastFrame = didEndFrameIdle;
        return z;
    }

    private static boolean hasEventBetweenTimestamps(LongArray longArray, long j, long j2) {
        for (int i = 0; i < longArray.size(); i++) {
            long j3 = longArray.get(i);
            if (j3 >= j && j3 < j2) {
                return true;
            }
        }
        return false;
    }

    private static long getLastEventBetweenTimestamps(LongArray longArray, long j, long j2) {
        long j3 = -1;
        for (int i = 0; i < longArray.size(); i++) {
            long j4 = longArray.get(i);
            if (j4 >= j && j4 < j2) {
                j3 = j4;
            } else if (j4 >= j2) {
                break;
            }
        }
        return j3;
    }

    private boolean didEndFrameIdle(long j, long j2) {
        long lastEventBetweenTimestamps = getLastEventBetweenTimestamps(this.mTransitionToIdleEvents, j, j2);
        long lastEventBetweenTimestamps2 = getLastEventBetweenTimestamps(this.mTransitionToBusyEvents, j, j2);
        if (lastEventBetweenTimestamps == -1 && lastEventBetweenTimestamps2 == -1) {
            return this.mWasIdleAtEndOfLastFrame;
        }
        return lastEventBetweenTimestamps > lastEventBetweenTimestamps2;
    }

    private static void cleanUp(LongArray longArray, long j) {
        int size = longArray.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (longArray.get(i2) < j) {
                i++;
            }
        }
        if (i > 0) {
            for (int i3 = 0; i3 < size - i; i3++) {
                longArray.set(i3, longArray.get(i3 + i));
            }
            longArray.dropTail(i);
        }
    }
}
