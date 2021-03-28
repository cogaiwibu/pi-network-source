package com.facebook.imagepipeline.request;

public interface RepeatedPostprocessor extends Postprocessor {
    void setCallback(RepeatedPostprocessorRunner repeatedPostprocessorRunner);
}
