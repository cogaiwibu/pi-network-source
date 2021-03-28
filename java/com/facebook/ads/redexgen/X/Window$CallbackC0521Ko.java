package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ko  reason: case insensitive filesystem */
public final class Window$CallbackC0521Ko implements Window.Callback {
    public static final List<Kn> A02 = Collections.synchronizedList(new ArrayList());
    public Activity A00;
    public Window.Callback A01;

    public Window$CallbackC0521Ko(Window.Callback callback, Activity activity) {
        this.A01 = callback;
        this.A00 = activity;
    }

    public static void A00(Kn kn) {
        A02.add(kn);
    }

    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.A01.dispatchGenericMotionEvent(motionEvent);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.A01.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.A01.dispatchKeyShortcutEvent(keyEvent);
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.A01.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        for (Kn kn : A02) {
            kn.A4p(motionEvent);
        }
        return this.A01.dispatchTouchEvent(motionEvent);
    }

    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.A01.dispatchTrackballEvent(motionEvent);
    }

    public final void onActionModeFinished(ActionMode actionMode) {
        this.A01.onActionModeFinished(actionMode);
    }

    public final void onActionModeStarted(ActionMode actionMode) {
        this.A01.onActionModeStarted(actionMode);
    }

    public final void onAttachedToWindow() {
        this.A01.onAttachedToWindow();
    }

    public final void onContentChanged() {
        this.A01.onContentChanged();
    }

    public final boolean onCreatePanelMenu(int i, Menu menu) {
        return this.A01.onCreatePanelMenu(i, menu);
    }

    @Nullable
    public final View onCreatePanelView(int i) {
        return this.A01.onCreatePanelView(i);
    }

    public final void onDetachedFromWindow() {
        this.A01.onDetachedFromWindow();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.A01.onMenuItemSelected(i, menuItem);
    }

    public final boolean onMenuOpened(int i, Menu menu) {
        return this.A01.onMenuOpened(i, menu);
    }

    public final void onPanelClosed(int i, Menu menu) {
        this.A01.onPanelClosed(i, menu);
    }

    public final boolean onPreparePanel(int i, View view, Menu menu) {
        return this.A01.onPreparePanel(i, view, menu);
    }

    public final boolean onSearchRequested() {
        return this.A01.onSearchRequested();
    }

    @TargetApi(23)
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.A01.onSearchRequested(searchEvent);
    }

    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.A01.onWindowAttributesChanged(layoutParams);
    }

    public final void onWindowFocusChanged(boolean z) {
        this.A01.onWindowFocusChanged(z);
    }

    @Nullable
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.A01.onWindowStartingActionMode(callback);
    }

    @Nullable
    @TargetApi(23)
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.A01.onWindowStartingActionMode(callback, i);
    }
}
