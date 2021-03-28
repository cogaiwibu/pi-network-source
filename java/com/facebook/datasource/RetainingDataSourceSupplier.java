package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    @Nullable
    private Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;
    private final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        RetainingDataSource retainingDataSource = new RetainingDataSource();
        retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(retainingDataSource);
        return retainingDataSource;
    }

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        this.mCurrentDataSourceSupplier = supplier;
        for (RetainingDataSource retainingDataSource : this.mDataSources) {
            if (!retainingDataSource.isClosed()) {
                retainingDataSource.setSupplier(supplier);
            }
        }
    }

    /* access modifiers changed from: private */
    public static class RetainingDataSource<T> extends AbstractDataSource<T> {
        @Nullable
        private DataSource<T> mDataSource;

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void onDataSourceFailed(DataSource<T> dataSource) {
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public boolean hasMultipleResults() {
            return true;
        }

        private RetainingDataSource() {
            this.mDataSource = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r4 == null) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
            r4.subscribe(new com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.InternalDataSubscriber(r3, null), com.facebook.common.executors.CallerThreadExecutor.getInstance());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
            closeSafely(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setSupplier(@javax.annotation.Nullable com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> r4) {
            /*
                r3 = this;
                boolean r0 = r3.isClosed()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                r0 = 0
                if (r4 == 0) goto L_0x0011
                java.lang.Object r4 = r4.get()
                com.facebook.datasource.DataSource r4 = (com.facebook.datasource.DataSource) r4
                goto L_0x0012
            L_0x0011:
                r4 = r0
            L_0x0012:
                monitor-enter(r3)
                boolean r1 = r3.isClosed()     // Catch:{ all -> 0x0035 }
                if (r1 == 0) goto L_0x001e
                closeSafely(r4)     // Catch:{ all -> 0x0035 }
                monitor-exit(r3)     // Catch:{ all -> 0x0035 }
                return
            L_0x001e:
                com.facebook.datasource.DataSource<T> r1 = r3.mDataSource     // Catch:{ all -> 0x0035 }
                r3.mDataSource = r4     // Catch:{ all -> 0x0035 }
                monitor-exit(r3)     // Catch:{ all -> 0x0035 }
                if (r4 == 0) goto L_0x0031
                com.facebook.datasource.RetainingDataSourceSupplier$RetainingDataSource$InternalDataSubscriber r2 = new com.facebook.datasource.RetainingDataSourceSupplier$RetainingDataSource$InternalDataSubscriber
                r2.<init>()
                com.facebook.common.executors.CallerThreadExecutor r0 = com.facebook.common.executors.CallerThreadExecutor.getInstance()
                r4.subscribe(r2, r0)
            L_0x0031:
                closeSafely(r1)
                return
            L_0x0035:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.setSupplier(com.facebook.common.internal.Supplier):void");
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        @Nullable
        public synchronized T getResult() {
            return this.mDataSource != null ? this.mDataSource.getResult() : null;
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public synchronized boolean hasResult() {
            return this.mDataSource != null && this.mDataSource.hasResult();
        }

        @Override // com.facebook.datasource.DataSource, com.facebook.datasource.AbstractDataSource
        public boolean close() {
            synchronized (this) {
                if (!super.close()) {
                    return false;
                }
                DataSource<T> dataSource = this.mDataSource;
                this.mDataSource = null;
                closeSafely(dataSource);
                return true;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void onDataSourceNewResult(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setResult(null, false);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void onDatasourceProgress(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        private static <T> void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        /* access modifiers changed from: private */
        public class InternalDataSubscriber implements DataSubscriber<T> {
            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource) {
            }

            private InternalDataSubscriber() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    RetainingDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    RetainingDataSource.this.onDataSourceFailed(dataSource);
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource) {
                RetainingDataSource.this.onDataSourceFailed(dataSource);
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource) {
                RetainingDataSource.this.onDatasourceProgress(dataSource);
            }
        }
    }
}
