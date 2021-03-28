package com.facebook.react.views.text;

public class ReactTagSpan implements ReactSpan {
    private final int mReactTag;

    public ReactTagSpan(int i) {
        this.mReactTag = i;
    }

    public int getReactTag() {
        return this.mReactTag;
    }
}
