package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

public final class DurationKt {
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    public static /* synthetic */ void getDays$annotations(int i) {
    }

    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static /* synthetic */ void getHours$annotations(double d) {
    }

    public static /* synthetic */ void getHours$annotations(int i) {
    }

    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    private static /* synthetic */ void getStorageUnit$annotations() {
    }

    public static final TimeUnit getStorageUnit() {
        return TimeUnit.NANOSECONDS;
    }

    public static final double toDuration(int i, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return toDuration((double) i, timeUnit);
    }

    public static final double toDuration(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return toDuration((double) j, timeUnit);
    }

    public static final double getNanoseconds(int i) {
        return toDuration(i, TimeUnit.NANOSECONDS);
    }

    public static final double getNanoseconds(long j) {
        return toDuration(j, TimeUnit.NANOSECONDS);
    }

    public static final double getNanoseconds(double d) {
        return toDuration(d, TimeUnit.NANOSECONDS);
    }

    public static final double getMicroseconds(int i) {
        return toDuration(i, TimeUnit.MICROSECONDS);
    }

    public static final double getMicroseconds(long j) {
        return toDuration(j, TimeUnit.MICROSECONDS);
    }

    public static final double getMicroseconds(double d) {
        return toDuration(d, TimeUnit.MICROSECONDS);
    }

    public static final double getMilliseconds(int i) {
        return toDuration(i, TimeUnit.MILLISECONDS);
    }

    public static final double getMilliseconds(long j) {
        return toDuration(j, TimeUnit.MILLISECONDS);
    }

    public static final double getMilliseconds(double d) {
        return toDuration(d, TimeUnit.MILLISECONDS);
    }

    public static final double getSeconds(int i) {
        return toDuration(i, TimeUnit.SECONDS);
    }

    public static final double getSeconds(long j) {
        return toDuration(j, TimeUnit.SECONDS);
    }

    public static final double getSeconds(double d) {
        return toDuration(d, TimeUnit.SECONDS);
    }

    public static final double getMinutes(int i) {
        return toDuration(i, TimeUnit.MINUTES);
    }

    public static final double getMinutes(long j) {
        return toDuration(j, TimeUnit.MINUTES);
    }

    public static final double getMinutes(double d) {
        return toDuration(d, TimeUnit.MINUTES);
    }

    public static final double getHours(int i) {
        return toDuration(i, TimeUnit.HOURS);
    }

    public static final double getHours(long j) {
        return toDuration(j, TimeUnit.HOURS);
    }

    public static final double getHours(double d) {
        return toDuration(d, TimeUnit.HOURS);
    }

    public static final double getDays(int i) {
        return toDuration(i, TimeUnit.DAYS);
    }

    public static final double getDays(long j) {
        return toDuration(j, TimeUnit.DAYS);
    }

    public static final double getDays(double d) {
        return toDuration(d, TimeUnit.DAYS);
    }

    /* renamed from: times-mvk6XK0 */
    private static final double m1319timesmvk6XK0(int i, double d) {
        return Duration.m1299timesUwyO8pc(d, i);
    }

    /* renamed from: times-kIfJnKk */
    private static final double m1318timeskIfJnKk(double d, double d2) {
        return Duration.m1298timesUwyO8pc(d2, d);
    }

    public static final double toDuration(double d, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return Duration.m1272constructorimpl(DurationUnitKt.convertDurationUnit(d, timeUnit, TimeUnit.NANOSECONDS));
    }
}
