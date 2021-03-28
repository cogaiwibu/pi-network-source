package kotlin.io;

import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0015"}, d2 = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "nextByte", "", "getNextByte", "()I", "setNextByte", "(I)V", "nextPrepared", "getNextPrepared", "setNextPrepared", "hasNext", "", "prepareNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* compiled from: IOStreams.kt */
public final class ByteStreamsKt$iterator$1 extends ByteIterator {
    final /* synthetic */ BufferedInputStream $this_iterator;
    private boolean finished;
    private int nextByte = -1;
    private boolean nextPrepared;

    ByteStreamsKt$iterator$1(BufferedInputStream bufferedInputStream) {
        this.$this_iterator = bufferedInputStream;
    }

    public final int getNextByte() {
        return this.nextByte;
    }

    public final void setNextByte(int i) {
        this.nextByte = i;
    }

    public final boolean getNextPrepared() {
        return this.nextPrepared;
    }

    public final void setNextPrepared(boolean z) {
        this.nextPrepared = z;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final void setFinished(boolean z) {
        this.finished = z;
    }

    private final void prepareNext() {
        if (!this.nextPrepared && !this.finished) {
            int read = this.$this_iterator.read();
            this.nextByte = read;
            boolean z = true;
            this.nextPrepared = true;
            if (read != -1) {
                z = false;
            }
            this.finished = z;
        }
    }

    public boolean hasNext() {
        prepareNext();
        return !this.finished;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        prepareNext();
        if (!this.finished) {
            byte b = (byte) this.nextByte;
            this.nextPrepared = false;
            return b;
        }
        throw new NoSuchElementException("Input stream is over.");
    }
}
