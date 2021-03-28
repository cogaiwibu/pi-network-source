package com.tapjoy.internal;

import java.util.List;

public final class aw {
    public static void a(List list, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > 0) {
            int size = list.size();
            if (i > size) {
                throw new IndexOutOfBoundsException();
            } else if (i == size) {
                list.clear();
            } else {
                while (true) {
                    int i2 = i - 1;
                    if (i > 0) {
                        list.remove(0);
                        i = i2;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
