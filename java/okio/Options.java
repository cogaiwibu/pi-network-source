package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.UByte;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i3);
                int i4 = i3 + 1;
                int i5 = i4;
                while (i5 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i5);
                    if (!byteString2.startsWith(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                        arrayList.remove(i5);
                        arrayList2.remove(i5);
                    } else {
                        i5++;
                    }
                }
                i3 = i4;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int intCount = intCount(buffer);
            int[] iArr = new int[intCount];
            for (int i6 = 0; i6 < intCount; i6++) {
                iArr[i6] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        Buffer buffer2;
        int i6;
        int i7 = i2;
        if (i7 < i3) {
            for (int i8 = i7; i8 < i3; i8++) {
                if (list.get(i8).size() < i) {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            int i9 = -1;
            if (i == byteString.size()) {
                i9 = list2.get(i7).intValue();
                i7++;
                byteString = list.get(i7);
            }
            if (byteString.getByte(i) != byteString2.getByte(i)) {
                int i10 = 1;
                for (int i11 = i7 + 1; i11 < i3; i11++) {
                    if (list.get(i11 - 1).getByte(i) != list.get(i11).getByte(i)) {
                        i10++;
                    }
                }
                long intCount = j + ((long) intCount(buffer)) + 2 + ((long) (i10 * 2));
                buffer.writeInt(i10);
                buffer.writeInt(i9);
                for (int i12 = i7; i12 < i3; i12++) {
                    byte b = list.get(i12).getByte(i);
                    if (i12 == i7 || b != list.get(i12 - 1).getByte(i)) {
                        buffer.writeInt(b & UByte.MAX_VALUE);
                    }
                }
                Buffer buffer3 = new Buffer();
                int i13 = i7;
                while (i13 < i3) {
                    byte b2 = list.get(i13).getByte(i);
                    int i14 = i13 + 1;
                    int i15 = i14;
                    while (true) {
                        if (i15 >= i3) {
                            i5 = i3;
                            break;
                        } else if (b2 != list.get(i15).getByte(i)) {
                            i5 = i15;
                            break;
                        } else {
                            i15++;
                        }
                    }
                    if (i14 == i5 && i + 1 == list.get(i13).size()) {
                        buffer.writeInt(list2.get(i13).intValue());
                        i6 = i5;
                        buffer2 = buffer3;
                    } else {
                        buffer.writeInt((int) ((((long) intCount(buffer3)) + intCount) * -1));
                        i6 = i5;
                        buffer2 = buffer3;
                        buildTrieRecursive(intCount, buffer3, i + 1, list, i13, i5, list2);
                    }
                    buffer3 = buffer2;
                    i13 = i6;
                }
                buffer.write(buffer3, buffer3.size());
                return;
            }
            int i16 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            int i17 = i;
            while (i17 < min && byteString.getByte(i17) == byteString2.getByte(i17)) {
                i16++;
                i17++;
            }
            long intCount2 = 1 + j + ((long) intCount(buffer)) + 2 + ((long) i16);
            buffer.writeInt(-i16);
            buffer.writeInt(i9);
            int i18 = i;
            while (true) {
                i4 = i + i16;
                if (i18 >= i4) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i18) & UByte.MAX_VALUE);
                i18++;
            }
            if (i7 + 1 != i3) {
                Buffer buffer4 = new Buffer();
                buffer.writeInt((int) ((((long) intCount(buffer4)) + intCount2) * -1));
                buildTrieRecursive(intCount2, buffer4, i4, list, i7, i3, list2);
                buffer.write(buffer4, buffer4.size());
            } else if (i4 == list.get(i7).size()) {
                buffer.writeInt(list2.get(i7).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // java.util.List, java.util.AbstractList
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
