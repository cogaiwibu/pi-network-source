package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class NI extends WebChromeClient {
    public static String[] A02;
    public final WeakReference<NH> A00;
    public final WeakReference<NE> A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"YcV2lPdb1GD", "n5DgX5QSw4FQX59vcvxBmCs4C4mD4", "EksZFw55Ld98qazTViJtw6pSuONG6", "FQxvmp8vruM", "8OOSEuFQ7OrFhHkYKSo1UtYVyasxVGnA", "3ltH6wFp1GB97FT9l8RHOrWs4kHkX0iG", "Qgk2ZsNAH7VHvpqjGWkwA7olVBMIpezg", "lYuGhUBeP576iz9ihjd4qaMvDoX6gejl"};
    }

    public NI(WeakReference<NH> weakReference, WeakReference<NE> weakReference2) {
        this.A00 = weakReference;
        this.A01 = weakReference2;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        if (TextUtils.isEmpty(message) || consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.LOG) {
            return true;
        }
        NE ne = this.A01.get();
        String[] strArr = A02;
        if (strArr[1].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "G67BWScyobP0YXfVqACryJUIpKzfHuOG";
        strArr2[5] = "G67BWScyobP0YXfVqACryJUIpKzfHuOG";
        if (ne == null) {
            return true;
        }
        this.A01.get().A05(message);
        return true;
    }

    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (this.A01.get() != null) {
            this.A01.get().A04();
        }
        if (this.A00.get() != null) {
            this.A00.get().AAd(i);
        }
    }

    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.A00.get() != null) {
            this.A00.get().AAi(str);
        }
    }
}
