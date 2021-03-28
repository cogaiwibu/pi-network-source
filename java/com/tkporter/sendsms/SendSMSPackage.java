package com.tkporter.sendsms;

import android.content.Intent;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SendSMSPackage implements ReactPackage {
    private static SendSMSPackage instance;
    private SendSMSModule sendSms = null;

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        this.sendSms = new SendSMSModule(reactApplicationContext);
        if (instance == null) {
            instance = this;
        }
        return Arrays.asList(this.sendSms);
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public static SendSMSPackage getInstance() {
        if (instance == null) {
            instance = new SendSMSPackage();
        }
        return instance;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        SendSMSModule sendSMSModule = this.sendSms;
        if (sendSMSModule != null) {
            sendSMSModule.onActivityResult(null, i, i2, intent);
        }
    }
}
