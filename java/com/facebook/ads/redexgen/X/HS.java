package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class HS extends ImageView implements AbstractC0627Ot {
    public static byte[] A05;
    public static String[] A06;
    public static final int A07 = ((int) (C0535Le.A01 * 4.0f));
    @Nullable
    public C0532Lb A00;
    public final Paint A01;
    public final C0820Wh A02;
    public final JL A03;
    public final I0 A04 = new C02007b(this);

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{101, 93, 92, 77, 8, 105, 76};
    }

    public static void A07() {
        A06 = new String[]{"CZ6R6baQKTb1E5sAmpDqVkfMXF7zVnG4", "nQZGX73N3q5NRRZlZyP90gUTrDeeLYBu", "LfCM6PYFJNbwOvLH4thVDQon3h1Zk2zk", "bpUakkTElIOqaP65ISNG9oh", "gJtMODfbj2e7z8MJG7ZRKfD", "8rYwk9o7IGDDsMQbyUTj4ra1LUt9E6qX", "3WiLQHXTUUJ8WctEatoRQ", "Xo7nIXQ5hsw2R0tzDjIU8fyfjH4jtFIR"};
    }

    static {
        A07();
        A06();
    }

    public HS(C0820Wh wh, JL jl) {
        super(wh);
        this.A03 = jl;
        this.A02 = wh;
        this.A01 = new Paint();
        this.A01.setColor(-1728053248);
        setColorFilter(-1);
        int i = A07;
        setPadding(i, i, i, i);
        setContentDescription(A03(0, 7, 59));
        A05();
        setOnClickListener(new P6(this));
    }

    private void A04() {
        setImageBitmap(C0544Ln.A00(EnumC0543Lm.SOUND_OFF));
    }

    private void A05() {
        setImageBitmap(C0544Ln.A00(EnumC0543Lm.SOUND_ON));
    }

    /* access modifiers changed from: private */
    public boolean A08() {
        C0532Lb lb = this.A00;
        if (lb != null) {
            float volume = lb.getVolume();
            String[] strArr = A06;
            if (strArr[5].charAt(12) != strArr[1].charAt(12)) {
                String[] strArr2 = A06;
                strArr2[3] = "7LwdJMyLjSlNEKSwxkcw7Q3";
                strArr2[6] = "d5nTRpYYugpReKnwSxkEX";
                if (volume == 0.0f) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    public final void A0A() {
        if (this.A00 != null) {
            if (A08()) {
                A04();
            } else {
                A05();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void A7s(C0532Lb lb) {
        this.A00 = lb;
        C0532Lb lb2 = this.A00;
        if (lb2 != null) {
            lb2.getEventBus().A06(this.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void ADa(C0532Lb lb) {
        C0532Lb lb2 = this.A00;
        if (lb2 != null) {
            lb2.getEventBus().A07(this.A04);
        }
        this.A00 = null;
    }

    public final void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        canvas.drawCircle((float) width, (float) height, (float) Math.min(width, height), this.A01);
        super.onDraw(canvas);
    }
}
