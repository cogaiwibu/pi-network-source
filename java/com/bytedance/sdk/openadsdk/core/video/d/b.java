package com.bytedance.sdk.openadsdk.core.video.d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.g.l;
import com.facebook.common.util.UriUtil;
import java.util.HashMap;

/* compiled from: MediaUtils */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b  reason: collision with other inner class name */
    /* compiled from: MediaUtils */
    public interface AbstractC0006b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, AbstractC0006b bVar) {
        new a(bVar, j).execute(str);
    }

    /* compiled from: MediaUtils */
    public static class a extends AsyncTask<String, Integer, Bitmap> {
        private AbstractC0006b a;
        private long b = 0;

        public a(AbstractC0006b bVar, long j) {
            this.a = bVar;
            this.b = j;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith(UriUtil.HTTP_SCHEME)) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(this.b * 1000, 3);
                mediaMetadataRetriever.release();
                return frameAtTime;
            } catch (Throwable th) {
                l.b("MediaUtils", "MediaUtils doInBackground : ", th);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            AbstractC0006b bVar = this.a;
            if (bVar != null) {
                bVar.a(bitmap);
            }
        }
    }
}
