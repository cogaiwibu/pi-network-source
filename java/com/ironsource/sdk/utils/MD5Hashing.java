package com.ironsource.sdk.utils;

import com.facebook.appevents.AppEventsConstants;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class MD5Hashing {
    private static final byte[] padding = {ByteCompanionObject.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] decodeBuffer = new int[16];
    private MD5State finalState = new MD5State();
    private MD5State workingState = new MD5State();

    private static int FF(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & i2) | (i4 & (i2 ^ -1))) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int GG(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & (i4 ^ -1)) | (i2 & i4)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int HH(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 ^ i2) ^ i4) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int II(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + (i3 ^ ((i4 ^ -1) | i2)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static byte[] encode(long j) {
        return new byte[]{(byte) ((int) (j & 255)), (byte) ((int) ((j >>> 8) & 255)), (byte) ((int) ((j >>> 16) & 255)), (byte) ((int) ((j >>> 24) & 255)), (byte) ((int) ((j >>> 32) & 255)), (byte) ((int) ((j >>> 40) & 255)), (byte) ((int) ((j >>> 48) & 255)), (byte) ((int) ((j >>> 56) & 255))};
    }

    MD5Hashing() {
        reset();
    }

    public byte[] getHash() {
        if (!this.finalState.valid) {
            this.finalState.copy(this.workingState);
            long j = this.finalState.bitCount;
            int i = (int) ((j >>> 3) & 63);
            update(this.finalState, padding, 0, i < 56 ? 56 - i : 120 - i);
            update(this.finalState, encode(j), 0, 8);
            this.finalState.valid = true;
        }
        return encode(this.finalState.state, 16);
    }

    public String getHashString() {
        return toHex(getHash());
    }

    public static String getHashString(String str) {
        MD5Hashing mD5Hashing = new MD5Hashing();
        mD5Hashing.update(str);
        return mD5Hashing.getHashString();
    }

    public void reset() {
        this.workingState.reset();
        this.finalState.valid = false;
    }

    public String toString() {
        return getHashString();
    }

    private void update(MD5State mD5State, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.finalState.valid = false;
        if (i2 + i > bArr.length) {
            i2 = bArr.length - i;
        }
        int i4 = ((int) (mD5State.bitCount >>> 3)) & 63;
        mD5State.bitCount += (long) (i2 << 3);
        int i5 = 64 - i4;
        if (i2 >= i5) {
            System.arraycopy(bArr, i, mD5State.buffer, i4, i5);
            transform(mD5State, decode(mD5State.buffer, 64, 0));
            while (i5 + 63 < i2) {
                transform(mD5State, decode(bArr, 64, i5));
                i5 += 64;
            }
            i3 = i5;
            i4 = 0;
        }
        if (i3 < i2) {
            for (int i6 = i3; i6 < i2; i6++) {
                mD5State.buffer[(i4 + i6) - i3] = bArr[i6 + i];
            }
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        update(this.workingState, bArr, i, i2);
    }

    public void update(byte[] bArr, int i) {
        update(bArr, 0, i);
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte b) {
        update(new byte[]{b}, 1);
    }

    public void update(String str) {
        update(str.getBytes());
    }

    public void update(String str, String str2) throws UnsupportedEncodingException {
        update(str.getBytes(str2));
    }

    /* access modifiers changed from: private */
    public class MD5State {
        private long bitCount;
        private byte[] buffer;
        private int[] state;
        private boolean valid;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void reset() {
            int[] iArr = this.state;
            iArr[0] = 1732584193;
            iArr[1] = -271733879;
            iArr[2] = -1732584194;
            iArr[3] = 271733878;
            this.bitCount = 0;
        }

        private MD5State() {
            this.valid = true;
            this.state = new int[4];
            this.buffer = new byte[64];
            reset();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void copy(MD5State mD5State) {
            byte[] bArr = mD5State.buffer;
            byte[] bArr2 = this.buffer;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            int[] iArr = mD5State.state;
            int[] iArr2 = this.state;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.valid = mD5State.valid;
            this.bitCount = mD5State.bitCount;
        }
    }

    private static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & UByte.MAX_VALUE;
            if (i < 16) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString();
    }

    private static byte[] encode(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) (iArr[i2] & 255);
            bArr[i3 + 1] = (byte) ((iArr[i2] >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((iArr[i2] >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((iArr[i2] >>> 24) & 255);
            i2++;
        }
        return bArr;
    }

    private int[] decode(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4 += 4) {
            this.decodeBuffer[i3] = (bArr[i4 + i2] & UByte.MAX_VALUE) | ((bArr[(i4 + 1) + i2] & UByte.MAX_VALUE) << 8) | ((bArr[(i4 + 2) + i2] & UByte.MAX_VALUE) << 16) | ((bArr[(i4 + 3) + i2] & UByte.MAX_VALUE) << 24);
            i3++;
        }
        return this.decodeBuffer;
    }

    private static void transform(MD5State mD5State, int[] iArr) {
        int i = mD5State.state[0];
        int i2 = mD5State.state[1];
        int i3 = mD5State.state[2];
        int i4 = mD5State.state[3];
        int FF = FF(i, i2, i3, i4, iArr[0], 7, -680876936);
        int FF2 = FF(i4, FF, i2, i3, iArr[1], 12, -389564586);
        int FF3 = FF(i3, FF2, FF, i2, iArr[2], 17, 606105819);
        int FF4 = FF(i2, FF3, FF2, FF, iArr[3], 22, -1044525330);
        int FF5 = FF(FF, FF4, FF3, FF2, iArr[4], 7, -176418897);
        int FF6 = FF(FF2, FF5, FF4, FF3, iArr[5], 12, 1200080426);
        int FF7 = FF(FF3, FF6, FF5, FF4, iArr[6], 17, -1473231341);
        int FF8 = FF(FF4, FF7, FF6, FF5, iArr[7], 22, -45705983);
        int FF9 = FF(FF5, FF8, FF7, FF6, iArr[8], 7, 1770035416);
        int FF10 = FF(FF6, FF9, FF8, FF7, iArr[9], 12, -1958414417);
        int FF11 = FF(FF7, FF10, FF9, FF8, iArr[10], 17, -42063);
        int FF12 = FF(FF8, FF11, FF10, FF9, iArr[11], 22, -1990404162);
        int FF13 = FF(FF9, FF12, FF11, FF10, iArr[12], 7, 1804603682);
        int FF14 = FF(FF10, FF13, FF12, FF11, iArr[13], 12, -40341101);
        int FF15 = FF(FF11, FF14, FF13, FF12, iArr[14], 17, -1502002290);
        int FF16 = FF(FF12, FF15, FF14, FF13, iArr[15], 22, 1236535329);
        int GG = GG(FF13, FF16, FF15, FF14, iArr[1], 5, -165796510);
        int GG2 = GG(FF14, GG, FF16, FF15, iArr[6], 9, -1069501632);
        int GG3 = GG(FF15, GG2, GG, FF16, iArr[11], 14, 643717713);
        int GG4 = GG(FF16, GG3, GG2, GG, iArr[0], 20, -373897302);
        int GG5 = GG(GG, GG4, GG3, GG2, iArr[5], 5, -701558691);
        int GG6 = GG(GG2, GG5, GG4, GG3, iArr[10], 9, 38016083);
        int GG7 = GG(GG3, GG6, GG5, GG4, iArr[15], 14, -660478335);
        int GG8 = GG(GG4, GG7, GG6, GG5, iArr[4], 20, -405537848);
        int GG9 = GG(GG5, GG8, GG7, GG6, iArr[9], 5, 568446438);
        int GG10 = GG(GG6, GG9, GG8, GG7, iArr[14], 9, -1019803690);
        int GG11 = GG(GG7, GG10, GG9, GG8, iArr[3], 14, -187363961);
        int GG12 = GG(GG8, GG11, GG10, GG9, iArr[8], 20, 1163531501);
        int GG13 = GG(GG9, GG12, GG11, GG10, iArr[13], 5, -1444681467);
        int GG14 = GG(GG10, GG13, GG12, GG11, iArr[2], 9, -51403784);
        int GG15 = GG(GG11, GG14, GG13, GG12, iArr[7], 14, 1735328473);
        int GG16 = GG(GG12, GG15, GG14, GG13, iArr[12], 20, -1926607734);
        int HH = HH(GG13, GG16, GG15, GG14, iArr[5], 4, -378558);
        int HH2 = HH(GG14, HH, GG16, GG15, iArr[8], 11, -2022574463);
        int HH3 = HH(GG15, HH2, HH, GG16, iArr[11], 16, 1839030562);
        int HH4 = HH(GG16, HH3, HH2, HH, iArr[14], 23, -35309556);
        int HH5 = HH(HH, HH4, HH3, HH2, iArr[1], 4, -1530992060);
        int HH6 = HH(HH2, HH5, HH4, HH3, iArr[4], 11, 1272893353);
        int HH7 = HH(HH3, HH6, HH5, HH4, iArr[7], 16, -155497632);
        int HH8 = HH(HH4, HH7, HH6, HH5, iArr[10], 23, -1094730640);
        int HH9 = HH(HH5, HH8, HH7, HH6, iArr[13], 4, 681279174);
        int HH10 = HH(HH6, HH9, HH8, HH7, iArr[0], 11, -358537222);
        int HH11 = HH(HH7, HH10, HH9, HH8, iArr[3], 16, -722521979);
        int HH12 = HH(HH8, HH11, HH10, HH9, iArr[6], 23, 76029189);
        int HH13 = HH(HH9, HH12, HH11, HH10, iArr[9], 4, -640364487);
        int HH14 = HH(HH10, HH13, HH12, HH11, iArr[12], 11, -421815835);
        int HH15 = HH(HH11, HH14, HH13, HH12, iArr[15], 16, 530742520);
        int HH16 = HH(HH12, HH15, HH14, HH13, iArr[2], 23, -995338651);
        int II = II(HH13, HH16, HH15, HH14, iArr[0], 6, -198630844);
        int II2 = II(HH14, II, HH16, HH15, iArr[7], 10, 1126891415);
        int II3 = II(HH15, II2, II, HH16, iArr[14], 15, -1416354905);
        int II4 = II(HH16, II3, II2, II, iArr[5], 21, -57434055);
        int II5 = II(II, II4, II3, II2, iArr[12], 6, 1700485571);
        int II6 = II(II2, II5, II4, II3, iArr[3], 10, -1894986606);
        int II7 = II(II3, II6, II5, II4, iArr[10], 15, -1051523);
        int II8 = II(II4, II7, II6, II5, iArr[1], 21, -2054922799);
        int II9 = II(II5, II8, II7, II6, iArr[8], 6, 1873313359);
        int II10 = II(II6, II9, II8, II7, iArr[15], 10, -30611744);
        int II11 = II(II7, II10, II9, II8, iArr[6], 15, -1560198380);
        int II12 = II(II8, II11, II10, II9, iArr[13], 21, 1309151649);
        int II13 = II(II9, II12, II11, II10, iArr[4], 6, -145523070);
        int II14 = II(II10, II13, II12, II11, iArr[11], 10, -1120210379);
        int II15 = II(II11, II14, II13, II12, iArr[2], 15, 718787259);
        int II16 = II(II12, II15, II14, II13, iArr[9], 21, -343485551);
        int[] iArr2 = mD5State.state;
        iArr2[0] = iArr2[0] + II13;
        int[] iArr3 = mD5State.state;
        iArr3[1] = iArr3[1] + II16;
        int[] iArr4 = mD5State.state;
        iArr4[2] = iArr4[2] + II15;
        int[] iArr5 = mD5State.state;
        iArr5[3] = iArr5[3] + II14;
    }
}
