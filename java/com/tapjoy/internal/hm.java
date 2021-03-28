package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.ev;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public final class hm {
    final gy a;
    final AtomicBoolean b = new AtomicBoolean();
    @Nullable
    ScheduledFuture c;
    private final Runnable d = new Runnable() {
        /* class com.tapjoy.internal.hm.AnonymousClass1 */

        public final void run() {
            if (hm.this.b.compareAndSet(true, false)) {
                gw.a("The session ended");
                gy gyVar = hm.this.a;
                long elapsedRealtime = SystemClock.elapsedRealtime() - gyVar.c;
                hc hcVar = gyVar.a;
                synchronized (hcVar) {
                    long a2 = hcVar.c.i.a() + elapsedRealtime;
                    hcVar.c.i.a(a2);
                    hcVar.b.i = Long.valueOf(a2);
                }
                ev.a a3 = gyVar.a(ey.APP, "session");
                a3.i = Long.valueOf(elapsedRealtime);
                gyVar.a(a3);
                gyVar.c = 0;
                hc hcVar2 = gyVar.a;
                long longValue = a3.e.longValue();
                synchronized (hcVar2) {
                    SharedPreferences.Editor a4 = hcVar2.c.a();
                    hcVar2.c.j.a(a4, longValue);
                    hcVar2.c.k.a(a4, elapsedRealtime);
                    a4.apply();
                    hcVar2.b.j = Long.valueOf(longValue);
                    hcVar2.b.k = Long.valueOf(elapsedRealtime);
                }
                gx gxVar = gyVar.b;
                if (gxVar.b != null) {
                    gxVar.a();
                    
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x008c: INVOKE  
                          (wrap: com.tapjoy.internal.gx$1 : 0x0089: CONSTRUCTOR  (r1v5 com.tapjoy.internal.gx$1) = (r0v8 'gxVar' com.tapjoy.internal.gx) call: com.tapjoy.internal.gx.1.<init>(com.tapjoy.internal.gx):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tapjoy.internal.gx.1.run():void in method: com.tapjoy.internal.hm.1.run():void, file: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0089: CONSTRUCTOR  (r1v5 com.tapjoy.internal.gx$1) = (r0v8 'gxVar' com.tapjoy.internal.gx) call: com.tapjoy.internal.gx.1.<init>(com.tapjoy.internal.gx):void type: CONSTRUCTOR in method: com.tapjoy.internal.hm.1.run():void, file: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 26 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tapjoy.internal.gx, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 32 more
                        */
                    /*
                    // Method dump skipped, instructions count: 161
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hm.AnonymousClass1.run():void");
                }
            };
            private final Runnable e = new Runnable() {
                /* class com.tapjoy.internal.hm.AnonymousClass2 */

                public final void run() {
                }
            };

            hm(gy gyVar) {
                this.a = gyVar;
            }

            public final void a() {
                if (!this.b.get()) {
                    return;
                }
                if (Boolean.FALSE.booleanValue()) {
                    ScheduledFuture scheduledFuture = this.c;
                    if (scheduledFuture == null || scheduledFuture.cancel(false)) {
                        this.c = hn.a.schedule(this.d, 3000, TimeUnit.MILLISECONDS);
                        return;
                    }
                    return;
                }
                this.d.run();
            }
        }
