package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
import androidx.annotation.Nullable;

public final class BJ {
    public static String[] A06;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    @Nullable
    public final BH A05;

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"W1h", "J3B5KCEbjjwmRuC3OBjGZe6Vqq", "m9qFzMc74R8svEUC9gqMjQn", "jgNIoR8qAkaEc7us150M5yTFbz", "3ys", "w1u", "bbeJnzocKvEAyVfPIveapdYFC3HTaXea", "5a1"};
    }

    public BJ(AudioTrack audioTrack) {
        if (C0466Ig.A02 >= 19) {
            this.A05 = new BH(audioTrack);
            A06();
            return;
        }
        this.A05 = null;
        A01(3);
    }

    private void A01(int i) {
        this.A00 = i;
        if (i == 0) {
            this.A03 = 0;
            this.A01 = -1;
            this.A02 = System.nanoTime() / 1000;
            this.A04 = 5000;
        } else if (i == 1) {
            this.A04 = 5000;
        } else if (i == 2 || i == 3) {
            this.A04 = 10000000;
        } else if (i == 4) {
            this.A04 = 500000;
        } else {
            throw new IllegalStateException();
        }
    }

    public final long A02() {
        BH bh = this.A05;
        if (bh != null) {
            return bh.A01();
        }
        return -1;
    }

    public final long A03() {
        BH bh = this.A05;
        if (bh != null) {
            return bh.A02();
        }
        return -9223372036854775807L;
    }

    public final void A04() {
        if (this.A00 == 4) {
            A06();
        }
    }

    public final void A05() {
        A01(4);
    }

    public final void A06() {
        if (this.A05 != null) {
            A01(0);
        }
    }

    public final boolean A07() {
        int i = this.A00;
        return i == 1 || i == 2;
    }

    public final boolean A08() {
        return this.A00 == 2;
    }

    public final boolean A09(long timestampPositionFrames) {
        BH bh = this.A05;
        if (bh == null || timestampPositionFrames - this.A03 < this.A04) {
            return false;
        }
        this.A03 = timestampPositionFrames;
        boolean A032 = bh.A03();
        int i = this.A00;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        String[] strArr = A06;
                        if (strArr[0].length() != strArr[7].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A06;
                        strArr2[5] = "KBr";
                        strArr2[4] = "FWj";
                        if (i == 4) {
                            return A032;
                        }
                        throw new IllegalStateException();
                    } else if (!A032) {
                        return A032;
                    } else {
                        A06();
                        return A032;
                    }
                } else if (A032) {
                    return A032;
                } else {
                    A06();
                    return A032;
                }
            } else if (!A032) {
                A06();
                return A032;
            } else if (this.A05.A01() <= this.A01) {
                return A032;
            } else {
                A01(2);
                return A032;
            }
        } else if (A032) {
            if (this.A05.A02() < this.A02) {
                return false;
            }
            this.A01 = this.A05.A01();
            String[] strArr3 = A06;
            if (strArr3[1].length() != strArr3[3].length()) {
                A01(1);
                return A032;
            }
            String[] strArr4 = A06;
            strArr4[5] = "X7O";
            strArr4[4] = "dhv";
            A01(1);
            return A032;
        } else if (timestampPositionFrames - this.A02 <= 500000) {
            return A032;
        } else {
            A01(3);
            return A032;
        }
    }
}
