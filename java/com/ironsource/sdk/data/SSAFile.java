package com.ironsource.sdk.data;

public class SSAFile extends SSAObj {
    private String FILE = "file";
    private String LAST_UPDATE_TIME = "lastUpdateTime";
    private String PATH = "path";
    private String mErrMsg;
    private String mFile;
    private String mLastUpdateTime;
    private String mPath;

    public SSAFile(String str) {
        super(str);
        if (containsKey("file")) {
            setFile(getString(this.FILE));
        }
        if (containsKey(this.PATH)) {
            setPath(getString(this.PATH));
        }
        if (containsKey(this.LAST_UPDATE_TIME)) {
            setLastUpdateTime(getString(this.LAST_UPDATE_TIME));
        }
    }

    public SSAFile(String str, String str2) {
        setFile(str);
        setPath(str2);
    }

    public String getFile() {
        return this.mFile;
    }

    private void setFile(String str) {
        this.mFile = str;
    }

    private void setPath(String str) {
        this.mPath = str;
    }

    public String getPath() {
        return this.mPath;
    }

    public void setErrMsg(String str) {
        this.mErrMsg = str;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public void setLastUpdateTime(String str) {
        this.mLastUpdateTime = str;
    }

    public String getLastUpdateTime() {
        return this.mLastUpdateTime;
    }
}
