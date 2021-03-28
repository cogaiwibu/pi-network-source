package com.facebook.reactnative.androidsdk;

import android.os.Bundle;
import android.util.SparseArray;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = FBGraphRequestModule.NAME)
public class FBGraphRequestModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBGraphRequest";
    private SparseArray<WritableMap> mResponses = new SparseArray<>();

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private class GraphRequestBatchCallback implements GraphRequestBatch.Callback {
        private int mBatchID;
        private Callback mCallback;

        public GraphRequestBatchCallback(int i, Callback callback) {
            this.mBatchID = i;
            this.mCallback = callback;
        }

        @Override // com.facebook.GraphRequestBatch.Callback
        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString(IronSourceConstants.EVENTS_RESULT, "batch finished executing or timed out");
            this.mCallback.invoke(null, createMap, FBGraphRequestModule.this.mResponses.get(this.mBatchID));
            FBGraphRequestModule.this.mResponses.remove(this.mBatchID);
        }
    }

    private class GraphRequestCallback implements GraphRequest.Callback {
        private int mBatchID;
        private String mIndex;

        public GraphRequestCallback(int i, int i2) {
            this.mIndex = String.valueOf(i);
            this.mBatchID = i2;
        }

        @Override // com.facebook.GraphRequest.Callback
        public void onCompleted(GraphResponse graphResponse) {
            WritableArray createArray = Arguments.createArray();
            createArray.pushMap(FBGraphRequestModule.this.buildFacebookRequestError(graphResponse.getError()));
            createArray.pushMap(FBGraphRequestModule.this.buildGraphResponse(graphResponse));
            ((WritableMap) FBGraphRequestModule.this.mResponses.get(this.mBatchID)).putArray(this.mIndex, createArray);
        }
    }

    public FBGraphRequestModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void start(ReadableArray readableArray, int i, Callback callback) {
        int i2;
        int i3;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        synchronized (this) {
            i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (this.mResponses.get(i3) == null) {
                    this.mResponses.put(i3, Arguments.createMap());
                } else {
                    i3 = i4;
                }
            }
        }
        for (i2 = 0; i2 < readableArray.size(); i2++) {
            GraphRequest buildRequest = buildRequest(readableArray.getMap(i2));
            buildRequest.setCallback(new GraphRequestCallback(i2, i3));
            graphRequestBatch.add(buildRequest);
        }
        graphRequestBatch.setTimeout(i);
        graphRequestBatch.addCallback(new GraphRequestBatchCallback(i3, callback));
        graphRequestBatch.executeAsync();
    }

    private GraphRequest buildRequest(ReadableMap readableMap) {
        GraphRequest graphRequest = new GraphRequest();
        graphRequest.setGraphPath(readableMap.getString("graphPath"));
        setConfig(graphRequest, readableMap.getMap("config"));
        return graphRequest;
    }

    private void setConfig(GraphRequest graphRequest, ReadableMap readableMap) {
        if (readableMap == null) {
            graphRequest.setAccessToken(AccessToken.getCurrentAccessToken());
            return;
        }
        if (readableMap.hasKey("parameters")) {
            graphRequest.setParameters(buildParameters(readableMap.getMap("parameters")));
        }
        if (readableMap.hasKey("httpMethod")) {
            graphRequest.setHttpMethod(HttpMethod.valueOf(readableMap.getString("httpMethod")));
        }
        if (readableMap.hasKey(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
            graphRequest.setVersion(readableMap.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION));
        }
        if (readableMap.hasKey("accessToken")) {
            graphRequest.setAccessToken(new AccessToken(readableMap.getString("accessToken"), AccessToken.getCurrentAccessToken().getApplicationId(), AccessToken.getCurrentAccessToken().getUserId(), null, null, null, null, null, null, null));
        } else {
            graphRequest.setAccessToken(AccessToken.getCurrentAccessToken());
        }
    }

    private Bundle buildParameters(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            if (map.hasKey("string")) {
                bundle.putString(nextKey, map.getString("string"));
            }
        }
        return bundle;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private WritableMap buildFacebookRequestError(FacebookRequestError facebookRequestError) {
        if (facebookRequestError == null) {
            return null;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("requestStatusCode", facebookRequestError.getRequestStatusCode());
        createMap.putInt(IronSourceConstants.EVENTS_ERROR_CODE, facebookRequestError.getErrorCode());
        createMap.putInt("subErrorCode", facebookRequestError.getSubErrorCode());
        if (facebookRequestError.getErrorType() != null) {
            createMap.putString("errorType", facebookRequestError.getErrorType());
        }
        if (facebookRequestError.getErrorMessage() != null) {
            createMap.putString("errorMessage", facebookRequestError.getErrorMessage());
        }
        if (facebookRequestError.getErrorUserTitle() != null) {
            createMap.putString("errorUserTitle", facebookRequestError.getErrorUserTitle());
        }
        if (facebookRequestError.getErrorUserMessage() != null) {
            createMap.putString("errorUserMessage", facebookRequestError.getErrorUserMessage());
        }
        if (facebookRequestError.getRequestResultBody() != null) {
            createMap.putString("requestResultBody", facebookRequestError.getRequestResultBody().toString());
        }
        if (facebookRequestError.getRequestResult() != null) {
            createMap.putString("requestResult", facebookRequestError.getRequestResult().toString());
        }
        if (facebookRequestError.getBatchRequestResult() != null) {
            createMap.putString("batchRequestResult", facebookRequestError.getBatchRequestResult().toString());
        }
        if (facebookRequestError.getException() != null) {
            createMap.putString("exception", facebookRequestError.getException().toString());
        }
        return createMap;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private WritableMap buildGraphResponse(GraphResponse graphResponse) {
        if (graphResponse.getJSONObject() != null) {
            return convertJSONObject(graphResponse.getJSONObject());
        }
        return Arguments.createMap();
    }

    private WritableArray convertJSONArray(JSONArray jSONArray) {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONObject) {
                    createArray.pushMap(convertJSONObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    createArray.pushArray(convertJSONArray((JSONArray) obj));
                } else if (obj instanceof String) {
                    createArray.pushString((String) obj);
                } else if (obj instanceof Integer) {
                    createArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    createArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    createArray.pushDouble(((Double) obj).doubleValue());
                }
            } catch (JSONException unused) {
            }
        }
        return createArray;
    }

    private WritableMap convertJSONObject(JSONObject jSONObject) {
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    createMap.putMap(next, convertJSONObject((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    createMap.putArray(next, convertJSONArray((JSONArray) obj));
                } else if (obj instanceof String) {
                    createMap.putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    createMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Boolean) {
                    createMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Double) {
                    createMap.putDouble(next, ((Double) obj).doubleValue());
                }
            } catch (JSONException unused) {
            }
        }
        return createMap;
    }
}
