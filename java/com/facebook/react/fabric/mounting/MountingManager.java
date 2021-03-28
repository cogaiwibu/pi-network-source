package com.facebook.react.fabric.mounting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.yoga.YogaMeasureMode;
import java.util.concurrent.ConcurrentHashMap;

public class MountingManager {
    public static final String TAG = MountingManager.class.getSimpleName();
    private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();
    private final RootViewManager mRootViewManager = new RootViewManager();
    private final ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    private final ViewManagerRegistry mViewManagerRegistry;

    public MountingManager(ViewManagerRegistry viewManagerRegistry) {
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    public void addRootView(int i, View view) {
        if (view.getId() == -1) {
            this.mTagToViewState.put(Integer.valueOf(i), new ViewState(i, view, this.mRootViewManager, true));
            view.setId(i);
            return;
        }
        throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
    }

    private void dropView(View view) {
        UiThreadUtil.assertOnUiThread();
        int id = view.getId();
        ViewState viewState = getViewState(id);
        ViewManager viewManager = viewState.mViewManager;
        if (!viewState.mIsRoot && viewManager != null) {
            viewManager.onDropViewInstance(view);
        }
        if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
            ViewGroup viewGroup = (ViewGroup) view;
            ViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(viewState);
            for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                if (getNullableViewState(childAt.getId()) != null) {
                    dropView(childAt);
                }
                viewGroupManager.removeViewAt(viewGroup, childCount);
            }
        }
        this.mTagToViewState.remove(Integer.valueOf(id));
    }

    public void addViewAt(int i, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        ViewGroup viewGroup = (ViewGroup) viewState.mView;
        ViewState viewState2 = getViewState(i2);
        View view = viewState2.mView;
        if (view != null) {
            getViewGroupManager(viewState).addView(viewGroup, view, i3);
            return;
        }
        throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i2);
    }

    private ViewState getViewState(int i) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
        if (viewState != null) {
            return viewState;
        }
        throw new IllegalStateException("Unable to find viewState view for tag " + i);
    }

    private ViewState getNullableViewState(int i) {
        return this.mTagToViewState.get(Integer.valueOf(i));
    }

    @Deprecated
    public void receiveCommand(int i, int i2, ReadableArray readableArray) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str = TAG;
            ReactSoftException.logSoftException(str, new ReactNoCrashSoftException("Unable to find viewState for tag: " + i + " for commandId: " + i2));
        } else if (nullableViewState.mViewManager == null) {
            throw new IllegalStateException("Unable to find viewManager for tag " + i);
        } else if (nullableViewState.mView != null) {
            nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, i2, readableArray);
        } else {
            throw new IllegalStateException("Unable to find viewState view for tag " + i);
        }
    }

    public void receiveCommand(int i, String str, ReadableArray readableArray) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str2 = TAG;
            ReactSoftException.logSoftException(str2, new IllegalStateException("Unable to find viewState for tag: " + i + " for commandId: " + str));
        } else if (nullableViewState.mViewManager == null) {
            throw new IllegalStateException("Unable to find viewState manager for tag " + i);
        } else if (nullableViewState.mView != null) {
            nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, str, readableArray);
        } else {
            throw new IllegalStateException("Unable to find viewState view for tag " + i);
        }
    }

    public void sendAccessibilityEvent(int i, int i2) {
        ViewState viewState = getViewState(i);
        if (viewState.mViewManager == null) {
            throw new IllegalStateException("Unable to find viewState manager for tag " + i);
        } else if (viewState.mView != null) {
            viewState.mView.sendAccessibilityEvent(i2);
        } else {
            throw new IllegalStateException("Unable to find viewState view for tag " + i);
        }
    }

    private static ViewGroupManager<ViewGroup> getViewGroupManager(ViewState viewState) {
        if (viewState.mViewManager != null) {
            return (ViewGroupManager) viewState.mViewManager;
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    public void removeViewAt(int i, int i2) {
        UiThreadUtil.assertOnUiThread();
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str = TAG;
            ReactSoftException.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i + " for removeViewAt"));
            return;
        }
        ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
        if (viewGroup != null) {
            getViewGroupManager(nullableViewState).removeViewAt(viewGroup, i2);
            return;
        }
        throw new IllegalStateException("Unable to find view for tag " + i);
    }

    public void createView(ThemedReactContext themedReactContext, String str, int i, ReadableMap readableMap, StateWrapper stateWrapper, boolean z) {
        ViewManager viewManager;
        View view;
        if (getNullableViewState(i) == null) {
            ReadableNativeMap readableNativeMap = null;
            ReactStylesDiffMap reactStylesDiffMap = readableMap != null ? new ReactStylesDiffMap(readableMap) : null;
            if (z) {
                viewManager = this.mViewManagerRegistry.get(str);
                view = viewManager.createView(themedReactContext, reactStylesDiffMap, stateWrapper, this.mJSResponderHandler);
                view.setId(i);
            } else {
                view = null;
                viewManager = null;
            }
            ViewState viewState = new ViewState(i, view, viewManager);
            viewState.mCurrentProps = reactStylesDiffMap;
            if (stateWrapper != null) {
                readableNativeMap = stateWrapper.getState();
            }
            viewState.mCurrentState = readableNativeMap;
            this.mTagToViewState.put(Integer.valueOf(i), viewState);
        }
    }

    public void updateProps(int i, ReadableMap readableMap) {
        if (readableMap != null) {
            UiThreadUtil.assertOnUiThread();
            ViewState viewState = getViewState(i);
            viewState.mCurrentProps = new ReactStylesDiffMap(readableMap);
            View view = viewState.mView;
            if (view != null) {
                ((ViewManager) Assertions.assertNotNull(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag " + i);
        }
    }

    public void updateLayout(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (!viewState.mIsRoot) {
            View view = viewState.mView;
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                ViewParent parent = view.getParent();
                if (parent instanceof RootView) {
                    parent.requestLayout();
                }
                view.layout(i2, i3, i4 + i2, i5 + i3);
                return;
            }
            throw new IllegalStateException("Unable to find View for tag: " + i);
        }
    }

    public void updatePadding(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (!viewState.mIsRoot) {
            View view = viewState.mView;
            if (view != null) {
                ViewManager viewManager = viewState.mViewManager;
                if (viewManager != null) {
                    viewManager.setPadding(view, i2, i3, i4, i5);
                    return;
                }
                throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
            }
            throw new IllegalStateException("Unable to find View for tag: " + i);
        }
    }

    public void deleteView(int i) {
        UiThreadUtil.assertOnUiThread();
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str = TAG;
            ReactSoftException.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i + " for deleteView"));
            return;
        }
        View view = nullableViewState.mView;
        if (view != null) {
            dropView(view);
        } else {
            this.mTagToViewState.remove(Integer.valueOf(i));
        }
    }

    public void updateLocalData(int i, ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (viewState.mCurrentProps == null) {
            throw new IllegalStateException("Can not update local data to view without props: " + i);
        } else if (viewState.mCurrentLocalData == null || !readableMap.hasKey("hash") || viewState.mCurrentLocalData.getDouble("hash") != readableMap.getDouble("hash") || !viewState.mCurrentLocalData.equals(readableMap)) {
            viewState.mCurrentLocalData = readableMap;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateLocalData = viewManager.updateLocalData(viewState.mView, viewState.mCurrentProps, new ReactStylesDiffMap(viewState.mCurrentLocalData));
                if (updateLocalData != null) {
                    viewManager.updateExtraData(viewState.mView, updateLocalData);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
        }
    }

    public void updateState(int i, StateWrapper stateWrapper) {
        ReadableNativeMap readableNativeMap;
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (stateWrapper == null) {
            readableNativeMap = null;
        } else {
            readableNativeMap = stateWrapper.getState();
        }
        if (viewState.mCurrentState != null && viewState.mCurrentState.equals(readableNativeMap)) {
            return;
        }
        if (viewState.mCurrentState != null || stateWrapper != null) {
            viewState.mCurrentState = readableNativeMap;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateState = viewManager.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
                if (updateState != null) {
                    viewManager.updateExtraData(viewState.mView, updateState);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i);
        }
    }

    public void preallocateView(ThemedReactContext themedReactContext, String str, int i, ReadableMap readableMap, StateWrapper stateWrapper, boolean z) {
        if (getNullableViewState(i) == null) {
            createView(themedReactContext, str, i, readableMap, stateWrapper, z);
            return;
        }
        throw new IllegalStateException("View for component " + str + " with tag " + i + " already exists.");
    }

    public void updateEventEmitter(int i, EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        getViewState(i).mEventEmitter = eventEmitterWrapper;
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        if (!z) {
            this.mJSResponderHandler.setJSResponder(i2, null);
            return;
        }
        ViewState viewState = getViewState(i);
        View view = viewState.mView;
        if (i2 != i && (view instanceof ViewParent)) {
            this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
        } else if (view == null) {
            SoftAssertions.assertUnreachable("Cannot find view for tag " + i + ".");
        } else {
            if (viewState.mIsRoot) {
                SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
            }
            this.mJSResponderHandler.setJSResponder(i2, view.getParent());
        }
    }

    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    public long measure(Context context, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        return this.mViewManagerRegistry.get(str).measure(context, readableMap, readableMap2, readableMap3, f, yogaMeasureMode, f2, yogaMeasureMode2);
    }

    public EventEmitterWrapper getEventEmitter(int i) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    /* access modifiers changed from: private */
    public static class ViewState {
        public ReadableMap mCurrentLocalData;
        public ReactStylesDiffMap mCurrentProps;
        public ReadableMap mCurrentState;
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        final int mReactTag;
        final View mView;
        final ViewManager mViewManager;

        private ViewState(int i, View view, ViewManager viewManager) {
            this(i, view, viewManager, false);
        }

        private ViewState(int i, View view, ViewManager viewManager, boolean z) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mCurrentState = null;
            this.mEventEmitter = null;
            this.mReactTag = i;
            this.mView = view;
            this.mIsRoot = z;
            this.mViewManager = viewManager;
        }

        public String toString() {
            boolean z = this.mViewManager == null;
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + z;
        }
    }
}
