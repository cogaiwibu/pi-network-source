package com.facebook.share;

import com.facebook.share.ShareBuilder;

public interface ShareBuilder<P, E extends ShareBuilder> {
    P build();
}
