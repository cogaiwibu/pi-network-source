package com.facebook.ads.redexgen.X;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

public class O9 extends WebChromeClient {
    public final /* synthetic */ C0664Qe A00;

    public O9(C0664Qe qe) {
        this.A00 = qe;
    }

    public /* synthetic */ O9(C0664Qe qe, C0669Qj qj) {
        this(qe);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            this.A00.A09.A03(JK.A0N, null);
            this.A00.A0F.A05(C02248i.A0q, consoleMessage.message());
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
