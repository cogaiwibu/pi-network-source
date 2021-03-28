package com.facebook.systrace;

public final class SystraceMessage {
    private static final Builder NOOP_BUILDER = new NoopBuilder();

    public static abstract class Builder {
        public abstract Builder arg(String str, double d);

        public abstract Builder arg(String str, int i);

        public abstract Builder arg(String str, long j);

        public abstract Builder arg(String str, Object obj);

        public abstract void flush();
    }

    private interface Flusher {
        void flush(StringBuilder sb);
    }

    public static Builder beginSection(long j, String str) {
        return NOOP_BUILDER;
    }

    public static Builder endSection(long j) {
        return NOOP_BUILDER;
    }

    private static class NoopBuilder extends Builder {
        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String str, double d) {
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String str, int i) {
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String str, long j) {
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public Builder arg(String str, Object obj) {
            return this;
        }

        @Override // com.facebook.systrace.SystraceMessage.Builder
        public void flush() {
        }

        private NoopBuilder() {
        }
    }
}
