package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    @Deprecated
    public void finishUpdate(View view) {
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        return -1;
    }

    public CharSequence getPageTitle(int i) {
        return null;
    }

    public float getPageWidth(int i) {
        return 1.0f;
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(View view, int i, Object obj) {
    }

    @Deprecated
    public void startUpdate(View view) {
    }

    public void startUpdate(ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return instantiateItem((View) viewGroup, i);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        destroyItem((View) viewGroup, i, obj);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        setPrimaryItem((View) viewGroup, i, obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    @Deprecated
    public Object instantiateItem(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void destroyItem(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            if (this.mViewPagerObserver != null) {
                this.mViewPagerObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    /* access modifiers changed from: package-private */
    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }
}
