package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;

public interface PooledByteBufferFactory {
    PooledByteBuffer newByteBuffer(int i);

    PooledByteBuffer newByteBuffer(InputStream inputStream) throws IOException;

    PooledByteBuffer newByteBuffer(InputStream inputStream, int i) throws IOException;

    PooledByteBuffer newByteBuffer(byte[] bArr);

    PooledByteBufferOutputStream newOutputStream();

    PooledByteBufferOutputStream newOutputStream(int i);
}
