package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public final class AccountPicker {
    private AccountPicker() {
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    public static class AccountChooserOptions {
        private Account zze;
        private ArrayList<Account> zzf;
        private ArrayList<String> zzg;
        private boolean zzh;
        private String zzi;
        private Bundle zzj;
        private boolean zzk;
        private int zzl;
        private String zzm;
        private boolean zzn;
        private zza zzo;
        private String zzp;

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        public static class zza {
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        public static class Builder {
            private Account zze;
            private ArrayList<Account> zzf;
            private ArrayList<String> zzg;
            private boolean zzh = false;
            private String zzi;
            private Bundle zzj;
            private boolean zzk = false;
            private int zzl = 0;
            private boolean zzn = false;

            public Builder setSelectedAccount(Account account) {
                this.zze = account;
                return this;
            }

            public Builder setAllowableAccounts(List<Account> list) {
                this.zzf = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAllowableAccountsTypes(List<String> list) {
                this.zzg = list == null ? null : new ArrayList<>(list);
                return this;
            }

            public Builder setAlwaysShowAccountPicker(boolean z) {
                this.zzh = z;
                return this;
            }

            public Builder setTitleOverrideText(String str) {
                this.zzi = str;
                return this;
            }

            public Builder setOptionsForAddingAccount(Bundle bundle) {
                this.zzj = bundle;
                return this;
            }

            public AccountChooserOptions build() {
                Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.checkArgument(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.zzg = this.zzg;
                accountChooserOptions.zzf = this.zzf;
                accountChooserOptions.zzh = this.zzh;
                accountChooserOptions.zzo = null;
                accountChooserOptions.zzm = null;
                accountChooserOptions.zzj = this.zzj;
                accountChooserOptions.zze = this.zze;
                accountChooserOptions.zzk = false;
                accountChooserOptions.zzp = null;
                accountChooserOptions.zzl = 0;
                accountChooserOptions.zzi = this.zzi;
                accountChooserOptions.zzn = false;
                return accountChooserOptions;
            }
        }
    }

    @Deprecated
    public static Intent newChooseAccountIntent(Account account, ArrayList<Account> arrayList, String[] strArr, boolean z, String str, String str2, String[] strArr2, Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.checkArgument(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    public static Intent newChooseAccountIntent(AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        int i = 0;
        if (!accountChooserOptions.zzn) {
            Preconditions.checkArgument(accountChooserOptions.zzm == null, "We only support hostedDomain filter for account chip styled account picker");
            Preconditions.checkArgument(accountChooserOptions.zzo == null, "Consent is only valid for account chip styled account picker");
        }
        intent.setAction(accountChooserOptions.zzn ? "com.google.android.gms.common.account.CHOOSE_ACCOUNT_USERTILE" : "com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.zzf);
        if (accountChooserOptions.zzg != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.zzg.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.zzj);
        intent.putExtra("selectedAccount", accountChooserOptions.zze);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.zzh);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.zzi);
        intent.putExtra("setGmsCoreAccount", accountChooserOptions.zzk);
        intent.putExtra("realClientPackage", accountChooserOptions.zzp);
        intent.putExtra("overrideTheme", accountChooserOptions.zzl);
        if (accountChooserOptions.zzn) {
            i = 2;
        }
        intent.putExtra("overrideCustomTheme", i);
        intent.putExtra("hostedDomainFilter", accountChooserOptions.zzm);
        Bundle bundle = new Bundle();
        if (accountChooserOptions.zzn && !TextUtils.isEmpty(accountChooserOptions.zzi)) {
            bundle.putString("title", accountChooserOptions.zzi);
        }
        if (accountChooserOptions.zzo != null) {
            bundle.putBoolean("should_show_consent", true);
            bundle.putString("privacy_policy_url", null);
            bundle.putString("terms_of_service_url", null);
        }
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
