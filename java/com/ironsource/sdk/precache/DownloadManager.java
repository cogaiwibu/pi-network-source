package com.ironsource.sdk.precache;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.sdk.data.SSAFile;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class DownloadManager {
    public static final String FILE_ALREADY_EXIST = "file_already_exist";
    protected static final String FILE_NOT_FOUND_EXCEPTION = "file not found exception";
    static final int MESSAGE_EMPTY_URL = 1007;
    static final int MESSAGE_FILE_DOWNLOAD_FAIL = 1017;
    static final int MESSAGE_FILE_DOWNLOAD_SUCCESS = 1016;
    static final int MESSAGE_FILE_NOT_FOUND_EXCEPTION = 1018;
    static final int MESSAGE_GENERAL_HTTP_ERROR_CODE = 1011;
    static final int MESSAGE_HTTP_EMPTY_RESPONSE = 1006;
    static final int MESSAGE_HTTP_NOT_FOUND = 1005;
    static final int MESSAGE_IO_EXCEPTION = 1009;
    static final int MESSAGE_MALFORMED_URL_EXCEPTION = 1004;
    static final int MESSAGE_NUM_OF_BANNERS_TO_CACHE = 1013;
    static final int MESSAGE_OUT_OF_MEMORY_EXCEPTION = 1019;
    static final int MESSAGE_SOCKET_TIMEOUT_EXCEPTION = 1008;
    static final int MESSAGE_TMP_FILE_RENAME_FAILED = 1020;
    static final int MESSAGE_URI_SYNTAX_EXCEPTION = 1010;
    public static final String NO_DISK_SPACE = "no_disk_space";
    public static final String NO_NETWORK_CONNECTION = "no_network_connection";
    public static final int OPERATION_TIMEOUT = 5000;
    protected static final String OUT_OF_MEMORY_EXCEPTION = "out of memory exception";
    public static final String STORAGE_UNAVAILABLE = "sotrage_unavailable";
    private static final String TAG = "DownloadManager";
    private static final String TEMP_DIR_FOR_FILES = "temp";
    private static final String TEMP_PREFIX_FOR_FILES = "tmp_";
    private static final String UNABLE_TO_CREATE_FOLDER = "unable_to_create_folder";
    private static DownloadManager mDownloadManager;
    private final String mCacheRootDirectory;
    private DownloadHandler mDownloadHandler = getDownloadHandler();
    private Thread mMobileControllerThread;

    private DownloadManager(String str) {
        this.mCacheRootDirectory = str;
        IronSourceStorageUtils.deleteFolder(this.mCacheRootDirectory, TEMP_DIR_FOR_FILES);
        IronSourceStorageUtils.makeDir(this.mCacheRootDirectory, TEMP_DIR_FOR_FILES);
    }

    public static synchronized DownloadManager getInstance(String str) {
        DownloadManager downloadManager;
        synchronized (DownloadManager.class) {
            if (mDownloadManager == null) {
                mDownloadManager = new DownloadManager(str);
            }
            downloadManager = mDownloadManager;
        }
        return downloadManager;
    }

    static byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public DownloadHandler getDownloadHandler() {
        return new DownloadHandler();
    }

    public void setOnPreCacheCompletion(OnPreCacheCompletion onPreCacheCompletion) {
        this.mDownloadHandler.setOnPreCacheCompletion(onPreCacheCompletion);
    }

    public synchronized void release() {
        mDownloadManager = null;
        if (this.mDownloadHandler != null) {
            this.mDownloadHandler.release();
            this.mDownloadHandler = null;
        }
    }

    public void downloadFile(SSAFile sSAFile) {
        new Thread(new SingleFileWorkerThread(sSAFile, this.mDownloadHandler, this.mCacheRootDirectory, getTempFilesDirectory())).start();
    }

    public void downloadMobileControllerFile(SSAFile sSAFile) {
        Thread thread = new Thread(new SingleFileWorkerThread(sSAFile, this.mDownloadHandler, this.mCacheRootDirectory, getTempFilesDirectory()));
        this.mMobileControllerThread = thread;
        thread.start();
    }

    public boolean isMobileControllerThreadLive() {
        Thread thread = this.mMobileControllerThread;
        return thread != null && thread.isAlive();
    }

    /* access modifiers changed from: package-private */
    public String getTempFilesDirectory() {
        return this.mCacheRootDirectory + File.separator + TEMP_DIR_FOR_FILES;
    }

    /* access modifiers changed from: package-private */
    public static class SingleFileWorkerThread implements Runnable {
        private final long DEFAULT_CONNECTION_RETRIES = 3;
        private String mCacheRootDirectory;
        private long mConnectionRetries;
        Handler mDownloadHandler;
        private String mFile;
        private String mFileName;
        private String mPath;
        private final String mTempFilesDirectory;

        SingleFileWorkerThread(SSAFile sSAFile, Handler handler, String str, String str2) {
            this.mFile = sSAFile.getFile();
            this.mPath = sSAFile.getPath();
            this.mFileName = guessFileName(this.mFile);
            this.mConnectionRetries = 3;
            this.mCacheRootDirectory = str;
            this.mDownloadHandler = handler;
            this.mTempFilesDirectory = str2;
        }

        /* access modifiers changed from: package-private */
        public String guessFileName(String str) {
            return SDKUtils.getFileName(this.mFile);
        }

        /* access modifiers changed from: package-private */
        public FileWorkerThread getFileWorkerThread(String str, String str2, String str3, long j, String str4) {
            return new FileWorkerThread(str, str2, str3, j, str4);
        }

        /* access modifiers changed from: package-private */
        public Message getMessage() {
            return new Message();
        }

        /* access modifiers changed from: package-private */
        public String makeDir(String str, String str2) {
            return IronSourceStorageUtils.makeDir(str, str2);
        }

        public void run() {
            SSAFile sSAFile = new SSAFile(this.mFileName, this.mPath);
            Message message = getMessage();
            message.obj = sSAFile;
            String makeDir = makeDir(this.mCacheRootDirectory, this.mPath);
            if (makeDir == null) {
                message.what = 1017;
                sSAFile.setErrMsg(DownloadManager.UNABLE_TO_CREATE_FOLDER);
                this.mDownloadHandler.sendMessage(message);
                return;
            }
            int i = getFileWorkerThread(this.mFile, makeDir, sSAFile.getFile(), this.mConnectionRetries, this.mTempFilesDirectory).call().responseCode;
            message.what = 1016;
            if (i != 200) {
                message.what = 1017;
                sSAFile.setErrMsg(Utils.convertErrorCodeToMessage(i));
            }
            this.mDownloadHandler.sendMessage(message);
        }
    }

    /* access modifiers changed from: package-private */
    public static class FileWorkerThread implements Callable<Result> {
        private long mConnectionRetries;
        private String mDirectory;
        private String mFileName;
        private String mFileUrl;
        private String mTmpFilesDirectory;

        public FileWorkerThread(String str, String str2, String str3, long j, String str4) {
            this.mFileUrl = str;
            this.mDirectory = str2;
            this.mFileName = str3;
            this.mConnectionRetries = j;
            this.mTmpFilesDirectory = str4;
        }

        /* access modifiers changed from: package-private */
        public int saveFile(byte[] bArr, String str) throws Exception {
            return IronSourceStorageUtils.saveFile(bArr, str);
        }

        /* access modifiers changed from: package-private */
        public boolean renameFile(String str, String str2) throws Exception {
            return IronSourceStorageUtils.renameFile(str, str2);
        }

        /* access modifiers changed from: package-private */
        public byte[] getBytes(InputStream inputStream) throws IOException {
            return DownloadManager.getBytes(inputStream);
        }

        @Override // java.util.concurrent.Callable
        public Result call() {
            if (this.mConnectionRetries == 0) {
                this.mConnectionRetries = 1;
            }
            int i = 0;
            Result result = null;
            while (((long) i) < this.mConnectionRetries && ((r3 = (result = downloadContent(this.mFileUrl, i)).responseCode) == 1008 || r3 == 1009)) {
                i++;
            }
            if (!(result == null || result.body == null)) {
                String str = this.mDirectory + File.separator + this.mFileName;
                String str2 = this.mTmpFilesDirectory + File.separator + DownloadManager.TEMP_PREFIX_FOR_FILES + this.mFileName;
                try {
                    if (saveFile(result.body, str2) == 0) {
                        result.responseCode = 1006;
                    } else if (!renameFile(str2, str)) {
                        result.responseCode = 1020;
                    }
                } catch (FileNotFoundException unused) {
                    result.responseCode = 1018;
                } catch (Exception e) {
                    if (!TextUtils.isEmpty(e.getMessage())) {
                        Logger.i(DownloadManager.TAG, e.getMessage());
                    }
                    result.responseCode = 1009;
                } catch (Error e2) {
                    if (!TextUtils.isEmpty(e2.getMessage())) {
                        Logger.i(DownloadManager.TAG, e2.getMessage());
                    }
                    result.responseCode = 1019;
                }
            }
            return result;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0126, code lost:
            if (r4 != null) goto L_0x0138;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x0136, code lost:
            if (r4 != null) goto L_0x0138;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0138, code lost:
            r4.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x013b, code lost:
            r1.url = r8;
            r1.responseCode = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e1, code lost:
            if (r4 != null) goto L_0x0138;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0106, code lost:
            if (r4 != null) goto L_0x0138;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x0116, code lost:
            if (r4 != null) goto L_0x0138;
         */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x012e A[SYNTHETIC, Splitter:B:106:0x012e] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0050 A[Catch:{ MalformedURLException -> 0x012a, URISyntaxException -> 0x011a, SocketTimeoutException -> 0x010a, FileNotFoundException -> 0x00fa, Exception -> 0x008d, Error -> 0x0089 }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0076 A[SYNTHETIC, Splitter:B:19:0x0076] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0 A[Catch:{ all -> 0x00bc }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a9 A[SYNTHETIC, Splitter:B:39:0x00a9] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00ce A[Catch:{ all -> 0x00e4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00d9 A[SYNTHETIC, Splitter:B:56:0x00d9] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00e7 A[SYNTHETIC, Splitter:B:63:0x00e7] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x00fe A[SYNTHETIC, Splitter:B:76:0x00fe] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x010e A[SYNTHETIC, Splitter:B:86:0x010e] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x011e A[SYNTHETIC, Splitter:B:96:0x011e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.ironsource.sdk.precache.DownloadManager.Result downloadContent(java.lang.String r8, int r9) {
            /*
            // Method dump skipped, instructions count: 320
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.precache.DownloadManager.FileWorkerThread.downloadContent(java.lang.String, int):com.ironsource.sdk.precache.DownloadManager$Result");
        }
    }

    /* access modifiers changed from: package-private */
    public static class Result {
        byte[] body;
        int responseCode;
        public String url;

        Result() {
        }
    }
}
