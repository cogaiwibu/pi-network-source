package com.facebook.ads.redexgen.X;

import android.widget.MediaController;

public class PZ implements MediaController.MediaPlayerControl {
    public static String[] A01;
    public final /* synthetic */ GB A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"hSLXxwS3ED2PXa4HWxT5O8AkoZWeLCaL", "Gmogcdio2x0gXeHeLgUduGgoR45wUaaW", "srtP07DjK9aYu1B8NyoR8EE0J7RhN7X5", "MH7", "NBYiw3cvWUp2yNoHdye4I6uBFIshebL3", "osH0FOpWNHuyeeWL1EivPIw0cJCzEheb", "y4KJdcSo65PTSQflVKQ3KiIVJaTfePYu", "FLJEaU0xa"};
    }

    public PZ(GB gb) {
        this.A00 = gb;
    }

    public final boolean canPause() {
        return true;
    }

    public final boolean canSeekBackward() {
        return true;
    }

    public final boolean canSeekForward() {
        return true;
    }

    public final int getAudioSessionId() {
        if (GB.A00(this.A00) != null) {
            return GB.A00(this.A00).getAudioSessionId();
        }
        return 0;
    }

    public final int getBufferPercentage() {
        return 0;
    }

    public final int getCurrentPosition() {
        return this.A00.getCurrentPosition();
    }

    public final int getDuration() {
        return this.A00.getDuration();
    }

    public final boolean isPlaying() {
        if (GB.A00(this.A00) != null) {
            GB gb = this.A00;
            if (A01[3].length() != 27) {
                String[] strArr = A01;
                strArr[1] = "lkPRs4KbLtabABAzVL2ijXaoS745wM0q";
                strArr[1] = "lkPRs4KbLtabABAzVL2ijXaoS745wM0q";
                if (GB.A00(gb).isPlaying()) {
                    return true;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return false;
    }

    public final void pause() {
        if (GB.A02(this.A00) != null) {
            GB.A02(this.A00).AA7();
        }
    }

    public final void seekTo(int i) {
        this.A00.seekTo(i);
    }

    public final void start() {
        if (GB.A02(this.A00) != null) {
            GB.A02(this.A00).AA8();
        }
    }
}
