package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.onesignal.OSNotificationFormatHelper;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class IronSourceSegment {
    public static final String AGE = "age";
    public static final String GENDER = "gen";
    public static final String IAPT = "iapt";
    public static final String LEVEL = "lvl";
    public static final String PAYING = "pay";
    private static final String SEGMENT_NAME = "segName";
    public static final String USER_CREATION_DATE = "ucd";
    private final String CUSTOM = OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM;
    private final int MAX_CUSTOMS = 5;
    private double MAX_IAPT = 999999.99d;
    private int MAX_LEVEL = 999999;
    private int mAge = -1;
    private Vector<Pair<String, String>> mCustoms = new Vector<>();
    private String mGender;
    private double mIapt = -1.0d;
    private AtomicBoolean mIsPaying = null;
    private int mLevel = -1;
    private String mSegmentName;
    private long mUcd = 0;

    public String getSegmentName() {
        return this.mSegmentName;
    }

    public int getAge() {
        return this.mAge;
    }

    public String getGender() {
        return this.mGender;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public AtomicBoolean getIsPaying() {
        return this.mIsPaying;
    }

    public double getIapt() {
        return this.mIapt;
    }

    public long getUcd() {
        return this.mUcd;
    }

    public void setAge(int i) {
        if (i <= 0 || i > 199) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setAge( " + i + " ) age must be between 1-199", 2);
            return;
        }
        this.mAge = i;
    }

    public void setGender(String str) {
        if (TextUtils.isEmpty(str) || (!StringUtils.toLowerCase(str).equals(IronSourceConstants.Gender.MALE) && !StringUtils.toLowerCase(str).equals(IronSourceConstants.Gender.FEMALE))) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setGender( " + str + " ) is invalid", 2);
            return;
        }
        this.mGender = str;
    }

    public void setLevel(int i) {
        if (i <= 0 || i >= this.MAX_LEVEL) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setLevel( " + i + " ) level must be between 1-" + this.MAX_LEVEL, 2);
            return;
        }
        this.mLevel = i;
    }

    public void setIsPaying(boolean z) {
        if (this.mIsPaying == null) {
            this.mIsPaying = new AtomicBoolean();
        }
        this.mIsPaying.set(z);
    }

    public void setIAPTotal(double d) {
        if (d <= 0.0d || d >= this.MAX_IAPT) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setIAPTotal( " + d + " ) iapt must be between 0-" + this.MAX_IAPT, 2);
            return;
        }
        this.mIapt = Math.floor(d * 100.0d) / 100.0d;
    }

    public void setUserCreationDate(long j) {
        if (j > 0) {
            this.mUcd = j;
            return;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "setUserCreationDate( " + j + " ) is an invalid timestamp", 2);
    }

    public void setSegmentName(String str) {
        if (!validateAlphanumeric(str) || !validateLength(str, 1, 32)) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            logger.log(ironSourceTag, "setSegmentName( " + str + " ) segment name must be alphanumeric and 1-32 in length", 2);
            return;
        }
        this.mSegmentName = str;
    }

    public void setCustom(String str, String str2) {
        try {
            if (!validateAlphanumeric(str) || !validateAlphanumeric(str2) || !validateLength(str, 1, 32) || !validateLength(str2, 1, 32)) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setCustom( " + str + " , " + str2 + " ) key and value must be alphanumeric and 1-32 in length", 2);
                return;
            }
            String str3 = "custom_" + str;
            if (this.mCustoms.size() < 5) {
                this.mCustoms.add(new Pair<>(str3, str2));
                return;
            }
            this.mCustoms.remove(0);
            this.mCustoms.add(new Pair<>(str3, str2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public Vector<Pair<String, String>> getSegmentData() {
        Vector<Pair<String, String>> vector = new Vector<>();
        if (this.mAge != -1) {
            vector.add(new Pair<>(AGE, this.mAge + ""));
        }
        if (!TextUtils.isEmpty(this.mGender)) {
            vector.add(new Pair<>(GENDER, this.mGender));
        }
        if (this.mLevel != -1) {
            vector.add(new Pair<>(LEVEL, this.mLevel + ""));
        }
        if (this.mIsPaying != null) {
            vector.add(new Pair<>(PAYING, this.mIsPaying + ""));
        }
        if (this.mIapt != -1.0d) {
            vector.add(new Pair<>(IAPT, this.mIapt + ""));
        }
        if (this.mUcd != 0) {
            vector.add(new Pair<>(USER_CREATION_DATE, this.mUcd + ""));
        }
        if (!TextUtils.isEmpty(this.mSegmentName)) {
            vector.add(new Pair<>(SEGMENT_NAME, this.mSegmentName));
        }
        vector.addAll(this.mCustoms);
        return vector;
    }

    private boolean validateAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private boolean validateLength(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }
}
