package com.facebook.react.devsupport.interfaces;

import android.util.Pair;

public interface ErrorCustomizer {
    Pair<String, StackFrame[]> customizeErrorInfo(Pair<String, StackFrame[]> pair);
}
