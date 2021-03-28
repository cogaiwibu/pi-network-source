package com.tapjoy;

import com.tapjoy.internal.az;
import com.tapjoy.internal.gl;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.go;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.ha;

public class FiveRocksIntegration {
    private static az a = new az();

    public static void addPlacementCallback(String str, TJPlacement tJPlacement) {
        synchronized (a) {
            a.put(str, tJPlacement);
        }
    }

    public static void a() {
        gz a2 = gz.a();
        if (!a2.c) {
            a2.c = true;
        }
        AnonymousClass1 r0 = new go() {
            /* class com.tapjoy.FiveRocksIntegration.AnonymousClass1 */

            @Override // com.tapjoy.internal.go
            public final void a(String str) {
            }

            @Override // com.tapjoy.internal.go
            public final void d(String str) {
            }

            @Override // com.tapjoy.internal.go
            public final void b(String str) {
                TJPlacement tJPlacement;
                synchronized (FiveRocksIntegration.a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                }
                if (tJPlacement != null && tJPlacement.a != null) {
                    tJPlacement.a.onContentReady(tJPlacement);
                }
            }

            @Override // com.tapjoy.internal.go
            public final void c(String str) {
                TJPlacement tJPlacement;
                synchronized (FiveRocksIntegration.a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                }
                if (tJPlacement != null && tJPlacement.a != null) {
                    tJPlacement.a.onContentShow(tJPlacement);
                }
            }

            @Override // com.tapjoy.internal.go
            public final void a(String str, gl glVar) {
                if (glVar != null) {
                    glVar.a(e(str));
                }
            }

            @Override // com.tapjoy.internal.go
            public final void a(String str, String str2, gl glVar) {
                TJPlacement tJPlacement;
                if (glVar != null) {
                    glVar.a(e(str));
                }
                synchronized (FiveRocksIntegration.a) {
                    tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                }
                if (tJPlacement != null) {
                    TapjoyConnectCore.viewDidClose(str2);
                    if (tJPlacement.a != null) {
                        tJPlacement.a.onContentDismiss(tJPlacement);
                    }
                }
            }

            private gm e(final String str) {
                return new gm() {
                    /* class com.tapjoy.FiveRocksIntegration.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tapjoy.internal.gm
                    public final void a(final String str, String str2) {
                        TJPlacement tJPlacement;
                        synchronized (FiveRocksIntegration.a) {
                            tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.a != null) {
                            tJPlacement.a.onPurchaseRequest(tJPlacement, new TJActionRequest() {
                                /* class com.tapjoy.FiveRocksIntegration.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tapjoy.TJActionRequest
                                public final void cancelled() {
                                }

                                @Override // com.tapjoy.TJActionRequest
                                public final void completed() {
                                }

                                @Override // com.tapjoy.TJActionRequest
                                public final String getToken() {
                                    return null;
                                }

                                @Override // com.tapjoy.TJActionRequest
                                public final String getRequestId() {
                                    return str;
                                }
                            }, str2);
                        }
                    }

                    @Override // com.tapjoy.internal.gm
                    public final void a(final String str, String str2, int i, final String str3) {
                        TJPlacement tJPlacement;
                        synchronized (FiveRocksIntegration.a) {
                            tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.a != null) {
                            tJPlacement.a.onRewardRequest(tJPlacement, new TJActionRequest() {
                                /* class com.tapjoy.FiveRocksIntegration.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                @Override // com.tapjoy.TJActionRequest
                                public final void cancelled() {
                                }

                                @Override // com.tapjoy.TJActionRequest
                                public final void completed() {
                                }

                                @Override // com.tapjoy.TJActionRequest
                                public final String getRequestId() {
                                    return str;
                                }

                                @Override // com.tapjoy.TJActionRequest
                                public final String getToken() {
                                    return str3;
                                }
                            }, str2, i);
                        }
                    }
                };
            }
        };
        gz.a().p = ha.a(r0);
    }
}
