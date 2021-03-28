package com.ironsource.sdk.precache;

import com.ironsource.sdk.data.SSAFile;

public interface OnPreCacheCompletion {
    void onFileDownloadFail(SSAFile sSAFile);

    void onFileDownloadSuccess(SSAFile sSAFile);
}
