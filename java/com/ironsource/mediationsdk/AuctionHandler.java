package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ironsource.eventsTracker.NativeEventsConstants;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.AuctionSettings;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceGZIP;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import com.ironsource.sdk.constants.Events;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class AuctionHandler {
    private static final int SERVER_REQUEST_TIMEOUT = 15000;
    private final String AUCTION_INTERNAL_ERROR_LOSS_CODE = "1";
    private final String AUCTION_LOST_TO_NON_BIDDER_LOSS_CODE = "103";
    private final String AUCTION_NOT_HIGHEST_RTB_BIDDER_LOSS_CODE = "102";
    private final String GENERIC_NOTIFICATION = "GenericNotifications";
    private final String GENERIC_NOTIFICATIONS_DEFAULT_LOSS_CODE = "102";
    private String mAdUnit;
    private AuctionEventListener mAuctionListener;
    private ISBannerSize mBannerSize;
    private String mSessionId;
    private AuctionSettings mSettings;

    public AuctionHandler(String str, AuctionSettings auctionSettings, AuctionEventListener auctionEventListener) {
        this.mAdUnit = str;
        this.mSettings = auctionSettings;
        this.mAuctionListener = auctionEventListener;
        this.mSessionId = IronSourceUtils.getSessionId();
    }

    public void executeAuction(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i, ISBannerSize iSBannerSize) {
        this.mBannerSize = iSBannerSize;
        executeAuction(context, map, list, auctionHistory, i);
    }

    public void executeAuction(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i) {
        try {
            boolean z = IronSourceUtils.getSerr() == 1;
            new AuctionHttpRequestTask(this.mAuctionListener).execute(this.mSettings.getUrl(), generateRequest(context, map, list, auctionHistory, i, z), Boolean.valueOf(z), Integer.valueOf(this.mSettings.getNumOfMaxTrials()), Long.valueOf(this.mSettings.getTrialsInterval()), Boolean.valueOf(this.mSettings.isCompressAuctionRequest()), Boolean.valueOf(this.mSettings.isCompressAuctionResponse()));
        } catch (Exception e) {
            this.mAuctionListener.onAuctionFailed(1000, e.getMessage(), 0, "other", 0);
        }
    }

    public void reportImpression(AuctionResponseItem auctionResponseItem, int i, AuctionResponseItem auctionResponseItem2, String str) {
        for (String str2 : auctionResponseItem.getBurls()) {
            AuctionDataUtils.getInstance().sendResponse("reportImpression", auctionResponseItem.getInstanceName(), AuctionDataUtils.getInstance().enrichNotificationURL(str2, i, auctionResponseItem, "", "", str));
        }
        if (auctionResponseItem2 != null) {
            for (String str3 : auctionResponseItem2.getBurls()) {
                AuctionDataUtils.getInstance().sendResponse("reportImpression", "GenericNotifications", AuctionDataUtils.getInstance().enrichNotificationURL(str3, i, auctionResponseItem, "", "102", str));
            }
        }
    }

    public void reportLoadSuccess(AuctionResponseItem auctionResponseItem, int i, AuctionResponseItem auctionResponseItem2) {
        for (String str : auctionResponseItem.getNurls()) {
            AuctionDataUtils.getInstance().sendResponse("reportLoadSuccess", auctionResponseItem.getInstanceName(), AuctionDataUtils.getInstance().enrichNotificationURL(str, i, auctionResponseItem, "", "", ""));
        }
        if (auctionResponseItem2 != null) {
            for (String str2 : auctionResponseItem2.getNurls()) {
                AuctionDataUtils.getInstance().sendResponse("reportLoadSuccess", "GenericNotifications", AuctionDataUtils.getInstance().enrichNotificationURL(str2, i, auctionResponseItem, "", "102", ""));
            }
        }
    }

    public void reportAuctionLose(CopyOnWriteArrayList<ProgSmash> copyOnWriteArrayList, ConcurrentHashMap<String, AuctionResponseItem> concurrentHashMap, int i, AuctionResponseItem auctionResponseItem, AuctionResponseItem auctionResponseItem2) {
        Iterator<ProgSmash> it = copyOnWriteArrayList.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            ProgSmash next = it.next();
            String instanceName = next.getInstanceName();
            if (instanceName.equals(auctionResponseItem2.getInstanceName())) {
                z = true;
                z2 = next.isBidder();
            } else {
                AuctionResponseItem auctionResponseItem3 = concurrentHashMap.get(instanceName);
                String price = auctionResponseItem3.getPrice();
                String str = z ? z2 ? "102" : "103" : "1";
                for (String str2 : auctionResponseItem3.getLurls()) {
                    AuctionDataUtils.getInstance().sendResponse("reportAuctionLose", auctionResponseItem3.getInstanceName(), AuctionDataUtils.getInstance().enrichNotificationURL(str2, i, auctionResponseItem2, price, str, ""));
                }
            }
        }
        if (auctionResponseItem != null) {
            for (String str3 : auctionResponseItem.getLurls()) {
                AuctionDataUtils.getInstance().sendResponse("reportAuctionLose", "GenericNotifications", AuctionDataUtils.getInstance().enrichNotificationURL(str3, i, auctionResponseItem2, "", "102", ""));
            }
        }
    }

    private JSONObject generateRequest(Context context, Map<String, Object> map, List<String> list, AuctionHistory auctionHistory, int i, boolean z) throws JSONException {
        new JSONObject();
        JSONObject enrichToken = AuctionDataUtils.getInstance().enrichToken(context, map, list, auctionHistory, i, this.mSessionId, this.mSettings, this.mBannerSize);
        enrichToken.put("adUnit", this.mAdUnit);
        enrichToken.put("doNotEncryptResponse", z ? "false" : "true");
        return enrichToken;
    }

    /* access modifiers changed from: package-private */
    public static class AuctionHttpRequestTask extends AsyncTask<Object, Void, Boolean> {
        private String mAuctionFallback = "other";
        private String mAuctionId;
        private WeakReference<AuctionEventListener> mAuctionListener;
        private int mCurrentAuctionTrial;
        private int mErrorCode;
        private String mErrorMessage;
        private AuctionResponseItem mGenericNotifications;
        private JSONObject mGenericParams;
        private JSONObject mRequestData;
        private long mRequestStartTime;
        private List<AuctionResponseItem> mWaterfall;

        AuctionHttpRequestTask(AuctionEventListener auctionEventListener) {
            this.mAuctionListener = new WeakReference<>(auctionEventListener);
        }

        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(Object... objArr) {
            this.mRequestStartTime = new Date().getTime();
            try {
                URL url = new URL((String) objArr[0]);
                int i = 1;
                this.mRequestData = (JSONObject) objArr[1];
                boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
                int intValue = ((Integer) objArr[3]).intValue();
                long longValue = ((Long) objArr[4]).longValue();
                boolean booleanValue2 = ((Boolean) objArr[5]).booleanValue();
                boolean booleanValue3 = ((Boolean) objArr[6]).booleanValue();
                this.mCurrentAuctionTrial = 0;
                HttpURLConnection httpURLConnection = null;
                while (this.mCurrentAuctionTrial < intValue) {
                    try {
                        long time = new Date().getTime();
                        String str = "Auction Handler: auction trial " + (this.mCurrentAuctionTrial + i) + " out of " + intValue + " max trials";
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                        IronSourceUtils.sendAutomationLog(str);
                        httpURLConnection = prepareAuctionRequest(url, longValue);
                        sendAuctionRequest(httpURLConnection, this.mRequestData, booleanValue2);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 200) {
                            this.mErrorCode = 1001;
                            this.mErrorMessage = "Auction status not 200 error, error code response from server - " + responseCode;
                            IronLog.INTERNAL.error(this.mErrorMessage);
                            httpURLConnection.disconnect();
                            if (this.mCurrentAuctionTrial < intValue - 1) {
                                waitUntilNextTrial(longValue, time);
                            }
                            i = 1;
                            this.mCurrentAuctionTrial++;
                        } else {
                            try {
                                handleResponse(readResponse(httpURLConnection), booleanValue, booleanValue3);
                                httpURLConnection.disconnect();
                                return true;
                            } catch (JSONException e) {
                                if (e.getMessage() != null && e.getMessage().equalsIgnoreCase("decryption error")) {
                                    this.mErrorCode = 1003;
                                    this.mErrorMessage = "Auction decryption error";
                                }
                                if (e.getMessage() == null || !e.getMessage().equalsIgnoreCase("decompression error")) {
                                    this.mErrorCode = 1002;
                                    this.mErrorMessage = "Auction parsing error";
                                } else {
                                    this.mErrorCode = 1008;
                                    this.mErrorMessage = "Auction decompression error";
                                }
                                this.mAuctionFallback = "parsing";
                                httpURLConnection.disconnect();
                                return false;
                            }
                        }
                    } catch (SocketTimeoutException unused) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.mErrorCode = 1006;
                        this.mErrorMessage = "Connection timed out";
                    } catch (Exception e2) {
                        IronLog.INTERNAL.error("getting exception " + e2);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.mErrorCode = 1000;
                        this.mErrorMessage = e2.getMessage();
                        this.mAuctionFallback = "other";
                        return false;
                    }
                }
                this.mCurrentAuctionTrial = intValue - i;
                this.mAuctionFallback = "trials_fail";
                return false;
            } catch (Exception e3) {
                this.mErrorCode = 1007;
                this.mErrorMessage = e3.getMessage();
                this.mCurrentAuctionTrial = 0;
                this.mAuctionFallback = "other";
                return false;
            }
        }

        private void waitUntilNextTrial(long j, long j2) {
            long time = j - (new Date().getTime() - j2);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        private void sendAuctionRequest(HttpURLConnection httpURLConnection, JSONObject jSONObject, boolean z) throws Exception {
            String str;
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String jSONObject2 = jSONObject.toString();
            if (z) {
                IronLog.INTERNAL.verbose("compressing auction request");
                str = String.format("{\"request\" : \"%1$s\"}", IronSourceAES.encodeFromBytes(IronSourceUtils.KEY, IronSourceGZIP.compress(jSONObject2)));
            } else {
                str = String.format("{\"request\" : \"%1$s\"}", IronSourceAES.encode(IronSourceUtils.KEY, jSONObject2));
            }
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
        }

        private HttpURLConnection prepareAuctionRequest(URL url, long j) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(NativeEventsConstants.HTTP_METHOD_POST);
            httpURLConnection.setRequestProperty(Events.CONTENT_TYPE, "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        private void handleResponse(String str, boolean z, boolean z2) throws JSONException {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z) {
                    String string = jSONObject.getString(ServerResponseWrapper.RESPONSE_FIELD);
                    if (z2) {
                        jSONObject = getDecompressedResponse(string);
                    } else {
                        jSONObject = getDecodedResponse(string);
                    }
                }
                AuctionDataUtils.AuctionData auctionDataFromResponse = AuctionDataUtils.getInstance().getAuctionDataFromResponse(jSONObject);
                this.mAuctionId = auctionDataFromResponse.getAuctionId();
                this.mWaterfall = auctionDataFromResponse.getWaterfall();
                this.mGenericNotifications = auctionDataFromResponse.getGenericNotifications();
                this.mGenericParams = auctionDataFromResponse.getGenericParams();
                this.mErrorCode = auctionDataFromResponse.getErrorCode();
                this.mErrorMessage = auctionDataFromResponse.getErrorMessage();
                return;
            }
            throw new JSONException("empty response");
        }

        private JSONObject getDecodedResponse(String str) throws JSONException {
            String decode = IronSourceAES.decode(IronSourceUtils.KEY, str);
            if (!TextUtils.isEmpty(decode)) {
                return new JSONObject(decode);
            }
            throw new JSONException("decryption error");
        }

        private JSONObject getDecompressedResponse(String str) throws JSONException {
            byte[] decodeToBytes = IronSourceAES.decodeToBytes(IronSourceUtils.KEY, str);
            if (decodeToBytes != null) {
                IronLog.INTERNAL.verbose("decompressing auction response");
                String decompress = IronSourceGZIP.decompress(decodeToBytes);
                if (decompress != null) {
                    return new JSONObject(decompress);
                }
                throw new JSONException("decompression error");
            }
            throw new JSONException("decryption error");
        }

        private String readResponse(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            AuctionEventListener auctionEventListener = this.mAuctionListener.get();
            if (auctionEventListener != null) {
                long time = new Date().getTime() - this.mRequestStartTime;
                if (bool.booleanValue()) {
                    auctionEventListener.onAuctionSuccess(this.mWaterfall, this.mAuctionId, this.mGenericNotifications, this.mGenericParams, this.mCurrentAuctionTrial + 1, time);
                } else {
                    auctionEventListener.onAuctionFailed(this.mErrorCode, this.mErrorMessage, this.mCurrentAuctionTrial + 1, this.mAuctionFallback, time);
                }
            }
        }
    }
}
