package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.Nullable;

public final class L9 {
    public static void A00(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, @Nullable Context context) {
        if (context == null || !(context instanceof Activity)) {
            onClickListener.onClick(null, 0);
        } else {
            new AlertDialog.Builder(context).setTitle(J8.A0T(context)).setMessage(J8.A0R(context)).setPositiveButton(J8.A0S(context), new L8(onClickListener)).setNegativeButton(J8.A0Q(context), new L7(onClickListener2)).show();
        }
    }
}
