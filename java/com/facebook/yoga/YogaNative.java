package com.facebook.yoga;

import com.facebook.soloader.SoLoader;

public class YogaNative {
    static native void jni_YGConfigFreeJNI(long j);

    static native long jni_YGConfigNewJNI();

    static native void jni_YGConfigSetExperimentalFeatureEnabledJNI(long j, int i, boolean z);

    static native void jni_YGConfigSetLoggerJNI(long j, YogaLogger yogaLogger);

    static native void jni_YGConfigSetPointScaleFactorJNI(long j, float f);

    static native void jni_YGConfigSetPrintTreeFlagJNI(long j, boolean z);

    static native void jni_YGConfigSetShouldDiffLayoutWithoutLegacyStretchBehaviourJNI(long j, boolean z);

    static native void jni_YGConfigSetUseLegacyStretchBehaviourJNI(long j, boolean z);

    static native void jni_YGConfigSetUseWebDefaultsJNI(long j, boolean z);

    static native void jni_YGNodeCalculateLayoutJNI(long j, float f, float f2, long[] jArr, YogaNodeJNIBase[] yogaNodeJNIBaseArr);

    static native void jni_YGNodeClearChildrenJNI(long j);

    static native long jni_YGNodeCloneJNI(long j);

    static native void jni_YGNodeCopyStyleJNI(long j, long j2);

    static native void jni_YGNodeFreeJNI(long j);

    static native void jni_YGNodeInsertChildJNI(long j, long j2, int i);

    static native boolean jni_YGNodeIsDirtyJNI(long j);

    static native boolean jni_YGNodeIsReferenceBaselineJNI(long j);

    static native void jni_YGNodeMarkDirtyAndPropogateToDescendantsJNI(long j);

    static native void jni_YGNodeMarkDirtyJNI(long j);

    static native long jni_YGNodeNewJNI();

    static native long jni_YGNodeNewWithConfigJNI(long j);

    static native void jni_YGNodePrintJNI(long j);

    static native void jni_YGNodeRemoveChildJNI(long j, long j2);

    static native void jni_YGNodeResetJNI(long j);

    static native void jni_YGNodeSetHasBaselineFuncJNI(long j, boolean z);

    static native void jni_YGNodeSetHasMeasureFuncJNI(long j, boolean z);

    static native void jni_YGNodeSetIsReferenceBaselineJNI(long j, boolean z);

    static native void jni_YGNodeSetStyleInputsJNI(long j, float[] fArr, int i);

    static native int jni_YGNodeStyleGetAlignContentJNI(long j);

    static native int jni_YGNodeStyleGetAlignItemsJNI(long j);

    static native int jni_YGNodeStyleGetAlignSelfJNI(long j);

    static native float jni_YGNodeStyleGetAspectRatioJNI(long j);

    static native float jni_YGNodeStyleGetBorderJNI(long j, int i);

    static native int jni_YGNodeStyleGetDirectionJNI(long j);

    static native int jni_YGNodeStyleGetDisplayJNI(long j);

    static native long jni_YGNodeStyleGetFlexBasisJNI(long j);

    static native int jni_YGNodeStyleGetFlexDirectionJNI(long j);

    static native float jni_YGNodeStyleGetFlexGrowJNI(long j);

    static native float jni_YGNodeStyleGetFlexJNI(long j);

    static native float jni_YGNodeStyleGetFlexShrinkJNI(long j);

    static native int jni_YGNodeStyleGetFlexWrapJNI(long j);

    static native long jni_YGNodeStyleGetHeightJNI(long j);

    static native int jni_YGNodeStyleGetJustifyContentJNI(long j);

    static native long jni_YGNodeStyleGetMarginJNI(long j, int i);

    static native long jni_YGNodeStyleGetMaxHeightJNI(long j);

    static native long jni_YGNodeStyleGetMaxWidthJNI(long j);

    static native long jni_YGNodeStyleGetMinHeightJNI(long j);

    static native long jni_YGNodeStyleGetMinWidthJNI(long j);

    static native int jni_YGNodeStyleGetOverflowJNI(long j);

    static native long jni_YGNodeStyleGetPaddingJNI(long j, int i);

    static native long jni_YGNodeStyleGetPositionJNI(long j, int i);

    static native int jni_YGNodeStyleGetPositionTypeJNI(long j);

    static native long jni_YGNodeStyleGetWidthJNI(long j);

    static native void jni_YGNodeStyleSetAlignContentJNI(long j, int i);

    static native void jni_YGNodeStyleSetAlignItemsJNI(long j, int i);

    static native void jni_YGNodeStyleSetAlignSelfJNI(long j, int i);

    static native void jni_YGNodeStyleSetAspectRatioJNI(long j, float f);

    static native void jni_YGNodeStyleSetBorderJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetDirectionJNI(long j, int i);

    static native void jni_YGNodeStyleSetDisplayJNI(long j, int i);

    static native void jni_YGNodeStyleSetFlexBasisAutoJNI(long j);

    static native void jni_YGNodeStyleSetFlexBasisJNI(long j, float f);

    static native void jni_YGNodeStyleSetFlexBasisPercentJNI(long j, float f);

    static native void jni_YGNodeStyleSetFlexDirectionJNI(long j, int i);

    static native void jni_YGNodeStyleSetFlexGrowJNI(long j, float f);

    static native void jni_YGNodeStyleSetFlexJNI(long j, float f);

    static native void jni_YGNodeStyleSetFlexShrinkJNI(long j, float f);

    static native void jni_YGNodeStyleSetFlexWrapJNI(long j, int i);

    static native void jni_YGNodeStyleSetHeightAutoJNI(long j);

    static native void jni_YGNodeStyleSetHeightJNI(long j, float f);

    static native void jni_YGNodeStyleSetHeightPercentJNI(long j, float f);

    static native void jni_YGNodeStyleSetJustifyContentJNI(long j, int i);

    static native void jni_YGNodeStyleSetMarginAutoJNI(long j, int i);

    static native void jni_YGNodeStyleSetMarginJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetMarginPercentJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetMaxHeightJNI(long j, float f);

    static native void jni_YGNodeStyleSetMaxHeightPercentJNI(long j, float f);

    static native void jni_YGNodeStyleSetMaxWidthJNI(long j, float f);

    static native void jni_YGNodeStyleSetMaxWidthPercentJNI(long j, float f);

    static native void jni_YGNodeStyleSetMinHeightJNI(long j, float f);

    static native void jni_YGNodeStyleSetMinHeightPercentJNI(long j, float f);

    static native void jni_YGNodeStyleSetMinWidthJNI(long j, float f);

    static native void jni_YGNodeStyleSetMinWidthPercentJNI(long j, float f);

    static native void jni_YGNodeStyleSetOverflowJNI(long j, int i);

    static native void jni_YGNodeStyleSetPaddingJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetPaddingPercentJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetPositionJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetPositionPercentJNI(long j, int i, float f);

    static native void jni_YGNodeStyleSetPositionTypeJNI(long j, int i);

    static native void jni_YGNodeStyleSetWidthAutoJNI(long j);

    static native void jni_YGNodeStyleSetWidthJNI(long j, float f);

    static native void jni_YGNodeStyleSetWidthPercentJNI(long j, float f);

    static {
        SoLoader.loadLibrary("yoga");
    }
}
