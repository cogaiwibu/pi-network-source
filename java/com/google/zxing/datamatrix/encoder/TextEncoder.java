package com.google.zxing.datamatrix.encoder;

/* access modifiers changed from: package-private */
public final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder, com.google.zxing.datamatrix.encoder.C40Encoder
    public int getEncodingMode() {
        return 2;
    }

    TextEncoder() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int encodeChar(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'a' && c <= 'z') {
            sb.append((char) ((c - 'a') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c == '`') {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c - 'A') + 1));
            return 2;
        } else if (c < '{' || c > 127) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c - 128), sb) + 2;
        } else {
            sb.append((char) 2);
            sb.append((char) ((c - '{') + 27));
            return 2;
        }
    }
}
