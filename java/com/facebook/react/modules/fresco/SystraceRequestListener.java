package com.facebook.react.modules.fresco;

import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener extends BaseRequestListener {
    int mCurrentID = 0;
    Map<String, Pair<Integer, String>> mProducerID = new HashMap();
    Map<String, Pair<Integer, String>> mRequestsID = new HashMap();

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String str) {
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(String str, String str2) {
        if (Systrace.isTracing(0)) {
            Pair<Integer, String> create = Pair.create(Integer.valueOf(this.mCurrentID), "FRESCO_PRODUCER_" + str2.replace(':', '_'));
            Systrace.beginAsyncSection(0, (String) create.second, this.mCurrentID);
            this.mProducerID.put(str, create);
            this.mCurrentID = this.mCurrentID + 1;
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        if (Systrace.isTracing(0) && this.mProducerID.containsKey(str)) {
            Pair<Integer, String> pair = this.mProducerID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mProducerID.remove(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        if (Systrace.isTracing(0) && this.mProducerID.containsKey(str)) {
            Pair<Integer, String> pair = this.mProducerID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mProducerID.remove(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
        if (Systrace.isTracing(0) && this.mProducerID.containsKey(str)) {
            Pair<Integer, String> pair = this.mProducerID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mProducerID.remove(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(String str, String str2, String str3) {
        if (Systrace.isTracing(0)) {
            Systrace.traceInstant(0, "FRESCO_PRODUCER_EVENT_" + str.replace(':', '_') + "_" + str2.replace(':', '_') + "_" + str3.replace(':', '_'), Systrace.EventScope.THREAD);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (Systrace.isTracing(0)) {
            Pair<Integer, String> create = Pair.create(Integer.valueOf(this.mCurrentID), "FRESCO_REQUEST_" + imageRequest.getSourceUri().toString().replace(':', '_'));
            Systrace.beginAsyncSection(0, (String) create.second, this.mCurrentID);
            this.mRequestsID.put(str, create);
            this.mCurrentID = this.mCurrentID + 1;
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        if (Systrace.isTracing(0) && this.mRequestsID.containsKey(str)) {
            Pair<Integer, String> pair = this.mRequestsID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mRequestsID.remove(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        if (Systrace.isTracing(0) && this.mRequestsID.containsKey(str)) {
            Pair<Integer, String> pair = this.mRequestsID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mRequestsID.remove(str);
        }
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(String str) {
        if (Systrace.isTracing(0) && this.mRequestsID.containsKey(str)) {
            Pair<Integer, String> pair = this.mRequestsID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mRequestsID.remove(str);
        }
    }
}
