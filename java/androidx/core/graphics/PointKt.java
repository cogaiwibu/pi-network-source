package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import com.onesignal.NotificationBundleProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\n¨\u0006\r"}, d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON, "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: Point.kt */
public final class PointKt {
    public static final int component1(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$component1");
        return point.x;
    }

    public static final int component2(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$component2");
        return point.y;
    }

    public static final float component1(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$component1");
        return pointF.x;
    }

    public static final float component2(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$component2");
        return pointF.y;
    }

    public static final Point plus(Point point, Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "$this$plus");
        Intrinsics.checkParameterIsNotNull(point2, NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON);
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$plus");
        Intrinsics.checkParameterIsNotNull(pointF2, NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final Point plus(Point point, int i) {
        Intrinsics.checkParameterIsNotNull(point, "$this$plus");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    public static final PointF plus(PointF pointF, float f) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$plus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }

    public static final Point minus(Point point, Point point2) {
        Intrinsics.checkParameterIsNotNull(point, "$this$minus");
        Intrinsics.checkParameterIsNotNull(point2, NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON);
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$minus");
        Intrinsics.checkParameterIsNotNull(pointF2, NotificationBundleProcessor.PUSH_MINIFIED_BUTTON_ICON);
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final Point minus(Point point, int i) {
        Intrinsics.checkParameterIsNotNull(point, "$this$minus");
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    public static final PointF minus(PointF pointF, float f) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$minus");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    public static final Point unaryMinus(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$unaryMinus");
        return new Point(-point.x, -point.y);
    }

    public static final PointF unaryMinus(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$unaryMinus");
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final PointF toPointF(Point point) {
        Intrinsics.checkParameterIsNotNull(point, "$this$toPointF");
        return new PointF(point);
    }

    public static final Point toPoint(PointF pointF) {
        Intrinsics.checkParameterIsNotNull(pointF, "$this$toPoint");
        return new Point((int) pointF.x, (int) pointF.y);
    }
}
