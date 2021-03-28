package com.facebook.ads.redexgen.X;

import android.net.Uri;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.DataInputStream;
import java.io.IOException;

public class ZW extends DownloadAction.Deserializer {
    public ZW(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final ZX A01(int i, DataInputStream dataInputStream) throws IOException {
        String str;
        Uri parse = Uri.parse(dataInputStream.readUTF());
        boolean readBoolean = dataInputStream.readBoolean();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        if (dataInputStream.readBoolean()) {
            str = dataInputStream.readUTF();
        } else {
            str = null;
        }
        return new ZX(parse, readBoolean, bArr, str);
    }
}
