package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* access modifiers changed from: package-private */
public final class AI01320xDecoder extends AI013x0xDecoder {
    /* access modifiers changed from: protected */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public int checkWeight(int i) {
        return i < 10000 ? i : i - 10000;
    }

    AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public void addWeightCode(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }
}
