package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.core.d.e;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.o;
import com.facebook.internal.NativeProtocol;

public class TTDelegateActivity extends Activity {
    private Intent a;
    private AlertDialog b;
    private a c;

    public static void a() {
        Intent intent = new Intent(j.a(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 5);
        if (j.a() != null) {
            j.a().startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        this.a = getIntent();
        if (j.a() == null) {
            j.a(this);
        }
    }

    private void b() {
        if (g.b().m()) {
            getWindow().addFlags(2621440);
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (j.a() == null) {
            j.a(this);
        }
        setIntent(intent);
        this.a = intent;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.b != null && this.b.isShowing()) {
                this.b.dismiss();
            }
            if (this.c != null && this.c.isShowing()) {
                this.c.dismiss();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }

    private void c() {
        int intExtra = this.a.getIntExtra("type", 0);
        String stringExtra = this.a.getStringExtra("app_download_url");
        this.a.getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
        if (intExtra == 1) {
            return;
        }
        if (intExtra == 2) {
            e();
        } else if (intExtra == 3) {
            a(stringExtra, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_content_key"));
        } else if (intExtra == 4) {
            a(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
        } else if (intExtra != 5) {
            finish();
        } else {
            d();
        }
    }

    private void d() {
        a aVar = new a(this);
        this.c = aVar;
        aVar.a(o.a(this, "no_thank_you"), new a.b() {
            /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.a.b
            public void a() {
                g.b().b(0);
                if (TTDelegateActivity.this.c.isShowing()) {
                    TTDelegateActivity.this.c.dismiss();
                }
                TTDelegateActivity.this.finish();
            }
        }).a(o.a(this, "yes_i_agree"), new a.c() {
            /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.core.widget.a.c
            public void a() {
                g.b().b(1);
                if (TTDelegateActivity.this.c.isShowing()) {
                    TTDelegateActivity.this.c.dismiss();
                }
                TTDelegateActivity.this.finish();
            }
        });
        this.c.show();
    }

    private void a(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            finish();
        } else if (Build.VERSION.SDK_INT >= 23) {
            try {
                d.a().a(this, strArr, new e() {
                    /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass3 */

                    @Override // com.bytedance.sdk.openadsdk.core.d.e
                    public void a() {
                        com.bytedance.sdk.openadsdk.g.e.a(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.d.e
                    public void a(String str) {
                        com.bytedance.sdk.openadsdk.g.e.a(str, str);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            l.b(TTAdConstant.TAG, "已经有权限");
            finish();
        }
    }

    private void a(final String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            str2 = o.a(this, "tt_tip");
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        a(str2, str3, new DialogInterface.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                com.bytedance.sdk.openadsdk.g.d.a(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                com.bytedance.sdk.openadsdk.g.d.b(str);
                TTDelegateActivity.this.finish();
            }
        }, new DialogInterface.OnCancelListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass6 */

            public void onCancel(DialogInterface dialogInterface) {
                com.bytedance.sdk.openadsdk.g.d.c(str);
                TTDelegateActivity.this.finish();
            }
        });
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                d.a().a(this, new String[0], new e() {
                    /* class com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.AnonymousClass7 */

                    @Override // com.bytedance.sdk.openadsdk.core.d.e
                    public void a() {
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.d.e
                    public void a(String str) {
                        "android.permission.READ_PHONE_STATE".equals(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            } catch (Exception unused) {
                finish();
            }
        } else {
            l.b(TTAdConstant.TAG, "已经有Read phone state权限");
            finish();
        }
    }

    private void a(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        String str3;
        try {
            if (this.b == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    str3 = "Theme.Dialog.TTDownload";
                } else {
                    str3 = "Theme.Dialog.TTDownloadOld";
                }
                this.b = new AlertDialog.Builder(this, o.g(this, str3)).create();
            }
            this.b.setTitle(String.valueOf(str));
            this.b.setMessage(String.valueOf(str2));
            this.b.setButton(-1, o.a(this, "tt_label_ok"), onClickListener);
            this.b.setButton(-2, o.a(this, "tt_label_cancel"), onClickListener2);
            this.b.setOnCancelListener(onCancelListener);
            if (!this.b.isShowing()) {
                this.b.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        d.a().a(this, strArr, iArr);
        finish();
    }
}
