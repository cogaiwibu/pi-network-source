package com.ironsource.environment;

public class ExceptionLog {
    private String mDate;
    private int mId;
    private String mStacktrace;

    public ExceptionLog(String str, String str2) {
        this.mId = -1;
        this.mDate = str2;
        this.mStacktrace = str;
    }

    public ExceptionLog(int i, String str, String str2) {
        this.mId = i;
        this.mDate = str2;
        this.mStacktrace = str;
    }

    public int getId() {
        return this.mId;
    }

    public String getStacktrace() {
        return this.mStacktrace;
    }

    public String getDate() {
        return this.mDate;
    }

    public void Save() {
        DbHandler.addReport(this);
    }
}
