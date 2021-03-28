package com.bytedance.sdk.openadsdk.h.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.openadsdk.g.l;
import java.io.File;
import java.io.IOException;
import java.util.List;

/* compiled from: TotalSizeLruDiskUsage */
public class g extends d {
    protected long a;

    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public File a(String str, File file) throws IOException {
        return null;
    }

    public g() {
        this.a = 83886080;
    }

    public g(long j) {
        this.a = j;
        if (j <= 0) {
            this.a = 83886080;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public boolean a(long j, int i) {
        return j < this.a;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public boolean a(File file, long j, int i) {
        return j < this.a / 2;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.d
    public void a(List<File> list) {
        long b = b(list);
        l.c("TotalSizeLruDiskUsage", "当前缓存文件的总size：" + ((b / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + "MB");
        int size = list.size();
        boolean a2 = a(b, size);
        if (a2) {
            l.c("TotalSizeLruDiskUsage", "不满足删除条件，不执行删除操作(true)" + a2);
        } else {
            l.c("TotalSizeLruDiskUsage", "满足删除条件，开始执行删除操作(false)" + a2);
        }
        for (File file : list) {
            if (!a2) {
                l.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
                long length = file.length();
                if (file.delete()) {
                    size--;
                    b -= length;
                    l.c("TotalSizeLruDiskUsage", "删除 一个 Cache file 当前总大小totalSize：" + ((b / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + "MB");
                } else {
                    l.e("TotalSizeLruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
                boolean a3 = a(file, b, size);
                if (a3) {
                    l.c("TotalSizeLruDiskUsage", "当前总大小totalSize：" + ((b / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + "MB，最大值存储上限maxSize=" + ((this.a / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + "MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=" + a3);
                    return;
                }
            }
        }
    }
}
