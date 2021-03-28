package com.ironsource.sdk.utils;

import android.content.Context;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.sdk.data.SSAFile;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceStorageUtils {
    private static final String SSA_DIRECTORY_NAME = "supersonicads";

    public static String initializeCacheDirectory(Context context) {
        createRootDirectory(context);
        return refreshRootDirectory(context);
    }

    private static String refreshRootDirectory(Context context) {
        String currentSDKVersion = IronSourceSharedPrefHelper.getSupersonicPrefHelper(context).getCurrentSDKVersion();
        String supersonicSdkVersion = DeviceProperties.getSupersonicSdkVersion();
        if (currentSDKVersion.equalsIgnoreCase(supersonicSdkVersion)) {
            return getDiskCacheDir(context, SSA_DIRECTORY_NAME).getPath();
        }
        IronSourceSharedPrefHelper.getSupersonicPrefHelper().setCurrentSDKVersion(supersonicSdkVersion);
        File externalCacheDir = DeviceStatus.getExternalCacheDir(context);
        if (externalCacheDir != null) {
            deleteAllFiles(externalCacheDir.getAbsolutePath() + File.separator + SSA_DIRECTORY_NAME + File.separator);
        }
        deleteAllFiles(DeviceStatus.getInternalCacheDirPath(context) + File.separator + SSA_DIRECTORY_NAME + File.separator);
        return createRootDirectory(context);
    }

    private static void deleteAllFiles(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    deleteAllFiles(file.getAbsolutePath());
                    file.delete();
                } else {
                    file.delete();
                }
            }
        }
    }

    private static File getDiskCacheDir(Context context, String str) {
        return new File(getDiskCacheDirPath(context) + File.separator + str);
    }

    public static String getDiskCacheDirPath(Context context) {
        if (!SDKUtils.isExternalStorageAvailable()) {
            return DeviceStatus.getInternalCacheDirPath(context);
        }
        File externalCacheDir = DeviceStatus.getExternalCacheDir(context);
        if (externalCacheDir == null || !externalCacheDir.canWrite()) {
            return DeviceStatus.getInternalCacheDirPath(context);
        }
        return externalCacheDir.getPath();
    }

    private static String createRootDirectory(Context context) {
        File diskCacheDir = getDiskCacheDir(context, SSA_DIRECTORY_NAME);
        if (!diskCacheDir.exists()) {
            diskCacheDir.mkdir();
        }
        return diskCacheDir.getPath();
    }

    public static String makeDir(String str, String str2) {
        File file = new File(str, str2);
        if (file.exists() || file.mkdirs()) {
            return file.getPath();
        }
        return null;
    }

    public static synchronized boolean deleteFile(String str, String str2, String str3) {
        synchronized (IronSourceStorageUtils.class) {
            File file = new File(str, str2);
            if (!file.exists()) {
                return false;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().equalsIgnoreCase(str3)) {
                    return file2.delete();
                }
            }
            return false;
        }
    }

    public static synchronized boolean isFileCached(String str, SSAFile sSAFile) {
        synchronized (IronSourceStorageUtils.class) {
            File file = new File(str, sSAFile.getPath());
            if (file.listFiles() != null) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (file2.isFile() && file2.getName().equalsIgnoreCase(SDKUtils.getFileName(sSAFile.getFile()))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean isPathExist(String str, String str2) {
        return new File(str, str2).exists();
    }

    public static synchronized boolean deleteFolder(String str, String str2) {
        boolean z;
        synchronized (IronSourceStorageUtils.class) {
            File file = new File(str, str2);
            z = deleteFolderContentRecursive(file) && file.delete();
        }
        return z;
    }

    private static boolean deleteFolderContentRecursive(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteFolderContentRecursive(file2);
                }
                if (!file2.delete()) {
                    z = false;
                }
            }
        }
        return z;
    }

    public static String getCachedFilesMap(String str, String str2) {
        JSONObject buildFilesMap = buildFilesMap(str, str2);
        try {
            buildFilesMap.put("path", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return buildFilesMap.toString();
    }

    private static JSONObject buildFilesMap(String str, String str2) {
        File file = new File(str, str2);
        JSONObject jSONObject = new JSONObject();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                try {
                    Object looping = looping(file2);
                    if (looping instanceof JSONArray) {
                        jSONObject.put("files", looping(file2));
                    } else if (looping instanceof JSONObject) {
                        jSONObject.put(file2.getName(), looping(file2));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    private static Object looping(File file) {
        String campaignLastUpdate;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (file.isFile()) {
                jSONArray.put(file.getName());
                return jSONArray;
            }
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    jSONObject.put(file2.getName(), looping(file2));
                } else {
                    jSONArray.put(file2.getName());
                    jSONObject.put("files", jSONArray);
                }
            }
            if (file.isDirectory() && (campaignLastUpdate = IronSourceSharedPrefHelper.getSupersonicPrefHelper().getCampaignLastUpdate(file.getName())) != null) {
                jSONObject.put("lastUpdateTime", campaignLastUpdate);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean renameFile(String str, String str2) throws Exception {
        return new File(str).renameTo(new File(str2));
    }

    public static int saveFile(byte[] bArr, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            byte[] bArr2 = new byte[102400];
            int i = 0;
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    return i;
                }
                fileOutputStream.write(bArr2, 0, read);
                i += read;
            }
        } finally {
            fileOutputStream.close();
            byteArrayInputStream.close();
        }
    }
}
