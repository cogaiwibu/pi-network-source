package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class F3 extends R5 {
    public static byte[] A02;
    public static String[] A03;
    public static final String A04 = F3.class.getSimpleName();
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] - i3) - 27;
            String[] strArr = A03;
            if (strArr[6].charAt(23) != strArr[0].charAt(23)) {
                String[] strArr2 = A03;
                strArr2[3] = "uqLwDcTKX4SWJds2FMBMp5QNw2MnWtU";
                strArr2[3] = "uqLwDcTKX4SWJds2FMBMp5QNw2MnWtU";
                copyOfRange[i4] = (byte) i5;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{106, -105, -105, -108, -105, 69, -107, -122, -105, -104, -114, -109, -116, 69, -122, -107, -107, -104, -114, -103, -118, -124, -119, -122, -103, -122, -124, -97, -89, -86, -93, -94, 94, -78, -83, 94, -83, -82, -93, -84, 94, -85, -97, -80, -87, -93, -78, 94, -77, -80, -86, 120, 94, -29, -27, -5, 8, -2, 12, 9, 3, -2, -108, -95, -105, -91, -94, -100, -105, 97, -100, -95, -89, -104, -95, -89, 97, -108, -106, -89, -100, -94, -95, 97, 118, 116, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, -94, -81, -91, -77, -80, -86, -91, 111, -86, -81, -75, -90, -81, -75, 111, -94, -92, -75, -86, -80, -81, 111, -105, -118, -122, -104, -8, 7, 7, 10, 0, 11, -4, -10, -5, -8, 11, -8, -3, -15, 2, -5, -11, 4, -54, -65, -65, -12, -11, 4, -15, -7, -4, 3, -49, -7, -12, -51, -75, 3, -26, -25, -36, -27, -36, -37, -42, -37, -36, -36, -25, -29, -32, -27, -30, -108, -107, -118, -109, -118, -119, -124, -104, -103, -108, -105, -118, -124, -117, -122, -111, -111, -121, -122, -120, -112, -124, -102, -105, -111, -38, -37, -48, -39, -48, -49, -54, -34, -33, -38, -35, -48, -54, -32, -35, -41, -70, -85, -68, -67, -77, -72, -79, -51, -50, -55, -52, -65, -71, -61, -66, -10, -9, -14, -11, -24, -30, -8, -11, -17, -96, -95, -100, -97, -110, -116, -94, -97, -103, -116, -92, -110, -113, -116, -109, -114, -103, -103, -113, -114, -112, -104, -90, -105, -98, 108, -72, -87, -80, -76, -74, -77, -79, -76, -72, 126};
    }

    public static void A07() {
        A03 = new String[]{"eZwrQOnpnpQE2xbRo0zNjy7tlobdqdqH", "SFt7WwZUn", "NjRPf9lXQVcUlHZaPZ2tHyzwDKEOZm5m", "vsw9aGbGyLBdbL44W3z8tEYPUFR7w9", "bZApvv", "GYK1wV", "jBSwIULngy0dc0IzE6SbgF9ev3BAFzHy", "9HFC3JFq8"};
    }

    static {
        A07();
        A06();
    }

    public F3(C0820Wh wh, JE je, String str, Uri uri, Map<String, String> map, C00330m r12, boolean z) {
        super(wh, je, str, r12, z);
        this.A00 = uri;
        this.A01 = map;
    }

    private Intent A00(C00310k r8) {
        if (TextUtils.isEmpty(r8.A06()) || !C00300j.A05(((AbstractC00260f) this).A00, r8.A06())) {
            return null;
        }
        String A042 = r8.A04();
        if (TextUtils.isEmpty(A042) || (!A042.startsWith(A03(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, 4, 23)) && !A042.startsWith(A03(254, 10, 41)))) {
            PackageManager packageManager = ((AbstractC00260f) this).A00.getPackageManager();
            if (TextUtils.isEmpty(r8.A05()) && TextUtils.isEmpty(A042)) {
                return packageManager.getLaunchIntentForPackage(r8.A06());
            }
            Intent A012 = A01(r8);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(A012, 65536);
            if (A012.getComponent() == null) {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (next.activityInfo.packageName.equals(r8.A06())) {
                        A012.setComponent(new ComponentName(next.activityInfo.packageName, next.activityInfo.name));
                        break;
                    }
                }
            }
            boolean isEmpty = queryIntentActivities.isEmpty();
            String[] strArr = A03;
            if (strArr[5].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "mdy3DwQER";
            strArr2[1] = "z4eGZXaiq";
            if (isEmpty || A012.getComponent() == null) {
                return null;
            }
            return A012;
        }
        return new Intent(A03(62, 26, 24), Uri.parse(A042));
    }

    private Intent A01(C00310k r5) {
        Intent intent = new Intent(A03(88, 26, 38));
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(r5.A06()) && !TextUtils.isEmpty(r5.A05())) {
            intent.setComponent(new ComponentName(r5.A06(), r5.A05()));
        }
        if (!TextUtils.isEmpty(r5.A04())) {
            intent.setData(Uri.parse(r5.A04()));
        }
        return intent;
    }

    private final Uri A02() {
        String queryParameter = this.A00.getQueryParameter(A03(219, 9, 104));
        if (!TextUtils.isEmpty(queryParameter)) {
            return Uri.parse(queryParameter);
        }
        String queryParameter2 = this.A00.getQueryParameter(A03(211, 8, 63));
        return Uri.parse(String.format(Locale.US, A03(126, 22, 117), queryParameter2));
    }

    /* JADX INFO: Multiple debug info for r0v17 com.facebook.ads.redexgen.X.0k: [D('i' int), D('appSiteData' com.facebook.ads.redexgen.X.0k)] */
    private List<C00310k> A04() {
        String queryParameter = this.A00.getQueryParameter(A03(114, 12, 124));
        if (TextUtils.isEmpty(queryParameter) || A03(53, 2, 109).equals(queryParameter)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray(A03(55, 7, 127));
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C00310k appSiteData = C00310k.A00(optJSONArray.optJSONObject(i));
                    if (appSiteData != null) {
                        arrayList.add(appSiteData);
                    }
                }
            }
        } catch (JSONException e) {
            ((AbstractC00260f) this).A00.A04().A82(A03(204, 7, 47), C02248i.A1j, new C02258j(e));
            Log.w(A04, A03(0, 26, 10), e);
        }
        return arrayList;
    }

    /* JADX INFO: Multiple debug info for r0v4 android.content.Intent: [D('intents' java.util.List<android.content.Intent>), D('intent' android.content.Intent)] */
    private final List<Intent> A05() {
        List<C00310k> A042 = A04();
        ArrayList arrayList = new ArrayList();
        if (A042 != null) {
            for (C00310k r0 : A042) {
                Intent intent = A00(r0);
                if (intent != null) {
                    arrayList.add(intent);
                }
            }
        }
        return arrayList;
    }

    private boolean A08() {
        List<Intent> A05 = A05();
        if (A05 == null) {
            return false;
        }
        for (Intent intent : A05) {
            try {
                if (C0523Kq.A0C(((AbstractC00260f) this).A00, intent)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean A09() {
        Kw kw = new Kw();
        try {
            Kw.A09(kw, ((AbstractC00260f) this).A00, A02(), this.A02);
            return true;
        } catch (Exception unused) {
            String str = A03(26, 27, 35) + this.A00.toString();
            String queryParameter = this.A00.getQueryParameter(A03(228, 22, 18));
            if (queryParameter == null || queryParameter.length() <= 0) {
                return false;
            }
            Kw.A09(kw, ((AbstractC00260f) this).A00, Uri.parse(queryParameter), this.A02);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00260f
    @Nullable
    public final EnumC00250e A0A() {
        EnumC00250e r4 = null;
        String A032 = A03(148, 15, 92);
        if (!A08()) {
            try {
                A032 = A09() ? A03(188, 16, 80) : A03(163, 25, 10);
            } catch (Exception unused) {
                r4 = EnumC00250e.A02;
            }
        }
        this.A01.put(A032, String.valueOf(true));
        return r4;
    }

    @Override // com.facebook.ads.redexgen.X.R5
    public final void A0E() {
        EnumC00250e r5 = null;
        if (((R5) this).A01) {
            r5 = A0A();
        } else {
            this.A01.put(A03(188, 16, 80), String.valueOf(true));
        }
        Map<String, String> map = this.A01;
        if (A03[3].length() != 13) {
            String[] strArr = A03;
            strArr[2] = "sgzsFq3t5RzUzGxHOqvhuB7Tq08HlvIk";
            strArr[2] = "sgzsFq3t5RzUzGxHOqvhuB7Tq08HlvIk";
            A0F(map, r5);
            return;
        }
        throw new RuntimeException();
    }
}
