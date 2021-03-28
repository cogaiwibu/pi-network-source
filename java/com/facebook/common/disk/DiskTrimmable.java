package com.facebook.common.disk;

public interface DiskTrimmable {
    void trimToMinimum();

    void trimToNothing();
}
