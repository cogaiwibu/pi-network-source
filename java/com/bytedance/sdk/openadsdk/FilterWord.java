package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class FilterWord {
    private String a;
    private String b;
    private boolean c;
    private List<FilterWord> d;

    public String getId() {
        return this.a;
    }

    public void setId(String str) {
        this.a = str;
    }

    public String getName() {
        return this.b;
    }

    public void setName(String str) {
        this.b = str;
    }

    public boolean getIsSelected() {
        return this.c;
    }

    public void setIsSelected(boolean z) {
        this.c = z;
    }

    public List<FilterWord> getOptions() {
        return this.d;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord != null) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(filterWord);
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b);
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.d;
        return list != null && !list.isEmpty();
    }
}
