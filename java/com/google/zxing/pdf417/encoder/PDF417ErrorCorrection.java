package com.google.zxing.pdf417.encoder;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* access modifiers changed from: package-private */
public final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{TiffUtil.TIFF_TAG_ORIENTATION, 562, 232, 755, 599, IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, 287, 107, IronSourceError.ERROR_CODE_KEY_NOT_SET, 733, 877, 381, IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, 723, 476, 462, 172, 430, IronSourceError.ERROR_BN_INSTANCE_RELOAD_TIMEOUT, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, JfifUtil.MARKER_APP1, 535, 517, 352, IronSourceError.ERROR_BN_LOAD_EXCEPTION, 158, 651, 201, 488, IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, 925, 749, 415, 822, 93, JfifUtil.MARKER_EOI, JfifUtil.MARKER_RST0, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, IronSourceError.ERROR_BN_LOAD_NO_FILL, 860, 569, 193, 219, 129, 186, 236, 287, JfifUtil.MARKER_SOFn, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, RotationOptions.ROTATE_270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, IronSourceError.ERROR_BN_INIT_FAILED_AFTER_LOAD, 754, 336, 89, IronSourceError.ERROR_BN_RELOAD_SKIP_BACKGROUND, 87, 432, 670, IronSourceError.ERROR_BN_UNSUPPORTED_SIZE, 157, 374, 242, 726, IronSourceError.ERROR_BN_LOAD_AFTER_INIT_FAILED, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, 905, 786, 138, 720, 858, 194, 311, 913, 275, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, IronSourceError.ERROR_BN_LOAD_EXCEPTION, 540, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, JfifUtil.MARKER_SOI, InputDeviceCompat.SOURCE_KEYBOARD, 284, 549, 209, 884, 315, 70, 329, 793, 490, TiffUtil.TIFF_TAG_ORIENTATION, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, JfifUtil.MARKER_APP1, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, IronSourceError.ERROR_BN_LOAD_AFTER_LONG_INITIATION, JfifUtil.MARKER_SOFn, IronSourceError.ERROR_BN_LOAD_EXCEPTION, 142, 673, 687, 234, 722, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 177, 752, IronSourceError.ERROR_BN_INSTANCE_INIT_TIMEOUT, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, IronSourceError.ERROR_BN_INSTANCE_RELOAD_TIMEOUT, 441, RotationOptions.ROTATE_180, 791, 893, 754, IronSourceError.ERROR_BN_LOAD_EXCEPTION, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, IronSourceError.ERROR_BN_INSTANCE_RELOAD_TIMEOUT, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, IronSourceError.ERROR_CODE_KEY_NOT_SET, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, IronSourceError.ERROR_NO_INTERNET_CONNECTION, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, RotationOptions.ROTATE_180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, InputDeviceCompat.SOURCE_DPAD, JfifUtil.MARKER_SOFn, 516, 258, 240, 518, 794, 395, 768, 848, 51, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 168, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 826, 328, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, 429, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, IronSourceError.ERROR_BN_INSTANCE_LOAD_TIMEOUT, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, IronSourceError.ERROR_BN_RELOAD_SKIP_INVISIBLE, 830, 922, 437, 519, 644, 905, 789, 420, IronSourceConstants.OFFERWALL_OPENED, 441, 207, 300, 892, 827, 141, 537, 381, 662, InputDeviceCompat.SOURCE_DPAD, 56, 252, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, JfifUtil.MARKER_SOI, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, IronSourceError.ERROR_BN_INSTANCE_LOAD_EMPTY_BANNER, 46, 656, 447, 171, IronSourceError.ERROR_BN_UNSUPPORTED_SIZE, 464, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, IronSourceError.ERROR_BN_LOAD_AFTER_INIT_FAILED, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, 244, 31, 121, 303, 263}};

    private PDF417ErrorCorrection() {
    }

    static int getErrorCorrectionCodewordCount(int i) {
        if (i >= 0 && i <= 8) {
            return 1 << (i + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i <= 40) {
            return 2;
        } else {
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }

    static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            if (cArr[i4] != 0) {
                cArr[i4] = (char) (929 - cArr[i4]);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }
}
