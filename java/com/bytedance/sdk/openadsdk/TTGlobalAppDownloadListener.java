package com.bytedance.sdk.openadsdk;

public interface TTGlobalAppDownloadListener {
    void onDownloadActive(TTAppDownloadInfo tTAppDownloadInfo);

    void onDownloadFailed(TTAppDownloadInfo tTAppDownloadInfo);

    void onDownloadFinished(TTAppDownloadInfo tTAppDownloadInfo);

    void onDownloadPaused(TTAppDownloadInfo tTAppDownloadInfo);

    void onInstalled(String str, String str2, long j, int i);
}
