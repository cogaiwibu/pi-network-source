package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.IOException;
import java.util.Map;

public interface IHttpStack {
    HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, VAdError;
}
