package com.google.zxing.pdf417;

public final class PDF417ResultMetadata {
    private String addressee;
    private int checksum = -1;
    private String fileId;
    private String fileName;
    private long fileSize = -1;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentCount = -1;
    private int segmentIndex;
    private String sender;
    private long timestamp = -1;

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public void setSegmentIndex(int i) {
        this.segmentIndex = i;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.optionalData;
    }

    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setLastSegment(boolean z) {
        this.lastSegment = z;
    }

    public int getSegmentCount() {
        return this.segmentCount;
    }

    public void setSegmentCount(int i) {
        this.segmentCount = i;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public String getAddressee() {
        return this.addressee;
    }

    public void setAddressee(String str) {
        this.addressee = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public int getChecksum() {
        return this.checksum;
    }

    public void setChecksum(int i) {
        this.checksum = i;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
