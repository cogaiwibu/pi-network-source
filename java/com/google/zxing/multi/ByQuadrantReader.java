package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;

public final class ByQuadrantReader implements Reader {
    private final Reader delegate;

    public ByQuadrantReader(Reader reader) {
        this.delegate = reader;
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x000d */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.zxing.BinaryBitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: com.google.zxing.BinaryBitmap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.google.zxing.Result] */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = r5.delegate.decode(r6.crop(r0, r1, r0, r1), r7);
        makeAbsolute(r2.getResultPoints(), r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        r2 = r0 / 2;
        r3 = r1 / 2;
        r6 = r5.delegate.decode(r6.crop(r2, r3, r0, r1), r7);
        makeAbsolute(r6.getResultPoints(), r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r3 = r5.delegate.decode(r6.crop(r0, 0, r0, r1), r7);
        makeAbsolute(r3.getResultPoints(), r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3 = r5.delegate.decode(r6.crop(0, r1, r0, r1), r7);
        makeAbsolute(r3.getResultPoints(), 0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        return r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0018 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    @Override // com.google.zxing.Reader
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decode(com.google.zxing.BinaryBitmap r6, java.util.Map<com.google.zxing.DecodeHintType, ?> r7) throws com.google.zxing.NotFoundException, com.google.zxing.ChecksumException, com.google.zxing.FormatException {
        /*
            r5 = this;
            int r0 = r6.getWidth()
            int r1 = r6.getHeight()
            int r0 = r0 / 2
            int r1 = r1 / 2
            r2 = 0
            com.google.zxing.Reader r3 = r5.delegate     // Catch:{ NotFoundException -> 0x0018 }
            com.google.zxing.BinaryBitmap r4 = r6.crop(r2, r2, r0, r1)     // Catch:{ NotFoundException -> 0x0018 }
            com.google.zxing.Result r6 = r3.decode(r4, r7)     // Catch:{ NotFoundException -> 0x0018 }
            return r6
        L_0x0018:
            com.google.zxing.Reader r3 = r5.delegate     // Catch:{ NotFoundException -> 0x002a }
            com.google.zxing.BinaryBitmap r4 = r6.crop(r0, r2, r0, r1)     // Catch:{ NotFoundException -> 0x002a }
            com.google.zxing.Result r3 = r3.decode(r4, r7)     // Catch:{ NotFoundException -> 0x002a }
            com.google.zxing.ResultPoint[] r4 = r3.getResultPoints()     // Catch:{ NotFoundException -> 0x002a }
            makeAbsolute(r4, r0, r2)     // Catch:{ NotFoundException -> 0x002a }
            return r3
        L_0x002a:
            com.google.zxing.Reader r3 = r5.delegate     // Catch:{ NotFoundException -> 0x003c }
            com.google.zxing.BinaryBitmap r4 = r6.crop(r2, r1, r0, r1)     // Catch:{ NotFoundException -> 0x003c }
            com.google.zxing.Result r3 = r3.decode(r4, r7)     // Catch:{ NotFoundException -> 0x003c }
            com.google.zxing.ResultPoint[] r4 = r3.getResultPoints()     // Catch:{ NotFoundException -> 0x003c }
            makeAbsolute(r4, r2, r1)     // Catch:{ NotFoundException -> 0x003c }
            return r3
        L_0x003c:
            com.google.zxing.Reader r2 = r5.delegate     // Catch:{ NotFoundException -> 0x004e }
            com.google.zxing.BinaryBitmap r3 = r6.crop(r0, r1, r0, r1)     // Catch:{ NotFoundException -> 0x004e }
            com.google.zxing.Result r2 = r2.decode(r3, r7)     // Catch:{ NotFoundException -> 0x004e }
            com.google.zxing.ResultPoint[] r3 = r2.getResultPoints()     // Catch:{ NotFoundException -> 0x004e }
            makeAbsolute(r3, r0, r1)     // Catch:{ NotFoundException -> 0x004e }
            return r2
        L_0x004e:
            int r2 = r0 / 2
            int r3 = r1 / 2
            com.google.zxing.BinaryBitmap r6 = r6.crop(r2, r3, r0, r1)
            com.google.zxing.Reader r0 = r5.delegate
            com.google.zxing.Result r6 = r0.decode(r6, r7)
            com.google.zxing.ResultPoint[] r7 = r6.getResultPoints()
            makeAbsolute(r7, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.multi.ByQuadrantReader.decode(com.google.zxing.BinaryBitmap, java.util.Map):com.google.zxing.Result");
    }

    @Override // com.google.zxing.Reader
    public void reset() {
        this.delegate.reset();
    }

    private static void makeAbsolute(ResultPoint[] resultPointArr, int i, int i2) {
        if (resultPointArr != null) {
            for (int i3 = 0; i3 < resultPointArr.length; i3++) {
                ResultPoint resultPoint = resultPointArr[i3];
                resultPointArr[i3] = new ResultPoint(resultPoint.getX() + ((float) i), resultPoint.getY() + ((float) i2));
            }
        }
    }
}
