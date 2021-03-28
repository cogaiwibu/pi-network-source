package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class DailyCappingManager {
    private static final int RAND_MINUTES = 10;
    private String mAdUnitName;
    private DailyCappingListener mListener;
    private IronSourceLoggerManager mLogger;
    private Map<String, Integer> mSmashIdToCounter;
    private Map<String, String> mSmashIdToCounterDate;
    private Map<String, Integer> mSmashIdToMaxShowsPerDay;
    private Timer mTimer = null;

    public DailyCappingManager(String str, DailyCappingListener dailyCappingListener) {
        this.mAdUnitName = str;
        this.mListener = dailyCappingListener;
        this.mSmashIdToMaxShowsPerDay = new HashMap();
        this.mSmashIdToCounter = new HashMap();
        this.mSmashIdToCounterDate = new HashMap();
        this.mLogger = IronSourceLoggerManager.getLogger();
        scheduleTimer();
    }

    public void addSmash(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                if (abstractSmash.getMaxAdsPerDay() != 99) {
                    this.mSmashIdToMaxShowsPerDay.put(getUniqueId(abstractSmash), Integer.valueOf(abstractSmash.getMaxAdsPerDay()));
                }
            } catch (Exception e) {
                this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "addSmash", e);
            }
        }
    }

    public void increaseShowCounter(AbstractSmash abstractSmash) {
        synchronized (this) {
            try {
                String uniqueId = getUniqueId(abstractSmash);
                if (this.mSmashIdToMaxShowsPerDay.containsKey(uniqueId)) {
                    saveCounter(uniqueId, getTodayShowCount(uniqueId) + 1);
                }
            } catch (Exception e) {
                this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "increaseShowCounter", e);
            }
        }
    }

    public boolean shouldSendCapReleasedEvent(AbstractSmash abstractSmash) {
        synchronized (this) {
            boolean z = false;
            try {
                String uniqueId = getUniqueId(abstractSmash);
                if (!this.mSmashIdToMaxShowsPerDay.containsKey(uniqueId)) {
                    return false;
                }
                if (getTodayDate().equalsIgnoreCase(getCounterDate(uniqueId))) {
                    return false;
                }
                if (this.mSmashIdToMaxShowsPerDay.get(uniqueId).intValue() <= getCounter(uniqueId)) {
                    z = true;
                }
                return z;
            } catch (Exception e) {
                this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "shouldSendCapReleasedEvent", e);
                return false;
            }
        }
    }

    public boolean isCapped(AbstractSmash abstractSmash) {
        synchronized (this) {
            boolean z = false;
            try {
                String uniqueId = getUniqueId(abstractSmash);
                if (!this.mSmashIdToMaxShowsPerDay.containsKey(uniqueId)) {
                    return false;
                }
                if (this.mSmashIdToMaxShowsPerDay.get(uniqueId).intValue() <= getTodayShowCount(uniqueId)) {
                    z = true;
                }
                return z;
            } catch (Exception e) {
                this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "isCapped", e);
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onTimerTick() {
        synchronized (this) {
            try {
                for (String str : this.mSmashIdToMaxShowsPerDay.keySet()) {
                    zeroCounter(str);
                }
                this.mListener.onDailyCapReleased();
                scheduleTimer();
            } catch (Exception e) {
                this.mLogger.logException(IronSourceLogger.IronSourceTag.INTERNAL, "onTimerTick", e);
            }
        }
    }

    private void scheduleTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.mTimer = timer2;
        timer2.schedule(new TimerTask() {
            /* class com.ironsource.mediationsdk.utils.DailyCappingManager.AnonymousClass1 */

            public void run() {
                DailyCappingManager.this.onTimerTick();
            }
        }, getUtcMidnight());
    }

    private Date getUtcMidnight() {
        Random random = new Random();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.US);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, random.nextInt(10));
        gregorianCalendar.set(13, random.nextInt(60));
        gregorianCalendar.set(14, random.nextInt(1000));
        gregorianCalendar.add(5, 1);
        return gregorianCalendar.getTime();
    }

    private int getTodayShowCount(String str) {
        if (!getTodayDate().equalsIgnoreCase(getCounterDate(str))) {
            zeroCounter(str);
        }
        return getCounter(str);
    }

    private String getCounterDate(String str) {
        if (this.mSmashIdToCounterDate.containsKey(str)) {
            return this.mSmashIdToCounterDate.get(str);
        }
        String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(ContextProvider.getInstance().getApplicationContext(), getDayKeyName(str), getTodayDate());
        this.mSmashIdToCounterDate.put(str, stringFromSharedPrefs);
        return stringFromSharedPrefs;
    }

    private int getCounter(String str) {
        if (this.mSmashIdToCounter.containsKey(str)) {
            return this.mSmashIdToCounter.get(str).intValue();
        }
        int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(ContextProvider.getInstance().getApplicationContext(), getCounterKeyName(str), 0);
        this.mSmashIdToCounter.put(str, Integer.valueOf(intFromSharedPrefs));
        return intFromSharedPrefs;
    }

    private void saveCounter(String str, int i) {
        this.mSmashIdToCounter.put(str, Integer.valueOf(i));
        this.mSmashIdToCounterDate.put(str, getTodayDate());
        IronSourceUtils.saveIntToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), getCounterKeyName(str), i);
        IronSourceUtils.saveStringToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), getDayKeyName(str), getTodayDate());
    }

    private void zeroCounter(String str) {
        this.mSmashIdToCounter.put(str, 0);
        this.mSmashIdToCounterDate.put(str, getTodayDate());
        IronSourceUtils.saveIntToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), getCounterKeyName(str), 0);
        IronSourceUtils.saveStringToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), getDayKeyName(str), getTodayDate());
    }

    private String getUniqueId(AbstractSmash abstractSmash) {
        return this.mAdUnitName + "_" + abstractSmash.getSubProviderId() + "_" + abstractSmash.getName();
    }

    private String getCounterKeyName(String str) {
        return str + "_counter";
    }

    private String getDayKeyName(String str) {
        return str + "_day";
    }

    private String getTodayDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }
}
