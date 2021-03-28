package com.facebook.appevents.aam;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class MetadataMatcher {
    private static final int MAX_INDICATOR_LENGTH = 100;
    private static final String TAG = MetadataMatcher.class.getCanonicalName();

    MetadataMatcher() {
    }

    static List<String> getCurrentViewIndicators(View view) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(ViewHierarchy.getHintOfView(view));
        Object tag = view.getTag();
        if (tag != null) {
            arrayList.add(tag.toString());
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null) {
            arrayList.add(contentDescription.toString());
        }
        try {
            if (view.getId() != -1) {
                String[] split = view.getResources().getResourceName(view.getId()).split("/");
                if (split.length == 2) {
                    arrayList.add(split[1]);
                }
            }
        } catch (Resources.NotFoundException unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            if (!str.isEmpty() && str.length() <= 100) {
                arrayList2.add(str.toLowerCase());
            }
        }
        return arrayList2;
    }

    static boolean matchIndicator(List<String> list, List<String> list2) {
        for (String str : list) {
            if (matchIndicator(str, list2)) {
                return true;
            }
        }
        return false;
    }

    static boolean matchIndicator(String str, List<String> list) {
        for (String str2 : list) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    static boolean matchValue(String str, String str2) {
        return str.matches(str2);
    }

    static List<String> getTextIndicators(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof EditText) {
            return arrayList;
        }
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!charSequence.isEmpty() && charSequence.length() < 100) {
                arrayList.add(charSequence.toLowerCase());
            }
            return arrayList;
        }
        for (View view2 : ViewHierarchy.getChildrenOfView(view)) {
            arrayList.addAll(getTextIndicators(view2));
        }
        return arrayList;
    }
}
