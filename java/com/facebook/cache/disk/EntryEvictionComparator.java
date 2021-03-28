package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import java.util.Comparator;

public interface EntryEvictionComparator extends Comparator<DiskStorage.Entry> {
}
