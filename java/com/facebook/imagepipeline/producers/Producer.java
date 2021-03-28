package com.facebook.imagepipeline.producers;

public interface Producer<T> {
    void produceResults(Consumer<T> consumer, ProducerContext producerContext);
}
