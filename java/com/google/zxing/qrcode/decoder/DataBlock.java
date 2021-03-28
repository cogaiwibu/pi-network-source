package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

/* access modifiers changed from: package-private */
public final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == version.getTotalCodewords()) {
            Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
            Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
            int i = 0;
            for (Version.ECB ecb : eCBlocks) {
                i += ecb.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i];
            int i2 = 0;
            for (Version.ECB ecb2 : eCBlocks) {
                int i3 = 0;
                while (i3 < ecb2.getCount()) {
                    int dataCodewords = ecb2.getDataCodewords();
                    dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                    i3++;
                    i2++;
                }
            }
            int length = dataBlockArr[0].codewords.length;
            int i4 = i - 1;
            while (i4 >= 0 && dataBlockArr[i4].codewords.length != length) {
                i4--;
            }
            int i5 = i4 + 1;
            int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
            int i6 = 0;
            for (int i7 = 0; i7 < eCCodewordsPerBlock; i7++) {
                int i8 = 0;
                while (i8 < i2) {
                    dataBlockArr[i8].codewords[i7] = bArr[i6];
                    i8++;
                    i6++;
                }
            }
            int i9 = i5;
            while (i9 < i2) {
                dataBlockArr[i9].codewords[eCCodewordsPerBlock] = bArr[i6];
                i9++;
                i6++;
            }
            int length2 = dataBlockArr[0].codewords.length;
            while (eCCodewordsPerBlock < length2) {
                int i10 = 0;
                while (i10 < i2) {
                    dataBlockArr[i10].codewords[i10 < i5 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i6];
                    i10++;
                    i6++;
                }
                eCCodewordsPerBlock++;
            }
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }

    /* access modifiers changed from: package-private */
    public byte[] getCodewords() {
        return this.codewords;
    }
}
